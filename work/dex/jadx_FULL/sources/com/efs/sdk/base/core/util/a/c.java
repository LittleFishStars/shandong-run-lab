package com.efs.sdk.base.core.util.a;

import androidx.annotation.NonNull;
import com.efs.sdk.base.http.HttpResponse;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c extends com.efs.sdk.base.core.util.concurrent.d<HttpResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f29614a;

    public c(@NonNull b bVar) {
        super(bVar);
        this.f29614a = bVar;
    }

    @NonNull
    public final HttpResponse b() {
        this.f29614a.e = "post";
        return a();
    }
}
