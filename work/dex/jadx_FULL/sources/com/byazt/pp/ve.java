package com.byazt.pp;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1434, 54})
public class ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f28954a;
    public int c;
    public String da;
    public String i;
    public String m;
    public String n;
    public String nu;
    public final Map<String, String> rh = new HashMap();
    public String sl;
    public int sp;
    public String t;
    public String tt;
    public String u;
    public String uj;
    public String ve;
    public String x;
    public String yp;
    public String z;

    @Nullable
    public String a() {
        return this.yp;
    }

    public void c(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.rh.clear();
        this.rh.putAll(map);
    }

    @Nullable
    public String da() {
        return this.ve;
    }

    @Nullable
    public String i() {
        return this.tt;
    }

    public int m() {
        return this.sp;
    }

    @Nullable
    public String n() {
        return this.u;
    }

    @Nullable
    public String nu() {
        return this.x;
    }

    @Nullable
    public String rh() {
        return this.i;
    }

    @Nullable
    public String sl() {
        return this.uj;
    }

    @Nullable
    public String sp() {
        return this.z;
    }

    @Nullable
    public String t() {
        return TextUtils.isEmpty(this.ve) ? this.tt : this.ve;
    }

    public String toString() {
        return "{mSdkNum='" + this.c + "', mSlotId='" + this.uj + "', mLevelTag='" + this.n + "', mEcpm=" + this.f28954a + ", mReqBiddingType=" + this.sp + "', mRequestId=" + this.i + ", mSubRitType=" + this.sl + '}';
    }

    @Nullable
    public String tt() {
        return this.da;
    }

    @Nullable
    public String u() {
        return this.f28954a;
    }

    @Nullable
    public String uj() {
        return this.t;
    }

    @Nullable
    public String ve() {
        return this.sl;
    }

    @Nullable
    public String x() {
        return this.m;
    }

    public String yp() {
        return this.nu;
    }

    @Nullable
    public String z() {
        return this.n;
    }

    public void a(String str) {
        this.z = str;
    }

    public void da(String str) {
        this.uj = str;
    }

    public void i(String str) {
        this.ve = str;
    }

    public void n(String str) {
        this.yp = str;
    }

    public void sl(String str) {
        this.f28954a = str;
    }

    public void sp(String str) {
        this.m = str;
    }

    public void t(String str) {
        this.nu = str;
    }

    public void tt(String str) {
        this.sl = str;
    }

    public void u(String str) {
        this.n = str;
    }

    public void uj(String str) {
        this.u = str;
    }

    public void ve(String str) {
        this.t = str;
    }

    public void x(String str) {
        this.tt = str;
    }

    public void yp(String str) {
        this.x = str;
    }

    public void z(String str) {
        this.i = str;
    }

    public void tt(int i) {
        this.sp = i;
    }

    public Map<String, String> c() {
        return this.rh;
    }

    public void c(String str) {
        this.da = str;
    }

    public void c(int i) {
        this.c = i;
    }
}
