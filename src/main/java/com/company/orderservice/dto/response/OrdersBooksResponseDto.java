package com.company.orderservice.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrdersBooksResponseDto {
    private Integer orderBookId;

//    private Set<BooksDto> books;
    private Set<OrdersResponseDto> orders;
}
