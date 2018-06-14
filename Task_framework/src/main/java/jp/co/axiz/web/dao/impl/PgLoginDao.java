package jp.co.axiz.web.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.axiz.web.dao.LoginDao;
import jp.co.axiz.web.entity.Login;

@Repository
public class PgLoginDao implements LoginDao {

	@Autowired
	private JdbcTemplate jt;

	public List<Login> findAll() {
		return jt.query("SELECT admin_id, admin_name, password FROM admin WHERE admin_id = ? AND password = ?",
				new BeanPropertyRowMapper<Login>(Login.class));
	}

}
