package Ejercicio2.App.Elements;

import Ejercicio2.App.Interfaces.IBackButton;
import Ejercicio2.App.Views.Home;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

@SuppressWarnings("serial")
public class WindowBack extends Window implements IBackButton {
	public WindowBack() {		
		JButton btnNewButton = new JButton("");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setToolTipText("Volver a la pantalla principal");
		btnNewButton.setSelectedIcon(new ImageIcon(WindowBack.class.getResource("/Ejercicio2/App/Assets/home.png")));
		btnNewButton.setIcon(new ImageIcon(WindowBack.class.getResource("/Ejercicio2/App/Assets/home.png")));
		btnNewButton.addActionListener(this.goBack());
		btnNewButton.setBounds(371, 637, 50, 50);
		getContentPane().add(btnNewButton);
	}
	
	@Override
	public ActionListener goBack() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Home();
			}
		};
	}	
}
