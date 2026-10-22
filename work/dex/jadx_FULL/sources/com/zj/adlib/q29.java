package com.zj.adlib;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public class q29 implements Api.ApiOptions.Optional {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public static final q29 f44112a = a().a();

    @Nullable
    public final String f;

    @KeepForSdk
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public String f44113a;

        public a() {
        }

        public /* synthetic */ a(n0c n0cVar) {
        }

        @NonNull
        @KeepForSdk
        public q29 a() {
            return new q29(this.f44113a, null);
        }

        @NonNull
        @CanIgnoreReturnValue
        @KeepForSdk
        public a b(@Nullable String str) {
            this.f44113a = str;
            return this;
        }
    }

    public /* synthetic */ q29(String str, p0c p0cVar) {
        this.f = str;
    }

    @NonNull
    @KeepForSdk
    public static a a() {
        return new a(null);
    }

    @NonNull
    public final Bundle b() {
        Bundle bundle = new Bundle();
        String str = this.f;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof q29) {
            return i76.b(this.f, ((q29) obj).f);
        }
        return false;
    }

    public final int hashCode() {
        return i76.c(this.f);
    }
}
