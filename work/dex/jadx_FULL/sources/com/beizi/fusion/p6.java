package com.beizi.fusion;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class p6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f27645a;
    private boolean b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static p6 f27646a = new p6();
    }

    private p6() {
        this.b = true;
        if (a.f27646a != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    public static p6 a() {
        return a.f27646a;
    }

    public void a(String str, boolean z) {
        this.f27645a = str;
        this.b = z;
    }
}
