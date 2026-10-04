package com.codewithmosh.store.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.codewithmosh.store.dtos.RegisterUserRequest;
import com.codewithmosh.store.dtos.UpdateUserRequest;
import com.codewithmosh.store.dtos.UserDto;
import com.codewithmosh.store.entities.User;

@Mapper (componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    // to save in data 
    User toEntity(RegisterUserRequest request);
    // update
    void update(UpdateUserRequest request, @MappingTarget  User user);
    
}
