package pl.bpol.microbloge.model;

import java.util.List;
import java.util.Objects;

public class Wall {

    private List<Post> wallPosts;

    public Wall() {
    }

    public Wall(List<Post> wallPosts) {
        this.wallPosts = wallPosts;
    }

    public List<Post> getWallPosts() {
        return wallPosts;
    }

    public void setWallPosts(List<Post> wallPosts) {
        this.wallPosts = wallPosts;
    }

    @Override
    public String toString() {
        return "Wall{" +
                "wallPosts=" + wallPosts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wall wall = (Wall) o;
        return Objects.equals(wallPosts, wall.wallPosts);
    }

    @Override
    public int hashCode() {

        return Objects.hash(wallPosts);
    }
}
