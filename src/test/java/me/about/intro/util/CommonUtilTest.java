package me.about.intro.util;

import me.about.intro.entity.Post;
import org.junit.Test;

import java.time.LocalDateTime;

public class CommonUtilTest {

    @Test
    public void toJsonString() {
        Post post = new Post();
        post.setId(0L);
        post.setTitle("title");
        post.setContent("content");
        LocalDateTime localDateTime = LocalDateTime.of(2019, 11, 07, 13, 30);
        post.setCreateDate(localDateTime);
        post.setUpdateDate(localDateTime);
        post.setAuthor("author");
//        String expectedString = "{\"id\":0,\"title\":null,\"content\":null,\"createDate\":null,\"updateDate\":null,\"author\":null}";
        System.out.println(CommonUtil.toJsonString(post));
    }
}
