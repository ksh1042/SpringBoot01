package com.roman14.roman14.login.controller;

import com.roman14.roman14.login.entity.UserVO;
import com.roman14.roman14.login.service.LoginService;
import com.roman14.roman14.login.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginRestController
{
  private final UserService userService;
  private final LoginService loginService;

  public LoginRestController(UserService userService, LoginService loginService)
  {
    this.userService = userService;
    this.loginService = loginService;
  }

  @GetMapping("/login/checkExist")
  public ResponseEntity<Boolean> loginCheckExist(@RequestBody UserVO user)
  {
    return ResponseEntity.ok().body(userService.isExist(user.getUserId()));
  }
}
