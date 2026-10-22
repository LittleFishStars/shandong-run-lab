package com.beizi.fusion;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class z extends v9 {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static z f28076a = new z();
    }

    private z() {
        if (a.f28076a != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    @Override // com.beizi.fusion.v9
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public r9 a(Context context) {
        return new y(context);
    }

    public static z a() {
        return a.f28076a;
    }
}
