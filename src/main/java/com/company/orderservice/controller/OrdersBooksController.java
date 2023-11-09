package com.company.orderservice.controller;

import com.company.orderservice.dto.ResponseDto;
import com.company.orderservice.dto.SimpleCRUD;
import com.company.orderservice.dto.request.OrdersBooksRequestDto;
import com.company.orderservice.dto.request.OrdersRequestDto;
import com.company.orderservice.dto.response.OrdersBooksResponseDto;
import com.company.orderservice.dto.response.OrdersResponseDto;
import com.company.orderservice.service.OrdersBooksService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.company.orderservice.constants.Constants.EXAMPLE_ORDERSBOOKS_NOT_FOUND;
import static com.company.orderservice.constants.Constants.EXAMPLE_ORDERSBOOKS_SUCCESS;
import static com.company.orderservice.constants.SimpleResponseDto.convertStatusCodeByData;


@RestController
@RequestMapping(value = "ordersbooks")
public class OrdersBooksController implements SimpleCRUD<Integer, OrdersBooksResponseDto, OrdersBooksRequestDto> {

    @Autowired
    protected OrdersBooksService ordersBooksService;

    @Override
    @Operation(
            method = "Post",
            summary = "This method creates OrdersBook",
            description = "Create OrdersBook",
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
                                    examples = @ExampleObject(value = EXAMPLE_ORDERSBOOKS_SUCCESS)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "404",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_ORDERSBOOKS_NOT_FOUND)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "400",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_ORDERSBOOKS_NOT_FOUND)
                            )
                    }

            )

    })
    @PostMapping(value = "/create")
    public ResponseEntity<ResponseDto<OrdersBooksResponseDto>> create(@Valid @RequestBody OrdersBooksRequestDto dto) {
        return convertStatusCodeByData(this.ordersBooksService.create(dto));
    }

    @Override
    @Operation(
            method = "Get",
            summary = "This method gets OrdersBook",
            description = "Get OrdersBook",
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
                                    examples = @ExampleObject(value = EXAMPLE_ORDERSBOOKS_SUCCESS)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "404",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_ORDERSBOOKS_NOT_FOUND)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "400",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_ORDERSBOOKS_NOT_FOUND)
                            )
                    }

            )

    })
    @GetMapping(value = "/get/{id}")
    public ResponseEntity<ResponseDto<OrdersBooksResponseDto>> get(@PathVariable(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.ordersBooksService.get(entityId));
    }

    @Override
    @Operation(
            method = "Put",
            summary = "This method Updates OrdersBook",
            description = "Update OrdersBook",
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
                                    examples = @ExampleObject(value = EXAMPLE_ORDERSBOOKS_SUCCESS)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "404",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_ORDERSBOOKS_NOT_FOUND)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "400",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_ORDERSBOOKS_NOT_FOUND)
                            )
                    }

            )

    })
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<ResponseDto<OrdersBooksResponseDto>> update(@PathVariable(value = "id") Integer entityId, @RequestBody OrdersBooksRequestDto dto) {
        return convertStatusCodeByData(this.ordersBooksService.update(entityId,dto));
    }

    @Override
    @Operation(
            method = "Delete",
            summary = "This method deletes OrdersBook",
            description = "Delete OrdersBook",
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
                                    examples = @ExampleObject(value = EXAMPLE_ORDERSBOOKS_SUCCESS)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "404",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_ORDERSBOOKS_NOT_FOUND)
                            )
                    }

            ),
            @ApiResponse(
                    responseCode = "400",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    examples = @ExampleObject(value = EXAMPLE_ORDERSBOOKS_NOT_FOUND)
                            )
                    }

            )

    })
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<ResponseDto<OrdersBooksResponseDto>> delete(@PathVariable(value = "id") Integer entityId) {
        return convertStatusCodeByData(this.ordersBooksService.delete(entityId));
    }
}

