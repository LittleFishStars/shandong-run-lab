package com.zj.adlib;

import com.facebook.imagepipeline.memory.BasePool;
import com.facebook.imagepipeline.memory.PoolStatsTracker;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class oz5 implements PoolStatsTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static oz5 f43860a;

    public static synchronized oz5 h() {
        if (f43860a == null) {
            f43860a = new oz5();
        }
        return f43860a;
    }

    @Override // com.facebook.imagepipeline.memory.PoolStatsTracker
    public void a(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.PoolStatsTracker
    public void b() {
    }

    @Override // com.facebook.imagepipeline.memory.PoolStatsTracker
    public void c() {
    }

    @Override // com.facebook.imagepipeline.memory.PoolStatsTracker
    public void d(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.PoolStatsTracker
    public void e(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.PoolStatsTracker
    public void f(int i) {
    }

    @Override // com.facebook.imagepipeline.memory.PoolStatsTracker
    public void g(int i) {
    }
}
