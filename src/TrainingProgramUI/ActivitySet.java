package TrainingProgramUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Logic.Athlete;

public class ActivitySet extends JFrame {

	private Athlete athlete;

	private JLabel labelActivity = new JLabel("Choose your type activity : ");
	private JLabel explain ;

	private ButtonGroup groupByActivity = new ButtonGroup();

	private JButton buttonOk;
	private JButton buttonBack;

	private JRadioButton activity1;
	private JRadioButton activity2;
	private JRadioButton activity3;
	private JRadioButton activity4;
	private JRadioButton activity5;
	
	

	public ActivitySet(Athlete athlete) {
		this.athlete = athlete;

		setVisible(true);
		setSize(500, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(null);

		activity1 = new JRadioButton("None");
		activity2 = new JRadioButton("Noob");
		activity3 = new JRadioButton("Snowdrop");
		activity4 = new JRadioButton("Train sometimes");
		activity5 = new JRadioButton("Athlete");

		groupByActivity.add(activity1);
		groupByActivity.add(activity2);
		groupByActivity.add(activity3);
		groupByActivity.add(activity4);
		groupByActivity.add(activity5);

		buttonOk = new JButton("Next step");
		buttonBack = new JButton("Back");
		explain = new JLabel("");
		
		
		labelActivity.setBounds(180,0,200,80);
		activity1.setBounds(10,50,100,50);
		activity2.setBounds(10,100,100,50);
		activity3.setBounds(10,150,100,50);
		activity4.setBounds(10,200,200,50);
		activity5.setBounds(10,250,100,50);
		explain.setBounds(10,400,500,100);
		buttonOk.setBounds(300, 600, 200, 80);
		buttonBack.setBounds(0, 600, 200, 80);

		panel.add(labelActivity);
		panel.add(activity1);
		panel.add(activity2);
		panel.add(activity3);
		panel.add(activity4);
		panel.add(activity5);
		panel.add(explain);
		panel.add(buttonOk);
		panel.add(buttonBack);

		add(panel);

		activity1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				athlete.setActivity(1.2);
				explain.setText("Sedentary (little or no exercise).");
			}
		});
		activity2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				athlete.setActivity(1.375);
				explain.setText("Lightly active (light exercise/sports 1-3 days/week).");
			}
		});
		activity3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				athlete.setActivity(1.55);
				explain.setText("Moderately active (moderate exercise/sports 3-5 days/week).");
			}
		});
		activity4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				athlete.setActivity(1.725);
				explain.setText("Very active (hard exercise/sports 6-7 days a week).");
			}
		});
		activity5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				athlete.setActivity(1.9);
				explain.setText("If you are extra active (very hard exercise/sports & a physical job).");
			}
		});

		buttonOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new GenderSet(athlete);
				

			}
		});
		buttonBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new FirstMenu();
			}
		});

	}
}
