package Social;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

import Exceptions.*;
import structures.LinkedList;
import structures.LinkedOrderedFameList;
/**
 * Class that represents a network
 * @author Iker Pintado
 *
 */
public class SocialList {
	/**
	 * the list of persons of the network
	 */
	private LinkedList<Person> list;
	/**
	 * the only instance of the network--singleton pattern
	 */
	private static SocialList instance;

	/**
	 * private constructor of the class--singleton pattern
	 */
	private SocialList() {
		super();
		list=new LinkedList<Person>();
	}
	/**
	 * method to get the only instance of the class--singleton pattern
	 * @return the only instance
	 */
	public static SocialList getInstance() {
		if(instance==null) {
			instance=new SocialList();
		}
		return instance;
	}
	/**
	 * method to add a person to the list
	 */
	public void addPerson(Person p) throws AlreadyAddedPerson{
		if(!list.isEmpty())
			if(list.contains(p)) throw new AlreadyAddedPerson();
		list.addToTail(p);
	}
	/**
	 * method to remove a person of the list. Deletes all the existence of that person in the network,
	 * including friendships
	 * @param person to remove
	 */
	public void removePerson(Person p){	
		try {
			list.remove(p);
			
		} catch (EmptyCollectionException | ElementNotFoundException e) {
			System.out.println("\n \u001B[31m"+"Already removed person or never existed"+"\u001B[0m \n");
		}
		if(!p.friendList.isEmpty()) {
			for(Person pe:p.friendList) {
				pe.removeFriend(p);
			}
		}
		
		System.out.println("\n \u001B[32m DONE! \u001B[0m \n");
	}
	/**
	 * method to find a person from the id
	 * @param the id of the person
	 * @return the person with that id
	 * @throws PersonNotFoundException when the id is not on the network
	 */
	public Person findPerson(String id)throws PersonNotFoundException {
		String[] s=new String[11];
		s[0]=id;
		Person w=new Person(s);
		if(list!=null) {
			for(Person p:list) {
				if(p.equals(w)) {
					return p;
				}
			}
		}
		throw new PersonNotFoundException("\n \u001B[31m We cannot find that person\n \u001B[0m");
	}
	/**
	 * Method to know if a person is in the network
	 * @param the id of the person
	 * @return if the person is in the network
	 */
	public boolean isPerson(String id) {
		String[] pe=new String[11];
		pe[0]=id;
		Person p=new Person(pe);
		return list.contains(p);
	}
	/**
	 *Prints all the people of the network
	 */
	public void printPeople() {
		System.out.println("People:");
		if(list!=null) {
			for(int i=0;i<list.size();i++) {
				System.out.println(list.get(i).toString());
			}
		}
		System.out.println("\n \u001B[33m"+"There are no more people"+"\u001B[0m \n");
	}
	
