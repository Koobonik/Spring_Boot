package com.devkoo.webservice.service;

import com.devkoo.webservice.domain.account.AccountRepository;
import com.devkoo.webservice.dto.account.AccountMainResponseDto;
import com.devkoo.webservice.dto.account.AccountSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AccountService {
    private AccountRepository accountRepository;

    @Transactional
    public Long save(AccountSaveRequestDto dto){
        return accountRepository.save(dto.toEntity()).getUsernum();
    }

    // 트랜잭션 범위는 유지하되, 조회 기능만 남겨두어 조회 속도를 개선함
    // 그렇기에 특별히 등록, 수정, 삭제 기능이 없는 메소드에서 사용하는걸 추천함
    @Transactional(readOnly = true)
    public List<AccountMainResponseDto> findAllDesc() {
        return accountRepository.findAllDesc()
                .map(AccountMainResponseDto::new)
                .collect(Collectors.toList());
    }
}