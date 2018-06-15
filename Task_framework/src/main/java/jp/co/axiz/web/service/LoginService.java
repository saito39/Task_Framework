package jp.co.axiz.web.service;

import jp.co.axiz.web.entity.Login;

public interface  LoginService {

	public Login authentication(String id, String password);
}
