package pl.bpol.microbloge.service;

import pl.bpol.microbloge.dao.PostDao;

public class PostService {

    private PostDao postDao;

    public PostService() {
    }

    public PostService(PostDao postDao) {
        this.postDao = postDao;
    }

    public PostDao getPostDao() {
        return postDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public String toString() {
        return "PostService{" +
                "postDao=" + postDao +
                '}';
    }
}
