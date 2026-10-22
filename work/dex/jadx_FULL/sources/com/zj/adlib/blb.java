package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class blb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ytb f40777a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f15568a;

    public blb(ytb ytbVar, String str) {
        this.f40777a = ytbVar;
        this.f15568a = str;
    }

    public final void a(String str) {
        this.f40777a.f46116a.post(new djb(this, str));
    }
}
