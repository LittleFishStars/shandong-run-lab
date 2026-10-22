package cj.mobile.wm;

import android.app.Application;
import android.text.TextUtils;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.huachenjie.base.util.rich_text.RichTextUtils;
import com.kc.openset.sdk.dsp.util.QdActivityType;
import com.wangmai.insightvision.openadsdk.api.AdSlot;
import com.wangmai.insightvision.openadsdk.api.FanTiAppConfig;
import com.wangmai.insightvision.openadsdk.net.request.ad.AdAppInfo;
import com.wangmai.insightvision.openadsdk.net.request.ad.AdDeviceInfo;
import com.wangmai.insightvision.openadsdk.net.request.ad.AdImpInfo;
import com.wangmai.insightvision.openadsdk.net.request.ad.AdUserInfo;
import com.wangmai.insightvision.openadsdk.proxy.InsightProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class v9 extends s9 {
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
        return "https://" + strValueOf + "/union/sdk/ad";
    }

    @Override // cj.mobile.wm.s9
    public Map<String, Object> dexb() {
        FanTiAppConfig fanTiAppConfigDexb;
        HashMap map = new HashMap();
        Application applicationDexa = g1.dexc().dexa();
        if (applicationDexa != null && (fanTiAppConfigDexb = g1.dexc().dexb()) != null && !TextUtils.isEmpty(fanTiAppConfigDexb.getAppId())) {
            String appId = fanTiAppConfigDexb.getAppId();
            map.put("id", dexa());
            map.put("apv", "v1.0.1");
            map.put("app_id", appId);
            AdSlot adSlotDexa = this.dexa.dexa();
            if (adSlotDexa == null) {
                return map;
            }
            ArrayList arrayList = new ArrayList();
            AdImpInfo adImpInfo = new AdImpInfo();
            adImpInfo.setId("0");
            adImpInfo.setPid(adSlotDexa.getSlotId());
            adImpInfo.setWidth(adSlotDexa.getWidth());
            adImpInfo.setHeight(adSlotDexa.getHeight());
            adImpInfo.setAd_num(adSlotDexa.getAdCount());
            adImpInfo.setSlot_id(adSlotDexa.getSlotId());
            HashMap map2 = new HashMap();
            Map extMap = adSlotDexa.getExtMap();
            if (extMap != null) {
                String str = (String) extMap.get("convToolTaskId");
                if (!TextUtils.isEmpty(str)) {
                    Objects.requireNonNull(str);
                    map2.put("convToolTaskId", str);
                }
            }
            adImpInfo.setExt(map2);
            arrayList.add(adImpInfo);
            map.put(QdActivityType.IMP, arrayList);
            dexx systemInfo = InsightProxy.getInstance().getSystemInfo();
            AdAppInfo adAppInfo = new AdAppInfo();
            adAppInfo.setName(dexa(systemInfo.dexa()));
            adAppInfo.setPackage_name(dexa(systemInfo.dexj()));
            adAppInfo.setPackage_version(dexa(systemInfo.dexk()));
            adAppInfo.setSdk_version(dexa(systemInfo.dexl()));
            map.put(NativeCallContext.DOMAIN_APP, adAppInfo);
            AdDeviceInfo adDeviceInfo = new AdDeviceInfo();
            adDeviceInfo.setUa(dexa(systemInfo.dexm()));
            adDeviceInfo.setOs("android");
            adDeviceInfo.setOsv(dexa(systemInfo.dexi()));
            adDeviceInfo.setDevice_type(de.dexc(applicationDexa));
            adDeviceInfo.setConnection_type(systemInfo.dexd());
            adDeviceInfo.setCarrier(dexa(systemInfo.dexc()));
            adDeviceInfo.setModel(dexa(systemInfo.dexg()));
            adDeviceInfo.setBrand(dexa(systemInfo.dexb()));
            adDeviceInfo.setWidth(systemInfo.dexp());
            adDeviceInfo.setHeight(systemInfo.dexf());
            adDeviceInfo.setOaid(dexa(systemInfo.dexh()));
            String strDexa = tc.dexa(applicationDexa);
            adDeviceInfo.setDevice_id(strDexa);
            adDeviceInfo.setUtdid(strDexa);
            adDeviceInfo.setSdkv(dexa(systemInfo.dexl()));
            adDeviceInfo.setUmengId(dexa(systemInfo.dexn()));
            adDeviceInfo.setUmengZid(dexa(systemInfo.dexo()));
            adDeviceInfo.setSst(be.dexa());
            adDeviceInfo.setSut(be.dexb());
            map.put("device", adDeviceInfo);
            AdUserInfo adUserInfo = new AdUserInfo();
            adUserInfo.setAa(je.dexa());
            map.put(RichTextUtils.USER_SCHEME, adUserInfo);
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
            String strDexa = be.dexa("debug.network.ad.url", "");
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
