package cj.mobile.wm;

import android.app.Application;
import android.text.TextUtils;
import com.wangmai.insightvision.openadsdk.api.FanTiAppConfig;
import com.wangmai.insightvision.openadsdk.proxy.InsightProxy;
import com.zj.adlib.ze1;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class t9 extends s9 {
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    private String dexf() {
        String strValueOf;
        FanTiAppConfig fanTiAppConfigDexb = g1.dexc().dexb();
        if (fanTiAppConfigDexb != null) {
            strValueOf = String.valueOf(fanTiAppConfigDexb.getExtraValue("domain"));
            if (TextUtils.isEmpty(strValueOf)) {
                strValueOf = "ssp.iytcdn.com";
            }
        } else {
            strValueOf = "ssp.iytcdn.com";
        }
        return "https://" + strValueOf + "/union/sdk/config";
    }

    @Override // cj.mobile.wm.s9
    public Map<String, Object> dexb() {
        HashMap map = new HashMap();
        Application applicationDexa = g1.dexc().dexa();
        if (applicationDexa == null) {
            return map;
        }
        FanTiAppConfig fanTiAppConfigDexb = g1.dexc().dexb();
        dexx systemInfo = InsightProxy.getInstance().getSystemInfo();
        String appId = fanTiAppConfigDexb != null ? fanTiAppConfigDexb.getAppId() : "";
        map.put("req_id", dexa());
        map.put("app_id", appId);
        map.put("device_id", dexa(tc.dexa(applicationDexa)));
        map.put("package_name", dexa(systemInfo.dexj()));
        map.put("package_version", dexa(systemInfo.dexk()));
        map.put("sdk_version", dexa(systemInfo.dexl()));
        map.put("os", "android");
        map.put("osv", dexa(systemInfo.dexi()));
        map.put("device_type", Integer.valueOf(systemInfo.dexe()));
        map.put("connection_type", Integer.valueOf(systemInfo.dexd()));
        String strDexc = systemInfo.dexc();
        if (TextUtils.isEmpty(strDexc)) {
            strDexc = " ";
        }
        map.put("carrier", strDexc);
        map.put(ze1.k, dexa(systemInfo.dexg()));
        map.put("brand", dexa(systemInfo.dexb()));
        map.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        map.put("umengZid", dexa(systemInfo.dexo()));
        map.put("umengId", dexa(systemInfo.dexn()));
        try {
            String strDexb = ae.dexb(ae.dexa(applicationDexa), "ykaduscNO7X8D5Ny");
            if (strDexb != null) {
                map.put("app_sha", strDexb);
            }
        } catch (Exception unused) {
        }
        return map;
    }

    @Override // cj.mobile.wm.s9
    public String dexd() {
        Application applicationDexa = g1.dexc().dexa();
        if (applicationDexa != null && "com.youku.insightvision.demo".equals(applicationDexa.getPackageName())) {
            String strDexa = be.dexa("debug.network.config.url", "");
            if (!TextUtils.isEmpty(strDexa)) {
                return strDexa;
            }
        }
        return dexf();
    }

    @Override // cj.mobile.wm.s9
    public boolean dexe() {
        return true;
    }
}
