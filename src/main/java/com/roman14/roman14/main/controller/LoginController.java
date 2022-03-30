package com.roman14.roman14.main.controller;

import com.roman14.roman14.main.entity.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/login")
public class LoginController
{
  public String loginPage(HttpServletRequest request, HttpServletResponse response)
  {
    final UserVO loginUser = (UserVO) request.getSession().getAttribute("user");


    return "/login.html";
  }
}
