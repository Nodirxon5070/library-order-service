package com.company.orderservice.service.mapper;

import com.company.orderservice.dto.OrdersBooksDto;
import com.company.orderservice.modul.OrdersBooks;
import org.mapstruct.*;

import java.util.stream.Collectors;


@Mapper(componentModel = "spring", imports = Collectors.class)
public abstract class OrdersBooksMapper {

    public abstract OrdersBooksDto toDto(OrdersBooks ordersBooks);

    public abstract OrdersBooks toEntity(OrdersBooksDto ordersBooksDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updateOrdersBooksFromDto(OrdersBooksDto dto, @MappingTarget OrdersBooks ordersBooks);


}