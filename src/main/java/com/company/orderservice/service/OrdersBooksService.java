package com.company.orderservice.service;

import com.company.orderservice.dto.*;
import com.company.orderservice.modul.OrdersBooks;
import com.company.orderservice.repository.OrdersBooksRepository;
import com.company.orderservice.service.mapper.OrdersBooksMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class OrdersBooksService implements SimpleCRUD<Integer, OrdersBooksDto> {

    private final OrdersBooksRepository ordersBooksRepository;
    private final OrdersBooksMapper ordersBooksMapper;

    @Override
    public ResponseDto<OrdersBooksDto> create(@Valid OrdersBooksDto dto) {
        try {
            OrdersBooks ordersBooks = this.ordersBooksMapper.toEntity(dto);
            this.ordersBooksRepository.save(ordersBooks);
            return ResponseDto.<OrdersBooksDto>builder()
                    .success(true)
                    .message("OK")
                    .data(this.ordersBooksMapper.toDto(ordersBooks))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<OrdersBooksDto>builder()
                    .message(String.format("Orders Books while saving error %s", e.getMessage()))
                    .code(-2)
                    .build();
        }
    }

    @Override
    public ResponseDto<OrdersBooksDto> get(@Valid Integer entityId) {
        return this.ordersBooksRepository.findByOrderBookId(entityId)
                .map(ordersBooks -> ResponseDto.<OrdersBooksDto>builder()
                        .success(true)
                        .message("OK")
                        .data(this.ordersBooksMapper.toDto(ordersBooks))
                        .build())
                .orElse(ResponseDto.<OrdersBooksDto>builder()
                        .message("Orders Books is not found")
                        .code(-1)
                        .build());
    }

    @Override
    public ResponseDto<OrdersBooksDto> update(@Valid Integer entityId, OrdersBooksDto dto) {
        try {
            return this.ordersBooksRepository.findByOrderBookId(entityId)
                    .map(ordersBooks -> {
                        this.ordersBooksMapper.updateOrdersBooksFromDto(dto, ordersBooks);
                        this.ordersBooksRepository.save(ordersBooks);
                        return ResponseDto.<OrdersBooksDto>builder()
                                .success(true)
                                .message("OK")
                                .data(this.ordersBooksMapper.toDto(ordersBooks))
                                .build();
                    }).orElse(ResponseDto.<OrdersBooksDto>builder()
                            .message("Orders Book is not found")
                            .code(-1)
                            .build());

        } catch (Exception e) {
            return ResponseDto.<OrdersBooksDto>builder()
                    .message(String.format("Orders Books while updating error %s", e.getMessage()))
                    .code(-2)
                    .build();
        }

    }

    @Override
    public ResponseDto<OrdersBooksDto> delete(@Valid Integer entityId) {
        return this.ordersBooksRepository.findByOrderBookId(entityId)
                .map(ordersBooks -> {
                    this.ordersBooksRepository.delete(ordersBooks);
                    return ResponseDto.<OrdersBooksDto>builder()
                            .success(true)
                            .message("OK")
                            .data(this.ordersBooksMapper.toDto(ordersBooks))
                            .build();
                }).orElse(ResponseDto.<OrdersBooksDto>builder()
                        .code(-1)
                        .message("Orders Books is not found")
                        .build());
    }
}
