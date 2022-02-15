package com.example.demo.service;


import com.example.demo.shared.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    String getProduct();

    Optional<ProductDto> getProductById(String id);

    ProductDto createProduct(ProductDto userDetails);

    Optional<ProductDto> updateProduct(String id, ProductDto productDto);

    boolean deleteProduct(String id);

    List<ProductDto> getProducts();
}
