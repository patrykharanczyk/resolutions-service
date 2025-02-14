package com.patrykharanczyk.resolutions.repository;

import com.patrykharanczyk.resolutions.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
