package com.platform.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.platform.entity.SysOssEntity;

import java.util.List;
import java.util.Map;

/**
 * 文件上传Dao
 *
 


 * @date 2020-03-25 12:13:26
 */
public interface SysOssDao extends BaseMapper<SysOssEntity> {

    /**
     * 自定义分页查询
     *
     * @param page
     * @param params
     * @return
     */
    List<SysOssEntity> selectSysOssPage(IPage page, Map<String, Object> params);
}
