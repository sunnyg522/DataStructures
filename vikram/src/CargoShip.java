import java.util.Scanner;
import static java.lang.System.out;

public class CargoShip extends Ship
{

	int capacity;
	
	public CargoShip() 
	{
	super();
	capacity=0;
	}




	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void printShip()
{
	Scanner Sc = new Scanner(System.in);
	ShipName = Sc.nextLine();
	capacity = Sc.nextInt();
	
	System.out.print("CargoShip Name: "+ShipName );
	System.out.println(" Capacity :" +capacity);
	
}
















}
