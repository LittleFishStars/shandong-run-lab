package com.alibaba.alibctriver.extensions;

import android.content.Context;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.mtop.SendMtopParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.triver.inside.impl.MtopExtensionImpl;
import com.taobao.tao.remotebusiness.MtopBusiness;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopBuilder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcMtopExtensionImpl extends MtopExtensionImpl {

    /* JADX INFO: renamed from: com.alibaba.alibctriver.extensions.AlibcMtopExtensionImpl$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f23676a;

        static {
            int[] iArr = new int[EnvModeEnum.values().length];
            f23676a = iArr;
            try {
                iArr[EnvModeEnum.ONLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23676a[EnvModeEnum.PREPARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23676a[EnvModeEnum.TEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.alibaba.ariver.mtop.SendMtopProxyImpl
    public MtopBusiness buildMtopBusiness(App app, SendMtopParams sendMtopParams) {
        return super.buildMtopBusiness(app, sendMtopParams);
    }

    @Override // com.alibaba.ariver.mtop.SendMtopProxyImpl
    public void configMtopBusinessInner(MtopBusiness mtopBusiness, SendMtopParams sendMtopParams) {
        super.configMtopBusinessInner(mtopBusiness, sendMtopParams);
        mtopBusiness.setOpenBiz("baichuan");
        MtopNetworkProp mtopNetworkProp = ((MtopBuilder) mtopBusiness).mtopProp;
        mtopNetworkProp.customOnlineDomain = "";
        mtopNetworkProp.customDailyDomain = "";
        mtopNetworkProp.customPreDomain = "";
    }

    @Override // com.alibaba.ariver.mtop.SendMtopProxyImpl
    public void configMtopBussiness(App app, MtopBusiness mtopBusiness, SendMtopParams sendMtopParams) {
        super.configMtopBussiness(app, mtopBusiness, sendMtopParams);
    }

    @Override // com.alibaba.ariver.mtop.SendMtopProxyImpl
    public String getDomain(EnvModeEnum envModeEnum, Mtop mtop) {
        int i = AnonymousClass1.f23676a[envModeEnum.ordinal()];
        if (i != 1) {
            return i != 2 ? "" : "acs4baichuan.wapa.taobao.com";
        }
        return "acs4miniapp.m.taobao.com";
    }

    @Override // com.alibaba.ariver.mtop.SendMtopProxyImpl
    public Mtop getMtopInstance(String str, SendMtopParams sendMtopParams) {
        return Mtop.instance("OPEN", ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
    }

    @Override // com.alibaba.ariver.mtop.SendMtopProxyImpl
    public String getUserAgent(Context context) {
        return super.getUserAgent(context) + " " + String.format("AliBaichuan(%s/%s)", Mtop.instance("OPEN", ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext()).getMtopConfig().ttid, "5.0.2.5");
    }
}
