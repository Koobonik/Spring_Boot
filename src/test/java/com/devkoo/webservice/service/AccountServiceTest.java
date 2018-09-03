package com.devkoo.webservice.service;

import com.devkoo.webservice.domain.account.Account;
import com.devkoo.webservice.domain.account.AccountRepository;
import com.devkoo.webservice.dto.account.AccountSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {
    long a = 23;
    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @After
    public void cleanup () {
        accountRepository.deleteAll();
    }

    @Test
    public void Dto데이터가_account테이블에_저장된다 () {
        //given
        AccountSaveRequestDto dto = AccountSaveRequestDto.builder()
                .usernum(a)
                .userid("테스트 유저 아이디")
                .useremail("유저 이메일")
                .userpassword("테스트 패스워드")
                .build();

        //when
        accountService.save(dto);

        //then
        Account account= accountRepository.findAll().get(0);
        //assertThat(account.getusernum()).isEqualTo(dto.getusernum());
        //assertThat(account.getuserpassword()).isEqualTo(dto.getuserid());
        assertThat(account.getUserpassword()).isEqualTo(dto.getUserpassword());

    }


}
