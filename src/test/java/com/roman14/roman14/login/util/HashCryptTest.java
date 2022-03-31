package com.roman14.roman14.login.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DisplayName("해시 암호화 유틸")
class HashCryptTest
{

  @Test
  @DisplayName("해시 암호화")
  void encrypt()
  {
    final String message        = "abcd";
    final String exceptedResult = "2B22A9986AFF26F9568F02D8BF8346580EA6D49EA3C3B7D17698784A67513A63";
    final long salt             = 4593200548957554529L;

    String result    = "";
    boolean isExcept = false;

    try
    {
      result = HashCrypt.getInstance().encrypt(message, salt);
    }
    catch ( NoSuchAlgorithmException e )
    {
      isExcept = true;
    }

    assertFalse(isExcept);
    assertEquals(result, exceptedResult);
  }
}