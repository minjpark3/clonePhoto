package com.cos.photogramstart.handler.ex;

import lombok.Getter;

import java.util.Map;
@Getter
public class CustomValidationException extends RuntimeException{
    //객체를 구분할때 씀
    private static final long serialVersionUID = 1L;

   // private String massage;
    private Map<String,String> errorMap;

    public CustomValidationException(String massage, Map<String,String> errorMap){
        super(massage);
       // this.massage = massage;
        this.errorMap = errorMap;
    }
//    public Map<String,String>getErrorMap(){
//        return errorMap;
//    }

}
