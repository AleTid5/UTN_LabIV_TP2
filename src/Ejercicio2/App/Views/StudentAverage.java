package Ejercicio2.App.Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import Ejercicio2.App.Controllers.StudentAverageController;
import Ejercicio2.App.Elements.Button;
import Ejercicio2.App.Elements.Image;
import Ejercicio2.App.Elements.Label;
import Ejercicio2.App.Elements.TextField;
import Ejercicio2.App.Elements.WindowBack;
import Ejercicio2.App.Interfaces.IForm;

@SuppressWarnings("serial")
public class StudentAverage extends WindowBack implements IForm {
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private TextField txtNote1;
	private TextField txtNote2;
	private TextField txtNote3;
	private Label lblSStudents;
	private Label lblSAverage;
	private Label lblSCondition;
	private Label lblOAverage;
	private Label lblOCondition;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public StudentAverage() {
		this.setHeader("Promedio");
		
		Label labelN1 = new Label(47, 159, 66, 15, "Nota 1");		
		Label labelN2 = new Label(47, 186, 66, 15, "Nota 2");
		Label labelN3 = new Label(47, 213, 66, 15, "Nota 3");		
		Label lblEstadoTpS = new Label(47, 240, 90, 15, "Estado TP' s");		
		txtNote1 = new TextField(156, 157, 124, 19);		
		txtNote2 = new TextField(156, 184, 124, 19);		
		txtNote3 = new TextField(156, 211, 124, 19);		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Aprobado", "Desaprobado"}));
		comboBox.setBounds(156, 240, 125, 24);		
		lblSStudents = new Label(401, 159, 124, 15, "Notas del Alumno", false);		
		lblSAverage = new Label(349, 186, 73, 15, "Promedio", false);		
		lblSCondition = new Label(349, 213, 73, 15, "Condición", false);		
		lblOAverage = new Label(452, 186, 131, 15, "");		
		lblOCondition = new Label(452, 213, 131, 15, "");		
		Button btnCheck = new Button(260, 287, 24, 24, "Validar Formulario", new Image("check.png", 310, 537, 50, 50), this.submit());		
		Button btnClean = new Button(154, 287, 24, 24, "Nuevo Estudiante", new Image("student.png", 310, 537, 50, 50), this.clean());		
		Button btnExit = new Button(47, 287, 24, 24, "Salir del sistema", new Image("close.png", 310, 537, 50, 50), this.exit());
		

		getContentPane().add(labelN1);
		getContentPane().add(labelN2);
		getContentPane().add(labelN3);
		getContentPane().add(lblEstadoTpS);
		getContentPane().add(txtNote1);
		getContentPane().add(txtNote2);
		getContentPane().add(txtNote3);
		getContentPane().add(comboBox);
		getContentPane().add(lblSStudents);
		getContentPane().add(lblSAverage);
		getContentPane().add(lblSCondition);
		getContentPane().add(lblOAverage);
		getContentPane().add(lblOCondition);
		getContentPane().add(btnCheck);
		getContentPane().add(btnClean);
		getContentPane().add(btnExit);
	}
	
	public ActionListener submit() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentAverageController.setError(false);
				int n1 = StudentAverageController.getNote(txtNote1);
				int n2 = StudentAverageController.getNote(txtNote2);
				int n3 = StudentAverageController.getNote(txtNote3);				
				StudentAverageController.setAverage(n1, n2, n3);
				StudentAverageController.setCondition(comboBox.getSelectedItem());
				
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
