package mainFrame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import constants.Constants.EMainClock;
import constants.Constants.ERegister;
import control.CFind;
import valueObject.VFind;
import valueObject.VFind1;
import valueObject.VRegister;
import valueObject.VUser;
import valueObject.VUserInfo;

public class Main extends JFrame implements Runnable {

	private PLoginDialog pLoginDialog;
	private PMainFrame pMainFrame = new PMainFrame();
	private PRegister pRegister;
	private PIdFind pIdFind;
	private PPwFind pPwFind;

	private Thread thread;
	private JLabel label;

	public Main() {
		this.pLoginDialog = new PLoginDialog(new ActionHandler());
		this.pLoginDialog.initialize();

		this.pRegister = new PRegister(new ActionHandler());

		this.pIdFind = new PIdFind(new ActionHandler());
		this.pPwFind = new PPwFind(new ActionHandler());

		setTitle(EMainClock.title.getText());
		setLayout(new FlowLayout());
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		label = new JLabel();
		label.setFont(new Font("Daum", Font.PLAIN, 20));
		if (thread == null) {

			thread = new Thread(this);
			thread.start();
		}
		add(label);
		setBounds(790, 10, 400, 80);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void intialize() {

	}

	// ���̾�α� �α��� ��ư
	private void validateUser(Object source) {
		VUserInfo vUserInfo = this.pLoginDialog.validateUser1(source);

		if (vUserInfo != null) {
//			PMainFrame pMainFrame = new PMainFrame();
			this.pMainFrame.initialize(vUserInfo);
			this.pLoginDialog.dispose();
		}
	}

	// ���̾�α� ȸ������ ��ư
	private void Register(Object source) {
		boolean check = this.pLoginDialog.regiActionBtn(source);
		if (check == true) {
			this.pRegister.initialize();
		}
	}

	// ���̾�α� ���̵� ã�� ��ư
	private void idFind(Object source) {
		boolean check = this.pLoginDialog.idFindActionBtn(source);
		if (check == true) {
			this.pIdFind.initialize();
		}
	}

	// ���̾�α� ��й�ȣ ã�� ��ư
	private void pwFind(Object source) {
		boolean check = this.pLoginDialog.pwFindActionBtn(source);
		if (check == true) {
			this.pPwFind.initialize();
		}
	}

	// ȸ������ ȸ������ ��ư
	private void Register1(Object source) {
		boolean hehe = this.pRegister.register(source);
		if (hehe == true) {
			this.pRegister.dispose();
			this.pLoginDialog.setVisible(true);
		}
	}

	// ȸ������ ���̵� �ߺ�Ȯ�� ��ư
	private void idConfirm(Object source) {
		this.pRegister.idConfirm(source);
	}

	// ȸ������ �ڷΰ��� ��ư
	private void regiback(Object source) {
		boolean yes = pRegister.back(source);
		if (yes == true) {
			this.pRegister.dispose();
			this.pLoginDialog.setVisible(true);
		}
	}

	// ���̵� ã�� �ڷΰ��� ��ư
	private void idFindback(Object source) {
		boolean yes = pIdFind.back(source);
		if (yes == true) {
			this.pIdFind.dispose();
			this.pLoginDialog.setVisible(true);
		}
	}

	// ���̵� ã�� ã��!
	private void idFind1(Object source) {
		VFind1 vFind1 = new VFind1();
		vFind1 = pIdFind.idFind(source);

		if (vFind1 != null) {
			CFind cFind = new CFind();
			VFind vFind = cFind.idFind(vFind1.getName(), vFind1.getStnum());
			if (vFind.getId() == null) {
				JOptionPane.showMessageDialog(null, "ȸ�������� �����ϴ�");
			} else {
				JOptionPane.showMessageDialog(null, "���̵�� " + vFind.getId() + " �Դϴ�!");
			}
		}
	}

	// ��й�ȣ ã�� �ڷΰ��� ��ư
	private void pwFindback(Object source) {
		boolean yes = pPwFind.back(source);
		if (yes == true) {
			this.pPwFind.dispose();
			this.pLoginDialog.setVisible(true);
		}
	}

	// ��й�ȣ ã�� ã��!
	private void pwFind1(Object source) {
		VFind1 vFind1 = new VFind1();
		vFind1 = pPwFind.pwFind(source);
		if (vFind1 != null) {
			CFind cFind = new CFind();
			VFind vFind = cFind.pwFind(vFind1.getId(), vFind1.getStnum());
			if (vFind.getPw() == null) {
				JOptionPane.showMessageDialog(null, "ȸ�������� �����ϴ�");
			} else {
				JOptionPane.showMessageDialog(null, "��й�ȣ�� " + vFind.getPw() + " �Դϴ�!");
			}
		}
	}

	public class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// ���̾�α� �α��� ��ư
			validateUser(event.getSource());
			// ���̾�α� ȸ������ ��ư
			Register(event.getSource());
			// ���̾�α� ���̵� ã�� ��ư
			idFind(event.getSource());
			// ���̾�α� ��й�ȣ ã�� ��ư
			pwFind(event.getSource());

			///////////////////////////////////////////////
			// ȸ������ ȸ������ ��ư
			Register1(event.getSource());
			// ȸ������ �ڷΰ��� ��ư
			regiback(event.getSource());
			// ȸ������ ID �ߺ�Ȯ�� ��ư
			idConfirm(event.getSource());

			////////////////////////////////////////////////
			// ���̵� ã�� �ڷΰ��� ��ư
			idFindback(event.getSource());
			// ���̵� ã�� ã��!
			idFind1(event.getSource());

			/////////////////////////////////////////////////
			// ��й�ȣ ã�� �ڷΰ��� ��ư
			pwFindback(event.getSource());
			// ��й�ȣ ã�� ã��!
			pwFind1(event.getSource());
		}
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.intialize();
	}

	public void PCanlender() {
		run();
	}

	public void run() {
		while (true) {
			Calendar cal = Calendar.getInstance();
			String now = cal.get(Calendar.YEAR) + "�� " + (cal.get(Calendar.MONTH) + 1) + "�� " + cal.get(Calendar.DATE)
					+ "�� " + cal.get(Calendar.HOUR) + "�� " + cal.get(Calendar.MINUTE) + "�� " + cal.get(Calendar.SECOND)
					+ "��";
			label.setText(now);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
