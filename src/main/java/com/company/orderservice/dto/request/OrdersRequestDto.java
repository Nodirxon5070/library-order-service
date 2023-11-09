package com.company.orderservice.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrdersRequestDto {
    private Integer userId;
    private Integer total;

    private OrdersBooksRequestDto ordersBooks;

}
