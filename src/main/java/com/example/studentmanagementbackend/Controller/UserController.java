package com.example.studentmanagementbackend.Controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.studentmanagementbackend.DTO.Auth.LoginRequest;
import com.example.studentmanagementbackend.DTO.Auth.LoginResponse;
import com.example.studentmanagementbackend.DTO.Auth.RegisterRequest;
import com.example.studentmanagementbackend.Model.User;
import com.example.studentmanagementbackend.Security.JwtTokenProvider;
import com.example.studentmanagementbackend.Service.RoleService;
import com.example.studentmanagementbackend.Service.UserService;
import com.example.studentmanagementbackend.Service.AuthService.UserDetailsImpl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final RoleService roleService;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.ok(userService.create(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable UUID id, @RequestBody User user) {
        return ResponseEntity.ok(userService.update(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody RegisterRequest req) {
        System.out.println("Enter the regioster method");
        if (userService.existsByUsername(req.getUsername())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Username '" + req.getUsername() + "' is already taken");
        }
        System.out.println("no error1");
        if (userService.existsByEmail(req.getEmail())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Email '" + req.getEmail() + "' is already registered");
        }
        System.out.println("noerro 2");

        var roleOpt = roleService.findByName(req.getRole());
        if (roleOpt.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Role '" + req.getRole() + "' does not exist");
        }
        System.out.println("no error3");

        var user = new User();
        System.out.println("no error4");
        user.setUsername(req.getUsername());
        System.out.println("no error5");
        user.setEmail(req.getEmail());
        System.out.println("no error6");
        user.setPasswordHash(passwordEncoder.encode(req.getPassword()));
        System.out.println("no error7");
        user.setRole(roleOpt.get());
        System.out.println("no error8");
        LocalDateTime now = LocalDateTime.now();
        user.setCreatedAt(now);
        user.setUpdatedAt(now);

        var created = userService.create(user);
        System.out.println("no error9");
        return ResponseEntity
                .created(URI.create("/api/users/" + created.getUserId()))
                .body(created);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest req) {

        User user = userService
                .findByUsername(req.getUsername())
                .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.UNAUTHORIZED, "Invalid username or password"));

        if (!passwordEncoder.matches(req.getPassword(), user.getPasswordHash())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username or password");
        }

        UserDetailsImpl userDetails = UserDetailsImpl.build(user);

        String token = jwtTokenProvider.generateToken(userDetails);

        String roleName = user.getRole().getName().name();
        LoginResponse resp = new LoginResponse(token, roleName);
        return ResponseEntity.ok(resp);
    }

}
