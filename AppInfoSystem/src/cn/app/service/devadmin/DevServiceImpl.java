package cn.app.service.devadmin;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.app.dao.devadmin.DevMapper;
import cn.app.pojo.DevUser;

@Service
public class DevServiceImpl implements DevService {

	@Resource
	private DevMapper devMapper;

	@Override
	public DevUser findDevUserByPassWord(String userCode, String passWord) {
		return devMapper.getDevUserByPassWord(userCode, passWord);
	}

}
