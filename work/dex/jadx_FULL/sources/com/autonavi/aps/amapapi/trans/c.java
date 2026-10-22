package com.autonavi.aps.amapapi.trans;

import android.content.Context;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.aliyun.credentials.utils.AuthConstant;
import com.amap.api.col.p0003l.hl;
import com.amap.api.col.p0003l.hs;
import com.amap.api.maps.AMap;
import com.autonavi.aps.amapapi.utils.i;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.zj.adlib.i9b;
import com.zj.adlib.j4b;
import com.zj.adlib.l4b;
import com.zj.adlib.n4b;
import com.zj.adlib.q4b;
import com.zj.adlib.s4b;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class c {
    private static c b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    hl f26197a;
    private Context c;
    private int d = com.autonavi.aps.amapapi.utils.b.i;
    private boolean e = false;
    private int f = 0;

    private c(Context context) {
        this.f26197a = null;
        this.c = null;
        try {
            n4b.a().c(context);
        } catch (Throwable unused) {
        }
        this.c = context;
        this.f26197a = hl.b();
    }

    public static c a(Context context) {
        if (b == null) {
            b = new c(context);
        }
        return b;
    }

    public final void a(long j, boolean z, int i) {
        try {
            this.e = z;
            this.d = Long.valueOf(j).intValue();
            this.f = i;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "LocNetManager", "setOption");
        }
    }

    public final d a(Context context, byte[] bArr, String str, String str2, boolean z) {
        try {
            HashMap map = new HashMap(16);
            d dVar = new d(context, com.autonavi.aps.amapapi.utils.b.c());
            try {
                map.put("Content-Type", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
                map.put("Accept-Encoding", "gzip");
                map.put("gzipped", "1");
                map.put("Connection", com.google.common.net.b.t0);
                map.put("User-Agent", "AMAP_Location_SDK_Android 6.1.0");
                map.put("KEY", j4b.j(context));
                map.put("enginever", com.autonavi.aps.amapapi.utils.b.f26202a);
                String strA = l4b.a();
                String strC = l4b.c(context, strA, "key=" + j4b.j(context));
                map.put("ts", strA);
                map.put("scode", strC);
                if (Double.valueOf(com.autonavi.aps.amapapi.utils.b.f26202a).doubleValue() >= 5.3d) {
                    map.put("aps_s_src", "openapi");
                }
                map.put("encr", "1");
                dVar.b(map);
                String str3 = z ? "loc" : "locf";
                dVar.b(true);
                dVar.a(String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "6.1.0", str3, 3));
                dVar.a(z);
                dVar.b(str);
                dVar.c(str2);
                dVar.c(i.a(bArr));
                dVar.setProxy(q4b.c(context));
                HashMap map2 = new HashMap(16);
                map2.put(com.alibaba.ariver.remotedebug.b.c.g, "bin");
                map2.put(AuthConstant.INI_POLICY, "3103");
                int i = this.f;
                if (i == 0) {
                    map2.remove("custom");
                } else if (i == 1) {
                    map2.put("custom", "language:cn");
                } else if (i != 2) {
                    map2.remove("custom");
                } else {
                    map2.put("custom", "language:en");
                }
                dVar.a(map2);
                dVar.setConnectionTimeout(this.d);
                dVar.setSoTimeout(this.d);
                if (!this.e) {
                    return dVar;
                }
                dVar.setHttpProtocol(hs.c.HTTPS);
                return dVar;
            } catch (Throwable unused) {
                return dVar;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public final i9b a(d dVar) throws Throwable {
        if (this.e) {
            dVar.setHttpProtocol(hs.c.HTTPS);
        }
        return hl.e(dVar);
    }

    public final String a(Context context, double d, double d2) {
        try {
            HashMap map = new HashMap(16);
            d dVar = new d(context, com.autonavi.aps.amapapi.utils.b.c());
            map.clear();
            map.put("Content-Type", "application/x-www-form-urlencoded");
            map.put("Connection", com.google.common.net.b.t0);
            map.put("User-Agent", "AMAP_Location_SDK_Android 6.1.0");
            HashMap map2 = new HashMap(16);
            map2.put("custom", "26260A1F00020002");
            map2.put(CachedContentIndex.a.e, j4b.j(context));
            int i = this.f;
            if (i == 0) {
                map2.remove(MediaFormat.KEY_LANGUAGE);
            } else if (i == 1) {
                map2.put(MediaFormat.KEY_LANGUAGE, "zh-CN");
            } else if (i != 2) {
                map2.remove(MediaFormat.KEY_LANGUAGE);
            } else {
                map2.put(MediaFormat.KEY_LANGUAGE, AMap.ENGLISH);
            }
            map2.put("curLocationType", i.m(this.c) ? "coarseLoc" : "fineLoc");
            String strA = l4b.a();
            String strC = l4b.c(context, strA, s4b.s(map2));
            map2.put("ts", strA);
            map2.put("scode", strC);
            dVar.b(("output=json&radius=1000&extensions=all&location=" + d2 + "," + d).getBytes("UTF-8"));
            dVar.b(false);
            dVar.a(true);
            dVar.a(String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "6.1.0", "loc", 3));
            dVar.a(map2);
            dVar.b(map);
            dVar.setProxy(q4b.c(context));
            dVar.setConnectionTimeout(com.autonavi.aps.amapapi.utils.b.i);
            dVar.setSoTimeout(com.autonavi.aps.amapapi.utils.b.i);
            try {
                dVar.c("http://dualstack-arestapi.amap.com/v3/geocode/regeo");
                dVar.b("http://restsdk.amap.com/v3/geocode/regeo");
                if (this.e) {
                    dVar.setHttpProtocol(hs.c.HTTPS);
                }
                return new String(hl.e(dVar).f17171a, "utf-8");
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "LocNetManager", "post");
                return null;
            }
        } catch (Throwable unused) {
        }
    }
}
