//Marielle Korringa and Janet Madrid
//ESOF 332 HW 2
// Class for NoSQL batabase
public class NoSQL extends DataBaseSoftware{
	public NoSQL(){
		System.out.println("You have picked the NoSQL database software.");
		storeBehavior = new DocumentStore();
	}
}
