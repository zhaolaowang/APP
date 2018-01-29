package cn.app.dao.datadictionary;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import cn.app.pojo.DataDictionary;

/**
 * 数据字典的持久化层
 * 
 * @author Administrator
 */
public interface DataDictionaryMapper {

	/**
	 * 根据类型编码进行查找类型的对象
	 * 
	 * @param typeCode
	 * @return
	 */
	ArrayList<DataDictionary> getDataDictionaryByTypeCode(
			@Param("typeCode") String typeCode);
}
