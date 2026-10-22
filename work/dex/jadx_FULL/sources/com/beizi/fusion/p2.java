package com.beizi.fusion;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class p2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f27631a;

    public static class a extends na {
        public a(Context context, boolean z) {
            super(context, z);
        }
    }

    public p2(Context context) {
        this.f27631a = new a(context.getApplicationContext(), true);
    }

    public void a(String str, String str2, byte[] bArr, sa saVar) {
        this.f27631a.a(str2);
        this.f27631a.a(str, bArr, saVar);
    }
}
