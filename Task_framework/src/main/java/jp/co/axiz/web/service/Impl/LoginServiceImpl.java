package jp.co.axiz.web.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.axiz.web.dao.LoginDao;
import jp.co.axiz.web.service.LoginService;

@Service
@Transactional
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDao lgDao;
}
