package com.ms.controllers;


import com.ms.dtos.ProductsRecordsDto;
import com.ms.models.ProductModel;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;





@RestController
public class ProductController {



    
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductsRecordsDto productsRecordsDto) {

        var productModel = new ProductModel();
        BeanUtils.copyProperties(ProductsRecordsDto, ProductModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productModel);

    }




}
