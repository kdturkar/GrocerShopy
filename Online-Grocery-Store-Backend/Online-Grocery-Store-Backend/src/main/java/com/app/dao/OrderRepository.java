package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

	@Query("Select o from Order o where o.customer.id=:id order by o.statusUpdateDate desc")
	List<Order> findAllOrdersByUserId(@Param("id") Integer userId);

	

}
