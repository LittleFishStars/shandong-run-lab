package com.byazt.fo;

import android.text.TextUtils;
import com.byazt.nr.m;
import com.zj.adlib.xh9;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 737, 20})
public class c implements com.byazt.vb.tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f28546a;
    public JSONObject c;
    public int da;
    public String i;
    public long n;
    public byte sl;
    public long sp;
    public String t;
    public tt tt;
    public int u;
    public byte uj;
    public byte ve;
    public String x;

    public c(String str, JSONObject jSONObject) {
        this.i = str;
        this.c = jSONObject;
    }

    public static com.byazt.vb.tt uj(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("type");
            int iOptInt2 = jSONObject.optInt("priority");
            c cVar = new c();
            cVar.c((byte) iOptInt);
            cVar.tt((byte) iOptInt2);
            cVar.c(jSONObject.optJSONObject("event"));
            cVar.c(jSONObject.optString("localId"));
            cVar.tt(jSONObject.optString("genTime"));
            cVar.c(jSONObject.optInt(xh9.WEBSITE_PARAMS_CHANNEL));
            return cVar;
        } catch (JSONException e) {
            m.c(e);
            return null;
        }
    }

    @Override // com.byazt.vb.tt
    public String a() {
        if (TextUtils.isEmpty(this.i)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("localId", this.i);
            jSONObject.put("event", sp());
            jSONObject.put("genTime", t());
            jSONObject.put("priority", (int) this.uj);
            jSONObject.put("type", (int) this.ve);
            jSONObject.put(xh9.WEBSITE_PARAMS_CHANNEL, this.u);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.byazt.vb.tt
    public tt c() {
        return this.tt;
    }

    @Override // com.byazt.vb.tt
    public int da() {
        return this.da;
    }

    @Override // com.byazt.vb.tt
    public long i() {
        return this.f28546a;
    }

    @Override // com.byazt.vb.tt
    public byte n() {
        return this.uj;
    }

    public String sl() {
        return this.t;
    }

    @Override // com.byazt.vb.tt
    public synchronized JSONObject sp() {
        tt ttVar;
        if (this.c == null && (ttVar = this.tt) != null) {
            this.c = ttVar.c(sl());
        }
        return this.c;
    }

    public String t() {
        return this.x;
    }

    @Override // com.byazt.vb.tt
    public byte tt() {
        return this.sl;
    }

    public void ve(String str) {
        this.t = str;
    }

    @Override // com.byazt.vb.tt
    public long x() {
        return this.n;
    }

    @Override // com.byazt.vb.tt
    public void c(JSONObject jSONObject) {
        this.c = jSONObject;
    }

    @Override // com.byazt.vb.tt
    public void tt(String str) {
        this.x = str;
    }

    public void ve(byte b) {
        this.sl = b;
    }

    @Override // com.byazt.vb.tt
    public void c(byte b) {
        this.ve = b;
    }

    @Override // com.byazt.vb.tt
    public void tt(long j) {
        this.f28546a = j;
    }

    @Override // com.byazt.vb.tt
    public String ve() {
        return this.i;
    }

    public c(String str, tt ttVar) {
        this.i = str;
        this.tt = ttVar;
    }

    @Override // com.byazt.vb.tt
    public void c(String str) {
        this.i = str;
    }

    @Override // com.byazt.vb.tt
    public void tt(byte b) {
        this.uj = b;
    }

    @Override // com.byazt.vb.tt
    public void ve(long j) {
        this.sp = j;
    }

    @Override // com.byazt.vb.tt
    public void c(long j) {
        this.n = j;
    }

    @Override // com.byazt.vb.tt
    public void tt(int i) {
        this.da = i;
    }

    @Override // com.byazt.vb.tt
    public void c(int i) {
        this.u = i;
    }

    private c() {
    }

    @Override // com.byazt.vb.tt
    public byte uj() {
        return this.ve;
    }
}
