package com.baidu.b.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.b.h;
import java.util.Comparator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Comparator f26261a = new com.baidu.b.b.b();
    protected C0256a b;
    protected com.baidu.b.e.a.C0258a c;
    private final String d;
    private long e;

    /* JADX INFO: renamed from: com.baidu.b.b.a$a, reason: collision with other inner class name */
    public static class C0256a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f26262a;
        public com.baidu.b.e.a b;
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.baidu.b.e.a.C0258a f26263a;
        private String b;
        private String c;
        private boolean d = true;

        public b(com.baidu.b.e.a.C0258a c0258a, String str) {
            this.f26263a = c0258a;
            this.b = str;
            this.c = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public abstract void a(JSONObject jSONObject) throws JSONException;

        public void a(boolean z) {
            this.d = z;
        }

        public boolean a() {
            String strA = this.f26263a.a(this.c, true);
            if (!TextUtils.isEmpty(strA)) {
                try {
                    a(new JSONObject(strA));
                    a(false);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public abstract void b(JSONObject jSONObject) throws JSONException;

        public boolean b() {
            if (this.d) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    b(jSONObject);
                    this.f26263a.a(this.c, jSONObject.toString(), true);
                    a(false);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public static class c {
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f26264a;
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h.a f26265a;
        public int b;
        public Exception c;

        public e(int i, h.a aVar, Exception exc) {
            this.b = i;
            this.f26265a = aVar;
            this.c = exc;
        }

        public static e a() {
            return new e(-1, null, null);
        }

        public static e a(int i) {
            return new e(i, null, null);
        }

        public static e a(h.a aVar) {
            return new e(0, aVar, null);
        }

        public boolean b() {
            return this.b == 0;
        }
    }

    public a(String str, long j) {
        this.d = str;
        this.e = j;
    }

    public abstract e a(String str, d dVar);

    public String a() {
        return this.d;
    }

    public final void a(C0256a c0256a) {
        this.b = c0256a;
        this.c = c0256a.b.b().a("cs");
    }

    public abstract void a(c cVar);

    public long b() {
        return this.e;
    }
}
