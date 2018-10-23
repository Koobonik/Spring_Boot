package com.devkoo.webservice.domain.account;

import com.devkoo.webservice.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자 자동 추가 // 기본 생성자의 접근 권한을 protected로 제한
@Getter // 클래스내 모든 필드의 Getter 메소드를 자동생성
@Entity // 테이블과 링크될 클래스 + 언더스코어 네이밍으로 이름 매칭 ex ) SalesManager -> sales_manager table

// 데이터 베이스를 만드는 jpa 기능임
public class Account extends BaseTimeEntity{
    @Id // 해당 테이블의 PK 필드를 나타냄
    @GeneratedValue // PK의 생성 규칙을 나타냄
    private  Long usernum; //유저 수
    // 테이블의 컬럼을 나타내면 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 됨
    // 사용하는 이유는 기본값 외에 추가로 변경이 필요한 옵션이 있을경우 사용함
    // 문자열의 경우 VARCHAR(255)가 기본값인데, 사이즈를 500으로 늘리고 싶거나(ex: title), 타입을 TEXT로 변경하고 싶거나

    //@Column(length = 50, nullable = false)
    //private String id;

    // 아이디 이메일 패스워드
    // 이값들이 null 이면 회원가입 안됨.
    @Column(columnDefinition = "TEXT", nullable = false)
    private String userid;
    private String useremail;
    private String userpassword;



    // 해당 클래스의 빌더 패턴 클래스를 생성
    @Builder
    public Account(Long usernum, String userid, String useremail, String userpassword){
        this.usernum = usernum;
        this.userid = userid;
        this.useremail = useremail;
        this.userpassword = userpassword;
    }
}
