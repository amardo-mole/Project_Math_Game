/*
 * Author				 : Amardo Mole
 * Date					 : November 05, 2013
 * FileName/s			 : HighScore.java
 * Notes on program 	 : This part of the program shows the high score screen for the math game program. High scores will
 * 						   be stored in a database.
 * sources for code ideas: None.
 */
package com.example.project_math_game;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

// TODO: Auto-generated Javadoc
/**
 * The Class HighScore shows the high score screen for the math game program. High scores will
 * be stored in a database.
 */
public class HighScore extends Activity implements OnClickListener{

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 * The onCreate method sets and displays the layout for this object's page.
	 */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.high_score);

		//setting up click listeners
		View menuReturnButton = findViewById(R.id.menuReturn);
		menuReturnButton.setOnClickListener(this);

		fillHighScore();
	}

	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId()) {//return to menu when button is clicked
		case R.id.menuReturn:
			Intent i1 = new Intent(this, MathGameActivity.class);
			startActivity(i1);
			break;
		}
	}

	/**
	 * Fill high score. This selects the top 10 scores in the highscore table and outputs them into thee high score table for the user to see.
	 */
	public void fillHighScore(){

		//all the textviews for initials in the high score table are stored into an arraylist
		ArrayList<TextView> tempViewTableInitialsArray = new ArrayList<TextView>();
		tempViewTableInitialsArray.add((TextView) findViewById(R.id.initials1));
		tempViewTableInitialsArray.add((TextView) findViewById(R.id.initials2));
		tempViewTableInitialsArray.add((TextView) findViewById(R.id.initials3));
		tempViewTableInitialsArray.add((TextView) findViewById(R.id.initials4));
		tempViewTableInitialsArray.add((TextView) findViewById(R.id.initials5));
		tempViewTableInitialsArray.add((TextView) findViewById(R.id.initials6));
		tempViewTableInitialsArray.add((TextView) findViewById(R.id.initials7));
		tempViewTableInitialsArray.add((TextView) findViewById(R.id.initials8));
		tempViewTableInitialsArray.add((TextView) findViewById(R.id.initials9));
		tempViewTableInitialsArray.add((TextView) findViewById(R.id.initials10));

		//all the textviews for question number amount in the high score table are stored into an arraylist
		ArrayList<TextView> tempViewTableNumberArray = new ArrayList<TextView>();
		tempViewTableNumberArray.add((TextView) findViewById(R.id.questionNumberAmount1));
		tempViewTableNumberArray.add((TextView) findViewById(R.id.questionNumberAmount2));
		tempViewTableNumberArray.add((TextView) findViewById(R.id.questionNumberAmount3));
		tempViewTableNumberArray.add((TextView) findViewById(R.id.questionNumberAmount4));
		tempViewTableNumberArray.add((TextView) findViewById(R.id.questionNumberAmount5));
		tempViewTableNumberArray.add((TextView) findViewById(R.id.questionNumberAmount6));
		tempViewTableNumberArray.add((TextView) findViewById(R.id.questionNumberAmount7));
		tempViewTableNumberArray.add((TextView) findViewById(R.id.questionNumberAmount8));
		tempViewTableNumberArray.add((TextView) findViewById(R.id.questionNumberAmount9));
		tempViewTableNumberArray.add((TextView) findViewById(R.id.questionNumberAmount10));

		//all the textviews for question type in the high score table are stored into an arraylist
		ArrayList<TextView> tempViewTableTypeArray = new ArrayList<TextView>();
		tempViewTableTypeArray.add((TextView) findViewById(R.id.questionType1));
		tempViewTableTypeArray.add((TextView) findViewById(R.id.questionType2));
		tempViewTableTypeArray.add((TextView) findViewById(R.id.questionType3));
		tempViewTableTypeArray.add((TextView) findViewById(R.id.questionType4));
		tempViewTableTypeArray.add((TextView) findViewById(R.id.questionType5));
		tempViewTableTypeArray.add((TextView) findViewById(R.id.questionType6));
		tempViewTableTypeArray.add((TextView) findViewById(R.id.questionType7));
		tempViewTableTypeArray.add((TextView) findViewById(R.id.questionType8));
		tempViewTableTypeArray.add((TextView) findViewById(R.id.questionType9));
		tempViewTableTypeArray.add((TextView) findViewById(R.id.questionType10));

		//all the textviews for total questions in the high score table are stored into an arraylist
		ArrayList<TextView> tempViewTableTotalArray = new ArrayList<TextView>();
		tempViewTableTotalArray.add((TextView) findViewById(R.id.totalQuestions1));
		tempViewTableTotalArray.add((TextView) findViewById(R.id.totalQuestions2));
		tempViewTableTotalArray.add((TextView) findViewById(R.id.totalQuestions3));
		tempViewTableTotalArray.add((TextView) findViewById(R.id.totalQuestions4));
		tempViewTableTotalArray.add((TextView) findViewById(R.id.totalQuestions5));
		tempViewTableTotalArray.add((TextView) findViewById(R.id.totalQuestions6));
		tempViewTableTotalArray.add((TextView) findViewById(R.id.totalQuestions7));
		tempViewTableTotalArray.add((TextView) findViewById(R.id.totalQuestions8));
		tempViewTableTotalArray.add((TextView) findViewById(R.id.totalQuestions9));
		tempViewTableTotalArray.add((TextView) findViewById(R.id.totalQuestions10));

		//all the textviews for total correct questions in the high score table are stored into an arraylist
		ArrayList<TextView> tempViewTableCorrectArray = new ArrayList<TextView>();
		tempViewTableCorrectArray.add((TextView) findViewById(R.id.totalCorrectAnswers1));
		tempViewTableCorrectArray.add((TextView) findViewById(R.id.totalCorrectAnswers2));
		tempViewTableCorrectArray.add((TextView) findViewById(R.id.totalCorrectAnswers3));
		tempViewTableCorrectArray.add((TextView) findViewById(R.id.totalCorrectAnswers4));
		tempViewTableCorrectArray.add((TextView) findViewById(R.id.totalCorrectAnswers5));
		tempViewTableCorrectArray.add((TextView) findViewById(R.id.totalCorrectAnswers6));
		tempViewTableCorrectArray.add((TextView) findViewById(R.id.totalCorrectAnswers7));
		tempViewTableCorrectArray.add((TextView) findViewById(R.id.totalCorrectAnswers8));
		tempViewTableCorrectArray.add((TextView) findViewById(R.id.totalCorrectAnswers9));
		tempViewTableCorrectArray.add((TextView) findViewById(R.id.totalCorrectAnswers10));

		//all the textviews for score in the high score table are stored into an arraylist
		ArrayList<TextView> tempViewTableScoreArray = new ArrayList<TextView>();
		tempViewTableScoreArray.add((TextView) findViewById(R.id.score1));
		tempViewTableScoreArray.add((TextView) findViewById(R.id.score2));
		tempViewTableScoreArray.add((TextView) findViewById(R.id.score3));
		tempViewTableScoreArray.add((TextView) findViewById(R.id.score4));
		tempViewTableScoreArray.add((TextView) findViewById(R.id.score5));
		tempViewTableScoreArray.add((TextView) findViewById(R.id.score6));
		tempViewTableScoreArray.add((TextView) findViewById(R.id.score7));
		tempViewTableScoreArray.add((TextView) findViewById(R.id.score8));
		tempViewTableScoreArray.add((TextView) findViewById(R.id.score9));
		tempViewTableScoreArray.add((TextView) findViewById(R.id.score10));

		//connect to the database and fill an arraylist of objects with HighScore table top score rows.
		MathGameDatabaseHandler dbObjectHandler = new MathGameDatabaseHandler(this, null, null, 1);
		ArrayList<HighScoreTable> tableDataArray = dbObjectHandler.findHighScoreRows();

		//go through the entire stored arraylist and output all object of row information into high score table.
		if (tableDataArray != null){
			for (int i = 0;i<tableDataArray.size();i++){

				HighScoreTable tempTable = tableDataArray.get(i);

				tempViewTableInitialsArray.get(i).setText(tempTable.getInitials());

				int qNum = tempTable.getQuestionNumberAmount();
				qNum += 2;//for making the questions number amount correct displaying to user
				tempViewTableNumberArray.get(i).setText(Integer.toString(qNum));

				String questionType = "";
				int qType = tempTable.getQuestionType();
				switch (qType){
				case 0:
					 questionType = " + ";
					break;
				case 1:
					 questionType = " - ";
					break;
				case 2:
					 questionType = "+ -";
					break;
				case 3:
					 questionType = " / ";
					break;
				case 4:
					 questionType = " X ";
					break;
				case 5:
					 questionType = "/ X";
					break;
				case 6:
					 questionType = "ALL";
					break;
				}
				tempViewTableTypeArray.get(i).setText(questionType);


				tempViewTableTotalArray.get(i).setText(Integer.toString(tempTable.getTotalQuestions()));
				tempViewTableCorrectArray.get(i).setText(Integer.toString(tempTable.getTotalCorrectAnswers()));
				tempViewTableScoreArray.get(i).setText(Integer.toString(tempTable.getScore()));
			}
		}//end check if there is data to enter on highscore screen at all
	}
}