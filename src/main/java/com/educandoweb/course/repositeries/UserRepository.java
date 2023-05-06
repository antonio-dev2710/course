package com.educandoweb.course.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educandoweb.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
