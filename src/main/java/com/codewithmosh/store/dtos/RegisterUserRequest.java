package com.codewithmosh.store.dtos;

import com.codewithmosh.store.validation.Lowercase;
import com.codewithmosh.store.validation.ValidationGroups.First;
import com.codewithmosh.store.validation.ValidationGroups.Second;
import com.codewithmosh.store.validation.ValidationGroups.Third;

import jakarta.validation.GroupSequence;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@GroupSequence({First.class, Second.class, Third.class, RegisterUserRequest.class})
public class RegisterUserRequest {

    @NotBlank(message = "Name is required", groups = First.class)
    @Size(min = 2, max = 100, message = "Name must be between {min} and {max} characters", groups = Second.class)
    @Lowercase(groups = Third.class)
    private String name;
    
    @NotBlank(message = "Email is required", groups = First.class)
    @Email(message = "Email must be valid", groups = Second.class)
    private String email;
    
    @NotBlank(message = "Password is required", groups = First.class)
    @Size(min = 8, max = 72, message = "Password must be between {min} and {max} characters", groups = Second.class)
    @Pattern(
        regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#^()_\\-+=\\[\\]{}|;:'\",.<>/?~`]).*$",
        message = "Password must contain uppercase, lowercase, digit, and special character",
        groups = Third.class
    )
    private String password;
}