package lk.ijse.notecollectorusingspringboot.config;

import ch.qos.logback.core.util.StringUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;
import org.thymeleaf.util.StringUtils;

import java.io.IOException;
@Configuration
public class JWTConfigFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String initToken = request.getHeader("Authorization");
        String userEmail;
        String extractedJwtToken;

        //validate the token
        if (StringUtils.isEmpty(initToken) || initToken.startsWith("Bearer")){
            //meka dapu gaman ilaga filter ekata pass karanwa
            filterChain.doFilter(request,response);
        }

        extractedJwtToken = initToken.substring(7);
    }
}
