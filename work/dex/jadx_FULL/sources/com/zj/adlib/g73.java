package com.zj.adlib;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.inject.Provider;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public class g73 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Provider f41834a;

    public g73(@NonNull Provider provider) {
        this.f41834a = provider;
    }

    @NonNull
    @KeepForSdk
    public Executor a(@Nullable Executor executor) {
        return executor != null ? executor : (Executor) this.f41834a.get();
    }
}
