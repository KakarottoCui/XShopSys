package com.platform.validator;

import com.platform.utils.RRException;
import org.apache.commons.lang.StringUtils;

/**
 * 数据校验
 *
 

 * @date 2020-03-23 15:50
 */
public abstract class Assert {

    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new RRException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new RRException(message);
        }
    }
}
