package TrainingProgramUI;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Logic.Athlete;
import Logic.Coach;
import mySQL.DBAthletes;
import mySQL.DBworker;

public class WorkoutOne extends JFrame {
	Coach coach = new Coach();
	Athlete athlete;
	DBworker dBworker = new DBworker();
	DBAthletes dbAthletes = new DBAthletes(dBworker);

	private JLabel labelWurmUp;
	private JLabel labelWorkout;
	private JLabel labelPostWorkout;
	private JLabel labelPicture;
	private ImageIcon icon;

	private JButton buttonJumpingJack;
	private JButton buttonBurpees;

	private JButton buttonPushUP;
	private JButton buttonSitUps;
	private JButton buttonAirSquats;

	private JButton buttonPlank;
	private JButton buttonSitWall;

	private JButton buttonBack;
	private JButton buttonFinish;

	public WorkoutOne(Coach coach, Athlete athlete) {
		this.coach = coach;
		this.athlete = athlete;

		setTitle("Trainig Program v1.0");
		setVisible(true);
		setSize(550, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		labelPicture = new JLabel("Push to button to see exercise");

		labelWurmUp = new JLabel("Wurm-up : 3 rounds of :");
		labelWorkout = new JLabel("Worcout 3 rounds of : ");
		labelPostWorkout = new JLabel("Post-Workot : ");

		buttonJumpingJack = new JButton("30 Jumpimg-Jack");
		buttonBurpees = new JButton("3 burpees");

		buttonPushUP = new JButton(coach.getPushUps() + " push-ups;");
		buttonSitUps = new JButton(coach.getSitUps() + " sit-ups");
		buttonAirSquats = new JButton(coach.getAirSquats() + " air squat");

		buttonPlank = new JButton("Elbow plank");
		buttonSitWall = new JButton("SitWall");

		buttonBack = new JButton("Back");
		buttonFinish = new JButton("Finish");

		JPanel panel = new JPanel();
		panel.setLayout(null);

		panel.add(labelWurmUp);
		panel.add(buttonJumpingJack);
		panel.add(buttonBurpees);
		panel.add(labelWorkout);
		panel.add(buttonPushUP);
		panel.add(buttonSitUps);
		panel.add(buttonAirSquats);
		panel.add(labelPostWorkout);
		panel.add(buttonPlank);
		panel.add(buttonSitWall);
		panel.add(labelPicture);
		panel.add(buttonBack);
		panel.add(buttonFinish);

		labelWurmUp.setBounds(20, 0, 300, 80);
		buttonJumpingJack.setBounds(10, 50, 200, 50);
		buttonBurpees.setBounds(10, 100, 200, 50);
		labelWorkout.setBounds(10, 150, 200, 50);
		buttonPushUP.setBounds(10, 200, 200, 50);
		buttonSitUps.setBounds(10, 250, 200, 50);
		buttonAirSquats.setBounds(10, 300, 200, 50);
		labelPostWorkout.setBounds(10, 350, 200, 50);
		buttonPlank.setBounds(10, 400, 200, 50);
		buttonSitWall.setBounds(10, 450, 200, 50);
		labelPicture.setBounds(230, 75, 300, 400);
		buttonBack.setBounds(0, 600, 300, 80);
		buttonFinish.setBounds(300, 600, 300, 80);

		add(panel);

		buttonJumpingJack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				icon = new ImageIcon("myImages/jumpingJack.gif");
				labelPicture.setIcon(icon);

			}
		});
		buttonBurpees.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				icon = new ImageIcon("myImages/burpee.gif");
				icon.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
				labelPicture.setIcon(icon);
			}
		});

		buttonAirSquats.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				icon = new ImageIcon("myImages/airSquat.gif");
				labelPicture.setIcon(icon);

			}
		});

		buttonPushUP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				icon = new ImageIcon("myImages/pushUp.gif");
				labelPicture.setIcon(icon);

			}
		});

		buttonSitUps.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				icon = new ImageIcon("myImages/sitUp.gif");
				labelPicture.setIcon(icon);

			}
		});

		buttonPlank.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				icon = new ImageIcon("myImages/elbowPlank.jpg");
				labelPicture.setIcon(icon);

			}
		});

		buttonSitWall.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				icon = new ImageIcon("myImages/sitWall.jpg");
				icon.getImage().getScaledInstance(300, 400, Image.SCALE_SMOOTH);
				labelPicture.setIcon(icon);

			}
		});

		buttonBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new PowerIndicatorHome(athlete);
			}
		});

		buttonFinish.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dbAthletes.createAthlete(athlete.getName(), athlete.getAge(), athlete.getWeigth(), athlete.getHeigth(),
						athlete.getRecommentedCalories(), coach.getPushUps(), coach.getSitUps(), coach.getAirSquats());
				setVisible(false);
			}
		});

	}

}
