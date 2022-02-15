package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.entity.ProductEntity;
import com.example.demo.shared.Util;
import com.example.demo.shared.dto.ProductDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.example.demo.service.ProductService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private Util util;

    public ProductServiceImpl(ProductRepository productRepository, Util util) {
        this.productRepository = productRepository;
        this.util = util;
    }

    public String getProduct() { return "getProduct"; }

    public Optional<ProductDto> getProductById(String id) {
        Optional<ProductEntity> productIdEntity = productRepository.findByProductId(id);
        return productIdEntity.map(productEntity -> {
           ProductDto productDto = new ProductDto();
           BeanUtils.copyProperties(productEntity, productDto);
           return productDto;
        });
    }

    public ProductDto createProduct(ProductDto productDetailsIn) {
        Optional<ProductEntity> checkNameEntity = productRepository.findByName(productDetailsIn.getName());
        if(checkNameEntity.isPresent()) {
            throw new BadRequestException("Product already exists");
        }
        ProductEntity productEntity = new ProductEntity();

        BeanUtils.copyProperties(productDetailsIn, productEntity);

        String productId = util.generateHash(productDetailsIn.getName());
        productEntity.setProductId(productId.substring(3));

        ProductEntity productEntityOut = productRepository.save(productEntity);
        ProductDto productDtoOut = new ProductDto();
        BeanUtils.copyProperties(productEntityOut, productDtoOut);
        return productDtoOut;
    }

    public Optional<ProductDto> updateProduct(String id, ProductDto productDto) {

        Optional<ProductEntity> productIdEntity = productRepository.findByProductId(id);
        if (productIdEntity.isEmpty()) {
            return Optional.empty();
        }
        return productIdEntity.map(productEntity -> {
            ProductDto response = new ProductDto();

            productEntity.setProductId(productDto.getProductId() != null ? util.generateHash(productDto.getName()).substring(3) : productEntity.getProductId());
            productEntity.setName(productDto.getName() != null ? productDto.getName() : productEntity.getName());
            productEntity.setCost(productDto.getCost() != 0 ? Integer.parseInt(String.valueOf(productDto.getCost())) : productEntity.getCost());
            productEntity.setCategory(productDto.getCategory() != null ? productDto.getCategory() : productEntity.getCategory());

            ProductEntity updatedProductEntity = productRepository.save(productEntity);
            BeanUtils.copyProperties(updatedProductEntity, response);
            return response;
        });

    }
    @Transactional
    public boolean deleteProduct(String id) {
        long removedUsersCount = productRepository.deleteByProductId(id);
        return removedUsersCount > 0;
    }

    @Override
    public List<ProductDto> getProducts() {
        Iterable<ProductEntity> userEntities = productRepository.findAll();
        ArrayList<ProductDto> productDtos = new ArrayList<>();
        for (ProductEntity productEntity : userEntities) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productEntity, productDto);
            productDtos.add(productDto);
        }
        return productDtos;
    }
}
