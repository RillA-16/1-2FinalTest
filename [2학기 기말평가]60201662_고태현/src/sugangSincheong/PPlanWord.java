package sugangSincheong;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.Constants.ERegister;
import control.CPlanWord;
import valueObject.VPlanWord;

public class PPlanWord extends JFrame {

	public PPlanWord(VPlanWord vPlanWord) {
		CPlanWord cPlanWord = new CPlanWord();
		VPlanWord vPlanWord1 = cPlanWord.planRead(vPlanWord);
		
		System.out.println(vPlanWord1.getCode() + "�ўp");

		this.setSize(920, 770);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("������ ������û : ���ǰ�ȹ��");

		JPanel line = new JPanel();

		line.setBackground(Color.white);
		this.setContentPane(line);
		this.setLayout(null);

		JLabel planLa = new JLabel("<���� ��ȹ��>");
		planLa.setFont(new Font("����", Font.BOLD, 22));
		planLa.setBounds(30, 21, 158, 44);
		line.add(planLa);

		JLabel nameLa = new JLabel("���Ǹ� : "+vPlanWord1.getName());
		nameLa.setFont(new Font("����", Font.PLAIN, 15));
		nameLa.setBounds(27, 75, 360, 25);
		line.add(nameLa);

		JLabel codeLa = new JLabel("�����ڵ� : "+vPlanWord1.getCode());
		codeLa.setFont(new Font("����", Font.PLAIN, 15));
		codeLa.setBounds(12, 97, 360, 30);
		line.add(codeLa);

		JLabel mathLa = new JLabel("�ο��� : "+vPlanWord1.getPersonnel());
		mathLa.setFont(new Font("����", Font.PLAIN, 15));
		mathLa.setBounds(27, 122, 282, 25);
		line.add(mathLa);

		JLabel timeLa = new JLabel("�ð� : "+vPlanWord1.getTime());
		timeLa.setFont(new Font("����", Font.PLAIN, 15));
		timeLa.setBounds(38, 148, 395, 25);
		line.add(timeLa);

		JLabel creditLa = new JLabel("�� �� : "+vPlanWord1.getGrades());
		creditLa.setFont(new Font("����", Font.PLAIN, 15));
		creditLa.setBounds(508, 68, 251, 25);
		line.add(creditLa);

		JLabel professorLa = new JLabel("���� : " +vPlanWord1.getProfessor());
		professorLa.setFont(new Font("����", Font.PLAIN, 15));
		professorLa.setBounds(508, 97, 306, 25);
		line.add(professorLa);

		JLabel emailLa = new JLabel("�̸��� : "+vPlanWord1.getEmail());
		emailLa.setFont(new Font("����", Font.PLAIN, 15));
		emailLa.setBounds(496, 124, 317, 20);
		line.add(emailLa);

		JLabel bookLa = new JLabel("���� �� ������ :"+vPlanWord1.getBook());
		bookLa.setFont(new Font("����", Font.PLAIN, 15));
		bookLa.setBounds(0, 173, 880, 25);
		line.add(bookLa);

		JLabel goalLa = new JLabel("�� ǥ :"+vPlanWord1.getGoal());
		goalLa.setFont(new Font("����", Font.PLAIN, 15));
		goalLa.setBounds(30, 195, 862, 25);
		line.add(goalLa);

		JLabel weekWordLa = new JLabel("<���� ��ȹ>");
		weekWordLa.setFont(new Font("����", Font.BOLD, 22));
		weekWordLa.setBounds(30, 230, 139, 36);
		line.add(weekWordLa);

		JLabel firstweekLa = new JLabel("1���� : "+vPlanWord1.getWeek1());
		firstweekLa.setFont(new Font("����", Font.PLAIN, 13));
		firstweekLa.setBounds(27, 275, 853, 15);
		line.add(firstweekLa);

		JLabel secondLa = new JLabel("2���� : "+vPlanWord1.getWeek2());
		secondLa.setFont(new Font("����", Font.PLAIN, 13));
		secondLa.setBounds(27, 297, 850, 15);
		line.add(secondLa);

		JLabel sam = new JLabel("3���� : "+vPlanWord1.getWeek3());
		sam.setFont(new Font("����", Font.PLAIN, 13));
		sam.setBounds(27, 319, 850, 15);
		line.add(sam);

		JLabel sa = new JLabel("4���� : "+vPlanWord1.getWeek4());
		sa.setFont(new Font("����", Font.PLAIN, 13));
		sa.setBounds(27, 341, 850, 15);
		line.add(sa);

		JLabel oh = new JLabel("5���� : "+vPlanWord1.getWeek5());
		oh.setFont(new Font("����", Font.PLAIN, 13));
		oh.setBounds(27, 363, 850, 15);
		line.add(oh);

		JLabel wook = new JLabel("6���� : "+vPlanWord1.getWeek6());
		wook.setFont(new Font("����", Font.PLAIN, 13));
		wook.setBounds(27, 385, 850, 15);
		line.add(wook);

		JLabel cheel = new JLabel("7���� : "+vPlanWord1.getWeek7());
		cheel.setFont(new Font("����", Font.PLAIN, 13));
		cheel.setBounds(27, 407, 850, 15);
		line.add(cheel);

		JLabel pal = new JLabel("8���� : "+vPlanWord1.getWeek8());
		pal.setFont(new Font("����", Font.PLAIN, 13));
		pal.setBounds(27, 429, 850, 15);
		line.add(pal);

		JLabel goo = new JLabel("9���� : "+vPlanWord1.getWeek9());
		goo.setFont(new Font("����", Font.PLAIN, 13));
		goo.setBounds(27, 451, 850, 15);
		line.add(goo);

		JLabel ship = new JLabel("10���� : "+vPlanWord1.getWeek10());
		ship.setFont(new Font("����", Font.PLAIN, 13));
		ship.setBounds(27, 473, 850, 15);
		line.add(ship);

		JLabel shipill = new JLabel("11���� : "+vPlanWord1.getWeek11());
		shipill.setFont(new Font("����", Font.PLAIN, 13));
		shipill.setBounds(27, 495, 850, 15);
		line.add(shipill);

		JLabel shipee = new JLabel("12���� : "+vPlanWord1.getWeek12());
		shipee.setFont(new Font("����", Font.PLAIN, 13));
		shipee.setBounds(27, 517, 850, 15);
		line.add(shipee);

		JLabel shipsam = new JLabel("13���� : "+vPlanWord1.getWeek13());
		shipsam.setFont(new Font("����", Font.PLAIN, 13));
		shipsam.setBounds(27, 539, 850, 15);
		line.add(shipsam);

		JLabel shipsa = new JLabel("14���� : "+vPlanWord1.getWeek14());
		shipsa.setFont(new Font("����", Font.PLAIN, 13));
		shipsa.setBounds(27, 561, 850, 15);
		line.add(shipsa);

		JLabel shipoh = new JLabel("15���� : "+vPlanWord1.getWeek15());
		shipoh.setFont(new Font("����", Font.PLAIN, 13));
		shipoh.setBounds(27, 583, 850, 15);
		line.add(shipoh);

		JLabel shipwook = new JLabel("16���� : "+vPlanWord1.getWeek16());
		shipwook.setFont(new Font("����", Font.PLAIN, 13));
		shipwook.setBounds(27, 605, 850, 15);
		line.add(shipwook);
	}
}
