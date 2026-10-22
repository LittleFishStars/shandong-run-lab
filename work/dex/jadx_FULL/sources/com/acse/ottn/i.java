package com.acse.ottn;

import android.os.Handler;
import android.os.Looper;
import com.acse.ottn.io.reactivex.annotations.NonNull;
import com.acse.ottn.io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Executor;
import rx.Scheduler;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class i implements Executor {
    public static i c;
    public final Handler b = new Handler(Looper.myLooper());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Scheduler f23034a = Schedulers.from(this);

    public static synchronized Scheduler a() {
        if (c == null) {
            c = new i();
        }
        return c.f23034a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.b.post(runnable);
    }
}
