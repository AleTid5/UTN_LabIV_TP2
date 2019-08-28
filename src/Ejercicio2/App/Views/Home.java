package Ejercicio2.App.Views;

import javax.swing.JLabel;
import Ejercicio2.App.Elements.Window;

@SuppressWarnings("serial")
public class Home extends Window {	
	public Home() {
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setBounds(155, 202, 123, 15);
		getContentPane().add(lblBienvenido);
		setVisible(true);
	}
}
