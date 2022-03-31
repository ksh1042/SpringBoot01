package com.roman14.roman14.devtemp.controller;

import com.roman14.roman14.devtemp.entity.DevTemp;
import com.roman14.roman14.devtemp.repository.DevTempRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevTempService
{
  // 순환참조 방지를 위해 @Autowired 사용 지양
  private final DevTempRepository devTempRepository;

  public DevTempService(DevTempRepository devTempRepository)
  {
    this.devTempRepository = devTempRepository;
  }

  /**
   * DEV_TEMP 전체 데이터 조회
   * @return - devTemp
   */
  public List<DevTemp> devTempGet()
  {
    return devTempRepository.findAll( Sort.by(Sort.Direction.ASC, "seq") );
  }

  /**
   * DEV_TEMP 데이터 삽입
   * @param devTemp
   */
  public void devTempInsert(DevTemp devTemp)
  {
    devTempRepository.save(devTemp);
  }

  /**
   * DEV_TEMP 데이터 삭제
   * @param devTemp
   */
  public void devTempDelete(DevTemp devTemp) { devTempRepository.delete(devTemp); }


}
