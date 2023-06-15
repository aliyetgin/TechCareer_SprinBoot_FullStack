package com.aliyetgin.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

// @Component: Marks the class as a Spring component
@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // Retrieve user information of the logged-in user from the database
        // You should obtain the username of the user in the system using Session
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            System.out.println(authentication.getName());
            System.out.println(authentication.getPrincipal());
            return Optional.of(authentication.getName());
        }
        // If there is a user in the system, return their name; otherwise, return null
        // return Optional.ofNullable(authentication != null ? authentication.getName() : null);
        return Optional.of("AliYet.");
    }
}