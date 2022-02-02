package com.example.bankapp.repo;

import com.example.bankapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    public User findByEmail(String email);

    public User findByEmailAndPassword(String email, String password);
}
