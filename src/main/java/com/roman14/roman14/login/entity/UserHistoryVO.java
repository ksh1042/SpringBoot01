package com.roman14.roman14.login.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * <h2>UserHistoryVO</h2>
 * <pre>
 *   - TABLE : DEVELOP.TB_USER_INFO_HISTORY
 *   - 사용자 변경 이력 테이블
 * </pre>
 */
@Entity
@Data
@Table(name = "TB_USER_INFO_HISTORY")
public class UserHistoryVO
{
  /** 사용자 변경이력 id */
  @Id
  @SequenceGenerator(name = "userHistoryInfoSeq", sequenceName = "SEQ_USER_INFO_SEQ")
  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "userHistoryInfoSeq")
  @Column(name = "SEQ")
  private String seq;

  /** 사용자 아이디 */
  @Column(name = "USER_ID")
  private String userId;

  /** 사용자 이름 */
  @Column(name = "FIRST_NAME")
  private String firstName;

  /** 사용자 성(姓) */
  @Column(name = "LAST_NAME")
  private String lastName;

  /** 사용자 성별 */
  @Column(name = "SEX")
  private String sex;

  /** 사용자 정보가 변경된 날짜 */
  @Column(name = "ADD_TIME")
  private Date addTime;

  /** 기타 내용 */
  @Column(name = "DESCRIPTIONS")
  private String descriptions;

  /** 사용 중지 여부 */
  @Column(name = "IS_USE")
  private boolean isUse;

}
