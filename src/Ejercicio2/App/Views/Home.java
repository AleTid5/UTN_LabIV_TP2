package Ejercicio2.App.Views;

import Ejercicio2.App.Elements.Image;
import Ejercicio2.App.Elements.Window;
import javax.swing.JLabel;
import java.awt.Font;

@SuppressWarnings("serial")
public class Home extends Window {
	public Home() {
		this.setHeader("Inicio");
		
		JLabel spaceImage = new Image("space.gif", 12, 216, 626, 321);
		getContentPane().add(spaceImage);
		
		JLabel lblNewLabel_1 = new JLabel("TRABAJO PRÁCTICO N° 2");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel_1.setBounds(119, 134, 415, 36);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblAlejandroMTidele = new JLabel("Alejandro M. Tidele");
		lblAlejandroMTidele.setFont(new Font("Dialog", Font.ITALIC, 10));
		lblAlejandroMTidele.setBounds(12, 572, 101, 15);
		getContentPane().add(lblAlejandroMTidele);
		
		JLabel lblLegajo = new JLabel("Legajo: 21841");
		lblLegajo.setFont(new Font("Dialog", Font.ITALIC, 10));
		lblLegajo.setBounds(563, 572, 75, 15);
		getContentPane().add(lblLegajo);
		this.setVisible(true);
	}
}
