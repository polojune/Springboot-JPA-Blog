package com.cos.blog.controller.api;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;

@RestController
public class UserApiController {
       
	@Autowired
	  private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	  @PostMapping("/auth/joinProc")
	   public ResponseDto<Integer> save (@RequestBody User user) {
		   System.out.println("UserApiController: save 호출" );
		   //실제로 DB에 insert를 하고 아래에서 return		     	
		    userService.회원가입(user);
		  return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	   }
/*	  
	  @PostMapping("/api/user/login")
	  public ResponseDto<Integer> login(@RequestBody User user, HttpSession session){
		     System.out.println("UserApiController: login 호출 ");
		      User principal = userService.로그인(user);
		      
		      if(principal != null) {
		    	   session.setAttribute("principal", principal);
		      }
		     return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	  }
	  */
	  @PutMapping("/user")
	  public ResponseDto<Integer> update(@RequestBody User user){
		      userService.회원수정(user); 
		      //여기서는 트랜잭션이 종료되기 때문에 DB값은 변경 되었고 
		      // 세션값은 변경 되지 않은 상태 이기 때문에 직접 세션값을 변경해줘야 함 
		      
		      Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		      SecurityContextHolder.getContext().setAuthentication(authentication);
		      return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	  }
}
