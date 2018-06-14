package jp.co.axiz.web.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.axiz.web.dao.DeleteDao;
import jp.co.axiz.web.entity.Delete;

@Repository
public class PgDeleteDao implements DeleteDao{

	@Autowired
	private JdbcTemplate jt;

	public List<Delete> findAll() {
		return jt.query("DELETE FROM user_info WHERE user_id = ?",
				new BeanPropertyRowMapper<Delete>(Delete.class));
	}

}
