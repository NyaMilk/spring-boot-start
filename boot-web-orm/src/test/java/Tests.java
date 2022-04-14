import org.example.Application;
import org.example.model.Users;
import org.example.repository.UserRepository;
import org.example.service.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class Tests {
    @Autowired
    private UsersService usersService;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testUser() {
        boolean success = usersService.checkForTest("Test2");
        assertTrue(success);

        Users user = userRepository.findByFirstname("Test1");
        assertEquals("testTestTestTestTestTestTestTestTest", user.getLastname());
    }
}
