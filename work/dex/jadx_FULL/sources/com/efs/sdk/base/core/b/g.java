package com.efs.sdk.base.core.b;

import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.http.HttpResponse;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LogDto f29569a;
    private d b;
    private String c;

    public g(LogDto logDto, d dVar, String str) {
        this.f29569a = logDto;
        this.b = dVar;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d dVar;
        LogDto logDto = this.f29569a;
        HttpResponse httpResponse = (logDto == null || (dVar = this.b) == null) ? new HttpResponse() : dVar.a(logDto, true);
        e.a().b(this.c, httpResponse.succ ? 0 : httpResponse.getHttpCode());
        this.c = null;
        this.b = null;
    }
}
