package me.about.intro.repository;

import me.about.intro.entity.Home;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HomeRepositoryTest {

    @Autowired
    HomeRepository homeRepository;

    @Test
    public void notNullTest() {
        Assertions.assertThat(homeRepository).isNotNull();
    }

    @Test
    public void insertTest() {

        Home home = new Home();
        home.setHomeDescr("home descr");
        home.setHomeTitle("home title");
        home = homeRepository.save(home);

    }

    @Test
    public void selectTest() {
        Home expectedHome = new Home();
        expectedHome.setHomeTitle("home title");
        expectedHome.setHomeDescr("home descr");
        Assertions.assertThat(homeRepository.findById("home title").orElseThrow(() -> new RuntimeException()))
                .isEqualTo(expectedHome);
    }

}
