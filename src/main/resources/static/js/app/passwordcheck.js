function check() {
    var pw = document.getElementById("userpassword").value; // 변수의 크기 측정을 위해 사용될 변수
    var pw2 = document.getElementById("userpassword2").value; // 변수의 크기 측정을 위해 사용될 변수

    // 비밀번호의 크기는 12글자 이상 25글자 이하면 가능! 조금 줄일까 생각중
    if ( (pw.length < 8 || pw.length >= 20) && (pw2.length < 8 || pw2.length >= 20) ) {
        window.alert("비밀번호는 12글자 이상, 20글자 이하만 이용 가능 합니다.");
        document.getElementById("userpassword").value = document.getElementById("userpassword2").value = "";
        document.getElementById("same").innerHTML = "8글자 이상 25글자 이하로 입력해주세요.";
        document.getElementById("same").style.color="red";
    }

    // 공백이 아니라면
    if(document.getElementById("userpassword").value!="" && document.getElementById("userpassword2").value!=""){

        // 같다면 일치한다고 출력
        if(document.getElementById("userpassword").value == document.getElementById("userpassword2").value){
            document.getElementById("same").innerHTML="비밀번호가 일치합니다.";
            document.getElementById("same").style.color="blue";
        }

        // 아니라면 일치하지 않는다고 출력
        else {
            document.getElementById("same").innerHTML="비밀번호가 일치하지 않습니다.";
            document.getElementById("same").style.color="red";
        }
    }
}