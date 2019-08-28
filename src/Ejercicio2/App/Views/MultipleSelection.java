package Ejercicio2.App.Views;

import javax.swing.JLabel;

import Ejercicio2.App.Elements.WindowBack;

@SuppressWarnings("serial")
public class MultipleSelection extends WindowBack {
	public MultipleSelection() {
		JLabel lblHola = new JLabel("MultipleSelection");
		getContentPane().add(lblHola);
		setVisible(true);
	}
}
