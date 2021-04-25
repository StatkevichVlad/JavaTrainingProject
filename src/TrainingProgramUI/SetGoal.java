package TrainingProgramUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Logic.Athlete;

public class SetGoal extends JFrame{
	Athlete athlete;

	private JLabel labelGoal ;
	private JLabel labelResult = new JLabel("");

	private ButtonGroup groupByGoal = new ButtonGroup();

	private JRadioButton buttonLoseWeigth;
	private JRadioButton buttonSameWeigth;
	private JRadioButton buttonGainWeigth;
	
	private JButton buttonOk;
	private JButton buttonNext;
	private JButton buttonBack;
	
	public SetGoal(Athlete athlete) {
		this.athlete = athlete;
		
		setTitle("Trainig Program v1.0");
		setVisible(true);
		setSize(500, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		labelGoal = new JLabel("Your goal is: ");
		
		buttonLoseWeigth = new JRadioButton("Lose weigth");
		buttonSameWeigth = new JRadioButton("Stay in same weigth");
		buttonGainWeigth = new JRadioButton("Gain weigth");
		
		buttonOk = new JButton("Generate");
		buttonBack = new JButton("Back");
		buttonNext = new JButton("Next step to be perfect");
		
		groupByGoal.add(buttonLoseWeigth);
		groupByGoal.add(buttonSameWeigth);
		groupByGoal.add(buttonGainWeigth);
		
		
		labelGoal.setBounds(200,0,200,80);
		buttonLoseWeigth.setBounds(10,50,200,80);
		buttonSameWeigth.setBounds(10,100,200,80);
		buttonGainWeigth.setBounds(10,150,200,80);
		
		buttonOk.setBounds(0, 220, 500, 80);
		labelResult.setBounds(10,300,500,80);
		buttonBack.setBounds(0, 600, 200, 80);
		buttonNext.setBounds(300,600,200,80);
		
		panel.add(labelGoal);
		panel.add(buttonLoseWeigth);
		panel.add(buttonSameWeigth);
		panel.add(buttonGainWeigth);
		panel.add(buttonBack);
		panel.add(buttonOk);
		panel.add(labelResult);
		panel.add(buttonNext);
		
		
		add(panel);
		
		buttonLoseWeigth.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				athlete.setGoal(-250); 
			}
		});
		buttonSameWeigth.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				athlete.setGoal(-0); 			}
		});
		buttonGainWeigth.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				athlete.setGoal(+250); 			}
		});
		
		buttonOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				athlete.calcCalories();
				labelResult.setText("You have to eat " + athlete.getRecommentedCalories() + " calories ."  );
				athlete.printInfo();
			}
		});
		
		buttonNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new PowerIndicatorHome(athlete);
				
			}
		});
		
		buttonBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new GenderSet(athlete);
			}
		});
		
		
		
		
	}

}
