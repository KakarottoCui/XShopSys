package com.platform.service;

import com.platform.entity.SearchHistoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 
 
 * @date 2020-08-13 10:41:10
 */
public interface SearchHistoryService {
	
	SearchHistoryEntity queryObject(Integer id);
	
	List<SearchHistoryEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SearchHistoryEntity searchHistory);
	
	void update(SearchHistoryEntity searchHistory);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
