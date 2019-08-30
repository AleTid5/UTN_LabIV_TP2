package Ejercicio2.App.Views;

import javax.swing.JLabel;
import Ejercicio2.App.Elements.Window;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Home extends Window {
	public Home() {
		
		JLabel label = new JLabel(new ImageIcon(Home.class.getResource("/Ejercicio2/App/Assets/utn.png")));
		label.setBounds(537, 0, 201, 78);
		getContentPane().add(label);
		setVisible(true);
	}
}
