package com.aliyun.svideosdk.editor.pplayer;

import android.os.SystemClock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f25767a;

    @Override // com.aliyun.svideosdk.editor.pplayer.c
    public long a() {
        return SystemClock.uptimeMillis() - this.f25767a;
    }

    @Override // com.aliyun.svideosdk.editor.pplayer.c
    public long b() {
        return SystemClock.uptimeMillis();
    }

    @Override // com.aliyun.svideosdk.editor.pplayer.c
    public void reset() {
        this.f25767a = SystemClock.uptimeMillis();
    }
}
