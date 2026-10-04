package com.codewithmosh.store.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codewithmosh.store.dtos.ProductDto;
import com.codewithmosh.store.dtos.UserDto;
import com.codewithmosh.store.entities.Product;
import com.codewithmosh.store.mapper.ProductMapper;
import com.codewithmosh.store.repositories.ProductRepository;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor 
@RestController 
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @GetMapping()
    public List<ProductDto> getAllProducts(@RequestParam(required = false, defaultValue = "", name = "categoryId") Byte categoryId){
        List<Product> products;
        if (categoryId !=null) {
            products=productRepository.findByCategoryId(categoryId);
        }else{
            // products=productRepository.findAll();
            products =productRepository.findAllWithCategory();
        }
        return products.stream().map(productMapper::toDto).toList();

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        var product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productMapper.toDto(product));
    }
    
}
