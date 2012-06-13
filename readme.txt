Jacqueline D. Brown
CSC 4500 - Introduction to Theorectical Computer Science 
Instructor: Suzanne Jennings
LEXX Project -Part 1 


I implemented each type in a separate JFF File, (i.e, Keywords, Operators, etc.).  I then unioned this files together to create
one big JFF file for the whole project (Lexx Project.jff).

I then mapped this big DFA to the code as follows:
			
			
			States are stored as follows: q[state][value] = nextState
			state= state machine number;
			value= the ascii code of the character
			nextState= move to this state
			f[state] = determines whether state is final or not (true or false)

DFA are mapped to code by token type.  The specific order that they appear in the program helped to lessen the burden of typing in all the transition manually.

Line 31-251 contains the code for the DFA.


Program is written in Java. Simply enter the input file when the dialog box pops up.



