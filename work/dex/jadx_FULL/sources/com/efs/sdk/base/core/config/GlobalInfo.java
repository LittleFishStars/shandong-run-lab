package com.efs.sdk.base.core.config;

import android.content.Context;
import android.text.TextUtils;
import com.efs.sdk.base.core.a.a;
import com.efs.sdk.base.core.util.c;
import com.efs.sdk.base.protocol.file.section.AbsSection;
import com.efs.sdk.base.protocol.file.section.KVSection;
import com.huachenjie.common.constants.UserConstants;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.igexin.push.core.b;
import com.zj.adlib.dv9;
import com.zj.adlib.ze1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class GlobalInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Object> f29586a = new ConcurrentHashMap();

    public final void a(String str, Object obj) {
        if (obj != null) {
            this.f29586a.put(str, obj);
        }
    }

    public final Object b(String str, Object obj) {
        Object obj2 = this.f29586a.get(str);
        return (obj2 != null || this.f29586a.containsKey(str)) ? obj2 : obj;
    }

    public Map<String, Object> getGlobalInfoMap() {
        HashMap map = new HashMap(this.f29586a);
        a.a();
        map.put("ctime", Long.valueOf(a.b() / 1000));
        a.a();
        map.put("w_tm", Long.valueOf(a.b() / 1000));
        return map;
    }

    public List<AbsSection> getGlobalSectionList(String str) {
        ArrayList arrayList = new ArrayList();
        KVSection kVSection = new KVSection("global_head");
        KVSection kVSectionPut = kVSection.put("type", str).put("appid", this.f29586a.get("appid")).put("wid", this.f29586a.get("wid")).put("pid", this.f29586a.get("pid")).put(b.aC, this.f29586a.get(b.aC)).put("ver", this.f29586a.get("ver")).put("vcode", this.f29586a.get("vcode")).put("ps", this.f29586a.get("ps")).put("stime", this.f29586a.get("stime"));
        a.a();
        KVSection kVSectionPut2 = kVSectionPut.put("ctime", Long.valueOf(a.b() / 1000));
        a.a();
        kVSectionPut2.put("w_tm", Long.valueOf(a.b() / 1000)).put(HiAnalyticsConstant.BI_KEY_SDK_VER, this.f29586a.get(HiAnalyticsConstant.BI_KEY_SDK_VER));
        String strValueOf = String.valueOf(b(UserConstants.URL_PARAMS.b, ""));
        if (!TextUtils.isEmpty(strValueOf)) {
            kVSection.put(UserConstants.URL_PARAMS.b, strValueOf);
        }
        arrayList.add(kVSection);
        KVSection kVSection2 = new KVSection("device_info");
        kVSection2.put(dv9.h, this.f29586a.get(dv9.h)).put("brand", this.f29586a.get("brand")).put(ze1.k, this.f29586a.get(ze1.k)).put("build_model", this.f29586a.get("build_model")).put("rom", this.f29586a.get("rom")).put("sdk", this.f29586a.get("sdk")).put("dsp_h", this.f29586a.get("dsp_h")).put("dsp_w", this.f29586a.get("dsp_w")).put("tzone", this.f29586a.get("tzone")).put("net", this.f29586a.get("net")).put("fr", this.f29586a.get("fr"));
        try {
            if (this.f29586a.containsKey("um_access")) {
                kVSection2.put("um_access", this.f29586a.get("um_access"));
            }
            if (this.f29586a.containsKey("um_access_subtype")) {
                kVSection2.put("um_access_subtype", this.f29586a.get("um_access_subtype"));
            }
            if (this.f29586a.containsKey("um_network_type")) {
                kVSection2.put("um_network_type", this.f29586a.get("um_network_type"));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        arrayList.add(kVSection2);
        return arrayList;
    }

    public String getUUID(Context context) {
        String strValueOf = String.valueOf(b("wid", ""));
        if (!TextUtils.isEmpty(strValueOf)) {
            return strValueOf;
        }
        String strA = c.a(context);
        a("wid", strA);
        return strA;
    }
}
