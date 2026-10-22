package com.zj.adlib;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.amap.api.col.p0003l.p;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class n4b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile b f43448a = new b(0);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public r8b f18351a = new r8b("HttpsDecisionUtil");

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static n4b f43449a = new n4b();
    }

    public static n4b a() {
        return a.f43449a;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("https")) {
            return str;
        }
        try {
            Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
            builderBuildUpon.scheme("https");
            return builderBuildUpon.build().toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    public static void f(Context context) {
        g(context, true);
    }

    public static void g(Context context, boolean z) {
        SharedPreferences.Editor editorB = r8b.b(context, "open_common");
        r8b.j(editorB, "a3", z);
        r8b.e(editorB);
    }

    public static boolean i() {
        return false;
    }

    public final void c(Context context) {
        if (this.f43448a == null) {
            this.f43448a = new b((byte) 0);
        }
        this.f43448a.b(r8b.k(context, "open_common", "a3", true));
        this.f43448a.a(context);
        p.a(context).b();
    }

    public final void d(Context context, boolean z) {
        if (this.f43448a == null) {
            this.f43448a = new b((byte) 0);
        }
        g(context, z);
        this.f43448a.b(z);
    }

    public final boolean e(boolean z) {
        if (i()) {
            return false;
        }
        return z || h();
    }

    public final boolean h() {
        if (this.f43448a == null) {
            this.f43448a = new b((byte) 0);
        }
        return this.f43448a.c();
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f43450a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f18352a;
        public final boolean b;
        public boolean c;

        public b() {
            this.f43450a = 0;
            this.f18352a = true;
            this.b = true;
            this.c = false;
        }

        public final void a(Context context) {
            if (context != null && this.f43450a <= 0) {
                this.f43450a = context.getApplicationContext().getApplicationInfo().targetSdkVersion;
            }
        }

        public final void b(boolean z) {
            this.f18352a = z;
        }

        /* JADX WARN: Code duplicated, block: B:19:0x0022  */
        public final boolean c() {
            boolean z;
            if (!this.c) {
                boolean z2 = Build.VERSION.SDK_INT >= 28;
                if (this.f18352a) {
                    int i = this.f43450a;
                    if (i <= 0) {
                        i = 28;
                    }
                    if (i >= 28) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = true;
                }
                if (!(z2 && z)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ b(byte b) {
            this();
        }
    }
}
