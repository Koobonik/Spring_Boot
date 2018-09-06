function check() {
    document.getElementById("same").innerHTML="비밀dfs번호가 일치하지 않습니다.";
    var pw = document.getElementById("userpassword").value;
    var pw2 = document.getElementById("userpassword2").value;
    if (pw.length < 12 || pw.length >= 25) {
        window.alert("비밀번호는 12글자 이상, 25글자 이하만 이용 가능 합니다.");
        document.getElementById("userpassword").value = document.getElementById("userpassword2").value = "";
        document.getElementById("same").innerHTML = "으아아아아";
    }
    if(document.getElementById("userpassword").value!="" && document.getElementById("userpassword2").value!=""){
        if(document.getElementById(pw).value == document.getElementById(pw2).value){
            document.getElementById("same").innerHTML='비밀번호가 일치합니다.';
            document.getElementById("same").style="blue";
        }
        else {
            document.getElementById("same").innerHTML='비밀번호가 일치하지 않습니다.';
            document.getElementById("same").style="red";
        }
    }
}