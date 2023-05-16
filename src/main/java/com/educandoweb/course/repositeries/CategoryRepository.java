package com.educandoweb.course.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.User;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
