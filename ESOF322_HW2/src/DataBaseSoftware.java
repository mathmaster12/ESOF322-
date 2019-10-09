//Marielle Korringa and Janet Madrid
//ESOF 332 HW 2
// Abstract class for Databases
import java.util.Scanner;

public abstract class DataBaseSoftware {
	StoreBehavior storeBehavior;
	public DataBaseSoftware(){
	}
	//Perform store algorithm 
	public void performStore(){
		storeBehavior.store();
	}
	//Change the type of store algorithm used by database
	public void setPerformStore(StoreBehavior sb){
		storeBehavior = sb;
	}
	
	//main method to execute the program
	public static void main(String args[]){
		boolean choice = false;
		DataBaseSoftware dataBaseSoftware = null;
		//User decides which type of database they want to use
		System.out.println("Please enter the type of database you want to use (Relational, NoSQL, or Graph): ");
		while(choice == false){ 
			Scanner input = new Scanner(System.in);
			String dataBase = input.next(); 
			//Relational database choice
			if(dataBase.compareTo("Relational") == 0 || dataBase.compareTo("relational") == 0){
				dataBaseSoftware = new Relational();
				System.out.println("The default store algorithm for the Relational database system is the table store.");
				choice = true;
			}
			//NoSQL database choice
			else if(dataBase.compareTo("NoSQL") == 0 || dataBase.compareTo("noSQL") == 0 || dataBase.compareTo("SQL") == 0) {
				dataBaseSoftware = new NoSQL();
				System.out.println("The default store algorithm for the NoSQL database system is the document store.");
				choice = true;
			}
			//Graph database choice
			else if(dataBase.compareTo("Graph") == 0 || dataBase.compareTo("graph") == 0){
				dataBaseSoftware = new Graph();
				System.out.println("The default store algorithm for the Graph database system is the node store.");
				choice = true;
			}
			else{
				System.out.println("Error 1! Please try again.");
			}
		}
		System.out.println("Do you wish to change the algorithm? Y/N ");
		Boolean b = false;
		while(b == false){ //User decides to either keep or change store algorithm being used
			Scanner input2 = new Scanner(System.in);
			String maybe = input2.next();
			if(maybe.compareTo("Y") == 0 || maybe.compareTo("Yes") == 0 || maybe.compareTo("y") == 0){
				Boolean d = false;
				while(d == false){
					System.out.println("Do you want to use the table store, document store, or node store?");
					Scanner input3 = new Scanner(System.in);
					String decided = input3.nextLine();
					//table store algorithm choice
					if(decided.compareTo("Table Store") == 0 || decided.compareTo("table store") == 0 || decided.compareTo("Table") == 0 || decided.compareTo("table") == 0){
						dataBaseSoftware.setPerformStore(new TableStore());
						dataBaseSoftware.performStore();
						d = true;
					}
					//document store algorithm choice
					else if(decided.compareTo("Document Store") == 0 || decided.compareTo("document store") == 0 || decided.compareTo("Document") == 0 || decided.compareTo("document") == 0){
						dataBaseSoftware.setPerformStore(new DocumentStore());
						dataBaseSoftware.performStore();
						d = true;
					}
					//node store algorithm choice
					else if(decided.compareTo("Node Store") == 0 || decided.compareTo("node store") == 0 || decided.compareTo("Node") == 0 || decided.compareTo("node") == 0){
						dataBaseSoftware.setPerformStore(new NodeStore());
						dataBaseSoftware.performStore();
						d = true;
					}
					else{
						System.out.println("Error 3! Please try again.");
					}
				}
				b = true;
			}
			else if(maybe.compareTo("N") == 0 || maybe.compareTo("No") == 0 || maybe.compareTo("n") == 0){
				dataBaseSoftware.performStore();
				b = true;
			}
			else{
				System.out.println("Error 2! Please try again.");
			}
		}
	}
}

