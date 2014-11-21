import static java.lang.System.out;
public class main {

public static void main(String[] args)
{
	Ship [] shiparray = new Ship[3];	
   
	Ship ship1 = new Ship();
	shiparray[0] = ship1;
    
	CruiseShip cruise = new CruiseShip();
	shiparray[1] = cruise;
    
	CargoShip cargo = new CargoShip();
	shiparray[2] = cargo;
	
	shiparray[0].printShip();
	shiparray[1].printShip();
    shiparray[2].printShip();
}

}
