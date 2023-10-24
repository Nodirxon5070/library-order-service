package com.company.orderservice.controller;

import com.company.orderservice.dto.OrdersDto;
import com.company.orderservice.dto.ResponseDto;
import com.company.orderservice.dto.SimpleCRUD;
import com.company.orderservice.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "orders")
@RequiredArgsConstructor
public class OrdersController implements SimpleCRUD<Integer, OrdersDto> {

    private final OrdersService ordersService;

    @Override
    @PostMapping(value = "/create")
    public ResponseDto<OrdersDto> create(@RequestBody OrdersDto dto) {
        return this.ordersService.create(dto);
    }

    @Override
    @GetMapping(value = "/get")
    public ResponseDto<OrdersDto> get(@RequestParam(value = "id") Integer entityId) {
        return this.ordersService.get(entityId);
    }

    @Override
    @PutMapping(value = "/update/{id}")
    public ResponseDto<OrdersDto> update(@PathVariable(value = "id") Integer entityId,
                                         @RequestBody OrdersDto dto) {
        return this.ordersService.update(entityId, dto);
    }

    @Override
    @DeleteMapping(value = "/delete/{id}")
    public ResponseDto<OrdersDto> delete(@PathVariable(value = "id") Integer entityId) {
        return this.ordersService.delete(entityId);
    }
}
