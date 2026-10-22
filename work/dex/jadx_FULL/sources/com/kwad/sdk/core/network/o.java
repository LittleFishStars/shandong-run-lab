package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.response.model.BaseResultData;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class o<R extends f, T extends BaseResultData> implements g<R, T> {
    @Override // com.kwad.sdk.core.network.g
    public void onError(@NonNull R r, int i, String str) {
    }

    @Override // com.kwad.sdk.core.network.g
    public void onStartRequest(@NonNull R r) {
    }

    @Override // com.kwad.sdk.core.network.g
    public void onSuccess(@NonNull R r, @NonNull T t) {
    }
}
