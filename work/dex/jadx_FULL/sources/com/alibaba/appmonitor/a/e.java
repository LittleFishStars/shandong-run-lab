package com.alibaba.appmonitor.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.analytics.a.j;
import com.alibaba.analytics.a.r;
import com.zj.adlib.ze1;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e {
    private static final Map<String, String> B;

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        B = concurrentHashMap;
        concurrentHashMap.put(ze1.j, com.alibaba.analytics.b.a.a().E());
    }

    private static String F() {
        Object objA;
        try {
            Object objA2 = r.a("com.taobao.updatecenter.hotpatch.HotPatchManager", "getInstance");
            if (objA2 == null || (objA = r.a(objA2, "getPatchSuccessedVersion")) == null) {
                return null;
            }
            return objA + "";
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(Context context, String str) {
        int identifier;
        if (context == null) {
            return null;
        }
        try {
            identifier = context.getResources().getIdentifier(str, TypedValues.Custom.S_STRING, context.getPackageName());
        } catch (Throwable th) {
            j.w("SdkMeta", "getString Id error", th);
            identifier = 0;
        }
        if (identifier != 0) {
            return context.getString(identifier);
        }
        return null;
    }

    public static Map<String, String> d() {
        Context context = com.alibaba.analytics.core.d.a().getContext();
        if (context != null) {
            Map<String, String> map = B;
            if (!map.containsKey("pt")) {
                String strA = a(context, "package_type");
                if (TextUtils.isEmpty(strA)) {
                    map.put("pt", "");
                } else {
                    map.put("pt", strA);
                }
            }
            if (!map.containsKey("pid")) {
                String strA2 = a(context, "project_id");
                if (TextUtils.isEmpty(strA2)) {
                    map.put("pid", "");
                } else {
                    map.put("pid", strA2);
                }
            }
            if (!map.containsKey("bid")) {
                String strA3 = a(context, "build_id");
                if (TextUtils.isEmpty(strA3)) {
                    map.put("bid", "");
                } else {
                    map.put("bid", strA3);
                }
            }
            if (!map.containsKey("bv")) {
                String strA4 = a(context, "base_version");
                if (TextUtils.isEmpty(strA4)) {
                    map.put("bv", "");
                } else {
                    map.put("bv", strA4);
                }
            }
        }
        String strF = F();
        if (TextUtils.isEmpty(strF)) {
            B.put("hv", "");
        } else {
            B.put("hv", strF);
        }
        Map<String, String> map2 = B;
        if (!map2.containsKey(ze1.j)) {
            map2.put(ze1.j, com.alibaba.analytics.b.a.a().E());
        }
        return map2;
    }
}
