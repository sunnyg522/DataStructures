import java.util.Scanner;
import static java.lang.System.out;

public class Ship 
{
  String ShipName;
  String Build;

  public Ship() 
  {
	
    ShipName = null;
    Build = null;
  }

public String getShipName() {
	return ShipName;
}

public void setShipName(String shipName) {
	ShipName = shipName;
}

public String getBuild() {
	return Build;
}

public void setBuild(String build) {
	Build = build;
}
 

public void printShip()
{
    Scanner sc = new Scanner(System.in);
    ShipName = sc.nextLine();
    Build = sc.nextLine();
    System.out.print("Ship name :"+ShipName );
    System.out.println(" Build :" +Build);
}
}