package com.roman14.roman14.main.controller;

import com.roman14.roman14.main.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public final class MainController
{
  @Autowired
  private MainService mainService;

  @GetMapping("/")
//  @ResponseBody
  public final String main(HttpServletRequest request, HttpServletResponse response)
  {
    return "/index.html";
  }

  @GetMapping("/viewTable")
  public final String viewTable(HttpServletRequest request, HttpServletResponse response)
  {
    request.setAttribute("getX", mainService.selectX("temp"));
    return "/view/table.html";
  }
}
