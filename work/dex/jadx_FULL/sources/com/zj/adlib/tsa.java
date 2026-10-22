package com.zj.adlib;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class tsa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f44998a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f19893a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f19894a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f19895b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f19896c;

    public tsa(int i, int[] iArr, String str, String str2, String str3) {
        this.f44998a = i;
        this.f19894a = iArr;
        this.f19893a = str;
        this.f19895b = str2;
        this.f19896c = str3;
        str = TextUtils.isEmpty(str) ? str2 : str;
        this.b = -1000;
        if ("regions".equals(str)) {
            this.b = 1001;
        } else if ("water".equals(str)) {
            this.b = 1002;
        } else if ("buildings".equals(str)) {
            this.b = 1003;
        } else if ("roads".equals(str)) {
            this.b = 1004;
        } else if ("labels".equals(str)) {
            this.b = 1005;
        } else if ("borders".equals(str)) {
            this.b = 1006;
        }
        this.c = (i * 1000) + iArr.hashCode();
    }
}
