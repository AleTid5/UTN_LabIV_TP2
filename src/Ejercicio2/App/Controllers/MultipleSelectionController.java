package Ejercicio2.App.Controllers;

import java.awt.Color;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Ejercicio2.App.Elements.Alert;

public class MultipleSelectionController extends Controller {
	public static final void validate(JCheckBox v1, JCheckBox v2, JCheckBox v3, JLabel l) {
		try {
			l.setForeground(Color.getColor("DARK_GREY"));			
			assertOrFail(v1.isSelected() || v2.isSelected() || v3.isSelected(), new Exception());
		} catch(Exception e) {
			setError(true);
			l.setForeground(Color.RED);
		}
	}

	@SuppressWarnings("finally")
	public static final String validate(JTextField value, String regex) {
		String hours = value.getText().trim();
		try {
			value.setBackground(Color.WHITE);
			assertOrFail(value.getText().trim().matches(regex), new Exception());
		} catch(Exception e) {
			setError(true);
			value.setBackground(Color.RED);
		} finally {
			return hours;
		}
	}
	
	public static final String getSO(Boolean isL, Boolean isM, Boolean isW) {
		return isL ? "Linux" : isM ? "Mac" : "Windows";
	}
	
	public static final String getSpecialties(Boolean isP, Boolean isA, Boolean isD) {
		String returned = "";
		
		if (isP) returned += "Programación - ";
		if (isA) returned += "Administración - ";
		if (isD) returned += "Diseño Gráfico - ";
		
		return returned.substring(0, returned.length() - 3);
	}
	
	public static final void fillOutput(String so, String specialties, String hours) {
		new Alert("Selecciones", so + " | " + specialties + " | " + hours);
	}
}
