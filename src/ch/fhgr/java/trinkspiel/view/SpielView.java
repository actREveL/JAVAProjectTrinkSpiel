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

/*Colours:

Background-Colour "Question 1": RGB (80, 94, 99)
Schriftfarbe "Question 1": RGB (185, 219, 232)
Background-Colour Questions: RGB (88, 152, 176)
Background-Colour Spielfeld: RGB (185, 219, 232)
Schrift Timer: RGB (255, 0, 0)
Schriftfarbe allg. (Schwarz): RGB (0, 0, 0) */


public class SpielView implements ActionListener{
	//die folgenden Variabeln sind ausserhalb der Funktionen damit alle Funktionen darauf zugreifen und sie ändern können.
	/*String[] questions = {
						"Wie heisst der Churer Hausberg?",
						"Welches sind die grössten Events von Chur?",
						"Stimmt es dass in Chur eine Polizeistunde herrscht?"
						};
	
	String[][] antwortmöglichkeiten = {
						{"Brambrüesch", "Haldensteiner Calanda"},
						{"BigAir,Schlagerparade", "Fasnacht, Churer Fest"},
						{"Ja", "Nein"}
						};
	
	char[] answers = {
						'A',
						'A',
						'B'
						}; -> brauchen wir hier nicht */

	private SpielAblaufController controller = new SpielAblaufController();
	
	private int answer;
	private int index;
	private int correct_guesses = 0;
	private int result;
	int seconds = 10;
	
	// TO DO: alles was noch angefasst wird private machen und alles andere kann runter in SpielView
	JFrame frame = new JFrame();
	JTextField textfield = new JTextField();
	JTextField textfieldQuestion = new JTextField();
	JTextArea textarea = new JTextArea();
	private JButton buttonA = new JButton();
	private JButton buttonB = new JButton();
	JLabel answerLabelA = new JLabel();
	JLabel answerLabelB = new JLabel();
	JTextField answerFeedback = new JTextField();
	JLabel timeLabel = new JLabel();
	JLabel secondsLeft = new JLabel();
	JTextField numberRight = new JTextField();
	JTextField percentage = new JTextField();
	JLabel pictureDisplay = new JLabel();
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
		frame.getContentPane().setBackground(new Color(185,219,232));//Hintergrund noch ändern?
		frame.setLayout(null);
		frame.setResizable(false);
		
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
		
		textfieldQuestion.setBounds(0,80,1200,120);
		textfieldQuestion.setBorder(null);
		textfieldQuestion.setBackground(new Color(88,152,176));
		
		//Button
		buttonA.setBounds(200,225,800,80);
		buttonA.setFont(new Font("Arial", Font.PLAIN, 25));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);	

		
		buttonB.setBounds(200,305,800,80);
		buttonB.setFont(new Font("Arial", Font.PLAIN, 25));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		
		//Antworttext
		//answerLabelA.setBounds(125,100,500,100);
		//answerLabelA.setBackground(new Color(50,50,50));
		//answerLabelA.setForeground(new Color(25,255,0));
		//answerLabelA.setFont(new Font("Arial", Font.PLAIN, 20));
		
		//answerLabelB.setBounds(125,200,500,100);
		//answerLabelB.setBackground(new Color(50,50,50));
		//answerLabelB.setForeground(new Color(25,255,0));
		//answerLabelB.setFont(new Font("Arial", Font.PLAIN, 20));
		
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
		timeLabel.setText("Mach vorwärts \uD83E\uDD21");
		
		//Antwort Feedback
		answerFeedback.setBounds(200,385,800,80);
		answerFeedback.setBackground(new Color(80,94,99));
		answerFeedback.setForeground(new Color(185,219,232));
		answerFeedback.setFont(new Font("Arial", Font.PLAIN, 20));
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
		//frame.add(answerLabelA);
		//frame.add(answerLabelB);
		frame.add(buttonA);
		frame.add(buttonB);
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
			buttonA.setText(frage.getAntwortvarianten().get(0));
			buttonB.setText(frage.getAntwortvarianten().get(1));
			timer.start();
		}
	}
	
	public void actionPerformed(ActionEvent e) { //when someone presses the button (answer)
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		
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
				answerFeedback.setText("Richtiiiig du Champ");
			}else {
				answerFeedback.setText("Falsch du Nichtskönner");
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
		if(richtig != 0)
		answerLabelA.setForeground(new Color(255,0,0));
		
		
		if(richtig != 1)
		answerLabelB.setForeground(new Color(255,0,0));	
		
		// Timer, wartet nach Antwort 2sek, bis nächste Aufgabe kommt bzw. Schriftfarbe sich wieder ändert
		Timer pause = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				answerLabelA.setForeground(new Color(25,255,0));
				answerLabelB.setForeground(new Color(25,255,0));
				
				answerFeedback.setText("Weiter geht's");
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
		pictureDisplay.setIcon(imageResult);
		
		result = (int)((correct_guesses/(double)controller.getAnzahlFragen())*100);
		
		
		textfield.setText("RESULTATE:");
		textarea.setText("Du heschs gschafft aber suuf wiiter!");
		answerLabelA.setText("");
		answerLabelB.setText("");
		
		numberRight.setText("(" + correct_guesses + "/" + controller.getAnzahlFragen() + ")");
		percentage.setText(result + "%");
		
		frame.add(numberRight);
		frame.add(percentage);
		frame.add(pictureDisplay);
	}
}

//Youtube-Channel -> https://www.youtube.com/watch?v=wk1Fbqh7Tew
