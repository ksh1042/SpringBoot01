package com.roman14.roman14.login.service;

import com.roman14.roman14.login.entity.UserHistoryVO;
import com.roman14.roman14.login.entity.UserVO;
import com.roman14.roman14.login.repository.UserHistoryRepository;
import com.roman14.roman14.login.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService
{
  private final UserRepository userRepository;
  private final UserHistoryRepository userHistoryRepository;

  public UserService(UserRepository userRepository, UserHistoryRepository userHistoryRepository)
  {
    this.userRepository = userRepository;
    this.userHistoryRepository = userHistoryRepository;
  }

  /**
   * 사용자 아이디를 통한 사용자 중복 확인
   * @param userId
   * @return null=true, notNull=false
   */
  public boolean isExist(String userId)
  {
    return !userRepository.findById(userId).isPresent();
  }

  /**
   * 사용자 조회
   * @param userId
   */
  @Transactional
  public Optional<UserVO> getUser(String userId)
  {
    return userRepository.findById(userId);
  }
  /**
   * 사용자 등록
   * @param user
   * @return
   */
  @Transactional
  public void addUser(UserVO user)
  {
    if( userRepository.existsById(user.getUserId()) )
      throw new RuntimeException("user already exist : " + user.getUserId());

    final UserHistoryVO userHistoryVO = new UserHistoryVO(user);
    userHistoryVO.setAddTime(LocalDateTime.now());
    userHistoryVO.setDescriptions("add");

    userRepository.save(user);
    userHistoryRepository.save(userHistoryVO);
  }

  /**
   * 사용자 수정
   * @param user
   */
  @Transactional
  public void updateUser(UserVO user)
  {
    if( !userRepository.existsById(user.getUserId()) )
      throw new RuntimeException("there was no user : " + user.getUserId());

    final UserHistoryVO userHistoryVO = new UserHistoryVO(user);
    userHistoryVO.setAddTime(LocalDateTime.now());

    userRepository.save(user);
    userHistoryRepository.save(userHistoryVO);
  }

  /**
   * 사용자 삭제(상태 변경으로 물리적 삭제는 아님)
   * @param user
   */
  @Transactional
  public void deleteUser(UserVO user)
  {
    if( !userRepository.existsById(user.getUserId()) )
      throw new RuntimeException("there was no user : " + user.getUserId());

    user.setIsUse('F');

    final UserHistoryVO userHistoryVO = new UserHistoryVO(user);
    userHistoryVO.setAddTime(LocalDateTime.now());
    userHistoryVO.setDescriptions("delete");

    userRepository.save(user);
    userHistoryRepository.save(userHistoryVO);
  }
}
