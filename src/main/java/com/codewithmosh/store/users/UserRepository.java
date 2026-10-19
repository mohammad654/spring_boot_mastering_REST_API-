package com.codewithmosh.store.users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

// using entity 
// public interface UserRepository extends CrudRepository<User, Long> {
// }
// using dto
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
}