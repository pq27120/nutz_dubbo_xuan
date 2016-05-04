package com.xuan.web.client.module;

import com.sunivo.nutzdubbo.utils.ServiceFactory;
import com.xuan.smzdm.services.IFindGoodsServices;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Ok;
import org.quartz.Scheduler;

/**
 * Created by bj on 2016/5/3.
 */
@At("/user")
@Ok("json")
@Fail("http:500")
public class UserModule {
    @At
    public void count() {
        IFindGoodsServices findGoodsService = ServiceFactory.getService(
                IFindGoodsServices.class, "1.0.0");
        System.out.println(findGoodsService.findGodPricesGoods());
    }
}
