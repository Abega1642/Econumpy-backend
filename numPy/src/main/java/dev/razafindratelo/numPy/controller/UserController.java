package dev.razafindratelo.numPy.controller;

import dev.razafindratelo.numPy.dtos.userDtos.UserDto;
import dev.razafindratelo.numPy.entity.user.User;
import dev.razafindratelo.numPy.services.userServices.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UserController {

    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers() {
        List<UserDto> userDtoList = userService.getAllUsers();
        return ResponseEntity.ok(userDtoList);
    }

    @GetMapping("/users/{userName}")
    public ResponseEntity<UserDto> getUser(@PathVariable String id) {
        UserDto userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/users/authentication")
    public ResponseEntity<Boolean> loginUser(@RequestBody UserDto userDto) {
        Boolean check = userService.checkUserLogin(userDto);
        return (check) ? ResponseEntity.ok(true) : ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    @PostMapping("/users/add")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto addUser = userService.createUser(userDto);
        return new ResponseEntity<>(addUser, HttpStatus.CREATED);
    }

    @PutMapping("/users/update/{userName}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("userName") String userName, @RequestBody UserDto userDto) {
        UserDto updateUser = userService.updateUser(userName, userDto);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("userName") String  id) {
        userService.deleteEvent(id);
        return "User deleted with success !";
    }

}
