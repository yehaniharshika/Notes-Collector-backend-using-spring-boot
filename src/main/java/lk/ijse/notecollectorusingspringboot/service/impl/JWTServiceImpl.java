package lk.ijse.notecollectorusingspringboot.service.impl;

import lk.ijse.notecollectorusingspringboot.service.JWTService;
import org.springframework.security.core.userdetails.UserDetails;

/*tasks:
    01.Generate Token
    02.Token eken username eka exctract kirima
    03.validate the Token*/
public class JWTServiceImpl implements JWTService {

    @Override
    public String extractUserName(String token) {
        return null;
    }

    @Override
    public String generateToken(UserDetails user) {
        return null;
    }

    @Override
    public boolean validateToken(String token, UserDetails userDetails) {
        return false;
    }

    @Override
    public String refreshToken(String prevToken) {
        return null;
    }
}
