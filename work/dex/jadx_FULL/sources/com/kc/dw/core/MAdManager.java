package com.kc.dw.core;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.android.arouter.utils.Consts;
import com.aliyun.vod.log.struct.AliyunLogKey;
import com.igexin.assist.util.AssistUtils;
import com.kc.dw.core.utils.PckIdBean;
import com.kc.dw.core.utils.d1;
import com.kc.dw.core.utils.p;
import com.kc.dw.core.utils.p0;
import com.kc.dw.core.utils.r;
import com.kc.dw.core.utils.w0;
import com.kc.openset.constant.DeviceIdType;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MAdManager implements IAdManager {
    private static final String TAG = "MsAdManager";

    @Override // com.kc.dw.core.IAdManager
    public String getBuyerId(Map<String, Object> map) {
        try {
            if (com.kc.dw.base.a.getContext() == null) {
                Log.d("Sdk_MsAdManager", "Sdk is not initialized. Please initialize the SDK first.");
                return "";
            }
            HashMap map2 = new HashMap();
            if (map != null) {
                map2.put(LoginConstants.EXT, map);
            }
            map2.put("uuid", SsdAdConfig.initUUID());
            map2.put("msec", String.valueOf(System.currentTimeMillis()));
            map2.put("code", Long.toString(3000400L));
            String str = w0.b;
            map2.put("ver", "20251125");
            map2.put("rext", 1);
            return p.a(map2);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x004a  */
    @Override // com.kc.dw.core.IAdManager
    public String getSDKInfo(String str) {
        String strA;
        try {
            if (com.kc.dw.base.a.getContext() == null) {
                Log.d("Sdk_MsAdManager", "Sdk is not initialized. Please initialize the SDK first.");
                return "";
            }
            Context context = com.kc.dw.base.a.getContext();
            String localOaid = null;
            if (com.kc.dw.base.a.adConfig() != null && com.kc.dw.base.a.adConfig().enableOaid()) {
                try {
                    if (r.a().a("oaid_e")) {
                        String strA2 = r.a().a("oaid_e", (String) null);
                        if (TextUtils.isEmpty(strA2)) {
                            strA = null;
                        } else {
                            strA = d1.a(strA2);
                        }
                    } else {
                        strA = null;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (TextUtils.isEmpty(strA) && Build.MANUFACTURER.equalsIgnoreCase(AssistUtils.BRAND_HON)) {
                    strA = r.a().a("honor_oaid", (String) null);
                }
                if (TextUtils.isEmpty(strA)) {
                    strA = r.a().a(DeviceIdType.OAID) ? r.a().a(DeviceIdType.OAID, (String) null) : com.kc.dw.base.a.getSharedPreferences().getString(DeviceIdType.OAID, null);
                }
                localOaid = strA;
            }
            if (TextUtils.isEmpty(localOaid)) {
                localOaid = AdSdk.getLocalOaid();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msec", String.valueOf(System.currentTimeMillis()));
            linkedHashMap.put("pid", str);
            if (!TextUtils.isEmpty(localOaid)) {
                linkedHashMap.put(DeviceIdType.OAID, localOaid);
            }
            linkedHashMap.put("anid", w0.b(context));
            if (!TextUtils.isEmpty(w0.k(context))) {
                linkedHashMap.put("imsi", w0.k(context));
            }
            if (!TextUtils.isEmpty(w0.j(context))) {
                linkedHashMap.put("hmscore", w0.j(context));
            }
            if (!TextUtils.isEmpty(w0.f(context))) {
                linkedHashMap.put("appstore_ver", w0.f(context));
            }
            if (!TextUtils.isEmpty(w0.b())) {
                linkedHashMap.put("boot_mark", w0.b());
            }
            if (!TextUtils.isEmpty(w0.k())) {
                linkedHashMap.put("update_mark", w0.k());
            }
            if (!TextUtils.isEmpty(com.kc.dw.core.utils.c.a(context))) {
                linkedHashMap.put("ua", com.kc.dw.core.utils.c.a(context));
            }
            PckIdBean pckIdBean = p0.e;
            if (pckIdBean != null) {
                String app_y = pckIdBean.getApp_y();
                String app_n = p0.e.getApp_n();
                if (!TextUtils.isEmpty(app_y)) {
                    if (app_y.startsWith(Consts.DOT)) {
                        app_y = app_y.substring(1);
                    }
                    linkedHashMap.put("app_y", app_y);
                }
                if (!TextUtils.isEmpty(app_n)) {
                    if (app_n.startsWith(Consts.DOT)) {
                        app_n = app_n.substring(1);
                    }
                    linkedHashMap.put(AliyunLogKey.KEY_APP_NAME, app_n);
                }
            }
            return p.a(linkedHashMap);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
