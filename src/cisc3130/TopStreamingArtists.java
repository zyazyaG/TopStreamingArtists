package cisc3130;

import java.util.LinkedHashSet;
import java.util. Scanner;
import java.io.*;

public class TopStreamingArtists {
	public static void main (String[]args)throws IOException {
		
		String[] art=new String[210];
		String [][] artists=new String[210][2];
		
		int n=readData(artists);//reads in data from file into nested array, returns the length of array
		
		int b=readArtists(artists, n);//rearranges array and deletes duplicates

		
		ArtistList list=new ArtistList();// linked list 
		
		//read in array into linked list
		for (int i=b-1;i>=0;i--) {
			list.insertFirst(artists[i][0],artists[i][1]);
			}
		
		
		list.displayList();//print list
		
		
	}
	
	//method to read in third column from the file and return number of array elements
	public static int readData(String [][] artists)throws IOException{
		Scanner input=new Scanner (new File ("/Users/azizagulyamova/Downloads/regional-global-daily-2020-01-23-2.csv"));
		int n=0;//tracker of # of elements
		String empt=input.nextLine();//store first two lines of file
		String empt2=input.nextLine();
		
		
		while (input.hasNextLine()) {//read in data to array and trim it
			if (input.hasNext()) {
				String []temp=input.nextLine().split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");//temporary array to store line
                String line=temp[2].replaceAll("\'", "");
                artists[n][0]=line;
				n++;
			}
		}
		sortData(artists, n);// call sort method
		
		return n;
	}
	
	//method to read in the artists in first column and the number of occurances in second column 
	public static int readArtists (String[][]artists, int n){
		String [][] temp=new String [n][2];//temporary nested array to store data without duplucates
		int j=0;
		
		for (int i=0;i<n-1;i++) {
			
			if (artists[i][0].compareToIgnoreCase(artists[i+1][0])!=0) {
				temp[j][0]=artists[i][0];
				temp[j][1]=dup(artists, artists[i][0]);// calls method to get #of occurances
				j++;
			}
		}		
		
		temp[j+1][0]=artists[n-1][0];
		temp[j+1][1]=artists[n-1][1];//reads in last row of the data
		
		for (int i=0;i<j;i++) {//reads the temporary array into artist array with number of occurances
			artists[i][0]=temp[i][0];
			artists[i][1]=temp[i][1];
		}
		return j;
	}
	
	//method to count number of occurances of artist	
	public static String dup(String [][] data,String artist) {
    	int count=0;
    	String num="";
    	for (int i=0;i<data.length;i++) {
    		if (artist.equals(data[i][0])) {
    			count++;
    		}
    	}
    	
    	num=String.valueOf(count); //convert int into String
    	return num;
    }
	
    //method to sort data in alphabetic order
	public static void sortData(String [][] data, int n) {
		for (int i=0;i<n-1;i++) {
			for (int j=i+1;j<n;j++) {
				if (data[i][0].compareToIgnoreCase(data[j][0])>0) {
					String temp=data[i][0];
					data[i][0]=data[j][0];
					data[j][0]=temp;
				}
			}
		}
	}
		
}//close the main class

