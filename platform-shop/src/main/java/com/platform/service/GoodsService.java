package com.platform.service;

import com.platform.entity.GoodsEntity;

import java.util.List;
import java.util.Map;

/**
 * Service接口
 *


 * @date 2020-08-21 21:19:49
 */
public interface GoodsService {

    /**
     * 根据主键查询实体
     *
     * @param id 主键
     * @return 实体
     */
    GoodsEntity queryObject(Integer id);

    /**
     * 分页查询
     *
     * @param map 参数
     * @return list
     */
    List<GoodsEntity> queryList(Map<String, Object> map);

    /**
     * 分页统计总数
     *
     * @param map 参数
     * @return 总数
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存实体
     *
     * @param goods 实体
     * @return 保存条数
     */
    int save(GoodsEntity goods);

    /**
     * 根据主键更新实体
     *
     * @param goods 实体
     * @return 更新条数
     */
    int update(GoodsEntity goods);

    /**
     * 根据主键删除
     *
     * @param id
     * @return 删除条数
     */
    int delete(Integer id);

    /**
     * 根据主键批量删除
     *
     * @param ids
     * @return 删除条数
     */
    int deleteBatch(Integer[] ids);

    /**
     * 商品从回收站恢复
     *
     * @param ids
     * @return
     */
    int back(Integer[] ids);

    /**
     * 上架
     *
     * @param id
     * @return
     */
    int enSale(Integer id);

    /**
     * 下架
     *
     * @param id
     * @return
     */
    int unSale(Integer id);
}
