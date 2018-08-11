package edu.unq.desapp.grupo_a.backend.validators;

import edu.unq.desapp.grupo_a.backend.model.User;
import edu.unq.desapp.grupo_a.backend.model.exceptions.UserInitException;
import edu.unq.desapp.grupo_a.backend.utils.ErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserValidator extends Validator {
	
	@Autowired
	ErrorHandler errorHandler;

	public UserValidator() {
		
	}
	
	private void validationUserName(User user) throws UserInitException {

        if (user.getName() == null || user.getName().trim().isEmpty()) {
            
        	throw new UserInitException("Nombre invalido");
        } 
		
	}

	private void validationUserCuil(User user) throws UserInitException {
        if (user.getCuil() == null || user.getCuil().trim().isEmpty()) {
          
        	throw new UserInitException("CUIL invalido");
        
        } 
	}
	
	private void validationUserEmail(User user) throws UserInitException {
       
		if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            throw new UserInitException("E-mail invalido");
        }
	}
	
	public void validateUser(User user) throws UserInitException{
		validationUserName(user);
		validationUserCuil(user);
		validationUserEmail(user);
	}

	@Override
	public void validate(Object object) throws ExceptionInInitializerError {
		User user = (User) object;
		validateUser(user);
	}
}