	/**
	 * returns a list with the most popular  people
	 * @return a list with the most popular ones ordered
	 */
	public LinkedOrderedFameList mostPopular(){
		LinkedOrderedFameList fameList=new LinkedOrderedFameList();
		for(Iterator<Person> i=list.iterator(); i.hasNext();) {
			fameList.add(i.next());
		}
		return fameList;

	}
	/**
	 * method that adds people from a file
	 * @param the name of the file
	 * @throws FileNotFoundException if the file name is wrong
	 */
	public void addFromFile(String s) throws FileNotFoundException{
		String splitBy=",";
		String[] pData;
		String line="";
		try {

			Scanner sr=new Scanner(new File(s));
			while(sr.hasNextLine()) {
				line=sr.nextLine();
				if(!line.equals("")) {
					pData=line.split(splitBy);
				
					try {
						addPerson(new Person(pData));
					} catch (AlreadyAddedPerson e) {
						System.out.println("\n \u001B[31m"+"already added"+"\u001B[0m \n");
					}
				}
				
			}
				
		
			sr.close();
		}catch(IOException e) {
			System.out.println("\n \u001B[31m"+e.getMessage()+"\u001B[0m \n");
		}
		
	}
	/**
	 * method that removes from the network all the people in the file
	 * @param the name of the file
	 * @throws FileNotFoundException if the name of the file is wrong
	 */
	public void removeFromFile(String s) throws FileNotFoundException{
		String splitBy=",";
		String[] pData;
		String line="";
		try {

			Scanner sr=new Scanner(new File(s));
			while(sr.hasNextLine()) {
				line=sr.nextLine();
				if(!line.equals("")) {
					pData=line.split(splitBy);				
					removePerson(new Person(pData));
				}
				
			}
				
		
			sr.close();
		}catch(IOException e) {
			System.out.println("\n \u001B[31m"+e.getMessage()+"\u001B[0m \n");
		}
		
	}
	/**
	 * method that reads from a file and sets the friendships
	 * @param the name of the file
	 * @throws PersonNotFoundException if one person of the file is not in the list
	 */
	@SuppressWarnings("resource")
	public void setFriendships(String s) throws PersonNotFoundException{
		String splitBy=",";
		String[] friends;
		String line="";
		int m=0,n=0,i=0,q=3,w=3,det=0;
		
		try {
			Scanner sr=new Scanner(new File(s));
			
			while(sr.hasNextLine()) {
				line=sr.nextLine();
				if(!line.equals("")) {
					friends=line.split(splitBy);
						
					while(w+q!=0 && i<list.size()) {
							if(list.get(i).equals(findPerson(friends[0]))) {
								m=i;//indice del amigo 1
								q=0;
							}else if(list.get(i).equals(findPerson(friends[1]))) {
								n=i;//indice del amigo 2
								w=0;
							}
							i++;
					}
					
					if(w+q==0) {
						try {
							list.get(m).addFriend(list.get(n));
						} catch (AlreadyAddedFriend e) {
							System.out.println("\n \u001B[31m"+"Already added friend"+"\u001B[0m \n");
						}
					}else {
						det++;
					}
					w=3;
					q=3;
					i=0;
				}
			}
			if(det>0)
				throw new PersonNotFoundException("\n \u001B[31m"+"There where "+det+" impossible to stablish relations"+"\u001B[0m \n");
				
			sr.close();
			
		}catch(FileNotFoundException e) {
			System.out.println("\n \u001B[31m"+"file not found"+"\u001B[0m \n");
		}
	}
	/**
	 * method that removes the read from file relationships
	 * @param name of the file
	 * @throws PersonNotFoundException if some name on the file does not appear in the network
	 */
	@SuppressWarnings("resource")
	public void removeFriendships(String s) throws PersonNotFoundException{
		String splitBy=",";
		String[] friends;
		String line="";
		int m=0,n=0,i=0,q=3,w=3,det=0;
		
		try {
			Scanner sr=new Scanner(new File(s));
			
			while(sr.hasNextLine()) {
				line=sr.nextLine();
				if(!line.equals("")) {
					friends=line.split(splitBy);
						
					while(w+q!=0 && i<list.size()) {
							if(list.get(i).equals(findPerson(friends[0]))) {
								m=i;//indice del amigo 1
								q=0;
							}else if(list.get(i).equals(findPerson(friends[1]))) {
								n=i;//indice del amigo 2
								w=0;
							}
							i++;
					}
					
					if(w+q==0) {
						
						list.get(m).removeFriend(list.get(n));
						
					}else {
						det++;
					}
					w=3;
					q=3;
					i=0;
				}
			}
			if(det>0)
				throw new PersonNotFoundException("\n \u001B[31m"+"There where "+det+" impossible to remove relations"+"\u001B[0m \n");
				
			sr.close();
			
		}catch(FileNotFoundException e) {
			System.out.println("\n \u001B[31m"+"file not found"+"\u001B[0m \n");
		}
	}
	/**
	 * method that prints all the people of the network on a .txt
	 */
	public void getTXT() {
		try {
			PrintWriter wrfile =new PrintWriter(new File("wrotePeople.txt"));
			for(Person p:list) {
				wrfile.println(p.toStringTXT());
			}
			wrfile.close();
		} catch (FileNotFoundException e) {
			System.out.println("\n \u001B[31m"+"txt not found"+"\u001B[0m \n");
		}
	}
	/**
	 * method that prints all the existing relationships on a .txt
	 */
	public void getRelasTXT() {
		try {
			Person au,au2;
			String print="";
			PrintWriter wrfile =new PrintWriter(new File("wroteRelas.txt"));
			for(int i=0;i<list.size();i++) {
				au=list.get(i);
				for(int j=i+1;j<list.size();j++) {
					au2=list.get(j);
					if(au.isFriend(au2)) {
						print=au.getPersonData()[0]+","+au2.getPersonData()[0];
						wrfile.println(print);
					}
				}
			}
			
			wrfile.close();
		} catch (FileNotFoundException e) {
			System.out.println("\n \u001B[31m"+"txt not found"+"\u001B[0m \n");
		}
	}
	
	
}
