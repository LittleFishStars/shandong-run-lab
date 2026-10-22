package com.beizi.fusion;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class r0 extends v9 {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static r0 f27706a = new r0();
    }

    private r0() {
        if (a.f27706a != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    @Override // com.beizi.fusion.v9
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public q0 a(Context context) {
        return new q0(context);
    }

    public static r0 a() {
        return a.f27706a;
    }
}
