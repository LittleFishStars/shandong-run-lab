package com.baidu.mshield.x6.f.m;

import com.baidu.mshield.x6.EngineImpl;
import com.baidu.mshield.x6.f.f;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static c f26774a = null;
    public static int b = Integer.MAX_VALUE;
    public static long c = 120;
    public ThreadPoolExecutor d;

    public class a implements FileFilter {
        public a(c cVar) {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    public c() {
        int iA = (a() / 2) + 2;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(iA > 5 ? 5 : iA, b, c, TimeUnit.SECONDS, new PriorityBlockingQueue());
        this.d = threadPoolExecutor;
        threadPoolExecutor.setThreadFactory(new b());
    }

    public static c b() {
        synchronized (c.class) {
            if (f26774a == null) {
                f26774a = new c();
            }
        }
        return f26774a;
    }

    public void a(d dVar) {
        try {
            if (EngineImpl.isUnload) {
                return;
            }
            this.d.execute(dVar);
        } catch (Throwable th) {
            f.b(th);
        }
    }

    public void c() {
        try {
            this.d.shutdownNow();
            f26774a = null;
        } catch (Throwable th) {
            f.b(th);
        }
    }

    public int a() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new a(this)).length;
        } catch (Throwable th) {
            f.b(th);
            return 2;
        }
    }
}
