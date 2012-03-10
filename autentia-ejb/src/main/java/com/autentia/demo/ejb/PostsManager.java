package com.autentia.demo.ejb;

import com.autentia.demo.ejb.domain.Post;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jaime
 * Date: 4/03/12
 * Time: 12:19 AM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface PostsManager {

    /**
     * The com.autentia.demo.ejb.domain.Post#fechaPublicado attribute will be overriden by this method
     *
     * @param post
     * @return
     */
    Post savePost(Post post);


    /**
     * Get all posts ordered by date, from latest (index 0) to older (last index)
     *
     * @return
     */
    List<Post> getAllPosts();
}
