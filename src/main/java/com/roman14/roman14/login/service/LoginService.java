package com.roman14.roman14.login.service;

import com.roman14.roman14.login.entity.UserVO;
import com.roman14.roman14.login.repository.LoginHistoryRepository;
import com.roman14.roman14.login.repository.UserHistoryRepository;
import com.roman14.roman14.login.repository.UserRepository;
import com.roman14.roman14.login.util.HashCrypt;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class LoginService
{
  private final UserRepository userRepository;
  private final UserHistoryRepository userHistoryRepository;
  private final LoginHistoryRepository loginHistoryRepository;


  public LoginService(UserRepository userRepository, UserHistoryRepository userHistoryRepository, LoginHistoryRepository loginHistoryRepository)
  {
    this.userRepository = userRepository;
    this.userHistoryRepository = userHistoryRepository;
    this.loginHistoryRepository = loginHistoryRepository;
  }

  /**
   * 패스워드를 통한 사용자 로그인 체크
   * @param userId
   * @param password
   * @return
   */
  public Optional<UserVO> checkLogin(String userId, String password)
  {
    return userRepository.findById(userId).filter(user -> {
      boolean result = false;
      try
      {
        result = HashCrypt.getInstance()
          .encrypt(password, user.getSalt())
          .equals(user.getPassword());
      }
      catch ( NoSuchAlgorithmException e )
      {
        e.printStackTrace();
      }

      return result;
    });
  }

}
