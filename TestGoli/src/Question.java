
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Question {

public static Random randomGenrator = new Random();
public  int index;
public static ArrayList <String >question = new ArrayList<String>();
public static ArrayList <String>answer = new ArrayList<String>();
//
public void setQuestionAnswers()
{
	//setting Questions.
	question.add("What is the capital of california");
	question.add("what is the capital of New York");
	question.add("what is the capital of x");
	question.add("what is the capital of y");
	question.add("what is the capital of z");
	
	//setting answers.
	answer.add("sacramento");
	answer.add("newyork");
	answer.add("x");
	answer.add("y");
	answer.add("z");
	}
public String getRandomQuestion()
{
	index = randomGenrator.nextInt(question.size());
	System.out.println(index);
	//index = 0;
	return question.get(index);
	}
public String getAnswer()
{
	return answer.get(index);
	}
	
}
