package com.company.orderservice.service.mapper;

import com.company.orderservice.dto.request.OrdersRequestDto;
import com.company.orderservice.dto.response.OrdersResponseDto;
import com.company.orderservice.modul.Orders;
import org.mapstruct.*;



@Mapper(componentModel = "spring")
public abstract class OrdersMapper {


    public abstract OrdersResponseDto toDto(Orders orders);


    public abstract Orders toEntity(OrdersRequestDto dto);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,resultType = Orders.class)
    public abstract Orders  updateOrderWithDto(OrdersRequestDto dto,@MappingTarget Orders orders);


}








