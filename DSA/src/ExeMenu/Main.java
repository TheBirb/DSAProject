package ExeMenu;

import java.io.FileNotFoundException;
import java.util.Scanner;

import Exceptions.*;
import Social.*;
/**
 * class to represent the social network
 * @author iker pintado
 *
 */
public class Main {

	/**
	 * main method to interact with the console
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		SocialList soc=SocialList.getInstance();
		System.out.println("\n \u001B[33m"+"Write the name of the people file you want to upload"+"\u001B[0m");
		String name=s.nextLine();
		try {
			soc.addFromFile(name);
	
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\n \u001B[33m"+"well, now you are in. Press the number we tell you to do the desired task"+"\u001B[0m");
		boolean logout=false;
		String opt;
		while(!logout) {
			System.out.println("\u001B[33m"
					+ "-------------------------------------------------------"
					+ "\n|"+"\u001B[34m"+"Show someone큦 friends----1                          "+ "\u001B[33m"+"|"
					+ "\n|"+"\u001B[34m"+"show all the people of the network----2              "+ "\u001B[33m"+"|"
					+ "\n|"+"\u001B[34m"+"show the three most famous people----3               "+ "\u001B[33m"+"|"
					+ "\n|"+"\u001B[34m"+"check existence of someone----4                      "+ "\u001B[33m"+"|"
					+ "\n|"+"\u001B[34m"+"Print all the people of the network at a .txt----5   "+ "\u001B[33m"+"|"
					+ "\n|"+"\u001B[34m"+"print someone큦 data----6                            "+ "\u001B[33m"+"|"
					+ "\n|"+"\u001B[34m"+"Print all the relationships to a .txt----7           "+ "\u001B[33m"+"|"
					+ "\n|"+"\u001B[34m"+"add another people file----8                         "+ "\u001B[33m"+"|"
					+ "\n|"+"\u001B[34m"+"add relationships file----9                          "+ "\u001B[33m"+"|"
					+ "\n|"+"\u001B[34m"+"add a single person----10                            "+ "\u001B[33m"+"|"
					+ "\n|"+"\u001B[34m"+"add a relation-----11                                "+ "\u001B[33m"+"|"
					+ "\n|"+"\u001B[34m"+"remove a single person----12                         "+ "\u001B[33m"+"|"
					+ "\n|"+"\u001B[34m"+"remove a relationship----13                          "+ "\u001B[33m"+"|"
					+ "\n|"+"\u001B[34m"+"remove people from a .txt----14                      "+ "\u001B[33m"+"|"
					+ "\n|"+"\u001B[34m"+"remove relationships from a .txt----15               "+ "\u001B[33m"+"|"
					+ "\n|"+"\u001B[34m"+"log out with any other number                        "+ "\u001B[33m"+"|"
					+ "\n-------------------------------------------------------"+"\u001B[0m" );
			opt=s.nextLine();
			
			switch(opt) {
				case "1":
					someonesFriends(soc);
					break;
				case "2":
					soc.printPeople();
					break;
				case "3":
					try {
						for(int i=0; i<3;i++) {
							System.out.println(soc.mostPopular3()[i].toString());
						}
					} catch (NotEnoughPeopleException e) {
					
						System.out.println("\n \u001B[31m"+e.getMessage()+"\u001B[0m \n");
					}
				
					break;
				case "4":

					if(exist(soc))
						System.out.println("\n \u001B[32m"+"This person exists"+"\u001B[0m \n");
					else
						System.out.println("\n \u001B[31m"+"This person does not exist"+"\u001B[0m \n");
					
					break;
				case "5":
					soc.getTXT();
					
					break;
				case "6":
					findSomeone(soc);
					
					break;
				case "7":
					soc.getRelasTXT();
					
					break;
				case "8":
					newFile(soc);
					break;
				case "9":
					newRela(soc);
					break;
				case "10":
					register(soc);
					break;
				case "11":
					addFriend(soc);
					
					break;
				case "12":
					remove(soc);
					break;
				case "13":
					removeFriend(soc);
					break;
				case "14":
					removeFile(soc);
					break;
				case "15":
					removeRela(soc);
					break;
				default:
					System.out.println("\n \u001B[32m"+"See you soon!!!!"+"\u001B[0m");
					logout=true;
					break;
			}
		}
		
		s.close();
	}
	
	
	
	
	
	/**
	 * method to register a new person
	 * @param the network
	 */
	@SuppressWarnings("resource")
	public static void register(SocialList so) {
		Scanner s=new Scanner(System.in);
		String[] data=new String[11];
		Person per;
		System.out.println("\n \u001B[33m"+"Hello! Can you give me the id you want to add?"+"\u001B[0m");
		boolean good=false;
		String id;
		while(!good) {
			System.out.println("\u001B[33m"+"Write the desired id:"+"\u001B[0m");
			id=s.nextLine();
			if(so.isPerson(id)) {
				System.out.println("\u001B[31m"+"This id already exists, you have to choose another one"+"\u001B[0m");
			}else {
				good=true;
				data[0]=id;
				System.out.println("\u001B[32m"+"Valid id!"+"\u001B[0m");
			}
		}
		System.out.println("\u001B[33m"+"Type the actual name:"+"\u001B[0m");
		data[1]=s.nextLine();
		System.out.println("\u001B[33m"+"Well, now the surname:"+"\u001B[0m");
		data[2]=s.nextLine();
		System.out.println("\u001B[33m"+"Now write the birthday:"+"\u001B[0m");
		data[3]=s.nextLine();
		System.out.println("\u001B[33m"+"What큦 the gender?"+"\u001B[0m");
		data[4]=s.nextLine();
		System.out.println("\u001B[33m"+"Where were the person born?"+"\u001B[0m");
		data[5]=s.nextLine();
		System.out.println("\u001B[33m"+"Type where is the person큦 current home:"+"\u001B[0m");
		data[6]=s.nextLine();
		System.out.println("\u001B[33m"+"Where did the person study? separate witn ';' if there are more than one center:"+"\u001B[0m");
		data[7]=s.nextLine();
		System.out.println("\u001B[33m"+"Where have the person worked? Tell us your carreer, separate with ';' the different places:"+"\u001B[0m");
		data[8]=s.nextLine();
		System.out.println("\u001B[33m"+"Separating with the method used in the preivious sections, create a list of the person큦 favourite films:"+"\u001B[0m");
		data[9]=s.nextLine();
		System.out.println("\u001B[33m"+"We are almost done! type the group code please:"+"\u001B[0m");
		data[10]=s.nextLine();

	
		per=new Person(data);
		System.out.println("\u001B[32m"+"Successful registering! \n"+"\u001B[0m");
		try {
			so.addPerson(per);
		} catch (AlreadyAddedPerson e) {
			System.out.println("\n \u001B[31m"+"Already added person"+"\u001B[0m \n");
		}
			
	}
	/**
	 * method to remove a person from the network
	 * @param the network
	 */
	@SuppressWarnings("resource")
	public static void remove(SocialList so) {
		Scanner s=new Scanner(System.in);
		Person per;
		System.out.println("\u001B[33m"+"Hello! Can you give me the id you want to remove?");
		String id;

		System.out.println("Write the desired id:"+"\u001B[0m");
		id=s.nextLine();
		try {
			per=so.findPerson(id);
			so.removePerson(per);
		} catch (PersonNotFoundException e) {
			System.out.println("\n \u001B[31m"+"This person is already removed or does not exist"+"\u001B[0m \n");
		}
		

	}
	/**
	 * adds a relationship
	 * @param the network
	 */
	@SuppressWarnings("resource")
	public static void addFriend(SocialList so) {
		Scanner s=new Scanner(System.in);
		System.out.println("\u001B[33m"+"Type de id of the first friend:"+"\u001B[0m");
		String id1=s.nextLine();
		System.out.println("\u001B[33m"+"Type de id of the second friend:"+"\u001B[0m");
		String id2=s.nextLine();
		try {
			Person f=so.findPerson(id1);
			Person n=so.findPerson(id2);
			n.addFriend(f);
		} catch (PersonNotFoundException e) {
			System.out.println("\n \u001B[31m"+"one or the both id큦 does/do not exist"+"\u001B[0m \n");
		} catch (AlreadyAddedFriend e){
			System.out.println("\n \u001B[31m"+"relation already added"+"\u001B[0m \n");
		}
	
			
		

	}
	/**
	 * removes a relationship
	 * @param the network
	 */
	@SuppressWarnings("resource")
	public static void removeFriend(SocialList so) {
		Scanner s=new Scanner(System.in);
		System.out.println("\u001B[33m"+"Type de id of the first friend:"+"\u001B[0m");
		String id1=s.nextLine();
		System.out.println("\u001B[33m"+"Type de id of the second friend:"+"\u001B[0m");
		String id2=s.nextLine();
		try {
			Person f=so.findPerson(id1);
			Person n=so.findPerson(id2);
			n.removeFriend(f);
		} catch (PersonNotFoundException e) {
			System.out.println("\n \u001B[31m"+"one or the both id큦 does/do not exist"+"\u001B[0m \n");
		} 
	
			
		
		/**
		 * prints the person you look for
		 * @param the network
		 */
	}
	@SuppressWarnings("resource")
	public static void findSomeone(SocialList soc) {
		Scanner s=new Scanner(System.in);
		System.out.println("\u001B[33m"+"type the id of the person you are looking for:"+"\u001B[0m ");
		String id=s.nextLine();
		try {
	
			System.out.println(soc.findPerson(id).toString());
			
		} catch (PersonNotFoundException e) {
			System.out.println("\n \u001B[31m"+"This person does not belong to the network"+"\u001B[0m \n");
		}
	}
	
