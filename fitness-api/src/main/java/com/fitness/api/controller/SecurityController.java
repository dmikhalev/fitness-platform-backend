package com.fitness.api.controller;

import com.fitness.api.dto.security.AuthInfoDto;
import com.fitness.api.dto.security.BaseUserCreateDto;
import com.fitness.api.dto.security.LoginUserDto;
import com.fitness.api.dto.security.currentUser.BaseUserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RequestMapping("/api/security")
public interface SecurityController {

    @RequestMapping(method = POST, path = "/login")
    ResponseEntity<AuthInfoDto> loginUser(@RequestBody LoginUserDto loginUserDto);

    @RequestMapping(method = POST, path = "/create")
    ResponseEntity<Object> createBaseUser(@RequestBody BaseUserCreateDto baseUserCreateDto);

    @RequestMapping(method = POST, path = "/currentUser")
    ResponseEntity<BaseUserDto> currentUser();

}
