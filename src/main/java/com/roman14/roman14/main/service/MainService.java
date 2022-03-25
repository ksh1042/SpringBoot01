package com.roman14.roman14.main.service;

import com.roman14.roman14.main.repository.DevTempRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class MainService
{
  @Autowired
  private DevTempRepository devTempRepository;

  public final String selectX(String x)
  {
    return devTempRepository.getById(x).getX();
  }
}
