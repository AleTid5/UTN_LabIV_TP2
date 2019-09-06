package Ejercicio2.App.Views;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

import Ejercicio2.App.Controllers.MultipleSelectionController;
import Ejercicio2.App.Elements.Button;
import Ejercicio2.App.Elements.Image;
import Ejercicio2.App.Elements.Label;
import Ejercicio2.App.Elements.TextField;
import Ejercicio2.App.Elements.WindowBack;
import Ejercicio2.App.Interfaces.IForm;

@SuppressWarnings("serial")
public class MultipleSelection extends WindowBack implements IForm {
	private TextField textField;

	public MultipleSelection() {
		this.setHeader("Selección Multiple");

		Label lblElijaUnSistema = new Label(46, 168, 259, 15, "Elija un Sistema Operativo");		
		JRadioButton rdbtnWindows = new JRadioButton("Windows");
		rdbtnWindows.setBackground(SystemColor.controlShadow);
		rdbtnWindows.setBounds(340, 162, 149, 23);		
		JRadioButton rdbtnMac = new JRadioButton("Mac");
		rdbtnMac.setBackground(SystemColor.controlShadow);
		rdbtnMac.setBounds(340, 189, 149, 23);		
		JRadioButton rdbtnLinux = new JRadioButton("Linux");
		rdbtnLinux.setBackground(SystemColor.controlShadow);
		rdbtnLinux.setBounds(340, 216, 149, 23);		
		Label lblElijaUnaEspecialidad = new Label(46, 259, 259, 15, "Elija al menos una especialidad");		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Programación");
		chckbxNewCheckBox.setBackground(SystemColor.controlShadow);
		chckbxNewCheckBox.setBounds(340, 256, 129, 23);		
		JCheckBox chckbxAdministracin = new JCheckBox("Administración");
		chckbxAdministracin.setBackground(SystemColor.controlShadow);
		chckbxAdministracin.setBounds(340, 283, 149, 23);		
		JCheckBox chckbxDiseoGrfico = new JCheckBox("Diseño Gráfico");
		chckbxDiseoGrfico.setBackground(SystemColor.controlShadow);
		chckbxDiseoGrfico.setBounds(340, 310, 149, 23);		
		Label lblCantidadDeHoras = new Label(46, 358, 259, 15, "Cantidad de horas en el computador");		
		textField = new TextField(343, 356, 129, 19);		
		Button buttonChk = new Button(445, 405, 24, 24, "Validar Formulario", new Image("check.png", 310, 537, 50, 50), this.submit());
		Button buttonCln = new Button(340, 405, 24, 24, "Limpiar Formulario", new Image("trash.png", 310, 537, 50, 50), this.clean());

		getContentPane().add(lblElijaUnSistema);
		getContentPane().add(rdbtnWindows);
		getContentPane().add(rdbtnMac);
		getContentPane().add(rdbtnLinux);
		getContentPane().add(lblElijaUnaEspecialidad);
		getContentPane().add(chckbxNewCheckBox);
		getContentPane().add(chckbxAdministracin);
		getContentPane().add(chckbxDiseoGrfico);
		getContentPane().add(lblCantidadDeHoras);
		getContentPane().add(textField);
		getContentPane().add(buttonChk);
		getContentPane().add(buttonCln);

		this.setVisible(true);
	}

	@Override
	public ActionListener submit() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MultipleSelectionController.validate();
				
				if (! MultipleSelectionController.hasError()) {
					// Mostrar mensaje
				}
			}
		};
	}

	@Override
	public ActionListener clean() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		};
	}
}