	/**
	 * prints all the friends of the wanted person
	 * @param the network
	 */
	@SuppressWarnings("resource")
	public static void someonesFriends(SocialList soc) {
		Scanner s=new Scanner(System.in);
		System.out.println("\u001B[33m"+"type the id of the person whose firends will be printed:"+"\u001B[0m ");
		String id=s.nextLine();

		try {
	
			soc.findPerson(id).printFriends();
				
		} catch (PersonNotFoundException e) {
			System.out.println("\n \u001B[31m"+"This person does not belong to the network"+"\u001B[0m \n");
		}

	}
	/**
	 * says if someone is in the network
	 * @param the network
	 * @return true if the person is in the network, false if not
	 */
	@SuppressWarnings("resource")
	public static boolean exist(SocialList soc) {
		Scanner s=new Scanner(System.in);
		System.out.println("\u001B[33m"+"type the id of you want to check:"+"\u001B[0m");
		String id=s.nextLine();
		return soc.isPerson(id);
	}
	/**
	 * adds people to the network from a new file
	 * @param the network
	 */
	@SuppressWarnings("resource")
	public static void newFile(SocialList soc) {
		Scanner s=new Scanner(System.in);
		System.out.println("\u001B[33m"+"type the name of (path to) the new people file:"+"\u001B[0m");
		String id=s.nextLine();
		try {
			soc.addFromFile(id);
		} catch (FileNotFoundException e) {
			System.out.println("\n \u001B[31m"+"Unvalid name"+"\u001B[0m \n");
		} 
		
	}
	/**
	 * removes the people that is in the fil from the network
	 * @param the network
	 */
	@SuppressWarnings("resource")
	public static void removeFile(SocialList soc) {
		Scanner s=new Scanner(System.in);
		System.out.println("\u001B[33m"+"type the name of (path to) the new people remover file:"+"\u001B[0m");
		String id=s.nextLine();
		try {
			soc.removeFromFile(id);
		} catch (FileNotFoundException e) {
			System.out.println("\n \u001B[31m"+"Unvalid name"+"\u001B[0m \n");
		} 
		
	}
	/**
	 * sets relationships based on a new file
	 * @param the network
	 */
	@SuppressWarnings("resource")
	public static void newRela(SocialList soc) {
		Scanner s=new Scanner(System.in);
		System.out.println("\u001B[33m"+"type the name of (path to) the new relations file:"+"\u001B[0m");
		String id=s.nextLine();
		try {
			soc.setFriendships(id);	
		} catch (PersonNotFoundException e) {
			System.out.println("\n \u001B[31m"+e.getMessage()+"\u001B[0m \n");
		}
		
	}
	/**
	 * removes relationships based on a file
	 * @param the network
	 */
	@SuppressWarnings("resource")
	public static void removeRela(SocialList soc) {
		Scanner s=new Scanner(System.in);
		System.out.println("\u001B[33m"+"type the name of (path to) the new relations remover file:"+"\u001B[0m");
		String id=s.nextLine();
		try {
			soc.removeFriendships(id);	
		} catch (PersonNotFoundException e) {
			System.out.println("\n \u001B[31m"+e.getMessage()+"\u001B[0m \n");
		}
		
	}
}
