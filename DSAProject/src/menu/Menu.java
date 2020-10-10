package menu;

import socialNetwork.SocialNetwork;

public class Menu {
	
	
	
	public static void main(String[] args) {
		
		SocialNetwork socialNetwork=new SocialNetwork();
		socialNetwork.loadNetwork();
		socialNetwork.readFriendShip();
		socialNetwork.loadFame();
		socialNetwork.whoIsFamous();
		
	}
}
