package com.google.android.gms.dynamite;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class i implements DynamiteModule.VersionPolicy.IVersions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f31327a;

    public i(int i, int i2) {
        this.f31327a = i;
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.IVersions
    public final int a(Context context, String str) {
        return this.f31327a;
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.IVersions
    public final int b(Context context, String str, boolean z) {
        return 0;
    }
}
