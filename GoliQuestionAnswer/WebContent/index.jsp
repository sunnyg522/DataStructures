
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.goli.com.Question" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@page import="java.util.ArrayList" %>
<%

ArrayList <String >question = new ArrayList<String>();
ArrayList <String>answer = new ArrayList<String>();
//setting Questions.
question.add("What is the capital of california");
question.add("what is the capital of New York");
question.add("what is the capital of North Carolina");
question.add("what is the capital of south dakota");
question.add("what is the capital of Washington");

//setting answers.
answer.add("sacramento");
answer.add("newyork");
answer.add("reliagh");
answer.add("pierre");
answer.add("olympia");
int ind = (int) (Math.random() * 3);
%>

</head>
<body>
<%  
//String qu = q.getRandomQuestion();

%>


<script >


function checkAnswer(){
	
	var ans = document.getElementById(answer).value;
	var correct = <%= answer.get(ind) %>
	
	if(ans == null){
		alert("enter the value");
	}
	if(correct==ans){
		alert("correct answer");
		document.getElementById('question').style.display = "block";
		document.getElementById('resultTrue').style.display = "visible";
		
		
	}
	else{
		alert("wrong answer");
		document.getElementById('question').style.display = "block";
		document.getElementById('resultFalse').style.display = "visible";
	}
	function result(){
		document.getElementById('question').style.display = "visible";
		document.getElementById('resultFalse').style.display = "block";
		document.getElementById('resultTrue').style.display = "block";
	}
	
}


</script>



<div id=question>
<form >
<%=   question.get(ind) %>
  Answer: <input type="text" name="answer" id="answer"><br>
  <input type="button" value="Result" onclick="checkAnswer()">
</form>
</div>
<div id=resultTrue style="visibility: hidden">
Your Answer is true
 <input type="button" value="Next Question" onclick="result()">
</div>

<div id=resultFalse style="visibility: hidden">
Your Answer is False correct answer is <%=   answer.get(ind) %>
 <input type="button" value="Next Question" onclick="result()">
</div>
</body>
</html>