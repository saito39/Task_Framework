package jp.co.axiz.web.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import jp.co.axiz.web.dao.UserInfoDao;
import jp.co.axiz.web.entity.UserInfo;

@Repository
public class PgUserInfoDao implements UserInfoDao {

	@Autowired
	private NamedParameterJdbcTemplate jt;

	/*public List<Update> findAll(){
		return jt.query(" UPDATE user_info SET user_name = ?, telephone = ?, password = ? WHERE user_id = ?;",
				new BeanPropertyRowMapper<Update>(Update.class));
	}*/

	@Override
	public List<UserInfo> findAll() {
		String sql = "SELECT * FROM user_info ORDER BY user_id";

		List<UserInfo> resultList = jt.query(sql, new BeanPropertyRowMapper<UserInfo>(UserInfo.class));

		return resultList;
	}

	@Override
	public List<UserInfo> findByConditions(UserInfo userInfo) {

		List<String> condition = new ArrayList<String>();
		MapSqlParameterSource param = new MapSqlParameterSource();

		Integer userId = userInfo.getUserId();
		String userName = userInfo.getUserName();
		String telephone = userInfo.getTelephone();

		if(userId != null) {
			condition.add("user_id = :userId");
			param.addValue("userId", userId);
		}

		if(userName != null && !userName.isEmpty()) {
			condition.add("user_name = :userName");
			param.addValue("userName", userName);

		}

		if(telephone != null && !telephone.isEmpty()) {
			condition.add("telephone = :telephone");
			param.addValue("telephone", telephone);

		}

		String whereString = String.join(" AND ", condition.toArray(new String[]{}));

		String sql = "SELECT * FROM user_info WHERE " + whereString + " ORDER BY user_id";

		List<UserInfo> resultList = jt.query(sql, param, new BeanPropertyRowMapper<UserInfo>(UserInfo.class));

		return resultList;
	}

	@Override
	public UserInfo findById(Integer id) {

		String sql = "SELECT * FROM user_info WHERE user_id = :userId";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", id);

		List<UserInfo> resultList = jt.query(sql, param, new BeanPropertyRowMapper<UserInfo>(UserInfo.class));

		return resultList.isEmpty() ? null : resultList.get(0);
	}

	@Override
	public int register(UserInfo user) {
		String sql = "INSERT INTO user_info (user_name, telephone, password) VALUES (:userName, :telephone, :password)";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userName", user.getUserName());
		param.addValue("telephone", user.getTelephone());
		param.addValue("password", user.getPassword());

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jt.update(sql, param, keyHolder, new String[] {"user_id"});

		return keyHolder.getKey().intValue();
	}

	@Override
	public void update(UserInfo user) {
		String sql = "UPDATE user_info SET user_name = :userName, telephone = :telephone, password = :password WHERE user_id = :userId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userName", user.getUserName());
		param.addValue("telephone", user.getTelephone());
		param.addValue("password", user.getPassword());
		param.addValue("userId", user.getUserId());

		jt.update(sql, param);
	}

	@Override
	public void delete(Integer id) {

		String sql = "DELETE FROM user_info WHERE user_id = :userId";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", id);

		jt.update(sql, param);
	}
}



