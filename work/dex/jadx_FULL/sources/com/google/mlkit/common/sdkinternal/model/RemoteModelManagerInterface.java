package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.model.RemoteModel;
import com.zj.adlib.sp2;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public interface RemoteModelManagerInterface<RemoteT extends RemoteModel> {
    @NonNull
    @KeepForSdk
    Task<Set<RemoteT>> a();

    @NonNull
    @KeepForSdk
    Task<Void> b(@NonNull RemoteT remotet, @NonNull sp2 sp2Var);

    @NonNull
    @KeepForSdk
    Task<Void> c(@NonNull RemoteT remotet);

    @NonNull
    @KeepForSdk
    Task<Boolean> d(@NonNull RemoteT remotet);
}
