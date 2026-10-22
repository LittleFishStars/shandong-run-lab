package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.MlKitException;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public interface RemoteModelFileMover {
    @Nullable
    @KeepForSdk
    File a(@NonNull File file) throws MlKitException;

    @NonNull
    @KeepForSdk
    File b() throws MlKitException;
}
