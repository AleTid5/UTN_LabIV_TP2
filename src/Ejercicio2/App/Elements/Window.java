package Ejercicio2.App.Elements;

import javax.swing.JFrame;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import Ejercicio2.App.Interfaces.INavBar;
import Ejercicio2.App.Views.Contacts;
import Ejercicio2.App.Views.MultipleSelection;
import Ejercicio2.App.Views.StudentAverage;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class Window extends JFrame implements INavBar {	
	public Window() {
		setTitle("TP2");
		setBackground(Color.DARK_GRAY);
		setSize(500, 500);
		setLocation(350, 350);
		
		JMenuBar menuBar = new JMenuBar();
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
