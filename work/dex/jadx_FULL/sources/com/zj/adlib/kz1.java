package com.zj.adlib;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.model.RemoteModelSource;
import com.google.mlkit.common.sdkinternal.ModelType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class kz1 extends RemoteModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RemoteModelSource f42949a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final RemoteModelSource f42950a;

        public a(@NonNull RemoteModelSource remoteModelSource) {
            yw6.l(remoteModelSource);
            this.f42950a = remoteModelSource;
        }

        @NonNull
        public kz1 a() {
            return new kz1(this.f42950a, null);
        }
    }

    public /* synthetic */ kz1(RemoteModelSource remoteModelSource, r6c r6cVar) {
        super(TextUtils.isEmpty(remoteModelSource.a()) ? "no_model_name" : remoteModelSource.a(), null, ModelType.CUSTOM);
        this.f42949a = remoteModelSource;
    }

    @NonNull
    @KeepForSdk
    public RemoteModelSource i() {
        return this.f42949a;
    }
}
