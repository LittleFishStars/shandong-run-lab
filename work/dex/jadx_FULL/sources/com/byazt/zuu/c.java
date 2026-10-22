package com.byazt.zuu;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 466, 20})
public class c implements com.byazt.fn.c {
    public final float c;
    public final float tt;
    public final long ve;

    public c(float f, float f2, long j) {
        this.c = f;
        this.tt = f2;
        this.ve = j;
    }

    @Override // com.byazt.fn.c
    public long getLastTime() {
        return this.ve;
    }

    @Override // com.byazt.fn.c
    public float getLatitude() {
        return this.c;
    }

    @Override // com.byazt.fn.c
    public float getLongitude() {
        return this.tt;
    }
}
