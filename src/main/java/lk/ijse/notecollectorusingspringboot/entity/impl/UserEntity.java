package lk.ijse.notecollectorusingspringboot.entity.impl;

import jakarta.persistence.*;
import lk.ijse.notecollectorusingspringboot.entity.Role;
import lk.ijse.notecollectorusingspringboot.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.management.relation.RoleInfo;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user")
public class UserEntity implements UserDetails, SuperEntity {
    @Id
    private String userId;
    private String firstName;
    private String lastName;
    //unique value ekk daddi mehema danna oni
    @Column(unique = true)
    private String email;
    private String password;

    @Column(columnDefinition = "LONGTEXT")
    private String profilePic;

    @OneToMany(mappedBy = "user")
    private List<NoteEntity> notes;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        /*return List.of();*/
        Set<GrantedAuthority>  authorities= new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+role.name()));
        return authorities;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    //NoteDTO eka NoteEntity karanawa methnadi
}
