package Ejercicio2.App.Controllers;

import java.awt.Color;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JTextField;

import Ejercicio2.App.Exceptions.PromotedStudent;
import Ejercicio2.App.Exceptions.RegularStudent;
import Ejercicio2.App.Models.Student;

public class StudentAverageController extends Controller {
	private static double average = 0.00;
	private static String condition = null;
	
	@SuppressWarnings("finally")
	public static final int getNote(JTextField value) {
		int note = 0;
		
		try {
			value.setBackground(Color.WHITE);
			assertOrFail(value.getText().trim().matches("[0-9]+"), new Exception());
			note = Integer.parseInt(value.getText().trim());
			assertOrFail(note >= 0 && note <= 10, new Exception());
		} catch(Exception e) {
			setError(true);
			value.setBackground(Color.RED);
		} finally {
			return note;
		}
	}
	
	public static final void setAverage(int a, int b, int c) {
		Student.setNotes(Arrays.asList(a, b, c));
		average = Student.getAverage();
	}
	
	public static final void setCondition(Object tpCondition) {		
		try {
			boolean isTPApproved = tpCondition == "Aprobado";
			assertOrFail(! (isTPApproved && Student.canBePromoted()), new PromotedStudent()); // Se niega para que no continue y salga por el catch
			assertOrFail(! (isTPApproved && Student.canBeRegularized()), new RegularStudent());
			assertOrFail(false, new Exception());
		} catch (PromotedStudent e) {
			condition = "PROMOCIONADO";
		} catch (RegularStudent e) {
			condition = "REGULAR";
		} catch (Exception e) {
			condition = "LIBRE";			
		}

	}
	
	public static final void fillOutput(JLabel tit, JLabel sAvg, JLabel sCon, JLabel oAvg, JLabel oCon) {
		tit.setVisible(true);
		sAvg.setVisible(true);
		sCon.setVisible(true);
		oAvg.setVisible(true);
		oCon.setVisible(true);
		oAvg.setText(Double.toString(average));
		oCon.setText(condition);
	}
	
	public static final void clean(JLabel tit, JLabel sAvg, JLabel sCon, JLabel oAvg, JLabel oCon, JTextField v1, JTextField v2, JTextField v3) {
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
}
