package com.roman14.roman14.login.controller;

import com.roman14.roman14.login.entity.UserVO;
import com.roman14.roman14.login.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginRestController
{
  private final LoginService loginService;

  public LoginRestController(LoginService loginService)
  {
    this.loginService = loginService;
  }

  @GetMapping("/login/checkExist")
  public ResponseEntity<Boolean> loginCheckExist(@RequestBody UserVO user)
  {
    return ResponseEntity.ok().body(loginService.selectUserId(user.getUserId()));
  }
}
