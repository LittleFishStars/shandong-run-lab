package com.alibaba.triver.app;

import com.alibaba.ariver.app.api.App;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<App> f24614a;

    public a(App app) {
        if (app != null) {
            this.f24614a = new WeakReference<>(app);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        WeakReference<App> weakReference = this.f24614a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f24614a.get().exit();
    }
}
