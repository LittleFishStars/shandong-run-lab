package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.mlkit_vision_common.zzme;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class cgd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static zfd f40966a;

    public static synchronized bfd a(zzme zzmeVar) {
        if (f40966a == null) {
            f40966a = new zfd(null);
        }
        return (bfd) f40966a.a(zzmeVar);
    }

    public static synchronized bfd b(String str) {
        return a(zzme.d("vision-common").c());
    }
}
