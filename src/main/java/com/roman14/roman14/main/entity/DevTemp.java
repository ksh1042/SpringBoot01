package com.roman14.roman14.main.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class DevTemp
{
  @Id
  @SequenceGenerator(name = "SEQ_DEV_TEMP_SEQ", sequenceName = "SEQ_DEV_TEMP_SEQ", schema = "DEVELOP", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private long seq;

  private String x;

}