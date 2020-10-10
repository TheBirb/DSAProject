package socialNetwork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import dependencies.LinkedOrderedFameList;
import dependencies.LinkedPersonList;
import person.Person;

public class SocialNetwork {
	LinkedPersonList list= new LinkedPersonList();
	LinkedOrderedFameList fameList= new LinkedOrderedFameList();
	public SocialNetwork() {
		
		
	}
	
	public void loadNetwork() {
		File pep= new File("People.txt");
		BufferedReader sr;
		try {
			sr = new BufferedReader(new FileReader(pep));
		
			
			String splitBy=",";
			String[] data=null;
			String line=" ";
			while((line=sr.readLine())!=null) {
				Person p= new Person();
				data= line.split(splitBy);
				p.setId(data[0]);
				p.setName(data[1]);
				p.setSurnames(data[2]);
				p.setBirthdate(data[3]);
				p.setGender(data[4]);
				p.setBirthplace(data[5]);
				p.setHome(data[6]);
				p.setStudiedat(data[7]);
				p.setWorkedat(data[8]);
				p.setMovies(data[9]);
				p.setGroupCode(data[10]);
				list.add(p);
				
			}
			sr.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void readFriendShip(){
		
		File f = new File("friends.txt");
			String splitBy=",";
			String line="";
			String[] data=null;
			
			
			try {
				
				BufferedReader br= new BufferedReader(new FileReader(f));
				while((line=br.readLine())!=null) {
					data=line.split(splitBy);
					list.setFriendShip(data[0], data[1]);
					
				}
				br.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
		
		
	}
	
	
	
}
