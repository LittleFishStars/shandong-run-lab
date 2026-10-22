package com.alibaba.alibctriver.extensions;

import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.triver.inside.impl.MtopProxyImpl;
import com.alibaba.triver.kit.api.model.RequestParams;
import com.taobao.tao.remotebusiness.MtopBusiness;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopBuilder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcMtopProxyImpl extends MtopProxyImpl {
    @Override // com.alibaba.triver.inside.impl.MtopProxyImpl
    public void configMtopBusiness(MtopBusiness mtopBusiness, RequestParams requestParams) {
        super.configMtopBusiness(mtopBusiness, requestParams);
        MtopNetworkProp mtopNetworkProp = ((MtopBuilder) mtopBusiness).mtopProp;
        mtopNetworkProp.customOnlineDomain = "";
        mtopNetworkProp.customDailyDomain = "";
        mtopNetworkProp.customPreDomain = "";
        mtopBusiness.setOpenBiz("baichuan");
    }

    @Override // com.alibaba.triver.inside.impl.MtopProxyImpl
    public Mtop getMtopInstance(String str, RequestParams requestParams) {
        return Mtop.instance("OPEN", ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
    }
}
