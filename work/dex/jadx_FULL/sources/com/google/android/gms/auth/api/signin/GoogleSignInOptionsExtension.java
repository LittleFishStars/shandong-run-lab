package com.google.android.gms.auth.api.signin;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface GoogleSignInOptionsExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @KeepForSdk
    public static final int f31205a = 1;

    @KeepForSdk
    public static final int b = 3;

    @Nullable
    @KeepForSdk
    List<Scope> a();

    @KeepForSdk
    int b();

    @NonNull
    @KeepForSdk
    Bundle toBundle();
}
