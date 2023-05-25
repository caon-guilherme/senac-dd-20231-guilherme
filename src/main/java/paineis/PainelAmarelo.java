package paineis;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PainelAmarelo extends JPanel {

	/**
	 * Create the panel.
	 */
	public PainelAmarelo() {
		setBackground(new Color(255, 255, 0));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bem-vindo!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(30, 144, 373, 67);
		add(lblNewLabel);

	}
}
