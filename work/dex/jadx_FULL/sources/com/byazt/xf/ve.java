package com.byazt.xf;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 804, 54})
public class ve {
    public PluginValueSet c;
    public Function<SparseArray<Object>, Object> n;
    public PluginValueSet tt;
    public com.byazt.dj.c uj = new com.byazt.dj.c(com.byazt.bp.c.t().cu().sparseArray());
    public PluginValueSet ve;

    private ve(SparseArray<Object> sparseArray) {
        this.n = null;
        PluginValueSet pluginValueSetTt = com.byazt.rl.c.c(sparseArray).tt();
        this.c = pluginValueSetTt;
        if (pluginValueSetTt != null) {
            this.ve = com.byazt.lq.uj.c(8457, pluginValueSetTt);
            PluginValueSet pluginValueSetC = com.byazt.lq.uj.c(8475, this.c);
            this.tt = pluginValueSetC;
            if (pluginValueSetC != null) {
                this.n = (Function) pluginValueSetC.objectValue(8311, Function.class);
            }
        }
        lo();
    }

    public static ve c(SparseArray<Object> sparseArray) {
        return new ve(sparseArray);
    }

    private void lo() {
        lt();
        to();
        pu();
    }

    private void lt() {
        com.byazt.eu.tt.tt("---------  sdk 初始化信息 start ----");
        com.byazt.eu.tt.tt("isDebug：" + zb());
        com.byazt.eu.tt.tt("getClassName：" + c());
        com.byazt.eu.tt.tt("getAppId：" + tt());
        com.byazt.eu.tt.tt("getAppName：" + ve());
        com.byazt.eu.tt.tt("getADNName：" + uj());
        com.byazt.eu.tt.tt("getAppKey：" + n());
        com.byazt.eu.tt.tt("getInitCallback：" + a());
        com.byazt.eu.tt.tt("getAgeGroup：" + md());
        com.byazt.eu.tt.tt("isCustom：" + h());
        com.byazt.eu.tt.tt("getCustomInitMap：" + d());
        com.byazt.eu.tt.tt("getCustomGMConfiguration：" + eo());
        com.byazt.eu.tt.tt("getGromoreVersion：" + or());
        com.byazt.eu.tt.tt("getMap：" + cu());
        com.byazt.eu.tt.tt("---------  sdk 初始化信息 end ----");
    }

    private void pu() {
        com.byazt.eu.tt.tt("---------  sdk 聚合信息 start ----");
        com.byazt.eu.tt.tt("getHttps：" + qp());
        com.byazt.eu.tt.tt("getWxAppId：" + nb());
        com.byazt.eu.tt.tt("getPublisherDid：" + pf());
        com.byazt.eu.tt.tt("isOpenAdnTest：" + bx());
        com.byazt.eu.tt.tt("getMediationConfigUserInfoForSegment：" + sv());
        com.byazt.eu.tt.tt("getLocalExtra：" + aw());
        com.byazt.eu.tt.tt("getCustomLocalConfig：" + ic());
        com.byazt.eu.tt.tt("getOpensdkVer：" + hd());
        com.byazt.eu.tt.tt("isWxInstalled：" + bm());
        com.byazt.eu.tt.tt("isSupportH265：" + lr());
        com.byazt.eu.tt.tt("isSupportSplashZoomout：" + l());
        com.byazt.eu.tt.tt("---------  sdk 聚合信息 end ----");
    }

    private boolean tk() {
        PluginValueSet pluginValueSet = this.c;
        return (pluginValueSet == null || pluginValueSet.isEmpty()) ? false : true;
    }

    private void to() {
        com.byazt.eu.tt.tt("---------  sdk 隐私设置 start ----");
        com.byazt.eu.tt.tt("isCanUseLocation：" + i());
        uj ujVarZ = z();
        com.byazt.eu.tt.tt("getLocation：".concat(String.valueOf(ujVarZ)));
        if (ujVarZ != null) {
            com.byazt.eu.tt.tt("getLocation getLatitude：" + ujVarZ.c());
            com.byazt.eu.tt.tt("getLocation getLongitude：" + ujVarZ.tt());
        }
        com.byazt.eu.tt.tt("appList：" + sl());
        com.byazt.eu.tt.tt("isCanUsePhoneState：" + x());
        com.byazt.eu.tt.tt("isLimitPersonalAds：" + sp());
        com.byazt.eu.tt.tt("getDevImei：" + rh());
        com.byazt.eu.tt.tt("isCanUseWifiState：" + zm());
        com.byazt.eu.tt.tt("getMacAddress：" + gu());
        com.byazt.eu.tt.tt("userPrivacyConfig：" + gr());
        com.byazt.eu.tt.tt("isCanUseWriteExternal：" + da());
        com.byazt.eu.tt.tt("isCanUseAndroidId：" + u());
        com.byazt.eu.tt.tt("getAndroidId：" + gt());
        List<String> listP = p();
        com.byazt.eu.tt.tt("getAppList：".concat(String.valueOf(listP)));
        if (listP != null) {
            Iterator<String> it = listP.iterator();
            while (it.hasNext()) {
                com.byazt.eu.tt.tt("getAppList item: ".concat(String.valueOf(it.next())));
            }
        }
        List<String> listMy = my();
        com.byazt.eu.tt.tt("getDevImeis：".concat(String.valueOf(listMy)));
        if (listMy != null) {
            Iterator<String> it2 = listMy.iterator();
            while (it2.hasNext()) {
                com.byazt.eu.tt.tt("getDevImeis item: ".concat(String.valueOf(it2.next())));
            }
        }
        com.byazt.eu.tt.tt("getDevOaid：" + qy());
        com.byazt.eu.tt.tt("isCanUseOaid：" + rl());
        com.byazt.eu.tt.tt("isCanUseMacAddress：" + t());
        com.byazt.eu.tt.tt("isProgrammaticRecommend：" + yp());
        com.byazt.eu.tt.tt("---------  sdk 隐私设置 end ----");
    }

