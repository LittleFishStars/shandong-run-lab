package com.byazt.nbs;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1871, 72})
public class da implements Comparable<da> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f28812a;
    public String c;
    public int da;
    public com.byazt.hr.i gr;
    public Map<String, String> gt;
    public int gu;
    public int i;
    public int m;
    public x my;
    public int nu;
    public String qy;
    public int rh;
    public int rl;
    public String sl;
    public int sp;
    public String t;
    public String tt;
    public String u;
    public String ve;
    public int x;
    public int yp;
    public int yv;
    public int z;
    public com.byazt.hr.sp zm;
    public String uj = "1";
    public String n = "0";

    public int a() {
        return this.rl;
    }

    public String bx() {
        return this.qy;
    }

    public void c(int i) {
        this.yv = i;
    }

    public boolean cu() {
        return this.sp == 100;
    }

    public x d() {
        return this.my;
    }

    public int da() {
        return this.m;
    }

    public Map<String, String> eo() {
        return this.gt;
    }

    public double gr() {
        try {
            return Double.valueOf(this.n).doubleValue() * Double.valueOf(this.uj).doubleValue();
        } catch (Exception e) {
            com.byazt.eu.tt.uj("WaterFallConfig", "getEcpm error " + e.toString());
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
    }

    public boolean gt() {
        int i = this.sp;
        return i == 0 || i == 100;
    }

    public String gu() {
        return this.f28812a;
    }

    public String h() {
        return this.u;
    }

    public int i() {
        return this.z;
    }

    public String m() {
        return this.tt;
    }

    public String md() {
        return this.t;
    }

    public int my() {
        return this.sp;
    }

    public da n() {
        ConcurrentHashMap concurrentHashMap;
        List<String> listTt = com.byazt.vx.i.tt();
        da daVar = new da();
        daVar.c = this.c;
        com.byazt.vx.i.c(listTt, "mAdnetworkName");
        daVar.ve = this.ve;
        com.byazt.vx.i.c(listTt, "mAdnetwokrSlotId");
        daVar.uj = this.uj;
        com.byazt.vx.i.c(listTt, "mExchangeRate");
        daVar.n = this.n;
        com.byazt.vx.i.c(listTt, "mEcpm");
        daVar.f28812a = this.f28812a;
        com.byazt.vx.i.c(listTt, "mDiscount");
        daVar.sp = this.sp;
        com.byazt.vx.i.c(listTt, "mAdnetworkSlotType");
        daVar.x = this.x;
        com.byazt.vx.i.c(listTt, "mLoadSort");
        daVar.i = this.i;
        com.byazt.vx.i.c(listTt, "mShowSort");
        daVar.da = this.da;
        com.byazt.vx.i.c(listTt, "mRitType");
        daVar.m = this.m;
        com.byazt.vx.i.c(listTt, "originType");
        daVar.rl = this.rl;
        com.byazt.vx.i.c(listTt, "mSubAdType");
        daVar.sl = this.sl;
        com.byazt.vx.i.c(listTt, "mLoaderAdapterName");
        daVar.t = this.t;
        com.byazt.vx.i.c(listTt, "mWaterfallAbTestParam");
        daVar.u = this.u;
        com.byazt.vx.i.c(listTt, "mServerBiddingExtra");
        daVar.yp = this.yp;
        com.byazt.vx.i.c(listTt, "adExpiredTime");
        daVar.z = this.z;
        com.byazt.vx.i.c(listTt, "ifReuseAds");
        daVar.nu = this.nu;
        com.byazt.vx.i.c(listTt, "ifPreRequest");
        daVar.rh = this.rh;
        com.byazt.vx.i.c(listTt, "ifIsReady");
        daVar.yv = this.yv;
        com.byazt.vx.i.c(listTt, "isRefresh");
        daVar.tt = this.tt;
        com.byazt.vx.i.c(listTt, "mCustomAdnetworkName");
        Map<String, String> map = this.gt;
        if (map == null || map.size() <= 0) {
            concurrentHashMap = null;
        } else {
            concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.putAll(this.gt);
        }
        daVar.gt = concurrentHashMap;
        com.byazt.vx.i.c(listTt, "mMultilevelSlotCpm");
        daVar.qy = this.qy;
        com.byazt.vx.i.c(listTt, "mCustomAdapterJson");
        daVar.gu = this.gu;
        com.byazt.vx.i.c(listTt, "mAdnRitTimingMode");
        daVar.zm = this.zm;
        com.byazt.vx.i.c(listTt, "mIntervalFreqctlBean");
        daVar.gr = this.gr;
        com.byazt.vx.i.c(listTt, "mIntervalPacingBean");
        com.byazt.vx.i.tt(listTt, "WaterFallConfig");
        return daVar;
    }

    public boolean nb() {
        return zb() || or() || qp();
    }

    public String nu() {
        return TextUtils.isEmpty(this.c) ? this.tt : this.c;
    }

    public boolean or() {
        return this.sp == 1;
    }

    public int p() {
        return this.i;
    }

    public boolean pf() {
        return this.sp == 0;
    }

    public boolean qp() {
        return this.sp == 3;
    }

    public double qy() {
        x xVar = this.my;
        if (xVar != null && !TextUtils.isEmpty(xVar.a())) {
            try {
                return Double.valueOf(this.my.a()).doubleValue();
            } catch (Exception e) {
                com.byazt.eu.tt.uj("WaterFallConfig", "getServerBiddingLoadEcpm error " + e.toString());
            }
        }
        return -1.0d;
    }

    public String rh() {
        return this.ve;
    }

    public double rl() {
        x xVar = this.my;
        if (xVar != null && !TextUtils.isEmpty(xVar.n())) {
            try {
                return Double.valueOf(this.my.n()).doubleValue();
            } catch (Exception e) {
                com.byazt.eu.tt.uj("WaterFallConfig", "getServerBiddingShowEcpm error " + e.toString());
            }
        }
        return -1.0d;
    }

    public int sl() {
        return this.nu;
    }

    public String sp() {
        return this.sl;
    }

    public boolean sv() {
        return com.byazt.bp.tt.tt().ve(this.c);
    }

    public int t() {
        return this.rh;
    }

    public String toString() {
        return "WaterFallConfig{mAdnetworkName='" + this.c + "', mCustomAdnetworkName='" + this.tt + "', mAdnetwokrSlotId='" + this.ve + "', mExchangeRate=" + this.uj + ", mSlotEcpm=" + this.n + ", mAdnetworkSlotType=" + this.sp + ", mLoadSort=" + this.x + ", mShowSort=" + this.i + '}';
    }

    public com.byazt.hr.sp tt() {
        return this.zm;
    }

    public int u() {
        return this.da;
    }

    public boolean uj() {
        return this.gu == 1;
    }

    public com.byazt.hr.i ve() {
        return this.gr;
    }

    public int x() {
        return this.yp;
    }

    public String yp() {
        return this.uj;
    }

    public int yv() {
        return this.x;
    }

    public String z() {
        return this.c;
    }

    public boolean zb() {
        return this.sp == 2;
    }

    public double zm() {
        if (TextUtils.isEmpty(this.f28812a)) {
            return gr();
        }
        try {
            double d = Double.parseDouble(this.f28812a);
            if (d > AudioStats.AUDIO_AMPLITUDE_NONE && d <= 100.0d) {
                return (gr() * d) / 100.0d;
            }
            return gr();
        } catch (Exception unused) {
            return gr();
        }
    }

    public void a(int i) {
        this.m = i;
    }

    public int c() {
        return this.yv;
    }

    public void da(int i) {
        this.sp = i;
    }

    public void i(int i) {
        this.da = i;
    }

    public void sl(int i) {
        this.x = i;
    }

    public void sp(int i) {
        this.nu = i;
    }

    public void t(int i) {
        this.i = i;
    }

    public void tt(int i) {
        this.gu = i;
    }

    public void uj(int i) {
        this.yp = i;
    }

    public void ve(int i) {
        this.rl = i;
    }

    public void x(int i) {
        this.rh = i;
    }

    public void a(String str) {
        this.f28812a = str;
    }

    public void c(com.byazt.hr.sp spVar) {
        this.zm = spVar;
    }

    public void da(String str) {
        this.qy = str;
    }

    public void i(String str) {
        this.u = str;
    }

    public void sp(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        this.n = str;
    }

    public void tt(String str) {
        this.uj = str;
    }

    public void uj(String str) {
        this.tt = str;
    }

    public void ve(String str) {
        this.c = str;
    }

    public void x(String str) {
        this.t = str;
    }

    public void c(com.byazt.hr.i iVar) {
        this.gr = iVar;
    }

    public void c(String str) {
        this.sl = str;
    }

    public void c(x xVar) {
        this.my = xVar;
    }

    public void c(Map<String, String> map) {
        this.gt = map;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(da daVar) {
        if (daVar == null || this.x > daVar.yv()) {
            return 1;
        }
        if (this.x < daVar.yv()) {
            return -1;
        }
        if (this.i > daVar.p()) {
            return 1;
        }
        return this.i < daVar.p() ? -1 : 0;
    }

    public void n(int i) {
        this.z = i;
    }

    public void n(String str) {
        this.ve = str;
    }
}
