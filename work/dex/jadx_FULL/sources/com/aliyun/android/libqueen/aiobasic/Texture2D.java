package com.aliyun.android.libqueen.aiobasic;

import android.opengl.GLES20;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class Texture2D {
    protected long b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected long f25560a = 0;
    private int c = -1;
    private boolean d = true;

    public Texture2D(long j) {
        this.b = j;
    }

    private boolean b() {
        return (this.f25560a == 0 || this.b == 0) ? false : true;
    }

    private native long nInit(long j, int i, boolean z);

    private native void nRelease(long j);

    private native void nSetSize(long j, int i, int i2);

    public int a() {
        return this.c;
    }

    public boolean a(int i, int i2, int i3, boolean z) {
        c();
        this.c = i;
        long jNInit = nInit(this.b, i, z);
        this.f25560a = jNInit;
        this.d = false;
        nSetSize(jNInit, i2, i3);
        return this.f25560a != 0;
    }

    public void c() {
        int i;
        if (this.d && (i = this.c) > 0) {
            GLES20.glDeleteTextures(1, new int[]{i}, 0);
            this.c = -1;
        }
        if (b()) {
            nRelease(this.f25560a);
        }
        this.f25560a = 0L;
    }
}
