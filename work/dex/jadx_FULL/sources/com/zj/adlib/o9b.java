package com.zj.adlib;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.amap.api.col.p0003l.fj;
import com.amap.api.col.p0003l.it;
import com.amap.api.col.p0003l.z;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class o9b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f43700a = 1000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static WeakReference<k9b> f18590a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f18591a = false;
    public static int b = 20;
    public static int c = 10;
    public static int d;

    @Deprecated
    public static synchronized void b(int i, boolean z) {
        f43700a = i;
        f18591a = z;
    }

    public static synchronized void c(int i, boolean z, int i2, int i3) {
        f43700a = i;
        f18591a = z;
        if (i2 < 10 || i2 > 100) {
            i2 = 20;
        }
        b = i2;
        if (i2 / 5 > c) {
            c = i2 / 5;
        }
        d = i3;
    }

    public static void d(Context context) {
        z.g().b(new a(context, 2));
    }

    public static synchronized void e(n9b n9bVar, Context context) {
        z.g().b(new a(context, n9bVar));
    }

    public static class a extends it {
        public int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f43701a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public n9b f18592a;

        public a(Context context, int i) {
            this.f43701a = context;
            this.K = i;
        }

        /* JADX WARN: Bottom block not found for handler: all -> 0x004e */
        @Override // com.amap.api.col.p0003l.it
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void runTask() {
            int i = this.K;
            if (i == 1) {
                synchronized (o9b.class) {
                    try {
                        String string = Long.toString(System.currentTimeMillis());
                        k9b k9bVarA = nbb.a(o9b.f18590a);
                        nbb.f(this.f43701a, k9bVarA, y6b.i, o9b.f43700a, 2097152, "6");
                        if (k9bVarA.f17613a == null) {
                            k9bVarA.f17613a = new y8b(new a9b(new b9b(new a9b())));
                        }
                        l9b.c(string, this.f18592a.b(), k9bVarA);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            }
            if (i == 2) {
                try {
                    k9b k9bVarA2 = nbb.a(o9b.f18590a);
                    nbb.f(this.f43701a, k9bVarA2, y6b.i, o9b.f43700a, 2097152, "6");
                    k9bVarA2.b = 14400000;
                    if (k9bVarA2.f17614a == null) {
                        k9bVarA2.f17614a = new sbb(new qbb(this.f43701a, new wbb(), new y8b(new a9b(new b9b())), new String(s6b.c(10)), j4b.j(this.f43701a), fj.L(), fj.G(), fj.N(this.f43701a), fj.s(), Build.MANUFACTURER, Build.DEVICE, fj.h0(this.f43701a), j4b.g(this.f43701a), Build.MODEL, j4b.h(this.f43701a), j4b.e(this.f43701a), fj.M(this.f43701a), fj.t(this.f43701a), String.valueOf(Build.VERSION.SDK_INT)));
                    }
                    if (TextUtils.isEmpty(k9bVarA2.c)) {
                        k9bVarA2.c = "fKey";
                    }
                    Context context = this.f43701a;
                    k9bVarA2.f17615a = new acb(context, k9bVarA2.b, k9bVarA2.c, new ybb(context, o9b.f18591a, o9b.c * 1024, o9b.b * 1024, "offLocKey", o9b.d * 1024));
                    l9b.a(k9bVarA2);
                } catch (Throwable th2) {
                    a7b.m(th2, "ofm", "uold");
                }
            }
        }

        public a(Context context, n9b n9bVar) {
            this(context, 1);
            this.f18592a = n9bVar;
        }
    }
}
