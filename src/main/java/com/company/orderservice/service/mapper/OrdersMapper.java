package com.company.orderservice.service.mapper;

import com.company.orderservice.dto.OrdersBooksDto;
import com.company.orderservice.dto.OrdersDto;
import com.company.orderservice.modul.Orders;
import org.mapstruct.*;



@Mapper(componentModel = "spring")
public abstract class OrdersMapper {


    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    public abstract OrdersDto toDto(Orders orders);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    public abstract Orders toEntity(OrdersDto dto);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void  updateOrderWithDto(OrdersDto dto,@MappingTarget Orders orders);


}








