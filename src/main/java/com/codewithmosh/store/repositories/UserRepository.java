package com.codewithmosh.store.repositories;

import com.codewithmosh.store.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

// using entity 
// public interface UserRepository extends CrudRepository<User, Long> {
// }
// using dto
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}