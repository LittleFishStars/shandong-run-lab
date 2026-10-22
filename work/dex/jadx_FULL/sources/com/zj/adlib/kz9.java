package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final /* synthetic */ class kz9 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mz9 f42954a;

    public kz9(mz9 mz9Var) {
        this.f42954a = mz9Var;
    }

    public static Runnable a(mz9 mz9Var) {
        return new kz9(mz9Var);
    }

    @Override // java.lang.Runnable
    public void run() {
        mz9 mz9Var = this.f42954a;
        mz9Var.f18329a.a(lz9.b(mz9Var));
    }
}
