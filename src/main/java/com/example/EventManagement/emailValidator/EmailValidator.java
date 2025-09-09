package com.example.EventManagement.emailValidator;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class EmailValidator {

    //проверка корректности введенного эмейла через регулярку
    public boolean isValid(String userMail) {
        String reg = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        Pattern pattern = Pattern.compile(reg);
        return pattern.matcher(userMail).matches();
    }

}
