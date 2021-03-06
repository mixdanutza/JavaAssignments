package com.daniela.belt.validator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.daniela.belt.models.User;
import com.daniela.belt.services.UserService;


@Component
public class UserValidator implements Validator {
	UserService userService;
	
	public UserValidator(UserService userService) {
		this.userService=userService;
	}
	
	
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	public static final Pattern VALID_NAME_REGEX = 
		    Pattern.compile("^[a-zA-Z\\\\s]*$", Pattern.CASE_INSENSITIVE);

    //  1
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    
    // 2
    @Override
    public void validate(Object object, Errors errors) {
        User user = (User) object;
        Matcher matcher=VALID_EMAIL_ADDRESS_REGEX.matcher(user.getEmail());
        if(matcher.find()==false) {
        	errors.rejectValue("email", "Regex");
        }
        
        Matcher matchUsername=VALID_NAME_REGEX.matcher(user.getUsername());
        if(matchUsername.find()==false) {
        	errors.rejectValue("username", "Regex");
        }
        
        if(user.getPassword().length()<6) {
        	errors.rejectValue("password","Size");
        }
        
    	if (!user.getPasswordConfirm().equals(user.getPassword())) {
    		// 3
    		errors.rejectValue("passwordConfirm", "Match");
    	}  
    	
    	User usernameUser=userService.findByUsername(user.getUsername());
    	if (usernameUser != null) {
    		errors.rejectValue("username", "Unique");
    	}
    	
    	
    	
    }
    
    
}