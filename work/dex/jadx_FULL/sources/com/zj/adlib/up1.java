package com.zj.adlib;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class up1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Api.AbstractClientBuilder f45197a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final Api.b<d4c> f20117a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public static final Api<Api.ApiOptions.a> f20118a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final p3c f20119a;

    static {
        Api.b<d4c> bVar = new Api.b<>();
        f20117a = bVar;
        d1c d1cVar = new d1c();
        f45197a = d1cVar;
        f20118a = new Api<>("Common.API", d1cVar, bVar);
        f20119a = new p3c();
    }
}
