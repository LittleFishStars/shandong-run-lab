package com.zj.adlib;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class c7b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r4b f40916a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static Map<String, c7b> f40917a = new HashMap();
    }

    public c7b(r4b r4bVar) {
        this.f40916a = r4bVar;
    }

    public static c7b a(r4b r4bVar) {
        if (a.f40917a.get(r4bVar.a()) == null) {
            a.f40917a.put(r4bVar.a(), new c7b(r4bVar));
        }
        return a.f40917a.get(r4bVar.a());
    }

    public final void b(Context context, boolean z, boolean z2) {
        f7b.b(context, this.f40916a, "sckey", String.valueOf(z));
        if (z) {
            f7b.b(context, this.f40916a, "scisf", String.valueOf(z2));
        }
    }

    public final boolean c(Context context) {
        try {
            return Boolean.parseBoolean(f7b.a(context, this.f40916a, "sckey"));
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean d(Context context) {
        try {
            return Boolean.parseBoolean(f7b.a(context, this.f40916a, "scisf"));
        } catch (Throwable unused) {
            return true;
        }
    }
}
