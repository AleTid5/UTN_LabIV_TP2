package Ejercicio2.App.Views;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Ejercicio2.App.Controllers.ContactController;
import Ejercicio2.App.Elements.Image;
import Ejercicio2.App.Elements.WindowBack;

@SuppressWarnings("serial")
public class Contacts extends WindowBack {
	private JTextField txtName;
	private JTextField txtLastName;
	private JTextField txtPhone;
	private JTextField txtBornDate;
	private JLabel lblStaticTitle;
	private JLabel lblStaticName;
	private JLabel lblStaticLastname;
	private JLabel lblStaticPhone;
	private JLabel lblStaticBornDate;
	private JLabel lblOutName;
	private JLabel lblOutLastname;
	private JLabel lblOutPhone;
	private JLabel lblOutBornDate;
	public Contacts() {
		this.setHeader("Contactos");
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(47, 163, 66, 15);
		getContentPane().add(lblNombre);
		
		txtName = new JTextField();
		txtName.setBounds(131, 161, 181, 19);
		txtName.setColumns(10);
		getContentPane().add(txtName);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(330, 163, 66, 15);
		getContentPane().add(lblApellido);
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(414, 161, 181, 19);
		getContentPane().add(txtLastName);
		
		JLabel lblTelfono = new JLabel("Teléfono");
		lblTelfono.setBounds(47, 223, 66, 15);
		getContentPane().add(lblTelfono);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(131, 221, 181, 19);
		getContentPane().add(txtPhone);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fec. Nac.");
		lblFechaDeNacimiento.setBounds(330, 223, 88, 15);
		getContentPane().add(lblFechaDeNacimiento);
		
		txtBornDate = new JTextField();
		txtBornDate.setColumns(10);
		txtBornDate.setBounds(413, 219, 181, 19);
		getContentPane().add(txtBornDate);
		
		JButton btnCheck = new JButton("");
		Image imageCheck = new Image("check.png", 310, 537, 50, 50);
		btnCheck.setBackground(imageCheck.getBackground());
		btnCheck.setToolTipText("Validar Formulario");
		btnCheck.setIcon(imageCheck.getIcon());
		btnCheck.addActionListener(this.validateForm());
		btnCheck.setBounds(new Rectangle(570, 261, 25, 25));
		btnCheck.setBorder(null);
		getContentPane().add(btnCheck);
		setVisible(true);
		
		JButton btnClean = new JButton("");
		Image imageTrash = new Image("trash.png", 310, 537, 50, 50);
		btnClean.setBackground(imageTrash.getBackground());
		btnClean.setToolTipText("Limpiar Formulario");
		btnClean.setIcon(imageTrash.getIcon());
		btnClean.addActionListener(this.cleanForm());
		btnClean.setBounds(new Rectangle(47, 261, 25, 25));
		btnClean.setBorder(null);
		getContentPane().add(btnClean);
		
		lblStaticTitle = new JLabel("Los datos ingresados fueron:");
		lblStaticTitle.setVisible(false);
		lblStaticTitle.setBounds(47, 316, 205, 15);
		getContentPane().add(lblStaticTitle);
		
		lblStaticName = new JLabel("Nombre: ");
		lblStaticName.setVisible(false);
		lblStaticName.setBounds(47, 343, 205, 15);
		getContentPane().add(lblStaticName);
		
		lblStaticLastname = new JLabel("Apellido: ");
		lblStaticLastname.setVisible(false);
		lblStaticLastname.setBounds(47, 370, 205, 15);
		getContentPane().add(lblStaticLastname);
		
		lblStaticPhone = new JLabel("Teléfono: ");
		lblStaticPhone.setVisible(false);
		lblStaticPhone.setBounds(47, 397, 205, 15);
		getContentPane().add(lblStaticPhone);
		
		lblStaticBornDate = new JLabel("Fecha de nacimiento: ");
		lblStaticBornDate.setVisible(false);
		lblStaticBornDate.setBounds(47, 424, 205, 15);
		getContentPane().add(lblStaticBornDate);
		
		lblOutName = new JLabel("");
		lblOutName.setVisible(false);
		lblOutName.setBounds(264, 343, 205, 15);
		getContentPane().add(lblOutName);
		
		lblOutLastname = new JLabel("");
		lblOutLastname.setVisible(false);
		lblOutLastname.setBounds(264, 370, 205, 15);
		getContentPane().add(lblOutLastname);
		
		lblOutPhone = new JLabel("");
		lblOutPhone.setVisible(false);
		lblOutPhone.setBounds(264, 397, 205, 15);
		getContentPane().add(lblOutPhone);
		
		lblOutBornDate = new JLabel("");
		lblOutBornDate.setVisible(false);
		lblOutBornDate.setBounds(264, 424, 205, 15);
		getContentPane().add(lblOutBornDate);
		setVisible(true);
	}
	
	private ActionListener validateForm() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContactController.setError(false);
				ContactController.validate(txtName, "[a-zA-Z]+");
				ContactController.validate(txtLastName, "[a-zA-Z]+");
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
	
	private ActionListener cleanForm() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContactController.cleanForm(
						txtName, txtLastName, txtPhone, txtBornDate, lblStaticTitle,
						lblStaticName, lblStaticLastname, lblStaticPhone, lblStaticBornDate,
						lblOutName, lblOutLastname, lblOutPhone, lblOutBornDate);
			}
		};
	}
}
