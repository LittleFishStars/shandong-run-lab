package com.zj.adlib;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Result;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ig7<T extends Result> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Result f42354a;

    public ig7() {
    }

    public ig7(@NonNull T t) {
        this.f42354a = t;
    }

    @NonNull
    public T getResult() {
        return (T) this.f42354a;
    }

    public void setResult(@NonNull T t) {
        this.f42354a = t;
    }
}
