package cj.mobile.wm;

import android.app.Application;
import com.wangmai.insightvision.openadsdk.api.FanTiAppConfig;
import com.wangmai.insightvision.openadsdk.proxy.InsightProxy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g1 {
    public FanTiAppConfig dexa;
    public Application dexb;

    public static class dexb {
        public static final g1 dexa = new g1();
    }

    public g1() {
    }

    public static g1 dexc() {
        return dexb.dexa;
    }

    public Application dexa() {
        return this.dexb;
    }

    public void dexa(Application application, FanTiAppConfig fanTiAppConfig) {
        this.dexa = fanTiAppConfig;
        this.dexb = application;
        InsightProxy.getInstance().initialize();
        InsightProxy.getInstance().setDebugMode(fanTiAppConfig.isDebugMode());
        dexv.dexj().dexa((dexv.dexc) null);
        dexy.dexa().dexa(application);
    }

    public FanTiAppConfig dexb() {
        return this.dexa;
    }
}
