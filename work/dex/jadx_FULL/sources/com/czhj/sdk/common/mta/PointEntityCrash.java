package com.czhj.sdk.common.mta;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class PointEntityCrash extends PointEntitySuper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29403a;
    private long b = 0;

    public String getCrashMessage() {
        return this.f29403a;
    }

    public long getCrashTime() {
        return this.b;
    }

    public void setCrashMessage(String str) {
        this.f29403a = str;
    }

    public void setCrashTime(long j) {
        this.b = j;
    }
}
