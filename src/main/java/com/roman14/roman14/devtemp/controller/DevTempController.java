package com.roman14.roman14.devtemp.controller;

import com.roman14.roman14.devtemp.entity.DevTemp;
import com.roman14.roman14.devtemp.service.DevTempService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>DevTempController</b>
 * <pre>
 *   - 처음 사용해보는 JPA/Vue.js의 간단한 CRUD 테스트를 위한 컨트롤러 클래스
 * </pre>
 */
@Controller
@RequestMapping("/devTemp")
public class DevTempController
{
  // 순환참조 방지를 위해 @Autowired 사용 지양
  private final DevTempService devTempService;

  public DevTempController(DevTempService devTempService)
  {
    this.devTempService = devTempService;
  }

  /**
   * 입력 및 조회 화면 호출
   * @return
   */
  @GetMapping("/view")
  public String devTempView(Model model)
  {
    return "/devTemp/devTemp.html";
  }

  /**
   * 데이터 호출
   * @return
   */
  @GetMapping("/get")
  public ResponseEntity<List<DevTemp>> devTempGet()
  {
    return ResponseEntity.ok().body(devTempService.devTempGet());
  }

  /**
   * 단순 입력 테스트
   * @param devTemp
   * @return
   */
  @PostMapping("/add")
  public ResponseEntity<?> devTempAdd(@RequestBody DevTemp devTemp)
  {
    devTempService.devTempInsert(devTemp);
    return ResponseEntity.ok().body(null);
  }

  /**
   * 튜플 삭제 테스트
   * @param devTemp
   * @return
   */
  @DeleteMapping("/delete")
  public ResponseEntity<?> devTempDelete(@RequestBody DevTemp devTemp)
  {
    devTempService.devTempDelete(devTemp);
    return ResponseEntity.ok().body(null);
  }
}
