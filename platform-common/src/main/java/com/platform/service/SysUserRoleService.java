package com.platform.service;

import java.util.List;


/**
 * 用户与角色对应关系
 *


 * @date 2020年9月18日 上午9:43:24
 */
public interface SysUserRoleService {

    void saveOrUpdate(Long userId, List<Long> roleIdList);

    /**
     * 根据用户ID，获取角色ID列表
     */
    List<Long> queryRoleIdList(Long userId);

    void delete(Long userId);
}
