package com.company.orderservice.service;

import com.company.orderservice.dto.OrdersDto;
import com.company.orderservice.dto.ResponseDto;
import com.company.orderservice.dto.SimpleCRUD;
import com.company.orderservice.modul.Orders;
import com.company.orderservice.repository.OrdersRepository;
import com.company.orderservice.service.mapper.OrdersMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrdersService implements SimpleCRUD<Integer, OrdersDto> {

    private final OrdersMapper ordersMapper;
    private final OrdersRepository ordersRepository;

    @Override
    public ResponseDto<OrdersDto> create(OrdersDto dto) {
        try {
            Orders orders = this.ordersMapper.toEntity(dto);
            this.ordersRepository.save(orders);
            return ResponseDto.<OrdersDto>builder()
                    .success(true)
                    .message("OK")
//                    .data(this.ordersMapper.toDto(orders))
                    .build();

        }catch (Exception e){
            return ResponseDto.<OrdersDto>builder()
                    .message("Order while creating error!")
                    .code(-2)
                    .build();
        }
    }

    @Override
    public ResponseDto<OrdersDto> get(Integer entityId) {
//        return this.ordersRepository.findByOrderIdAndDeletedAtIsNull(entityId).
    return null;
    }

    @Override
    public ResponseDto<OrdersDto> update(Integer entityId, OrdersDto dto) {
        return null;
    }

    @Override
    public ResponseDto<OrdersDto> delete(Integer entityId) {
        return null;
    }
}
