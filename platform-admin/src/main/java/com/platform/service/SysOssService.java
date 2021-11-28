package com.platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.entity.SysOssEntity;
import com.platform.utils.PageUtilsPlus;

import java.util.Map;

/**
 * 文件上传Service
 *
 
 

 * @date 2020-03-25 12:13:26
 */
public interface SysOssService extends IService<SysOssEntity> {

    /**
     * queryPage
     *
     * @param params
     * @return
     */
    PageUtilsPlus queryPage(Map<String, Object> params);
}
