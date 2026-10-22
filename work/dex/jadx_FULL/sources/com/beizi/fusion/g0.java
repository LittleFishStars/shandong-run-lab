package com.beizi.fusion;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class g0 extends v9 {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static g0 f27310a = new g0();
    }

    private g0() {
        if (a.f27310a != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    @Override // com.beizi.fusion.v9
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public s9 a(Context context) {
        return new f0();
    }

    public static g0 a() {
        return a.f27310a;
    }
}
