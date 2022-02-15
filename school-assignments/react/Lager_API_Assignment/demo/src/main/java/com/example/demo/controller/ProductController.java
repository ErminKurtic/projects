package com.example.demo.controller;


import com.example.demo.exception.NotFoundException;
import com.example.demo.model.request.ProductDetailsRequestModel;
import com.example.demo.model.response.ProductResponseModel;
import com.example.demo.shared.dto.ProductDto;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductResponseModel> getProducts() {
        List<ProductDto> productDtos = productService.getProducts();
        ArrayList<ProductResponseModel> responseList = new ArrayList<>();
        for (ProductDto productDto : productDtos) {
            ProductResponseModel responseModel = new ProductResponseModel();
            BeanUtils.copyProperties(productDto, responseModel);
            responseList.add(responseModel);
        }
        return responseList;
    }

    @GetMapping("/{id}")
    public ProductResponseModel getProduct(@PathVariable String id) {
        ProductResponseModel responseModel = new ProductResponseModel();
        Optional<ProductDto> optionalProductDto = productService.getProductById(id);
        if (optionalProductDto.isPresent()) {
            ProductDto productDto = optionalProductDto.get();
            BeanUtils.copyProperties(productDto, responseModel);
            return responseModel;
        }
        throw new NotFoundException("Can't find a product with the id: " + id);
    }

    @PostMapping
    public ResponseEntity<ProductResponseModel> createProduct(@RequestBody ProductDetailsRequestModel productDetailsModel) {

        ProductDto productDtoIn = new ProductDto();
        BeanUtils.copyProperties(productDetailsModel, productDtoIn);

        ProductDto productDtoOut = productService.createProduct(productDtoIn);

        ProductResponseModel response = new ProductResponseModel();
        BeanUtils.copyProperties(productDtoOut, response);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ProductResponseModel updateProduct(@PathVariable String id, @RequestBody ProductDetailsRequestModel requestData) {
        ProductDto productDtoIn = new ProductDto();
        BeanUtils.copyProperties(requestData, productDtoIn);

        Optional<ProductDto> productDtoOut = productService.updateProduct(id, productDtoIn);
        if(productDtoOut.isEmpty()) {
            throw new NotFoundException("Can't find a product with the id: " + id);
        }

            ProductDto productDto = productDtoOut.get();
            ProductResponseModel responseModel = new ProductResponseModel();
            BeanUtils.copyProperties(productDto, responseModel);
            return responseModel;
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable String id) {
        boolean deleted = productService.deleteProduct(id);
        if (deleted) {
            return "";
        }
        throw new NotFoundException("Can't find a product with the id: " + id);
    }

}
