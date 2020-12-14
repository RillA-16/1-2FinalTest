package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import valueObject.VCredit;
import valueObject.VFind;
import valueObject.VGangjwa;
import valueObject.VLecture;
import valueObject.VLogin;
import valueObject.VPlan;
import valueObject.VPlanWord;
import valueObject.VRegister;
import valueObject.VUserInfo;

public class DataBase {

	// ȸ�� ����
	public void registerPersonalinfo(VRegister vRegister) {

		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = " INSERT INTO USERINFO VALUES(?,?,?,?,?,?,?,?,?) ";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection dcConn = DriverManager.getConnection(url, "KOTAE", "1234");
			PreparedStatement statement = dcConn.prepareStatement(sql);

			statement.setString(1, vRegister.getId());
			statement.setString(2, vRegister.getPw());
			statement.setString(3, vRegister.getName());
			statement.setString(4, vRegister.getStNum());
			statement.setString(5, vRegister.getEmail());
			statement.setString(6, vRegister.getTel());
			statement.setString(7, vRegister.getBirth());
			statement.setString(8, vRegister.getSeoulBtn());
			statement.setString(9, vRegister.getYonginBtn());

			statement.executeUpdate();

			dcConn.close();
			statement.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ȸ������ ID �ߺ�Ȯ��
	public int joinCheck(VRegister vRegister) {

		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "SELECT * FROM USERINFO WHERE ID = ?";

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection dcConn = DriverManager.getConnection(url, "KOTAE", "1234");
			PreparedStatement statement = dcConn.prepareStatement(sql);

			ResultSet rs = null;

			statement.setString(1, vRegister.getConfirmId());

			rs = statement.executeQuery();

			// �ߺ��� ���̵� ������ 1�� ��ȯ
			if (rs.next()) {
				return 1;
			} else { // ���̵� ������ 0 ��ȯ
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ���� �߻� �� -1 ��ȯ
		return -1;
	}

	// �α���
	public VUserInfo login(VLogin vLogin) {

		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "SELECT * FROM USERINFO WHERE ID=?";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection dcConn = DriverManager.getConnection(url, "KOTAE", "1234");
			PreparedStatement statement = dcConn.prepareStatement(sql);
			ResultSet rs;

			statement.setString(1, vLogin.getUserId());
			rs = statement.executeQuery();
		

			if (rs.next()) {
				if (vLogin.getUserId().equals(rs.getString("ID"))) { /* ���� ģ �н������ ���̺� �н����� �� �� ������ */

					VUserInfo vUserInfo = new VUserInfo();
					vUserInfo.setId(rs.getString("ID"));
					vUserInfo.setPw(rs.getString("PW"));
					vUserInfo.setName(rs.getString("NAME"));
					vUserInfo.setStNum(rs.getString("STNUM"));
					vUserInfo.setEmail(rs.getString("EMAIL"));
					vUserInfo.setTel(rs.getString("TEL"));
					vUserInfo.setBirth(rs.getString("BIRTH"));
					vUserInfo.setSeoulBtn(rs.getString("SEOULCAMPUS"));
					vUserInfo.setYonginBtn(rs.getString("YONGINCAMPUS"));

					System.out.println(rs.getString("BIRTH") + "����?");
					statement.executeUpdate();

					return vUserInfo;
				}
			}
			rs.close();
			dcConn.close();
			statement.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int login1(VLogin vLogin) {
		int result = 3;
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "SELECT * FROM USERINFO WHERE ID= ?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection dcConn = DriverManager.getConnection(url, "KOTAE", "1234");
			PreparedStatement st = dcConn.prepareStatement(sql);

			st.setString(1, vLogin.getUserId());

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				if (vLogin.getPassword().equals(rs.getString("PW"))) {
					// �α��� ����
					result = 1;
				} else {
					// ���̵� ��ġ & ��й�ȣ ����ġ
					result = 2;
				}
			} else {
				// ���̵� ����ġ
				result = 3;
			}
			dcConn.close();
			st.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// ������ ���̺� �����
	public void create(String fileName) {
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		try {

			String sql = "CREATE TABLE " + fileName

					+ "(" + "id NUMBER(5)," + "name NVARCHAR2(2000)," + "LECTURER NVARCHAR2(2000),"
					+ "credit NVARCHAR2(2000)," + "TIME NVARCHAR2(2000)" + ")";

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "KOTAE", "1234");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			rs.close();
			st.close();
			con.close();

		} catch (Exception e) {

		}
	}

	// �̸���� ����
	public void Save(String fileName, Vector<VGangjwa> vGangjwas) {

		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "DELETE FROM " + fileName;
	

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection dcConn = DriverManager.getConnection(url, "KOTAE", "1234");
			Statement statement = dcConn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			for (VGangjwa vGangjwa : vGangjwas) {

				String id = vGangjwa.getId();
				String name = vGangjwa.getName();
				String lecturer = vGangjwa.getLecturer();
				String credit = vGangjwa.getCredit();
				String time = vGangjwa.getTime();

				String sql1 = "SELECT * FROM " + fileName;
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection dcConn1 = DriverManager.getConnection(url, "KOTAE", "1234");
				Statement statement1 = dcConn1.createStatement();
				ResultSet rs1 = statement.executeQuery(sql1);

				statement.executeUpdate("INSERT INTO " + fileName + "(id, name, LECTURER, credit, TIME) VALUES (" + "'"
						+ id + "'" + "," + "'" + name + "'" + "," + "'" + lecturer + "'" + "," + "'" + credit + "'"
						+ "," + "'" + time + "'" + ")");
			}

			dcConn.close();
			statement.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// �̸���� ������û DB �ҷ�����
	public Vector<VGangjwa> read(String fileName) {
		Vector<VGangjwa> VGangjwas = new Vector<VGangjwa>();

		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "SELECT * FROM " + fileName;

		try {

			VGangjwa vGangjwa;

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection dcConn = DriverManager.getConnection(url, "KOTAE", "1234");
			Statement statement = dcConn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {

				vGangjwa = new VGangjwa();

				vGangjwa.setId(rs.getString("ID"));
				vGangjwa.setName(rs.getString("NAME"));
				vGangjwa.setLecturer(rs.getString("LECTURER"));
				vGangjwa.setCredit(rs.getString("CREDIT"));
				vGangjwa.setTime(rs.getString("TIME"));
				VGangjwas.add(vGangjwa);

			}
			rs.close();
			dcConn.close();
			statement.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return VGangjwas;
	}

	// ��й�ȣ ����!
	public void change(String chagePw, VUserInfo vUserInfo) {

		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "UPDATE USERINFO SET PW='" + chagePw + "' WHERE PW='" + vUserInfo.getPw() + "'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection dcConn = DriverManager.getConnection(url, "KOTAE", "1234");
			PreparedStatement statement = dcConn.prepareStatement(sql);

			statement.executeUpdate();

			dcConn.close();
			statement.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ���� ��ȹ�� ������
	public Vector<VPlan> planRead(String campus, String name, String professor, String credit) {
		Vector<VPlan> vPlans = new Vector<VPlan>();

		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "SELECT * FROM lecture WHERE name = '" + name + "' OR professor = '" + professor
				+ "' OR grades = '" + credit + "'";

		VPlan vPlan;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection dcConn = DriverManager.getConnection(url, "KOTAE", "1234");
			Statement statement = dcConn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {

				vPlan = new VPlan();

				System.out.println(rs.getString("CODE") + "����������");
				vPlan.setCode(rs.getString("CODE"));
				vPlan.setName(rs.getString("NAME"));
				vPlan.setLocation(rs.getString("LOCATION"));
				vPlan.setPersonnel(rs.getString("PERSONNEL"));
				vPlan.setGrades(rs.getString("GRADES"));
				vPlan.setProfessor(rs.getString("PROFESSOR"));
				vPlan.setTime(rs.getString("TIME"));
				vPlan.setCampus(rs.getString("CAMPUS"));
				vPlan.setCollege(rs.getString("COLLEAGE"));
				vPlan.setDepartment(rs.getString("DEPARTMENT"));
				vPlans.add(vPlan);

			}
			rs.close();
			dcConn.close();
			statement.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vPlans;
	}

	// ���� ��ȹ��
	public VPlanWord planWordRead(VPlanWord vPlanWord) {
		String i = vPlanWord.getCode();

		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "SELECT * FROM LECTURE, LECTUREDETAIL, WEEKLYPROGRESS WHERE LECTURE.CODE = LECTUREDETAIL.CODE AND WEEKLYPROGRESS.CODE = LECTUREDETAIL.CODE AND  LECTURE.CODE = LECTUREDETAIL.CODE";

		VPlanWord vPlanWord1 = new VPlanWord();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection dcConn = DriverManager.getConnection(url, "KOTAE", "1234");
			Statement statement = dcConn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {

				if (i.equals(rs.getString("CODE"))) {

					vPlanWord1.setCode(rs.getString("CODE"));
					vPlanWord1.setName(rs.getString("NAME"));
					vPlanWord1.setLocation(rs.getString("LOCATION"));
					vPlanWord1.setPersonnel(rs.getString("PERSONNEL"));
					vPlanWord1.setGrades(rs.getString("GRADES"));
					vPlanWord1.setProfessor(rs.getString("PROFESSOR"));
					vPlanWord1.setTime(rs.getString("TIME"));
					vPlanWord1.setCampus(rs.getString("CAMPUS"));
					vPlanWord1.setCollege(rs.getString("COLLEAGE"));
					vPlanWord1.setDepartment(rs.getString("DEPARTMENT"));
					vPlanWord1.setEmail((rs.getString("EMAIL")));
					vPlanWord1.setGoal((rs.getString("GOAL")));
					vPlanWord1.setGreadeevaluation((rs.getString("GRADEEVALUATION")));
					vPlanWord1.setBook((rs.getString("BOOK")));
					vPlanWord1.setWeek1((rs.getString("WEEK1")));
					vPlanWord1.setWeek2((rs.getString("WEEK2")));
					vPlanWord1.setWeek3((rs.getString("WEEK3")));
					vPlanWord1.setWeek4((rs.getString("WEEK4")));
					vPlanWord1.setWeek5((rs.getString("WEEK5")));
					vPlanWord1.setWeek6((rs.getString("WEEK6")));
					vPlanWord1.setWeek7((rs.getString("WEEK7")));
					vPlanWord1.setWeek8((rs.getString("WEEK8")));
					vPlanWord1.setWeek9((rs.getString("WEEK9")));
					vPlanWord1.setWeek10((rs.getString("WEEK10")));
					vPlanWord1.setWeek11((rs.getString("WEEK11")));
					vPlanWord1.setWeek12((rs.getString("WEEK12")));
					vPlanWord1.setWeek13((rs.getString("WEEK13")));
					vPlanWord1.setWeek14((rs.getString("WEEK14")));
					vPlanWord1.setWeek15((rs.getString("WEEK15")));
					vPlanWord1.setWeek16((rs.getString("WEEK16")));

				}
			}
			rs.close();
			dcConn.close();
			statement.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vPlanWord1;
	}

	// id ã��
	public VFind idFind(String name, String stnum) {

		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "SELECT * FROM USERINFO WHERE STNUM LIKE" + "'" + stnum + "'";


		VFind vFind = new VFind();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection dcConn = DriverManager.getConnection(url, "KOTAE", "1234");
			Statement statement = dcConn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {

				if (name.equals(rs.getString("NAME")) && stnum.equals(rs.getString("STNUM"))) {
					vFind.setId(rs.getString("ID"));
				}
			}
			rs.close();
			dcConn.close();
			statement.close();
			return vFind;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// ��й�ȣ ã��
	public VFind pwFind(String id, String stnum) {

		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "SELECT * FROM USERINFO WHERE STNUM LIKE" + "'" + stnum + "'";

		VFind vFind = new VFind();

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection dcConn = DriverManager.getConnection(url, "KOTAE", "1234");
			Statement statement = dcConn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {

				if (id.equals(rs.getString("ID")) && stnum.equals(rs.getString("STNUM")))
					vFind.setPw(rs.getString("PW"));

			}
			rs.close();
			dcConn.close();
			statement.close();
			return vFind;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Vector<VCredit> Creditread(String fileName) {
		Vector<VCredit> vCredites = new Vector<VCredit>();

		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "SELECT * FROM " + fileName;

		try {

			VCredit vCredit = new VCredit();
			;

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection dcConn = DriverManager.getConnection(url, "KOTAE", "1234");
			Statement statement = dcConn.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {

				vCredit.setCredit(rs.getString("CREDIT"));

				vCredites.add(vCredit);
			}

			rs.close();
			dcConn.close();
			statement.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vCredites;
	}
}
