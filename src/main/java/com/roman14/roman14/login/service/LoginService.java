package com.roman14.roman14.login.service;

import com.roman14.roman14.login.entity.UserHistoryVO;
import com.roman14.roman14.login.entity.UserVO;
import com.roman14.roman14.login.repository.LoginHistoryRepository;
import com.roman14.roman14.login.repository.UserHistoryRepository;
import com.roman14.roman14.login.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
   * 사용자 아이디를 통한 사용자 존재여부 확인
   * @param userId
   * @return null=false, notNull=true
   */
  public boolean selectUserId(String userId)
  {
    return userRepository.findById(userId).isPresent();
  }

  /**
   * 사용자 등록
   * @param user
   * @return
   */
  @Transactional
  public void addUser(final UserVO user)
  {
    final UserHistoryVO userHistoryVO = new UserHistoryVO(user);
    userHistoryVO.setDescriptions("create");

    userRepository.save(user);
    userHistoryRepository.save(userHistoryVO);
  }

}
