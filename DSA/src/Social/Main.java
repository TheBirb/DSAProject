package Social;

import java.util.Scanner;

public class Main {

	@SuppressWarnings({ "resource" })
	public static void main(String[] args) {
		Person user=null;
		Scanner s=new Scanner(System.in);
		SocialList soc=SocialList.getInstance();
		System.out.println("decide, press 1 to log in or 2 to register");
		int sel=0;
		while(sel!=1 && sel!=2) {
			sel=s.nextInt();
			if(sel==1) {
				user=logIn(soc);
			}else if(sel==2){
				user=register(soc);
			}else {
				System.out.println("Come on... it´s just 1 or 2 the choices you have.Try again");
			}
		}
		if(user!=null) {
			System.out.println("well, now you are in. Press the number we tell you to do the desired task");
			boolean logout=false;
			int opt;
			String id;
			while(!logout) {
				System.out.println("Show your friends----1"
						+ "\n add a friend-----2 \n search for someone----3 \n print your data----4 \n show the three most famous people----5"
						+ "\n show all the people of the network----6 \n log out with any other number");
				opt=s.nextInt();
				switch(opt) {
					case 1:
						user.printFriends();
						break;
					case 2:
						System.out.println("Type de id of your friend:");
						id=s.nextLine();
						if(soc.isPerson(id)) {
							try {
								Person f=soc.findPerson(id);
								user.addFriend(f);
							} catch (PersonNotFoundException e) {
								e.printStackTrace();
							} catch (AlreadyAddedFriend e){
								e.printStackTrace();
							}
						}else {
							System.out.println("This id does not exist");
						}
						break;
					case 3:
						System.out.println("type the id of the person you are looking for:");
						id=s.nextLine();
						if(soc.isPerson(id)) {
							try {
								if(user.isFriend(soc.findPerson(id))) {
									System.out.println(soc.findPerson(id).toStringForFriends());
								}else {
									System.out.println(soc.findPerson(id).toString());
								}
							} catch (PersonNotFoundException e) {
								e.printStackTrace();
							}
						}else {
							System.out.println("This person does not belong to the network");
						}
						break;
					case 4:
						System.out.println(user.toStringForFriends());
						break;
					case 5:
						try {
							for(Person w:soc.mostPopular3()) {
								System.out.println(w.toString());
							}
						} catch (NotEnoughPeopleException e) {
						
							e.printStackTrace();
						}
					
						break;
					case 6:
						soc.printPeopleForUsers(user);
						break;
					default:
						System.out.println("See you soon!!!!");
						logout=true;
						break;
				}
			}
		}
		
	}
	
	
	
	
	
	@SuppressWarnings("resource")
	public static Person logIn(SocialList so) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the username(log in Id):");
		String username=s.nextLine();
		Person per = null;
		try {
			if(so.isPerson(username)) {
				try {
					per=so.findPerson(username);
				} catch (PersonNotFoundException e) {
				
					e.printStackTrace();
				}
				Thread.sleep(750);	
			
				System.out.println(".");
				Thread.sleep(750);
				System.out.println(".");
				Thread.sleep(750);
				System.out.println(".");
				System.out.println("Succesful log in!!!");
			}else {
				System.out.println("log in failed! :'(");
				Thread.sleep(1500);
				System.out.println("Ok...");
				Thread.sleep(200);
				System.out.println("You have 3 choices now..\n type 1 to try to Log in again "
					+ "\n type 2 to register \n type 3 if you want to give up and do nothing >:(");
				boolean good=false;
				int opt;
				while(!good) {
					System.out.println("well... what do you say? 1, 2 or 3?");
					opt=s.nextInt();
					switch(opt) {
						case 1:
							System.out.println("okay! Let´s go again!");
							per=logIn(so);
							good=true;
							break;
						case 2:
							System.out.println("Good choice!!!!");
							per=register(so);
							good=true;
							break;
						case 3:
							System.out.println("I get your point, but... I am still disappointed :/");
							per=null;
							good=true;
							break;
						default:
							System.out.println("Come on! Select a valid choice!");
							break;						
					}
				}
			}
		}catch (InterruptedException e) {
		e.printStackTrace();
		}
		
		return per;
	}
	
	@SuppressWarnings("resource")
	public static Person register(SocialList so) {
		Scanner s=new Scanner(System.in);
		String[] data=new String[11];
		Person per;
		System.out.println("Hello! Can you give me the id you want to have?");
		boolean good=false;
		String id;
		while(!good) {
			System.out.println("Write your desired id:");
			id=s.nextLine();
			if(so.isPerson(id)) {
				System.out.println("This id already exists, you have to choose another one");
			}else {
				good=true;
				data[0]=id;
				System.out.println("Valid id!");
			}
		}
		System.out.println("Type your actual name:");
		data[1]=s.nextLine();
		System.out.println("Well, now your surname:");
		data[2]=s.nextLine();
		System.out.println("Now write your birthday:");
		data[3]=s.nextLine();
		System.out.println("What´s your gender? Feel free to be yourself in here!");
		data[4]=s.nextLine();
		System.out.println("Where were you born?");
		data[5]=s.nextLine();
		System.out.println("Type where is your current home:");
		data[6]=s.nextLine();
		System.out.println("Where did you study? separate witn ';' if there are more than one center:");
		data[7]=s.nextLine();
		System.out.println("Where have you worked? Tell us your carreer, separate with ';' the different places:");
		data[8]=s.nextLine();
		System.out.println("Separating with the method used in the preivious sections, create a list of your favourite films:");
		data[9]=s.nextLine();
		System.out.println("We are almost done! type your group code please:");
		data[10]=s.nextLine();
		System.out.println("Ok! The last thing to do. Type 'yes' if you want your info to be public or type anything else to make it private:");
		String decide=s.nextLine();
		if(decide.equals("yes")) {
			per= new Person(data,false);
		}else {
			per=new Person(data);
		}
		return per;
			
			
			
			
			
			
			
	}
}
