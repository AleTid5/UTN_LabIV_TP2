package Ejercicio2.App.Controllers;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class StudentAverageController extends Controller {
	private static Boolean error = false;
	private static double average = 0.00;
	private static String condition = null;
	
	public static int getNote(JTextField value) {
		int note = 0;
		
		try {
			value.setBackground(Color.WHITE);
			assertOrFail(value.getText().trim().matches("[0-9]+"), new Exception());
			note = Integer.parseInt(value.getText().trim());
			assertOrFail(note >= 0 && note <= 10, new Exception());
		} catch(Exception e) {
			setError(true);
			value.setBackground(Color.RED);
		}
		
		return note;
	}
	
	public static void calculateAverage(int a, int b, int c) {
		average = (a + b + c) / 3;
	}
	
	public static void calculateCondition(Object tpCondition) {
		boolean isTPApproved = tpCondition == "Aprobado";
		
		if (isTPApproved && average >= 8) {
			condition = "PROMOCIONADO";
		} else if (isTPApproved && average >= 6) {
			condition = "REGULAR";			
		} else {
			condition = "LIBRE";
		}
	}
	
	public static void fillOutput(JLabel tit, JLabel sAvg, JLabel sCon, JLabel oAvg, JLabel oCon) {
		tit.setVisible(true);
		sAvg.setVisible(true);
		sCon.setVisible(true);
		oAvg.setVisible(true);
		oCon.setVisible(true);
		oAvg.setText(Double.toString(average));
		oCon.setText(condition);
	}
	
	public static void clean(JLabel tit, JLabel sAvg, JLabel sCon, JLabel oAvg, JLabel oCon, JTextField v1, JTextField v2, JTextField v3) {
		v1.setBackground(Color.WHITE);
		v2.setBackground(Color.WHITE);
		v3.setBackground(Color.WHITE);
		v1.setText("");
		v2.setText("");
		v3.setText("");
		tit.setVisible(false);
		sAvg.setVisible(false);
		sCon.setVisible(false);
		oAvg.setVisible(false);
		oCon.setVisible(false);
	}

	public static Boolean hasError() {
		return error;
	}

	public static void setError(Boolean error) {
		StudentAverageController.error = error;
	}
}
