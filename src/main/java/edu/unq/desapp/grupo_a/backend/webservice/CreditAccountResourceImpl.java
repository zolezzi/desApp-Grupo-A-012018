package edu.unq.desapp.grupo_a.backend.webservice;

import edu.unq.desapp.grupo_a.backend.api.CreditAccountResource;
import edu.unq.desapp.grupo_a.backend.dto.UserDto;
import edu.unq.desapp.grupo_a.backend.model.CreditAccount;
import edu.unq.desapp.grupo_a.backend.model.User;
import edu.unq.desapp.grupo_a.backend.service.UserService;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Produces("application/json")
@Consumes("application/json")
@Path("/credit-amount")
public class CreditAccountResourceImpl implements CreditAccountResource {

    private UserService userService;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public Double getCreditAmount(Long userId) {

        User user = userService.getUser(userId);

        return user.getCreditAccount().getCurrentAmount();
    }

	@Override
	@Transactional
	public UserDto addCredit(Long userId, Double amount) {
        User user = userService.getUser(userId);
        
        user.setCreditAccount(createCreditAmount(user));
        
        user.addCredit(amount);

        userService.update(user);
        
        return user.toDto();
		
	}

	@Override
	@Transactional
	public UserDto loseCredit(Long userId, Double amount) {
        User user = userService.getUser(userId);
        
        user.loseCredit(amount);

        userService.update(user);
        
        return user.toDto();
		
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public ModelMapper getModelMapper() {
		return modelMapper;
	}

	public void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	private CreditAccount createCreditAmount(User user) {
		
		CreditAccount creditAccount = new CreditAccount();
		creditAccount.setUser(user);
		
		return creditAccount;
	}
}
