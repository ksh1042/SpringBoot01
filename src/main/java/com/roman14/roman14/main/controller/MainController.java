package com.roman14.roman14.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public final class MainController
{


  @GetMapping("/")
  public String main()
  {
    return "/index.html";
  }

  @GetMapping("/viewTable")
  public String viewTable(HttpServletRequest request)
  {
    return "/view/table.html";
  }


}
