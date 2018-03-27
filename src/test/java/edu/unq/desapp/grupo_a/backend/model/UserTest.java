package edu.unq.desapp.grupo_a.backend.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import edu.unq.desapp.grupo_a.backend.model.User;

public class UserTest {


    @Test
    public void testUserName(){
    	//Only a proof
        User user = new User();
        user.setName("Charlie");
        assertEquals(user.getName(), "Charlie");
    }
    
    @Test
    public void testUserCuil() {
    	User user = new User();
    	user.setCuil("20-11111111-3");
    	assertEquals(user.getCuil(), "20-11111111-3");
    }

}
