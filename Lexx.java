/**
* Name: Jacqueline D. Brown, aw4025@wayne.edu
* Class: CSC 4500 - Introduction to Theroretical Computer Science
* Instructor: Suzanne Jennings
* Description:  
* Due: 03/21/2010
*/

import java.util.Scanner;
import javax.swing.JFileChooser;

public class Lexx {
	public static void main(String[]args) throws Exception {
	
		/* Initialization */
		
		//Variables
		final int NUM_STATE_MACHINES = 41; //Number of state machines
		final int NUM_CHARS=127; // Number of characters in alphabet, corresponds to ASCII code
		final int TRAP_STATE=32; // Holds value of trap state
		
		int[][]q=new int[NUM_STATE_MACHINES][NUM_CHARS]; // Array to hold state machines
		boolean f[]= new boolean[NUM_STATE_MACHINES]; //Determines final and non final states
		String []id= new String[100]; // Array to hold identifiers
		
		int start, end; //Used to fill values across multiple states
		int identifier=-1;
		int number;
		
		
		//Initialize states to trap state
		for (int state=0; state<NUM_STATE_MACHINES; state++)
		{
			for (int index=0; index<NUM_CHARS; index++)
			{	
				q[state][index]=TRAP_STATE;
			}
		}
		
		//All states are final, except trap state
		for (int state=0; state<NUM_STATE_MACHINES; state++)
		{
			f[state]=true;
		}
		
		f[TRAP_STATE]=false; //Trap State
		
		
		/* DFA Initialization */
		
		
		
		
		/* States are stored as follows: q[state][value] = nextState
			state= state machine number;
			value= the ascii code of the character
			nextState= move to this state
			f[state] = determines whether state is final or not (true or false)
			*/
		
		
		//Identifiers
		
		//a -z
		start=(int)'a';
		end=(int)'z';
		
		for (int state=0; state<NUM_STATE_MACHINES; state++)
			{
		for (int i=start; i<=end; i++)
		{	q[state][i]=8;
			}
			}
		
		//0-9
		start=(int)'0';
		end=(int)'9';
		for (int state=0; state<NUM_STATE_MACHINES; state++)
		{
		for (int i=start; i<=end; i++)
		{
		
			q[state][i]=8;
		}
		}
		
		// Comments
		
		q[0][(int)'/']= 15;
		q[15][(int)'/']= 25;
		
		
		for (int index=0; index<NUM_CHARS; index++)
		{
			q[25][index]=25; // Accept all characters after slashes
		}
		
		f[25]=true; //Final State
		
		//-----------------------------------------------------------------
		
		
		
		// Quoted Strings
		
		q[0][34]= 14; 
		
		for (int index=0; index<NUM_CHARS; index++)
		{
			q[14][index]= 14; //Accept all characters between quotes
		}
		
		q[14][34] =24; //Transition on "
		
		f[24]=true; //Final State for Quoted Strings
		
		
			
		//DFA - Comments (Stored in file: Comments.jff);
		
		q[0][(int)'/']= 15;
		q[15][(int)'/']= 25;
		
		f[25]=true; //Final State -Comments
		
		for (int index=0; index<NUM_CHARS; index++)
		{
			q[4][index]=25; // Accept all characters after slashes
		}
		
		
		//Integers
		
		//0-9
		start=(int)'0';
		end=(int)'9';
		for (int i=start; i<=end; i++)
		{
			q[0][i]=4;
			q[4][i]=4;
			}
			
		f[4]=true; //Accept integer
			
		
		
		//DFA - Operators
		
		// +,-, /, *
		q[0][(int)'+']=5;
		q[0][(int)'-']=5;
		q[0][(int)'/']=15;
		q[0][(int)'*']=5;
		
		// <,>, =
		q[0][(int)'>']=1;
		q[0][(int)'<']=1;
		q[0][(int)'=']=1;
		
		// <=, >=, ==
		q[1][(int)'=']=5;
		
		q[0][(int)'!']=16;
		q[16][(int)'=']=5;
		
		
		//DFA- ( ) ;
		q[0][(int)'(']= 2;
		q[0][(int)')']=2;
		
		f[2]=true;  // Final State- Parenthesis
		
		q[0][(int)';']=6;
		
		f[6]=true; //Final State- Semicolon
		
		
	
		
		
		
		
		
		//DFA - Key Words (Store in file: Keywords.jff)
		
		//if
		q[0][(int)'i']=11;
		q[11][(int)'f']=20;
		
		
		//then
		q[0][(int)'t']=10;
		q[10][(int)'h']=21;
		q[21][(int)'e']=29;
		q[29][(int)'n']=20;
		
		//else
		q[0][(int)'e']=3;
		q[3][(int)'l']=18;
		q[18][(int)'s']=27;
		q[27][(int)'e']=20;
		
		//endif
		q[0][(int)'e']=3;
		q[3][(int)'n']=17;
		q[17][(int)'d']=26;
		q[26][(int)'i']=11;
		q[11][(int)'f']=20;
		
		//while
		q[0][(int)'w']=12;
		q[12][(int)'h']=22;
		q[22][(int)'i']=30;
		q[30][(int)'l']=35;
		q[35][(int)'e']=20;
		
		
		//do
		q[0][(int)'d']=9;
		q[9][(int)'o']=20;
		
		//endwhile
		q[0][(int)'e']= 3;
		q[3][(int)'n']= 17;
		q[17][(int)'d']=26;
		q[26][(int)'w']=12;
		q[12][(int)'h']=22;
		q[22][(int)'i']=30;
		q[30][(int)'l']=35;
		q[35][(int)'e']=20;
		
		
		
		//print
		q[0][(int)'p']=13;
		q[13][(int)'r']=23;
		q[23][(int)'i']=31;
		q[31][(int)'n']=36;
		q[36][(int)'t']=20;
		
		//newline
		q[0][(int)'n']=7;
		q[7][(int)'e']=19;
		q[19][(int)'w']=28;
		q[28][(int)'l']=34;
		q[34][(int)'i']=38;
		q[38][(int)'n']=40;
		q[40][(int)'e']=20;
		
		
		f[20]=true; //Final State for Keywords
		
		
		
		
		
		
		/* Program begins here */
		
		int linenum=0; // Number of lines read
		
		
		//Get file
		JFileChooser fileChooser= new JFileChooser();
		if (fileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
		
		java.io.File file = fileChooser.getSelectedFile();
		Scanner input= new Scanner(file);
		
		//Read text from file
		while (input.hasNext()) {
			
			linenum+=1;
			String line=input.nextLine(); 
			
			
			//Process line of text;
			int state=DFA(line,q); 
			
			// Accept or reject string
			if (f[state])
			{
				switch(state) {
				
					case 1:
					case 5: 
					case 15: System.out.println("operator: "+ line); //Operator
					break;
					
					case 2: System.out.println("parenthesis: "+ line); //Parenthesis
					break;
							
					case 4: number=Integer.parseInt(line);
							System.out.println("integer: " + number); //Integers
					break;
					
					case 6: System.out.println("semicolon: "+line); //Semicolon
					break;
					
					case 20: System.out.println("keyword: " +line); // Keywords
					break;
					
					case 24: //Quoted String
							System.out.println("quoted string: " + removeQuotes(line));
					break;
							
					case 25:  //Comment, do nothing
					break;
					
					}
					if (( state!=1) && (state!=5)&& (state!=2) && (state!=4) && (state!=6 ) && (state!=20) && (state!=24) && (state!=25) && (state!=15)) // Identifiers
					{		
							
							if (!idsearch(line,id,identifier))
							{
								System.out.println("NEW identifier: "+ "\"" + line + "\"");
								identifier+=1;
								id[identifier]=line;
								
							}
							else
							{
								System.out.println("identifer: "+ "\"" + line + "\"" + " already in table"); 
							}
					}
				}
				
			else
			{
				System.out.println("Error - line "+ linenum + ". Program terminated.");
				System.exit(0);
			
			}
		}
			
		//Close the file
		input.close();
	}
		else
		{ 
			System.out.println("No file selected");
			}
	
	} // End
	
	/*
	DFA Simulator
	
	Description: This function stimulates a DFA state machine.
	Input: a line of text
	Ouput: current state of machine after text is processed.
	*/
	public static int DFA(String input, int[][]q)
	{
		int state=0; // Initial state is 0.
		for (int i=0; i<input.length(); i++)
		{
		state=q[state][(int)input.charAt(i)];
		}
	return state;
	}
	
	/* RemoveQuotes Function
		Description: Removes quotes from a quoted string */
		
		public static String removeQuotes(String l)
		{
			int len=l.length()-1;
			String s=l.substring(1, len);
			s=s+ "\0";
			return s;
			}
			
	public static boolean idsearch(String i, String []id, int identifier)
	{
		if (identifier==-1)
		{
		return false; 
		}
		for (int j=0; j<identifier; j++)
		{
		if (id[j].equals(i))
		{
		return true;
		}
		}
		return false;
	}
			
	
	
	} // End of program
	
	
		