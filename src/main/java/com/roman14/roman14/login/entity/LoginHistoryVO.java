package com.roman14.roman14.login.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * <h2>LoginHistoryVO</h2>
 * <pre>
 *   - TABLE : DEVELOP.TB_LOGIN_HISTORY
 *   - 로그인 시도 기록 VO
 * </pre>
 */
@Entity
@Data
@Table(name = "TB_LOGIN_HISTORY")
public class LoginHistoryVO
{

  /** 로그인 시도 기록 id */
  @Id
  @SequenceGenerator(name ="loginHistorySeq", sequenceName = "SEQ_LOGIN_HISTORY_SEQ", schema = "DEVELOP")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loginHistorySeq")
  @Column(name = "SEQ", nullable = false)
  private long seq;

  /** 로그인 성공 여부 ('Y', 'N') */
  @Column(name = "LOGIN_STATUS")
  private char loginStatus;

  /** 로그인 시도에 사용된 사용자 ID */
  @Column(name = "USER_ID", nullable = false)
  private String userId;

  /** 로그인 시도에 사용된 IP 주소 */
  @Column(name = "IP_ADDRESS")
  private String ipAddress;

  /** 로그인 시도에 사용된 기기 */
  @Column(name = "DEVICE")
  private String device;

  /** 로그인 시도 날짜 */
  @Column(name = "ADD_TIME")
  private LocalDateTime addTime;

}
