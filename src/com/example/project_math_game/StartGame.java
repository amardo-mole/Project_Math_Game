/*
 * Author				 : Amardo Mole
 * Date					 : November 05, 2013
 * FileName/s			 : StartGame.java
 * Notes on program 	 : This Currently is the Math Game main program part. It creates questions and their answers
 * 						   then displays the questions and if the user makes the right rounded answer (displayed in editview box) the
 * 						   game shows "GOOD!" and if the incorrect answer is shown, the game displays "NOOOOOO!". It also shows scoring
 * 						   for the game based on difficulty of 'options' page selections that is currently in the database. It has the
 * 						   ability through algorithms and iteration to dynamically create questions based on 'Options' database rows information.
 * sources for code ideas: None.
 */
package com.example.project_math_game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * The Class StartGame creates a keypad that has events to enter numbers into a editview, enter, clear, backspace answer, make
 * answer positive or negative and creates questions and their answers then displays the questions in a textview and will
 * (coming soon) have a timer. The game then checks answers given by user and displays feedback if answer entered rounded
 * up is correct or incorrect.
 */
public class StartGame extends Activity implements OnClickListener, Serializable {

	/** This is the serial id for this object.	 */
	private static final long serialVersionUID = -3169993484344127987L;

	/** The stored questions. */
	List<String[ ][ ]> storedQuestions = new ArrayList<String[ ][ ]>();

	/** The stored questions current list item. */
	int storedQuestionsCurrentListItem = 0;

	/** The current question. */
	int currentQuestion;

	/** The selected math type. */
	int[] selectedMathType = {1,2,3,4};

	/** The random number generator. */
	Random randomNumberGenerator;

	/** The keypad1. */
	Button keypad1;

	/** The keypad2. */
	Button keypad2;

	/** The keypad3. */
	Button keypad3;

	/** The keypad4. */
	Button keypad4;

	/** The keypad5. */
	Button keypad5;

	/** The keypad6. */
	Button keypad6;

	/** The keypad7. */
	Button keypad7;

	/** The keypad8. */
	Button keypad8;

	/** The keypad9. */
	Button keypad9;

	/** The keypad0. */
	Button keypad0;

	/** The keypad period. */
	Button keypadPeriod;

	/** The keypad backspace. */
	Button keypadBackspace;

	/** The keypad clear completely. */
	Button keypadClearCompletely;

	/** The keypad enter. */
	Button keypadEnter;

	/** The keypad plus. */
	Button keypadPlus;

	/** The keypad minus. */
	Button keypadMinus;

	/** The math question. */
	TextView mathQuestion;

	/** The game score. */
	TextView gameScore;

	/** The view question answer. */
	EditText viewQuestionAnswer;

	/** The temporary true or false of answer screen. */
	TextView trueFalseofAnswer;

	/** The game timer (coming soon). */
	TextView gameTimer;

	/** The number amount. Number amounts: 0 = 2 numbers, 1 = 3 numbers, 2 = 4 numbers.*/
	private int numberAmount;

	/** The question type. Types of questions:
	 * 0 = addition,
	 * 1 = subtraction,
	 * 2 = addition and subtraction,
	 * 3 = Division,
	 * 4 = Multiplication,
	 * 5 = Division and Multiplication,
	 * 6 = All Choices
	 */
	private int questionType;

	/** The gameplay type. Gameplay types: 0 = Practice Mode, 1 = Timed Mode (With Scoring).*/
	private int gameplayType;

	/** The questions total. */
	private int questionsTotal = 0;

	/** The questions correct. */
	private int questionsCorrect = 0;

	private CountDownTimer timedModeTimer;


	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 * Creates and displays user view and creates a keypad that has events to enter numbers into a editview,
	 * enter, clear and backspace answer, creates questions and their answers then displays the questions in a textview.
	 */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setting the gui xml page for this activity
		setContentView(R.layout.start_game);

		//setting up the random number generator for question creation
		randomNumberGenerator = new Random();

		//setting the button variables to the xml page buttons
		keypad1 = (Button) findViewById(R.id.keypad_1);
		keypad1.setOnClickListener(this);

		keypad2 = (Button) findViewById(R.id.keypad_2);
		keypad2.setOnClickListener(this);

		keypad3 = (Button) findViewById(R.id.keypad_3);
		keypad3.setOnClickListener(this);

