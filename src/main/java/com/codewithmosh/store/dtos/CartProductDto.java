package com.codewithmosh.store.dtos;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class CartProductDto {
    private Long id;
    private String name;
    private BigDecimal price;
    
}
