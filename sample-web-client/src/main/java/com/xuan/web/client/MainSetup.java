package com.xuan.web.client;

import org.nutz.integration.quartz.NutQuartzCronJobFactory;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.PropertiesProxy;
import org.nutz.lang.Encoding;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;
import org.quartz.Scheduler;

import java.nio.charset.Charset;

/**
 * Nutz内核初始化完成后的操作
 *
 * @author wendal
 */
public class MainSetup implements Setup {

    private static final Log log = Logs.get();

    public static PropertiesProxy conf;

    public void init(NutConfig nc) {
        // 检查环境
        if (!Charset.defaultCharset().name().equalsIgnoreCase(Encoding.UTF8)) {
            log.warn("This project must run in UTF-8, pls add -Dfile.encoding=UTF-8 to JAVA_OPTS");
        }

        // 获取Ioc容器及Dao对象
        Ioc ioc = nc.getIoc();

        // 获取配置对象
        conf = ioc.get(PropertiesProxy.class, "conf");

        // 获取NutQuartzCronJobFactory从而触发计划任务的初始化与启动
        ioc.get(NutQuartzCronJobFactory.class);
    }

    public void destroy(NutConfig conf) {
        // 解决quartz有时候无法停止的问题
        try {
            conf.getIoc().get(Scheduler.class).shutdown(true);
        } catch (Exception e) {
        }
    }
}
