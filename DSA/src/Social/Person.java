package Social;

/**
 * Class that represents all the people of a social media
 * @author ikerb
 *
 */

public class Person {
		/**
		 * 0-id
		 * 1-name
		 * 2-surname(s)
		 * 3-bday
		 * 4-gender
		 * 5-bplce
		 * 6-home
		 * 7-studied
		 * 8-work
		 * 9-films
		 * 10-group
		 */
		private String[] personData;
		
		private boolean hideInfo;
		/**
		 * the number of friends of a user
		 */
		private int numFriends;
		/**
		 * friend list
		 */
		private Person[] friendList;
		
		public Person(String[] p) {

			this(p,true);
			this.numFriends = 0;
			friendList=null;
		}
		
		public Person(String[] p, boolean hideInfo) {

			this.personData = p;
			this.hideInfo = hideInfo;
			this.numFriends = 0;
			friendList=null;
		}
		



		/**
		 * @return the personData
		 */
		public String[] getPersonData() {
			return personData;
		}

	

		/**
		 * @param idPreson the idPreson to set
		 */
		public void setIdPreson(String idPreson) {
			personData[0] = idPreson;
		}


		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			personData[1] = name;
		}

	

		/**
		 * @param lastName the lastName to set
		 */
		public void setLastName(String lastName) {
			personData[2] = lastName;
		}

	

		/**
		 * @param birthDate the birthDate to set
		 */
		public void setBirthDate(String birthDate) {
			personData[3] = birthDate;
		}


		/**
		 * @param gender the gender to set
		 */
		public void setGender(String gender) {
			personData[4] = gender;
		}

	

		/**
		 * @param birdPlace the birdPlace to set
		 */
		public void setBirthPlace(String birthPlace) {
			personData[5] = birthPlace;
		}


		/**
		 * @param home the home to set
		 */
		public void setHome(String home) {
			personData[6]= home;
		}


		/**
		 * @param studiedAt the studiedAt to set
		 */
		public void setStudiedAt(String studiedAt) {
			personData[7] = studiedAt;
		}

	

		/**
		 * @param workPlaces the workPlaces to set
		 */
		public void setWorkPlaces(String workPlaces) {
			personData[8] = workPlaces;
		}


		/**
		 * @param films the films to set
		 */
		public void setFilms(String films) {
			personData[9] = films;
		}

		

		/**
		 * @param groupCode the groupCode to set
		 */
		public void setGroupCode(String groupCode) {
			personData[10] = groupCode;
		}

		/**
		 * @return the hideInfo
		 */
		public boolean isHideInfo() {
			return hideInfo;
		}

		/**
		 * @param hideInfo the hideInfo to set
		 */
		public void setHideInfo(boolean hideInfo) {
			this.hideInfo = hideInfo;
		}

		/**
		 * @return the numFriends
		 */
		public int getNumFriends() {
			return numFriends;
		}

		
		
		public void addFriend(Person f) throws AlreadyAddedFriend{
			numFriends++;
			Person[] p=new Person[numFriends];
			p[0]=f;
			if(friendList!=null) {
				for(int i=0;i<friendList.length;i++) {
					if(f.equals(friendList[i])) {
						throw new AlreadyAddedFriend("Friend Already Added");
					}
					p[i+1]=friendList[i];
				}
			}
			friendList=p;
		}
		public void addFilm(String f) {
			setFilms(getPersonData()[9]+", "+f);
		}
		
		public void addWork(String f) {
			setWorkPlaces((getPersonData()[8])+", "+f);
		}
		
		@Override
		public String toString() {
			String r="--------------------------------\n Id: "+getPersonData()[0]+"\n Name: "+getPersonData()[1]+"\n Last name: "+getPersonData()[2]+"\n";
			if(!isHideInfo()) {
				r=r+" Birthday: "+getPersonData()[3]+"\n"
				+" Gender: "+getPersonData()[4]+"\n"
				+" Birth place: "+getPersonData()[5]+"\n"
				+" Home: "+getPersonData()[6]+"\n"
				+" Has studied at: "+getPersonData()[7]+"\n"
				+" Worked at: "+getPersonData()[8]+"\n"
				+" Favourite films: "+getPersonData()[9]+"\n"
				+" Has "+getNumFriends()+" friends\n";
			}
			
			r=r+" Group code: "+getPersonData()[10]+"\n--------------------------------";
			return r;
			
		}
		
		public String toStringForFriends() {
			String r="--------------------------------\n Id: "+getPersonData()[0]+"\n Name: "+getPersonData()[1]+"\n Last name: "
					+getPersonData()[2]+"\n"
			
			+" Birthday: "+getPersonData()[3]+"\n"
			+" Gender: "+getPersonData()[4]+"\n"
			+" Birth place: "+getPersonData()[5]+"\n"
			+" Home: "+getPersonData()[6]+"\n"
			+" Has studied at: "+getPersonData()[7]+"\n"
			+" Worked at: "+getPersonData()[8]+"\n"
			+" Favourite films: "+getPersonData()[9]+"\n"
			+" Has "+getNumFriends()+" friends\n"
			
			
			+" Group code: "+getPersonData()[10]+"\n--------------------------------";
			return r;
			
		}
		/**
		 * Returns true if they are the same person, this means that they have the same id 
		 */
		@Override
		public boolean equals(Object e) {
			boolean res=false;
			if(this==e) {res=true;}
			else
				if(e!=null) {
					if(getClass()==e.getClass()) {
						Person per=(Person)e;
						res=(per.getPersonData()[0].equals(this.getPersonData()[0]));
					}
				}
			
			return res;
		}
		
		public void printFriends() {
			System.out.println("Friends:");
			String lone="";
			if(friendList!=null) {
				for(Person p:friendList) {
					System.out.println(p.toStringForFriends());
				}
				lone=" more";
			}
			System.out.println("There are no"+lone+" friends...");
		}

		public boolean isFriend(Person p) {
			if(friendList!=null) {
				for(Person q:friendList) {
					if(q.equals(p)) {
						return true;
					}
				}
			}
			return false;
		}

		
}
