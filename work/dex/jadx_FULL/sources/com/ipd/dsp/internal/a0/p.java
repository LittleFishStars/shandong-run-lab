package com.ipd.dsp.internal.a0;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface p<R> extends com.ipd.dsp.internal.w.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38177a = Integer.MIN_VALUE;

    @Nullable
    com.ipd.dsp.internal.z.e getRequest();

    void getSize(@NonNull o oVar);

    void onLoadCleared(@Nullable Drawable drawable);

    void onLoadFailed(@Nullable Drawable drawable);

    void onLoadStarted(@Nullable Drawable drawable);

    void onResourceReady(@NonNull R r, @Nullable com.ipd.dsp.internal.b0.f<? super R> fVar);

    void removeCallback(@NonNull o oVar);

    void setRequest(@Nullable com.ipd.dsp.internal.z.e eVar);
}
