package ch.fhgr.java.trinkspiel.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

import ch.fhgr.java.trinkspiel.logik.Frage;
import ch.fhgr.java.trinkspiel.logik.SpielAblaufController;
import ch.fhgr.java.trinkspiel.logik.userFeedback;

/*Colours:

Background-Colour "Question 1": RGB (80, 94, 99)
Schriftfarbe "Question 1": RGB (185, 219, 232)
Background-Colour Questions: RGB (88, 152, 176)
Background-Colour Spielfeld: RGB (185, 219, 232)
Schrift Timer: RGB (255, 0, 0)
Schriftfarbe allg. (Schwarz): RGB (0, 0, 0) */


public class SpielView implements ActionListener{

	private SpielAblaufController controller = new SpielAblaufController();
	
	private int answer;
	private int index;
	private int correct_guesses = 0;
	private int result;
	int seconds = 10;
	
	// TO DO: alles was noch angefasst wird private machen und alles andere kann runter in SpielView
	private JFrame frame = new JFrame();
	private JTextField textfield = new JTextField();
	private JTextArea textarea = new JTextArea();
	private JButton buttonA = new JButton();
	private JButton buttonB = new JButton();
	private JTextField answerFeedback = new JTextField();
	private JLabel timeLabel = new JLabel();
	private JLabel secondsLeft = new JLabel();
	private JTextField numberRight = new JTextField();
	private JTextField percentage = new JTextField();
	private JLabel pictureDisplay = new JLabel();
	private JButton buttonStopGame = new JButton();
	private JButton buttonPauseGame = new JButton();
	private JButton buttonContinueGame = new JButton();


	ImageIcon imageResult = new ImageIcon("src/ch/fhgr/java/trinkspiel/ressources/results.png");
	
