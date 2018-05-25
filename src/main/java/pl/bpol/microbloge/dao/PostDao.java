package pl.bpol.microbloge.dao;

import pl.bpol.microbloge.model.Post;

public interface PostDao {

    boolean addNewPost(Post newPost);

    boolean updatePost(Post userPost);

    boolean deletePost(Post userPost);

}
