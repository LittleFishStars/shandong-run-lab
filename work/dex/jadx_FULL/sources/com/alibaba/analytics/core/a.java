package com.alibaba.analytics.core;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23751a = new a();
    private volatile String appKey;
    private volatile Context mContext = null;
    private volatile boolean l = false;
    private volatile boolean m = false;
    private volatile String r = null;
    private String s = "" + System.currentTimeMillis();

    private a() {
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m98a() {
        return this.appKey;
    }

    public void b(String str) {
        this.r = str;
    }

    public boolean e() {
        return this.m;
    }

    public boolean f() {
        return this.l;
    }

    public void g() {
        this.m = true;
    }

    public Context getContext() {
        return this.mContext;
    }

    public String getTimestamp() {
        return this.s;
    }

    public void h() {
        this.l = true;
    }

    public void setAppKey(String str) {
        this.appKey = str;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public static a a() {
        return f23751a;
    }

    public String b() {
        return this.r;
    }
}