    public Function<SparseArray<Object>, Object> a() {
        if (tk()) {
            return (Function) this.c.objectValue(JosStatusCodes.RNT_CODE_NETWORK_ERROR, Function.class);
        }
        return null;
    }

    public Map aw() {
        PluginValueSet pluginValueSet = this.ve;
        return pluginValueSet != null ? (Map) pluginValueSet.objectValue(8462, Map.class) : new HashMap();
    }

    public boolean bm() {
        PluginValueSet pluginValueSet = this.ve;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8465);
        }
        return false;
    }

    public boolean bx() {
        PluginValueSet pluginValueSet = this.ve;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8461);
        }
        return false;
    }

    public Map cu() {
        PluginValueSet pluginValueSet = this.c;
        return pluginValueSet != null ? (Map) pluginValueSet.objectValue(8425, Map.class) : new HashMap();
    }

    public Map d() {
        if (tk()) {
            return (Map) this.c.objectValue(8400, Map.class);
        }
        return null;
    }

    public boolean da() {
        PluginValueSet pluginValueSet = this.tt;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8025);
        }
        return true;
    }

    public Function<SparseArray<Object>, Object> eo() {
        if (tk()) {
            return (Function) this.c.objectValue(8401, Function.class);
        }
        return null;
    }

    public Map<String, Object> gr() {
        PluginValueSet pluginValueSet = this.tt;
        if (pluginValueSet != null) {
            return (Map) pluginValueSet.objectValue(8554, Map.class);
        }
        return null;
    }

    public String gt() {
        PluginValueSet pluginValueSet = this.tt;
        return pluginValueSet != null ? pluginValueSet.stringValue(8485) : "";
    }

    public String gu() {
        PluginValueSet pluginValueSet = this.tt;
        return pluginValueSet != null ? pluginValueSet.stringValue(8487) : "";
    }

    public boolean h() {
        if (tk()) {
            return this.c.booleanValue(8098);
        }
        return false;
    }

    public String hd() {
        PluginValueSet pluginValueSet = this.ve;
        return pluginValueSet != null ? pluginValueSet.stringValue(8464) : "";
    }

    public boolean i() {
        PluginValueSet pluginValueSet = this.tt;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8024);
        }
        return true;
    }

    public JSONObject ic() {
        PluginValueSet pluginValueSet = this.ve;
        if (pluginValueSet != null) {
            return (JSONObject) pluginValueSet.objectValue(8463, JSONObject.class);
        }
        return null;
    }

    public boolean l() {
        PluginValueSet pluginValueSet = this.ve;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8467);
        }
        return false;
    }

    public boolean lr() {
        PluginValueSet pluginValueSet = this.ve;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8466);
        }
        return false;
    }

    public double m() {
        Function function;
        PluginValueSet pluginValueSetTt;
        PluginValueSet pluginValueSet = this.tt;
        if (pluginValueSet == null || (function = (Function) pluginValueSet.objectValue(8312, Function.class)) == null || (pluginValueSetTt = com.byazt.yxi.ve.tt(function)) == null) {
            return -1.0d;
        }
        return pluginValueSetTt.doubleValue(8481);
    }

    public int md() {
        return this.uj.u();
    }

    public List<String> my() {
        PluginValueSet pluginValueSetTt;
        Function<SparseArray<Object>, Object> function = this.n;
        return (function == null || (pluginValueSetTt = com.byazt.yxi.ve.tt(function)) == null) ? new LinkedList() : (List) pluginValueSetTt.objectValue(8477, List.class);
    }

    public String n() {
        return tk() ? this.c.stringValue(AVMDLDataLoader.KeyIsLiveWatchDurationThreshold) : "";
    }

    public String nb() {
        PluginValueSet pluginValueSet = this.ve;
        return pluginValueSet != null ? pluginValueSet.stringValue(8459) : "";
    }

    public double nu() {
        Function function;
        PluginValueSet pluginValueSetTt;
        PluginValueSet pluginValueSet = this.tt;
        if (pluginValueSet == null || (function = (Function) pluginValueSet.objectValue(8312, Function.class)) == null || (pluginValueSetTt = com.byazt.yxi.ve.tt(function)) == null) {
            return -1.0d;
        }
        return pluginValueSetTt.doubleValue(8482);
    }

    public String or() {
        PluginValueSet pluginValueSet = this.c;
        return pluginValueSet != null ? pluginValueSet.stringValue(8411) : "";
    }

    public List<String> p() {
        PluginValueSet pluginValueSetTt;
        Function<SparseArray<Object>, Object> function = this.n;
        return (function == null || (pluginValueSetTt = com.byazt.yxi.ve.tt(function)) == null) ? new LinkedList() : (List) pluginValueSetTt.objectValue(8476, List.class);
    }

    public String pf() {
        PluginValueSet pluginValueSet = this.ve;
        return pluginValueSet != null ? pluginValueSet.stringValue(8460) : "";
    }

    public boolean qp() {
        PluginValueSet pluginValueSet = this.ve;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8458);
        }
        return false;
    }

    public String qy() {
        PluginValueSet pluginValueSet = this.tt;
        return pluginValueSet != null ? pluginValueSet.stringValue(8486) : "";
    }

    public String rh() {
        PluginValueSet pluginValueSet = this.tt;
        return pluginValueSet != null ? pluginValueSet.stringValue(8484) : "";
    }

    public boolean rl() {
        PluginValueSet pluginValueSetTt;
        Function<SparseArray<Object>, Object> function = this.n;
        if (function == null || (pluginValueSetTt = com.byazt.yxi.ve.tt(function)) == null) {
            return true;
        }
        return pluginValueSetTt.booleanValue(8478);
    }

    public boolean sl() {
        PluginValueSet pluginValueSet = this.tt;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8026);
        }
        return true;
    }

    public boolean sp() {
        PluginValueSet pluginValueSetTt;
        Function<SparseArray<Object>, Object> function = this.n;
        if (function == null || (pluginValueSetTt = com.byazt.yxi.ve.tt(function)) == null) {
            return false;
        }
        return pluginValueSetTt.booleanValue(8027);
    }

    public Function<SparseArray<Object>, Object> sv() {
        PluginValueSet pluginValueSet = this.ve;
        if (pluginValueSet != null) {
            return (Function) pluginValueSet.objectValue(8310, Function.class);
        }
        return null;
    }

    public boolean t() {
        return zm();
    }

    public void tt(SparseArray<Object> sparseArray) {
        PluginValueSet pluginValueSetTt = com.byazt.rl.c.c(sparseArray).tt();
        this.tt = pluginValueSetTt;
        if (pluginValueSetTt != null) {
            this.n = (Function) pluginValueSetTt.objectValue(8311, Function.class);
        }
        to();
    }

    public boolean u() {
        PluginValueSet pluginValueSet = this.tt;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8479);
        }
        return true;
    }

    public String uj() {
        return tk() ? this.c.stringValue(8003) : "";
    }

    public String ve() {
        return tk() ? this.c.stringValue(8) : "";
    }

    public boolean x() {
        PluginValueSet pluginValueSet = this.tt;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8023);
        }
        return true;
    }

    public boolean yp() {
        PluginValueSet pluginValueSetTt;
        Function<SparseArray<Object>, Object> function = this.n;
        if (function == null || (pluginValueSetTt = com.byazt.yxi.ve.tt(function)) == null) {
            return true;
        }
        return pluginValueSetTt.booleanValue(8028);
    }

    public boolean yv() {
        PluginValueSet pluginValueSet = this.tt;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8549);
        }
        return true;
    }

    public uj z() {
        if (m() == -1.0d || m() == -1.0d) {
            return null;
        }
        return new uj() { // from class: com.byazt.xf.ve.1
            @Override // com.byazt.xf.uj
            public double c() {
                return ve.this.m();
            }

            @Override // com.byazt.xf.uj
            public double tt() {
                return ve.this.nu();
            }
        };
    }

    public boolean zb() {
        PluginValueSet pluginValueSet = this.c;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(1);
        }
        return false;
    }

    public boolean zm() {
        PluginValueSet pluginValueSet = this.tt;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8480);
        }
        return true;
    }

    public String c() {
        return tk() ? this.c.stringValue(AVMDLDataLoader.KeyIsLiveMobileUploadAllow) : "";
    }

    public String tt() {
        if (tk()) {
            return this.c.stringValue(3);
        }
        return null;
    }
}
