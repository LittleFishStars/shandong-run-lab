package com.igexin.push.c;

import com.ali.auth.third.login.LoginConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class d {
    private static final String f = "DT_DetectResult";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f37890a;
    int b;
    private String g;
    private int h;
    private int i;
    long c = 2147483647L;
    long d = -1;
    boolean e = true;
    private final int j = 1;

    public d() {
    }

    public d(String str, int i) {
        this.g = str;
        this.b = i;
    }

    private void a(int i) {
        this.b = i;
    }

    private void a(long j) {
        this.c = j;
    }

    private void b(long j) {
        this.d = j;
    }

    private void b(String str) {
        this.f37890a = str;
    }

    private void b(boolean z) {
        this.e = z;
    }

    private String g() {
        return this.f37890a;
    }

    private int h() {
        return this.b;
    }

    private void i() {
        this.f37890a = null;
        this.h = 0;
        this.e = true;
    }

    private boolean j() {
        return this.f37890a != null && System.currentTimeMillis() - this.d <= b.d && this.h <= 0;
    }

    public final synchronized String a() {
        return this.g;
    }

    public final synchronized String a(boolean z) {
        if (j()) {
            if (z) {
                this.h++;
            }
            this.e = false;
            return this.f37890a;
        }
        this.f37890a = null;
        this.h = 0;
        this.e = true;
        com.igexin.c.a.c.a.a("DT_DetectResult|disc, ip is invalid, use domain = " + this.g, new Object[0]);
        if (z) {
            this.i++;
        }
        return this.g;
    }

    public final synchronized void a(String str) {
        this.g = str;
    }

    public final synchronized void a(String str, long j, long j2) {
        this.f37890a = str;
        this.c = j;
        this.d = j2;
        this.h = 0;
        this.i = 0;
        this.e = false;
    }

    public final synchronized void b() {
        this.f37890a = null;
        this.c = 2147483647L;
        this.d = -1L;
        this.e = true;
        this.h = 0;
    }

    public final synchronized long c() {
        return this.c;
    }

    public final synchronized boolean d() {
        if (j()) {
            return true;
        }
        if (this.i <= 0) {
            return true;
        }
        this.i = 0;
        return false;
    }

    public final synchronized void e() {
        this.h = 0;
        this.i = 0;
    }

    public final JSONObject f() {
        if (this.g != null && this.f37890a != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("domain", this.g);
                jSONObject.put(LoginConstants.IP, this.f37890a);
                long j = this.c;
                if (j != 2147483647L) {
                    jSONObject.put("consumeTime", j);
                }
                jSONObject.put("port", this.b);
                long j2 = this.d;
                if (j2 != -1) {
                    jSONObject.put("detectSuccessTime", j2);
                }
                jSONObject.put("isDomain", this.e);
                jSONObject.put("connectTryCnt", 1);
                return jSONObject;
            } catch (JSONException e) {
                com.igexin.c.a.c.a.a(f, e.toString());
            }
        }
        return null;
    }
}
