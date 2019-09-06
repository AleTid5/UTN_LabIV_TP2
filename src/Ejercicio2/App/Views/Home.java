package Ejercicio2.App.Views;

import Ejercicio2.App.Elements.Image;
import Ejercicio2.App.Elements.Label;
import Ejercicio2.App.Elements.Window;
import javax.swing.JLabel;
import java.awt.Font;

@SuppressWarnings("serial")
public class Home extends Window {
	public Home() {
		this.setHeader("Inicio");
		
		JLabel lbl1 = new Label(119, 134, 415, 36, "TRABAJO PRÁCTICO N° 2");
		lbl1.setFont(new Font("Dialog", Font.BOLD, 30));
		
		JLabel lbl2 = new Label(12, 572, 101, 15, "Alejandro M. Tidele");
		lbl2.setFont(new Font("Dialog", Font.ITALIC, 10));
		
		JLabel lbl3 = new Label(563, 572, 75, 15, "Legajo: 21841");
		lbl3.setFont(new Font("Dialog", Font.ITALIC, 10));

		getContentPane().add(lbl1);
		getContentPane().add(lbl2);
		getContentPane().add(lbl3);
		getContentPane().add(new Image("space.gif", 12, 216, 626, 321));
		
		this.setVisible(true);
	}
}
