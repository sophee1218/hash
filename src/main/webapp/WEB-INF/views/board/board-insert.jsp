<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="/board/insert" onsubmit="return vali()">
제목 : <input type="text" name="hb_title" id="hb_title"><br>
내용 : <textarea cols=30 rows=10 name="hb_content" id="hb_content"></textarea><br>
해쉬태그 : <input type="text" name="ht_hash" id="ht_hash" onkeypress="checkHash()"><br>
<button>글쓰기</button>
</form>
<script>

function checkHash(){
	// 35=#, 32=space 일 경우 이벤트 프리벤트시킴
	if(event.keyCode==35 || event.keyCode==32){
		event.preventDefault();	
	}
		
}
function vali(){
	if(document.querySelector('#hb_title').value.trim().length<1){
		alert('제목은 최소 1글자');
		return false;
	}
	if(document.querySelector('#hb_content').value.trim().length<1){
		alert('내용은 최소 1글자');
		return false;
	}
}
</script>
</body>
</html>