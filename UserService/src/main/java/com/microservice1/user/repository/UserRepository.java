package com.microservice1.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice1.user.model.User;

public interface UserRepository extends JpaRepository<User, String> {

}
