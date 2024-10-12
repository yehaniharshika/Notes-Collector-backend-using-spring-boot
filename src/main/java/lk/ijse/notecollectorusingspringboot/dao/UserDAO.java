package lk.ijse.notecollectorusingspringboot.dao;

import lk.ijse.notecollectorusingspringboot.entity.impl.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<UserEntity,String> {
    /*UserEntity saveUser(UserDTO userDTO);*/
    Optional<UserEntity> findByEmail(String email);


}
