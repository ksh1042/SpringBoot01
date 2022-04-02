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
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
@DisplayName("사용자 서비스")
class UserServiceTest
{
  @Autowired
  private UserService userService;

  @Nested
  @Transactional
  @DisplayName("아이디 중복 확인")
  class IsExist
  {
    private UserVO user;
    private String userId;

    @BeforeEach
    public void init() throws NoSuchAlgorithmException
    {
      final long   salt   = new SecureRandom().nextLong();

      this.user    = new UserVO();
      this.userId  = "#develop";

      this.user.setUserId(userId);
      this.user.setPassword( HashCrypt.getInstance().encrypt("develop001", salt) );
      this.user.setSalt(salt);
      this.user.setFirstName("Young Hee");
      this.user.setLastName("Kim");
      this.user.setIsUse('T');
      this.user.setSex("F");

      Assertions.assertAll(
        () -> userService.addUser(user)
      );
    }

    @Test
    @DisplayName("성공")
    public void success()
    {
      Assertions.assertFalse(
        userService.isExist(this.userId)
      );
    }
    @Test
    @DisplayName("실패")
    public void failed()
    {
      Assertions.assertTrue(
        userService.isExist("#anonymous")
      );
    }
  }

  @Nested
  @Transactional
  @DisplayName("사용자 조회")
  class getUser
  {
    private UserVO user;

    @BeforeEach
    public void init() throws NoSuchAlgorithmException
    {
      final long   salt   = new SecureRandom().nextLong();

      this.user = new UserVO();

      this.user.setUserId("#develop");
      this.user.setPassword( HashCrypt.getInstance().encrypt("develop001", salt) );
      this.user.setSalt(salt);
      this.user.setFirstName("Young Hee");
      this.user.setLastName("Kim");
      this.user.setIsUse('T');
      this.user.setSex("F");

      Assertions.assertAll(
        () -> userService.addUser(user)
      );
    }

    @Test
    @DisplayName("성공 케이스")
    public void success()
    {
      Assertions.assertTrue(
        userService.getUser(user.getUserId()).isPresent()
      );
    }

    @Test
    @DisplayName("실패 케이스")
    public void failedNoFound()
    {
      Assertions.assertFalse(
        userService.getUser("#anonymous").isPresent()
      );
    }

  }

  @Nested
  @Transactional
  @DisplayName("사용자 생성")
  class AddUser
  {

    private UserVO user;

    @BeforeEach
    public void init() throws NoSuchAlgorithmException
    {
      final long   salt   = new SecureRandom().nextLong();

      this.user = new UserVO();

      this.user.setUserId("#develop");
      this.user.setPassword( HashCrypt.getInstance().encrypt("develop001", salt) );
      this.user.setSalt(salt);
      this.user.setFirstName("Young Hee");
      this.user.setLastName("Kim");
      this.user.setIsUse('T');
      this.user.setSex("F");
    }

    @Test
    @DisplayName("성공 케이스")
    public void success()
    {
      Assertions.assertAll(
        () -> userService.addUser(user)
      );
    }

    @Test
    @DisplayName("PK 중복 실패 케이스")
    public void failedPK()
    {
      this.user.setUserId("ksh1042");

      Assertions.assertThrows(
        RuntimeException.class,
        () -> userService.addUser(user)
      );
    }
  }

  @Nested
  @Transactional
  @DisplayName("사용자 수정")
  class UpdateUser
  {
    
    private UserVO user;
    
    @BeforeEach
    public void init() throws NoSuchAlgorithmException
    {
      final long   salt   = new SecureRandom().nextLong();
      final String userId = "#develop";

      this.user = new UserVO();


      this.user.setUserId(userId);
      this.user.setPassword( HashCrypt.getInstance().encrypt("develop001", salt) );
      this.user.setSalt(salt);
      this.user.setFirstName("Young Hee");
      this.user.setLastName("Kim");
      this.user.setIsUse('T');
      this.user.setSex("F");

      Assertions.assertAll(
        () -> userService.addUser(user)
      );
    }

    @Test
    @DisplayName("성공 케이스")
    public void success() throws NoSuchAlgorithmException
    {
      final long salt = new SecureRandom().nextLong();

      user.setPassword( HashCrypt.getInstance().encrypt("develop002", salt) );
      user.setSalt(salt);

      Assertions.assertAll(
        () -> userService.updateUser(user)
      );
    }

    @Test
    @DisplayName("없는 사용자 실패 케이스")
    public void failedNoUser() throws NoSuchAlgorithmException
    {
      final long salt = new SecureRandom().nextLong();

      user.setUserId("#anonymous");
      user.setPassword( HashCrypt.getInstance().encrypt("develop002", salt) );
      user.setSalt(salt);

      Assertions.assertThrows(
        RuntimeException.class,
        () -> userService.updateUser(user)
      );
    }

  }

  @Nested
  @Transactional
  @DisplayName("사용자 삭제")
  class DeleteUser
  {
    private UserVO user;

    @BeforeEach
    public void init() throws NoSuchAlgorithmException
    {
      final long   salt   = new SecureRandom().nextLong();
      final String userId = "#develop";

      this.user = new UserVO();


      this.user.setUserId(userId);
      this.user.setPassword( HashCrypt.getInstance().encrypt("develop001", salt) );
      this.user.setSalt(salt);
      this.user.setFirstName("Young Hee");
      this.user.setLastName("Kim");
      this.user.setIsUse('T');
      this.user.setSex("F");

      Assertions.assertAll(
        () -> userService.addUser(user)
      );
    }

    @Test
    @DisplayName("성공 케이스")
    public void success()
    {
      Assertions.assertAll(
        () -> userService.deleteUser(user)
      );
    }
    @Test
    @DisplayName("없는 사용자 실패 케이스")
    public void failedNoUser()
    {
      user.setUserId("#anonymous");

      Assertions.assertThrows(
        RuntimeException.class,
        () -> userService.deleteUser(user)
      );
    }
  }

}