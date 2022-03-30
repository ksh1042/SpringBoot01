package com.roman14.roman14.main.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_USER_INFO_HISTORY")
public class UserHistoryVO
{
  @Id
  @Column(name = "SEQ")
  private String seq;

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

  @Column(name = "ADD_TIME")
  private Date addTime;

  @Column(name = "DESCRIPTIONS")
  private String descriptions;

  /** 사용 중지된 계정의 여부 */
  private boolean isUse;;

}
