package com.kc.dw.core.utils;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Runnable> f39403a;
    public Object b;
    public int c;
    public volatile boolean d;

    public r1() {
        this(null, 2);
    }

    public r1(Object obj, int i) {
        this.b = new Object();
        this.c = 2;
        if (i > 0) {
            this.c = i;
        } else {
            this.c = Integer.MAX_VALUE;
        }
        this.f39403a = Collections.synchronizedList(new ArrayList());
    }

    public final void a() {
        try {
            Runnable runnable = this.f39403a.get(0);
            try {
                synchronized (this.b) {
                    try {
                        try {
                            runnable.run();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            this.f39403a.remove(runnable);
        } catch (Throwable th4) {
            th4.printStackTrace();
        }
    }
}
