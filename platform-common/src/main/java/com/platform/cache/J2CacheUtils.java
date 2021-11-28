package com.platform.cache;

import com.platform.utils.Constant;
import com.platform.utils.StringUtils;
import net.oschina.j2cache.CacheChannel;
import net.oschina.j2cache.J2Cache;

import java.util.Collection;

/**
 * 作者: @author dabo <br>
 * 时间: 2017-07-09 17:12<br>
 * 描述: J2CacheUtils <br>
 */
public class J2CacheUtils {
    /**
     * 商城业务缓存
     */
    public static String SHOP_CACHE_NAME = "shopCache";
    /**
     * 系统缓存
     */
    private static String SYS_CACHE_NAME = "sysCache";

    private static CacheChannel cache = J2Cache.getChannel();

    /**
     * 获取SYS_CACHE_NAME缓存
     *
     * @param key
     * @return
     */
    public static Object get(String key) {
        return get(SYS_CACHE_NAME, key);
    }

    /**
     * 写入SYS_CACHE_NAME缓存
     *
     * @param key
     * @return
     */
    public static void put(String key, Object value) {
        put(SYS_CACHE_NAME, key, value);
    }

    /**
     * 从SYS_CACHE_NAME缓存中移除
     *
     * @param key
     * @return
     */
    public static void remove(String key) {
        remove(SYS_CACHE_NAME, key);
    }

    /**
     * 获取缓存
     *
     * @param cacheName
     * @param key
     * @return
     */
    public static Object get(String cacheName, String key) {
        return cache.get(cacheName, key).getValue();
    }

    /**
     * 写入缓存
     *
     * @param cacheName
     * @param key
     * @param value
     */
    public static void put(String cacheName, String key, Object value) {
        cache.set(cacheName, key, value);
    }

    /**
     * 从缓存中移除
     *
     * @param cacheName
     * @param key
     */
    public static void remove(String cacheName, String key) {
        cache.evict(cacheName, key);
    }

    /**
     * 获取SYS_CACHE缓存的所有key
     *
     * @return
     */
    public static Collection<String> keys() {
        return cache.keys(SYS_CACHE_NAME);
    }
    /**
     * 获取缓存的所有key
     *
     * @param cacheName
     * @return
     */
    public static Collection<String> keys(String cacheName) {
        return cache.keys(cacheName);
    }

    /**
     * Clear the cache
     *
     * @param cacheName: Cache region name
     */
    public static void clear(String cacheName) {
        cache.clear(cacheName);
    }

    /**
     * 判断某个缓存键是否存在
     *
     * @param region Cache region name
     * @param key    cache key
     * @return true if key exists
     */
    public static boolean exists(String region, String key) {
        return check(region, key) > 0;
    }

    /**
     * 判断某个缓存键是否存在
     *
     * @param key    cache key
     * @return true if key exists
     */
    public static boolean exists(String key) {
        return check(SYS_CACHE_NAME, key) > 0;
    }

    /**
     * 判断某个key存在于哪级的缓存中
     *
     * @param region cache region
     * @param key    cache key
     * @return 0(不存在), 1(一级), 2(二级)
     */
    public static int check(String region, String key) {
        return cache.check(region, key);
    }

    /**
     * 删除缓存
     *
     * @param className  类名
     * @param methodName 方法名
     */
    public static void delByClass(String className, String methodName) {
        String key = StringUtils.genKey(Constant.SYS_CACHE, className, methodName);

        remove(key);
    }
}
