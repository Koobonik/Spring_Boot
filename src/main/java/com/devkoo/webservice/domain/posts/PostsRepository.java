package com.devkoo.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.stream.Stream;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    /*
    그냥 SpringDataJpa에서 제공하는 기본 메소드 만으로도 해결할 수 있지만
    굳이 @Query를 쓴 이유는 SpringDataJpa에서 제공하지 않는 메소드는 밑에처럼 쿼리로 작성해도
    되는 것을 보여주기 위해서 이다.
    */
    @Query("SELECT p " +
            "FROM Posts p " +
            "ORDER BY p.id DESC")
    Stream<Posts> findAllDesc();
}
