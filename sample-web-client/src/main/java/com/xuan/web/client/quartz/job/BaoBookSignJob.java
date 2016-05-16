package com.xuan.web.client.quartz.job;

import com.sunivo.nutzdubbo.utils.ServiceFactory;
import com.xuan.smzdm.services.IBaoBookService;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * Created by bj on 2016/5/16.
 */
@IocBean
public class BaoBookSignJob implements Job{
    private static final Log log = Logs.get();

    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.debug("BaoBookSignJob , start" + new Date());
        IBaoBookService baoBookService = ServiceFactory.getService(
                IBaoBookService.class, "1.0.0");
        boolean flag = baoBookService.baoBookSign();
        log.debug(flag);
    }
}
