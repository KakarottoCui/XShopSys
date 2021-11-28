package com.platform.service.impl;

import com.platform.annotation.RedisCache;
import com.platform.cache.J2CacheUtils;
import com.platform.dao.SysMacroDao;
import com.platform.entity.SysMacroEntity;
import com.platform.service.SysMacroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通用字典表Service实现类
 *


 * @date 2020-08-22 11:48:16
 */
@Service("sysMacroService")
public class SysMacroServiceImpl implements SysMacroService {
    @Autowired
    private SysMacroDao sysMacroDao;

    @Override
    public SysMacroEntity queryObject(Long macroId) {
        return sysMacroDao.queryObject(macroId);
    }

    @Override
    @RedisCache
    public List<SysMacroEntity> queryList(Map<String, Object> map) {
        return sysMacroDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return sysMacroDao.queryTotal(map);
    }

    @Override
    public int save(SysMacroEntity sysMacro) {
        sysMacro.setGmtCreate(new Date());
        sysMacroDao.save(sysMacro);
        J2CacheUtils.delByClass(this.getClass().getName(),"queryList");
        return 1;
    }

    @Override
    public int update(SysMacroEntity sysMacro) {
        sysMacro.setGmtModified(new Date());
        sysMacroDao.update(sysMacro);
        J2CacheUtils.delByClass(this.getClass().getName(),"queryList");
        return 1;
    }

    @Override
    public int delete(Long macroId) {
        sysMacroDao.delete(macroId);
        J2CacheUtils.delByClass(this.getClass().getName(),"queryList");
        return 1;
    }

    @Override
    public int deleteBatch(Long[] macroIds) {
        sysMacroDao.deleteBatch(macroIds);
        J2CacheUtils.delByClass(this.getClass().getName(),"queryList");
        return 1;
    }

    @Override
    public List<SysMacroEntity> queryMacrosByValue(String value) {
        return sysMacroDao.queryMacrosByValue(value);
    }

    @Override
    public List<SysMacroEntity> queryAllParent(Map<String, Object> map) {
        map.put("type", 0);
        return sysMacroDao.queryList(map);
    }
}
