function check() {
    var pw = document.getElementById("userpassword").value;
    var pw2 = document.getElementById("userpassword2").value;
    if ( (pw.length < 12 || pw.length >= 25) && (pw2.length < 12 || pw2.length >= 25) ) {
        window.alert("비밀번호는 12글자 이상, 25글자 이하만 이용 가능 합니다.");
        document.getElementById("userpassword").value = document.getElementById("userpassword2").value = "";
        document.getElementById("same").innerHTML = "12글자 이상 25글자 이하로 입력해주세요.";
        document.getElementById("same").style.color="red";
    }
    if(document.getElementById("userpassword").value!="" && document.getElementById("userpassword2").value!=""){
        if(document.getElementById("userpassword").value == document.getElementById("userpassword2").value){
            document.getElementById("same").innerHTML="비밀번호가 일치합니다.";
            document.getElementById("same").style.color="blue";
        }
        else {
            document.getElementById("same").innerHTML="비밀번호가 일치하지 않습니다.";
            document.getElementById("same").style.color="red";
        }
    }
}