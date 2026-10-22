package com.beizi.fusion;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class v9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Object f27862a;

    public abstract Object a(Context context);

    public Object b(Context context) {
        if (this.f27862a == null) {
            synchronized (this) {
                if (this.f27862a == null) {
                    this.f27862a = a(context);
                }
            }
        }
        return this.f27862a;
    }
}
