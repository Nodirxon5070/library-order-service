package com.company.orderservice.controller;

import com.company.orderservice.dto.ResponseDto;
import com.company.orderservice.dto.SimpleCRUD;
import com.company.orderservice.dto.request.OrdersRequestDto;
import com.company.orderservice.dto.response.OrdersBooksResponseDto;
import com.company.orderservice.dto.response.OrdersResponseDto;
import com.company.orderservice.service.OrdersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.orderservice.constants.Constants.*;
import static com.company.orderservice.constants.SimpleResponseDto.convertStatusCodeByData;


@RestController
@RequestMapping(value = "orders")
@RequiredArgsConstructor
public class OrdersController implements SimpleCRUD<Integer, OrdersResponseDto, OrdersRequestDto> {

    private final OrdersService ordersService;

    @Override
    @Operation(
            method = "Post",
            summary = "This method creates Orders",
            description = "Create Orders",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            )
    )
    @ApiResponses(value={
            @ApiResponse(
                    responseCode = "200",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_ORDERS_SUCCESS)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "404",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_ORDERS_NOT_FOUND)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "400",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_ORDERS_NOT_FOUND)
                            )
                    }

            )

    })
    @PostMapping(value = "/create")
    public ResponseEntity<ResponseDto<OrdersResponseDto>> create(@RequestBody OrdersRequestDto dto) {
        return convertStatusCodeByData(this.ordersService.create(dto));
    }

    @Override
    @ApiResponses(value={
            @ApiResponse(
                    responseCode = "200",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_ORDERS_SUCCESS)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "404",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_ORDERS_NOT_FOUND)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "400",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_ORDERS_NOT_FOUND)
                            )
                    }

            )

    })
    @Operation(
            method = "Get",
            summary = "This method gets Orders",
            description = "Get Orders",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            )
    )
    @GetMapping(value = "/get")
    public ResponseEntity<ResponseDto<OrdersResponseDto>> get(@RequestParam(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.ordersService.get(entityId));
    }

    @Override
    @ApiResponses(value={
            @ApiResponse(
                    responseCode = "200",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_ORDERS_SUCCESS)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "404",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_ORDERS_NOT_FOUND)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "400",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_ORDERS_NOT_FOUND)
                            )
                    }

            )

    })
    @Operation(
            method = "Put",
            summary = "This method Updates Orders",
            description = "Update Orders",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            )
    )
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<ResponseDto<OrdersResponseDto>> update(@PathVariable(value = "id") Integer entityId,
                                         @RequestBody OrdersRequestDto dto) {
        return convertStatusCodeByData(this.ordersService.update(entityId, dto));
    }

    @Override
    @ApiResponses(value={
            @ApiResponse(
                    responseCode = "200",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_ORDERS_SUCCESS)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "404",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_ORDERS_NOT_FOUND)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "400",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_ORDERS_NOT_FOUND)
                            )
                    }

            )

    })
    @Operation(
            method = "Delete",
            summary = "This method deletes Orders",
            description = "Delete Orders",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            )
    )
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<ResponseDto<OrdersResponseDto>> delete(@PathVariable(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.ordersService.delete(entityId));
    }
}
