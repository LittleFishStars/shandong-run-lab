package com.efs.sdk.base.core.c.a;

import com.efs.sdk.base.core.model.LogDto;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f29574a;

    public abstract void a(LogDto logDto);

    public final void b(LogDto logDto) {
        a aVar = this.f29574a;
        if (aVar != null) {
            aVar.a(logDto);
        }
    }
}
