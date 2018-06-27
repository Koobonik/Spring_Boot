package com.devkoo.webservice.web;

import com.devkoo.webservice.domain.posts.Posts;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDto{
    private String title;
    private String content;
    private String author;

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
