package edu.unq.desapp.grupo_a.backend.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

import edu.unq.desapp.grupo_a.backend.model.User;
import edu.unq.desapp.grupo_a.backend.model.exceptions.UserInitException;
import edu.unq.desapp.grupo_a.backend.utils.ErrorHandler;

@Service
public class UserValidator {
	
	@Autowired
	ErrorHandler errorHandler;
	
	//@Autowired
	//Logger logger;
	
	public UserValidator() {
		
	}
	
	public void validationUserName(User user) {
		
		//logger.info("Validacion de usuario con el nombre" + user.getName());
		
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            
        	throw new UserInitException();
        } 
		
	}
	
	public void validationUserCuil(User user){
        if (user.getCuil() == null || user.getCuil().trim().isEmpty()) {
          
        	throw new UserInitException();
        
        } 
	}
	
	public void validationUserEmail(User user){
       
		if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            throw new UserInitException();
        } 

	}
	
	public void validateAdrress(User user) {
	
		if(user.getAddress() == null) {
			throw new UserInitException();
		}
	}
	
	public void ValidateUser(User user) {
		validationUserName(user);
		validationUserCuil(user);
		validationUserEmail(user);
		validateAdrress(user);
	}

}
