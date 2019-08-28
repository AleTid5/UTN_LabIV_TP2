package Ejercicio2.App.Elements;

import Ejercicio2.App.Interfaces.IBackButton;
import Ejercicio2.App.Views.Home;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class WindowBack extends Window implements IBackButton {
	public WindowBack() {		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(this.goBack());
		btnNewButton.setBounds(12, 394, 117, 25);
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
