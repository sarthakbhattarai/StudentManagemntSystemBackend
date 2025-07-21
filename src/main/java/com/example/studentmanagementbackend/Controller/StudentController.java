package com.example.studentmanagementbackend.Controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

import com.example.studentmanagementbackend.DTO.Student.RegisterStudentRequest;
import com.example.studentmanagementbackend.DTO.Student.StudentResponse;
import com.example.studentmanagementbackend.Model.Program;
import com.example.studentmanagementbackend.Model.Role;
import com.example.studentmanagementbackend.Model.Student;
import com.example.studentmanagementbackend.Model.User;
import com.example.studentmanagementbackend.Service.ProgramService;
import com.example.studentmanagementbackend.Service.RoleService;
import com.example.studentmanagementbackend.Service.StudentService;
import com.example.studentmanagementbackend.Service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    private final UserService userService;
    private final ProgramService programService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register/student")
    public ResponseEntity<StudentResponse> registerStudent(@RequestBody RegisterStudentRequest req) {
        if (userService.existsByUsername(req.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already taken");
        }

        if (userService.existsByEmail(req.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already registered");
        }

        Role studentRole = roleService.findByName(Role.RoleName.STUDENT)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student role not found"));

        Program program = programService.getEntityById(req.getProgramId());
        if (program == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Program not found");
        }

        // Create user
        User user = new User();
        user.setUsername(req.getUsername());
        user.setEmail(req.getEmail());
        user.setPasswordHash(passwordEncoder.encode(req.getPassword()));
        user.setRole(studentRole);
        user.setCreatedAt(java.time.LocalDateTime.now());
        user.setUpdatedAt(java.time.LocalDateTime.now());

        User savedUser = userService.create(user);

        // Create student
        Student student = new Student();
        student.setUser(savedUser);
        student.setProgram(program);
        student.setEnrollmentYear(req.getEnrollmentYear());
        student.setStatus(req.getStatus());

        Student savedStudent = studentService.create(student);

        // Prepare response
        StudentResponse response = new StudentResponse();
        response.setStudentId(savedStudent.getStudentId());
        response.setUsername(savedUser.getUsername());
        response.setEmail(savedUser.getEmail());
        response.setEnrollmentYear(savedStudent.getEnrollmentYear());
        response.setProgramName(program.getName());
        response.setStatus(savedStudent.getStatus());

        return ResponseEntity.created(URI.create("/api/students/" + savedStudent.getStudentId()))
                .body(response);
    }

    @GetMapping("/students")
    public List<StudentResponse> getAllStudents() {
        return studentService.getAll().stream().map(student -> {
            StudentResponse res = new StudentResponse();
            res.setStudentId(student.getStudentId());
            res.setUsername(student.getUser().getUsername());
            res.setEmail(student.getUser().getEmail());
            res.setEnrollmentYear(student.getEnrollmentYear());
            res.setProgramName(student.getProgram().getName());
            res.setStatus(student.getStatus());
            return res;
        }).collect(Collectors.toList());
    }


    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.create(student));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(studentService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.ok(studentService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable UUID id, @RequestBody Student student) {
        return ResponseEntity.ok(studentService.update(id, student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        studentService.delete(id);
        return ResponseEntity.ok().build();
    }
}
