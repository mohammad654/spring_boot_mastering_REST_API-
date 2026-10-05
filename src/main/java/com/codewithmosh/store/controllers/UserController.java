package com.codewithmosh.store.controllers;



import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.codewithmosh.store.dtos.ChangePasswordRequest;
import com.codewithmosh.store.dtos.RegisterUserRequest;
import com.codewithmosh.store.dtos.UpdateUserRequest;
import com.codewithmosh.store.dtos.UserDto;
import com.codewithmosh.store.entities.User;
import com.codewithmosh.store.mapper.UserMapper;
import com.codewithmosh.store.repositories.UserRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.val;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;






@AllArgsConstructor 
@RestController 
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    // using entity 
    // @GetMapping()  
    // public Iterable<User> getAllUsers(){
    //     return  userRepository.findAll();
    // }

    // @GetMapping("/{id}")
    // public ResponseEntity <User> getUsersByIds( @PathVariable Long id) {
    //     var user =userRepository.findById(id).orElse(null);
    //     if (user==null){
    //        return ResponseEntity.notFound().build();
    //     }
    //     return ResponseEntity.ok(user);
    // }

    // using dto 
      
    // @GetMapping
    // public List<UserDto> getAllUsers() {
    //     return userRepository.findAll().stream()
    //         .map(user -> new UserDto(
    //             user.getId(),
    //             user.getName(),
    //             user.getEmail()
    //         ))
    //         .toList();
    // }

    // @GetMapping("/{id}")
    // public ResponseEntity <UserDto> getUsersByIds( @PathVariable Long id) {
    //     var user =userRepository.findById(id).orElse(null);
    //     if (user==null){
    //        return ResponseEntity.notFound().build();
    //     }
    //     var userDto = new UserDto(user.getId(), user.getName(),user.getEmail());
    //     return ResponseEntity.ok(userDto);
    // }

    // using mapper 
  @GetMapping
    public List<UserDto> getAllUsers(
        // @RequestHeader(required = false,name = "x-auth-token") String authToken,
        @RequestParam(required = false, defaultValue = "", name = "sort")
         String sortBy) {
        if (!Set.of("name","email").contains(sortBy)){
            sortBy="name";
        }
        return userRepository.findAll(Sort.by(sortBy).descending()).stream()
            .map(userMapper::toDto)
            .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity <UserDto> getUsersByIds( @PathVariable Long id) {
        var user =userRepository.findById(id).orElse(null);
        if (user==null){
           return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userMapper.toDto(user));
    }
    @PostMapping
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterUserRequest request, UriComponentsBuilder uriBuilder) {
         var checkEmail = userRepository.existsByEmail(request.getEmail());
        if(checkEmail){
            return ResponseEntity.badRequest().body(Map.of("email", "Email is already registerd"));
        }

        var user = userMapper.toEntity(request);   // ← userMapper is null / never injected
        userRepository.save(user);
        var userDto = userMapper.toDto(user);
        var uri = uriBuilder.path("/users/{id}").buildAndExpand(userDto.getId()).toUri();
        return ResponseEntity.created(uri).body(userDto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserDto>  updateUser(@PathVariable(name = "id") Long id ,
    @RequestBody UpdateUserRequest request){
        var user=userRepository.findById(id).orElse(null);
        if(user==null){
            return ResponseEntity.notFound().build(); 
        }
        userMapper.update(request, user);
        userRepository.save(user);
        return ResponseEntity.ok(userMapper.toDto(user));
    }
    
    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "id") Long id){
        var user=userRepository.findById(id).orElse(null);
        if(user==null){
            return ResponseEntity.notFound().build(); 
        }  
        userRepository.delete(user);
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping("/{id}/change-password")
    public ResponseEntity<Void> changePassword(@PathVariable(name = "id") Long id, @RequestBody ChangePasswordRequest request){
        var user=userRepository.findById(id).orElse(null);
        if(user==null){
            return ResponseEntity.notFound().build(); 
        }
        if(!user.getPassword().equals(request.getOldPassword())){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        user.setPassword(request.getNewPassword());
        userRepository.save(user);
        return ResponseEntity.noContent().build();
    }

}
