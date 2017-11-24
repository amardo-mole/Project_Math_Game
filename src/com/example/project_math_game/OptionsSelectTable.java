/*
 * Author				 : Amardo Mole
 * Date					 : November 05, 2013
 * FileName/s			 : OptionsSelectTable.java
 * Notes on program 	 : This program connects to a SQLite Database. This is the database table row information as an object.
 * sources for code ideas: http://www.techotopia.com/index.php/An_Android_SQLite_Database_Tutorial#About_the_Database_Example
 */

package com.example.project_math_game;

/**
 * The Class OptionsSelectTable.
 */
public class OptionsSelectTable {


	/** The table id. */
	private int tableID;

	/** The tables stored number amount. */
	private int tablesStoredNumberAmount;

	/** The table stored question type. */
	private int tableStoredQuestionType;

	/** The table stored gameplay type. */
	private int tableStoredGameplayType;


	//this is not a row in the Options table. This is used only for checking if the table contains a row for updating options selected.
	/** The table row count. */
	private int tableRowCount;

	/**
	 * Instantiates a new options select table.
	 */
	public OptionsSelectTable(){

	}

	/**
	 * Instantiates a new options select table.
	 *
	 * @param numberAmount the number amount
	 * @param questionType the question type
	 */
	public OptionsSelectTable(int numberAmount, int questionType){
		this.tablesStoredNumberAmount = numberAmount;
		this.tableStoredQuestionType = questionType;
	}

	/**
	 * Instantiates a new options select table.
	 *
	 * @param numberAmount the number amount
	 * @param questionType the question type
	 * @param gameplayType the gameplay type
	 */
	public OptionsSelectTable(int numberAmount, int questionType, int gameplayType){
		this.tablesStoredNumberAmount = numberAmount;
		this.tableStoredQuestionType = questionType;
		this.tableStoredGameplayType = gameplayType;
	}

	/**
	 * Instantiates a new options select table.
	 *
	 * @param id the id
	 * @param numberAmount the number amount
	 * @param questionType the question type
	 * @param gameplayType the gameplay type
	 */
	public OptionsSelectTable(int id, int numberAmount, int questionType, int gameplayType){
		this.tableID = id;
		this.tablesStoredNumberAmount = numberAmount;
		this.tableStoredQuestionType = questionType;
		this.tableStoredGameplayType = gameplayType;
	}

	/**
	 * Gets the table id.
	 *
	 * @return the table id
	 */
	public int getTableID() {
		return tableID;
	}

	/**
	 * Sets the table id.
	 *
	 * @param tableID the new table id
	 */
	public void setTableID(int tableID) {
		this.tableID = tableID;
	}

	/**
	 * Gets the tables stored number amount.
	 *
	 * @return the tables stored number amount
	 */
	public int getTablesStoredNumberAmount() {
		return tablesStoredNumberAmount;
	}

	/**
	 * Sets the tables stored number amount.
	 *
	 * @param tablesStoredNumberAmount the new tables stored number amount
	 */
	public void setTablesStoredNumberAmount(int tablesStoredNumberAmount) {
		this.tablesStoredNumberAmount = tablesStoredNumberAmount;
	}

	/**
	 * Gets the table stored question type.
	 *
	 * @return the table stored question type
	 */
	public int getTableStoredQuestionType() {
		return tableStoredQuestionType;
	}

	/**
	 * Sets the table stored question type.
	 *
	 * @param tableStoredQuestionType the new table stored question type
	 */
	public void setTableStoredQuestionType(int tableStoredQuestionType) {
		this.tableStoredQuestionType = tableStoredQuestionType;
	}

	/**
	 * Gets the table stored gameplay type.
	 *
	 * @return the table stored gameplay type
	 */
	public int getTableStoredGameplayType() {
		return tableStoredGameplayType;
	}

	/**
	 * Sets the table stored gameplay type.
	 *
	 * @param tableStoredGameplayType the new table stored gameplay type
	 */
	public void setTableStoredGameplayType(int tableStoredGameplayType) {
		this.tableStoredGameplayType = tableStoredGameplayType;
	}


	/**
	 * Gets the table row count.
	 *
	 * @return the table row count
	 */
	public int getTableRowCount() {
		return tableRowCount;
	}

	/**
	 * Sets the table row count.
	 *
	 * @param tableRowCount the new table row count
	 */
	public void setTableRowCount(int tableRowCount) {
		this.tableRowCount = tableRowCount;
	}

}

