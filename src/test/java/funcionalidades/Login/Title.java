package funcionalidades.Login;

public enum Title {
	
	MR("Mr"),
	MRS("Mrs");
	
	private String value;
	
	private Title(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}