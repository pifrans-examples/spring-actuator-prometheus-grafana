package com.pifrans.springactuatorprometheusgrafana.controllers;

import com.pifrans.springactuatorprometheusgrafana.domains.dtos.UserDTO;
import com.pifrans.springactuatorprometheusgrafana.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO.All> findById(@PathVariable Long id) {
        final UserDTO.All object = userService.findById(id);
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO.All>> findAll() {
        final List<UserDTO.All> list = userService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDTO.All> save(@Validated @RequestBody UserDTO.Save body) {
        final UserDTO.All object = userService.save(body);
        return new ResponseEntity<>(object, HttpStatus.CREATED);
    }

    @PostMapping("/saveAll")
    public ResponseEntity<List<UserDTO.All>> saveAll(@Validated @RequestBody List<UserDTO.Save> body) {
        final List<UserDTO.All> list = userService.saveAll(body);
        return new ResponseEntity<>(list, HttpStatus.CREATED);
    }
}
