package jp.co.axiz.web.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.axiz.web.dao.LoginDao;
import jp.co.axiz.web.entity.Login;
import jp.co.axiz.web.service.LoginService;

@Service
@Transactional
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDao lgDao;

	@Override
    public Login authentication(String id, String password) {
    	return lgDao.findByIdPass(id, password);
    }
}
