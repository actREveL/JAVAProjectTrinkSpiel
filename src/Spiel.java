import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;


public class Spiel implements ActionListener{
	//die folgenden Variabeln sind ausserhalb der Funktionen damit alle Funktionen darauf zugreifen und sie ändern können.
	String[] questions = {
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
						};

	char guess;
	char answer;
	int index;
	int correct_guesses = 0;
	int totalQuestions = questions.length;
	int result;
	int seconds = 10;
	
	JFrame frame = new JFrame();
	JTextField textfield = new JTextField();
	JTextArea textarea = new JTextArea();
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JLabel answerLabelA = new JLabel();
	JLabel answerLabelB = new JLabel();
	JLabel timeLabel = new JLabel();
	JLabel secondsLeft = new JLabel();
	JTextField numberRight = new JTextField();
	JTextField percentage = new JTextField();
	
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
	
	public Spiel() {
		//Frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650,650);
		frame.getContentPane().setBackground(new Color(245,245,220));//Hintergrund noch ändern?
		frame.setLayout(null);
		frame.setResizable(false);
		
		//Zahl der Frage: Textfield
		textfield.setBounds(0,0,650,50);
		textfield.setBackground(new Color(50,50,50));//Hintergrund von Textfeld
		textfield.setForeground(new Color(25,255,0));//Schrift von Textfeld?
		textfield.setFont(new Font("Arial", Font.BOLD, 30));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		
		// Fragetext
		textarea.setBounds(0,50,650,50);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(new Color(50,50,50));//Hintergrund von Textfeld
		textarea.setForeground(new Color(25,255,0));//Schrift von Textfeld?
		textarea.setFont(new Font("Arial", Font.PLAIN, 25));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);
		
		//Button
		buttonA.setBounds(125,200,200,100);
		buttonA.setFont(new Font("Arial", Font.PLAIN, 25));
		buttonA.setFocusable(false);
		buttonA.setText("A");
		buttonA.addActionListener(this);	
		//buttonA.addActionListener(this); nach tutorial 26.36 sollte es funktionieren erhalte aber Fehlermeldung
		
		buttonB.setBounds(325,200,200,100);
		buttonB.setFont(new Font("Arial", Font.PLAIN, 25));
		buttonB.setFocusable(false);
		buttonB.setText("B");
		buttonB.addActionListener(this);
		//buttonB.addActionListener(this);
		
		//Antworttext
		answerLabelA.setBounds(125,100,500,100);
		answerLabelA.setBackground(new Color(50,50,50));
		answerLabelA.setForeground(new Color(25,255,0));
		answerLabelA.setFont(new Font("Arial", Font.PLAIN, 20));
	
		
		answerLabelB.setBounds(125,200,500,100);
		answerLabelB.setBackground(new Color(50,50,50));
		answerLabelB.setForeground(new Color(25,255,0));
		answerLabelB.setFont(new Font("Arial", Font.PLAIN, 20));
		
		secondsLeft.setBounds(535,510,100,100);
		secondsLeft.setBackground(new Color(25,25,25));
		secondsLeft.setForeground(new Color(255,0,0));
		secondsLeft.setFont(new Font("Arial", Font.BOLD, 60));
		secondsLeft.setBorder(BorderFactory.createBevelBorder(1));
		secondsLeft.setOpaque(true);
		secondsLeft.setHorizontalAlignment(JTextField.CENTER);
		secondsLeft.setText(String.valueOf(seconds));
		
		timeLabel.setBounds(535,475,100,25);
		timeLabel.setBackground(new Color (50,50,50));
		timeLabel.setForeground(new Color (255,0,0));
		timeLabel.setFont(new Font("Arial", Font.BOLD, 20));
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		timeLabel.setText("Timer");
		
		numberRight.setBounds(225,225,200,100);
		numberRight.setBackground(new Color(25,25,25));
		numberRight.setForeground(new Color(25,255,0));
		numberRight.setFont(new Font("Arial", Font.BOLD, 50));
		numberRight.setBorder(BorderFactory.createBevelBorder(1));
		numberRight.setHorizontalAlignment(JTextField.CENTER);
		numberRight.setEditable(false);
		
		percentage.setBounds(225,325,200,100);
		percentage.setBackground(new Color(25,25,25));
		percentage.setForeground(new Color(25,255,0));
		percentage.setFont(new Font("Arial", Font.BOLD, 50));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);
		
		frame.add(timeLabel);
		frame.add(secondsLeft); //weiter bei 35.04 https://www.youtube.com/watch?v=wk1Fbqh7Tew
		frame.add(answerLabelA);
		frame.add(answerLabelB);
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(textarea);
		frame.add(textfield);
		frame.setVisible(true);
		
		nextQuestion();
		
	}
	public void nextQuestion() {
		if(index>= totalQuestions) {
			results();
		}
		else {
			textfield.setText("Question "+ (index+1));
			textarea.setText(questions[index]);
			answerLabelA.setText(antwortmöglichkeiten[index][0]);
			answerLabelB.setText(antwortmöglichkeiten[index][1]);
			timer.start();
		}
	}
	
	public void actionPerformed(ActionEvent e) { //when someone presses the button (answer)
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		
		if(e.getSource()==buttonA) {
			answer = 'A';
			if(answer == answers[index]) {
				correct_guesses++;
			}
		}
		if(e.getSource()==buttonB) {
			answer = 'B';
			if(answer == answers[index]) {
				correct_guesses++;
			}
		}
		displayAnswer();
		
	}
	public void displayAnswer() {
		// wenn Timer bei 0 = falsch
		timer.stop();
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		
		if(answers[index] != 'A')
		answerLabelA.setForeground(new Color(255,0,0));
		if(answers[index] != 'B')
		answerLabelB.setForeground(new Color(255,0,0));	
		
		// Timer, wartet nach Antwort 2sek, bis nächste Aufgabe kommt bzw. Schriftfarbe sich wieder ändert
		Timer pause = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				answerLabelA.setForeground(new Color(25,255,0));
				answerLabelB.setForeground(new Color(25,255,0));
				
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
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		
		result = (int)((correct_guesses/(double)totalQuestions)*100);
		
		textfield.setText("RESULTS");
		textarea.setText("");
		answerLabelA.setText("");
		answerLabelB.setText("");
		
		numberRight.setText("(" + correct_guesses + "/" + totalQuestions + ")");
		percentage.setText(result + "%");
		
		frame.add(numberRight);
		frame.add(percentage);
		
	}
}

//Youtube-Channel -> https://www.youtube.com/watch?v=wk1Fbqh7Tew
