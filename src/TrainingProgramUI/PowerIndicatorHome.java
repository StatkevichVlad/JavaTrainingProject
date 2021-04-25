package TrainingProgramUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Logic.Athlete;
import Logic.Coach;

public class PowerIndicatorHome extends JFrame{
	Coach coach = new Coach();
	Athlete athlete = new Athlete();
	
	private int pushUpsMax;
	private int sitUpsMax;
	private int airSquatsMax;
	
	private JLabel labelPushUps;
	private JLabel labelSitUps;
	private JLabel labelAirSquats;
	private JLabel labelAttention;

	
	private JTextField pushUpsInput;
	private JTextField sitUpsInput;
	private JTextField airSquatsInput;
	
	
	private JButton buttonBack;
	private JButton buttonOk ;
	
	
	public PowerIndicatorHome(Athlete athlete) {
		this.athlete = athlete;
		
		setTitle("Trainig Program v1.0");
		setVisible(true);
		setSize(500, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		labelPushUps = new JLabel("How many push-ups can you do unbroken? ");
		labelSitUps = new JLabel("How many sit-ups can you do unbroken? ");
		labelAirSquats = new JLabel("How many air squat can you do unbroken? ");
		labelAttention = new JLabel("");
		
		pushUpsInput = new JTextField(15);
		sitUpsInput = new JTextField(15);
		airSquatsInput = new JTextField(15);
		
		buttonBack = new JButton("Back");
		buttonOk = new JButton("Create training program");
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		panel.add(labelPushUps);
		panel.add(pushUpsInput);
		panel.add(labelSitUps);
		panel.add(sitUpsInput);
		panel.add(labelAirSquats);
		panel.add(airSquatsInput);
		panel.add(labelAttention);
		
		panel.add(buttonBack);
		panel.add(buttonOk);
		
		labelPushUps.setBounds(10,10,500,50);
		pushUpsInput.setBounds(10,50,480,50);
		labelSitUps.setBounds(10,100,500,50);
		sitUpsInput.setBounds(10,150,480,50);
		labelAirSquats.setBounds(10,200,500,50);	
		airSquatsInput.setBounds(10,250,480,50);
		buttonBack.setBounds(0, 600, 200, 80);
		labelAttention.setBounds(10,300,500,80);
		buttonOk.setBounds(300,600,200,80);
		
		add(panel);
		
		
		buttonOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				pushUpsMax = Integer.parseInt(pushUpsInput.getText());
				sitUpsMax = Integer.parseInt(sitUpsInput.getText());
				airSquatsMax = Integer.parseInt(airSquatsInput.getText());
				
				coach.pushUpsProgression(pushUpsMax);
				coach.sitUpsProgression(sitUpsMax);
				coach.airSquatProgression(airSquatsMax);
				
				setVisible(false);
				new WorkoutOne(coach,athlete);
				
				}
				catch(Exception ex) {
					labelAttention.setText("Please, enter correct values !!!");
				}
				
			}
		});
		
		buttonBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new SetGoal(athlete);
			}
		});
	
	}
	
	
	

}
