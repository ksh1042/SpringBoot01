package com.roman14.roman14.login.service;

import com.roman14.roman14.login.entity.UserVO;
import com.roman14.roman14.login.util.HashCrypt;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@SpringBootTest
@Transactional
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
@DisplayName("로그인 서비스")
class LoginServiceTest
{
  @Autowired
  private UserService userService;
  @Autowired
  private LoginService loginService;

  private static final String USER_ID = "develop";
  private static final UserVO USER    = new UserVO();

  @Test
  @BeforeEach
  @DisplayName("테스트 계정 생성")
  void init() throws NoSuchAlgorithmException
  {
    final long salt = new SecureRandom().nextLong();

    USER.setUserId(USER_ID);
    USER.setPassword( HashCrypt.getInstance().encrypt("develop001", salt) );
    USER.setSalt(salt);
    USER.setFirstName("Young Hee");
    USER.setLastName("Kim");
    USER.setIsUse('T');
    USER.setSex("F");

    Assertions.assertAll(
      () -> userService.addUser(USER)
    );
  }

  @Test
  @DisplayName("아이디 존재여부 검색")
  void checkExist()
  {
    Assertions.assertTrue( loginService.checkExist(USER_ID) );
  }

}