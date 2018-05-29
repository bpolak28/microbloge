package pl.bpol.microbloge.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private long id;
    private String note;
    private Date creationDate;
    private PostStatus postStatus;
    private PostType postType;
    private User postAuthor;

    public Post() {
    }

    public Post(String note, Date creationDate, PostStatus postStatus, PostType postType, User postAuthor) {
        this.note = note;
        this.creationDate = creationDate;
        this.postStatus = postStatus;
        this.postType = postType;
        this.postAuthor = postAuthor;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public PostStatus getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(PostStatus postStatus) {
        this.postStatus = postStatus;
    }

    public PostType getPostType() {
        return postType;
    }

    public void setPostType(PostType postType) {
        this.postType = postType;
    }

    public User getPostAuthor() {
        return postAuthor;
    }

    public void setPostAuthor(User postAuthor) {
        this.postAuthor = postAuthor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(note, post.note) &&
                Objects.equals(creationDate, post.creationDate) &&
                postStatus == post.postStatus &&
                postType == post.postType &&
                Objects.equals(postAuthor, post.postAuthor);
    }

    @Override
    public int hashCode() {

        return Objects.hash(note, creationDate, postStatus, postType, postAuthor);
    }

    @Override
    public String toString() {
        return "Post{" +
                "note='" + note + '\'' +
                ", creationDate=" + creationDate +
                ", postStatus=" + postStatus +
                ", postType=" + postType +
                ", postAuthor=" + postAuthor +
                '}';
    }
}
