package com.devkoo.webservice.service;

import com.devkoo.webservice.domain.posts.PostsRepository;
import com.devkoo.webservice.dto.posts.PostsMainResponseDto;
import com.devkoo.webservice.dto.posts.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }

    // 트랜잭션 범위는 유지하되, 조회 기능만 남겨두어 조회 속도를 개선함
    // 그렇기에 특별히 등록, 수정, 삭제 기능이 없는 메소드에서 사용하는걸 추천함
    @Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());
    }
}