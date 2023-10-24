package com.company.orderservice.repository;

import com.company.orderservice.modul.Orders;
import com.google.common.base.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer> {
     Optional<Orders> findByOrderIdAndDeletedAtIsNull(Integer Id);


}
