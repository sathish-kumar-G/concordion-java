package net.breezeware;

import lombok.val;
import net.breezeware.entity.User;
import org.concordion.api.FullOGNL;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@RunWith(ConcordionRunner.class)
@FullOGNL
public class SplittingNamesTest {
    List<String> strings = new ArrayList<>();



    public User split(String fullName) {
        User result = new User();
        String[] words = fullName.split(" ");
        result.setFirstName(words[0]);
        result.setLastName(words[1]);
        return result;
    }

    public void setUpUser(String username) {
        strings.add(username);
    }

    public List<String> getSearchResultsFor(String searchString) {
        List<String> list = strings.stream().filter(s -> s.contains(searchString)).toList();

        return list;
    }
}
