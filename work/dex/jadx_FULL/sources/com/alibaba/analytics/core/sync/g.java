package com.alibaba.analytics.core.sync;

import com.alibaba.analytics.a.x;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g implements Runnable {
    private boolean S = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static BlockingQueue<String> f669a = new LinkedBlockingQueue();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static g f23795a = new g();

    public static g a() {
        return f23795a;
    }

    public void M(String str) {
        if (f669a.contains(str)) {
            com.alibaba.analytics.a.j.d("", "queueCache contains", str);
            return;
        }
        try {
            f669a.put(str);
            com.alibaba.analytics.a.j.d("", "queueCache put", str, "queueCache size", Integer.valueOf(f669a.size()));
        } catch (Exception e) {
            com.alibaba.analytics.a.j.d("", e);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (this.S) {
            try {
                String strTake = f669a.take();
                com.alibaba.analytics.a.j.d("", "take queueCache size", Integer.valueOf(f669a.size()));
                if ("i".equals(strTake)) {
                    e.a().F();
                }
            } catch (Throwable th) {
                com.alibaba.analytics.a.j.d("", th);
            }
        }
    }

    public synchronized void start() {
        if (!this.S) {
            this.S = true;
            x.a().schedule(null, a(), 0L);
        }
    }
}
