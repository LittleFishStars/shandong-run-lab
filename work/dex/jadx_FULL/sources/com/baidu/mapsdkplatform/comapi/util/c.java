package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.zj.adlib.c30;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ExecutorService f26687a = Executors.newSingleThreadExecutor();
    private static int b = -1;
    private static int c = -1;
    private int d;
    private int e;
    private Context f;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f26688a;

        public a(String str) {
            this.f26688a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            int unused = c.b = c.this.f.getSharedPreferences("ad_auth", 0).getInt(this.f26688a, 0);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f26689a;

        public b(String str) {
            this.f26689a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            int unused = c.c = c.this.f.getSharedPreferences("ad_auth", 0).getInt(this.f26689a, 0);
        }
    }

    /* JADX INFO: renamed from: com.baidu.mapsdkplatform.comapi.util.c$c, reason: collision with other inner class name */
    public class RunnableC0275c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f26690a;
        final /* synthetic */ int b;

        public RunnableC0275c(String str, int i) {
            this.f26690a = str;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f.getSharedPreferences("ad_auth", 0).edit().putInt(this.f26690a, this.b).apply();
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f26691a;
        final /* synthetic */ int b;

        public d(String str, int i) {
            this.f26691a = str;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f.getSharedPreferences("ad_auth", 0).edit().putInt(this.f26691a, this.b).apply();
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f26692a = new c(null);
    }

    public /* synthetic */ c(a aVar) {
        this();
    }

    public void c(int i) {
        if (i == -1 && (i = a("ad_key")) == -101) {
            return;
        }
        this.d = i;
        a("ad_key", i);
    }

    public void d(int i) {
        if (i == -1 && (i = b("ad_key_user")) == -101) {
            return;
        }
        this.e = i;
        b("ad_key_user", i);
    }

    public boolean e() {
        int i = this.d;
        return i >= 0 && (i & 65536) == 65536;
    }

    public boolean f() {
        int i = this.d;
        return i >= 0 && (i & 1073741824) == 1073741824;
    }

    public boolean g() {
        int i = this.d;
        return i >= 0 && (i & 1) == 1;
    }

    public boolean h() {
        int i = this.e;
        return i >= 0 && (i & 268435456) == 268435456;
    }

    public boolean i() {
        int i = this.d;
        return i >= 0 && (i & 1024) == 1024;
    }

    private c() {
    }

    private int b(String str) {
        if (this.f == null) {
            return c30.h;
        }
        if (c == -1) {
            f26687a.execute(new b(str));
        }
        return c;
    }

    public static c a() {
        return e.f26692a;
    }

    public void a(Context context) {
        this.f = context;
    }

    public boolean c() {
        int i = this.d;
        return i >= 0 && (i & TTAdConstant.KEY_CLICK_AREA) == 67108864;
    }

    public boolean d() {
        int i = this.d;
        return i >= 0 && (i & 134217728) == 134217728;
    }

    private int a(String str) {
        if (this.f == null) {
            return c30.h;
        }
        if (b == -1) {
            f26687a.execute(new a(str));
        }
        return b;
    }

    private void b(String str, int i) {
        if (this.f == null) {
            return;
        }
        c = i;
        f26687a.execute(new d(str, i));
    }

    private void a(String str, int i) {
        if (this.f == null) {
            return;
        }
        b = i;
        f26687a.execute(new RunnableC0275c(str, i));
    }

    public boolean b() {
        int i = this.d;
        return i >= 0 && (i & 33554432) == 33554432;
    }
}
