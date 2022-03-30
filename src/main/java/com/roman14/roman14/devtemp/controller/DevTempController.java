package com.roman14.roman14.devtemp.controller;

import com.roman14.roman14.devtemp.entity.DevTemp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

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
   * @return null
   */
  @GetMapping("/view")
  public String devTempView(Model model)
  {
    return "/devTemp/devTemp.html";
  }

  /**
   * 데이터 호출
   * @return @Responsebody
   */
  @GetMapping("/get")
  @ResponseBody
  public List<DevTemp> devTempGet()
  {
    return devTempService.devTempGet();
  }

  /**
   * 단순 입력 테스트
   * @return
   */
  @PostMapping("/add")
  public RedirectView devTempAdd(@RequestBody DevTemp devTemp)
  {
    devTempService.devTempInsert(devTemp);

    return new RedirectView("view");
  }

}
