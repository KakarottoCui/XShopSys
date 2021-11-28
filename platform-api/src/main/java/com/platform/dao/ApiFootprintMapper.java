package com.platform.dao;

import com.platform.entity.FootprintVo;

import java.util.List;
import java.util.Map;

/**


 
 * @date 2020-08-11 09:14:26
 */
public interface ApiFootprintMapper extends BaseDao<FootprintVo> {
    int deleteByParam(Map<String, Object> map);

    List<FootprintVo> shareList(Map<String, Object> map);

	List<FootprintVo> queryListFootprint(String userid);
}
