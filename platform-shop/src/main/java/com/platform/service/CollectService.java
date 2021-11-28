package com.platform.service;

import com.platform.entity.CollectEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 

 * @date 2020-08-13 10:41:06
 */
public interface CollectService {
	
	CollectEntity queryObject(Integer id);
	
	List<CollectEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CollectEntity collect);
	
	void update(CollectEntity collect);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
