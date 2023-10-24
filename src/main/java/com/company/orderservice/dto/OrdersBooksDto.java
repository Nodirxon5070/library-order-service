package com.company.orderservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrdersBooksDto {
    private Integer orderBookId;

//    private Set<BooksDto> books;
    private Set<OrdersDto> orders;
}
