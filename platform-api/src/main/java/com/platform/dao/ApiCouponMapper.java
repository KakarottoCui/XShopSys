package com.platform.dao;

import com.platform.entity.CouponVo;

import java.util.List;
import java.util.Map;

/**


 
 * @date 2020-08-11 09:16:46
 */
public interface ApiCouponMapper extends BaseDao<CouponVo> {
    /**
     * 按条件查询用户优惠券
     *
     * @param params
     * @return
     */
    List<CouponVo> queryUserCoupons(Map<String, Object> params);

    /**
     * 按条件查询用户优惠券
     *
     * @param params
     * @return
     */
    CouponVo getUserCoupon(Integer id);

    /**
     * 按类型查询
     *
     * @param params
     * @return
     */
    CouponVo queryMaxUserEnableCoupon(Map<String, Object> params);

    /**
     * sendType = 1或4 的优惠券
     *
     * @param params
     * @return
     */
    List<CouponVo> queryUserCouponList(Map<String, Object> params);

    int updateUserCoupon(CouponVo couponVo);
}
