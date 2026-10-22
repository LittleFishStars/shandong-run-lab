package com.byazt.ih;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.byazt.yxi.uj;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1573, 13})
public class tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f28645a;
    public final String c;
    public final String da;
    public final String i;
    public final String n;
    public final String sl;
    public final String sp;
    public final String t;
    public final String tt;
    public final String uj;
    public final String ve;
    public final String x;

    public tt() {
        this.ve = "";
        this.c = "";
        this.tt = "";
        this.uj = "";
        this.n = "";
        this.f28645a = "";
        this.sp = "";
        this.x = "";
        this.i = "";
        this.da = "";
        this.sl = "";
        this.t = "";
    }

    public SparseArray<Object> c() {
        uj ujVarC = uj.c();
        ujVarC.c(8003, this.ve);
        ujVarC.c(8534, this.c);
        ujVarC.c(8535, this.tt);
        ujVarC.c(8536, this.uj);
        ujVarC.c(8537, this.n);
        ujVarC.c(8538, this.f28645a);
        ujVarC.c(8539, this.sp);
        ujVarC.c(8540, this.x);
        ujVarC.c(8541, this.i);
        ujVarC.c(8542, this.da);
        ujVarC.c(8543, this.sl);
        ujVarC.c(8544, this.t);
        return ujVarC.tt();
    }

    public String toString() {
        return "GMCustomInitConfig{mAppId='" + this.c + "', mAppKey='" + this.tt + "', mADNName='" + this.ve + "', mAdnInitClassName='" + this.uj + "', mBannerClassName='" + this.n + "', mInterstitialClassName='" + this.f28645a + "', mRewardClassName='" + this.sp + "', mFullVideoClassName='" + this.x + "', mSplashClassName='" + this.i + "', mDrawClassName='" + this.sl + "', mFeedClassName='" + this.da + "'}";
    }

    @Nullable
    public String tt() {
        return this.ve;
    }

    public boolean uj() {
        return TextUtils.equals(this.t, "1");
    }

    @Nullable
    public String ve() {
        return this.uj;
    }

    public tt(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        this.ve = str;
        this.c = str2;
        this.tt = str3;
        this.uj = str4;
        this.n = str5;
        this.f28645a = str6;
        this.sp = str7;
        this.x = str8;
        this.i = str9;
        this.da = str10;
        this.sl = str11;
        this.t = str12;
    }

    @Nullable
    public c c(int i, int i2) {
        switch (i) {
            case 1:
                return new c(this.n, com.byazt.vz.c.class);
            case 2:
                return new c(this.f28645a, com.byazt.kv.c.class);
            case 3:
                return new c(this.i, com.byazt.xi.c.class);
            case 4:
            case 6:
            default:
                return null;
            case 5:
                if (i2 == 4) {
                    return new c(this.da, com.byazt.rm.c.class);
                }
                if (i2 == 5) {
                    return new c(this.sl, com.byazt.df.c.class);
                }
                if (i2 == 3) {
                    return new c(this.n, com.byazt.vz.c.class);
                }
                return new c(this.da, com.byazt.rm.c.class);
            case 7:
                if (i2 == 6) {
                    return new c(this.sp, com.byazt.oe.c.class);
                }
                if (i2 == 7) {
                    return new c(this.x, com.byazt.wp.c.class);
                }
                if (i2 == 8) {
                    return new c(this.f28645a, com.byazt.kv.c.class);
                }
                return new c(this.sp, com.byazt.oe.c.class);
            case 8:
                return new c(this.x, com.byazt.wp.c.class);
            case 9:
                break;
            case 10:
                if (i2 == 1) {
                    return new c(this.f28645a, com.byazt.kv.c.class);
                }
                if (i2 == 2) {
                    return new c(this.x, com.byazt.wp.c.class);
                }
                break;
        }
        return new c(this.sl, com.byazt.df.c.class);
    }
}
