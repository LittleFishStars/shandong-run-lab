package com.efs.sdk.net.a.a;

import android.text.TextUtils;
import com.acse.ottn.p3;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.net.NetManager;
import com.huawei.hms.utils.FileUtil;
import com.zj.adlib.ze1;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class g implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicInteger f29912a = new AtomicInteger(0);
    private static g c;
    private b b = new b();

    private g() {
    }

    public static g c() {
        if (c == null) {
            c = new g();
        }
        return c;
    }

    @Override // com.efs.sdk.net.a.a.f
    public final void a(f.b bVar) {
        String str;
        Log.d("NetTrace-Interceptor", "request will be sent");
        b bVar2 = this.b;
        try {
            String strA = bVar.a();
            bVar2.f29908a.put(bVar.a(), Long.valueOf(System.currentTimeMillis()));
            Log.i("NetTrace-Interceptor", "save request");
            com.efs.sdk.net.a.c cVarA = com.efs.sdk.net.a.a.a().a(strA);
            String strB = bVar.b();
            if (!TextUtils.isEmpty(strB)) {
                cVarA.d = strB;
            }
            cVarA.e = bVar.c();
            HashMap map = new HashMap();
            int iE = bVar.e();
            for (int i = 0; i < iE; i++) {
                map.put(bVar.a(i), bVar.b(i));
            }
            if (NetManager.getNetConfigManager().getNetRequestHeaderCollectState()) {
                cVarA.f = map;
            }
            cVarA.g = b.a(bVar);
            if (NetManager.getNetConfigManager().getNetRequestBodyCollectState()) {
                String str2 = cVarA.e;
                if ((str2 == null || !str2.equalsIgnoreCase(p3.f)) && (str = cVarA.e) != null && str.equalsIgnoreCase("post") && cVarA.g < FileUtil.LOCAL_REPORT_FILE_MAX_SIZE) {
                    if (map.containsKey("Content-Type") || map.containsKey(com.alipay.sdk.m.t.e.f)) {
                        String str3 = (String) map.get("Content-Type");
                        if (TextUtils.isEmpty(str3)) {
                            str3 = (String) map.get(com.alipay.sdk.m.t.e.f);
                        }
                        if (str3 != null) {
                            if (str3.contains(ze1.g) || str3.contains("application/x-www-form-urlencoded")) {
                                cVarA.h = new String(bVar.d());
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.efs.sdk.net.a.a.f
    public final String b() {
        Log.d("NetTrace-Interceptor", "next request id");
        return String.valueOf(f29912a.getAndIncrement());
    }

    @Override // com.efs.sdk.net.a.a.f
    public final void a(f.d dVar) {
        Log.d("NetTrace-Interceptor", "response headers received");
        b bVar = this.b;
        Log.i("NetTrace-Interceptor", "save response");
        String strA = dVar.a();
        if (bVar.f29908a != null) {
            com.efs.sdk.net.a.c cVarA = com.efs.sdk.net.a.a.a().a(strA);
            cVarA.i = dVar.b();
            try {
                if (NetManager.getNetConfigManager().getNetResponseHeaderCollectState()) {
                    HashMap map = new HashMap();
                    int iE = dVar.e();
                    for (int i = 0; i < iE; i++) {
                        map.put(dVar.a(i), dVar.b(i));
                    }
                    cVarA.l = map;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.efs.sdk.net.a.a.f
    @Nullable
    public final InputStream a(String str, @Nullable String str2, @Nullable String str3, @Nullable InputStream inputStream) {
        Log.d("NetTrace-Interceptor", "interpret response stream");
        return b.a(str, str2, str3, inputStream);
    }

    @Override // com.efs.sdk.net.a.a.f
    public final void a() {
        Log.d("NetTrace-Interceptor", "data sent");
    }
}
