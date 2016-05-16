var ioc = {
    // 读取配置文件
    conf : {
        type : "org.nutz.ioc.impl.PropertiesProxy",
        fields : {
            paths : [ "custom/" ]
        }
    },
    // 极光推送
    jpush: {
        type: "cn.jpush.api.JPushClient",
        args: [
            {java: "$conf.get('jpush.masterSecret')"},
            {java: "$conf.get('jpush.appKey')"}
        ]
    }
};