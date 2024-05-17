package net.breezeware;

import org.concordion.api.ConcordionFixture;
import org.concordion.api.FullOGNL;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
@FullOGNL
public class UserTest {

    public String createUser(String userName, String email) {
        System.out.println(userName);
        System.out.println("Hello "+userName);
        return "User Created";
    }

    public String createUserWithInvalidDetails(String userName, String email){
        if(userName==null || userName.isBlank()){
            return "Invalid User Details";
        }

        return "User Created";
    }

}
