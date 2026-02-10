package com.ms.services;


import com.ms.dtos.ProductDto;
import com.ms.models.ProductModel;
import com.ms.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {


    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public ProductDto createProduct(ProductDto dto) {

        ProductModel products = new ProductModel();
        products.setName(dto.getName());
        products.setValue(dto.getValue());

        ProductModel saved = productRepository.save(products);
        return toResponseDTO(saved);

    }


    public ProductDto updateProduct(UUID id, ProductDto dto){

        ProductModel product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto nao encontrado"));

        product.setName(dto.getName());
        product.setValue(dto.getValue());
        ProductModel update = productRepository.save(product);
        return toResponseDTO(update);
    }

    public ProductDto getProductById(UUID id) {
        ProductModel product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto nao encontrado"));
        return toResponseDTO(product);
    }

    public List<ProductDto> getAllProduct() {
        List<ProductModel> product = productRepository.findAll();
        return product.stream().map(this:: toResponseDTO).toList();

    }

    public void deleteProduct(UUID id) {
        ProductModel product = productRepository.getReferenceById(id);

    }


    private ProductDto toResponseDTO(ProductModel productModel){
        ProductDto dto = new ProductDto();
        dto.setName(productModel.getName());
        dto.setValue(productModel.getValue());
        return dto;

    }

}
