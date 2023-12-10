import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class yahtzeeMain {
	public static void main(String[] args)
			throws FileNotFoundException
	{
	//Defining variables
	File highscore = new File("src/resources/HighScoreTable.txt");
	Scanner scHigh = new Scanner(highscore);
	Scanner scHighc = new Scanner(highscore);
	SingleLinkedList HighScoreTable= new SingleLinkedList();
    SingleLinkedList diceListPlayer1= new SingleLinkedList();
    SingleLinkedList diceListPlayer2= new SingleLinkedList();
    int score1=0,score2=0;
    Boolean flag=false;
    Random rnd= new Random();
    for(int turnCounter=1;turnCounter<11;turnCounter++) {
    	//rolling dice player1
    	for(int diceRnd=0;diceRnd<3;diceRnd++) {
    		diceListPlayer1.add(rnd.nextInt(1, 7));
    	}
    	
    	//rolling dice player2
    	for(int diceRnd=0;diceRnd<3;diceRnd++) {
    		diceListPlayer2.add(rnd.nextInt(1, 7));
    	}
    	
    	//Output
       	System.out.print("Turn: "+turnCounter+"\n"+"Player1: ");
        diceListPlayer1.display();
        System.out.print("   score:"+score1+"\n"+"Player2: ");
        diceListPlayer2.display();
        System.out.print("   score:"+score2+"\n");
      //checking player1 for Large straight
    	flag=true;
    	for(int ls=1;ls<7;ls++) {
    		if(!diceListPlayer1.search(ls))
    			flag=false;
    	}
    	if(flag==true) {
    		score1=score1+30;
    		for(int i=1;i<7;i++) {
    			diceListPlayer1.removeOne(i);
    		}
    		flag=false;
    	}
    	
    	//checking player1 for Yahtzee
    	for(int i=1;i<7;i++) {
    		if(diceListPlayer1.count(i)>3) {
    			score1=score1+10;
    			diceListPlayer1.remove(i);
    		}
    	}
    	//checking player2 for Large straight
    	flag=true;
    	for(int ls=1;ls<7;ls++) {
    		if(!diceListPlayer2.search(ls))
    			flag=false;
    	}
    	if(flag==true) {
    		score2=score2+30;
    		for(int i=1;i<7;i++) {
    			diceListPlayer2.removeOne(i);
    		}
    		flag=false;
    	}
    	//checking player2 for Yahtzee
    	for(int i=1;i<7;i++) {
    		if(diceListPlayer2.count(i)>3) {
    			score2=score2+10;
    			diceListPlayer2.remove(i);
    		}
    	}
    }
    
  //Output
   	System.out.print("End Result: "+"\n"+"Player1: ");
    diceListPlayer1.display();
    System.out.print("   score:"+score1+"\n"+"Player2: ");
    diceListPlayer2.display();
    System.out.print("   score:"+score2+"\n");
    //Highscore table scaning from file
    boolean last=true;
    while(last==true) {
    	Object name=scHigh.next();
    	Object score=scHigh.next();
		HighScoreTable.addscore(name, score);
    	if(scHigh.hasNext()==false) {
    		last=false;
    	}
    }
    //highscore table output
    if(score1>score2) 
    	System.out.println("The winner is player 1.");
    else
    	System.out.println("The winner is player 2.");
    HighScoreTable.addscore("Player1", score1);
    HighScoreTable.addscore("Player2", score2);
    
    Node HSToutscore=HighScoreTable.head;
    Node HSToutname=HSToutscore.getLink();
    System.out.println("High Score Table");	
    //writing Highscore table into the .txt file
    try {
	      FileWriter myWriter = new FileWriter("src/resources/HighScoreTable.txt");
	      for(int i=0;i<10;i++) {
	    	  myWriter.write(HSToutname.getData().toString()+System.getProperty( "line.separator")+HSToutscore.getData().toString()+ System.getProperty( "line.separator"));
	    	  System.out.println(HSToutname.getData().toString()+"  "+HSToutscore.getData().toString());
	    	  HSToutscore=HSToutname.getLink();
	    	  HSToutname=HSToutscore.getLink();
	      }
	      myWriter.close();
	      System.out.println("Highscore table saved!");
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}
}
