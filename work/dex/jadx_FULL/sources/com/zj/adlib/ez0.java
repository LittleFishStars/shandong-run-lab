package com.zj.adlib;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ShowFirstParty;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ez0 implements Result {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Status f41553a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f16422a;

    @ShowFirstParty
    @KeepForSdk
    public ez0(@NonNull Status status, boolean z) {
        this.f41553a = (Status) yw6.m(status, "Status must not be null");
        this.f16422a = z;
    }

    public boolean a() {
        return this.f16422a;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ez0)) {
            return false;
        }
        ez0 ez0Var = (ez0) obj;
        return this.f41553a.equals(ez0Var.f41553a) && this.f16422a == ez0Var.f16422a;
    }

    @Override // com.google.android.gms.common.api.Result
    @NonNull
    public Status getStatus() {
        return this.f41553a;
    }

    public final int hashCode() {
        return ((this.f41553a.hashCode() + 527) * 31) + (this.f16422a ? 1 : 0);
    }
}
