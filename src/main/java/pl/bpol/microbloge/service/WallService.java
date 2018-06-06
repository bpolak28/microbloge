package pl.bpol.microbloge.service;

import pl.bpol.microbloge.model.Post;
import pl.bpol.microbloge.model.Wall;

import java.util.List;

public class WallService {
    private Wall wall;

    public WallService() {
    }

    public WallService(Wall wall) {
        this.wall = wall;
    }

    public Wall getWall() {
        return wall;
    }

    public void setWall(Wall wall) {
        this.wall = wall;
    }

    public List<Post> sortedDatePosts(){
        List<Post> wallPosts = wall.getWallPosts();
        return wallPosts;
    }
}
