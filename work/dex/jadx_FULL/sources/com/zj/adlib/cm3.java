package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class cm3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f40998a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f15856a;
    public int b;
    public int c;
    public int d;

    public cm3(int i, int i2) {
        this.f40998a = i;
        this.b = i2;
        if (i <= i2) {
            v61.f("原始帧率:" + i + "小于目标帧率:" + i2 + "，不支持补帧", new Object[0]);
            this.f15856a = true;
        }
    }

    public boolean a(int i) {
        if (this.f15856a) {
            return false;
        }
        if (i == 0) {
            this.d++;
            return false;
        }
        int i2 = this.f40998a;
        float f = (i2 - this.b) / i2;
        int i3 = this.c;
        int i4 = this.d;
        boolean z = Math.abs((((float) (i3 + 1)) / ((float) (i3 + i4))) - f) < Math.abs((((float) i3) / ((float) ((i3 + i4) + 1))) - f);
        if (z) {
            this.c++;
        } else {
            this.d++;
        }
        return z;
    }

    public void b() {
        if (this.f15856a) {
            return;
        }
        int i = this.c;
        int i2 = this.d;
        int i3 = this.f40998a;
        float f = i2 / ((i + i2) / i3);
        float f2 = (i3 - this.b) / i3;
        v61.k("最终帧率为:" + f, new Object[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("实际丢帧率:");
        int i4 = this.c;
        sb.append(i4 / (i4 + this.d));
        sb.append(" 目标丢帧率:");
        sb.append(f2);
        v61.k(sb.toString(), new Object[0]);
    }
}
