package com.example.studentmanagementbackend.Service.AuthService;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.studentmanagementbackend.Model.Role.RoleName;
import com.example.studentmanagementbackend.Model.User;

public class UserDetailsImpl implements UserDetails {
    private final UUID id;
    private final String username;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(UUID id, String username, String password,
            Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(User user) {
        
        List<GrantedAuthority> auths = List.of(
            new SimpleGrantedAuthority("ROLE_" + user.getRole().getName().name())
        );
        return new UserDetailsImpl(
            user.getUserId(),
            user.getUsername(),
            user.getPasswordHash(),
            auths
        );
    }

    public UUID getId() {
        return id;
    }

    public RoleName getRole() {
        // you can also expose the raw enum if needed
        String roleName = authorities.iterator().next().getAuthority().replace("ROLE_", "");
        return RoleName.valueOf(roleName);
    }

    @Override public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    @Override public String getPassword() { return password; }
    @Override public String getUsername() { return username; }
    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }
}