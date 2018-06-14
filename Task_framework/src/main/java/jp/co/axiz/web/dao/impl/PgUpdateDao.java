package jp.co.axiz.web.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.axiz.web.dao.UpdateDao;
import jp.co.axiz.web.entity.Update;

@Repository
public class PgUpdateDao implements UpdateDao {

	@Autowired
	private JdbcTemplate jt;

	public List<Update> findAll(){
		return jt.query(" UPDATE user_info SET user_name = ?, telephone = ?, password = ? WHERE user_id = ?;",
				new BeanPropertyRowMapper<Update>(Update.class));
	}

}
