package com.kwad.sdk.api.a;

import com.kwad.sdk.api.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class b implements Runnable {
    public abstract void doTask();

    @Override // java.lang.Runnable
    public void run() {
        try {
            doTask();
        } catch (Throwable th) {
            c.t(th);
        }
    }
}
