package com.roman14.roman14.login.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <h2>UserVO</h2>
 * <pre>
 *   - TABLE : DEVELOP.TB_USER_INFO
 *   - 사용자 정보 VO
 * </pre>
 */
@Entity
@Data
@Table(name = "TB_USER_INFO")
public class UserVO
{
  @Id
  @Column(name = "USER_ID")
  private String userId;

  /** 암호화된 사용자 패스워드 */
  @Column(name = "PASSWORD")
  private String password;

  /** 암호화에 사용되는 salt */
  @Column(name = "SALT")
  private long salt;

  /** 사용자 이름 */
  @Column(name = "FIRST_NAME")
  private String firstName;

  /** 사용자 성(姓) */
  @Column(name = "LAST_NAME")
  private String lastName;

  /** 사용자 성별 */
  @Column(name = "SEX")
  private String sex;

  /** 사용자 생성 날짜 */
  @Column(name = "REGIST_DATE")
  private LocalDateTime registDate;

  /** 사용자의 마지막으로 수정 날짜 */
  @Column(name = "MODIFY_DATE")
  private LocalDateTime modifyDate;

  /** 사용 중지된 계정의 여부 */
  @Column(name = "IS_USE")
  private String isUse;

  /** 로그인 시도 이력 */
  @OneToMany
  @JoinColumn(name = "USER_ID")
  private List<UserHistoryVO> userHistory;

}
