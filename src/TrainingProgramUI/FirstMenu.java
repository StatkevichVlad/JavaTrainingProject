package TrainingProgramUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Logic.Athlete;

public class FirstMenu extends JFrame {

	private Athlete athlete = new Athlete();

	public Athlete getAthlete() {
		return athlete;
	}

	public void setAthlete(Athlete athlete) {
		this.athlete = athlete;
	}

	private JLabel labelName = new JLabel("Name : ");
	private JLabel labelHeigth = new JLabel("Heigth , sm : ");
	private JLabel labelAge = new JLabel("Age , years : ");
	private JLabel labelWeigth = new JLabel("Weigth , kg : ");
	private JLabel labelAttention;

	private JTextField name;
	private JTextField age;
	private JTextField weigth;
	private JTextField heigth;

	private JButton buttonOk;

	public FirstMenu() {
		setTitle("Trainig Program v1.0");
		setVisible(true);
		setSize(500, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(null);

		name = new JTextField(15);
		age = new JTextField(15);
		weigth = new JTextField(15);
		heigth = new JTextField(15);
		buttonOk = new JButton("Ok");
		labelAttention = new JLabel("");

		labelName.setBounds(10, 10, 100, 50);
		name.setBounds(200, 10, 290, 50);
		labelAge.setBounds(10, 100, 100, 50);
		age.setBounds(200, 100, 290, 50);
		labelWeigth.setBounds(10, 200, 100, 50);
		weigth.setBounds(200, 200, 290, 50);
		labelHeigth.setBounds(10, 300, 100, 50);
		heigth.setBounds(200, 300, 290, 50);
		buttonOk.setBounds(300, 600, 200, 80);
		labelAttention.setBounds(150, 400, 500, 100);

		panel.add(labelHeigth);
		panel.add(weigth);
		panel.add(labelWeigth);
		panel.add(age);
		panel.add(labelAge);
		panel.add(name);
		panel.add(labelName);
		panel.add(heigth);

		panel.add(labelAttention);

		panel.add(buttonOk);

		add(panel);

		buttonOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Ok");
				try {
					athlete.setName(name.getText());
					athlete.setAge(Integer.parseInt(age.getText()));
					athlete.setWeigth(Integer.parseInt(weigth.getText()));
					athlete.setHeigth(Integer.parseInt(heigth.getText()));
					setVisible(false);
					new ActivitySet(athlete);

					athlete.printInfo();

				} catch (Exception ee) {
					
					labelAttention.setText("Please, enter correct values !!!");

				}

			}
		});

	}
}
