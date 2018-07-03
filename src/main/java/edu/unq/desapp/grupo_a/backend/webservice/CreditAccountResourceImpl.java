package edu.unq.desapp.grupo_a.backend.webservice;

import edu.unq.desapp.grupo_a.backend.api.CreditAccountResource;
import edu.unq.desapp.grupo_a.backend.model.User;
import edu.unq.desapp.grupo_a.backend.service.UserService;
import org.modelmapper.ModelMapper;

public class CreditAccountResourceImpl implements CreditAccountResource {

    private UserService userService;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public double getCreditAmount(long userId) {

        User user = userService.getUser(userId);

        return user.getCreditAccount().getCurrentAmount();
    }

    @Override
    public void addCredit(long userId, double amount) {

        User user = userService.getUser(userId);
        user.addCredit(amount);

        userService.update(user);
    }

    @Override
    public void loseCredit(long userId, double amount) {

        User user = userService.getUser(userId);
        user.loseCredit(amount);

        userService.update(user);
    }
}