		keypad4 = (Button) findViewById(R.id.keypad_4);
		keypad4.setOnClickListener(this);

		keypad5 = (Button) findViewById(R.id.keypad_5);
		keypad5.setOnClickListener(this);

		keypad6 = (Button) findViewById(R.id.keypad_6);
		keypad6.setOnClickListener(this);

		keypad7 = (Button) findViewById(R.id.keypad_7);
		keypad7.setOnClickListener(this);

		keypad8 = (Button) findViewById(R.id.keypad_8);
		keypad8.setOnClickListener(this);

		keypad9 = (Button) findViewById(R.id.keypad_9);
		keypad9.setOnClickListener(this);

		keypad0 = (Button) findViewById(R.id.keypad_0);
		keypad0.setOnClickListener(this);

		keypadPeriod = (Button) findViewById(R.id.keypad_period);
		keypadPeriod.setOnClickListener(this);

		keypadBackspace = (Button) findViewById(R.id.keypad_backspace);
		keypadBackspace.setOnClickListener(this);

		keypadClearCompletely = (Button) findViewById(R.id.keypad_clear_completely);
		keypadClearCompletely.setOnClickListener(this);

		keypadEnter = (Button) findViewById(R.id.keypad_enter);
		keypadEnter.setOnClickListener(this);

		keypadPlus = (Button) findViewById(R.id.keypad_plus);
		keypadPlus.setOnClickListener(this);

		keypadMinus = (Button) findViewById(R.id.keypad_minus);
		keypadMinus.setOnClickListener(this);

		//stuff for feedback to math game user editviews and textviews
		mathQuestion = (TextView) findViewById(R.id.math_question);
		viewQuestionAnswer = (EditText) findViewById(R.id.answer_edit_text_area);
		trueFalseofAnswer = (TextView) findViewById(R.id.start_game_answer_status);
		gameScore = (TextView) findViewById(R.id.game_score);
		gameTimer = (TextView) findViewById(R.id.timer_for_game);

		//return to menu button
		View menuReturnButton = findViewById(R.id.menuReturn);
		menuReturnButton.setOnClickListener(this);

		//check if there is any table or rows in the options table, and if none, enter 1 options table row.
		if(countTableRowsData() == 0){
			enterTableData (0, 2, 0);
		}

