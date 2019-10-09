//Marielle Korringa and Janet Madrid
//ESOF 332 HW 2
// Class for relational database
public class Relational extends DataBaseSoftware{
	public Relational(){
		System.out.println("You have picked the Relational database software.");
		storeBehavior = new TableStore(); 
	}
}
