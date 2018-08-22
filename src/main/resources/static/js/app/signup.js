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
            userpasswd: $('#userpasswd').val(),
            useremail: $('#useremail').val()
        };

        $.ajax({
            type: 'POST',
            url: '/posts',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('회원가입이 완료되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(error);
        });
    }

};

signup.init();