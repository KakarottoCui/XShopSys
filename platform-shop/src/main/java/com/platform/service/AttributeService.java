package com.platform.service;

import com.platform.entity.AttributeEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 

 * @date 2020-08-13 10:41:11
 */
public interface AttributeService {
	
	AttributeEntity queryObject(Integer id);
	
	List<AttributeEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AttributeEntity attribute);
	
	void update(AttributeEntity attribute);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
