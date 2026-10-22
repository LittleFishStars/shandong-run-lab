package com.byazt.ete;

import android.graphics.Color;
import android.text.TextUtils;
import com.hzchengdun.securityguard.SecExceptionCode;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 958})
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28510a;
    public int c;
    public int n;
    public tt sl;
    public int sp;
    public tt t;
    public String tt;
    public int u;
    public int uj;
    public int x;
    public c yp;
    public int z;
    public boolean ve = false;
    public String i = "#008DEA";
    public String da = "点击查看";
    public float m = 0.0f;
    public int nu = 0;
    public int rh = 0;
    public int my = 55;
    public int gt = 0;
    public float rl = 0.0f;
    public int qy = 100;
    public int gu = 0;
    public int gr = 0;
    public int zm = 0;

    @com.byazt.zqa.c(c = {0, 1, 8, 2495})
    public class c {
        public int c;
        public int tt;
        public int uj;
        public int ve;

        public c(JSONObject jSONObject, int i) {
            this.c = 30;
            this.tt = 30;
            this.ve = 150;
            this.uj = 40;
            if (jSONObject == null) {
                if (i == 2) {
                    this.ve = 40;
                    this.uj = 20;
                    return;
                }
                return;
            }
            int iOptInt = jSONObject.optInt("left_margin", 30);
            this.c = iOptInt;
            if (iOptInt < 0 || iOptInt > s.this.p()) {
                this.c = 30;
            }
            int iOptInt2 = jSONObject.optInt("right_margin", 30);
            this.tt = iOptInt2;
            if (iOptInt2 < 0 || iOptInt2 > s.this.p()) {
                this.tt = 30;
            }
            if (i == 2) {
                int iOptInt3 = jSONObject.optInt("top_margin", 40);
                this.ve = iOptInt3;
                if (iOptInt3 < 0 || iOptInt3 > s.this.yv()) {
                    this.ve = 40;
                }
                int iOptInt4 = jSONObject.optInt("bottom_margin", 20);
                this.uj = iOptInt4;
                if (iOptInt4 < 0 || iOptInt4 > s.this.yv()) {
                    this.uj = 20;
                    return;
                }
                return;
            }
            int iOptInt5 = jSONObject.optInt("top_margin", 150);
            this.ve = iOptInt5;
            if (iOptInt5 < 0 || iOptInt5 > s.this.yv()) {
                this.ve = 150;
            }
            int iOptInt6 = jSONObject.optInt("bottom_margin", 40);
            this.uj = iOptInt6;
            if (iOptInt6 < 0 || iOptInt6 > s.this.yv()) {
                this.uj = 40;
            }
        }

        public int c() {
            return this.c;
        }

        public JSONObject n() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("left_margin", 30);
                jSONObject.put("right_margin", 30);
                jSONObject.put("top_margin", 150);
                jSONObject.put("bottom_margin", 40);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public int tt() {
            return this.tt;
        }

        public int uj() {
            return this.uj;
        }

        public int ve() {
            return this.ve;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 8, SecExceptionCode.SEC_ERROR_LBSRISK_INIT_WUA_FAILED})
    public class tt {
        public int c;

        public tt(JSONObject jSONObject, int i) {
            this.c = 14;
            if (jSONObject == null) {
                return;
            }
            this.c = jSONObject.optInt("font_size", i);
        }

        public JSONObject c() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("font_size", this.c);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public int tt() {
            return this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int p() {
        return com.byazt.aas.pf.uj(com.byazt.omf.gt.getContext(), com.byazt.aas.pf.uj(com.byazt.omf.gt.getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int yv() {
        return com.byazt.aas.pf.uj(com.byazt.omf.gt.getContext(), com.byazt.aas.pf.n(com.byazt.omf.gt.getContext()));
    }

    public int a() {
        return this.sp;
    }

    public String da() {
        return this.i;
    }

    public int gr() {
        return this.zm;
    }

    public int gt() {
        return this.gt;
    }

    public int gu() {
        return this.gr;
    }

    public int i() {
        if (this.uj == 4 && !com.byazt.omf.x.m().c(com.byazt.omf.gt.getContext())) {
            this.uj = 0;
        } else if (this.uj == 7 && !com.byazt.omf.x.m().tt(com.byazt.omf.gt.getContext())) {
            this.uj = 0;
        }
        return this.uj;
    }

    public float m() {
        return this.m;
    }

    public int my() {
        return this.my;
    }

    public int n() {
        return this.f28510a;
    }

    public int nu() {
        return this.nu;
    }

    public int qy() {
        return this.gu;
    }

    public int rh() {
        return this.rh;
    }

    public int rl() {
        return this.qy;
    }

    public String sl() {
        return this.da;
    }

    public int sp() {
        return this.x;
    }

    public tt t() {
        return this.sl;
    }

    public tt u() {
        return this.t;
    }

    public int uj() {
        return this.n;
    }

    public boolean ve() {
        return this.ve;
    }

    public int x() {
        return this.z;
    }

    public c yp() {
        return this.yp;
    }

    public int z() {
        return this.u;
    }

    public float zm() {
        return this.rl;
    }

    public void a(int i) {
        this.z = i;
    }

    public int c() {
        return this.c;
    }

    public void da(int i) {
        this.rh = i;
    }

    public void m(int i) {
        this.zm = i;
    }

    public void n(int i) {
        this.x = i;
    }

    public void sl(int i) {
        this.my = i;
    }

    public void sp(int i) {
        this.uj = i;
    }

    public void t(int i) {
        this.gt = i;
    }

    public String tt() {
        if (this.uj == 4 && !com.byazt.omf.x.m().c(com.byazt.omf.gt.getContext())) {
            this.tt = "点击跳转至详情页或第三方应用";
        } else if (this.uj == 7 && !com.byazt.omf.x.m().tt(com.byazt.omf.gt.getContext())) {
            this.tt = "点击跳转至详情页或第三方应用";
        }
        return this.tt;
    }

    public void u(int i) {
        this.qy = i;
    }

    public void uj(int i) {
        this.sp = i;
    }

    public void ve(int i) {
        this.f28510a = i;
    }

    public void x(int i) {
        if (i <= 0 || i >= yv()) {
            this.u = 5;
        } else {
            this.u = i;
        }
    }

    public void yp(int i) {
        this.gu = i;
    }

    public void z(int i) {
        this.gr = i;
    }

    public void c(int i) {
        this.c = i;
    }

    public void ve(String str) {
        if (TextUtils.isEmpty(str)) {
            int i = this.uj;
            if (i == 7) {
                this.da = "扭动手机";
                return;
            } else if (i == 5) {
                this.da = "向上滑动";
                return;
            } else {
                if (i == 4) {
                    this.da = "摇一摇";
                    return;
                }
                return;
            }
        }
        this.da = str;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            this.ve = true;
            int i = this.uj;
            if (i == 3) {
                this.tt = "跳转至详情页或第三方应用";
                return;
            }
            if (i == 4) {
                this.tt = "前往详情页或第三方应用";
                return;
            } else if (i != 5 && i != 7) {
                this.tt = "点击跳转至详情页或第三方应用";
                return;
            } else {
                this.tt = "前往详情页或第三方应用";
                return;
            }
        }
        this.tt = str;
    }

    public void i(int i) {
        this.nu = i;
    }

    public void tt(int i) {
        this.n = i;
    }

    public void tt(String str) {
        try {
            Color.parseColor(str);
            this.i = str;
        } catch (Throwable unused) {
            this.i = "#008DEA";
        }
    }

    public void tt(JSONObject jSONObject) {
        this.t = new tt(jSONObject, 20);
    }

    public void c(JSONObject jSONObject) {
        this.sl = new tt(jSONObject, 14);
    }

    public void tt(float f) {
        this.rl = f;
    }

    public void c(JSONObject jSONObject, int i) {
        this.yp = new c(jSONObject, i);
    }

    public void c(float f) {
        this.m = f;
    }
}
