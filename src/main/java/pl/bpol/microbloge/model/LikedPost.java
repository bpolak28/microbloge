package pl.bpol.microbloge.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class LikedPost {

    @Id
    @GeneratedValue
    private long id;
    private User who;
    private Post likedPost;
    private Date date;


    public LikedPost() {
    }

    public LikedPost(User who, Post likedPost, Date date) {
        this.who = who;
        this.likedPost = likedPost;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getWho() {
        return who;
    }

    public void setWho(User who) {
        this.who = who;
    }

    public Post getLikedPost() {
        return likedPost;
    }

    public void setLikedPost(Post likedPost) {
        this.likedPost = likedPost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LikedPost likedPost1 = (LikedPost) o;
        return Objects.equals(who, likedPost1.who) &&
                Objects.equals(likedPost, likedPost1.likedPost) &&
                Objects.equals(date, likedPost1.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(who, likedPost, date);
    }

    @Override
    public String toString() {
        return "LikedPost{" +
                "who=" + who +
                ", likedPost=" + likedPost +
                ", date=" + date +
                '}';
    }
}
