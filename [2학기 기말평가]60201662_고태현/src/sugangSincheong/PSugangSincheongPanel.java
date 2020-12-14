package sugangSincheong;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import constants.Constants.ELoginDialog;
import control.CCredit;
import valueObject.VUserInfo;

public class PSugangSincheongPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private PHeaderPanel pHeaderPanel;
	private PContentPanel pContentPanel;
	private PFooterPanel pFooterPanel;
	private CCredit cCredit;
	private VUserInfo vUserInfo;

	public PSugangSincheongPanel() {
		this.setLayout(new BorderLayout());

		this.pHeaderPanel = new PHeaderPanel();
		this.add(this.pHeaderPanel, BorderLayout.NORTH);

		this.pContentPanel = new PContentPanel();
		this.add(this.pContentPanel, BorderLayout.CENTER);

		this.pFooterPanel = new PFooterPanel(new ActionHandler());
		this.add(this.pFooterPanel, BorderLayout.SOUTH);
	}

	public void initialize(VUserInfo vUserInfo) {
		this.vUserInfo = vUserInfo;
		this.pHeaderPanel.intialize(vUserInfo);
		this.pContentPanel.intialize(vUserInfo);
		this.pFooterPanel.intialize();
	}

	// �����ư
	private void save(Object source) {
		boolean yes = pFooterPanel.save(source);
		if (yes == true) {
			JOptionPane.showMessageDialog(this, "���ǰ� ������ ����Ǿ����ϴ�!");
			finish();
		}
	}

	private void chincheongCredit(Object source) {
		boolean yes = pFooterPanel.chincheongCredit(source);
		if (yes == true) {
			this.cCredit = new CCredit();
			int sum = cCredit.read(vUserInfo.getId() + "S");
			JOptionPane.showMessageDialog(this, "�̸���� ��ϵ� ������ " + sum + " �Դϴ�!");
		}
	}

	private void miridamgiCredit(Object source) {
		boolean yes = pFooterPanel.miridamgiCredit(source);
		if (yes == true) {
			this.cCredit = new CCredit();
			int sum = cCredit.read(vUserInfo.getId() + "M");
			JOptionPane.showMessageDialog(this, "�̸���� ��ϵ� ������ " + sum + " �Դϴ�!");
		}
	}

	private void capture(Object source) {
		boolean yes = pFooterPanel.captureBtn(source);
		if (yes == true) {
			try {
				
				Robot robot = new Robot();
				Rectangle rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
				BufferedImage image = robot.createScreenCapture(rectangle);

//				BufferedImage screencapture = new Robot().createScreenCapture(new Rectangle(550, 300, 1000, 600));
				File file = new File("ScreenCapture//ScreenCapture" + " " + vUserInfo.getId() + " " + ".jpg");

				try {
					JOptionPane.showMessageDialog(null, "���� ����Ʈ�� ĸó�߽��ϴ�", "ȭ�� ĸ��", JOptionPane.INFORMATION_MESSAGE);
					ImageIO.write(image, "jpg", file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			} catch (HeadlessException e1) {
				e1.printStackTrace();
			} catch (AWTException e1) {
				e1.printStackTrace();
			}

		}
	}

	public class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			save(event.getSource());
			chincheongCredit(event.getSource());
			miridamgiCredit(event.getSource());
			capture(event.getSource());
		}
	}

	public void finish() {
		this.pContentPanel.finish1();
	}
}
