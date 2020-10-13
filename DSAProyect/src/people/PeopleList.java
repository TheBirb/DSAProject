package people;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import dsa.DoubleNode;
import dsa.DoubleOrderedList;

public class PeopleList {
	private static PeopleList instance;
	private DoubleOrderedList<Person> peopleList;
	
	private PeopleList() throws IOException {
		peopleList = new DoubleOrderedList<Person>();
	}
	
	public static PeopleList getInstance() throws IOException {
		if(instance==null) {
			instance= new PeopleList();
		}
		return instance;
	}
	
	public DoubleOrderedList<Person> getList() {
		return peopleList;
	}
	
	public void readtext() throws IOException {
		String line;
		String separator= ",";
		try {
			BufferedReader b = new BufferedReader(new FileReader("txt/personas.txt"));
			while((line=b.readLine())!=null) {
				String [] fields= line.split(separator);
				newPerson(fields);
			}
			b.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	public void newPerson(String[] fields ) {
		Person p= new Person();
		for(int i=0; i<fields.length ; i++) {
			if(i==0) {
				p.setIdentifier(fields[i]);
			}
			if(i==1) {
				p.setName(fields[i]);
			}
			if(i==2) {
				p.setSurname(fields[i]);
			}
			if(i==3) {
				p.setBirthdate(fields[i]);
			}
			if(i==4) {
				p.setBirthplace(fields[i]);
			}
			if(i==5) {
				p.setHome(fields[i]);
			}
			if(i==6) {
				p.setStudiedat(fields[i]);
			}
			if(i==7) {
				p.setWorkdat(fields[i]);
			}
			if(i==8) {
				p.setMovies(fields[i]);
			}
			if(i==9) {
				p.setGroupcode(fields[i]);
			}
		}
		addPerson(p);
	}
	
	public void addPerson(Person p) {
		peopleList.add(p);
	}
	
	public int numberOfPeople() {
		return peopleList.size();
	}
	
	public void printPeople() {
		String write2file = "txt/peopleList.txt";
		File wrname = new File (write2file);
		
		try {
			PrintWriter wrfile = new PrintWriter (wrname);
			DoubleNode<Person> traverse = peopleList.getFront();
		      while (traverse != null)
		         { 
		         String p = traverse.getElement().getIdentifier();
		         wrfile.println(p);
		         traverse = traverse.getNext();
		         }
			wrfile.close();
		}
		catch ( FileNotFoundException e ) {
				 e.printStackTrace();
		}
	}
	
	public void readFriends() throws IOException {
		String line;
		String separator= ",";
		try {
			BufferedReader b = new BufferedReader(new FileReader("txt/friends.txt"));
			while((line=b.readLine())!=null) {
				String [] fields= line.split(separator);
				makeFriends(fields);
			}
			b.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void makeFriends(String[] fields) {
		Person one= getPerson(fields[0]);
		Person two= getPerson(fields[1]);
		one.getFriends().add(two);
		two.getFriends().add(one);
		
	}
	
	public Person getPerson(String id) {
		Person p= new Person();
		DoubleNode<Person> traverse = peopleList.getFront();
		while(traverse!=null) {
			if(traverse.getElement().getIdentifier().equals(id)==true) {
				p=traverse.getElement();
				break;
			}
			traverse=traverse.getNext();
		}
		return p;
	}
	
}
