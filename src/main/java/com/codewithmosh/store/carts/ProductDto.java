package com.codewithmosh.store.carts;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class ProductDto {
    private Long id;
    private String name;
    private BigDecimal price;
    
}
