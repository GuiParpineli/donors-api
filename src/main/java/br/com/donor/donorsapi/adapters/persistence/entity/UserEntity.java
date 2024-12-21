package br.com.donor.donorsapi.adapters.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "user_app")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserEntity implements UserDetails {
    @Serial
    private static final long serialVersionUID = 0L;
    @Id
    private Long id;
    private String username;
    private String password;
    private String email;
    private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(this.role);
        return Collections.singleton(grantedAuthority);
    }
}
