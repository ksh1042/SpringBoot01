package com.roman14.roman14.devtemp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class DevTemp
{
  @Id
  @SequenceGenerator(name = "devTempSeq", sequenceName = "SEQ_DEV_TEMP_SEQ", schema = "DEVELOP")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "devTempSeq")
  private long seq;

  private String x;

}