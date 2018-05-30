package pl.bpol.microbloge.service;

import pl.bpol.microbloge.dao.PostDao;
import pl.bpol.microbloge.repository.PostRepository;

public class PostService {

    private PostRepository postRepository;

//    private PostDao postDao;

    public PostService() {
    }

//    public PostService(PostDao postDao) {
//        this.postDao = postDao;
//    }


    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


}
