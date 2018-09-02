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
    private String useraccount;
    private String userpassword;

    @Builder
    public AccountSaveRequestDto(Long usernum, String useraccount, String userpassword) {
        this.usernum = usernum;
        this.useraccount = useraccount;
        this.userpassword = userpassword;
    }

    public Account toEntity(){
        return Account.builder()
                .usernum(usernum)
                .useraccount(useraccount)
                .userpassword(userpassword)
                .build();
    }
}