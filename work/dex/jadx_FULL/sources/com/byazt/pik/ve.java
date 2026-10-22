package com.byazt.pik;

import android.text.TextUtils;
import com.byazt.nr.m;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 903, 54})
public class ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<c> f28944a;
    public String c;
    public float n;
    public List<tt> sp;
    public String tt;
    public n uj;
    public String ve;
    public boolean x;

    public List<tt> a() {
        return this.sp;
    }

    public String c() {
        return this.c;
    }

    public List<c> n() {
        return this.f28944a;
    }

    public boolean sp() {
        return this.x;
    }

    public String tt() {
        return this.tt;
    }

    public n uj() {
        return this.uj;
    }

    public String ve() {
        return this.ve;
    }

    public void c(String str) {
        this.c = str;
    }

    public void tt(String str) {
        this.tt = str;
    }

    public void ve(String str) {
        this.ve = str;
    }

    public void c(n nVar) {
        this.uj = nVar;
    }

    public void tt(List<tt> list) {
        this.sp = list;
    }

    public void c(float f) {
        this.n = f;
    }

    public void c(List<c> list) {
        this.f28944a = list;
    }

    public void c(boolean z) {
        this.x = z;
    }

    public boolean c(JSONObject jSONObject) {
        String strTt = tt();
        if (TextUtils.isEmpty(strTt)) {
            return true;
        }
        try {
            Object objC = com.byazt.kx.c.c(com.byazt.jze.tt.c(strTt)).c(jSONObject);
            return objC != null && Boolean.TRUE.equals(objC);
        } catch (Exception e) {
            m.ve("TTFeatureRule", "匹配过滤器失败: ".concat(String.valueOf(strTt)), e);
            return false;
        }
    }
}
