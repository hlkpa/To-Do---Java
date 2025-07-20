package com.project.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.models.UserApp;

@Repository
public interface UserRepository extends JpaRepository<UserApp, Long> {

	UserApp findByUsername(String username);

}