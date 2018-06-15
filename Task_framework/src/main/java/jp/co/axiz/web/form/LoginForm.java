package jp.co.axiz.web.form;

import org.hibernate.validator.constraints.NotBlank;

public class LoginForm {

	@NotBlank
	private String loginId;

	@NotBlank
	private String password;

	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String _loginId) {
		this.loginId = _loginId;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String _password) {
		this.password = _password;
	}
}
