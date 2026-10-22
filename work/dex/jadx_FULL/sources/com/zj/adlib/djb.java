package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class djb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ blb f41213a;
    public final /* synthetic */ String f;

    public djb(blb blbVar, String str) {
        this.f41213a = blbVar;
        this.f = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        blb blbVar = this.f41213a;
        blbVar.f40777a.f20927a.remove(blbVar.f15568a);
        blb blbVar2 = this.f41213a;
        blbVar2.f40777a.f20929a.put(blbVar2.f15568a, this.f);
    }
}
