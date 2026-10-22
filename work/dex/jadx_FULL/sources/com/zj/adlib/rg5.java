package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class rg5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f44447a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f19286a;

    public void a(float f) {
        float f2 = this.f44447a + f;
        this.f44447a = f2;
        int i = this.f19286a + 1;
        this.f19286a = i;
        if (i == Integer.MAX_VALUE) {
            this.f44447a = f2 / 2.0f;
            this.f19286a = i / 2;
        }
    }

    public float b() {
        int i = this.f19286a;
        if (i == 0) {
            return 0.0f;
        }
        return this.f44447a / i;
    }
}
