package com.company.orderservice.service.mapper;

import com.company.orderservice.dto.OrdersBooksDto;
import com.company.orderservice.dto.OrdersBooksDto.OrdersBooksDtoBuilder;
import com.company.orderservice.dto.OrdersDto;
import com.company.orderservice.dto.OrdersDto.OrdersDtoBuilder;
import com.company.orderservice.modul.Orders;
import com.company.orderservice.modul.OrdersBooks;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-24T15:36:10+0500",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.3.jar, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class OrdersBooksMapperImpl extends OrdersBooksMapper {

    @Override
    public OrdersBooksDto toDto(OrdersBooks ordersBooks) {
        if ( ordersBooks == null ) {
            return null;
        }

        OrdersBooksDtoBuilder ordersBooksDto = OrdersBooksDto.builder();

        ordersBooksDto.orderBookId( ordersBooks.getOrderBookId() );
        ordersBooksDto.orders( ordersSetToOrdersDtoSet( ordersBooks.getOrders() ) );

        return ordersBooksDto.build();
    }

    @Override
    public OrdersBooks toEntity(OrdersBooksDto ordersBooksDto) {
        if ( ordersBooksDto == null ) {
            return null;
        }

        OrdersBooks ordersBooks = new OrdersBooks();

        ordersBooks.setOrderBookId( ordersBooksDto.getOrderBookId() );
        ordersBooks.setOrders( ordersDtoSetToOrdersSet( ordersBooksDto.getOrders() ) );

        return ordersBooks;
    }

    @Override
    public void updateOrdersBooksFromDto(OrdersBooksDto dto, OrdersBooks ordersBooks) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getOrderBookId() != null ) {
            ordersBooks.setOrderBookId( dto.getOrderBookId() );
        }
        if ( ordersBooks.getOrders() != null ) {
            Set<Orders> set = ordersDtoSetToOrdersSet( dto.getOrders() );
            if ( set != null ) {
                ordersBooks.getOrders().clear();
                ordersBooks.getOrders().addAll( set );
            }
        }
        else {
            Set<Orders> set = ordersDtoSetToOrdersSet( dto.getOrders() );
            if ( set != null ) {
                ordersBooks.setOrders( set );
            }
        }
    }

    protected OrdersDto ordersToOrdersDto(Orders orders) {
        if ( orders == null ) {
            return null;
        }

        OrdersDtoBuilder ordersDto = OrdersDto.builder();

        ordersDto.orderId( orders.getOrderId() );
        ordersDto.userId( orders.getUserId() );
        ordersDto.total( orders.getTotal() );
        ordersDto.ordersBooks( toDto( orders.getOrdersBooks() ) );
        ordersDto.createdAt( orders.getCreatedAt() );
        ordersDto.updatedAt( orders.getUpdatedAt() );
        ordersDto.deletedAt( orders.getDeletedAt() );

        return ordersDto.build();
    }

    protected Set<OrdersDto> ordersSetToOrdersDtoSet(Set<Orders> set) {
        if ( set == null ) {
            return null;
        }

        Set<OrdersDto> set1 = new HashSet<OrdersDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Orders orders : set ) {
            set1.add( ordersToOrdersDto( orders ) );
        }

        return set1;
    }

    protected Orders ordersDtoToOrders(OrdersDto ordersDto) {
        if ( ordersDto == null ) {
            return null;
        }

        Orders orders = new Orders();

        orders.setOrderId( ordersDto.getOrderId() );
        orders.setUserId( ordersDto.getUserId() );
        orders.setTotal( ordersDto.getTotal() );
        orders.setOrdersBooks( toEntity( ordersDto.getOrdersBooks() ) );
        orders.setCreatedAt( ordersDto.getCreatedAt() );
        orders.setUpdatedAt( ordersDto.getUpdatedAt() );
        orders.setDeletedAt( ordersDto.getDeletedAt() );

        return orders;
    }

    protected Set<Orders> ordersDtoSetToOrdersSet(Set<OrdersDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Orders> set1 = new HashSet<Orders>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( OrdersDto ordersDto : set ) {
            set1.add( ordersDtoToOrders( ordersDto ) );
        }

        return set1;
    }
}
