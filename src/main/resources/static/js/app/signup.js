var signup = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
    },
    save : function () {
        var data = {
            userid: $('#userid').val(),
            userpassword: $('#userpassword').val(),
            useremail: $('#useremail').val()
        };

        $.ajax({
            type: 'POST', // type은 변함 없음
            url: '/account', // 이게 중요함
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('회원가입이 완료되었습니다.');
            //location.reload();
            location.href="/";
        }).fail(function (error) {
            alert(error);
        });
    }

};

signup.init();