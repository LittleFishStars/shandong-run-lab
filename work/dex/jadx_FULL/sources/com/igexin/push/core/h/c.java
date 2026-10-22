package com.igexin.push.core.h;

import android.util.Base64;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.config.a.AnonymousClass6;
import com.igexin.push.config.a.AnonymousClass7;
import com.igexin.push.config.g;
import com.igexin.push.core.a.b.h;
import com.igexin.push.core.e.f;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class c extends com.igexin.push.f.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38053a = "GetIDCConfigHttpPlugin";
    public static JSONArray b;

    public c(String str, JSONArray jSONArray) {
        super(str);
        b = jSONArray;
    }

    private static void a(JSONArray jSONArray) {
        b = jSONArray;
    }

    @Override // com.igexin.push.f.a.d
    public final void a(Exception exc) {
        f.a().b(System.currentTimeMillis());
        com.igexin.c.a.c.a.a(exc);
    }

    @Override // com.igexin.push.f.a.d
    public final void a(byte[] bArr) throws Exception {
        if (bArr != null) {
            try {
                String str = new String(com.igexin.c.b.a.c(Base64.decode(bArr, 0)));
                com.igexin.c.a.c.a.a("->get idc config server resp data : ".concat(str), new Object[0]);
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.config.a.a().new AnonymousClass7(str), true, false);
                g.a(str, true);
                f.a().b(0L);
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.config.a.a().new AnonymousClass6(b.toString()), true, false);
                SDKUrlConfig.setIdcConfigUrl(h.a(b));
            } catch (Exception e) {
                f.a().b(System.currentTimeMillis());
                throw e;
            }
        }
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return 0;
    }
}
