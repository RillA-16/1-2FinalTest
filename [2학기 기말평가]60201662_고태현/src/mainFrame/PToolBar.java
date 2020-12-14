package mainFrame;

import javax.swing.JButton;
import javax.swing.JToolBar;

import mainFrame.PMainFrame.ActionHandler;
import valueObject.VUserInfo;

public class PToolBar extends JToolBar {
	private static final long serialVersionUID = 1L;
	
	private JButton sugangBtn;
	private JButton planBtn;
//	private JButton credit;
	private JButton friend;
	private VUserInfo vUserInfo;

	public PToolBar(ActionHandler actionHandler) {
		this.sugangBtn = new JButton("������û");
		this.sugangBtn.addActionListener(actionHandler);
		this.add(this.sugangBtn);
		
		this.planBtn = new JButton("���� ��ȹ��");
		this.planBtn.addActionListener(actionHandler);
		this.add(this.planBtn);

//		this.credit = new JButton("�� ��");
//		this.credit.addActionListener(actionHandler);
//		this.add(this.credit);

		this.friend = new JButton("ģ ��");
		this.friend.addActionListener(actionHandler);
		this.add(this.friend);
	}

	public void initialize(VUserInfo vUserInfo) {
		this.vUserInfo = vUserInfo;
	}

	// ���� ��ȹ�� ����
	public boolean actionPlan(Object eventSource) {
		boolean yes = false;
		if (eventSource.equals(this.planBtn)) {
			yes = true;
		}
		return yes;
	}
	

}
