package com.roman14.roman14.login.util;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Locale;

/**
 * <h2>HashCrypt</h2>
 * <pre>
 *   - 단방향 암호화를 위한 유틸 클래스
 *   - 싱글톤 인스턴스
 * </pre>
 * @since 2022.03.31
 */
public final class HashCrypt
{
  private static volatile HashCrypt INSTANCE;

  private static final String ALGORITHM = "SHA-256";

  private HashCrypt() {}

  public static HashCrypt getInstance()
  {
    if(INSTANCE == null)
    {
      synchronized ( HashCrypt.class )
      {
        if(INSTANCE == null)
        {
          INSTANCE = new HashCrypt();
        }
      }
    }
    return INSTANCE;
  }

  /**
   * 입력된 message를 지정된 hash 알고리즘을 통해 암호화된 16진수 문자열로 변환
   * SecureRandom 클래스의 nextLong 메서드를 통해 salt 값 자동 생성
   * @param message 암호화 할 문자열
   * @return 암호화된 16진수 문자열
   * @throws NoSuchAlgorithmException
   */
  public String encrypt(String message) throws NoSuchAlgorithmException
  {
    return this.encrypt(message, new SecureRandom().nextLong());
  }

  /**
   * 입력된 message를 salt와 조합하여 지정된 hash 알고리즘을 통해 암호화된 16진수 문자열로 변환
   * @param message 암호화 할 문자열
   * @param salt 8비트 정수 문자열(ex. new SecureRandom().nextLong())
   * @return 암호화된 16진수 문자열
   * @throws NoSuchAlgorithmException
   */
  public String encrypt(String message, long salt) throws NoSuchAlgorithmException
  {
    return hexToString( MessageDigest.getInstance(ALGORITHM)
      .digest((message + salt).getBytes(StandardCharsets.UTF_8)));
  }

  /**
   * 바이트 배열을 16진수 문자열로 변환
   * @param bytes
   * @return
   */
  private String hexToString(byte [] bytes)
  {
    final StringBuilder sb = new StringBuilder();

    for(byte b : bytes)
    {
      String hexStr = Integer.toString(b & 0xff, 16);
      if(hexStr.length() < 2)
      {
        sb.append('0');
      }
      sb.append(hexStr);
    }

    return sb.toString().toUpperCase(Locale.ROOT);
  }
}
