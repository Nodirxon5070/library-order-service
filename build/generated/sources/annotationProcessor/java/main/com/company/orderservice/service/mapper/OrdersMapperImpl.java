package com.company.orderservice.service.mapper;

import com.company.orderservice.dto.OrdersBooksDto;
import com.company.orderservice.dto.OrdersBooksDto.OrdersBooksDtoBuilder;
import com.company.orderservice.dto.OrdersDto;
import com.company.orderservice.dto.OrdersDto.OrdersDtoBuilder;
import com.company.orderservice.modul.Orders;
import com.company.orderservice.modul.OrdersBooks;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-19T17:50:56+0500",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.3.jar, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class OrdersMapperImpl extends OrdersMapper {

    @Override
    public OrdersDto toDto(Orders orders) {
        if ( orders == null ) {
            return null;
        }

        OrdersDtoBuilder ordersDto = OrdersDto.builder();

        ordersDto.orderId( orders.getOrderId() );
        ordersDto.userId( orders.getUserId() );
        ordersDto.total( orders.getTotal() );
        ordersDto.ordersBooks( ordersBooksToOrdersBooksDto( orders.getOrdersBooks() ) );

        return ordersDto.build();
    }

    @Override
    public Orders toEntity(OrdersDto dto) {
        if ( dto == null ) {
            return null;
        }

        Orders orders = new Orders();

        orders.setOrderId( dto.getOrderId() );
        orders.setUserId( dto.getUserId() );
        orders.setTotal( dto.getTotal() );
        orders.setOrdersBooks( ordersBooksDtoToOrdersBooks( dto.getOrdersBooks() ) );

        return orders;
    }

    @Override
    public void updateOrderWithDto(OrdersDto dto, Orders orders) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getOrderId() != null ) {
            orders.setOrderId( dto.getOrderId() );
        }
        if ( dto.getUserId() != null ) {
            orders.setUserId( dto.getUserId() );
        }
        if ( dto.getTotal() != null ) {
            orders.setTotal( dto.getTotal() );
        }
        if ( dto.getOrdersBooks() != null ) {
            if ( orders.getOrdersBooks() == null ) {
                orders.setOrdersBooks( new OrdersBooks() );
            }
            ordersBooksDtoToOrdersBooks1( dto.getOrdersBooks(), orders.getOrdersBooks() );
        }
    }

    protected Set<OrdersDto> ordersSetToOrdersDtoSet(Set<Orders> set) {
        if ( set == null ) {
            return null;
        }

        Set<OrdersDto> set1 = new HashSet<OrdersDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Orders orders : set ) {
            set1.add( toDto( orders ) );
        }

        return set1;
    }

    protected OrdersBooksDto ordersBooksToOrdersBooksDto(OrdersBooks ordersBooks) {
        if ( ordersBooks == null ) {
            return null;
        }

        OrdersBooksDtoBuilder ordersBooksDto = OrdersBooksDto.builder();

        ordersBooksDto.orderBookId( ordersBooks.getOrderBookId() );
        ordersBooksDto.orders( ordersSetToOrdersDtoSet( ordersBooks.getOrders() ) );

        return ordersBooksDto.build();
    }

    protected Set<Orders> ordersDtoSetToOrdersSet(Set<OrdersDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Orders> set1 = new HashSet<Orders>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( OrdersDto ordersDto : set ) {
            set1.add( toEntity( ordersDto ) );
        }

        return set1;
    }

    protected OrdersBooks ordersBooksDtoToOrdersBooks(OrdersBooksDto ordersBooksDto) {
        if ( ordersBooksDto == null ) {
            return null;
        }

        OrdersBooks ordersBooks = new OrdersBooks();

        ordersBooks.setOrderBookId( ordersBooksDto.getOrderBookId() );
        ordersBooks.setOrders( ordersDtoSetToOrdersSet( ordersBooksDto.getOrders() ) );

        return ordersBooks;
    }

    protected void ordersBooksDtoToOrdersBooks1(OrdersBooksDto ordersBooksDto, OrdersBooks mappingTarget) {
        if ( ordersBooksDto == null ) {
            return;
        }

        if ( ordersBooksDto.getOrderBookId() != null ) {
            mappingTarget.setOrderBookId( ordersBooksDto.getOrderBookId() );
        }
        if ( mappingTarget.getOrders() != null ) {
            Set<Orders> set = ordersDtoSetToOrdersSet( ordersBooksDto.getOrders() );
            if ( set != null ) {
                mappingTarget.getOrders().clear();
                mappingTarget.getOrders().addAll( set );
            }
        }
        else {
            Set<Orders> set = ordersDtoSetToOrdersSet( ordersBooksDto.getOrders() );
            if ( set != null ) {
                mappingTarget.setOrders( set );
            }
        }
    }
}
