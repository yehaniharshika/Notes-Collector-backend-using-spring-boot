package lk.ijse.notecollectorusingspringboot.service;

import lk.ijse.notecollectorusingspringboot.dto.UserStatus;
import lk.ijse.notecollectorusingspringboot.dto.impl.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    //UserDTO saveUser(UserDTO userDTO);
    void saveUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserStatus getUser(String userId);
    void updateUser(String userId,UserDTO userDTO);
    void deleteUser(String userId);

    //authorization part ekata meka heduwe
    UserDetailsService  userDetailService();
}
