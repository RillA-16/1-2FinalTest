package mainFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PFailure extends JFrame {

	public void PFailure() {

		setTitle("�α��� ����");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("2_1.gif");
		setIconImage(img);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		setContentPane(panel);
		panel.setLayout(null);

		setContentPane(panel);
		panel.setLayout(null);
		setVisible(true);
		setSize(655, 454);
		setLocationRelativeTo(null);
		setResizable(false);

		try {
			JLabel label = new JLabel("3���� ���α׷��� ����˴ϴ�.");
			label.setFont(new Font("����", Font.PLAIN, 25));
			label.setBounds(119, 138, 359, 128);
			panel.add(label);

			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		dispose();

	}
}
