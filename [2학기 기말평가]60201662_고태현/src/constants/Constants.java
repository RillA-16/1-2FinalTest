package constants;

public class Constants {
	
	public enum EMainClock{
		title("MJU ������û ���α׷� : �ð�");
		
		private String text;
		private EMainClock(String text) {
			this.text = text;
		}
		
		public String getText() {
			return this.text;
		}
		
		public int getInt(){
			return Integer.parseInt(text);
		}
	}
	
	public enum EConfigurations{
		miridamgiFilePostfix("M"),
		sincheongFilePostfix("S");

		private String text;
		private EConfigurations(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	public enum EPResultPanel{
		gangjwaNo("���¹�ȣ"),
		gangjwaName("���¸�"),
		credit("�� ��");

		private String text;
		private EPResultPanel(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
		
	}
	
	public enum EPGangjwaSelectionPanel{
		gangjwaNo("���¹�ȣ"),
		gangjwaName("���¸�"),
		damdangGyosu("��米��"),
		hakjeom("����"),
		time("�ð�");
		

		private String text;
		private EPGangjwaSelectionPanel(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
		
	}
	
	public enum EPHakgwaSelectionPanel{
		rootFileName("root"),
		campus("ķ�۽�"),
		college("����"),
		hakgwa("�а�");
		
		private String text;
		private EPHakgwaSelectionPanel(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
		
	}
	
	public enum ELoginDialog {
		width("600"),
		height("400"),
		nameLabel("ID"),
		sizeNameText("20"),
		passwordLabel("��й�ȣ"),
		sizePasswordText("20"),
		okButtonLabel("�α���"),
		cancelButtonLabel("�� ��"),
		registerButtonLabel("ȸ������"),
		idFnButtonLable("���̵� ã��"),
		pwFnButtonLable("��й�ȣ ã��"),
		lginFailed("���̵�� �н����尡 Ʋ��"),
		lginFailed1("�α׾� ������ ��ġ���� �ʽ��ϴ�"),
		lginFailed2("������ �������� �ʽ��ϴ�."),
		lginFailed3("��ĭ�� �ֽ��ϴ�!"),
		lginSuccess("�� ȯ���մϴ�!"),
		error("��й�ȣ�� 3ȸ Ʋ���̽��ϴ�."),
		title("������ ������û ���α׷� : Login");
		
		private String text;
		private ELoginDialog(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum ERegister {
		width("500"),
		height("700"),
		idLabel("ID : "),
		idConfrimButtonLabel("ID �ߺ�Ȯ��"),
		sizeNameText("20"),
		passwordLabel("PW :"),
		sizePasswordText("20"),
		passwordConfirmLabel("PW Ȯ�� : "),
		nameLabel("NAME :"),
		stNumLabel("�й� :"),
		emailLabel("E-mail :"),
		telLabel("��ȭ��ȣ :"),
		birthLabel("������� :"),
		seoulRadio("���� ķ�۽�"),
		yonginRadio("���� ķ�۽�"),
		informationCheck("�������� ���� ����"),
		telMessage("* - �� �����մϴ�"),
		birthMessage("Ex) 20010216"),
		okButtonLabel("�α���"),
		backButtonLabel("�ڷ� ����"),
		registerButtonLabel("ȸ������"),
		idConfirmAble("ID ����� ���� �մϴ�"),
		idConfirmUnable("ID ����� �Ұ��� �մϴ�"),
		lginFailed("���̵�� �н����尡 Ʋ��"),
		registerError("ȸ������ ������ ��ĭ�� �ֽ��ϴ�."),
		registerPwCheck("pw�� pwȮ�ΰ� ��ġ���� �ʽ��ϴ�"),
		regitserDuplication("���̵� �ߺ�Ȯ���� �����ּ���"),
		registerSuccess("ȸ������ �Ϸ�Ǿ����ϴ�!"),
		registerCheckBox("�������� ���� �ڽ��� üũ �� �ּ���"),
		registerIdEnglish("�ƾƵ�� ����� ���ڷ� �Է����ּ���!"),
		title("������ ������û ���α׷� : Register");
		
		private String text;
		private ERegister(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum EIdFind {
		width("450"),
		height("300"),
		idLabel("�̸� : "),
		sizeNameText("20"),
		stnumLabel("�й� : "),
		sizestnumText("20"),
		title("MJU ������û : IdFind"),
		backButtonLabel("�ڷ� ����"),
		idFnButtonLable("���̵� ã��"),
		lginFailed("���̵�� �н����尡 Ʋ��");
		
		private String text;
		private EIdFind(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum EPwFind {
		width("450"),
		height("300"),
		idLabel("ID : "),
		sizeNameText("20"),
		stnumLabel("�й� : "),
		sizestnumText("20"),
		title("MJU ������û : PwFind"),
		backButtonLabel("�ڷ� ����"),
		idFnButtonLable("��й�ȣ ã��"),
		lginFailed("���̵�� �н����尡 Ʋ��");
		
		private String text;
		private EPwFind(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}

	public enum EMainFrame{
		width("1000"),
		height("600");
		
		private String text;
		private EMainFrame(String text) {
			this.text = text;
		}
		
		public String getText() {
			return this.text;
		}
		
		public int getInt(){
			return Integer.parseInt(text);
		}
		
	}
	
	public enum EMenuBar {
		eFile("����");
		
		
		String text;
		EMenuBar(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EFileMenu {
		eLogiout("�α� �ƿ�"),
		ePersonalInfo("���� ����");

		String text;
		EFileMenu(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	//���������� �ٲ� ��
	public enum EEditMenu {
		eCopy("����"),
		eCut("�߶󳻱�"),
		ePaste("���̱�"),
		eDelete("����");
		
		String text;
		EEditMenu(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EMenuPersonalInfo {
		width("400"),
		height("600"),
		idLabel("���̵� : "),
		sizeidText("20"),
		passwordLabel("��й�ȣ : "),
		sizePasswordText("20"),
		campusLabel("�Ҽ� ķ�۽� : "),
		nameLabel("�̸� : "),
		stNumeLabel("�й� : "),
		emailLabel("e-mail : "),
		pwConfirmBtnLabel("��й�ȣ Ȯ��"),
		pwChangeBtnLabel("��й�ȣ ����"),
		cancelButtonLabel("�ڷ� ����"),
		lginFailed("��ĭ�� �ֽ��ϴ�!"),
		lginSuccess("��й�ȣ�� �����Ǿ����ϴ�!"),
		title("������ ������û ���α׷� : PesonalInfo");
		
		private String text;
		private EMenuPersonalInfo(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum EPlan {
		width("900"),
		height("600"),
		campusLabel("ķ�۽�"),
		professorLabel("������"),
		creditLabel("�� ��"),
		nameLabel("���Ǹ�"),
		sizeNameText("20"),
		title("MJU ������û : ���� ��ȹ��"),
		backButtonLabel("�ڷ� ����"),
		resetButtonLable("���� ��ȹ��"),
		searchButtonLable("�� ��"),
		lginFailed("���̵�� �н����尡 Ʋ��");
		
		private String text;
		private EPlan(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
	}
	
	public enum EplanTable{
		gangjwaNo("���¹�ȣ"),
		gangjwaName("���¸�"),
		credit("�� ��");

		private String text;
		private EplanTable(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
		
	}
	
}
