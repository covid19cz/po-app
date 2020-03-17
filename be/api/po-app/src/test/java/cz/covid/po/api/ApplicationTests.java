package cz.covid.po.api;

import cz.covid.po.api.app.Application;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

@SpringBootTest(classes = Application.class)
@Profile("test")
class ApplicationTests {

    @Test
    void contextLoads() {
    }

}
