/*
 * Author				 : Amardo Mole
 * Date					 : October 14, 2013
 * FileName/s			 : Help.java
 * Notes on program 	 : This part of the program shows help to user on how to run program.
 * sources for code ideas: None.
 */
package com.example.project_math_game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * The Class Help. Will show help to user on how to use this program via a TextView. 
 */
public class Help extends Activity implements OnClickListener{

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 * Generate the help page layout when this object is created.
	 */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help);

		//setting up click listeners for buttons on the screen.
		View menuReturnButton = findViewById(R.id.menuReturn);
		menuReturnButton.setOnClickListener(this);
	}

	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		//click listeners that are checked by the id of the button.
		switch (v.getId()) {
		case R.id.menuReturn:
			Intent i1 = new Intent(this, MathGameActivity.class);
			startActivity(i1);
			break;
		}

	}
}