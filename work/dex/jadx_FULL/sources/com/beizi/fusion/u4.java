package com.beizi.fusion;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class u4 extends v9 {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static u4 f27811a = new u4();
    }

    private u4() {
        if (a.f27811a != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    @Override // com.beizi.fusion.v9
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public kb a(Context context) {
        return new t4();
    }

    public static u4 a() {
        return a.f27811a;
    }
}
