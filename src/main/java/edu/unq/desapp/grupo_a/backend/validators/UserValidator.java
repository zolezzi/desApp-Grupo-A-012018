package edu.unq.desapp.grupo_a.backend.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

import edu.unq.desapp.grupo_a.backend.model.User;
import edu.unq.desapp.grupo_a.backend.model.exceptions.UserInitException;
import edu.unq.desapp.grupo_a.backend.utils.ErrorHandler;

@Service
public class UserValidator extends Validator {
	
	@Autowired
	ErrorHandler errorHandler;

	public UserValidator() {
		
	}
	
	public void validationUserName(User user) throws UserInitException {

        if (user.getName() == null || user.getName().trim().isEmpty()) {
            
        	throw new UserInitException();
        } 
		
	}

	public void validationUserCuil(User user) throws UserInitException {
        if (user.getCuil() == null || user.getCuil().trim().isEmpty()) {
          
        	throw new UserInitException();
        
        } 
	}
	
	public void validationUserEmail(User user) throws UserInitException {
       
		if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            throw new UserInitException();
        } 

	}
	
	public void validateAdrress(User user) throws UserInitException {
	
//		if(user.getAddress() == null) {
//			throw new UserInitException();
//		}
	}
	
	public void validateUser(User user) throws UserInitException{
		validationUserName(user);
		validationUserCuil(user);
		validationUserEmail(user);
		validateAdrress(user);
	}

	@Override
	public void validate(Object object) throws ExceptionInInitializerError {
		User user = (User) object;
		validateUser(user);
	}
}
