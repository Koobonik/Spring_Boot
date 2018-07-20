package com.devkoo.webservice.dto.posts;

import com.devkoo.webservice.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;


/*
Entity가 toDto와 같은 메소드로 dto를 반환하면 되지 않나? 라고 의문이 드실수 있다. 하지만 그렇게 하면 안된다.
DTO는 Entity를 사용해도 되지만, Entity는 DTO에 대해 전혀 모르게 코드를 구성해야함.
Entity는 말 그대로 가장 core한 클래스인 반면, DTO는 View 혹은 외부 요청에 관련 있는 클래스
Entity가 DTO를 사용하게 되면, 그때부터 View/외부요청에 따라 DTO뿐만 아니라 Entity까지 변경이 필요하게 됨.
또한, 다른 DTO도 필요하다고 하면 다시 Entity에 toDto2와 같은 메소드가 추가되는데, 모든 변화에 맞춰 Entity 변경이 필요하게 됨.
프로젝트 규모가 커져 프로젝트를 분리해야할때도 Entity가 DTO를 의존하고 있으면 분리하기가 굉장히 어렵기 때문에 DTO가 Entity에 의존하도록 코드를 꼭꼭 작성하시길 바람!
*/
@Getter
public class PostsMainResponseDto {
    private Long id;
    private String title;
    private String author;
    private String modifiedDate;

    public PostsMainResponseDto(Posts entity) {
        id = entity.getId();
        title = entity.getTitle();
        author = entity.getAuthor();
        modifiedDate = toStringDateTime(entity.getModifiedDate());
    }

    /**
     * Java 8 버전
     */
    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }

    /**
     * Java 7 버전

    private String toStringDateTimeByJava7(LocalDateTime localDateTime){
        if(localDateTime == null){
            return "";
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return formatter.format(localDateTime);
    }

     */
}