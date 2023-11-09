package com.company.orderservice.service;

import com.company.orderservice.dto.OrdersDto;
import com.company.orderservice.dto.ResponseDto;
import com.company.orderservice.dto.SimpleCRUD;
import com.company.orderservice.dto.request.OrdersRequestDto;
import com.company.orderservice.dto.response.OrdersBooksResponseDto;
import com.company.orderservice.dto.response.OrdersResponseDto;
import com.company.orderservice.modul.Orders;
import com.company.orderservice.repository.OrdersRepository;
import com.company.orderservice.service.mapper.OrdersMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrdersService {

    private final OrdersMapper ordersMapper;
    private final OrdersRepository ordersRepository;


    public ResponseDto<OrdersResponseDto> create(OrdersRequestDto dto) {
        try {
            Orders orders = this.ordersMapper.toEntity(dto);
            this.ordersRepository.save(orders);
            return ResponseDto.<OrdersResponseDto>builder()
                    .success(true)
                    .message("OK")
                    .data(this.ordersMapper.toDto(orders))
                    .build();

        }catch (Exception e){
            return ResponseDto.<OrdersResponseDto>builder()
                    .message("Order while creating error!")
                    .code(-2)
                    .build();
        }
    }


    public ResponseDto<OrdersResponseDto> get(Integer entityId) {
        return this.ordersRepository.findByOrderIdAndDeletedAtIsNull(entityId)
                .map(order -> ResponseDto.<OrdersResponseDto>builder()
                        .success(true)
                        .message("OK")
                        .data(this.ordersMapper.toDto(order))
                        .build())
                .orElse(ResponseDto.<OrdersResponseDto>builder()
                        .message("Orders is not found")
                        .code(-1)
                        .build());
    }

    public ResponseDto<OrdersResponseDto> update(Integer entityId, OrdersRequestDto dto) {
        try {
            return this.ordersRepository.findByOrderIdAndDeletedAtIsNull(entityId)
                    .map(orders -> {
                        this.ordersMapper.updateOrderWithDto(dto, orders);
                        this.ordersRepository.save(orders);
                        return ResponseDto.<OrdersResponseDto>builder()
                                .success(true)
                                .message("OK")
                                .data(this.ordersMapper.toDto(orders))
                                .build();
                    }).orElse(ResponseDto.<OrdersResponseDto>builder()
                            .message("Orders is not found")
                            .code(-1)
                            .build());

        } catch (Exception e) {
            return ResponseDto.<OrdersResponseDto>builder()
                    .message(String.format("Orders while updating error %s", e.getMessage()))
                    .code(-2)
                    .build();
        }
    }

    public ResponseDto<OrdersResponseDto> delete(Integer entityId) {
        return this.ordersRepository.findByOrderIdAndDeletedAtIsNull(entityId)
                .map(orders -> {
                    this.ordersRepository.delete(orders);
                    return ResponseDto.<OrdersResponseDto>builder()
                            .success(true)
                            .message("OK")
                            .data(this.ordersMapper.toDto(orders))
                            .build();
                }).orElse(ResponseDto.<OrdersResponseDto>builder()
                        .code(-1)
                        .message("Orders is not found")
                        .build());
    }
}
