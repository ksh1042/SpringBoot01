package com.roman14.roman14.login.service;

import com.roman14.roman14.login.entity.UserVO;
import com.roman14.roman14.login.repository.LoginRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService
{
  private final LoginRepository loginRepository;

  public LoginService(LoginRepository loginRepository)
  {
    this.loginRepository = loginRepository;
  }

  /**
   * 사용자 아이디를 통한 사용자 존재여부 확인
   * @param userId
   * @return null=false, notNull=true
   */
  public boolean selectUserId(String userId)
  {
    return loginRepository.findById(userId).isPresent();
  }

  /**
   * 사용자 등록
   * @param user
   * @return
   */
  public boolean addUser(UserVO user)
  {
    return Optional.of(loginRepository.save(user)).isPresent();
  }

}
