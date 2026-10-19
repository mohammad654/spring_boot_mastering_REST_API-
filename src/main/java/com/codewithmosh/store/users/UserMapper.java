package com.codewithmosh.store.users;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper (componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    // to save in data 
    User toEntity(RegisterUserRequest request);
    // update
    void update(UpdateUserRequest request, @MappingTarget  User user);
    
}
