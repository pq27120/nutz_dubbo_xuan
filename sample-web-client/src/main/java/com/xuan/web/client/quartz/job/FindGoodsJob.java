package com.xuan.web.client.quartz.job;

import com.sunivo.nutzdubbo.utils.ServiceFactory;
import com.xuan.smzdm.services.IFindGoodsServices;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * Created by bj on 2016/5/4.
 */
@IocBean
public class FindGoodsJob implements Job{
    private static final Log log = Logs.get();

    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.debug("FindGoodsJob , start" + new Date());
        IFindGoodsServices findGoodsService = ServiceFactory.getService(
                IFindGoodsServices.class, "1.0.0");
        log.debug(findGoodsService.findGodPricesGoods());
//        System.out.println("FindGoodsJob");
    }
}
