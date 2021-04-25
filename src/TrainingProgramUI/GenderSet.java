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

public class GenderSet extends JFrame {
	private Athlete athlete;

	private JLabel labelSex = new JLabel("Choose your gender : ");
	private ButtonGroup group = new ButtonGroup();

	private JButton buttonOk;
	private JButton buttonBack;

	private JRadioButton menRadioButton;
	private JRadioButton womenRadioButton;

	public GenderSet(Athlete athlete) {
		this.athlete = athlete;

		setTitle("Trainig Program v1.0");
		setVisible(true);
		setSize(500, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		menRadioButton = new JRadioButton("Men");
		womenRadioButton = new JRadioButton("Women");

		buttonOk = new JButton("Ok");
		buttonBack = new JButton("Back");

		group.add(menRadioButton);
		group.add(womenRadioButton);

		JPanel panel = new JPanel();
		panel.setLayout(null);

		labelSex.setBounds(180, 0, 200, 100);
		menRadioButton.setBounds(10, 60, 200, 50);
		womenRadioButton.setBounds(10, 90, 100, 50);
		buttonOk.setBounds(300, 600, 200, 80);
		buttonBack.setBounds(0, 600, 200, 80);

		panel.add(labelSex);
		panel.add(menRadioButton);
		panel.add(womenRadioButton);
		panel.add(buttonOk);
		panel.add(buttonBack);
		add(panel);

		menRadioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				athlete.setSex(true);

			}
		});

		womenRadioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				athlete.setSex(false);

			}
		});

		buttonOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new SetGoal(athlete);
			}
		});
		buttonBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ActivitySet(athlete);
			}
		});

	}

}
