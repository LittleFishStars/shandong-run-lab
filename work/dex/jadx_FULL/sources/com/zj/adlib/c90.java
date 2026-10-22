package com.zj.adlib;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public final class c90<O extends Api.ApiOptions> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f40925a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Api.ApiOptions f15766a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Api f15767a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final String f15768a;

    public c90(Api api, @Nullable Api.ApiOptions apiOptions, @Nullable String str) {
        this.f15767a = api;
        this.f15766a = apiOptions;
        this.f15768a = str;
        this.f40925a = i76.c(api, apiOptions, str);
    }

    @NonNull
    @KeepForSdk
    public static <O extends Api.ApiOptions> c90<O> a(@NonNull Api<O> api, @Nullable O o, @Nullable String str) {
        return new c90<>(api, o, str);
    }

    @NonNull
    public final String b() {
        return this.f15767a.d();
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c90)) {
            return false;
        }
        c90 c90Var = (c90) obj;
        return i76.b(this.f15767a, c90Var.f15767a) && i76.b(this.f15766a, c90Var.f15766a) && i76.b(this.f15768a, c90Var.f15768a);
    }

    public final int hashCode() {
        return this.f40925a;
    }
}
