package com.baidu.a;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class i implements g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f26251a;
    private final a b;
    private final a.EnumC0254a c;
    private final g d;

    public i(Context context) {
        a aVarA = a.a(context);
        this.b = aVarA;
        this.f26251a = aVarA.a();
        this.c = aVarA.c();
        this.d = aVarA.d();
    }

    @Override // com.baidu.a.g.a
    public void a(int i, g.d dVar, Map<String, g.e> map, String str) {
        if (i != -1) {
            if (i != 0) {
                j.a("Internal error: async httpdns resolve completion get error ret(%d)", Integer.valueOf(i));
            } else {
                for (Map.Entry<String, g.e> entry : map.entrySet()) {
                    String key = entry.getKey();
                    g.e value = entry.getValue();
                    if (value != null) {
                        f.a aVar = new f.a();
                        aVar.a(value.c());
                        aVar.b(System.currentTimeMillis() / 1000);
                        aVar.a(value.a());
                        aVar.b(value.b());
                        this.f26251a.a(key, aVar);
                    } else if (this.c == a.EnumC0254a.POLICY_TOLERANT) {
                        this.f26251a.b(key);
                    }
                }
            }
        } else if (dVar.equals(g.d.DNLIST_HOSTS) && this.c == a.EnumC0254a.POLICY_TOLERANT) {
            for (String str2 : str.split(",")) {
                this.f26251a.b(str2);
            }
        }
        if (this.b.e() <= 0 || this.d.f()) {
            return;
        }
        this.d.b(true);
        j.a("preResolve has finished", new Object[0]);
    }
}
