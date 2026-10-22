package com.zj.adlib;

import android.content.Context;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.amap.api.col.p0003l.hl;
import com.autonavi.aps.amapapi.trans.b;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class zma {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public hl f46297a;

    public zma(Context context) {
        this.f46297a = null;
        try {
            n4b.a().c(context);
        } catch (Throwable unused) {
        }
        this.f46297a = hl.b();
    }

    public static Map<String, String> e(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        HashMap map = new HashMap(16);
        map.put(CachedContentIndex.a.e, j4b.j(context));
        if (!TextUtils.isEmpty(str)) {
            map.put("keywords", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            map.put("types", str2);
        }
        if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
            map.put(RequestParameters.SUBRESOURCE_LOCATION, str6 + "," + str5);
        }
        if (!TextUtils.isEmpty(str3)) {
            map.put("city", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            map.put(TypedValues.CycleType.S_WAVE_OFFSET, str4);
        }
        if (!TextUtils.isEmpty(str7)) {
            map.put("radius", str7);
        }
        return map;
    }

    public final String a(Context context, String str, String str2) {
        Map<String, String> mapE = e(context, str2, null, null, null, null, null, null);
        mapE.put("extensions", "all");
        mapE.put("subdistrict", "0");
        return d(context, str, mapE);
    }

    public final String b(Context context, String str, String str2, String str3, String str4, String str5) {
        Map<String, String> mapE = e(context, str2, str3, str4, str5, null, null, null);
        mapE.put("children", "1");
        mapE.put("page", "1");
        mapE.put("extensions", "base");
        return d(context, str, mapE);
    }

    public final String c(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Map<String, String> mapE = e(context, str2, str3, null, str4, str5, str6, str7);
        mapE.put("children", "1");
        mapE.put("page", "1");
        mapE.put("extensions", "base");
        return d(context, str, mapE);
    }

    public final String d(Context context, String str, Map<String, String> map) {
        try {
            HashMap map2 = new HashMap(16);
            b bVar = new b();
            map2.clear();
            map2.put("Content-Type", "application/x-www-form-urlencoded");
            map2.put("Connection", com.google.common.net.b.t0);
            map2.put("User-Agent", "AMAP_Location_SDK_Android 6.1.0");
            String strA = l4b.a();
            String strC = l4b.c(context, strA, s4b.s(map));
            map.put("ts", strA);
            map.put("scode", strC);
            bVar.b(map);
            bVar.a(map2);
            bVar.a(str);
            bVar.setProxy(q4b.c(context));
            bVar.setConnectionTimeout(com.autonavi.aps.amapapi.utils.b.i);
            bVar.setSoTimeout(com.autonavi.aps.amapapi.utils.b.i);
            try {
                return new String(hl.e(bVar).f17171a, "utf-8");
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "GeoFenceNetManager", "post");
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }
}
