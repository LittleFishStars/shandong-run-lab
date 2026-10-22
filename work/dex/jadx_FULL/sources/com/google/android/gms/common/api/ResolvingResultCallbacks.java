package com.google.android.gms.common.api;

import android.app.Activity;
import android.content.IntentSender;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;
import com.zj.adlib.yw6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class ResolvingResultCallbacks<R extends Result> extends ResultCallbacks<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f31217a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Activity f5485a;

    public ResolvingResultCallbacks(@NonNull Activity activity, int i) {
        yw6.m(activity, "Activity must not be null");
        this.f5485a = activity;
        this.f31217a = i;
    }

    @Override // com.google.android.gms.common.api.ResultCallbacks
    @KeepForSdk
    public final void b(@NonNull Status status) {
        if (!status.hasResolution()) {
            d(status);
            return;
        }
        try {
            status.startResolutionForResult(this.f5485a, this.f31217a);
        } catch (IntentSender.SendIntentException e) {
            Log.e("ResolvingResultCallback", "Failed to start resolution", e);
            d(new Status(8));
        }
    }

    @Override // com.google.android.gms.common.api.ResultCallbacks
    public abstract void c(@NonNull R r);

    public abstract void d(@NonNull Status status);
}
