package Ejercicio2.App.Views;

import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Ejercicio2.App.Controllers.StudentAverageController;
import Ejercicio2.App.Elements.Image;
import Ejercicio2.App.Elements.WindowBack;
import Ejercicio2.App.Interfaces.IForm;

@SuppressWarnings("serial")
public class StudentAverage extends WindowBack implements IForm {
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private JTextField txtNote1;
	private JTextField txtNote2;
	private JTextField txtNote3;
	private JLabel lblSStudents;
	private JLabel lblSAverage;
	private JLabel lblSCondition;
	private JLabel lblOAverage;
	private JLabel lblOCondition;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public StudentAverage() {
		this.setHeader("Promedio");
		
		JLabel lblNota = new JLabel("Nota 3");
		lblNota.setBounds(47, 213, 66, 15);
		getContentPane().add(lblNota);
		
		JLabel label = new JLabel("Nota 1");
		label.setBounds(47, 159, 66, 15);
		getContentPane().add(label);
		
		JLabel lblNota_1 = new JLabel("Nota 2");
		lblNota_1.setBounds(47, 186, 66, 15);
		getContentPane().add(lblNota_1);
		
		JLabel lblEstadoTpS = new JLabel("Estado TP' s");
		lblEstadoTpS.setBounds(47, 240, 90, 15);
		getContentPane().add(lblEstadoTpS);
		
		txtNote1 = new JTextField();
		txtNote1.setBounds(156, 157, 124, 19);
		getContentPane().add(txtNote1);
		txtNote1.setColumns(10);
		
		txtNote2 = new JTextField();
		txtNote2.setColumns(10);
		txtNote2.setBounds(156, 184, 124, 19);
		getContentPane().add(txtNote2);
		
		txtNote3 = new JTextField();
		txtNote3.setColumns(10);
		txtNote3.setBounds(156, 211, 124, 19);
		getContentPane().add(txtNote3);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Aprobado", "Desaprobado"}));
		comboBox.setBounds(156, 240, 125, 24);
		getContentPane().add(comboBox);
		
		lblSStudents = new JLabel("Notas del Alumno");
		lblSStudents.setBounds(401, 159, 124, 15);
		lblSStudents.setVisible(false);
		getContentPane().add(lblSStudents);
		
		lblSAverage = new JLabel("Promedio");
		lblSAverage.setBounds(349, 186, 73, 15);
		lblSAverage.setVisible(false);
		getContentPane().add(lblSAverage);
		
		lblSCondition = new JLabel("Condición");
		lblSCondition.setBounds(349, 213, 73, 15);
		lblSCondition.setVisible(false);
		getContentPane().add(lblSCondition);
		
		lblOAverage = new JLabel("");
		lblOAverage.setBounds(452, 186, 131, 15);
		getContentPane().add(lblOAverage);
		
		lblOCondition = new JLabel("");
		lblOCondition.setBounds(452, 213, 131, 15);
		getContentPane().add(lblOCondition);
		
		JButton btnCheck = new JButton("");
		Image imageCheck = new Image("check.png", 310, 537, 50, 50);
		btnCheck.setBackground(imageCheck.getBackground());
		btnCheck.setIcon(imageCheck.getIcon());
		btnCheck.setToolTipText("Validar Formulario");
		btnCheck.addActionListener(this.submit());
		btnCheck.setBounds(new Rectangle(260, 287, 24, 24));
		btnCheck.setBorder(null);
		getContentPane().add(btnCheck);
		setVisible(true);
		
		JButton btnClean = new JButton("");
		Image imageStudent = new Image("student.png", 310, 537, 50, 50);
		btnClean.setBackground(imageStudent.getBackground());
		btnClean.setIcon(imageStudent.getIcon());
		btnClean.setToolTipText("Nuevo Estudiante");
		btnClean.addActionListener(this.clean());
		btnClean.setBounds(new Rectangle(154, 287, 24, 24));
		btnClean.setBorder(null);
		getContentPane().add(btnClean);
		
		JButton btnExit = new JButton("");
		Image imageExit= new Image("close.png", 310, 537, 50, 50);
		btnExit.setBackground(imageExit.getBackground());
		btnExit.setIcon(imageExit.getIcon());
		btnExit.setToolTipText("Salir del sistema");
		btnExit.addActionListener(this.exit());
		btnExit.setBounds(new Rectangle(47, 284, 24, 24));
		btnExit.setBorder(null);
		btnExit.setBackground(SystemColor.controlShadow);
		btnExit.setBounds(47, 287, 24, 24);
		getContentPane().add(btnExit);
	}
	
	public ActionListener submit() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentAverageController.setError(false);
				int n1 = StudentAverageController.getNote(txtNote1);
				int n2 = StudentAverageController.getNote(txtNote2);
				int n3 = StudentAverageController.getNote(txtNote3);				
				StudentAverageController.calculateAverage(n1, n2, n3);
				StudentAverageController.calculateCondition(comboBox.getSelectedItem());
				
				if (! StudentAverageController.hasError())
					StudentAverageController.fillOutput(lblSStudents, lblSAverage, lblSCondition, lblOAverage, lblOCondition);
			}
		};
	}
	
	public ActionListener clean() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentAverageController.clean(lblSStudents, lblSAverage, lblSCondition, lblOAverage, lblOCondition, txtNote1, txtNote2, txtNote3);
			}
		};
	}
	
	public ActionListener exit() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};
	}
}
