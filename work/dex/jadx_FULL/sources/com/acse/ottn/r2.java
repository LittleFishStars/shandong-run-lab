package com.acse.ottn;

import android.view.WindowManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class r2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f23175a;
    public int b;
    public WindowManager.LayoutParams c;

    public r2(int i, int i2, WindowManager.LayoutParams layoutParams) {
        this.f23175a = i;
        this.b = i2;
        this.c = layoutParams;
    }

    public void a(int i) {
        this.f23175a = i;
    }

    public int b() {
        return this.f23175a;
    }

    public int c() {
        return this.b;
    }

    public WindowManager.LayoutParams a() {
        return this.c;
    }

    public void b(int i) {
        this.b = i;
    }

    public void a(WindowManager.LayoutParams layoutParams) {
        this.c = layoutParams;
    }
}
