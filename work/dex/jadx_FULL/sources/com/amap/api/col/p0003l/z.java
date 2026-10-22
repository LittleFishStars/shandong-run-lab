package com.amap.api.col.p0003l;

import com.zj.adlib.a7b;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class z extends iu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static z f26073a = new z(new x.b().c("amap-global-threadPool").g());

    public z(x xVar) {
        try {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(xVar.a(), xVar.b(), xVar.d(), TimeUnit.SECONDS, xVar.c(), xVar);
            ((iu) this).f930a = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Throwable th) {
            a7b.m(th, "TPool", "ThreadPool");
            th.printStackTrace();
        }
    }

    public static z g() {
        return f26073a;
    }

    public static z h(x xVar) {
        return new z(xVar);
    }

    @Deprecated
    public static synchronized z i() {
        if (f26073a == null) {
            f26073a = new z(new x.b().g());
        }
        return f26073a;
    }

    @Deprecated
    public static z j() {
        return new z(new x.b().g());
    }
}
