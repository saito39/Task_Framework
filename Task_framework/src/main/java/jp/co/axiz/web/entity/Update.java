package jp.co.axiz.web.entity;

public class Update {

	private String id;
	private String name;
	private String telephone;
	private String password;

	@Override
	public String toString() {
	return "User [id=" + id+ ", name=" + name+ ", tel=" + telephone + ", password=" + password + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