	// Timer, der runterzählt
	Timer timer = new Timer(1000, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			secondsLeft.setText(String.valueOf(seconds));
			if(seconds<=0) {
				displayAnswer();
			}
		}	
	});
	
	public SpielView() {
		//Frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200,800);
		frame.getContentPane().setBackground(new Color(185,219,232));
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		//Zahl der Frage: Textfield
		textfield.setBounds(0,0,1200,80);
		textfield.setBackground(new Color(80,94,99));
		textfield.setForeground(new Color(185,219,232));
		textfield.setFont(new Font("Arial", Font.BOLD, 35));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		
		// Fragetext
		textarea.setBounds(100,100,1000,100);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(new Color(88,152,176));
		textarea.setForeground(new Color(0,0,0));
		textarea.setFont(new Font("Arial", Font.PLAIN, 30));
		textarea.setBorder(BorderFactory.createEmptyBorder());
		textarea.setEditable(false);
		
		JTextField textfieldQuestion = new JTextField();
		textfieldQuestion.setBounds(0,80,1200,120);
		textfieldQuestion.setBorder(null);
		textfieldQuestion.setBackground(new Color(88,152,176));
		
		//Buttons
		buttonA.setBounds(200,225,800,80);
		buttonA.setFont(new Font("Arial", Font.PLAIN, 25));
		buttonA.setBackground(new Color(220, 220, 220));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);	
		
		buttonB.setBounds(200,305,800,80);
		buttonB.setFont(new Font("Arial", Font.PLAIN, 25));
		buttonB.setBackground(new Color(220, 220, 220));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		
		buttonStopGame.setBounds(600,500,400,80);
		buttonStopGame.setFont(new Font("Arial", Font.PLAIN, 25));
		buttonStopGame.setText(userFeedback.endGame);
		buttonStopGame.setFocusable(false);
		buttonStopGame.addActionListener(this);
		
		buttonPauseGame.setBounds(200,500,400,80);
		buttonPauseGame.setFont(new Font("Arial", Font.PLAIN, 25));
		buttonPauseGame.setText(userFeedback.pauseGame);
		buttonPauseGame.setFocusable(false);
		buttonPauseGame.addActionListener(this);
		
		buttonContinueGame.setVisible(false);
		buttonContinueGame.setBounds(200,600,400,80);
		buttonContinueGame.setFont(new Font("Arial", Font.PLAIN, 25));
		buttonContinueGame.setText(userFeedback.continueGame);
		buttonContinueGame.setFocusable(false);
		buttonContinueGame.addActionListener(this);

		
		// Timer
		secondsLeft.setBounds(1000,600,200,200);
		secondsLeft.setBackground(new Color(80,94,99));
		secondsLeft.setForeground(new Color(255,0,0));
		secondsLeft.setFont(new Font("Arial", Font.BOLD, 60));
		secondsLeft.setBorder(BorderFactory.createBevelBorder(1));
		secondsLeft.setOpaque(true);
		secondsLeft.setHorizontalAlignment(JTextField.CENTER);
		secondsLeft.setText(String.valueOf(seconds));
		
		timeLabel.setBounds(1000,570,200,30);
		timeLabel.setBackground(new Color (50,50,50));
		timeLabel.setForeground(new Color (255,0,0));
		timeLabel.setFont(new Font("Arial", Font.BOLD, 20));
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		timeLabel.setText(userFeedback.timerComment);
		
		//Antwort Feedback
		answerFeedback.setBounds(200,385,800,80);
		answerFeedback.setBackground(new Color(80,94,99));
		answerFeedback.setForeground(new Color(185,219,232));
		answerFeedback.setFont(new Font("Arial", Font.PLAIN, 25));
		answerFeedback.setHorizontalAlignment(JTextField.CENTER);
		
		numberRight.setBounds(400,225,400,100);
		numberRight.setBackground(new Color(80,94,99));
		numberRight.setForeground(new Color(185,219,232));
		numberRight.setFont(new Font("Arial", Font.BOLD, 40));
		numberRight.setBorder(BorderFactory.createBevelBorder(1));
		numberRight.setHorizontalAlignment(JTextField.CENTER);
		numberRight.setEditable(false);
		
		percentage.setBounds(400,325,400,100);
		percentage.setBackground(new Color(80,94,99));
		percentage.setForeground(new Color(185,219,232));
		percentage.setFont(new Font("Arial", Font.BOLD, 40));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);
		
		pictureDisplay.setBounds(450,450,300,300);
		
		frame.add(timeLabel);
		frame.add(secondsLeft);
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonStopGame);
		frame.add(buttonPauseGame);
		frame.add(buttonContinueGame);
		frame.add(textarea);
		frame.add(textfield);
		frame.add(textfieldQuestion);
		frame.setVisible(true);
		
		controller.init();
		nextQuestion();
		
	}
	public void nextQuestion() {
		if (!controller.nochFragenUebrig()) {
			results();
		}
		else {
			Frage frage = controller.getRandomFrage();
			textfield.setText("Question "+ (index+1));
			textarea.setText(frage.getFrage());
			buttonA.setText(frage.getAntwort0());
			buttonB.setText(frage.getAntwort1());
			timer.start();
		}
	}
	
	public void actionPerformed(ActionEvent e) { //when someone presses the button (answer)
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		
		if(e.getSource()==buttonStopGame) {
			controller.setCounter(0);
			results();
		}
		
		if(e.getSource()==buttonPauseGame) {
			timer.stop();
			buttonContinueGame.setVisible(true);
			
		}
		
		if(e.getSource()==buttonContinueGame) {
			buttonA.setEnabled(true);
			buttonB.setEnabled(true);
			nextQuestion();
			buttonContinueGame.setVisible(false);

		}
		
		answer = -1;
		if(e.getSource()==buttonA) {
			answer = 0;
		}
		if(e.getSource()==buttonB) {
			answer = 1;
		}
		
		if (answer != -1) {
			if(answer == controller.getAktuelleFrage().getRichtigeAntwort()) {
				correct_guesses++;
				answerFeedback.setText(userFeedback.answerCorrect);
			}else {
				
				answerFeedback.setText(userFeedback.answerWrong);
			}
			displayAnswer();
		}
		
	}
	public void displayAnswer() {
		// wenn Timer bei 0 = falsch
		timer.stop();
		
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		
		frame.add(answerFeedback);
		
		int richtig = controller.getAktuelleFrage().getRichtigeAntwort();
		
		if(richtig == 0) 
			buttonA.setBackground(new Color(124, 252, 0));
	
		if(richtig == 1) 
			buttonB.setBackground(new Color(124, 252, 0));
		
		
		// Timer, wartet nach Antwort 2	sek, bis nächste Aufgabe kommt bzw. Schriftfarbe sich wieder ändert
		Timer pause = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonA.setBackground(new Color(220, 220, 220));
				buttonB.setBackground(new Color(220, 220, 220));

				answerFeedback.setText(userFeedback.continueQuiz);
				answer = ' ';
				seconds= 10;
				secondsLeft.setText(String.valueOf(seconds));
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				index++;
				nextQuestion();
			}
			
		});
		pause.setRepeats(false);
		pause.start();
	}
	public void results () {
		buttonA.setVisible(false);
		buttonB.setVisible(false);
		answerFeedback.setVisible(false);
		secondsLeft.setVisible(false);
		timeLabel.setVisible(false);
		buttonStopGame.setVisible(false);
		buttonPauseGame.setVisible(false);
		buttonContinueGame.setVisible(false);
		pictureDisplay.setIcon(imageResult);
		
		result = (int)((correct_guesses/(double)controller.getAnzahlFragen())*100);
		
		
		textfield.setText(userFeedback.resultText);
		textarea.setText(userFeedback.resultComment);
		
		numberRight.setText("(" + correct_guesses + "/" + controller.getAnzahlFragen() + ")");
		percentage.setText(result + "%");
		
		frame.add(numberRight);
		frame.add(percentage);
		frame.add(pictureDisplay);
	}
}