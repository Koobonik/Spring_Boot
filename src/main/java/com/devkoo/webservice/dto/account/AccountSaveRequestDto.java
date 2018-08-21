package com.devkoo.webservice.dto.account;

import com.devkoo.webservice.domain.account.Account;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by jojoldu@gmail.com on 2017. 12. 27.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@Getter
@Setter
@NoArgsConstructor
public class AccountSaveRequestDto {

    private Long userid;
    private String useraccount;
    private String userpasswd;

    @Builder
    public AccountSaveRequestDto(Long userid, String useraccount, String userpasswd) {
        this.userid = userid;
        this.useraccount = useraccount;
        this.userpasswd = userpasswd;
    }

    public Account toEntity(){
        return Account.builder()
                .userid(userid)
                .useraccount(useraccount)
                .userpasswd(userpasswd)
                .build();
    }
}