package cn.app.service.dataDictionary;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.app.dao.datadictionary.DataDictionaryMapper;
import cn.app.pojo.DataDictionary;

/**
 * 数据字典服务接口的实现类
 * @author Administrator
 *
 */
@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {
 
	@Resource
	private DataDictionaryMapper dataDictionary;
	
	@Override
	public ArrayList<DataDictionary> getDataDictionaryByTypeCode(String typeCode) {
		// TODO Auto-generated method stub
		return dataDictionary.getDataDictionaryByTypeCode(typeCode);
	}

}
