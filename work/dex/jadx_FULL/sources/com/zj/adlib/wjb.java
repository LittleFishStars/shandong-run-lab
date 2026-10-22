package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class wjb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ blb f45612a;

    public wjb(blb blbVar) {
        this.f45612a = blbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        blb blbVar = this.f45612a;
        blbVar.f40777a.f20927a.remove(blbVar.f15568a);
        blb blbVar2 = this.f45612a;
        blbVar2.f40777a.f20929a.remove(blbVar2.f15568a);
    }
}
