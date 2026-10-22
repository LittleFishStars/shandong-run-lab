package com.baidu.mshield.x0.d.h;

import android.annotation.TargetApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@TargetApi(9)
public abstract class b implements a<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f26741a;

    public b() {
        this(5);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(b bVar) {
        try {
            return bVar.f26741a - this.f26741a;
        } catch (Throwable th) {
            com.baidu.mshield.x0.d.d.a(th);
            return 0;
        }
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        a();
    }

    public b(int i) {
        this.f26741a = i;
    }
}
