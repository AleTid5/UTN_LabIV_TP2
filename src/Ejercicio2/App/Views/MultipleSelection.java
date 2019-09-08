package Ejercicio2.App.Views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
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
	private	JRadioButton rdbtnLinux = new JRadioButton("Linux");
	private JRadioButton rdbtnMac = new JRadioButton("Mac");
	private JRadioButton rdbtnWindows = new JRadioButton("Windows");
	private JCheckBox chckbxAdministracin = new JCheckBox("Administración");
	private JCheckBox chckbxDiseoGrfico = new JCheckBox("Diseño Gráfico");
	private JCheckBox chckbxProgramacion = new JCheckBox("Programación");
	private TextField txtHours;
	private Label lblElijaUnaEspecialidad;

	public MultipleSelection() {
		this.setHeader("Selección Multiple");

		Label lblElijaUnSistema = new Label(46, 168, 259, 15, "Elija un Sistema Operativo");		
		rdbtnWindows.setSelected(true);
		rdbtnWindows.setBackground(new Color(225, 193, 119));
		rdbtnWindows.setBounds(340, 162, 149, 23);		
		rdbtnMac.setBackground(new Color(225, 193, 119));
		rdbtnMac.setBounds(340, 189, 149, 23);
		rdbtnLinux.setBackground(new Color(225, 193, 119));
		rdbtnLinux.setBounds(340, 216, 149, 23);
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnWindows);
		group.add(rdbtnMac);
		group.add(rdbtnLinux);
		lblElijaUnaEspecialidad = new Label(46, 259, 259, 15, "Elija al menos una especialidad");		
		chckbxProgramacion.setBackground(new Color(225, 193, 119));
		chckbxProgramacion.setBounds(340, 256, 129, 23);
		chckbxAdministracin.setBackground(new Color(225, 193, 119));
		chckbxAdministracin.setBounds(340, 283, 149, 23);		
		chckbxDiseoGrfico.setBackground(new Color(225, 193, 119));
		chckbxDiseoGrfico.setBounds(340, 310, 149, 23);		
		Label lblCantidadDeHoras = new Label(46, 358, 259, 15, "Cantidad de horas en el computador");		
		txtHours = new TextField(343, 356, 129, 19);		
		Button buttonChk = new Button(445, 405, 24, 24, "Validar Formulario", new Image("check.png", 310, 537, 50, 50), this.submit());
		Button buttonCln = new Button(340, 405, 24, 24, "Limpiar Formulario", new Image("trash.png", 310, 537, 50, 50), this.clean());

		getContentPane().add(lblElijaUnSistema);
		getContentPane().add(rdbtnWindows);
		getContentPane().add(rdbtnMac);
		getContentPane().add(rdbtnLinux);
		getContentPane().add(lblElijaUnaEspecialidad);
		getContentPane().add(chckbxProgramacion);
		getContentPane().add(chckbxAdministracin);
		getContentPane().add(chckbxDiseoGrfico);
		getContentPane().add(lblCantidadDeHoras);
		getContentPane().add(txtHours);
		getContentPane().add(buttonChk);
		getContentPane().add(buttonCln);

		this.setVisible(true);
	}

	@Override
	public ActionListener submit() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MultipleSelectionController.setError(false);
				MultipleSelectionController.validate(chckbxProgramacion, chckbxAdministracin, chckbxDiseoGrfico, lblElijaUnaEspecialidad);
				String hours = MultipleSelectionController.validate(txtHours, "[0-9]+");

				if (! MultipleSelectionController.hasError()) {
					MultipleSelectionController.fillOutput(
							MultipleSelectionController.getSO(
									rdbtnLinux.isSelected(),
									rdbtnMac.isSelected(),
									rdbtnWindows.isSelected()),
							MultipleSelectionController.getSpecialties(
									chckbxProgramacion.isSelected(),
									chckbxAdministracin.isSelected(),
									chckbxDiseoGrfico.isSelected()),
							MultipleSelectionController.HOURS_IN + hours + " HS");
				}
			}
		};
	}

	@Override
	public ActionListener clean() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnWindows.setSelected(true);
				lblElijaUnaEspecialidad.setForeground(Color.getColor("DARK_GREY"));
				chckbxAdministracin.setSelected(false);
				chckbxDiseoGrfico.setSelected(false);
				chckbxProgramacion.setSelected(false);
				txtHours.setBackground(Color.white);
				txtHours.setText("");
			}
		};
	}
}
