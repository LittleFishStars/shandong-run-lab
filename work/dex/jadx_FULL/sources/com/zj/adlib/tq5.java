package com.zj.adlib;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.sdkinternal.ModelType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public class tq5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f44982a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ModelType f19880a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f19881a;
    public final String b;

    @KeepForSdk
    public tq5(@NonNull String str, @NonNull Uri uri, @NonNull String str2, @NonNull ModelType modelType) {
        this.f19881a = str;
        this.f44982a = uri;
        this.b = str2;
        this.f19880a = modelType;
    }

    @NonNull
    @KeepForSdk
    public String a() {
        return this.b;
    }

    @NonNull
    @KeepForSdk
    public String b() {
        return this.f19881a;
    }

    @NonNull
    @KeepForSdk
    public ModelType c() {
        return this.f19880a;
    }

    @NonNull
    @KeepForSdk
    public Uri d() {
        return this.f44982a;
    }
}
