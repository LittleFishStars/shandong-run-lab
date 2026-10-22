package com.google.mlkit.common.sdkinternal;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTaskInput;
import com.zj.adlib.e19;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public abstract class MLTask<T, S extends MLTaskInput> extends ModelResource {
    public MLTask() {
    }

    @NonNull
    @KeepForSdk
    @WorkerThread
    public abstract T i(@NonNull S s) throws MlKitException;

    @KeepForSdk
    public MLTask(@NonNull e19 e19Var) {
        super(e19Var);
    }
}
