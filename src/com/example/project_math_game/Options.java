/*
 * Author				 : Amardo Mole
 * Date					 : November 05, 2013
 * FileName/s			 : Options.java
 * Notes on program 	 : This screen is to select types of questions options for the math game.
 * sources for code ideas: http://stackoverflow.com/questions/16389581/android-create-a-popup-that-has-multiple-selection-options
 */
package com.example.project_math_game;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * The Class Options is to select types of questions options for the math game.
 */
public class Options extends Activity implements OnClickListener{


	/** The btn game number amount. */
	Button btnGameNumberAmount;

	/** The btn game question type. */
	Button btnGameQuestionType;

	/** The btn gameplay type. */
	Button btnGameplayType;

	/** The menu return button. */
	View menuReturnButton;

	/** The number amount. */
	CharSequence numberAmount[] = new CharSequence[] {"Two", "Three", "Four"};

	/** The question type. */
	CharSequence questionType[] = new CharSequence[] {"Addition", "Subtraction", "Addition and Subtraction",
			"Division", "Multiplication", "Division and Multiplication", "All Choices"};

	/** The gameplay type. */
	CharSequence gameplayType[] = new CharSequence[] {"Practice Mode", "Timed Mode\n(With Scoring)"};

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 * The onCreate method sets and displays the layout for this object's page.
	 */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.options);

		//setting up click listeners
		menuReturnButton = findViewById(R.id.menuReturn);
		menuReturnButton.setOnClickListener(this);

		btnGameNumberAmount = (Button) findViewById(R.id.buttonQuestionNumberAmount);
		btnGameNumberAmount.setOnClickListener(this);

		btnGameQuestionType = (Button) findViewById(R.id.buttonQuestionType);
		btnGameQuestionType.setOnClickListener(this);

		btnGameplayType = (Button) findViewById(R.id.buttonMathGameplayType);
		btnGameplayType.setOnClickListener(this);

		//check if there is any table or rows in the options table, and if none, enter 1 options table row.
		if(countTableRowsData() == 0){
			enterTableData (0, 2, 0);
		}
	}

	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		//check which button was clicked by button id
		switch (v.getId()) {

		case R.id.buttonQuestionNumberAmount://changing the options for the game regarding the number amount
			//create a alert menu for selection and enter selection into correct database table column
			AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
			builder1.setTitle("Question Number Amount");
			builder1.setItems(numberAmount, new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int optionSelection) {
					enterNumberAmountTableData(optionSelection);
				}
			});
			builder1.show();
			break;

		case R.id.buttonQuestionType://changing the options for the game regarding the question type
			//create a alert menu for selection and enter selection into correct database table column
			AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
			builder2.setTitle("Question type");
			builder2.setItems(questionType, new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int optionSelection) {
					enterQuestionTypeTableData(optionSelection);
				}
			});
			builder2.show();
			break;
		case R.id.buttonMathGameplayType://changing the options for the game regarding the gameplay type
			//create a alert menu for selection and enter selection into correct database table column
			AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
			builder3.setTitle("Gameplay Type");
			builder3.setItems(gameplayType, new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int optionSelection) {
					enterMathGameplayTypeTableData(optionSelection);
				}
			});
			builder3.show();
			break;
		case R.id.menuReturn:
			Intent i3 = new Intent(this, MathGameActivity.class);
			startActivity(i3);
			break;
		}
	}

	/**
	 * Enter number amount table data. Enter data for the number amount column in the table options.
	 *
	 * @param selection the selection
	 */
	public void enterNumberAmountTableData(int selection) {

		MathGameDatabaseHandler dbObjectHandler = new MathGameDatabaseHandler(this, null, null, 1);
		OptionsSelectTable tempTable1 = new OptionsSelectTable();
		tempTable1 = dbObjectHandler.selectOptionsRow();
		tempTable1.setTablesStoredNumberAmount(selection);
		dbObjectHandler.updateOptionsRow(tempTable1);
	}

	/**
	 * Enter question type table data. Enter data for the question type column in the table options.
	 *
	 * @param selection the selection
	 */
	public void enterQuestionTypeTableData(int selection) {

		MathGameDatabaseHandler dbObjectHandler = new MathGameDatabaseHandler(this, null, null, 1);
		OptionsSelectTable tempTable1 = new OptionsSelectTable();
		tempTable1 = dbObjectHandler.selectOptionsRow();
		tempTable1.setTableStoredQuestionType(selection);
		dbObjectHandler.updateOptionsRow(tempTable1);
	}

	/**
	 * Enter math gameplay type table data. Enter data for the gameplay type column in the table options.
	 *
	 * @param selection the selection
	 */
	public void enterMathGameplayTypeTableData(int selection) {

		MathGameDatabaseHandler dbObjectHandler = new MathGameDatabaseHandler(this, null, null, 1);
		OptionsSelectTable tempTable1 = new OptionsSelectTable();
		tempTable1 = dbObjectHandler.selectOptionsRow();
		tempTable1.setTableStoredGameplayType(selection);
		dbObjectHandler.updateOptionsRow(tempTable1);
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
	 * Count table rows data. Count the number of rows in the options table currently.
	 *
	 * @return the int
	 */
	public int countTableRowsData () {
		MathGameDatabaseHandler dbObjectHandler = new MathGameDatabaseHandler(this, null, null, 1);
		int rowCount = dbObjectHandler.selectCountOfRowsOptions();
		return rowCount;
	}

}
