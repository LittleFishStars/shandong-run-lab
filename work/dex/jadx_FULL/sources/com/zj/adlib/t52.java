package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class t52 {
    public static final float b = 4.0f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f19708a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public y52 f19709a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f19710b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public y52 f19711b;
    public int c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f44850a = 8.0f;
    public int d = 60;

    public void a(y52 danMuView) {
        int iM;
        if (danMuView.p()) {
            return;
        }
        danMuView.z(Math.max((this.f19708a + Math.max(danMuView.l(), 0)) / 4.0f, 1.0f));
        if (danMuView.g() == 1) {
            y52 y52Var = this.f19709a;
            iM = y52Var != null ? (int) ((this.f19708a - y52Var.m()) - this.f19709a.l()) : 0;
            y52 y52Var2 = this.f19709a;
            if (y52Var2 == null || !y52Var2.o() || iM > this.d) {
                danMuView.u(true);
                this.f19709a = danMuView;
                return;
            }
            return;
        }
        if (danMuView.g() == 2) {
            y52 y52Var3 = this.f19711b;
            iM = y52Var3 != null ? (int) y52Var3.m() : 0;
            y52 y52Var4 = this.f19711b;
            if (y52Var4 == null || !y52Var4.o() || iM > this.d) {
                danMuView.u(true);
                this.f19711b = danMuView;
            }
        }
    }
}
