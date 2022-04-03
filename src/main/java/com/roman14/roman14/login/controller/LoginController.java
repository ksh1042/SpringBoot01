package com.roman14.roman14.login.controller;

import com.roman14.roman14.login.entity.UserVO;
import com.roman14.roman14.login.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Controller
@RequestMapping("/login")
public class LoginController
{
  private final LoginService loginService;

  public LoginController(LoginService loginService)
  {
    this.loginService = loginService;
  }

  /**
   * 로그인 뷰 호출
   * @param session
   * @return
   */
  @GetMapping("")
  public String loginView(final HttpSession session)
  {
    final Optional<UserVO> loginUser = Optional.ofNullable( (UserVO) session.getAttribute("user") );

    if(!loginUser.isPresent())
      return "/login/view.html";
    else
      return "/main";

  }

  /**
   * 로그인
   * @param userId
   * @param password
   * @param session
   * @return
   */
  public String login(@RequestParam("userId") final String userId, @RequestParam("password") final String password, final HttpSession session)
    throws NoSuchAlgorithmException
  {
    final Optional<UserVO> loginUser = loginService.checkLogin(userId, password);

    String returnUrl = "";

    if(loginUser.isPresent())
    {
      // success
      session.setAttribute("user", loginService.login(userId, password));
      returnUrl = "/main";
    }

    return returnUrl;
  }

  /**
   * 로그아웃
   * @param session
   * @return
   */
  @PostMapping("/logout")
  public String logout(final HttpSession session)
  {
    session.invalidate();
    return "/login";
  }

}
