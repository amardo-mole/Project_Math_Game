/*
 * Author				 : Amardo Mole
 * Date					 : November 05, 2013
 * FileName/s			 : ResultsOfGame.java
 * Notes on program 	 : This part of the program shows the results screen for the math game program. High scores will
 * 						   be stored in a database by inputting initials into textbox and selecting "submit to high score" button.
 * sources for code ideas: None.
 */
package com.example.project_math_game;

import java.io.Serializable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * The Class ResultsOfGame. This cless shows the score gotten from the game. Allows only timed mode to enter scores to high score screen.
 */
public class ResultsOfGame extends Activity implements OnClickListener, Serializable {

	/** This is the serial id for this object.	 */
	private static final long serialVersionUID = -1955367652572118294L;

	/** The view initials input. */
	EditText viewInitialsInput;

	/** The game score. */
	TextView gameScore;

	/** The temp table1. */
	HighScoreTable tempTable1;

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 * The onCreate method sets and displays the layout for this object's page.
	 */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.results_screen);

		//setting up click listeners
		View menuReturnButton = findViewById(R.id.menuReturn);
		menuReturnButton.setOnClickListener(this);
		View submitScoreButton = findViewById(R.id.submitScore);
		submitScoreButton.setOnClickListener(this);

		//setting up the textviews and editviews
		viewInitialsInput = (EditText) findViewById(R.id.submitScoreInitialsEditTextBox);
		gameScore = (TextView) findViewById(R.id.highScoreSaved);

		//displaying the score on the game score textview
		retrieveScore();
	}

	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		Bundle extras = getIntent().getExtras();

		//check which button was clicked by button id
		switch (v.getId()) {
		case R.id.menuReturn:
			Intent i1 = new Intent(this, MathGameActivity.class);
			startActivity(i1);
			break;
		case R.id.submitScore://button click for submit score only works if gameplay was of timed mode type and initials are entered.
			if(Integer.valueOf(extras.getString("Gameplay_Type")) == 0){
				Toast.makeText(this, "\nYou can only submit scores while playing in Timed mode.\n", Toast.LENGTH_SHORT).show();
				break;
			}else if(viewInitialsInput.getText().length() == 0){
				Toast.makeText(this, "\nYou must input at least 1 letter or number to submit score. \n\n"
						+ "Note: Only 6 letters and digits allowed.\n", Toast.LENGTH_SHORT).show();
			}else{
				insertScore();
				Intent i2 = new Intent(this, HighScore.class);
				startActivity(i2);
				break;
			}
		}
	}

	/**
	 * Retrieve score. This gets the score that was gotten in the game and inputs it into the gameScore textview.
	 */
	private void retrieveScore(){
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			String value1 = extras.getString("Game_Score");
			gameScore.setText(value1);
		}
	}

	/**
	 * Insert score. This inserts the score for the game into a row in the database table highScore.
	 */
	private void insertScore(){
		Bundle extras = getIntent().getExtras();
		MathGameDatabaseHandler dbObjectHandler = new MathGameDatabaseHandler(this, null, null, 1);
		tempTable1 = new HighScoreTable();
		if (extras != null) {
			tempTable1.setInitials(viewInitialsInput.getText().toString());
			tempTable1.setQuestionNumberAmount(Integer.valueOf(extras.getString("Number_Amount")));
			tempTable1.setQuestionType(Integer.valueOf(extras.getString("Question_Type")));
			tempTable1.setTotalQuestions(Integer.valueOf(extras.getString("Total_Questions_Asked")));
			tempTable1.setTotalCorrectAnswers(Integer.valueOf(extras.getString("Total_Correct_Answers")));
			tempTable1.setScore(Integer.valueOf(extras.getString("Game_Score")));
		}
		dbObjectHandler.insertRowHighScore(tempTable1);
	}

}
