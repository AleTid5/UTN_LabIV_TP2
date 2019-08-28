package Ejercicio2.App.Views;

import javax.swing.JLabel;

import Ejercicio2.App.Elements.WindowBack;

@SuppressWarnings("serial")
public class Contacts extends WindowBack {
	public Contacts() {
		JLabel lblHola = new JLabel("Contactos");
		getContentPane().add(lblHola);
		setVisible(true);
	}
}
