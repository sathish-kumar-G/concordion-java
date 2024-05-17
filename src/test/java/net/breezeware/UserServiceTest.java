package net.breezeware;

import net.breezeware.dao.UserRepository;
import net.breezeware.entity.User;
import net.breezeware.service.UserService;
import org.concordion.api.FullOGNL;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.Instant;
import java.util.Optional;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(ConcordionRunner.class)
@FullOGNL
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService = new UserService();


    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public String createUser(String userName, String email) {
        User user = new User();
        user.setFirstName(userName);
        user.setEmail(email);
        user.setCreatedOn(Instant.now());
        user.setModifiedOn(Instant.now());
        when(userRepository.save(user)).thenReturn(user);
        String user1 = userService.createUser(user);
        return user1;
    }

    @Test
    public String deleteUser(String userName){
        User user = new User();
        user.setId(1);
        user.setFirstName("John Doe");
        user.setEmail("johndoe@gmail.com");

        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        doNothing().when(userRepository).deleteById(user.getId());

        String result = userService.deleteUser(user.getId());

        return result;
    }

    @Test
    public String updateUser(String userName, String email){
        User user = new User();
        user.setId(1);
        user.setFirstName(userName);
        user.setEmail(email);

        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        when(userRepository.save(user)).thenReturn(user);

        String result = userService.updateUser(user.getId(), user);

        return result;
    }

}
