package people;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) throws IOException {
		
		PeopleList network = PeopleList.getInstance();
		
		Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
 
            System.out.println("1. Load people into the network");
            System.out.println("2. Load relationships");
            System.out.println("3. Print out people");
            System.out.println("4. Search a user");
            System.out.println("5. Log out");
 
            try {
 
                System.out.println("Chose an option:");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("You have selected: Load people into the network");
                        network.readtext();
                        System.out.println("People have been loaded inte the network");
                        break;
                    case 2:
                        System.out.println("You have selected: Load relationships");
                        network.readFriends();
                        break;
                    case 3:
                        System.out.println("You have selected: Print out people");
                        network.printPeople();
                        break;
                    case 4:
                        System.out.println("You have selected: Search a user");
                        break;
                    case 5:
                    	System.out.println("You have selected: Log out");
                    	System.exit(0);
                        salir = true;
                        break;
                    default:
                        System.out.println("Only numbers between 1-5");
                }
            } catch (InputMismatchException e) {
                System.out.println("You must insert numbers");
                sn.next();
            }
        }
        sn.close();
	}

}
