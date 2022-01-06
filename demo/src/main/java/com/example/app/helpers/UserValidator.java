package com.example.app.helpers;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.app.models.SiteUser;
import com.example.app.services.SiteUserService;

@Component
public class UserValidator implements Validator
{
    @Autowired
    private SiteUserService userService;
    
    @Override
    public boolean supports(Class<?> aClass) {
        return SiteUser.class.equals(aClass);
    }
    
    @Override
    public void validate(Object obj, Errors errors) {
        SiteUser siteUser = (SiteUser) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty");
        int userNameLen = siteUser.getUserName().length();
        if (userNameLen < 6 || userNameLen > 32) {
            errors.rejectValue("userName", "Size.userForm.username");
        }
        if (userService.findByUserName(siteUser.getUserName()) != null) {
            errors.rejectValue("userName", "Duplicate.userForm.username");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        int passwordLen = siteUser.getPassword().length();
        if (passwordLen < 8 || passwordLen > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }
        if (!siteUser.getPasswordConfirm().equals(siteUser.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
}
