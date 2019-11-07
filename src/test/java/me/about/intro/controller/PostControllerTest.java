package me.about.intro.controller;

import me.about.intro.dto.PostDto;
import me.about.intro.entity.Post;
import me.about.intro.util.CommonUtil;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest
public class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void beanNotNullTest() {
        Assertions.assertThat(mockMvc).isNotNull();
    }

    @Test
    public void findPost() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/post/find/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void registerPost() throws Exception {
        PostDto post = new PostDto();
        post.setId(0L);
        post.setTitle("title");
        post.setContent("content");
        LocalDateTime localDateTime = LocalDateTime.parse(LocalDateTime.of(2019, 11, 07, 13, 30).format(DateTimeFormatter.ISO_DATE_TIME));
        post.setCreateDate(localDateTime);
        post.setUpdateDate(localDateTime);
        post.setAuthor("author");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/post/register").content(CommonUtil.toJsonString(post)))
        .andDo(MockMvcResultHandlers.print());

    }
}