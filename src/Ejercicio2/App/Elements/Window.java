package Ejercicio2.App.Elements;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import Ejercicio2.App.Interfaces.INavBar;
import Ejercicio2.App.Views.Contacts;
import Ejercicio2.App.Views.MultipleSelection;
import Ejercicio2.App.Views.StudentAverage;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Window extends JFrame implements INavBar {	
	public Window() {
		getContentPane().setFont(new Font("Khmer OS System", Font.PLAIN, 11));
		getContentPane().setBackground(SystemColor.controlShadow);
		setTitle("TP2");
		setBackground(Color.DARK_GRAY);
		setSize(750, 750);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Khmer OS", Font.BOLD, 11));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menú principal");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmEjercicio = new JMenuItem("Ejercicio 1");
		mntmEjercicio.addActionListener(this.ShowContactsView());
		mnNewMenu.add(mntmEjercicio);
		
		JMenuItem mntmEjercicio_1 = new JMenuItem("Ejercicio 2");
		mntmEjercicio_1.addActionListener(this.ShowStudentAverageView());
		mnNewMenu.add(mntmEjercicio_1);
		
		JMenuItem mntmEjercicio_2 = new JMenuItem("Ejercicio 3");
		mntmEjercicio_2.addActionListener(this.ShowMultipleSelectionView());
		mnNewMenu.add(mntmEjercicio_2);

		getContentPane().setLayout(null);
		
		JLabel label = new JLabel(new ImageIcon(Window.class.getResource("/Ejercicio2/App/Assets/utn.png")));
		label.setBackground(SystemColor.controlShadow);
		label.setBounds(525, 12, 201, 78);
		getContentPane().add(label);
	}

	@Override
	public ActionListener ShowContactsView() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Contacts();
			}
		};		
	}

	@Override
	public ActionListener ShowMultipleSelectionView() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new MultipleSelection();
			}
		};		
	}

	@Override
	public ActionListener ShowStudentAverageView() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new StudentAverage();
			}
		};	
	}	
	
}
