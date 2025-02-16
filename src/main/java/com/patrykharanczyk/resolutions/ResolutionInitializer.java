package com.patrykharanczyk.resolutions;

import com.patrykharanczyk.resolutions.model.Resolution;
import com.patrykharanczyk.resolutions.model.User;
import com.patrykharanczyk.resolutions.repository.ResolutionRepository;
import com.patrykharanczyk.resolutions.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ResolutionInitializer implements SmartInitializingSingleton {
    private final ResolutionRepository resolutions;
    private final UserRepository users;
    private final PasswordEncoder passwordEncoder;

    public ResolutionInitializer(ResolutionRepository resolutions, UserRepository users, PasswordEncoder passwordEncoder) {
        this.resolutions = resolutions;
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void afterSingletonsInstantiated() {
        System.out.println("Initializing resolutions");
        User tester1 = new User("tester 1", this.passwordEncoder.encode("pass1"));
        User tester2 = new User("tester 2", this.passwordEncoder.encode("pass2"));

        tester1.addAuthority("READ");
        tester2.addAuthority("READ");
        tester2.addAuthority("WRITE");

        this.users.save(tester1);
        this.users.save(tester2);

        this.resolutions.save(new Resolution(tester1, "R1", "R1 decs", false));
        this.resolutions.save(new Resolution(tester1, "R2", "R2 decs", true));
        this.resolutions.save(new Resolution(tester2, "R3", "R3 decs", false));

        System.out.println("Resolutions initialized");
    }
}
