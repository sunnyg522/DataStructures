import java.util.Scanner;
import static java.lang.System.out;

public class CruiseShip extends Ship
{
  int passengers;



public CruiseShip() 
{
super();
passengers = 0;
}

public int getPassangers() {
	return passengers;
}

public void setPassangers(int passengers) {
	this.passengers = passengers;
}
  

public void printShip()
{
Scanner Sc = new Scanner(System.in);
ShipName = Sc.nextLine();
passengers = Sc.nextInt();	

System.out.print("CruiseShip Name: " +ShipName );
System.out.println(" Max passengers" +passengers);
}
	
	
}
