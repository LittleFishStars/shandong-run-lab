package com.zj.adlib;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class uf9 extends ky3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static uf9 f45140a;

    public uf9() {
        super(new Handler(Looper.getMainLooper()));
    }

    public static uf9 d() {
        if (f45140a == null) {
            f45140a = new uf9();
        }
        return f45140a;
    }

    @Override // com.zj.adlib.ky3, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (w()) {
            runnable.run();
        } else {
            super.execute(runnable);
        }
    }
}
