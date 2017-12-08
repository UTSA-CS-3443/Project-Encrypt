# Project-Encrypt

1. 	Objective:
	The objective of Project Encrypt is to correctly decrypt all words in a given game in as few mutations as possible.
	There are four unique levels, each with three unique encrypted words, increasing in difficulty from Level 1 to Level 4.

2.	Gameplay Overview:
	- To play a game, choose "Start" from the Main Menu or choose a specific level by first choosing "Level Select".
	- Once a game is loaded, the user will click on "START" to view the first of three encrypted words and begin decrypting.
	- Users will then execute a series of substitutions and/or shifts to achieve the desired decryption.
	- Once ready to grade their decryption, users will choose "Check Answer" to recieve a score and proceed to the next word in the level.
	- A game is completed and a final score is recorded when all words in the level have been decrypted. 
	- After completing a game, users may click "Quit to Main Menu" to exit, start a new game, and/or choose a different level.

3. 	MainView Actions
	- Start:			Starts a new game (Level 1 by default).
	- Level Select:	Allows user to choose a level to play.
	- Scores: 		Allows user to view high scores for each individual level.
	- Quit:			Displays final message to user and closes the application after 5 seconds.

4.	GameView Actions
	- START:				Starts the current game. User must click on START before the game becomes playable.
	- Reset Encryption:	Allows user to return to the original encryption of the current word. Useful when user decides to try another strategy in decrypting the word.
	- Submit:			Allows user to submit required text input when substituting or shifting.
	- Substitution:		Allows user to substitute all instances of a particular letter in the current encryption with another letter. 
	- Shift:				Allows user to shift the current encryption by a particular number of increments to the ASCII value of each character (character range of a-z).
	- Check Answer:		Allows user to grade their current decryption by comparing it to the actual current word. Also updates total score for the current game.
	- Quit to Main Menu:	Allows user to return to the main menu. No score is recorded if user exits before finishing a game.
	
5. 	LevelView Actions
	- Level 1:			Allows user to start new game on Level 1
	- Level 2:			Allows user to start new game on Level 2
	- Level 3:			Allows user to start new game on Level 3
	- Level 4: 			Allows user to start new game on Level 4
	- Back to Main Menu:	Allows user to return to the main menu.
	
6.	ScoresView Actions
	- Level 1 Scores: 	Allows user to view top four (4) high scores recorded for Level 1
	- Level 2 Scores: 	Allows user to view top four (4) high scores recorded for Level 2
	- Level 3 Scores: 	Allows user to view top four (4) high scores recorded for Level 3
	- Level 4 Scores: 	Allows user to view top four (4) high scores recorded for Level 4
	- Back to Main Menu:	Allows user to return to the main menu. 
	
7. 	HighScoreView Actions
	- Back to Scores Menu:	Allows user to return to the scores menu. 
	- Back to Main Menu:		Allows user to return to the main menu.
	
8. 	QuitView Actions
	- Cancel:	Allows user to return to Main Menu if they click before five (5) seconds have passed.
	- Entire application closes five (5) seconds after loading this view if no user action is taken. 
	
9.	Encryption Key (Actual words and how to decrypt):
	- Level 1:	"class" (Shift), "application" (Substitution), "java" (Substitution)
	- Level 2:	"interface" (Substitution), "method" (Substitution), "strings" (Shift)
	- Level 3:	"collection" (Shift), "integer" (Shift), "dependency" (Shift)
	- Level 4: 	"synchronized" (Shift), "encryption" (Shift), "abstract" (Shift)