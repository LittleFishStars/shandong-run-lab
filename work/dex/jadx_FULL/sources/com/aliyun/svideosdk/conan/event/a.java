package com.aliyun.svideosdk.conan.event;

import com.aliyun.svideosdk.conan.AlivcConan;
import com.aliyun.vod.log.struct.AliyunLogKey;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, String> f25696a;
    private Map<String, String> b;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static a f25697a = new a();
    }

    private a() {
    }

    private void a(Map<String, String> map, Map<String, String> map2) {
        if (map == null || map2 == null) {
            return;
        }
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                map2.put(entry.getKey(), entry.getValue());
            }
        } catch (Throwable unused) {
        }
    }

    public static a b() {
        return b.f25697a;
    }

    private void d() {
        if (this.b == null) {
            this.b = new HashMap();
        }
        this.b.put(AliyunLogKey.KEY_LOG_VERSION, "2.0");
        this.b.put("conan_version", AlivcConan.getSDKVersion());
        if (com.aliyun.svideosdk.conan.b.l() != null) {
            this.b.put("tt", com.aliyun.svideosdk.conan.b.m());
        }
        this.b.put("dm", com.aliyun.svideosdk.conan.b.g());
        this.b.put("os", "android");
        this.b.put(AliyunLogKey.KEY_OSVERSION, com.aliyun.svideosdk.conan.b.j());
        this.b.put("uuid", com.aliyun.svideosdk.conan.b.h());
        if (com.aliyun.svideosdk.conan.b.l() != null) {
            this.b.put("app_id", com.aliyun.svideosdk.conan.b.l().getPackageName());
        }
        this.b.put("bi", "");
    }

    private void e() {
        if (this.f25696a == null) {
            this.f25696a = new HashMap();
        }
        if (com.aliyun.svideosdk.conan.b.l() != null) {
            this.f25696a.put("gl_v", com.aliyun.svideosdk.conan.b.k());
        }
        this.f25696a.put("db", com.aliyun.svideosdk.conan.b.e());
        this.f25696a.put("dma", com.aliyun.svideosdk.conan.b.f());
        this.f25696a.put(com.alipay.sdk.m.m.b.m, com.aliyun.svideosdk.conan.b.d());
        this.f25696a.put("ci", com.aliyun.svideosdk.conan.b.c());
        this.f25696a.put("gi", com.aliyun.svideosdk.conan.b.i());
    }

    public Map<String, String> a() {
        if (this.b == null) {
            d();
        }
        HashMap map = new HashMap();
        a(this.b, map);
        return map;
    }

    public void a(com.aliyun.svideosdk.conan.c cVar) {
        if (this.b == null) {
            d();
        }
        Map<String, String> map = this.b;
        StringBuilder sb = new StringBuilder();
        if (cVar == null) {
            cVar = com.aliyun.svideosdk.conan.c.EN_ONLINE;
        }
        sb.append(cVar.a());
        sb.append("");
        map.put("se", sb.toString());
    }

    public void a(String str) {
        if (this.b == null) {
            d();
        }
        this.b.put(AliyunLogKey.KEY_APP_NAME, str);
    }

    public void b(String str) {
        if (this.b == null) {
            d();
        }
        this.b.put("app_v", str);
    }

    public Map<String, String> c() {
        if (this.f25696a == null) {
            e();
        }
        HashMap map = new HashMap();
        a(this.f25696a, map);
        return map;
    }
}
