package Ejercicio2.App.Controllers;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class ContactController extends Controller {
	private static Boolean error = false;
	
	public static void validate(JTextField value, String regex) {
		try {
			value.setBackground(Color.WHITE);
			assertOrFail(value.getText().trim().matches(regex), new Exception());
		} catch(Exception e) {
			setError(true);
			value.setBackground(Color.RED);
		}
	}
	
	public static void cleanForm(JTextField name, JTextField lastname, JTextField phone, JTextField bornDate,
			JLabel sTitle, JLabel sName, JLabel sLastname, JLabel sPhone, JLabel sBD, JLabel oName,
			JLabel oLastname, JLabel oPhone, JLabel oBD) {
		name.setText("");
		name.setBackground(Color.WHITE);
		lastname.setText("");
		lastname.setBackground(Color.WHITE);
		phone.setText("");
		phone.setBackground(Color.WHITE);
		bornDate.setText("");
		bornDate.setBackground(Color.WHITE);
		sTitle.setVisible(false);
		sName.setVisible(false);
		sLastname.setVisible(false);
		sPhone.setVisible(false);
		sBD.setVisible(false);
		oName.setVisible(false);
		oName.setText(name.getText().trim());
		oLastname.setVisible(false);
		oLastname.setText(name.getText().trim());
		oPhone.setVisible(false);
		oPhone.setText(name.getText().trim());
		oBD.setVisible(false);
		oBD.setText(name.getText().trim());
	}
	
	public static void fillOutput(JTextField name, JTextField lastname, JTextField phone, JTextField bornDate,
			JLabel sTitle, JLabel sName, JLabel sLastname, JLabel sPhone, JLabel sBD, JLabel oName,
			JLabel oLastname, JLabel oPhone, JLabel oBD) {
		sTitle.setVisible(true);
		sName.setVisible(true);
		sLastname.setVisible(true);
		sPhone.setVisible(true);
		sBD.setVisible(true);
		oName.setVisible(true);
		oName.setText(name.getText().trim());
		oLastname.setVisible(true);
		oLastname.setText(lastname.getText().trim());
		oPhone.setVisible(true);
		oPhone.setText(phone.getText().trim());
		oBD.setVisible(true);
		oBD.setText(bornDate.getText().trim());
	}

	public static Boolean hasError() {
		return error;
	}

	public static void setError(Boolean error) {
		ContactController.error = error;
	}
}
