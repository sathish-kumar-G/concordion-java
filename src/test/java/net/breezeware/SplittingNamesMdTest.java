package net.breezeware;

import net.breezeware.entity.User;
import org.concordion.api.FullOGNL;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
@FullOGNL
public class SplittingNamesMdTest {

    public User split(String fullName) {
        User result = new User();
        String[] words = fullName.split(" ");
        result.setFirstName(words[0]);
        result.setLastName(words[1]);
        return result;
    }
}
