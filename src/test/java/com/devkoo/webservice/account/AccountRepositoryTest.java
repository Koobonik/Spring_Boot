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
    long a = 23;
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
            .usernum(a)
            .userid("테스트 유저 아이디")
            .useremail("유저 이메일")
            .userpassword("테스트 패스워드")
            .build());

        //when
        List<Account> accountList = accountRepository.findAll();

        //then
        Account account = accountList.get(0);
        //assertThat(account.getUsernum(), is(a));
        assertThat(account.getUserid(), is("테스트 유저 아이디"));
        assertThat(account.getUserpassword(), is("테스트 패스워드"));
    }
    @Test
    public void BaseTimeEntity_등록(){
        // given
        LocalDateTime now = LocalDateTime.now();
        accountRepository.save(Account.builder()
                .usernum(a)
                .userid("테스트 유저 아이디")
                .useremail("유저 이메일")
                .userpassword("테스트 패스워드")
                .build());

        // when
        List<Account> accountList = accountRepository.findAll();

        // then
        Account account = accountList.get(0);
        assertTrue(account.getCreatedDate().isAfter(now));
        assertTrue(account.getModifiedDate().isAfter(now));
    }
}
