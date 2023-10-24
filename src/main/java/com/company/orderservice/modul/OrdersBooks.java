package com.company.orderservice.modul;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "order_books")
public class OrdersBooks {
    @Id
    @Column(name = "order_book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderBookId;

    @OneToMany(mappedBy = "orderId", fetch = FetchType.EAGER)
    private Set<Orders> orders;

}
