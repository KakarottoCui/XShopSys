package com.platform.service;

import com.platform.entity.GoodsAttributeEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 

 
 * @date 2020-08-13 10:41:08
 */
public interface GoodsAttributeService {
	
	GoodsAttributeEntity queryObject(Integer id);
	
	List<GoodsAttributeEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(GoodsAttributeEntity goodsAttribute);
	
	void update(GoodsAttributeEntity goodsAttribute);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
