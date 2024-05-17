package Codsoft_Assignment1;
import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class Task1_Number_Game {

	//creating files
	public void CreatingFile(String name)
	{
		 try {
		        File file = new File(name+".txt");
		        if (file.createNewFile()) 
		        {
		         // System.out.println("File created: " + file.getName());
		        } else
		        {
		         // System.out.println("File already exists.");
		        }
		      } 
		    catch (IOException e) {
		        System.out.println("An error occurred in file creation or opening at the time of name.");
		        e.printStackTrace();
		      }
	}
	
	
	
	
	//playing game
	public void Game()
	{
		String result="";
		
		//System.out.print("\033[H\033[2J"); 
		System.out.println("----------------------------------------------");
		System.out.println("Enter your name : ");
		Scanner obj2 = new Scanner(System.in);  
	    String name = obj2.nextLine(); 
	  //file handling
	    CreatingFile(name);
	    clearConsole();
	    System.out.println("----------------------------------------------");
		System.out.println("-You will get three rounds to guess the number-");
		System.out.println("----------------------------------------------");
		for(int i=0;i<3;i++)
		{
			System.out.println("     ------------Round No : "+i+"------------");
			System.out.println("----------------------------------------------");
			Scanner obj1 = new Scanner(System.in);  
			System.out.println("Enter the guess from 1 to 100: ");
		     
		    if(obj1.hasNextInt())
			{
		    	String guess = obj1.next();
			   if(Integer. parseInt(guess)>=0&&Integer. parseInt(guess)<=100)
				   {
				   int GeneratedNumber=Generate_Number();
				   result=check_Guess(Integer. parseInt(guess),GeneratedNumber);
				   System.out.println();
				   System.out.println("----------------------------------------------");
				   System.out.println("-----------------"+result+"-----------------");
				   System.out.println("-------------Generated Number : "+GeneratedNumber+"-------------");
				   System.out.println("---------------Your Number: "+guess+"----------------");
				   System.out.println("----------------------------------------------");
				   System.out.println();
				  // System.out.println(result);
				 //file handling
				   
				    try {
				        File file = new File(name+".txt");
				        if (file.exists()) 
				        {
				        	FileWriter Write = new FileWriter(file,true);
				        	 Write.write(name);
				        	 Write.write("\n");
				        	 Write.write("Round "+i+" : "+result);
				        	 Write.write("\n");
				        	 Write.write("\n");
				        	 Write.close();
				         
				        } else
				        {
				        	System.out.println("file writing issue.");
					        
				        }
				      } 
				    catch (IOException e) {
				        System.out.println("An error occurred in file creation or opening at the time of name.");
				        e.printStackTrace();
				      }
				   }
			   else
			    {
			    //wrong input	
				   i--;
				   System.out.println("You Entered wrong input. Enter Again");
			    }
		   }
			
		  // System.out.print("\033[H\033[2J"); 
	  
		}
		//display record
		 Read_File(name);
	}
	
	
	
	//reading the file
	public void Read_File(String name)
	{
		clearConsole();
		System.out.println("----------------------------------------------");
		System.out.println("-----------------Score  Board-----------------");
		System.out.println("----------------------------------------------");
		System.out.println("----------------------------------------------");
		
		try {
		      File file = new File(name+".txt");
		      BufferedReader BR = new BufferedReader(new FileReader(file));
	        String str;
	        while ((str = BR.readLine()) != null)
	        {
	        	System.out.println(str);
		      }
	       // clearConsole();
		     // read.close();
		    } 
		catch (IOException e) {
		      System.out.println("An error occurred in display file.");
		      e.printStackTrace();
		    }
	}
	
	
	
	
	//generating the number randomly
	public int Generate_Number()
	{
		return (int) (Math.random()*100+1);
	}
	
	
	
	
	//checking the guess
	public String check_Guess(int guess,int GeneratedNumber)
	{
		
		String result="";
		if(guess==GeneratedNumber)
		{
			//System.out.println(GeneratedNumber);
			result="WIN";			
		}
		else if(guess>GeneratedNumber)
		{
			if(guess-GeneratedNumber>=0&&guess-GeneratedNumber<=20)
			{
				//System.out.println(GeneratedNumber);
				result="Bigger but close";
			}
			else
			{
				//System.out.println(GeneratedNumber);
				result="Too high";
			}
		}
		else 
		{
			if(GeneratedNumber-guess>=0&&GeneratedNumber-guess<=20)
			{
			//	System.out.println(GeneratedNumber);
				result="Smaller but close";
			}
			else
			{
				//System.out.println(GeneratedNumber);
				result="Too Low";
			}
		}
		return result;
	}

	
	
	//clearing console
	 private static void clearConsole() {
	        // Clear console
		 for (int i = 0; i < 10; i++) {
		        System.out.println(); // Print empty line
		    }
	 }
	
	
	//main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Task1_Number_Game game = new Task1_Number_Game();
		
		while(true)
		{
			
		System.out.println("----------------------------------------------");
		System.out.println("------------Welcome to Number Game------------");
		System.out.println("----------------------------------------------");
		System.out.println();
		System.out.println("----------------------------------------------");
		System.out.println("     ------------1. Play Game------------");
		System.out.println("     ------------2. Exit Game------------");
		System.out.println("----------------------------------------------");
		Scanner obj = new Scanner(System.in); 
		 
		
			if(obj.hasNextInt())
			{
				String answer = obj.next();
			if(Integer. parseInt(answer)==1)
			{
				clearConsole();
				game.Game();
				System.out.println("--------------Want to play again?--------------");
				System.out.println("     --------------- 1. Yes --------------     ");
				System.out.println("     --------------- 2. No ---------------     ");
				System.out.println("-----------------------------.-----------------");
				Scanner obj1 = new Scanner(System.in); 
				if(obj1.hasNextInt())
				{
					String answer1 = obj1.next();
				if(Integer. parseInt(answer1)==1)
				{
					clearConsole();
					continue;
				}
				else if(Integer. parseInt(answer1)==2)
				{
					break;
				}
				}
				else
				{
					//wrong input
					
					System.out.println("You Entered wrong input. Back to play Again");
					clearConsole();
					continue;
				}
			}
			else if(Integer. parseInt(answer)==2)
			{
				break;
				//exit();
			}
			}
			else
			{
				//wrong input
				System.out.println("You Entered wrong input. Back to play Again");
				clearConsole();
				continue;
			}
		
		}
		System.out.println("----------------------------------------------");
	}
	
}
