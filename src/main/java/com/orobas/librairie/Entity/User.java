package com.orobas.librairie.Entity;

import com.orobas.librairie.Config.User.Roles;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User implements UserDetails {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "mail", nullable = false)
    private String mail;

    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @Column(name = "role", nullable = false)
    private Roles role;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "token")
    private String token;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return mail;
    }

    // Permet de savoir si l'utilisateur n'a pas expiré
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // Permet de savoir si le compte de l'utilisateur n'a pas été bloqué
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // Permet de savoir si l'utilisateur doit renouveller son mot de passe
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // Permet de savoir si l'utilisateur est autorisé à s'authentifier (confirmation du compte)
    @Override
    public boolean isEnabled() {
        return true;
    }

}