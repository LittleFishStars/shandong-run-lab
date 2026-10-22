package cj.mobile.wm;

import android.app.Application;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.kc.openset.sdk.dsp.util.QdActivityType;
import com.wangmai.insightvision.openadsdk.api.AdSlot;
import com.wangmai.insightvision.openadsdk.api.FanTiAppConfig;
import com.wangmai.insightvision.openadsdk.api.INativeAd;
import com.wangmai.insightvision.openadsdk.net.request.ad.AdDeviceInfo;
import com.wangmai.insightvision.openadsdk.net.request.ad.AdImpInfo;
import com.wangmai.insightvision.openadsdk.proxy.InsightProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class k1 extends s9 {
    public final Map<String, String> dexc = new HashMap();
    public final String dexd;
    public INativeAd dexe;

    public k1(String str, INativeAd iNativeAd) {
        this.dexd = str;
        this.dexe = iNativeAd;
    }

    private String dexf() {
        Map extraInfo;
        INativeAd iNativeAd = this.dexe;
        return (iNativeAd == null || (extraInfo = iNativeAd.getExtraInfo()) == null || !extraInfo.containsKey("req_id")) ? "" : (String) extraInfo.get("req_id");
    }

    private String dexg() {
        INativeAd iNativeAd = this.dexe;
        if (iNativeAd == null) {
            return "";
        }
        Map extraInfo = iNativeAd.getExtraInfo();
        return extraInfo.containsKey("slot_id") ? (String) extraInfo.get("slot_id") : "";
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    private String dexh() {
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
        return "https://" + strValueOf + "/union/sdk/data";
    }

    @Override // cj.mobile.wm.s9
    public i9 dexa(q9 q9Var) {
        return super.dexa(q9Var);
    }

    @Override // cj.mobile.wm.s9
    public Map<String, Object> dexb() {
        HashMap map = new HashMap();
        String appId = g1.dexc().dexb().getAppId();
        map.put("id", dexf());
        map.put("slot_id", dexg());
        map.put("apv", "v1.0.1");
        map.put("app_id", appId);
        ArrayList arrayList = new ArrayList();
        AdImpInfo adImpInfo = new AdImpInfo();
        adImpInfo.setId("0");
        q9 q9Var = this.dexa;
        AdSlot adSlotDexa = q9Var != null ? q9Var.dexa() : null;
        if (adSlotDexa != null) {
            adImpInfo.setPid(adSlotDexa.getSlotId());
            adImpInfo.setWidth(adSlotDexa.getWidth());
            adImpInfo.setHeight(adSlotDexa.getHeight());
            adImpInfo.setAd_num(adSlotDexa.getAdCount());
            adImpInfo.setSlot_id(adSlotDexa.getSlotId());
        }
        map.put("mType", this.dexd);
        arrayList.add(adImpInfo);
        map.put(QdActivityType.IMP, arrayList);
        dexx systemInfo = InsightProxy.getInstance().getSystemInfo();
        AdDeviceInfo adDeviceInfo = new AdDeviceInfo();
        if (systemInfo != null) {
            map.put("appName", systemInfo.dexa());
            map.put("package_name", systemInfo.dexj());
            map.put("package_version", systemInfo.dexk());
            map.put("sdk_version", systemInfo.dexl());
            map.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            adDeviceInfo.setUa(systemInfo.dexm());
            adDeviceInfo.setOsv(systemInfo.dexi());
            adDeviceInfo.setConnection_type(systemInfo.dexd());
            adDeviceInfo.setCarrier(systemInfo.dexc());
            adDeviceInfo.setModel(systemInfo.dexg());
            adDeviceInfo.setBrand(systemInfo.dexb());
            adDeviceInfo.setWidth(systemInfo.dexp());
            adDeviceInfo.setHeight(systemInfo.dexf());
            adDeviceInfo.setOaid(systemInfo.dexh());
            adDeviceInfo.setA_oneid(systemInfo.dexh());
            adDeviceInfo.setSdkv(systemInfo.dexl());
            adDeviceInfo.setUmengId(systemInfo.dexn());
            adDeviceInfo.setUmengZid(systemInfo.dexo());
        }
        adDeviceInfo.setOs("android");
        adDeviceInfo.setDevice_type(de.dexc(InsightProxy.getApplication().getApplicationContext()));
        String strDexa = tc.dexa(g1.dexc().dexa());
        adDeviceInfo.setDevice_id(strDexa);
        adDeviceInfo.setUtdid(strDexa);
        adDeviceInfo.setSst(be.dexa());
        adDeviceInfo.setSut(be.dexb());
        map.put("device", adDeviceInfo);
        if (this.dexa.dexb() != null && !this.dexa.dexb().isEmpty()) {
            HashMap map2 = new HashMap();
            for (String str : this.dexa.dexb().keySet()) {
                map2.put(str, this.dexa.dexb().get(str) + "");
            }
            map.put(LoginConstants.EXT, map2);
        }
        return map;
    }

    @Override // cj.mobile.wm.s9
    public Map<String, Object> dexc() {
        return null;
    }

    @Override // cj.mobile.wm.s9
    public String dexd() {
        Application applicationDexa = g1.dexc().dexa();
        if (applicationDexa != null && "com.youku.insightvision.demo".equals(applicationDexa.getPackageName())) {
            String strDexa = be.dexa("debug.network.report.url", "");
            if (!TextUtils.isEmpty(strDexa)) {
                return strDexa;
            }
        }
        return dexh();
    }

    @Override // cj.mobile.wm.s9
    public boolean dexe() {
        return true;
    }
}
