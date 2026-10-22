package com.beizi.fusion;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class s4 extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference f27742a;

    public s4(Context context) {
        super(Looper.getMainLooper());
        this.f27742a = new WeakReference(context.getApplicationContext());
    }

    public Context a() {
        WeakReference weakReference = this.f27742a;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return (Context) this.f27742a.get();
    }

    public abstract void a(Message message);

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        WeakReference weakReference = this.f27742a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        a(message);
    }
}
