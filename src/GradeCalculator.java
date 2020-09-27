/*
 * GradeCalculator.java
 * Author:  Joseph Nguyen
 * Submission Date:  2/12/2020
 *
 * Purpose: Calculates your grade and if its possible to get your desired grade and what it would take to do it
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer
 * Science at the University of Georgia. Any publishing 
 * or posting of source code for this assignment is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia.  
 */

import java.util.Scanner;

public class GradeCalculator {

	public static void main(String[] args) {

		//declared variables
		char goalGrade, exam1Known, exam2Known, fexamKnown, labsKnown, projectKnown, participationKnown, quizKnown, currentLetterGrade;
		int exam1, exam2, fexam, labs, project, participation, quiz, weights;
		int exam1Score, exam2Score, fexamScore, labsScore, projectScore, participationScore, quizScore;
		double currentScore, avgToFinalLetterGrade, totalKnownGradeWeight, grade, finalOverallScore;

		//Prints out the grading scale
		System.out.println("Grading Scale:\nA\t90-100\nB\t80-89\nC\t70-79\nD\t60-69\nF\tbelow 60");

		//uses scanner and you type in what grade you want for the course
		Scanner keyboard = new Scanner(System.in);
		System.out.print("What letter grade do you want to achieve for the course? ");
		goalGrade = keyboard.next().charAt(0);
		if (goalGrade != 'A' && goalGrade != 'a' && goalGrade != 'B' && goalGrade != 'b' && goalGrade != 'C' && goalGrade != 'c' && goalGrade != 'D' && goalGrade != 'd' && goalGrade != 'F' && goalGrade != 'f') {
			System.out.println("Input Error");
			System.exit(0);
		}

		//enter grade weights
		System.out.println("Enter Percentage Weights:");
		System.out.print("Exam 1:\t\t");
		exam1 = keyboard.nextInt();
		System.out.print("Exam 2:\t\t");
		exam2 = keyboard.nextInt();
		System.out.print("Final Exam:\t");
		fexam = keyboard.nextInt();
		System.out.print("Labs:\t\t");
		labs = keyboard.nextInt();
		System.out.print("Projects:\t");
		project = keyboard.nextInt();
		System.out.print("Participation:\t");
		participation = keyboard.nextInt();
		System.out.print("Quizzes:\t");
		quiz = keyboard.nextInt();

		//if weights aren't equal to 100 then end program otherwise continue
		weights = exam1 + exam2 + fexam + labs + project+ participation + quiz;
		if (weights != 100) {
			System.out.println("Weights don't add up to 100, program exiting...");
			System.exit(0);
		}
		else
			System.out.println("Enter your scores out of a 100:");

		//see if they know their exam scores or not
		System.out.print("Do you know your Exam 1 score: ");
		exam1Known = keyboard.next().charAt(0);
		if ((exam1Known != ('y')) && (exam1Known != 'Y')) {
			exam1Score = 0;
			exam1 = 0;
			exam2Score = 0;
			exam2 = 0;
			fexamScore = 0;
			fexam = 0;
		}
		else {
			System.out.print("Score received on exam 1: ");
			exam1Score = keyboard.nextInt();
			System.out.print("Do you know your Exam 2 score: ");
			exam2Known = keyboard.next().charAt(0);
			if ((exam2Known != 'y') && (exam2Known != 'Y')) {
				exam2Score = 0;
				exam2 = 0;
				fexamScore = 0;
				fexam = 0;
			}
			else {
				System.out.print("Score received on exam 2: ");
				exam2Score = keyboard.nextInt();
				System.out.print("Do you know your Final Exam score: ");
				fexamKnown = keyboard.next().charAt(0);
				if ((fexamKnown != 'y') && (fexamKnown != 'Y')) {
					fexamScore = 0;
					fexam = 0;
				}
				else {
					System.out.print("Score received on final exam: ");
					fexamScore = keyboard.nextInt();
				}
			}
		}

		//see if they know their lab average or not
		System.out.print("Do you know your lab average: ");
		labsKnown = keyboard.next().charAt(0);
		if ((labsKnown != 'y') && (labsKnown != 'Y')) {
			labsScore = 0;
			labs = 0;
		}
		else {
			System.out.print("Average Lab Grade: ");
			labsScore = keyboard.nextInt();
		}

		//see if they know their project average or not
		System.out.print("Do you know your project average: ");
		projectKnown = keyboard.next().charAt(0);
		if ((projectKnown != 'y') && (projectKnown != 'Y')) {
			projectScore = 0;
			project = 0;
		}
		else {
			System.out.print("Average Project Grade: ");
			projectScore = keyboard.nextInt();
		}

		//see if they know their participation average or not
		System.out.print("Do you know your participation average: ");
		participationKnown = keyboard.next().charAt(0);
		if ((participationKnown != 'y') && (participationKnown != 'Y')) {
			participationScore = 0;
			participation = 0;
		}
		else {
			System.out.print("Average Participation Grade: ");
			participationScore = keyboard.nextInt();
		}

		//see if they know their quiz average or not
		System.out.print("Do you know your quiz average: ");
		quizKnown = keyboard.next().charAt(0);
		if ((quizKnown != 'y') && (quizKnown != 'Y')) {
			quizScore = 0;
			quiz = 0;
		}
		else {
			System.out.print("Average Quiz Grade: ");
			quizScore = keyboard.nextInt();
		}

		//calculates current grade
		grade = (exam1Score * exam1) + (exam2Score * exam2) + (fexamScore * fexam) + (labsScore * labs) + (projectScore * project) + (participationScore * participation) + (quizScore * quiz);
		totalKnownGradeWeight = exam1 + exam2 + fexam + labs + project + participation + quiz;
		currentScore = ((exam1Score * exam1) + (exam2Score * exam2) + (fexamScore * fexam) + (labsScore * labs) + (projectScore * project) + (participationScore * participation) + (quizScore * quiz)) / totalKnownGradeWeight;
		System.out.print("Current Grade Score: ");
		System.out.format("%.02f%n", currentScore);

		//prints out letter grade
		if (goalGrade == 'A' || goalGrade == 'B' || goalGrade == 'C' || goalGrade == 'D' || goalGrade == 'F') {
			if (currentScore >= 90) {
			currentLetterGrade = 'A';
			System.out.println("Your current letter grade is a " + currentLetterGrade);
			}
			else if (currentScore >= 80 && currentScore < 90) {
			currentLetterGrade = 'B';
			System.out.println("Your current letter grade is a " + currentLetterGrade);
			}
			else if (currentScore >= 70 && currentScore < 80) {
			currentLetterGrade = 'C';
			System.out.println("Your current letter grade is a " + currentLetterGrade);
			}
			else if (currentScore >= 60 && currentScore < 70) {
			currentLetterGrade = 'D';
			System.out.println("Your current letter grade is a " + currentLetterGrade);
			}
			else {
			currentLetterGrade = 'F';
			System.out.println("Your current letter grade is a " + currentLetterGrade);
			}
		}
		else {
			if (currentScore >= 90) {
			currentLetterGrade = 'a';
			System.out.println("Your current letter grade is a " + currentLetterGrade);
			}
			else if (currentScore >= 80 && currentScore < 90) {
			currentLetterGrade = 'b';
			System.out.println("Your current letter grade is a " + currentLetterGrade);
			}
			else if (currentScore >= 70 && currentScore < 80) {
			currentLetterGrade = 'c';
			System.out.println("Your current letter grade is a " + currentLetterGrade);
			}
			else if (currentScore >= 60 && currentScore < 70) {
			currentLetterGrade = 'd';
			System.out.println("Your current letter grade is a " + currentLetterGrade);
			}
			else {
			currentLetterGrade = 'f';
			System.out.println("Your current letter grade is a " + currentLetterGrade);
			}
		}

		//prints out if goal grade is reached/what is needed to reach it/if its possible to reach it
		if (goalGrade == 'A' || goalGrade == 'a')
			finalOverallScore = 90;
		else if (goalGrade == 'B' || goalGrade == 'b')
			finalOverallScore = 80;
		else if (goalGrade == 'C' || goalGrade == 'c')
			finalOverallScore = 70;
		else if (goalGrade == 'D' || goalGrade == 'd')
			finalOverallScore = 60;
		else if (goalGrade == 'F' || goalGrade == 'f')
			finalOverallScore = 59.99;
		else
			finalOverallScore = 999;

		if (goalGrade == currentLetterGrade)
			System.out.println("Congratulations! You received that " + goalGrade + " that you wanted!");
		else {
			avgToFinalLetterGrade = ((100 * finalOverallScore) - (grade)) / (100 - totalKnownGradeWeight);
			if (avgToFinalLetterGrade > 100)
				System.out.println("Sorry, you cannot receive an " + goalGrade + " in the course");
			else if ((avgToFinalLetterGrade <= 100) && (avgToFinalLetterGrade >= 0)) {
				avgToFinalLetterGrade = avgToFinalLetterGrade + 0.01;
				System.out.print("You have to score an average greater than or equal to ");
				System.out.format("%.02f", avgToFinalLetterGrade);
				System.out.print(" in the remaining grade items to receive an " + goalGrade + " in the course");
			}
			else
				System.out.println("You will receive at least a " + goalGrade + " no matter what");
		}

		
		//close keyboard and stop program
		keyboard.close();
		System.exit(0);



	}

}