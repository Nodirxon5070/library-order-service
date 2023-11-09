package com.company.orderservice.service.mapper;

import com.company.orderservice.dto.request.OrdersBooksRequestDto;
import com.company.orderservice.dto.request.OrdersRequestDto;
import com.company.orderservice.dto.response.OrdersBooksResponseDto;
import com.company.orderservice.dto.response.OrdersBooksResponseDto.OrdersBooksResponseDtoBuilder;
import com.company.orderservice.dto.response.OrdersResponseDto;
import com.company.orderservice.dto.response.OrdersResponseDto.OrdersResponseDtoBuilder;
import com.company.orderservice.modul.Orders;
import com.company.orderservice.modul.OrdersBooks;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-09T16:58:48+0500",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.3.jar, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class OrdersMapperImpl extends OrdersMapper {

    @Override
    public OrdersResponseDto toDto(Orders orders) {
        if ( orders == null ) {
            return null;
        }

        OrdersResponseDtoBuilder ordersResponseDto = OrdersResponseDto.builder();

        ordersResponseDto.orderId( orders.getOrderId() );
        ordersResponseDto.userId( orders.getUserId() );
        ordersResponseDto.total( orders.getTotal() );
        ordersResponseDto.ordersBooks( ordersBooksToOrdersBooksResponseDto( orders.getOrdersBooks() ) );
        ordersResponseDto.createdAt( orders.getCreatedAt() );
        ordersResponseDto.updatedAt( orders.getUpdatedAt() );
        ordersResponseDto.deletedAt( orders.getDeletedAt() );

        return ordersResponseDto.build();
    }

    @Override
    public Orders toEntity(OrdersRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Orders orders = new Orders();

        orders.setOrderId( dto.getOrderId() );
        orders.setUserId( dto.getUserId() );
        orders.setTotal( dto.getTotal() );
        orders.setOrdersBooks( ordersBooksRequestDtoToOrdersBooks( dto.getOrdersBooks() ) );
        orders.setCreatedAt( dto.getCreatedAt() );
        orders.setUpdatedAt( dto.getUpdatedAt() );
        orders.setDeletedAt( dto.getDeletedAt() );

        return orders;
    }

    @Override
    public Orders updateOrderWithDto(OrdersRequestDto dto, Orders orders) {
        if ( dto == null ) {
            return null;
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
            ordersBooksRequestDtoToOrdersBooks1( dto.getOrdersBooks(), orders.getOrdersBooks() );
        }
        if ( dto.getCreatedAt() != null ) {
            orders.setCreatedAt( dto.getCreatedAt() );
        }
        if ( dto.getUpdatedAt() != null ) {
            orders.setUpdatedAt( dto.getUpdatedAt() );
        }
        if ( dto.getDeletedAt() != null ) {
            orders.setDeletedAt( dto.getDeletedAt() );
        }

        return orders;
    }

    protected Set<OrdersResponseDto> ordersSetToOrdersResponseDtoSet(Set<Orders> set) {
        if ( set == null ) {
            return null;
        }

        Set<OrdersResponseDto> set1 = new HashSet<OrdersResponseDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Orders orders : set ) {
            set1.add( toDto( orders ) );
        }

        return set1;
    }

    protected OrdersBooksResponseDto ordersBooksToOrdersBooksResponseDto(OrdersBooks ordersBooks) {
        if ( ordersBooks == null ) {
            return null;
        }

        OrdersBooksResponseDtoBuilder ordersBooksResponseDto = OrdersBooksResponseDto.builder();

        ordersBooksResponseDto.orderBookId( ordersBooks.getOrderBookId() );
        ordersBooksResponseDto.orders( ordersSetToOrdersResponseDtoSet( ordersBooks.getOrders() ) );

        return ordersBooksResponseDto.build();
    }

    protected Set<Orders> ordersRequestDtoSetToOrdersSet(Set<OrdersRequestDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Orders> set1 = new HashSet<Orders>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( OrdersRequestDto ordersRequestDto : set ) {
            set1.add( toEntity( ordersRequestDto ) );
        }

        return set1;
    }

    protected OrdersBooks ordersBooksRequestDtoToOrdersBooks(OrdersBooksRequestDto ordersBooksRequestDto) {
        if ( ordersBooksRequestDto == null ) {
            return null;
        }

        OrdersBooks ordersBooks = new OrdersBooks();

        ordersBooks.setOrderBookId( ordersBooksRequestDto.getOrderBookId() );
        ordersBooks.setOrders( ordersRequestDtoSetToOrdersSet( ordersBooksRequestDto.getOrders() ) );

        return ordersBooks;
    }

    protected void ordersBooksRequestDtoToOrdersBooks1(OrdersBooksRequestDto ordersBooksRequestDto, OrdersBooks mappingTarget) {
        if ( ordersBooksRequestDto == null ) {
            return;
        }

        if ( ordersBooksRequestDto.getOrderBookId() != null ) {
            mappingTarget.setOrderBookId( ordersBooksRequestDto.getOrderBookId() );
        }
        if ( mappingTarget.getOrders() != null ) {
            Set<Orders> set = ordersRequestDtoSetToOrdersSet( ordersBooksRequestDto.getOrders() );
            if ( set != null ) {
                mappingTarget.getOrders().clear();
                mappingTarget.getOrders().addAll( set );
            }
        }
        else {
            Set<Orders> set = ordersRequestDtoSetToOrdersSet( ordersBooksRequestDto.getOrders() );
            if ( set != null ) {
                mappingTarget.setOrders( set );
            }
        }
    }
}
