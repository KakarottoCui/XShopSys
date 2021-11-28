package com.platform.dao;

import com.platform.entity.TokenEntity;
import org.apache.ibatis.annotations.Param;

/**
 * 用户Token
 *
 
 

 * @date 2020-03-23 15:22:07
 */
public interface ApiTokenMapper extends BaseDao<TokenEntity> {

    TokenEntity queryByUserId(@Param("userId") Long userId);

    TokenEntity queryByToken(@Param("token") String token);

}
