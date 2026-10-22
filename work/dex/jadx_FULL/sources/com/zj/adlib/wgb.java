package com.zj.adlib;

import cn.hzjizhun.admin.custom_ad.CustomReport;
import cn.hzjizhun.admin.custom_ad.http.CustomAdPosResult;
import cn.hzjizhun.admin.sads;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class wgb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile wgb f45593a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CustomReport f20439a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CustomAdPosResult f20440a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public sads f20441a;

    public static wgb c() {
        if (f45593a == null) {
            synchronized (wgb.class) {
                if (f45593a == null) {
                    f45593a = new wgb();
                }
            }
        }
        return f45593a;
    }

    public CustomReport a() {
        return this.f20439a;
    }

    public sads b() {
        return this.f20441a;
    }

    public CustomAdPosResult d() {
        return this.f20440a;
    }

    public void e(CustomReport customReport) {
        this.f20439a = customReport;
    }

    public void f(CustomAdPosResult customAdPosResult) {
        this.f20440a = customAdPosResult;
    }

    public void g(sads sadsVar) {
        this.f20441a = sadsVar;
    }

    public void h() {
        this.f20441a = null;
        this.f20440a = null;
    }
}
