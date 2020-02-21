package cisc3130;

import java.io.*;

class Artist {
	
	
	public String artist;
	public String freq;
	public Artist next;
	PrintWriter output;	
	
	
	
	//constructor method	
	public Artist (String artist,String freq){
	this.artist=artist;
	this.freq=freq;
	
	}
	
	//method to print out the node
	public void displayArtist(PrintWriter output) throws IOException{
		
		output.printf("%-20.20s\t   %-3s\n", artist, freq);
	}

}//close Artist class


class ArtistList {
	private Artist first;

	//constructor
	public ArtistList() {
		first=null;
	}
	
	//true if list is empty
	public boolean isEmpty() {
		return (first==null);
	}
	
	//method to insert node into list
	public void insertFirst (String artist, String freq) {
		Artist newArtist=new Artist(artist,freq);
		newArtist.next=first;
		first=newArtist;
	}
	
	//method to print out the list
	public void displayList()throws IOException{
		PrintWriter output=new PrintWriter(new File("output.txt"));
		output.println("List of artists in alphabetic order: ");
		Artist current=first;
		while (current!=null) {
			current.displayArtist(output);
			current=current.next;
		}
		output.close();		
	}
	
}//close ArtistsList class


