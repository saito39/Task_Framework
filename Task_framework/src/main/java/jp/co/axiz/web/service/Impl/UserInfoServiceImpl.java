package jp.co.axiz.web.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.axiz.web.dao.UserInfoDao;
import jp.co.axiz.web.entity.UserInfo;
import jp.co.axiz.web.service.UserInfoService;

@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDao uiDao;

	@Override
	public List<UserInfo> find(UserInfo userInfo) {

		if (userInfo.isConditionsEmpty()) {
			return uiDao.findAll();
		} else {
			return uiDao.findByConditions(userInfo);
		}
	}

	@Override
	public UserInfo findById(Integer id) {
		return uiDao.findById(id);
	}

	@Override
	public int insert(UserInfo userInfo) {
		return uiDao.register(userInfo);
	}

	@Override
	public void update(UserInfo userInfo) {
		uiDao.update(userInfo);
	}

	@Override
	public void delete(Integer id) {
		uiDao.delete(id);
	}
}
