package com.ludynia.pizza.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;
import java.util.logging.Level;

@Entity
@NoArgsConstructor(access =AccessLevel.PRIVATE,force = true)
@RequiredArgsConstructor
@Data
public class User implements UserDetails {

    private static final long serialUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;
    final private String username;
    final private String password;
    final private String fullName;
    final private String city;
    final private String street;
    final private String state;
    final private String zipCode;
    final private String telephoneNumber;




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
