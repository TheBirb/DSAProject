package people;

import dsa.DoubleOrderedList;

public class Person implements Comparable<Person>{
	

	private String indentifier;
	private String name;
	private String surname;
	private String birthdate;
	private String birthplace;
	private String home;
	private String studiedat;
	private String workdat;
	private String movies;
	private String groupcode;
	
	private DoubleOrderedList<Person> friends= new DoubleOrderedList<Person>();
	
	public Person() {
		
	}
	
	public void setIdentifier(String pIdentifier) {
		indentifier=pIdentifier;
	}
	
	public String getIdentifier() {
		return indentifier;
	}
	
	public void setName(String pName) {
		name=pName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setSurname(String pSurname) {
		surname=pSurname;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setBirthdate(String pBirthdate) {
		birthdate=pBirthdate;
	}
	
	public String getBirthdate() {
		return birthdate;
	}
	
	public void setBirthplace(String pBirthplace) {
		birthplace=pBirthplace;	
	}
	
	public String getBirthplace() {
		return birthplace;
	}
	
	public void setHome(String pHome) {
		home=pHome;
	}
	
	public String getHome() {
		return home;
	}

	public void setStudiedat(String pStudiedat) {
		studiedat=pStudiedat;
	}
	
	public String getStudiedat() {
		return studiedat;
	}
	
	public void setWorkdat(String pWorkdat) {
		workdat=pWorkdat;
	}
	
	public String getWorkdat() {
		return workdat;
	}

	public void setMovies(String pMovies) {
		movies=pMovies;
	}
	
	public String getMovies() {
		return movies;
	}
	
	public void setGroupcode(String pGroupcode) {
		groupcode=pGroupcode;
	}
	
	public String getGroupcode() {
		return groupcode;
	}


	@Override
	public int compareTo(Person o) {
		int resultado= getIdentifier().compareTo(o.getIdentifier());
		return resultado;
	}
	
	public DoubleOrderedList<Person> getFriends() {
		return friends;
	}
}
