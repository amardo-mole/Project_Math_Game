/*
 * Author				 : Amardo Mole
 * Date					 : November 05, 2013
 * FileName/s			 : TempDatabaseHandler.java
 * Notes on program 	 : This program connects to a SQLite Database. This interacts with the database and creates the database and table/s it has.
 * sources for code ideas: http://www.techotopia.com/index.php/An_Android_SQLite_Database_Tutorial#About_the_Database_Example
 */

package com.example.project_math_game;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * The Class MathGameDatabaseHandler.
 */
public class MathGameDatabaseHandler extends SQLiteOpenHelper {

	//the database for this program

	/** The Constant DATABASE_VERSION. */
	private static final int DATABASE_VERSION = 1;
	/** The Constant DATABASE_NAME. */
	private static final String DATABASE_NAME = "MathGameDB.db";


	//the tables for this program

	/** The Constant TABLENAME_TEMPTABLE. */
	private static final String TABLENAME_OPTIONS = "Options";
	/** The Constant TABLENAME_TEMPTABLE. */
	private static final String TABLENAME_HIGHSCORE = "HighScore";


	//the column id for both tables. (Note: will start count at id '1' automatically.)
	/** The Constant COLUMN_ID. Is for both tables for onCreate() method.*/
	public static final String COLUMN_ID = "tableID";


	//columns for table "Options"

	/** The Constant COLUMN_NAME. */
	public static final String COLUMN_NUMBER_AMOUNT = "NumberAmount";
	/** The Constant COLUMN_NUMBER. */
	public static final String COLUMN_QUESTION_TYPE = "QuestionType";
	/** The Constant COLUMN_OPTIONS. */
	private static final String COLUMN_GAMEPLAY_TYPE = "GameplayType";


	//columns for table "HighScore"

	/** The Constant COLUMN_INITIALS. */
	public static final String COLUMN_INITIALS = "Initials";
	/** The Constant COLUMN_QUESTION_AMOUNT_HS. */
	public static final String COLUMN_NUMBER_AMOUNT_HS = "QuestionNumberAmount";
	/** The Constant COLUMN_QUESTION_TYPE_HS. */
	public static final String COLUMN_QUESTION_TYPE_HS = "QuestionType";
	/** The Constant COLUMN_TOTAL_QUESTIONS. */
	public static final String COLUMN_TOTAL_QUESTIONS = "TotalQuestions";
	/** The Constant COLUMN_TOTAL_CORRECT_QUESTIONS. */
	public static final String COLUMN_TOTAL_CORRECT_ANSWERS = "TotalCorrectAnswers";
	/** The Constant COLUMN_SCORE. */
	public static final String COLUMN_SCORE = "Score";

