package dto;

public class CoffeeMemberDto {
	private String id;
	private String pwd;
	private String name;
	private String email;	//나이가 아니라 이메일로 처리함.
	
	public CoffeeMemberDto() {
		
	}

	public CoffeeMemberDto(String id, String pwd, String name, String email) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
	}

	@Override
	public String toString() {
		return "CoffeeMemberDto [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
