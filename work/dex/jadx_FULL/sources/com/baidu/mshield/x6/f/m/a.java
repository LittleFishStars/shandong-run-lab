package com.baidu.mshield.x6.f.m;

import android.annotation.TargetApi;
import com.baidu.mshield.x6.f.f;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@TargetApi(9)
public abstract class a implements d<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f26772a;

    public a() {
        this(5);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(a aVar) {
        try {
            return aVar.f26772a - this.f26772a;
        } catch (Throwable th) {
            f.b(th);
            return 0;
        }
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        a();
    }

    public a(int i) {
        this.f26772a = i;
    }
}
