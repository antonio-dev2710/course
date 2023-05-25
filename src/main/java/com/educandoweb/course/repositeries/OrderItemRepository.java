package com.educandoweb.course.repositeries;



import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
