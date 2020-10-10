package person;

import java.util.ArrayList;

public class Person {
	//Attributes
	private String id;
	private String name;
	private String surnames;
	private String birthdate;
	private String birthplace;
	private String home;
	private String studiedat;
	private String workedat;
	private String movies;
	private String groupCode;
	private String gender;
	ArrayList<String> friendList= new ArrayList<>();
	
	//class person
	public Person(){
		
	}
	//setters and getters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getStudiedat() {
		return studiedat;
	}

	public void setStudiedat(String studiedat) {
		this.studiedat = studiedat;
	}

	public String getWorkedat() {
		return workedat;
	}

	public void setWorkedat(String workedat) {
		this.workedat = workedat;
	}

	public String getMovies() {
		return movies;
	}

	public void setMovies(String movies) {
		this.movies = movies;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	
	public void setGender(String gender) {
		this.gender=gender;
	}
	public String getGender() {
		return this.gender;
	}
	
	public void addFriend(String uId) {
		friendList.add(uId);
	}
	public int numberOfFriends() {
		return this.friendList.size();
	}
	public String getFriends() {
		String friends="Friends: ";
		for(int i=0; i<friendList.size();i++) {
			friends= friends+friendList.get(i)+",";
		}
		return friends;
	}
	@Override
	public String toString() {
		
		return "Id:"+this.id+","+"Name: "+this.name+","+"Surnames: "+this.surnames+","+"Birthdate: "+this.birthdate+","+"Home: "+this.home+","+"Studied at: "+this.studiedat+","+"Worked at:"+this.workedat+","+"Movies: "+this.movies+","+"GroupCode: "+this.groupCode+","+getFriends();
	}
	
	
	
	
	
	
	
}
