package Ejercicio2.App.Elements;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Image extends JLabel {
	public static final String baseDir = "/Ejercicio2/App/Assets/";
	
	public Image(String resource, int x, int y, int w, int h) {
		this.setIcon(new ImageIcon(Image.class.getResource(Image.baseDir + resource)));
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setBounds(x, y, w, h);
		this.setBackground(new Color(225, 193, 119));
	}
}
