package com.roman14.roman14.login.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
@DisplayName("로그인 서비스")
class LoginServiceTest
{
  @Autowired
  private LoginService loginService;

  @Test
  @DisplayName("아이디 존재여부 검색")
  @Order(1)
  void selectUserId()
  {
    final String userId = "develop";

    Assertions.assertTrue(loginService.selectUserId(userId));
  }

  //@Transactional
}