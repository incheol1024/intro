package me.about.intro.entity;

import me.about.intro.dto.PostDto;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "POST_TBL")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    long id;

    @Column(name = "title")
    String title;

    @Column(name = "content")
    String content;

    @Column(name = "create_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd kk:mm:ss")
    LocalDateTime createDate;

    @Column(name = "update_date")
    LocalDateTime updateDate;

    @Column(name = "author")
    String author;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id &&
                Objects.equals(title, post.title) &&
                Objects.equals(content, post.content) &&
                Objects.equals(createDate, post.createDate) &&
                Objects.equals(updateDate, post.updateDate) &&
                Objects.equals(author, post.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, createDate, updateDate, author);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Post.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("title='" + title + "'")
                .add("content='" + content + "'")
                .add("createDate=" + createDate)
                .add("updateDate=" + updateDate)
                .add("author='" + author + "'")
                .toString();
    }

    public PostDto toDto() {
        PostDto postDto = new PostDto();
        postDto.setId(this.id);
        postDto.setTitle(this.title);
        postDto.setContent(this.content);
        postDto.setCreateDate(this.createDate);
        postDto.setCreateDate(this.updateDate);
        postDto.setAuthor(this.author);
        return postDto;
    }
}
