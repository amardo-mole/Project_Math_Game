/*
 * Author				 : Amardo Mole
 * Date					 : November 05, 2013
 * FileName/s			 : HgihScoreTable.java
 * Notes on program 	 : This program connects to a SQLite Database. This is the database table row information as an object.
 * sources for code ideas: http://www.techotopia.com/index.php/An_Android_SQLite_Database_Tutorial#About_the_Database_Example
 */

package com.example.project_math_game;

/**
 * The Class HighScoreTable.
 */
public class HighScoreTable {

	/** The table id. */
	private int tableID;

	/** The initials. */
	private String initials;

	/** The question number amount. */
	private int questionNumberAmount;

	/** The question type. */
	private int questionType;

	/** The total questions. */
	private int totalQuestions;

	/** The total correct answers. */
	private int totalCorrectAnswers;

	/** The score. */
	private int score;

	/**
	 * Instantiates a new high score table.
	 */
	public HighScoreTable(){

	}

	/**
	 * Instantiates a new high score table.
	 *
	 * @param tableID the table id
	 * @param initials the initials
	 * @param questionNumberAmount the question number amount
	 * @param questionType the question type
	 * @param totalQuestions the total questions
	 * @param totalCorrectAnswers the total correct answers
	 * @param score the score
	 */
	public HighScoreTable(int tableID, String initials, int questionNumberAmount, int questionType,
							int totalQuestions, int totalCorrectAnswers, int score){
		this.tableID = tableID;
		this.initials = initials;
		this.questionNumberAmount = questionNumberAmount;
		this.questionType = questionType;
		this.totalQuestions = totalQuestions;
		this.totalCorrectAnswers = totalCorrectAnswers;
		this.score = score;
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
	 * Gets the initials.
	 *
	 * @return the initials
	 */
	public String getInitials() {
		return initials;
	}

	/**
	 * Sets the initials.
	 *
	 * @param initials the new initials
	 */
	public void setInitials(String initials) {
		this.initials = initials;
	}

	/**
	 * Gets the question number amount.
	 *
	 * @return the question number amount
	 */
	public int getQuestionNumberAmount() {
		return questionNumberAmount;
	}

	/**
	 * Sets the question number amount.
	 *
	 * @param questionNumberAmount the new question number amount
	 */
	public void setQuestionNumberAmount(int questionNumberAmount) {
		this.questionNumberAmount = questionNumberAmount;
	}

	/**
	 * Gets the question type.
	 *
	 * @return the question type
	 */
	public int getQuestionType() {
		return questionType;
	}

	/**
	 * Sets the question type.
	 *
	 * @param questionType the new question type
	 */
	public void setQuestionType(int questionType) {
		this.questionType = questionType;
	}

	/**
	 * Gets the total questions.
	 *
	 * @return the total questions
	 */
	public int getTotalQuestions() {
		return totalQuestions;
	}

	/**
	 * Sets the total questions.
	 *
	 * @param totalQuestions the new total questions
	 */
	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	/**
	 * Gets the total correct answers.
	 *
	 * @return the total correct answers
	 */
	public int getTotalCorrectAnswers() {
		return totalCorrectAnswers;
	}

	/**
	 * Sets the total correct answers.
	 *
	 * @param totalCorrectAnswers the new total correct answers
	 */
	public void setTotalCorrectAnswers(int totalCorrectAnswers) {
		this.totalCorrectAnswers = totalCorrectAnswers;
	}

	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Sets the score.
	 *
	 * @param score the new score
	 */
	public void setScore(int score) {
		this.score = score;
	}

}

