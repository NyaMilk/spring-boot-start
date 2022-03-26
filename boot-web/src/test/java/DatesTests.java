import org.example.Application;
import org.example.model.DateResponse;
import org.example.repositories.DateRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.List;

@SpringBootTest(classes = Application.class)
public class DatesTests {
    @Autowired
    private DateRepository dateRepository;

    @Test
    @DisplayName("Check type")
    public void checkDateType() {
        List<DateResponse> dateResponseList = dateRepository.findAll();
        System.out.println(dateResponseList);

        dateResponseList.forEach(dateResponse -> {
            Assertions.assertTrue(dateResponse.getName() instanceof String);
            Assertions.assertTrue(dateResponse.getCreateat() instanceof Timestamp);
        });
    }
}
