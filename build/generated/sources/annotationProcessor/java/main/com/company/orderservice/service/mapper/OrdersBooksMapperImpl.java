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
import java.util.stream.Collectors;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-09T16:58:48+0500",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.3.jar, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class OrdersBooksMapperImpl extends OrdersBooksMapper {

    @Override
    public OrdersBooksResponseDto toDto(OrdersBooks ordersBooks) {
        if ( ordersBooks == null ) {
            return null;
        }

        OrdersBooksResponseDtoBuilder ordersBooksResponseDto = OrdersBooksResponseDto.builder();

        ordersBooksResponseDto.orderBookId( ordersBooks.getOrderBookId() );
        ordersBooksResponseDto.orders( ordersSetToOrdersResponseDtoSet( ordersBooks.getOrders() ) );

        return ordersBooksResponseDto.build();
    }

    @Override
    public OrdersBooks toEntity(OrdersBooksRequestDto ordersBooksDto) {
        if ( ordersBooksDto == null ) {
            return null;
        }

        OrdersBooks ordersBooks = new OrdersBooks();

        ordersBooks.setOrderBookId( ordersBooksDto.getOrderBookId() );
        ordersBooks.setOrders( ordersRequestDtoSetToOrdersSet( ordersBooksDto.getOrders() ) );

        return ordersBooks;
    }

    @Override
    public OrdersBooks updateOrdersBooksFromDto(OrdersBooksRequestDto dto, OrdersBooks ordersBooks) {
        if ( dto == null ) {
            return null;
        }

        if ( dto.getOrderBookId() != null ) {
            ordersBooks.setOrderBookId( dto.getOrderBookId() );
        }
        if ( ordersBooks.getOrders() != null ) {
            Set<Orders> set = ordersRequestDtoSetToOrdersSet( dto.getOrders() );
            if ( set != null ) {
                ordersBooks.getOrders().clear();
                ordersBooks.getOrders().addAll( set );
            }
        }
        else {
            Set<Orders> set = ordersRequestDtoSetToOrdersSet( dto.getOrders() );
            if ( set != null ) {
                ordersBooks.setOrders( set );
            }
        }

        return ordersBooks;
    }

    protected OrdersResponseDto ordersToOrdersResponseDto(Orders orders) {
        if ( orders == null ) {
            return null;
        }

        OrdersResponseDtoBuilder ordersResponseDto = OrdersResponseDto.builder();

        ordersResponseDto.orderId( orders.getOrderId() );
        ordersResponseDto.userId( orders.getUserId() );
        ordersResponseDto.total( orders.getTotal() );
        ordersResponseDto.ordersBooks( toDto( orders.getOrdersBooks() ) );
        ordersResponseDto.createdAt( orders.getCreatedAt() );
        ordersResponseDto.updatedAt( orders.getUpdatedAt() );
        ordersResponseDto.deletedAt( orders.getDeletedAt() );

        return ordersResponseDto.build();
    }

    protected Set<OrdersResponseDto> ordersSetToOrdersResponseDtoSet(Set<Orders> set) {
        if ( set == null ) {
            return null;
        }

        Set<OrdersResponseDto> set1 = new HashSet<OrdersResponseDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Orders orders : set ) {
            set1.add( ordersToOrdersResponseDto( orders ) );
        }

        return set1;
    }

    protected Orders ordersRequestDtoToOrders(OrdersRequestDto ordersRequestDto) {
        if ( ordersRequestDto == null ) {
            return null;
        }

        Orders orders = new Orders();

        orders.setOrderId( ordersRequestDto.getOrderId() );
        orders.setUserId( ordersRequestDto.getUserId() );
        orders.setTotal( ordersRequestDto.getTotal() );
        orders.setOrdersBooks( toEntity( ordersRequestDto.getOrdersBooks() ) );
        orders.setCreatedAt( ordersRequestDto.getCreatedAt() );
        orders.setUpdatedAt( ordersRequestDto.getUpdatedAt() );
        orders.setDeletedAt( ordersRequestDto.getDeletedAt() );

        return orders;
    }

    protected Set<Orders> ordersRequestDtoSetToOrdersSet(Set<OrdersRequestDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Orders> set1 = new HashSet<Orders>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( OrdersRequestDto ordersRequestDto : set ) {
            set1.add( ordersRequestDtoToOrders( ordersRequestDto ) );
        }

        return set1;
    }
}
