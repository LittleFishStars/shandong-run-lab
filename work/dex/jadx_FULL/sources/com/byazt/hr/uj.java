package com.byazt.hr;

import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 29, 15})
public abstract class uj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f28626a;
    public String c;
    public int n;
    public String tt;
    public String uj;
    public String ve;

    public uj(String str, String str2, String str3, String str4, int i) {
        this.c = str;
        this.ve = str3;
        this.n = i;
        this.tt = str2;
        this.f28626a = !TextUtils.isEmpty(str2);
        this.uj = str4;
    }

    public String a() {
        return this.uj;
    }

    public boolean c() {
        return this.f28626a;
    }

    public String n() {
        return this.ve;
    }

    public int sp() {
        return this.n;
    }

    public String toString() {
        return "BaseIntervalBean{waterfallId='" + this.c + "', showRulesVersion='" + this.ve + "', timingMode=" + this.n + '}';
    }

    public String tt() {
        return this.c;
    }

    public String uj() {
        if (TextUtils.isEmpty(this.tt)) {
            return this.c;
        }
        return this.c + LoginConstants.UNDER_LINE + this.tt;
    }

    public String ve() {
        return this.tt;
    }

    public boolean x() {
        return this.n == 1;
    }
}
