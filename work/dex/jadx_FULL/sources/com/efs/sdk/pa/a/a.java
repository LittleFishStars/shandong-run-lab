package com.efs.sdk.pa.a;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.efs.sdk.pa.PAANRListener;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile boolean f29920a;
    final Handler b;
    final Thread c;
    long d;
    long e;
    boolean f;
    Handler g;
    PAANRListener h;
    long i;
    long j;
    final long k;
    boolean l;
    final Runnable m;
    final Runnable n;
    private HandlerThread o;
    private Application p;

    public a(Application application, long j) {
        this(application, j, true);
    }

    public static boolean a(StringBuilder sb) {
        Set<Map.Entry<Thread, StackTraceElement[]>> setEntrySet = Thread.getAllStackTraces().entrySet();
        if (setEntrySet.size() == 0) {
            return false;
        }
        boolean z = false;
        for (Map.Entry<Thread, StackTraceElement[]> entry : setEntrySet) {
            Thread key = entry.getKey();
            StackTraceElement[] value = entry.getValue();
            if (key.getId() == Looper.getMainLooper().getThread().getId()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(key.getName());
                sb2.append(" ");
                sb2.append(key.getPriority());
                sb2.append(" ");
                sb2.append(key.getState());
                sb2.append("\n");
                for (StackTraceElement stackTraceElement : value) {
                    String string = stackTraceElement.toString();
                    sb2.append("  at  ");
                    sb2.append(string);
                    sb2.append('\n');
                }
                sb2.append("\n");
                sb.insert(0, (CharSequence) sb2);
                z = true;
            } else {
                sb.append(key.getName());
                sb.append(" ");
                sb.append(key.getPriority());
                sb.append(" ");
                sb.append(key.getState());
                sb.append("\n");
                for (StackTraceElement stackTraceElement2 : value) {
                    String string2 = stackTraceElement2.toString();
                    sb.append("  at  ");
                    sb.append(string2);
                    sb.append('\n');
                }
                sb.append("\n");
            }
        }
        if (!z) {
            sb.insert(0, a(Looper.getMainLooper().getThread()));
        }
        return true;
    }

    public a(Application application, long j, boolean z) {
        this.f29920a = true;
        this.e = 4L;
        this.f = true;
        this.i = 0L;
        this.m = new Runnable() { // from class: com.efs.sdk.pa.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
                PAANRListener pAANRListener;
                if (a.this.f) {
                    return;
                }
                long jUptimeMillis = SystemClock.uptimeMillis();
                a aVar = a.this;
                long j2 = jUptimeMillis - aVar.j;
                if (j2 > aVar.k && (pAANRListener = aVar.h) != null) {
                    pAANRListener.unexcept(Long.valueOf(j2));
                }
                if (a.this.f29920a) {
                    a aVar2 = a.this;
                    aVar2.i = 0L;
                    aVar2.f29920a = false;
                    a aVar3 = a.this;
                    aVar3.b.postAtFrontOfQueue(aVar3.n);
                } else {
                    a aVar4 = a.this;
                    aVar4.i++;
                    if (!aVar4.f29920a) {
                        a aVar5 = a.this;
                        long j3 = aVar5.i;
                        long j4 = aVar5.e;
                        if (j3 >= j4 && j3 == j4) {
                            StringBuilder sb = new StringBuilder();
                            if (aVar5.l) {
                                sb.append(a.a(aVar5.c));
                            } else if (a.a(sb)) {
                            }
                            if (aVar5.h != null && sb.length() > 0) {
                                aVar5.h.anrStack(sb.toString());
                            }
                        }
                    }
                }
                a.this.j = SystemClock.uptimeMillis();
                a aVar6 = a.this;
                aVar6.g.postDelayed(aVar6.m, aVar6.d);
            }
        };
        this.n = new Runnable() { // from class: com.efs.sdk.pa.a.a.2
            @Override // java.lang.Runnable
            public final void run() {
                a.this.f29920a = true;
            }
        };
        this.k = j;
        this.p = application;
        this.l = z;
        long j2 = ((long) (j * 0.8f)) / this.e;
        this.d = j2;
        if (j2 < 100) {
            this.d = 100L;
            this.e = j / 100;
        }
        Log.i("Matrix.AnrTracer", "anrTrace, final mAnrBeatTime:" + this.d + ", mAnrBeatRate:" + this.d);
        this.c = Looper.getMainLooper().getThread();
        this.b = new Handler(Looper.getMainLooper());
        HandlerThread handlerThread = new HandlerThread("ANR HANDLER THREAD");
        this.o = handlerThread;
        handlerThread.start();
        this.g = new Handler(this.o.getLooper());
    }

    public static String a(Thread thread) {
        StringBuilder sb = new StringBuilder();
        StackTraceElement[] stackTrace = thread.getStackTrace();
        sb.append(thread.getName());
        sb.append(" ");
        sb.append(thread.getPriority());
        sb.append(" ");
        sb.append(thread.getState());
        sb.append("\n");
        for (StackTraceElement stackTraceElement : stackTrace) {
            String string = stackTraceElement.toString();
            sb.append("  at  ");
            sb.append(string);
            sb.append('\n');
        }
        sb.append("\n");
        return sb.toString();
    }
}
