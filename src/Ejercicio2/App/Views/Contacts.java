package Ejercicio2.App.Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Ejercicio2.App.Controllers.ContactController;
import Ejercicio2.App.Elements.Button;
import Ejercicio2.App.Elements.Image;
import Ejercicio2.App.Elements.Label;
import Ejercicio2.App.Elements.TextField;
import Ejercicio2.App.Elements.WindowBack;
import Ejercicio2.App.Interfaces.IForm;

@SuppressWarnings("serial")
public class Contacts extends WindowBack implements IForm {
	private TextField txtName;
	private TextField txtLastName;
	private TextField txtPhone;
	private TextField txtBornDate;
	private Label lblStaticTitle;
	private Label lblStaticName;
	private Label lblStaticLastname;
	private Label lblStaticPhone;
	private Label lblStaticBornDate;
	private Label lblOutName;
	private Label lblOutLastname;
	private Label lblOutPhone;
	private Label lblOutBornDate;
	public Contacts() {
		this.setHeader("Contactos");
		
		Label lblNombre = new Label(47, 163, 66, 15, "Nombre");
		txtName = new TextField(131, 161, 181, 19);
		Label lblApellido = new Label(330, 163, 66, 15, "Apellido");
		txtLastName = new TextField(414, 161, 181, 19);
		Label lblTelfono = new Label(47, 223, 66, 15, "Teléfono");
		txtPhone = new TextField(131, 221, 181, 19);
		Label lblFechaDeNacimiento = new Label(330, 223, 88, 15, "Fec. Nac.");
		txtBornDate = new TextField(413, 219, 181, 19, "AAAA/MM/DD");
		Button btnCheck = new Button(570, 261, 24, 24, "Validar Formulario", new Image("check.png", 310, 537, 50, 50), this.submit());
		Button btnClean = new Button(47, 261, 24, 24, "Limpiar Formulario", new Image("trash.png", 310, 537, 50, 50), this.clean());
		lblStaticTitle = new Label(47, 316, 205, 15, "Los datos ingresados fueron:", false);
		lblStaticName = new Label(47, 343, 205, 15, "Nombre: ", false);
		lblStaticLastname = new Label(47, 370, 205, 15, "Apellido: ", false);
		lblStaticPhone = new Label(47, 397, 205, 15, "Teléfono: ", false);
		lblStaticBornDate = new Label(47, 424, 205, 15, "Fecha de nacimiento: ", false);
		lblOutName = new Label(264, 343, 205, 15, "", false);
		lblOutLastname = new Label(264, 370, 205, 15, "", false);
		lblOutPhone = new Label(264, 397, 205, 15, "", false);
		lblOutBornDate = new Label(264, 424, 205, 15, "", false);
		

		getContentPane().add(lblNombre);
		getContentPane().add(txtName);
		getContentPane().add(lblApellido);
		getContentPane().add(txtLastName);
		getContentPane().add(lblTelfono);
		getContentPane().add(txtPhone);
		getContentPane().add(lblFechaDeNacimiento);
		getContentPane().add(txtBornDate);
		getContentPane().add(btnCheck);
		getContentPane().add(btnClean);
		getContentPane().add(lblStaticTitle);
		getContentPane().add(lblStaticName);
		getContentPane().add(lblStaticLastname);
		getContentPane().add(lblStaticPhone);
		getContentPane().add(lblStaticBornDate);
		getContentPane().add(lblOutName);
		getContentPane().add(lblOutLastname);
		getContentPane().add(lblOutPhone);
		getContentPane().add(lblOutBornDate);
		
		this.setVisible(true);
	}

	@Override
	public ActionListener submit() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContactController.setError(false);
				ContactController.validate(txtName, "^([a-zA-Z]+\\s)*[a-zA-Z]+$");
				ContactController.validate(txtLastName, "^([a-zA-Z]+\\s)*[a-zA-Z]+$");
				ContactController.validate(txtPhone, "[0-9]+");
				ContactController.validate(txtBornDate, "((19|20)[0-9]{2})/((0?[1-9])|1[012])/((0?[1-9])|(1[0-9])|(3[01]))");
				
				if (! ContactController.hasError())
					ContactController.fillOutput(
							txtName, txtLastName, txtPhone, txtBornDate, lblStaticTitle,
							lblStaticName, lblStaticLastname, lblStaticPhone, lblStaticBornDate,
							lblOutName, lblOutLastname, lblOutPhone, lblOutBornDate);
			}
		};
	}

	@Override
	public ActionListener clean() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContactController.clean(
						txtName, txtLastName, txtPhone, txtBornDate, lblStaticTitle,
						lblStaticName, lblStaticLastname, lblStaticPhone, lblStaticBornDate,
						lblOutName, lblOutLastname, lblOutPhone, lblOutBornDate);
			}
		};
	}
}