	/**
	 * Instantiates a new temporary database handler.
	 *
	 * @param context the context
	 * @param name the name
	 * @param factory the factory
	 * @param version the version
	 */
	public MathGameDatabaseHandler(Context context, String name,
			CursorFactory factory, int version) {
		super(context, DATABASE_NAME, factory, DATABASE_VERSION);
	}

	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase dbObject) {

		//creates a table layout of options for the database to use
		String CREATE_TABLE_OPTIONS = "CREATE TABLE " +
				TABLENAME_OPTIONS + "("
				+ COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_NUMBER_AMOUNT + " INTEGER,"
				+ COLUMN_QUESTION_TYPE + " INTEGER," + COLUMN_GAMEPLAY_TYPE + " INTEGER" + ")";
		//creates a table for the database to use
		dbObject.execSQL(CREATE_TABLE_OPTIONS);

		//creates a table layout of high score for the database to use
		String CREATE_TABLE_HIGHSCORE = "CREATE TABLE " +
				TABLENAME_HIGHSCORE + "("
				+ COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_INITIALS + " TEXT,"
				+ COLUMN_NUMBER_AMOUNT_HS + " INTEGER," + COLUMN_QUESTION_TYPE_HS + " INTEGER,"
				+ COLUMN_TOTAL_QUESTIONS + " INTEGER," + COLUMN_TOTAL_CORRECT_ANSWERS + " INTEGER,"
				+ COLUMN_SCORE + " INTEGER" + ")";
		//creates a table for the database to use
		dbObject.execSQL(CREATE_TABLE_HIGHSCORE);
	}

	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase dbObject, int argOld, int argNew) {
		//if a table exists already, drop it.
		dbObject.execSQL("DROP TABLE IF EXISTS " + TABLENAME_OPTIONS);
		onCreate(dbObject);
	}

	/**
	 * Insert row for high score table.
	 *
	 * @param tempTable the temp table
	 */
	public void insertRowHighScore(HighScoreTable tempTable) {

		ContentValues values = new ContentValues();
		values.put(COLUMN_INITIALS, tempTable.getInitials());
		values.put(COLUMN_NUMBER_AMOUNT_HS, tempTable.getQuestionNumberAmount());
		values.put(COLUMN_QUESTION_TYPE_HS, tempTable.getQuestionType());
		values.put(COLUMN_TOTAL_QUESTIONS, tempTable.getTotalQuestions());
		values.put(COLUMN_TOTAL_CORRECT_ANSWERS, tempTable.getTotalCorrectAnswers());
		values.put(COLUMN_SCORE, tempTable.getScore());
		SQLiteDatabase dbObject = this.getWritableDatabase();
		//creates the actual database now
		dbObject.insert(TABLENAME_HIGHSCORE, null, values);
		dbObject.close();
	}

	/**
	 * Find high score rows in high score table for first 10 rows with highest scores.
	 *
	 * @return the array list
	 */
	public ArrayList<HighScoreTable> findHighScoreRows() {
		ArrayList<HighScoreTable> tableDataArray = new ArrayList<HighScoreTable>();
		String query = "Select * FROM " + TABLENAME_HIGHSCORE + " ORDER BY " + COLUMN_SCORE + " DESC LIMIT 10 ";

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(query, null);
		if(cursor.getCount() != 0){
			cursor.moveToPosition(-1);
			while ( cursor.moveToNext()) {
				HighScoreTable tableData = new HighScoreTable();
				tableData.setTableID(Integer.parseInt(cursor.getString(0)));
				tableData.setInitials(cursor.getString(1));
				tableData.setQuestionNumberAmount(Integer.parseInt(cursor.getString(2)));
				tableData.setQuestionType(Integer.parseInt(cursor.getString(3)));
				tableData.setTotalQuestions(Integer.parseInt(cursor.getString(4)));
				tableData.setTotalCorrectAnswers(Integer.parseInt(cursor.getString(5)));
				tableData.setScore(Integer.parseInt(cursor.getString(6)));
				tableDataArray.add(tableData);
			}
		}else {
			tableDataArray = null;
		}
		cursor.close();
		db.close();
		return tableDataArray;
	}

	/**
	 * Adds/inserts a row into the database table options.
	 *
	 */
	public void insertRowOptions(OptionsSelectTable tempTable) {

		ContentValues values = new ContentValues();
		values.put(COLUMN_NUMBER_AMOUNT, tempTable.getTablesStoredNumberAmount());
		values.put(COLUMN_QUESTION_TYPE, tempTable.getTableStoredQuestionType());
		values.put(COLUMN_GAMEPLAY_TYPE, tempTable.getTableStoredGameplayType());
		SQLiteDatabase dbObject = this.getWritableDatabase();
		//creates the actual database now
		dbObject.insert(TABLENAME_OPTIONS, null, values);
		dbObject.close();
	}

	/**
	 * Find/select a row from the database table options.
	 *
	 * @return  tableData: the temp table is the row found or not found and returned.
	 */
	public OptionsSelectTable selectOptionsRow() {
		String query = "Select * FROM " + TABLENAME_OPTIONS + " WHERE " + COLUMN_ID + " =  \"1\"";

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(query, null);
		OptionsSelectTable tableData = new OptionsSelectTable();

		if (cursor.moveToFirst()) {
			cursor.moveToFirst();
			tableData.setTableID(Integer.parseInt(cursor.getString(0)));
			tableData.setTablesStoredNumberAmount(Integer.parseInt(cursor.getString(1)));
			tableData.setTableStoredQuestionType(Integer.parseInt(cursor.getString(2)));
			tableData.setTableStoredGameplayType(Integer.parseInt(cursor.getString(3)));
			cursor.close();
		} else {
			tableData = null;
		}
		db.close();
		return tableData;
	}

	/**
	 * Select count of rows for the database table options.
	 *
	 * @return the int
	 */
	public int selectCountOfRowsOptions() {
		String query = "Select Count(*) FROM " + TABLENAME_OPTIONS;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(query, null);
		int rowCount;

		if (cursor.moveToFirst()) {
			cursor.moveToFirst();
			rowCount = Integer.parseInt(cursor.getString(0));
			cursor.close();
		} else {
			rowCount = 0;
		}
		db.close();
		return rowCount;
	}

	/**
	 * Update the first options table row.
	 *
	 * @param tempTable the temp table
	 * @return the options select table
	 */
	public OptionsSelectTable updateOptionsRow(OptionsSelectTable tempTable) {

		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(COLUMN_NUMBER_AMOUNT,tempTable.getTablesStoredNumberAmount());
		values.put(COLUMN_QUESTION_TYPE,tempTable.getTableStoredQuestionType());
		values.put(COLUMN_GAMEPLAY_TYPE,tempTable.getTableStoredGameplayType());

		db.update(TABLENAME_OPTIONS, values, COLUMN_ID + "=" + 1, null);
		db.close();
		return null;
	}

}

