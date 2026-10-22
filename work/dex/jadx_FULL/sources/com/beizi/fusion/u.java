package com.beizi.fusion;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class u extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference f27796a;

    public u(Context context) {
        super(Looper.getMainLooper());
        this.f27796a = new WeakReference(context != null ? context.getApplicationContext() : null);
    }

    public abstract void a(Message message);

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.f27796a.get() != null) {
            a(message);
        }
    }
}
