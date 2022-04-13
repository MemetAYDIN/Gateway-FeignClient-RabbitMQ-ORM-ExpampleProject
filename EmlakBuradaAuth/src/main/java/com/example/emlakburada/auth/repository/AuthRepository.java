package com.example.emlakburada.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.emlakburada.auth.model.User;

public interface AuthRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);

}
