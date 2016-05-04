package com.xuan.web.client;

import org.nutz.mvc.annotation.*;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

/**
 * Created by bj on 2016/5/3.
 */
@SetupBy(value=MainSetup.class)
@IocBy(type=ComboIocProvider.class, args={"*js", "ioc/",
        "*anno", "com.xuan.web.client",
        "*org.nutz.integration.quartz.QuartzIocLoader"})
@Modules(scanPackage=true)
public class MainModule {
}
