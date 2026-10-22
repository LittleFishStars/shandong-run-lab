package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.MlKitException;
import java.nio.MappedByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public interface RemoteModelLoaderHelper {
    @NonNull
    @KeepForSdk
    MappedByteBuffer a(@NonNull String str) throws MlKitException;
}
