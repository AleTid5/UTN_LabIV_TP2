package Ejercicio2.App.Views;

import javax.swing.JLabel;

import Ejercicio2.App.Elements.WindowBack;

@SuppressWarnings("serial")
public class StudentAverage extends WindowBack {
	public StudentAverage() {
		JLabel lblHola = new JLabel("StudentAverage");
		getContentPane().add(lblHola);
		setVisible(true);
	}
}
