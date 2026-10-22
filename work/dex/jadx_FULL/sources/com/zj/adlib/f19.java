package com.zj.adlib;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public class f19 {
    @KeepForSdk
    public static void a(@NonNull Status status, @NonNull z09<Void> z09Var) {
        b(status, null, z09Var);
    }

    @KeepForSdk
    public static <ResultT> void b(@NonNull Status status, @Nullable ResultT resultt, @NonNull z09<ResultT> z09Var) {
        if (status.isSuccess()) {
            z09Var.setResult(resultt);
        } else {
            z09Var.b(b90.a(status));
        }
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static Task<Void> c(@NonNull Task<Boolean> task) {
        return task.m(new y2c());
    }

    @KeepForSdk
    public static <ResultT> boolean d(@NonNull Status status, @Nullable ResultT resultt, @NonNull z09<ResultT> z09Var) {
        return status.isSuccess() ? z09Var.d(resultt) : z09Var.c(b90.a(status));
    }
}
