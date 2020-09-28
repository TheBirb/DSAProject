package Social;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SocialList {
	private Person[] list;
	private static SocialList instance;
	private int persons;
	
	private SocialList() {
		super();
		persons=0;
		list=null;
	}
	public static SocialList getInstance() {
		if(instance==null) {
			instance=new SocialList();
		}
		return instance;
	}
	
	public void addPerson(Person p) {
		persons++;
		Person[] w=new Person[persons];
		w[0]=p;
		if(list!=null) {
			for(int i=0;i<list.length;i++) {
				w[i+1]=list[i];
			}
		}
		list=w;	
	}
	
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
		throw new PersonNotFoundException("We cannot find that person");
	}
	
	public boolean isPerson(String id) {
		String[] s=new String[11];
		s[0]=id;
		Person w=new Person(s);
		if(list!=null) {
			for(Person p:list) {
				if(w.equals(p)) {
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * just usable when we see it from an external view, there is no user logged in
	 */
	public void printPeople() {
		System.out.println("People:");
		if(list!=null) {
			for(Person p:list) {
				System.out.println(p.toString());
			}
		}
		System.out.println("There are no more people");
	}
	
	public void printPeopleForUsers(Person p) {
		p.printFriends();
		System.out.println("Find new people");
		if(list!=null) {
			for(Person q:list) {
				if(!p.isFriend(q)) {
					System.out.println(q.toString());
				}
			}
		}
		System.out.println("That´s all the people you an find");
	}
	
	public Person[] mostPopular3() throws NotEnoughPeopleException{
		int p1=0;
		int p2=0;
		int p3=0;
		Person e1=null,e2=null,e3=null;
		if(list==null || list.length<3) {
			throw new NotEnoughPeopleException("There are not enough people to do this");
		}
		for(Person p:list) {
			if(p.getNumFriends()>p3) {
				if(p.getNumFriends()>p2) {
					if(p.getNumFriends()>p1) {
						e1=p;
						p1=p.getNumFriends();
					}else {
						e2=p;
						p2=p.getNumFriends();
					}
				}else {
					e3=p;
					p3=p.getNumFriends();
				}
			}
		}
		
		Person[] l=new Person[3];
		l[0]=e1;
		l[1]=e2;
		l[2]=e3;
		return l;
	}
	
	public void addFromFile(String s) {
		String splitBy=",";
		String line="";
		String[] pData=null;
		
		try {

			BufferedReader sr=new BufferedReader(new FileReader(s));
			while((line=sr.readLine())!=null) {
				pData=line.split(splitBy);
				addPerson(new Person(pData));
				pData=null;
			}
				
		
			sr.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("resource")
	public void setFriendships(String s) throws PersonNotFoundException{
		String splitBy=",";
		String line="";
		String[] friends=null;
		int m=0,n=0,i=0,q=3,w=3;
		
		try {
			BufferedReader sr=new BufferedReader(new FileReader(s));
			
			while((line=sr.readLine())!=null) {
					friends=line.split(splitBy);
					
					while(w+q!=0 && i<persons) {
						if(list[i].equals(findPerson(friends[0]))) {
							m=i;//indie del amigo 1
							q=0;
						}else if(list[i].equals(findPerson(friends[1]))) {
							n=i;//indie del amigo 2
							w=0;
						}
						i++;
					}
					if(w+q==0) {
						try {
							list[m].addFriend(list[n]);
						} catch (AlreadyAddedFriend e) {
							
							e.printStackTrace();
						}
						try {
							list[n].addFriend(list[m]);
						} catch (AlreadyAddedFriend e) {
							
							e.printStackTrace();
						}
					}else {
						throw new PersonNotFoundException();
					}
					w=3;
					q=3;
					i=0;
			}
				
			sr.close();
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(PersonNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
