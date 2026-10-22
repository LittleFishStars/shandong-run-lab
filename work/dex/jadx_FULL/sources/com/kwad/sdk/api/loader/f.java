package com.kwad.sdk.api.loader;

import android.content.Context;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class f implements Thread.UncaughtExceptionHandler {
    private static f aHX;
    private Thread.UncaughtExceptionHandler aHY;
    private int aHZ;
    private long aIb;
    private Context mContext;
    private boolean DEBUG = false;
    private final AtomicBoolean aIa = new AtomicBoolean();

    private f(Context context) {
        this.mContext = context;
    }

    public static f bn(Context context) {
        if (aHX == null) {
            synchronized (f.class) {
                if (aHX == null) {
                    aHX = new f(context);
                }
            }
        }
        return aHX;
    }

    public final void cancel() {
        if (this.DEBUG) {
            Log.d("test.chen", "AutoRevertHandler cancel:");
        }
        this.aIa.set(true);
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public final void m1061do(int i) {
        this.aIb = System.currentTimeMillis();
        this.aHZ = i;
        if (this.DEBUG) {
            Log.d("test.chen", "startCheck:");
        }
    }

    public final void setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (uncaughtExceptionHandler != this) {
            this.aHY = uncaughtExceptionHandler;
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            if (this.DEBUG) {
                Log.d("test.chen", "AutoRevertHandler uncaughtException, mStartCheckTime:" + this.aIb + ",mMaxDuration:" + this.aHZ + ",mIsCancel:" + this.aIa.get());
            }
            if (!this.aIa.get() && this.aIb > 0 && System.currentTimeMillis() - this.aIb <= this.aHZ) {
                Boolean bool = (Boolean) com.kwad.sdk.api.c.g("filterStack", th);
                boolean zBooleanValue = bool != null ? bool.booleanValue() : true;
                Context context = this.mContext;
                if (context != null && zBooleanValue) {
                    b.a(context, i.aIf, true);
                }
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.aHY;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Throwable th2) {
            try {
                th2.printStackTrace();
                if (this.aHY != null) {
                }
            } finally {
                if (this.aHY != null) {
                    this.aHY.uncaughtException(thread, th);
                }
            }
        }
    }
}
