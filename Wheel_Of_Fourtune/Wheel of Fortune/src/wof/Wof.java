package wof;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;   
import java.io.IOException;
import java.util.Random;
public class Wof {

	public static void main(String[] args)
			throws FileNotFoundException
	{
		//defining variables
		File country = new File("/Users/eng.arya/Downloads/2019510113_Maede_Mohamadi/countries.txt");
	    Scanner scCountry = new Scanner(country);
	    Scanner scCountryc = new Scanner(country);
	    File highscore = new File("/Users/eng.arya/Downloads/2019510113_Maede_Mohamadi/HighScoreTable.txt");
	    Scanner scHigh = new Scanner(highscore);
	    Scanner scHighc = new Scanner(highscore);
	    
	    Stack S2 = new Stack(26);
	    Stack S2temp = new Stack(26);
	    
	    Object ow;
	    Random rnd= new Random();
	    int hsc=0,Q1size=0,Q2size=0,step=1,score=0,thewheel,S1c=0,S3c=0;
	    boolean last=true, dc=false; ;
	    Object tempQ1,tempQ2,dash="_",os;
	    //scanning data file from D:\\........ to determine their size and therefore size of the stacks
	    do {
	    	scCountryc.next();
	    	S1c++;
	    	if(scCountryc.hasNext()==false) {
	    		last=false;
	    	}
	    }while(last==true);
	    scCountryc.close();
	    last=true;
	    do {
	    	scHighc.next();
	    	S3c++;
	    	if(scHighc.hasNext()==false) {
	    		last=false;
	    	}
	    }while(last==true);
	    scHighc.close();
	    last=true;
	    //defining the stacks
	    Stack s1unsorted = new Stack(S1c);
	    Stack tempstack = new Stack(S1c);
	    Stack tempname = new Stack(S3c);
	    Stack tempscore = new Stack(S3c);
	    Stack S1 = new Stack(S1c);
	    Stack S3unsorted = new Stack(S3c);	    
	    Stack S4unsorted = new Stack(S3c);	   
	    Stack S3 = new Stack(S3c);
	    Stack S4 = new Stack(S3c);
	    //change every letter in countries to upper case and 
	    //pushing them into S1unsorted stack to be able to sort them later 
	    do {
	    	s1unsorted.push(scCountry.next().toUpperCase());
	    	if(scCountry.hasNext()==false) {
	    		last=false;
	    		
	    	}
	    		
	    	
	    }while(last==true);
	    scCountry.close();
	    last= true;
	    //Dividing the High score table from D://........ file 
	    //to Names and Scores accordingly and putting them into S3 and S4
	    do {
	    	if(hsc%2==0) {
	    		S3unsorted.push(scHigh.next());
		    	if(scHigh.hasNext()==false) {
		    		last=false;
	    		
	    	}   	
	    		    		
	    	}
	    	
	    	else {
	    		try{
	    			S4unsorted.push(Integer.parseInt(scHigh.next()));	                
	            }
	            catch (NumberFormatException ex){
	                ex.printStackTrace();
	            }
	    		
		    	if(scHigh.hasNext()==false) {
		    		last=false;
	    	}
	    	}
		    hsc++;
	    		
	    	
	    }while(last==true);
	    //Sorting country names alphabetically by finding 
	    //the smallest remaining each time
	    int m=s1unsorted.size();
	    for(int i=0;i<m;i++) {
	    	if(i%2==0) {
	    		ow=s1unsorted.pop();
	    		
	    	}
	    	else {
	    		ow=tempstack.pop();
	    		
	    		
	    	}
	    	for(int j=0;j<m-i-1;j++) {
	    		if(i%2==0) {
	    		if(ow.toString().compareTo(s1unsorted.peek().toString())<0) {
	    			tempstack.push(ow);
	    			ow=s1unsorted.pop();
	    			
	    		}
	    		else {
	    			tempstack.push(s1unsorted.pop());
	    			
	    		}
	    		}
	    		else {
	    			if(ow.toString().compareTo(tempstack.peek().toString())<0) {
		    			s1unsorted.push(ow);
		    			ow=tempstack.pop();
		    			
		    		}
		    		else {
		    			s1unsorted.push(tempstack.pop());
		    			
		    		}
	    			
	    		}
	    		
	    		
	    		
	    	}
	    	S1.push(ow);
	    	
	    	
	    }
	   
	    //creating random number to chose X-th country 
	    //then defining the Q1 and Q2 according to the size of chosen country's name
	    int countryrnd = rnd.nextInt(S1.size());
	    System.out.println("Country number:" + (countryrnd+1));
	    if(countryrnd==0) {
	    	Q1size=S1.peek().toString().length();
	    	Q2size=S1.peek().toString().length();
	    	
	    }
	    else {
	    	for(int i=0;i<countryrnd+1;i++) {
		    	tempstack.push(S1.pop());
		    }
	    	Q1size=tempstack.peek().toString().length();
		    Q2size=tempstack.peek().toString().length();
		    for(int i=0;i<countryrnd+1;i++) {
		    	S1.push(tempstack.pop());
		    }
	    }
	    Queue Q1 = new Queue(Q1size);
	    Queue Q2 = new Queue(Q2size);
	    //enqueue the chosen random country into the Q1 and 
	    //creat Q2 accordingly
	    if(countryrnd==0) {
	    	for(int i=0;i<S1.peek().toString().length();i++){
		    	Q1.enqueue(S1.peek().toString().charAt(i)); 
		    }
	    	for(int i=0;i<S1.peek().toString().length();i++){
		    	Q2.enqueue(dash); 
		    }
	    }
	    else {
	    	for(int i=0;i<countryrnd+1;i++) {
		    	tempstack.push(S1.pop());
		    }
		    for(int i=0;i<tempstack.peek().toString().length();i++){
		    	Q1.enqueue(tempstack.peek().toString().charAt(i)); 
		    }
		    for(int i=0;i<tempstack.peek().toString().length();i++){
		    	Q2.enqueue(dash); 
		    }
		    for(int i=0;i<countryrnd+1;i++) {
		    	S1.push(tempstack.pop());
		    }
	    }
	    //Creating S2 Stack by puting all letters in it
	    for(char z='Z';z>='A';z--)
		    S2.push(Character.valueOf(z));
	    boolean win=true;
	    Object pickedletter=0;
	    Stack templetter = new Stack(26);
	    //making the wheel using switch method
	    //13 is the unlucky number therefore it represents the Bankrupt
    	//7 is the lucky number therefore it represents the Double
	    //rest of them are same as their score
	    do {
	    	
	    	int wheelrnd=rnd.nextInt(8);
	    	switch(wheelrnd) {
	    	  case 0:
	    		  thewheel=10;
	    	    break;
	    	  case 1:
	    		  thewheel=50;
	    	    break;
	    	  case 2:
	    		  thewheel=100;
	    	    break;
	    	  case 3:
	    		  thewheel=250;
	    	    break;
	    	  case 4:
	    		  thewheel=500;
	    	    break;
	    	  case 5:
	    		  thewheel=1000;
	    	    break;
	    	  case 6:
	    		  thewheel=7;
	    	    break;
	    	  case 7:
	    		  thewheel=13;
	    		  score=0;
	    	    break;
	    	  default:
	    		  thewheel=0;
	    	}
	    	//choosing random letter by a random number
	    	if(thewheel!=13) {
	    		int letterrnd = rnd.nextInt(S2.size());
		    	if(letterrnd==0) {
		    		pickedletter=S2.pop();
		    		
		    	}
		    	else {
		    		for(int i=0;i<letterrnd+1;i++) {
				    	templetter.push(S2.pop());
				    }
			    	pickedletter=templetter.pop();
			    		for(int i=0;i<letterrnd;i++) {
					    	S2.push(templetter.pop());
					    }
		    	}
	    		
	    	}
	    	//creating output following instructions from the Homework file
	    	System.out.print("Word:");
	    	for(int k=0;k<Q1size;k++) {
	    		
	    		tempQ2=Q2.dequeue();
		    	System.out.print(tempQ2+" ");
		    	Q2.enqueue(tempQ2);
		    }
	    	
	    	System.out.print("          Step:  " +step);
	    	System.out.print("      Score: " +score);
	    	//playing the game by checking if the chosen letter matches the country 
	    	//letters then calculating the score
	    	if(thewheel!=13) {
	    		for(int k=0;k<Q1size;k++) {
		    		
			    	
			    	
		    		tempQ1=Q1.dequeue();
		    		
		    		tempQ2=Q2.dequeue();
			    	if(pickedletter.equals(tempQ1)&&tempQ2.equals(dash)){
			    		Q2.enqueue(tempQ1);
			    		Q1.enqueue(tempQ1);
			    		if(thewheel==7&&dc==false) {
			    			dc=true;
			    			score=score*2;
			    		}
			    		else if(thewheel!=7){
			    			score=score+thewheel;
			    		}
			    	}
			    	else {
			    		Q2.enqueue(tempQ2);
			    		Q1.enqueue(tempQ1);		    		
			    	}
			    	
			    }
	    		dc=false;
	    	}
	    	//creating rest of the output due to the Homework file
	    	System.out.print("          Remaining: " );
	    	int S2size=S2.size();
	    	for(int i=0;i<S2size;i++) {
	    		System.out.print(S2.peek());
	    		S2temp.push(S2.pop());
	    	}
	    	for(int i=0;i<S2size;i++) {
	    		S2.push(S2temp.pop());
	    	}
	    	System.out.print("\n");
	    	switch(wheelrnd) {
	    	  case 0:
	    		  System.out.println("Wheel: "+"10");
	    	    break;
	    	  case 1:
	    		  System.out.println("Wheel: "+"50");
	    	    break;
	    	  case 2:
	    		  System.out.println("Wheel: "+"100");
	    	    break;
	    	  case 3:
	    		  System.out.println("Wheel: "+"250");
	    	    break;
	    	  case 4:
	    		  System.out.println("Wheel: "+"500");
	    	    break;
	    	  case 5:
	    		  System.out.println("Wheel: "+"1000");
	    	    break;
	    	  case 6:
	    		  System.out.println("Wheel: "+"Double Money");
	    	    break;
	    	  case 7:
	    		  System.out.println("Wheel: "+"Bankrupt");
	    	    break;
	    	  default:
	    		  System.out.println("Wheel: ");
	    	}
	    	System.out.println("Guess:"+pickedletter);
	    	//checking if the player has won yet 
	    	win=false;
	    	for(int i=0;i<Q1size;i++) {
	    		tempQ2=Q2.dequeue();
	    		if(tempQ2.equals(dash)) {
	    			win=true;
	    		}
	    			
	    		Q2.enqueue(tempQ2);
	    		  
	    	}
	    	if(win==false)
	    	{
	    		for(int k=0;k<Q1size;k++) {
		    		
		    		tempQ2=Q2.dequeue();
			    	System.out.print(tempQ2+" ");
			    	Q2.enqueue(tempQ2);
			    }
		    	
		    	System.out.print("          Step:  " +step);
		    	System.out.print("      Score: " +score);
		    	System.out.print("          Remaining: " );
		    	S2size=S2.size();
		    	for(int i=0;i<S2size;i++) {
		    		System.out.print(S2.peek());
		    		S2temp.push(S2.pop());
		    	}
		    	for(int i=0;i<S2size;i++) {
		    		S2.push(S2temp.pop());
		    	}
		    	System.out.println("\nYou win $"+score+" !!!");
	    	}
	    	
	    	step++;
	    	dc=false;
	    	
	    }while(win);
	    //after wining the game first sorting the high score table including new players
	    //score then remove last player from the table 
	    m=S4unsorted.size();
	    S4unsorted.push(score);
	    S3unsorted.push("You");
	    for(int i=0;i<m+1;i++) {
	    	if(i%2==0) {
	    		os=S4unsorted.pop();
	    		ow=S3unsorted.pop();
	    		
	    	}
	    	else {
	    		os=tempscore.pop();
	    		ow=tempname.pop();
	    		
	    	}
	    	for(int j=0;j<m-i;j++) {
	    		if(i%2==0) {
	    		if(((Integer)os)>((Integer)S4unsorted.peek())) {
	    			tempscore.push(os);
	    			tempname.push(ow);
	    			os=S4unsorted.pop();
	    			ow=S3unsorted.pop();
	    			
	    		}
	    		else {
	    			tempscore.push(S4unsorted.pop());
	    			tempname.push(S3unsorted.pop());
	    		}
	    		}
	    		else {
	    			if(((Integer)os)>((Integer)tempscore.peek())) {
		    			S4unsorted.push(os);
		    			S3unsorted.push(ow);
		    			os=tempscore.pop();
		    			ow=tempname.pop();
		    			
		    		}
		    		else {
		    			S4unsorted.push(tempscore.pop());
		    			S3unsorted.push(tempname.pop());
		    			
		    		}
	    			
	    		}
	    		
	    		
	    		
	    	}
	    	if(i>0) {
	    		S4.push(os);
		    	S3.push(ow);
	    	}
	    	
	    	
	    	
	    }
	    
	    //writing the high  score table into the "D:\\HighScoreTable.txt"
    	try {
    	      FileWriter myWriter = new FileWriter("/Users/eng.arya/Downloads/2019510113_Maede_Mohamadi/HighScoreTable.txt");
    	      for(int i=0;i<m;i++) {
    	    	  myWriter.write(S3.peek()+"  "+S4.peek()+System.getProperty( "line.separator" ));
    	    	  System.out.print(S3.pop()+"  "+S4.pop()+"\n");
    	      }
    	      myWriter.close();
    	      System.out.println("Highscore table saved!");
    	    } catch (IOException e) {
    	      System.out.println("An error occurred.");
    	      e.printStackTrace();
    	    }
	    	
    	scHigh.close();
	    
	 
	    
	 
	   
		
	   
	    
	}

}
