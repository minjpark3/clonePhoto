package com.cos.photogramstart.web;

import com.cos.photogramstart.web.dto.auth.SignupDto;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.logging.Logger;


@Controller
public class AuthController {

   // private static final Logger log = (Logger) LoggerFactory.getLogger(AuthController.class);

    @GetMapping("/auth/signin")
    public String signinForm(){
        return "auth/signin";
    }


    @GetMapping("/auth/signup")
    public String signupForm(){
        return "auth/signup";
    }

    //회원가입버튼을 누르면 /a~/signup에서 /au~/signin으로 넘어가야됨
    @PostMapping("/auth/signup")
    public String signup(SignupDto signupDto){
     //   log.info(signupDto.toString());
        return "auth/signin";
    }
}
