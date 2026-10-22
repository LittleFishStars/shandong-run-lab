package com.kc.cw.ad.internal;

import android.content.Context;
import android.text.TextUtils;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.y6b;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashSet<String> f38954a;
    private WeakReference<Context> b;
    private String d;
    private String e;
    private String f;
    private String g;
    private long h;
    private long i;
    private long j;
    private String q;
    private boolean r;
    private String u;
    private p c = p.PREFETCH;
    private int k = 3;
    private boolean l = false;
    private int m = -1;
    private int n = -1;
    private int o = -1;
    private int p = -1;
    private boolean s = false;
    private boolean t = false;

    public d(Context context, String str) {
        this.u = "";
        this.b = new WeakReference<>(context);
        this.u = str;
    }

    public String a() {
        return this.u;
    }

    public void a(int i) {
        this.k = i;
    }

    public void a(long j) {
        this.i = j;
    }

    public void a(p pVar) {
        this.c = pVar;
    }

    public void a(String str) {
        this.u = str;
    }

    public void a(boolean z) {
        this.s = z;
    }

    public Context b() {
        if (this.b.get() != null) {
            return this.b.get();
        }
        return null;
    }

    public void b(int i) {
        this.o = i;
    }

    public void b(long j) {
        this.h = j;
    }

    public void b(String str) {
        this.d = str;
    }

    public void b(boolean z) {
        this.r = z;
    }

    public String c() {
        return this.d;
    }

    public void c(int i) {
        this.p = i;
    }

    public void c(long j) {
        this.j = j;
    }

    public void c(String str) {
        this.e = str;
    }

    public void c(boolean z) {
        this.l = z;
    }

    public String d() {
        return this.e;
    }

    public void d(String str) {
        this.f = str;
    }

    public String e() {
        return TextUtils.isEmpty(this.f) ? this.u : this.f;
    }

    public void e(String str) {
        this.g = str;
    }

    public String f() {
        return this.g;
    }

    public long g() {
        return this.i;
    }

    public long h() {
        return this.h;
    }

    public long i() {
        return this.j;
    }

    public int j() {
        return -1;
    }

    public int k() {
        return -1;
    }

    public boolean l() {
        return this.r;
    }

    public int m() {
        return this.o;
    }

    public int n() {
        return this.p;
    }

    public boolean o() {
        return this.l;
    }

    public p p() {
        return this.c;
    }

    public boolean q() {
        if (q.a().s != null && !com.kc.cw.ad.internal.c.p.a(q.a().k()) && !com.kc.cw.ad.internal.c.p.a(this.d)) {
            return true;
        }
        com.kc.cw.ad.internal.c.f.e(com.kc.cw.ad.internal.c.f.f38946a, com.kc.cw.ad.internal.c.f.a(R.string.no_identification));
        return false;
    }

    public String r() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = b().getResources().getConfiguration().orientation == 2 ? y6b.g : "v";
            this.q = str;
            if (!com.kc.cw.ad.internal.c.p.a(str)) {
                jSONObject.put("mOrientation", this.q);
            }
            if (this.m > 0 && this.n > 0) {
                jSONObject.put("size", this.m + "x" + this.n);
            }
            int iN = n();
            int iM = m();
            if (iN > 0 && iM > 0) {
                p pVar = this.c;
                p pVar2 = p.INTERSTITIAL;
                if (!pVar.equals(pVar2) && (this.m < 0 || this.n < 0)) {
                    jSONObject.put("max_size", iM + "x" + iN);
                } else if (this.c.equals(pVar2)) {
                    jSONObject.put("size", iM + "x" + iN);
                }
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            com.kc.cw.ad.internal.c.f.e(com.kc.cw.ad.internal.c.f.h, "Failed to encode adUnitParams, err = " + e.getMessage());
            return "";
        }
    }
}
