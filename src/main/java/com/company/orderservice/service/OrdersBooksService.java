package com.company.orderservice.service;

import com.company.orderservice.dto.*;
import com.company.orderservice.dto.request.OrdersBooksRequestDto;
import com.company.orderservice.dto.request.OrdersRequestDto;
import com.company.orderservice.dto.response.OrdersBooksResponseDto;
import com.company.orderservice.modul.OrdersBooks;
import com.company.orderservice.repository.OrdersBooksRepository;
import com.company.orderservice.service.mapper.OrdersBooksMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class OrdersBooksService {

    private final OrdersBooksRepository ordersBooksRepository;
    private final OrdersBooksMapper ordersBooksMapper;

    public ResponseDto<OrdersBooksResponseDto> create(@Valid OrdersBooksRequestDto dto) {
        try {
            OrdersBooks ordersBooks = this.ordersBooksMapper.toEntity(dto);
            this.ordersBooksRepository.save(ordersBooks);
            return ResponseDto.<OrdersBooksResponseDto>builder()
                    .success(true)
                    .message("OK")
                    .data(this.ordersBooksMapper.toDto(ordersBooks))
                    .build();
        } catch (Exception e) {
            return ResponseDto.<OrdersBooksResponseDto>builder()
                    .message(String.format("Orders Books while saving error %s", e.getMessage()))
                    .code(-2)
                    .build();
        }
    }

    public ResponseDto<OrdersBooksResponseDto> get(@Valid Integer entityId) {
        return this.ordersBooksRepository.findByOrderBookId(entityId)
                .map(ordersBooks -> ResponseDto.<OrdersBooksResponseDto>builder()
                        .success(true)
                        .message("OK")
                        .data(this.ordersBooksMapper.toDto(ordersBooks))
                        .build())
                .orElse(ResponseDto.<OrdersBooksResponseDto>builder()
                        .message("Orders Books is not found")
                        .code(-1)
                        .build());
    }

    public ResponseDto<OrdersBooksResponseDto> update(@Valid Integer entityId, OrdersBooksRequestDto dto) {
        try {
            return this.ordersBooksRepository.findByOrderBookId(entityId)
                    .map(ordersBooks -> {
                        this.ordersBooksMapper.updateOrdersBooksFromDto(dto, ordersBooks);
                        this.ordersBooksRepository.save(ordersBooks);
                        return ResponseDto.<OrdersBooksResponseDto>builder()
                                .success(true)
                                .message("OK")
                                .data(this.ordersBooksMapper.toDto(ordersBooks))
                                .build();
                    }).orElse(ResponseDto.<OrdersBooksResponseDto>builder()
                            .message("Orders Book is not found")
                            .code(-1)
                            .build());

        } catch (Exception e) {
            return ResponseDto.<OrdersBooksResponseDto>builder()
                    .message(String.format("Orders Books while updating error %s", e.getMessage()))
                    .code(-2)
                    .build();
        }

    }

    public ResponseDto<OrdersBooksResponseDto> delete(@Valid Integer entityId) {
        return this.ordersBooksRepository.findByOrderBookId(entityId)
                .map(ordersBooks -> {
                    this.ordersBooksRepository.delete(ordersBooks);
                    return ResponseDto.<OrdersBooksResponseDto>builder()
                            .success(true)
                            .message("OK")
                            .data(this.ordersBooksMapper.toDto(ordersBooks))
                            .build();
                }).orElse(ResponseDto.<OrdersBooksResponseDto>builder()
                        .code(-1)
                        .message("Orders Books is not found")
                        .build());
    }
}
