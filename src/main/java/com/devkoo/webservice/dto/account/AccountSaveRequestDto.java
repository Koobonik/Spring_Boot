package com.devkoo.webservice.dto.account;

import com.devkoo.webservice.domain.account.Account;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class AccountSaveRequestDto {

    private Long usernum;
    private String userid;
    private String userpassword;

    @Builder
    public AccountSaveRequestDto(Long usernum, String userid, String userpassword) {
        this.usernum = usernum;
        this.userid = userid;
        this.userpassword = userpassword;
    }

    public Account toEntity(){
        return Account.builder()
                .usernum(usernum)
                .userid(userid)
                .userpassword(userpassword)
                .build();
    }
}