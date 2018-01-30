package cn.app.service.dataDictionary;

import java.util.ArrayList;


import cn.app.pojo.DataDictionary;

/**
 * 数据字典服务接口
 * 
 * @author Administrator
 * 
 */
public interface DataDictionaryService {
	/**
	 * 根据类型编码进行查找类型的对象
	 * 
	 * @param typeCode
	 * @return
	 */
	ArrayList<DataDictionary> getDataDictionaryByTypeCode(String typeCode);
}
