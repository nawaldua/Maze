///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            MyMazeProgram
// Files:            MyMazeProgram.java
// Semester:         Fall 2015
//
// Author:           Nawal Dua
// Email:            ndua2@wisc.edu
// CS Login:         nawal
// Lecturer's Name:  Deb Deppeler
// Lab Section:      311
///////////////////////////////////////////////////////////////////////////////


import java.util.Scanner;
import java.util.Random;

/**
* This Class (CS 302), is one in we are learning Java.
* In this program, users will be able to convert temperatures from F to C. 
* Users will also be able to play a maze game in which they have to get a robot 
* to the exit. A harder vesion is available, in which there will be an obstacle
* and positions of the robot, obstacle and exit are randomized.
*  
* <p>Bugs: None that are currently known.
*
* @author Nawal Dua
*/
public class MyMazeProgram {

    // put method header here
    public static void main(String[] args) {

        // Scanner connected to keyboard for reading user input
        Scanner scnr = new Scanner(System.in);

        // Random number generated seeded according to Config file
        Random rng = new Random(Config.SEED);

        // DISPLAY WELCOME MESSAGE AND HELP
        System.out.print("Welcome to MyMazeProgram!" +"\n"+"\n");
        
        

        // Declare variables and describe their use
        int input = 0;
        double temp = 0;
        int robotRow = 0;
        int robotCol = 0;
        int exitRow = 4;
        int exitCol = 4;
        int moveCounter = 0;
        int mazeSize = 0;
        
        
        // MAIN COMMAND LOOP
        // while the user has not selected the Exit value
        
        while (true){
        	

            // DISPLAY MENU
        
        	System.out.println("1. Temperature Converter"+"\n"+
        	"2. Simple Robot Maze"+"\n"+"3. Random Robot Maze with Obstacle"+
        			"\n"+"4. Exit");
        	
        	
            // DISPLAY COMMAND PROMPT
        	System.out.print("Enter Choice: ");
        	
        
        	
            // IF the user intput is the correct type:
        	if (scnr.hasNextInt()) {
                // READ (SCAN) user input
        		input=scnr.nextInt();
                // Execute command and display results to user

                    // Temp Converter Code 
        		if (input==1){ // Code only runs, if user enters 1
            		System.out.print ("Enter Fahrenheit Temperature: ");
            		scnr.nextLine(); // Clears any input after the 1
            		if (scnr.hasNextDouble()){ // if scanner has a double
            			temp=scnr.nextDouble(); // it sets "temp" as the double
            			System.out.println(temp+"F="+(temp - 32.0)/(1.8)+"C" +
            			"\n");
            			scnr.nextLine(); // clears buffer
            		}
            		else // if scanner didn't detect a double
            				System.out.println("Sorry, can't convert "
            		+scnr.nextLine()+" to C."+"\n");
            	}
                    // Robot Maze code
        		else if (input==2){
            		System.out.print ("Help Robot (R) get to Exit (E)"+"\n");
            		scnr.nextLine(); // clears buffer
            		// starts loop, for when robot is not at exit
            		while (robotRow!=exitRow||robotCol!=exitCol){
            		for (int row=0;row<5; row++){
            			for (int col=0;col<5; col++){
            				if (row==robotRow&&col==robotCol){
            					System.out.print("R ");
            				}
            				else if (row==exitRow&&col==exitCol){
            					System.out.print("E ");
            				}
            				else System.out.print("o ");
            			}
            			System.out.print("\n");
            		}
            		// prints the controls
            		System.out.print("1. up"+"\n"+"2. down"+"\n"+"3. left"+
            		"\n"+"4. right"+"\n");
            		System.out.println("Move? ");
            		if (scnr.hasNextInt()) {
            			input=scnr.nextInt();
            			if (input==1){
            				scnr.nextLine();
            				// does not let robot move out of grid
            				if (robotRow==0){
            					moveCounter++;
            				}
            				else
            				robotRow--;
            				moveCounter++;
            			}
            			else if (input==2){
            				scnr.nextLine();
            				// does not let robot move out of grid
            				if (robotRow==4){
            					moveCounter++;
            				}
            				else
            				robotRow++;
            				moveCounter++;
            			}
            			else if (input==3){
            				scnr.nextLine();
            				// does not let robot move out of grid
            				if (robotCol==0){
            					moveCounter++;
            				}
            				else
            				robotCol--;
            				moveCounter++;
            			}
            			else if (input==4){
            				scnr.nextLine();
            				// does not let robot move out of grid
            				if (robotCol==4){
            					moveCounter++;
            				}
            				else
            				robotCol++;
            				moveCounter++;
            			}
            			else System.out.print ("Sorry, I don't understand that"
            			+"\n"+"\n");
            		}
            		else System.out.print("Sorry, I don't understand that"+"\n"
            		+"\n");
            		}	
            		// prints victory message and number of moves
            		System.out.print("Congratulations! Robot is free!"+"\n"
            		+"It took "+moveCounter+" moves."+"\n"+"\n");
            		// resets robot position and move counter back to original
            		robotRow = 0;
            		robotCol = 0;
            		moveCounter = 0;
            			
            	}
        		else if (input==3){
            		System.out.print ("How big is the maze? (3-10) ");
            		scnr.nextLine();
            		if (scnr.hasNextInt()) {
            			mazeSize=scnr.nextInt();
            			scnr.nextLine();
            			// loop for maze size values that are out of bounds
            			while (mazeSize<3||mazeSize>10){
            				System.out.print("Must be between 3 and 10,"
            						+ " inclusive."+"\n"+"How big is the maze?"
            								+ " (3-10) ");
            				// reads new scnr int so that loop is not infinite
            				if (scnr.hasNextInt()){
            					mazeSize=scnr.nextInt();
                    			scnr.nextLine();
            				}
            				// clears buffer, to prevent infinite loop
            				else scnr.nextLine();
            			}
            			// sets conditions for when maze size is within bounds
            			if (mazeSize>=3&&mazeSize<=10){
            			// initializes variables
            			exitRow = mazeSize-1;
            			robotCol = rng.nextInt(mazeSize);
            			exitCol = rng.nextInt(mazeSize);
            			int xCol = rng.nextInt(mazeSize);
            			int xRow = rng.nextInt(mazeSize-2)+1;
            		// starts loop for when robot is not at exit			
            		while (robotRow!=exitRow||robotCol!=exitCol){
            			System.out.println("Help Robot (R) get to Exit (E)");
                		for (int row=0;row<mazeSize; row++){
                			for (int col=0;col<mazeSize; col++){
                				if (row==robotRow&&col==robotCol){
                					System.out.print("R ");
                				}
                				else if (row==exitRow&&col==exitCol){
                					System.out.print("E ");
                				}
                				else if (row==xRow&&col==xCol){
                					System.out.print("X ");
                				}
                				else System.out.print("o ");
                			}
                			System.out.print("\n");
                		}
                		// prints controls to the user
                		System.out.print("1. up"+"\n"+"2. down"+"\n"+"3. left"
                		+"\n"+"4. right"+"\n");
                		System.out.println("Move? ");
                		if (scnr.hasNextInt()) {
                			input=scnr.nextInt();
                			if (input==1){
                				scnr.nextLine();
                				// does not let robot move out of grid
                				if (robotRow==0){
                					moveCounter++;
                				}
                				// does not let robot go over obstacle
                				else if (robotRow==xRow+1&&robotCol==xCol){
                					moveCounter++;
                				}
                				else 	
                				robotRow--;
                				moveCounter++;
                			}
                			else if (input==2){
                				scnr.nextLine();
                				// does not let robot move out of grid
                				if (robotRow==mazeSize-1){
                					moveCounter++;
                				}
                				// does not let robot go over obstacle
                				else if (robotRow==xRow-1&&robotCol==xCol){
                					moveCounter++;
                				}
                				else 	
                				robotRow++;
                				moveCounter++;
                			}
                			else if (input==3){
                				scnr.nextLine();
                				// does not let robot move out of grid
                				if (robotCol==0){
                					moveCounter++;
                				}
                				// does not let robot go over obstacle
                				else if (robotCol==xCol+1&&robotRow==xRow){
                					moveCounter++;
                				}
                				else 	
                				robotCol--;
                				moveCounter++;
                			}
                			else if (input==4){
                				scnr.nextLine();
                				// does not let robot move out of grid
                				if (robotRow==mazeSize-1){
                					moveCounter++;
                				}
                				// does not let robot go over obstacle
                				else if (robotCol==xCol-1&&robotRow==xRow){
                					moveCounter++;
                				}
                				else 	
                				robotCol++;
                				moveCounter++;
                			}
                			else System.out.print ("Sorry, I don't understand"
                					+ " that"+"\n"+"\n");
                		}
                		else System.out.print("Sorry, I don't understand that"
                		+"\n"+"\n");
                		scnr.nextLine();
                		}	
            		// prints victory message and number of moves
                		System.out.print("Congratulations! Robot is free!"+"\n"
                		+"It took "+moveCounter+" moves."+"\n"+"\n");
                	// resets robot position and move counter back to original
                		robotRow = 0;
                		robotCol = 0;
                		moveCounter = 0;
            	}
            			else System.out.print("Sorry, I don't understand that"
            	+"\n"+"\n"); 
            		}
            		else {System.out.print("Sorry, I don't understand that"+"\n"
            		+"\n");
            		scnr.nextLine();}
        		}
                    // EXIT command
        		else if (input==4){
            		System.out.print ("Live Long And Prosper!");
            		scnr.nextLine();
            		scnr.close();
            		System.exit(0);
            	}
                    // IGNORE UNRECOGNIZED command
        		else if (input<1){
            		System.out.print ("Sorry, I don't understand that"+"\n"+
        		"\n");
            	}
            	else if (input>4){
            		System.out.print ("Sorry, I don't understand that"+"\n"+
            	"\n");
            	}
            	
            // ELSE the input is incorrect type

                // READ (SCAN) user input as a String
                // Display bad type message to user

           

        }
        	else {System.out.print ("Sorry, I don't understand that"+"\n"+"\n");
        	scnr.nextLine();}
        	
        

        // Close the scanner to avoid potential resource leak
        
        } 
    } // end of main method

}
// end of MyMazeProgram class
