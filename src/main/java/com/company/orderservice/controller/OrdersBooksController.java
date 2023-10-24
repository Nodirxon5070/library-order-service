package com.company.orderservice.controller;

import com.company.orderservice.dto.OrdersBooksDto;
import com.company.orderservice.dto.ResponseDto;
import com.company.orderservice.dto.SimpleCRUD;
import com.company.orderservice.service.OrdersBooksService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@OpenAPIDefinition(
        tags = @Tag(name = "Orders Books tag"),
        info = @Info(
                title = "Library Project",
                description = "Making changes on Orders Books class",
                contact = @Contact(
                        name = "Library project",
                        url = "https://t.me/xan_5070",
                        email = "nodirxon5070@gmail.com"
                ),
                license = @License(name = "Orders Books License",
                url = "https://t.me/xan_5070")
        )
)
@RestController
@RequestMapping(value = "ordersbooks")
public class OrdersBooksController implements SimpleCRUD<Integer, OrdersBooksDto> {

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
    @PostMapping(value = "/create")
    public ResponseDto<OrdersBooksDto> create(@Valid @RequestBody OrdersBooksDto dto) {
        return this.ordersBooksService.create(dto);
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
    @GetMapping(value = "/get/{id}")
    public ResponseDto<OrdersBooksDto> get(@PathVariable(value = "id") Integer entityId) {
        return this.ordersBooksService.get(entityId);
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
    @PutMapping(value = "/update/{id}")
    public ResponseDto<OrdersBooksDto> update(@PathVariable(value = "id") Integer entityId,@RequestBody OrdersBooksDto dto) {
        return this.ordersBooksService.update(entityId,dto);
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
    @DeleteMapping(value = "/delete/{id}")
    public ResponseDto<OrdersBooksDto> delete(@PathVariable(value = "id") Integer entityId) {
        return this.ordersBooksService.delete(entityId);
    }
}

