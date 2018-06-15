package jp.co.axiz.web.dao;

import jp.co.axiz.web.entity.Login;

public interface LoginDao {

	//public List<Login> findAll();

	public Login findByIdPass(String id,String pass);
}
