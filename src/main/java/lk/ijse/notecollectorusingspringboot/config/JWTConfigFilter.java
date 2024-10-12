package lk.ijse.notecollectorusingspringboot.config;

import ch.qos.logback.core.util.StringUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.notecollectorusingspringboot.service.JWTService;
import lk.ijse.notecollectorusingspringboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import org.thymeleaf.util.StringUtils;

import java.io.IOException;
@Configuration
@RequiredArgsConstructor
public class JWTConfigFilter extends OncePerRequestFilter {
    private final JWTService jwtService;
    private final UserService userService;
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
        userEmail = jwtService.extractUserName(extractedJwtToken);
        //user email
        if(!StringUtils.isEmpty(userEmail) &&
                SecurityContextHolder.getContext().getAuthentication() == null) {
            var userDetails =
                    userService.userDetailService().loadUserByUsername(userEmail);
            if (jwtService.validateToken(extractedJwtToken, userDetails)) {
                //add user to the security context
                SecurityContext emptyContext =
                        SecurityContextHolder.createEmptyContext();
                var authToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                emptyContext.setAuthentication(authToken);
                SecurityContextHolder.setContext(emptyContext);
            }
        }
        filterChain.doFilter(request,response);
    }
}