		//setup and show questions
		setupGame();
		setupQuestions();
		showQuestion();
	}

	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 *The on click creates keypad events for the buttons and checking of entry if valid or invalid input (ex. 2 decimal places not allowed).
	 *
	 */
	@Override
	public void onClick(View v) {
		// getting mathquestion information and length
		Editable mathGameText = viewQuestionAnswer.getText();
		int mathTextLength = viewQuestionAnswer.getText().length();

		/*
		 * making sure that only one decimal number is input by using this if statement.
		 * since indexof() first index check starts at 0, 1 has to be added for matching
		 * mathTextLength which starts at 1 when it has a value. Also since 1 decimal place
		 * is wanted for math game, 1 is added, in addition of the previous addition
		 * making +2.
		 *
		 * When loop runs, it will allow minimum length of 3 or 1 decimal and 1 number before
		 * checking when the decimals length reaches a certain size. mathGameText decimal position
		 * index check, when has decimal, remains a value that is 1 higher than mathTextLength.
		 * mathTextLength increases until it reaches the mathGameText decimal position index check.
		 */
		if(mathTextLength < 2 || !(mathGameText.toString().indexOf(".") +2 == mathTextLength) ){
			switch (v.getId()) {
			case R.id.keypad_1:
				viewQuestionAnswer.setText(mathGameText + "1");
				break;
			case R.id.keypad_2:
				viewQuestionAnswer.setText(mathGameText + "2");
				break;
			case R.id.keypad_3:
				viewQuestionAnswer.setText(mathGameText + "3");
				break;
			case R.id.keypad_4:
				viewQuestionAnswer.setText(mathGameText + "4");
				break;
			case R.id.keypad_5:
				viewQuestionAnswer.setText(mathGameText + "5");
				break;
			case R.id.keypad_6:
				viewQuestionAnswer.setText(mathGameText + "6");
				break;
			case R.id.keypad_7:
				viewQuestionAnswer.setText(mathGameText + "7");
				break;
			case R.id.keypad_8:
				viewQuestionAnswer.setText(mathGameText + "8");
				break;
			case R.id.keypad_9:
				viewQuestionAnswer.setText(mathGameText + "9");
				break;
			case R.id.keypad_0:
				viewQuestionAnswer.setText(mathGameText + "0");
				break;
			}
		}

		//a control structure for all other buttons that are not numbers.
		switch (v.getId()) {
		case R.id.keypad_period:
			if(!mathGameText.toString().contains(".")){
				viewQuestionAnswer.setText(mathGameText + ".");
			}
			break;
		case R.id.keypad_backspace:
			if (mathTextLength > 0){
				viewQuestionAnswer.getText().delete(mathTextLength -1, mathTextLength);
			}
			break;
		case R.id.keypad_minus:
			if(!mathGameText.toString().contains("-")){
				viewQuestionAnswer.setText("-" + mathGameText);
			}
			break;
		case R.id.keypad_plus:
			if(mathGameText.toString().contains("-")){
				viewQuestionAnswer.setText(mathGameText.delete(0,1));
			}
			break;
		case R.id.keypad_clear_completely:
			viewQuestionAnswer.setText("");
			break;
		case R.id.keypad_enter:
			questionsTotal++;
			if(checkAnswer()){
				trueFalseofAnswer.setText("Good!");
				questionsCorrect++;
				scoring(2);
			} else {
				trueFalseofAnswer.setText("NOOOOOO!");
				scoring(-1);
			}
			viewQuestionAnswer.setText("");

			//once all questions have been answered (0-9) and in practice mode, end the game
			if (currentQuestion == 10 && gameplayType == 0){
				endGame();
			}

			//once 10 questions have been answered (0-9) and in timed mode, create new questions for next question pool
			if (currentQuestion == 10 && gameplayType == 1){
				timedMode();
			}

			//once 20 questions have been answered (10-19) and in timed mode, create new questions for next question pool
			if (currentQuestion == 20 && gameplayType == 1){
				storedQuestionsCurrentListItem++;
				currentQuestion = 0;
			}

			//if answered 10 questions, do not display a question on next 'enter' press.
			if (currentQuestion != 10 && gameplayType == 0 || gameplayType == 1){
				showQuestion();
			}
			break;
		case R.id.menuReturn://if press return to menu button, stop timer if created and go to main menu activity.
			if (timedModeTimer != null){
				timedModeTimer.cancel();
			}
			Intent i1 = new Intent(this, MathGameActivity.class);
			startActivity(i1);
			break;

		}
	}

	/**
	 * Creates the ten questions. Uses addition, subtraction, multiplication and division currently for all questions.
	 */
	public void createQuestions(){

		if(gameplayType == 0){//set up questions for practice mode.
			practiceMode();
		}
		else if(gameplayType == 1){//set up questions for Timed Mode (With Scoring).
			timedMode();
		}
	}//end of method createTenQuestions()

	/**
	 * Show question. Displays question in a textview.
	 */
	public void showQuestion(){
		mathQuestion.setText(storedQuestions.get(storedQuestionsCurrentListItem)[currentQuestion][0]);
	}

	/**
	 * Check answer. Does some checking (Input handling for bad inputs) to see if answer is valid input then will
	 * return a boolean saying if answer is correct or incorrect.
	 *
	 * @return true, if successful
	 */
	public boolean checkAnswer(){
		// viewQuestionAnswer.getText ();
		double actualAnswerToQuestion = Double.parseDouble(storedQuestions.get(storedQuestionsCurrentListItem)[currentQuestion][1]);
		String userInputAsString = viewQuestionAnswer.getText().toString();
		double userInputAsDouble;
		boolean answer = false;
		//safety loop for checking if string is empty or only has period before using Double.parseDouble() method
		if(viewQuestionAnswer.length() != 0 && !userInputAsString.equals(".")  && !userInputAsString.equals("-") && !userInputAsString.equals("-.")){
			userInputAsDouble = Double.parseDouble(userInputAsString);
			if(actualAnswerToQuestion == userInputAsDouble){
				answer = true;
			}
		} else{
			answer = false;//if input was invalid, question is incorrect
		}
		currentQuestion += 1; //question counter increases
		return answer;
	}

	/**
	 * Setup questions. Resets flag of current question user is on and runs method createQuestions() to create 10 questions.
	 */
	public void setupQuestions(){
		currentQuestion = 0;
		createQuestions();
	}

	/**
	 * Setup game. Goes to the database for the options that have been selected for the game.
	 */
	private void setupGame() {
		//get options for game stored in the database table options for the options in the game.
		MathGameDatabaseHandler dbObjectHandler = new MathGameDatabaseHandler(this, null, null, 1);
		OptionsSelectTable tempTable1 = new OptionsSelectTable();
		tempTable1 = dbObjectHandler.selectOptionsRow();
		this.numberAmount = tempTable1.getTablesStoredNumberAmount();
		this.questionType = tempTable1.getTableStoredQuestionType();
		this.gameplayType = tempTable1.getTableStoredGameplayType();

		//create a countdown timer that activated endGame() when timer runs out.
		if (gameplayType == 1){
			timedModeTimer = new CountDownTimer(31000, 1000) {

				public void onTick(long millisSecondsUntilFinished) {
					gameTimer.setText("" + millisSecondsUntilFinished / 1000);
				}

				public void onFinish() {
					gameTimer.setText("Game Complete!");
					endGame();
				}
			}.start();
		} else if (gameplayType == 0){//if in practice mode, no timer
			gameTimer.setText("Practice Mode");
		}
	}

	/**
	 * Practice mode. No timer and create 20 questions but can only play 10 questions max.
	 */
	private void practiceMode(){

		double creatingAnswer = 0.0;
		int operator1;
		int operator2;
		String answer;
		String question;
		String[ ][ ] twentyCreatedQuestions = new String[20][2];
		int counter = 0;

		for(int i = 0;i<20;i++){

			//create the first number
			operator1 = randomNumberGenerator.nextInt(30) + 1;
			creatingAnswer = operator1;
			question = operator1 + " ";

			/*
			 * This loop is for creating the equation and of the second through to 4th number.
			 * - generateQuestionTypeRange() is the type of math available in the problem, gets a random number within question type range.
			 * - (numberAmount + 1) is the length of the problem adding 1 operation and 1 operand.
			 */
			while( counter < (numberAmount + 1) ){
				counter++;
				switch (selectedMathType[generateQuestionTypeRange()]){
				case 1:
					operator2 = randomNumberGenerator.nextInt(30) + 1;
					creatingAnswer += operator2;
					question += "+ " + operator2 + " ";
					break;
				case 2:
					operator2 = randomNumberGenerator.nextInt(30) + 1;
					creatingAnswer -= operator2;
					question += "- " + operator2 + " ";
					break;
				case 3:
					operator2 = randomNumberGenerator.nextInt(30) + 1;
					creatingAnswer /= operator2;
					question += "/ " + operator2 + " ";
					break;
				case 4:
					operator2 = randomNumberGenerator.nextInt(30) + 1;
					creatingAnswer *= operator2;
					question += "X " + operator2 + " ";
					break;
				}//end of switch selection
			}//end of while loop for switch selection
			question += "?";
			creatingAnswer = (double)Math.round(creatingAnswer * 10) / 10;
			answer = String.valueOf(creatingAnswer);
			twentyCreatedQuestions[i][0] = question;
			twentyCreatedQuestions[i][1] = answer;
			counter = 0;//resetting the counter
		}//end of 'for' loop
		storedQuestions.add(twentyCreatedQuestions);
	}//end of method practiceMode()

	/**
	 * Generate question type range. If question type is a certain value, then play only questions of those values.
	 *
	 * @return the int
	 */
	private int generateQuestionTypeRange(){

		int questionTypeRange = 0;

		if(questionType == 0){
			questionTypeRange = 0;
		}else if(questionType == 1){
			questionTypeRange = 1;
		}else if(questionType == 2){
			questionTypeRange = randomNumberGenerator.nextInt(2);
		}else if(questionType == 3){
			questionTypeRange = 2;
		}else if(questionType == 4){
			questionTypeRange = 3;
		}else if(questionType == 5){
			questionTypeRange = randomNumberGenerator.nextInt(2) + 2;
		}else if(questionType == 6){
			questionTypeRange = randomNumberGenerator.nextInt(4);
		}
		return questionTypeRange;
	}

	/**
	 * Timed mode. creates 20 questions and this method is run after every 10 questions in a question buffer pool is used.
	 */
	private void timedMode(){

		double creatingAnswer = 0.0;
		int operator1;
		int operator2;
		String answer;
		String question;
		String[ ][ ] twentyCreatedQuestions = new String[20][2];
		int counter = 0;

		for(int i = 0;i<20;i++){

			//create the first number
			operator1 = randomNumberGenerator.nextInt(30) + 1;
			creatingAnswer = operator1;
			question = operator1 + " ";

			/*
			 * This loop is for creating the equation and of the second through to 4th number.
			 * - generateQuestionTypeRange() is the type of math available in the problem, gets a random number within question type range.
			 * - (numberAmount + 1) is the length of the problem adding 1 operation and 1 operand.
			 */
			while( counter < (numberAmount + 1) ){
				counter++;
				switch (selectedMathType[generateQuestionTypeRange()]){
				case 1:
					operator2 = randomNumberGenerator.nextInt(30) + 1;
					creatingAnswer += operator2;
					question += "+ " + operator2 + " ";
					break;
				case 2:
					operator2 = randomNumberGenerator.nextInt(30) + 1;
					creatingAnswer -= operator2;
					question += "- " + operator2 + " ";
					break;
				case 3:
					operator2 = randomNumberGenerator.nextInt(30) + 1;
					creatingAnswer /= operator2;
					question += "/ " + operator2 + " ";
					break;
				case 4:
					operator2 = randomNumberGenerator.nextInt(30) + 1;
					creatingAnswer *= operator2;
					question += "X " + operator2 + " ";
					break;
				}//end of switch selection
			}//end of for loop for switch selection
			question += "?";
			creatingAnswer = (double)Math.round(creatingAnswer * 10) / 10;
			answer = String.valueOf(creatingAnswer);
			twentyCreatedQuestions[i][0] = question;
			twentyCreatedQuestions[i][1] = answer;
			counter = 0;//resetting the counter
		}//end of 'for' loop
		storedQuestions.add(twentyCreatedQuestions);
	}//end of method timedMode()


	/**
	 * Scoring. The game has scoring based on the length and question type complexity of a question.
	 *
	 * @param answerStatus the answer status
	 */
	private void scoring(int answerStatus){
		int multiplier = 0;
		int score = 0;

		//adding score multiplier based on question type difficulty
		if(questionType == 3 || questionType == 4){
			multiplier += 2;
		}else if(questionType == 5 || questionType == 6){
			multiplier += 3;
		} else {
			multiplier += 1;
		}

		//adding score multiplier based on question number length difficulty
		if(numberAmount == 2){
			multiplier += 2;
		}
		multiplier *= answerStatus;
		score = Integer.valueOf(gameScore.getText().toString()) + multiplier;
		gameScore.setText(String.valueOf(score));
	}

	/**
	 * Enter table data. Enter some table data for the options table if there is currently no rows in the database table options.
	 *
	 * @param numberAmount the number amount
	 * @param questionType the question type
	 * @param gameplayType the gameplay type
	 */
	public void enterTableData (int numberAmount, int questionType, int gameplayType) {
		MathGameDatabaseHandler dbObjectHandler = new MathGameDatabaseHandler(this, null, null, 1);
		OptionsSelectTable tempTable1 = new OptionsSelectTable(numberAmount, questionType, gameplayType);
		dbObjectHandler.insertRowOptions(tempTable1);
	}

	/**
	 * Count table rows data. This is done to see if there are any rows in the options table in the database.
	 *
	 * @return the int
	 */
	public int countTableRowsData () {
		MathGameDatabaseHandler dbObjectHandler = new MathGameDatabaseHandler(this, null, null, 1);
		int rowCount = dbObjectHandler.selectCountOfRowsOptions();
		return rowCount;
	}

	/**
	 * End game. Runs when end game conditions are met.
	 */
	public void endGame(){
		Intent i = new Intent(StartGame.this, ResultsOfGame.class);
		i.putExtra("Number_Amount", Integer.toString(numberAmount));
		i.putExtra("Question_Type", Integer.toString(questionType));
		i.putExtra("Gameplay_Type", Integer.toString(gameplayType));
		i.putExtra("Total_Questions_Asked", Integer.toString(questionsTotal));
		i.putExtra("Total_Correct_Answers", Integer.toString(questionsCorrect));
		i.putExtra("Game_Score", gameScore.getText().toString());
		startActivity(i);
	}

}
