package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public class NativeOnCompleteListener implements OnCompleteListener<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f31408a;

    @KeepForSdk
    public NativeOnCompleteListener(long j) {
        this.f31408a = j;
    }

    @KeepForSdk
    public static void a(@NonNull Task<Object> task, long j) {
        task.e(new NativeOnCompleteListener(j));
    }

    @KeepForSdk
    public native void nativeOnComplete(long j, @Nullable Object obj, boolean z, boolean z2, @Nullable String str);

    @Override // com.google.android.gms.tasks.OnCompleteListener
    @KeepForSdk
    public void onComplete(@NonNull Task<Object> task) {
        Object objR;
        String message;
        Exception excQ;
        if (task.v()) {
            objR = task.r();
            message = null;
        } else if (task.t() || (excQ = task.q()) == null) {
            objR = null;
            message = null;
        } else {
            message = excQ.getMessage();
            objR = null;
        }
        nativeOnComplete(this.f31408a, objR, task.v(), task.t(), message);
    }
}
