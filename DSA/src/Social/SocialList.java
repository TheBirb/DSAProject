package Social;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

import Exceptions.*;
//import structures.BinarySearchFriends;
import structures.BinarySearchID;
import structures.LinkedList;
/**
 * Class that represents a network
 * @author Iker Pintado
 *
 */
public class SocialList {
	/**
	 * the list of persons of the network
	 */
	private BinarySearchID list;

	/**
	 * the only instance of the network--singleton pattern
	 */
	private static SocialList instance;
	/**
	 * Comparator for sorting the list in a not natural order
	 */
	public static Comparator<Person> BSNComparator=new Comparator<Person>() {
		/**
		 * compare method for sorting in some cases
		 */
		@Override
		public int compare(Person o1, Person o2) {
			int res=o1.getPersonData()[5].compareTo(o2.getPersonData()[5]);
			if(res==0) {
				res=o1.getPersonData()[2].compareTo(o2.getPersonData()[2]);
				if(res==0) {
					res=o1.getPersonData()[1].compareTo(o2.getPersonData()[1]);
				}
			}
			return res;
		}
	};

	/**
	 * private constructor of the class--singleton pattern
	 */
	private SocialList() {
		super();
		list=new BinarySearchID();
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
		list.add(p);
		
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
	 * @throws ElementNotFoundException when the id is not on the network
	 */
	public Person findPerson(String id)throws ElementNotFoundException {
		String[] s=new String[11];
		s[0]=id;
		Person w=new Person(s);
		return list.find(w);

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
		String pr="\n \u001B[33m"+"People:"+"\u001B[0m \n\n";
		if(list!=null) {
			for(Person p:list) {
				pr=pr+p.toString()+"\n";
			}
		}
		System.out.println(pr+"\n \u001B[33m"+"There are no more people"+"\u001B[0m \n");
	}
	
	/**
	 *Prints all the people of the network ordered by fame
	 */
	public void printFamePeople() {
		String pr="\n \u001B[33m"+"People:"+"\u001B[0m \n\n";
		if(list!=null) {
			LinkedList<Person> fameList=list.toFameList();
			for(Person p:fameList) {
				pr=pr+p.toString()+"\n";
			}
		}
		System.out.println(pr+"\n \u001B[33m"+"There are no more people"+"\u001B[0m \n");
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
	 * @throws ElementNotFoundException if one person of the file is not in the list
	 */
	@SuppressWarnings("resource")
	public void setFriendships(String s) throws ElementNotFoundException{
		String splitBy=",";
		String[] friends;
		String line="";
		int q=3,w=3,det=0;
		Iterator<Person> it;
		Person p1,p2,pp;
		p1=p2=pp=null;
		try {
			Scanner sr=new Scanner(new File(s));
			while(sr.hasNextLine()) {
				line=sr.nextLine();
				if(!line.equals("")) {
					friends=line.split(splitBy);
					it=list.iterator();	
					while(w+q!=0 && it.hasNext()) {
						pp=it.next();
						if(pp.equals(findPerson(friends[0]))) {
							p1=pp;//amigo 1
							q=0;
						}else if(pp.equals(findPerson(friends[1]))) {
							p2=pp;// amigo 2
							w=0;
						}
					}
					
					if(w+q==0) {
						try {
							p1.addFriend(p2);
						} catch (AlreadyAddedFriend e) {
							System.out.println("\n \u001B[31m"+"Already added friend"+"\u001B[0m \n");
						}
					}else {
						det++;
					}
					w=3;
					q=3;
				}
			}
			if(det>0)
				throw new ElementNotFoundException("\n \u001B[31m"+"There where "+det+" impossible to stablish relations"+"\u001B[0m \n");
				
			sr.close();
			
		}catch(FileNotFoundException e) {
			System.out.println("\n \u001B[31m"+"file not found"+"\u001B[0m \n");
		}
	}
	/**
	 * method that removes the read from file relationships
	 * @param name of the file
	 * @throws ElementNotFoundException if some name on the file does not appear in the network
	 */
	@SuppressWarnings("resource")
	public void removeFriendships(String s) throws ElementNotFoundException{
		String splitBy=",";
		String[] friends;
		String line="";
		int q=3,w=3,det=0;
		Iterator<Person> it;
		Person p1,p2,pp;
		p1=p2=pp=null;
		try {
			Scanner sr=new Scanner(new File(s));
			
			while(sr.hasNextLine()) {
				line=sr.nextLine();
				if(!line.equals("")) {
					friends=line.split(splitBy);
					it=list.iterator();		
					while(w+q!=0 && it.hasNext()) {
						pp=it.next();
							if(pp.equals(findPerson(friends[0]))) {
								p1=pp;//amigo 1
								q=0;
							}else if(pp.equals(findPerson(friends[1]))) {
								p2=pp;//amigo 2
								w=0;
							}
					}
					
					if(w+q==0) {
						
						p1.removeFriend(p2);
						
					}else {
						det++;
					}
					w=3;
					q=3;
				}
			}
			if(det>0)
				throw new ElementNotFoundException("\n \u001B[31m"+"There where "+det+" impossible to remove relations"+"\u001B[0m \n");
				
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
			String pr="";
			for(Person p:list) {
				pr=pr+p.toStringTXT()+"\n";
			}
			wrfile.println(pr);
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
			Person au2,au;
			String print="";
			PrintWriter wrfile =new PrintWriter(new File("wroteRelas.txt"));
			LinkedList<Person> link=list.toFameList();
			Iterator<Person> it,ite=link.iterator();
			while(ite.hasNext()) {
				au=ite.next();
				try {
					link.remove(au);//always removes the first one
				} catch (EmptyCollectionException | ElementNotFoundException e) {}//the element will surely be found and the collection will never be empty
				it=link.iterator();
				while(it.hasNext()) {
					au2=it.next();
					if(au.isFriend(au2)) {
						print=print+au.getPersonData()[0]+","+au2.getPersonData()[0]+"\n";
					}
				}
			}
			wrfile.println(print);
			
			wrfile.close();
		} catch (FileNotFoundException e) {
			System.out.println("\n \u001B[31m"+"txt not found"+"\u001B[0m \n");
		}
	}
	/**
	 * This method sorts by birthplace,surname and name all the people born between the given dates
	 * if the dates are not given in order, the method order them
	 * @param d1 the first date, should be less than d2
	 * @param d2 the second date, should be more than d1
	 */
	public void sortByAge(int d1, int d2) {
		ArrayList<Person> print=new ArrayList<Person>();
		String date="",prnt="\u001B[33m"+"The people born between "+ "\u001B[32m"+d1+ "\u001B[33m"+" and "+ "\u001B[32m"+d2+ "\u001B[33m"+" are:"+ "\u001B[0m \n";
		Integer num=-1;
		Person au=null;
		if(d1>d2) {//change the values if they are unordered
			int aux=d1;
			d1=d2;
			d2=aux;
		}
		for(Iterator<Person> it=list.iterator();it.hasNext();) {//it is planned so the two outing conditions will be activated at the same time but we do this just in case
			au=it.next();
			date=au.getPersonData()[3].split("-")[2];
			num=Integer.parseInt(date);
			if(num.intValue()>=d1 && num.intValue()<=d2) {
				print.add(au);
			}
		}
		int i=print.size();
		if(i>0) {
			Collections.sort(print,BSNComparator);
			for(int j=0;j<i;j++) {
				prnt=prnt+print.get(j).toString()+"\n";
			}
		}else {
			prnt=prnt+"\u001B[33m"+"There are no people born between the given dates"+"\u001B[30m";
		}
		System.out.println(prnt);		
	}
	
	
}
