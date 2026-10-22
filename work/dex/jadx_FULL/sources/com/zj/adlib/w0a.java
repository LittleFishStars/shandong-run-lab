package com.zj.adlib;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public class w0a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static w0a f45503a = new w0a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public kl6 f20356a = null;

    @NonNull
    @KeepForSdk
    public static kl6 a(@NonNull Context context) {
        return f45503a.b(context);
    }

    @NonNull
    @VisibleForTesting
    public final synchronized kl6 b(@NonNull Context context) {
        if (this.f20356a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f20356a = new kl6(context);
        }
        return this.f20356a;
    }
}
