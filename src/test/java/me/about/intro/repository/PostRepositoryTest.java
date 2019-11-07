package me.about.intro.repository;

import me.about.intro.entity.Post;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.function.Predicate;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    public void beanNotNullTest() {
        Predicate<PostRepository> predicate = (postRepository) -> Objects.nonNull(postRepository);
        Assertions.assertThat(predicate);
    }

    @Test
    public void insertTest() {
        Post post = new Post();
        post.setTitle("post title");
        post.setContent("post content");
        post.setCreateDate(LocalDateTime.now());
        post.setUpdateDate(null);
        post.setAuthor("Hwang");

        postRepository.saveAndFlush(post);
    }
}
