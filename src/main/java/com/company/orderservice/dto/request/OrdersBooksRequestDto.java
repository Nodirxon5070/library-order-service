package com.company.orderservice.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrdersBooksRequestDto {
    private Integer orderBookId;

//    private Set<BooksDto> books;
    private Set<OrdersRequestDto> orders;
}