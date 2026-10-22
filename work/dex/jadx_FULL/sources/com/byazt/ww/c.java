package com.byazt.ww;

import android.annotation.SuppressLint;
import android.os.Handler;
import com.byazt.bwm.x;
import com.byazt.jtc.uj;
import com.byazt.yv.u;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 185, 20})
public class c {
    public static final int c = Runtime.getRuntime().availableProcessors();
    public static final com.byazt.he.c.AbstractC0420c<Executor> tt = new com.byazt.he.c.AbstractC0420c<Executor>() { // from class: com.byazt.ww.c.1
        @Override // com.byazt.he.c.AbstractC0420c
        @SuppressLint({"CI_NotAllowInvokeExecutorsMethods"})
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Executor tt(Object... objArr) {
            return new uj((int) (((double) c.c) * 0.5d), Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, new SynchronousQueue(), new x("xecutorUtil$1"));
        }
    };
    public static final com.byazt.he.c.AbstractC0420c<ExecutorService> ve = new com.byazt.he.c.AbstractC0420c<ExecutorService>() { // from class: com.byazt.ww.c.2
        @Override // com.byazt.he.c.AbstractC0420c
        @SuppressLint({"CI_NotAllowInvokeExecutorsMethods"})
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public ExecutorService tt(Object... objArr) {
            return new uj((int) (((double) c.c) * 0.5d), Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new x("xecutorUtil$2"));
        }
    };
    public static final com.byazt.he.c.AbstractC0420c<Handler> uj = new com.byazt.he.c.AbstractC0420c<Handler>() { // from class: com.byazt.ww.c.3
        @Override // com.byazt.he.c.AbstractC0420c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Handler tt(Object... objArr) {
            return new Handler(u.sp());
        }
    };

    public static Handler c() {
        return uj.ve(new Object[0]);
    }

    private static ExecutorService uj() {
        return ve.ve(new Object[0]);
    }

    private static Executor ve() {
        return tt.ve(new Object[0]);
    }

    public static void c(Runnable runnable) {
        ve().execute(runnable);
    }

    public static <T> Future<T> c(Callable<T> callable) {
        return uj().submit(callable);
    }
}
