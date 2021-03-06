/*
 * 
 */
var service = {
    service.sample.1 : {
		parent : 'baseService',
		fields : {
			interfaceName : 'com.sunivo.nutzdubbo.services.IPetService',
			ref : {
				refer:'petService'
			},
			version : '1.0.0'
		}
    },
    service.sample.2 : {
		parent : 'baseService',
		fields : {
			interfaceName : 'com.sunivo.nutzdubbo.services.IPetService',
			ref : {
				refer : 'myPetService'
			},
			version : '1.0.1'
		}
    },
    service.sample.3 : {
		parent : 'baseService',
		fields : {
			interfaceName : 'com.sunivo.nutzdubbo.services.IHelloService',
			ref : {
				refer : 'helloService'
			},
			version : '1.0.0'
		}
    },
    service.sample.4 : {
        parent : 'baseService',
            fields : {
            interfaceName : 'com.xuan.smzdm.services.IFindGoodsServices',
                ref : {
                refer : 'findService'
            },
            version : '1.0.0'
        }
    },
	service.sample.5 : {
        parent : 'baseService',
            fields : {
            interfaceName : 'com.xuan.smzdm.services.IPushService',
                ref : {
                refer : 'pushService'
            },
            version : '1.0.0'
        }
    },
    service.sample.6 : {
        parent : 'baseService',
            fields : {
            interfaceName : 'com.xuan.smzdm.services.IBaoBookService',
                ref : {
                refer : 'baoBookService'
            },
            version : '1.0.0',
            timeout : 15000
        }
    }
}