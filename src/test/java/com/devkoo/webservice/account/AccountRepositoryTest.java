package com.devkoo.webservice.account;

import com.devkoo.webservice.domain.account.Account;
import com.devkoo.webservice.domain.account.AccountRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest

public class AccountRepositoryTest {
    @Autowired
    AccountRepository accountRepository;

    @After
    public void cleanup(){
        /**
         이후 테스트 코드에 영향을 끼치지 않기 위해
         테스트 메소드가 끝날때 마다 respository 전체 비우는 코드
         **/
        accountRepository.deleteAll();
    }

    @Test
    public void 아이디_불러오기(){
        //given
        accountRepository.save(Account.builder()
            .id("테스트 아이디")
            .passwd("테스트 패스워드")
            .email("테스트 이메일")
            .build());

        //when
        List<Account> accountList = accountRepository.findAll();

        //then
        Account account = accountList.get(0);
        assertThat(account.getId(), is("테스트 아이디"));
        assertThat(account.getPasswd(), is("테스트 패스워드"));
        assertThat(account.getEmail(), is("테스트 이메일"));
    }
}
