package mainFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import control.CChange;
import valueObject.VUserInfo;

public class PChangePw extends JFrame {

	public PChangePw(VUserInfo vUserInfo) {

		this.setTitle("��й�ȣ ����");
		this.setSize(400, 200); // �� ó�� â ũ��
		setLocationRelativeTo(null); // â ����� �� ��� ����
		setResizable(false);// â ũ�� ����

		JPanel panelpwconfirm = new JPanel();
		panelpwconfirm.setBackground(Color.white);
		setContentPane(panelpwconfirm);
		panelpwconfirm.setLayout(null);

		JLabel labeltext = new JLabel("��й�ȣ�� �Է����ּ���");
		JLabel labelpw = new JLabel("��й�ȣ : ");
		JPasswordField textpw = new JPasswordField(10);

		panelpwconfirm.add(labeltext);
		labeltext.setBounds(77, 15, 151, 24);

		panelpwconfirm.add(labelpw);
		labelpw.setBounds(74, 47, 60, 24);

		panelpwconfirm.add(textpw);
		textpw.setBounds(135, 49, 132, 24);

		JButton confirmBtn = new JButton("Ȯ ��");
		panelpwconfirm.add(confirmBtn);
		confirmBtn.setBounds(177, 93, 97, 23);

		// ���� ���ľߵ�!!
		confirmBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String changePw;
				changePw = textpw.getText();
				CChange cChange = new CChange();
				cChange.change(changePw, vUserInfo);
				dispose();
				
			}
		});
	}
}
