package edu.unq.desapp.grupo_a.backend.model;

import org.junit.Test;
import static org.mockito.Mockito.*;

import edu.unq.desapp.grupo_a.backend.model.builders.UserBuilder;
import edu.unq.desapp.grupo_a.backend.model.exceptions.UserInitException;
import static org.junit.Assert.*;

public class UserTest {
	
    @Test
    public void testUserName() {
        User user = (User) UserBuilder.anUser()
        		.withName("Charlie")
        		.build();
        assertEquals(user.getName(), "Charlie");
    }
    
    @Test (expected = UserInitException.class)
    public void testUserNameNull() {
    	UserBuilder.anUser()
    		.withName(null)
    		.build();
    }

    @Test (expected = UserInitException.class)
    public void testUserNameEmpty() {
    	UserBuilder.anUser()
    		.withName("")
    		.build();
    }
    
    @Test (expected = UserInitException.class)
    public void testUserNameWithSpaces() {
    	UserBuilder.anUser()
    		.withName("   ")
    		.build();
    }
    
    @Test
    public void testUserCuil() {
    	User user = (User) UserBuilder.anUser()
    			.withCuil("20-11111111-3")
    			.build();
    	assertEquals(user.getCuil(), "20-11111111-3");
    }

    @Test
    public void testUserEmail() {
    	User user = (User) UserBuilder.anUser()
    			.withEmail("charlie@zolezzi.com")
    			.build();
    	assertEquals(user.getEmail(), "charlie@zolezzi.com");
    }
    
    @Test
    public void testUserInitialReputation() {
    	//when a User is initialized
    	//then its reputation is 0 (zero)
    	User user = (User) UserBuilder.anUser()
    			.build();
    	assertEquals(Double.valueOf(user.getReputation()), Double.valueOf(0));
    }
}
