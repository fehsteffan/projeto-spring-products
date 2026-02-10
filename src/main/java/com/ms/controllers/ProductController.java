package com.ms.controllers;


import com.ms.dtos.ProductDto;
import com.ms.models.ProductModel;
import com.ms.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;




@RestController
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public ResponseEntity<ProductDto> saveProduct(@RequestBody @Valid ProductDto dto) {
        ProductDto product = productService.createProduct(dto);
        return ResponseEntity.ok(product);

    }
    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> list = productService.getAllProduct();
        return ResponseEntity.ok().body(list);
    }


    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getOneProduct(@PathVariable UUID id){
        ProductDto product = productService.getProductById(id);
        return ResponseEntity.ok().body(product);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductDto> updateProduct (@PathVariable UUID id,
                                    @RequestBody ProductDto dto) {
        ProductDto products = productService.updateProduct(id, dto);
        return ResponseEntity.ok().body(products);

    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();

    }

}
