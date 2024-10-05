package lk.ijse.notecollectorusingspringboot.dao;

import lk.ijse.notecollectorusingspringboot.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<UserEntity,String> {
    /*UserEntity saveUser(UserDTO userDTO);*/

}
