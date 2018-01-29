package cn.app.service.backendadmin;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.app.dao.backendadmin.BackendMapper;
import cn.app.pojo.BackendUser;

@Service
public class BackendServiceImpl implements BackendService {

	@Resource
	private BackendMapper backendMapper;

	@Override
	public BackendUser getBackendUserByPassWord(String userCode, String passWord) {
		return backendMapper.getBackendUserByPassWord(userCode, passWord);
	}

}
