package people;

import java.io.File;
import java.io.IOException;

public class Pruebas {

	public static void main(String[] args) throws IOException {
		PeopleList prueba= PeopleList.getInstance();
		prueba.readtext();
		
		prueba.printPeople();
		
		/**File file =new File("firends.txt");
		String path = file.getAbsolutePath();
		
		prueba.readFriends(path);
		**/
		Person uno= prueba.getList().removeFirst();
		Person dos= prueba.getList().removeFirst();
		Person tres= prueba.getList().removeFirst();
		Person cuatro= prueba.getList().removeFirst();
		Person cinco= prueba.getList().removeFirst();
		
		System.out.println(uno.getIdentifier());
		System.out.println(dos.getIdentifier());
		System.out.println(tres.getIdentifier());
		System.out.println(cuatro.getIdentifier());
		System.out.println(cinco.getIdentifier());

		System.out.println(uno.getHome());
		System.out.println(uno.getGroupcode());
		System.out.println(uno.getBirthdate());
		System.out.println(dos.getIdentifier());;
		System.out.println(dos.getHome());
		System.out.println(dos.getGroupcode());
		System.out.println(dos.getBirthdate());
		
		System.out.println("FRIENDS");
		System.out.println(uno.getFriends().removeFirst().getIdentifier());
		System.out.println(dos.getFriends().removeFirst().getIdentifier());
		
		
		
		

	}

}
