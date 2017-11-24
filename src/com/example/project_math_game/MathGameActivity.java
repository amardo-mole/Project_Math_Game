/*
 * Author				 : Amardo Mole
 * Date					 : October 14, 2013
 * FileName/s			 : MathGameActivity.java
 * Notes on program 	 : This part of the program is the main menu. The program main controller is from this program's object.
 * sources for code ideas: None.
 */
package com.example.project_math_game;

import java.io.Serializable;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;

/**
 * The Class MathGameActivity is the Main menu for the program. It links to all the program layouts
 * and program parts by button click events.
 */
public class MathGameActivity extends Activity implements OnClickListener, Serializable {

	/** This is the serial id for this object.	 */
	private static final long serialVersionUID = -6797310538447644844L;

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 * The onCreate method displays MathGameActivity's layout it uses and sets up the buttons to have
	 * events that create parts of the program when clicked.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_math_game);

		//setting up click listeners
		View startGameButton = findViewById(R.id.start_game_button);
		startGameButton.setOnClickListener(this);
		View highScoreGameButton = findViewById(R.id.high_score_button);
		highScoreGameButton.setOnClickListener(this);
		View optionsGameButton = findViewById(R.id.options_button);
		optionsGameButton.setOnClickListener(this);
		View helpGameButton = findViewById(R.id.help_button);
		helpGameButton.setOnClickListener(this);
		View exitGameButton = findViewById(R.id.exit_button);
		exitGameButton.setOnClickListener(this);
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 * Menu at top of program window when running. I don't use in program.
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.math_game, menu);
		return true;
	}

	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 * Button click events for the program. These button events link to other parts of the math game from the main page.
	 */
	@Override
	public void onClick(View v) {
		//check which button was clicked by button id
		switch (v.getId()) {
		case R.id.start_game_button:
			Intent i1 = new Intent(MathGameActivity.this, StartGame.class);
			startActivity(i1);
			break;
		case R.id.high_score_button:
			Intent i2 = new Intent(MathGameActivity.this, HighScore.class);
			startActivity(i2);
			break;
		case R.id.options_button:
			Intent i3 = new Intent(MathGameActivity.this, Options.class);
			startActivity(i3);
			break;
		case R.id.help_button:
			Intent i4 = new Intent(MathGameActivity.this, Help.class);
			startActivity(i4);
			break;
		case R.id.exit_button:
			finish();
			break;
		}
	}


}
