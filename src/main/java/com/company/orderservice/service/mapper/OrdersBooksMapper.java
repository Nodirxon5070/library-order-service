package com.company.orderservice.service.mapper;

import com.company.orderservice.dto.request.OrdersBooksRequestDto;
import com.company.orderservice.dto.response.OrdersBooksResponseDto;
import com.company.orderservice.modul.OrdersBooks;
import org.mapstruct.*;

import java.util.stream.Collectors;


@Mapper(componentModel = "spring", imports = Collectors.class)
public abstract class OrdersBooksMapper {

    public abstract OrdersBooksResponseDto toDto(OrdersBooks ordersBooks);

    public abstract OrdersBooks toEntity(OrdersBooksRequestDto ordersBooksDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,resultType = OrdersBooks.class)
    public abstract OrdersBooks updateOrdersBooksFromDto(OrdersBooksRequestDto dto, @MappingTarget OrdersBooks ordersBooks);


}