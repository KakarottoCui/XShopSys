package com.platform.api;

import com.platform.annotation.IgnoreAuth;
import com.platform.entity.SysSmsLogEntity;
import com.platform.service.SysSmsLogService;
import com.platform.utils.R;
import com.platform.utils.RRException;
import com.platform.utils.RequestUtil;
import com.platform.utils.ResourceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 发送短信接口Controller
 *

 

 * @date 202018-06-05 13:58:47
 */
@RestController
@RequestMapping("api")
public class ApiSmsController {
    @Autowired
    private SysSmsLogService smsLogService;

    /**
     * 发送短信
     *
     * @param request request
     * @param params
     * @return R
     */
    @IgnoreAuth
    @RequestMapping("/sendSms")
    public R sendSms(HttpServletRequest request, @RequestParam Map<String, String> params) {
        SysSmsLogEntity smsLog = new SysSmsLogEntity();
        String validIP = RequestUtil.getIpAddrByRequest(request);
        if (ResourceUtil.getConfigByName("sms.validIp").indexOf(validIP) < 0) {
            throw new RRException("非法IP请求！");
        }
        smsLog.setMobile(params.get("mobile"));

        //todo 模板ID：实际使用需要修改
        smsLog.setTemplateId(23);
        smsLog.setCode(params.get("code"));
        SysSmsLogEntity sysSmsLogEntity = smsLogService.sendSms(smsLog);
        return R.ok().put("result", sysSmsLogEntity);
    }
}
