package com.roman14.roman14.login.service;

import com.roman14.roman14.login.entity.UserVO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;

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

    Assertions.assertTrue( loginService.selectUserId(userId) );
  }

  @Test
  @Transactional
  @DisplayName("사용자 생성")
  @Order(2)
  void addUser()
  {
    final UserVO user = new UserVO();

    final String userId = "develtop001";
    final String passwordMsg = "develtop001";
    final String salt = String.valueOf(new SecureRandom().nextLong());

    String password = null;// TODO --> password = SHA-256( passwordMsg + salt );

    user.setUserId(userId);
    user.setPassword(password);
    user.setSalt(salt);

    Assertions.assertTrue( loginService.addUser(user) );
  }

  //@Transactional
}