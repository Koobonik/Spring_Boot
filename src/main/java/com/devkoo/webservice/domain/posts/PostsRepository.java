package com.devkoo.webservice.domain.posts;

import com.devkoo.webservice.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}
