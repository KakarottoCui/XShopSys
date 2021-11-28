package com.platform.dao;

import com.platform.entity.GoodsAttributeEntity;

/**
 
 
 * @date 2020-08-13 10:41:08
 */
public interface GoodsAttributeDao extends BaseDao<GoodsAttributeEntity> {

    int updateByGoodsIdAttributeId(GoodsAttributeEntity goodsAttributeEntity);
}
