package com.company.orderservice.repository;

import com.company.orderservice.modul.OrdersBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdersBooksRepository extends JpaRepository<OrdersBooks,Integer> {
    Optional<OrdersBooks> findByOrderBookId(Integer id);

    List<OrdersBooks> findAll();
}
