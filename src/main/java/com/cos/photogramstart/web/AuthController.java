package com.cos.photogramstart.web;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignupDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequiredArgsConstructor //final 필드를 DI 할때 사용
public class  AuthController {

   // private static final Logger log = (Logger) LoggerFactory.getLogger(AuthController.class);
    private final AuthService authService;

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
    public @ResponseBody String signup(@Valid SignupDto signupDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            Map<String,String> errorMap = new HashMap<>();
            for(FieldError error : bindingResult.getFieldErrors()){
                errorMap.put(error.getField(),error.getDefaultMessage());
              //  System.out.println(error.getDefaultMessage());
            }
            throw new CustomValidationException("유효성검사 실패함",errorMap);
        }
     //   log.info(signupDto.toString());
        User user = signupDto.toEntity();
        User userEntity =authService.회원가입(user);
        System.out.println(userEntity);
        return "auth/signin";
    }
//    @PostMapping("/auth/signup")
//    public @ResponseBody String join(SignupDto signupDto) {
//        authService.회원가입(signupDto.toEntity());
//        return  "/auth/signin";
//    }
}
