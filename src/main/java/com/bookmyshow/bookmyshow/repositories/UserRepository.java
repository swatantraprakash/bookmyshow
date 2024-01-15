package com.bookmyshow.bookmyshow.repositories;

import com.bookmyshow.bookmyshow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Override
    Optional<User> findById(Long aLong);
    @Override
    User save(User user);
    Optional<User> findByEmail(String email);
}
