package vo;

public class Member {
	//회원정보를 담기 위한 모델
	
	private String id;  
	private String pass; 
	private String name;
	
	
	public Member(){
		
	}
	
	public Member(String id, String pass) {
		super();
		this.id = id;
		this.pass = pass;
	}
	
	public Member(String id, String pass, String name) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
