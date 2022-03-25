package com.roman14.roman14.main.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class DevTemp
{
  private String x;

  public void setX(String x)
  {
    this.x = x;
  }

  @Id
  public String getX()
  {
    return x;
  }
}
