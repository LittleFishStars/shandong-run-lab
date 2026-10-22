package com.ipd.dsp.internal.c1;

import android.text.TextUtils;
import com.ipd.dsp.internal.e1.d;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap<String, b> f38213a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f38214a = new c();
    }

    public static b a(d dVar, com.ipd.dsp.internal.j1.b bVar) {
        if (dVar == null || TextUtils.isEmpty(dVar.r.k)) {
            return null;
        }
        String str = dVar.r.k;
        c cVar = a.f38214a;
        if (!cVar.a().containsKey(str)) {
            cVar.a().put(str, new b(dVar, bVar));
        }
        return cVar.a().get(str);
    }

    public final HashMap<String, b> a() {
        if (this.f38213a == null) {
            this.f38213a = new HashMap<>();
        }
        return this.f38213a;
    }

    public static void a(d dVar) {
        if (dVar == null || TextUtils.isEmpty(dVar.r.k)) {
            return;
        }
        a.f38214a.a().remove(dVar.r.k);
    }
}
