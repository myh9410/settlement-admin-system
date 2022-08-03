package system.admin.settlement.config.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class UserSecurityFilter extends OncePerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(UserSecurityFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            log.info("authorize check");
        } catch (Exception e) {
            log.error("Invalid Token :: error - {}", e.getMessage());
        } finally {
            filterChain.doFilter(request, response);
        }
    }

}
