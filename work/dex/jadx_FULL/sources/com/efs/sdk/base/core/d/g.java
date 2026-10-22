package com.efs.sdk.base.core.d;

import com.ali.auth.third.login.LoginConstants;
import com.efs.sdk.base.core.controller.ControllerCenter;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class g extends com.efs.sdk.base.core.d.a {
    private ConcurrentHashMap<String, a> b = new ConcurrentHashMap<>(10);

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f29605a;
        String b;
        String c;
        AtomicInteger d = new AtomicInteger(0);

        public a(String str, String str2, String str3) {
            this.f29605a = str;
            this.b = str2;
            this.c = str3;
        }
    }

    public final void a(String str, String str2, String str3) {
        String str4 = str + LoginConstants.UNDER_LINE + str2 + LoginConstants.UNDER_LINE + str3.trim();
        if (!this.b.containsKey(str4) || this.b.get(str4) == null) {
            this.b.putIfAbsent(str4, new a(str, str2, str3));
        }
        this.b.get(str4).d.incrementAndGet();
    }

    @Override // com.efs.sdk.base.core.d.a
    public final void a() {
        try {
            if (this.f29600a != null && ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
                Iterator<Map.Entry<String, a>> it = this.b.entrySet().iterator();
                while (it.hasNext()) {
                    a value = it.next().getValue();
                    int i = value.d.get();
                    if (i > 0) {
                        ControllerCenter controllerCenter = this.f29600a;
                        String str = value.f29605a;
                        String str2 = value.b;
                        String str3 = value.c;
                        b bVar = new b("efs_core", "req_succ_rate", f.a.f29604a.f29603a.c);
                        bVar.put("rep_code", str);
                        bVar.put("px_code", str2);
                        bVar.put("path", str3);
                        bVar.put("cnt", Integer.valueOf(i));
                        controllerCenter.send(bVar);
                        value.d.addAndGet(i * (-1));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }
}
