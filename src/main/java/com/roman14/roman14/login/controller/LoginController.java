package com.roman14.roman14.login.controller;

import com.roman14.roman14.login.entity.UserVO;
import com.roman14.roman14.login.service.LoginService;
import com.roman14.roman14.login.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Controller
@RequestMapping("/login")
public class LoginController
{
  private final LoginService loginService;
  private final UserService userService;

  public LoginController(LoginService loginService, UserService userService)
  {
    this.loginService = loginService;
    this.userService = userService;
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
      return "/login/login.html";
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
  @PostMapping("")
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

  /**
   * 회원가입 뷰 호출
   * @return
   */
  @GetMapping("/signIn")
  public String signInView()
  {
    return "/login/signIn.html";
  }

  /**
   * 회원가입
   * @param user
   * @return
   */
  @PostMapping("/signIn")
  public ResponseEntity<?> signIn(@RequestBody UserVO user)
  {
    if(!userService.isExist(user.getUserId()))
    {
      userService.addUser(user);
    }
    else
    {
      throw new IllegalArgumentException(user.getUserId() + " is already created");
    }

    return ResponseEntity.ok().body(null);
  }

}
