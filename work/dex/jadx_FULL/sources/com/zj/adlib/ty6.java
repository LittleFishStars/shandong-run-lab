package com.zj.adlib;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ty6 implements ThreadFactory {
    public final int K;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Runnable f19914a;

        public a(Runnable runnable) {
            this.f19914a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Process.setThreadPriority(ty6.this.K);
            } catch (Throwable unused) {
            }
            this.f19914a.run();
        }
    }

    public ty6(int i) {
        this.K = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(new a(runnable));
    }
}
