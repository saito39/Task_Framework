package jp.co.axiz.web.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.axiz.web.dao.LoginDao;
import jp.co.axiz.web.entity.Login;

@Repository
public class PgLoginDao implements LoginDao {

	@Autowired
	private NamedParameterJdbcTemplate jt;

	/*public List<Login> findAll() {
		return jt.query("SELECT admin_id, admin_name, password FROM admin WHERE admin_id = ? AND password = ?",
				new BeanPropertyRowMapper<Login>(Login.class));
	}
*/
	@Override
	public Login findByIdPass(String id, String password) {
		String sql = "SELECT * FROM admin WHERE admin_id = :adminId AND password = :password";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("adminId", id);
		param.addValue("password", password);

		List<Login> resultList = jt.query(sql, param, new BeanPropertyRowMapper<Login>(Login.class));

		return resultList.isEmpty() ? null : resultList.get(0);
	}
}
