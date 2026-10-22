package com.fl.saas;

import android.content.Context;
import com.fl.saas.adx.util.FLImageLoader;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class g1 {
    private static volatile g1 d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private V f30172a;
    private long b = 314572800;
    private Map c = new HashMap();

    public class a implements Q {
        public a() {
        }

        @Override // com.fl.saas.Q
        public Map a(String str) {
            return g1.this.c;
        }
    }

    private V b(Context context) {
        long availableStorageSpace = FLImageLoader.getAvailableStorageSpace();
        long totalStorageSpace = FLImageLoader.getTotalStorageSpace();
        if (availableStorageSpace < 314572800) {
            this.b = Math.min((long) (totalStorageSpace * 0.005d), (availableStorageSpace * 5) / 10);
        }
        return new V.b(context).a(AbstractC1431r.a(context)).a(new a()).a(this.b).a();
    }

    public static g1 a() {
        if (d == null) {
            synchronized (g1.class) {
                if (d == null) {
                    d = new g1();
                }
            }
        }
        return d;
    }

    public V a(Context context) {
        if (this.f30172a == null && context != null) {
            this.f30172a = b(context);
        }
        return this.f30172a;
    }

    public String a(Context context, f1 f1Var) {
        String strA = a().a(context.getApplicationContext()).a(f1Var.a(), false);
        C1440v0.a().a(f1Var.a(), f1Var.b());
        return strA;
    }
}
