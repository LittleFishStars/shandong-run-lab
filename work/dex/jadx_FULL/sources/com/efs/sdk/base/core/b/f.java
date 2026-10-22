package com.efs.sdk.base.core.b;

import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.http.HttpResponse;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LogDto f29568a;
    private d b;
    private String c;

    public f(LogDto logDto, d dVar, String str) {
        this.f29568a = logDto;
        this.b = dVar;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d dVar;
        LogDto logDto = this.f29568a;
        HttpResponse httpResponse = (logDto == null || (dVar = this.b) == null) ? new HttpResponse() : dVar.a(logDto, true);
        e.a().a(this.c, httpResponse.succ ? 0 : httpResponse.getHttpCode());
        this.c = null;
        this.b = null;
    }
}
