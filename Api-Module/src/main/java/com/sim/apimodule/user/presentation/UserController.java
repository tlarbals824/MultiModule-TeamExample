package com.sim.apimodule.user.presentation;

import com.sim.apimodule.user.application.UserService;
import com.sim.apimodule.user.dto.request.UserCreateRequest;
import com.sim.apimodule.user.dto.request.UserLoginRequest;
import com.sim.apimodule.user.dto.request.UserUpdateRequest;
import com.sim.apimodule.user.dto.response.UserDetailsResponse;
import com.sim.apimodule.user.dto.response.UserLoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public void createUser(@RequestBody UserCreateRequest request){
        userService.createUser(request);
    }

    @PostMapping("/login")
    public UserLoginResponse loginUser(@RequestBody UserLoginRequest request){
        return userService.loginUser(request);
    }

    @PatchMapping
    public void updateUser(@RequestBody UserUpdateRequest request){
        userService.updateUser(request);
    }

    @GetMapping("/{userId}")
    public UserDetailsResponse getUserDetails(@PathVariable Long userId){
        return userService.getUserDetails(userId);
    }
}
