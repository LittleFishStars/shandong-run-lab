package com.zj.adlib;

import android.text.TextUtils;
import com.alipay.sdk.m.y.l;
import com.amap.api.col.p0003l.ff;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.amap.api.col.p0003l.gx(a = "a")
public final class r4b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.amap.api.col.p0003l.gy(a = "a6", b = 2)
    public int f44369a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @com.amap.api.col.p0003l.gy(a = "a1", b = 6)
    public String f19228a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String[] f19229a;

    @com.amap.api.col.p0003l.gy(a = "a2", b = 6)
    public String b;

    @com.amap.api.col.p0003l.gy(a = "a3", b = 6)
    public String c;

    @com.amap.api.col.p0003l.gy(a = "a4", b = 6)
    public String d;

    @com.amap.api.col.p0003l.gy(a = "a5", b = 6)
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f44370a;
        public String b;
        public String c;
        public String d;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f19230a = true;
        public String e = "standard";

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String[] f19231a = null;

        public a(String str, String str2, String str3) {
            this.f44370a = str2;
            this.b = str2;
            this.d = str3;
            this.c = str;
        }

        public final a a(String str) {
            this.b = str;
            return this;
        }

        public final a b(String[] strArr) {
            if (strArr != null) {
                this.f19231a = (String[]) strArr.clone();
            }
            return this;
        }

        public final r4b c() throws ff {
            if (this.f19231a != null) {
                return new r4b(this, (byte) 0);
            }
            throw new ff("sdk packages is null");
        }
    }

    public /* synthetic */ r4b(a aVar, byte b) {
        this(aVar);
    }

    public static String b(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            for (String str : strArr) {
                sb.append(str);
                sb.append(l.b);
            }
            return sb.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String[] d(String str) {
        try {
            return str.split(l.b);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final String a() {
        if (TextUtils.isEmpty(this.i) && !TextUtils.isEmpty(this.f19228a)) {
            this.i = s4b.v(this.f19228a);
        }
        return this.i;
    }

    public final void c(boolean z) {
        this.f44369a = z ? 1 : 0;
    }

    public final String e() {
        return this.f;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (r4b.class != obj.getClass()) {
            return false;
        }
        try {
            return this.i.equals(((r4b) obj).i) && this.f.equals(((r4b) obj).f) && this.g.equals(((r4b) obj).g);
        } catch (Throwable unused) {
        }
    }

    public final String f() {
        if (TextUtils.isEmpty(this.g) && !TextUtils.isEmpty(this.b)) {
            this.g = s4b.v(this.b);
        }
        return this.g;
    }

    public final String g() {
        if (TextUtils.isEmpty(this.j) && !TextUtils.isEmpty(this.e)) {
            this.j = s4b.v(this.e);
        }
        if (TextUtils.isEmpty(this.j)) {
            this.j = "standard";
        }
        return this.j;
    }

    public final boolean h() {
        return this.f44369a == 1;
    }

    public final String[] i() {
        String[] strArr = this.f19229a;
        if ((strArr == null || strArr.length == 0) && !TextUtils.isEmpty(this.d)) {
            this.f19229a = d(s4b.v(this.d));
        }
        return (String[]) this.f19229a.clone();
    }

    public r4b() {
        this.f44369a = 1;
        this.f19229a = null;
    }

    public r4b(a aVar) {
        this.f44369a = 1;
        this.f19229a = null;
        this.f = aVar.f44370a;
        this.g = aVar.b;
        this.i = aVar.c;
        this.h = aVar.d;
        this.f44369a = aVar.f19230a ? 1 : 0;
        this.j = aVar.e;
        this.f19229a = aVar.f19231a;
        this.b = s4b.r(this.g);
        this.f19228a = s4b.r(this.i);
        this.c = s4b.r(this.h);
        this.d = s4b.r(b(this.f19229a));
        this.e = s4b.r(this.j);
    }
}
