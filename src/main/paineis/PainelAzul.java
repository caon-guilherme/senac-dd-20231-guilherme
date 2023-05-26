package main.paineis;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PainelAzul extends JPanel {

	/**
	 * Create the panel.
	 */
	public PainelAzul() {
		setBackground(new Color(0, 0, 255));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Painel Azul");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(30, 144, 373, 67);
		add(lblNewLabel);

	}
}
