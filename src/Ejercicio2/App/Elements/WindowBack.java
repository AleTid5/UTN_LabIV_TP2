package Ejercicio2.App.Elements;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JSeparator;

import Ejercicio2.App.Interfaces.IBackButton;
import Ejercicio2.App.Views.Home;

@SuppressWarnings("serial")
public class WindowBack extends Window implements IBackButton {
	public WindowBack() {		
		JButton btnNewButton = new JButton("");
		Image imageHome = new Image("home.png", 310, 537, 50, 50);
		btnNewButton.setBackground(imageHome.getBackground());
		btnNewButton.setToolTipText("Volver a la pantalla principal");
		btnNewButton.setIcon(imageHome.getIcon());
		btnNewButton.addActionListener(this.goBack());
		btnNewButton.setBounds(imageHome.getBounds());
		btnNewButton.setBorder(null);
		getContentPane().add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBackground(Color.LIGHT_GRAY);
		separator.setBounds(47, 131, 548, 13);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBackground(Color.LIGHT_GRAY);
		separator_1.setBounds(47, 512, 548, 13);
		getContentPane().add(separator_1);
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
