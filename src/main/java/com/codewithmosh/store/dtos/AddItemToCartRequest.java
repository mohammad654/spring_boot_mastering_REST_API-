package com.codewithmosh.store.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AddItemToCartRequest {
    @NotNull(message = "Product ID is required")
    private Long productId; 
}
