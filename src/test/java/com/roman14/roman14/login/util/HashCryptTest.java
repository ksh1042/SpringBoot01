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
    final String message = "abcd";
    final String exceptedResult = "88D4266FD4E6338D13B845FCF289579D209C897823B9217DA3E161936F031589";

    boolean isExcept = false;
    String result  = "";
    try
    {
      result = HashCrypt.getInstance().encrypt(message);
    }
    catch ( NoSuchAlgorithmException e )
    {
      isExcept = true;
    }

    assertFalse(isExcept);
    assertEquals(result, exceptedResult);
  }
}