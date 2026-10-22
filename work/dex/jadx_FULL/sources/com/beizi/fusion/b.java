package com.beizi.fusion;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b extends v9 {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static b f27084a = new b();
    }

    private b() {
        if (a.f27084a != null) {
            throw new RuntimeException("Singleton ...");
        }
    }

    @Override // com.beizi.fusion.v9
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.beizi.fusion.a a(Context context) {
        return new com.beizi.fusion.a(context);
    }

    public static b a() {
        return a.f27084a;
    }
}
