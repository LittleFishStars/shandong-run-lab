package com.byazt.ete;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 184})
public class zb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f28525a;
    public String c;
    public boolean n;
    public int tt;
    public double uj;
    public int ve;

    @com.byazt.zqa.c(c = {0, 1, 8, 2462})
    public static final class c extends com.byazt.nc.t {
        public int c;
        public int tt;
        public double uj;
        public String ve;

        public c(int i, int i2, String str, double d) {
            this.c = i;
            this.tt = i2;
            this.ve = str;
            this.uj = d;
        }

        @Override // com.byazt.nc.t
        public double getDuration() {
            return this.uj;
        }

        @Override // com.byazt.nc.t
        public int getHeight() {
            return this.c;
        }

        @Override // com.byazt.nc.t
        public String getImageUrl() {
            return this.ve;
        }

        @Override // com.byazt.nc.t
        public int getWidth() {
            return this.tt;
        }

        @Override // com.byazt.nc.t
        public boolean isValid() {
            String str;
            return this.c > 0 && this.tt > 0 && (str = this.ve) != null && str.length() > 0;
        }
    }

    public boolean a() {
        return this.n;
    }

    public String c() {
        return this.c;
    }

    public boolean n() {
        return !TextUtils.isEmpty(this.c) && this.tt > 0 && this.ve > 0;
    }

    public String sp() {
        return this.f28525a;
    }

    public int tt() {
        return this.tt;
    }

    public double uj() {
        return this.uj;
    }

    public int ve() {
        return this.ve;
    }

    public void c(String str) {
        this.c = str;
    }

    public void tt(int i) {
        this.ve = i;
    }

    public void c(int i) {
        this.tt = i;
    }

    public void tt(String str) {
        this.f28525a = str;
    }

    public void c(double d) {
        this.uj = d;
    }

    public void c(boolean z) {
        this.n = z;
    }

    public static com.byazt.nc.t c(zb zbVar) {
        if (zbVar == null || !zbVar.n()) {
            return null;
        }
        return new c(zbVar.ve(), zbVar.tt(), zbVar.c(), zbVar.uj());
    }

    public static final com.byazt.nc.t c(int i, int i2, String str, double d) {
        return new c(i, i2, str, d);
    }
}
