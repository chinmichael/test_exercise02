package dbpackage;

public class MemberVO {
	
	String id;
	String pw;
	String name;
	String level;
	String gender;
	String phone;
	
	public MemberVO() {
		
	}
	
	public MemberVO(String id, String pw, String name, String level, String gender, String phone) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.level = level;
		this.gender = gender;
		this.phone = phone;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
