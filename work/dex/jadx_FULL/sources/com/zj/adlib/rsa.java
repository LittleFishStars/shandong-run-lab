package com.zj.adlib;

import android.opengl.GLES20;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class rsa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f44528a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f19422a;
    public int b;
    public int c;

    public final void a() {
        int i = this.f44528a;
        if (i >= 0) {
            GLES20.glDeleteProgram(i);
        }
        int i2 = this.b;
        if (i2 >= 0) {
            GLES20.glDeleteShader(i2);
        }
        int i3 = this.c;
        if (i3 >= 0) {
            GLES20.glDeleteShader(i3);
        }
        this.f19422a = true;
    }
}
