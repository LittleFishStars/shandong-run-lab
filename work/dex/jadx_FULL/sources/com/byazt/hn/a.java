package com.byazt.hn;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 25, 34})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float[] f28613a;
    public int c;
    public int[] i;
    public float[] n;
    public float[] sp;
    public int tt;
    public float[] uj;
    public float[] ve;
    public int[] x;

    public void c(int i) {
        float[] fArr = this.ve;
        if (fArr == null || fArr.length < i) {
            this.ve = new float[i];
            this.uj = new float[i];
            this.n = new float[i];
            this.f28613a = new float[i];
            this.sp = new float[i];
            this.x = new int[i];
            this.i = new int[i];
        }
    }
}
