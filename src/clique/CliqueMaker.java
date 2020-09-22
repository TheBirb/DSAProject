package clique;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class CliqueMaker {
	public static ArrayList<String> betaList = new ArrayList<>(); 
	public static void main(String[] args) throws UnsupportedEncodingException {
		cliqueMaker();
	}
	/*
	 * Method used to read a file with a number of names, and converting it into a clique of friends
	 */
	public static void cliqueMaker() throws UnsupportedEncodingException{
	try {
		BufferedReader bufReader = new BufferedReader(new FileReader("betaPairsV1.txt")); 
		
		String line = bufReader.readLine(); 
		while (line != null) { 
			betaList.add(line);
			line = bufReader.readLine();
		}
		bufReader.close();
		
	}catch(IOException e) {
		System.out.println("No file was found");
	}
	
	try {
		PrintWriter writer = new PrintWriter("friendsG612050.txt", "UTF-8");
		writer.println("friend1, friend2");
		for(int i=0; i<betaList.size(); i++) {
			for(int j= i+1; j<betaList.size(); j++) {
			
				writer.println(betaList.get(i)+","+betaList.get(j));
				
			}
		}
		writer.close();
	}catch(FileNotFoundException e) {
		
	}
	
		

}
	
}
