package com.efs.sdk.base.core.c;

import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.core.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.efs.sdk.base.core.c.a.a f29573a;

    public abstract com.efs.sdk.base.core.c.a.a a();

    public final void a(LogDto logDto) {
        try {
            if (this.f29573a == null) {
                synchronized (this) {
                    if (this.f29573a == null) {
                        com.efs.sdk.base.core.c.a.a aVarA = a();
                        this.f29573a = aVarA;
                        if (aVarA == null) {
                            return;
                        }
                    }
                }
            }
            this.f29573a.a(logDto);
        } catch (Throwable th) {
            Log.e("efs.processor", "log handle error", th);
        }
    }
}
