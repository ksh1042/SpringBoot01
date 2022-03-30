package com.roman14.roman14.main.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "TB_USER_INFO")
public class UserVO
{
  @Id
  @Column(name = "USER_ID")
  private String userId;

  @Column(name = "PASSWORD")
  private String password; // !!DEVELOP ONLY!!

  @Column(name = "FIRST_NAME")
  private String firstName;

  @Column(name = "LAST_NAME")
  private String lastName;

  @Column(name = "SEX")
  private String sex;

  @Column(name = "REGIST_DATE")
  private Date registDate;

  @Column(name = "MODIFY_DATE")
  private Date modifyDate;

  /** 사용 중지된 계정의 여부 */
  @Column(name = "IS_USE")
  private String isUse;

  @OneToMany
  @JoinColumn(name = "USER_ID")
  private List<UserHistoryVO> userHistory;

}
