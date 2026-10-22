package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.MutableConfig;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public interface ExtendableBuilder<T> {
    @NonNull
    T build();

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    MutableConfig getMutableConfig();
}
