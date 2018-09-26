var main = { // main 이라는 객체를 만드는 것임.
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
    },
    save : function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST', // type은 변함 없음
            url: '/posts', // 이게 중요함
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data) // data 를 이쪽으로 보냄
        }).done(function() {
            alert('글이 등록되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(error);
        });
    }

};

main.init();