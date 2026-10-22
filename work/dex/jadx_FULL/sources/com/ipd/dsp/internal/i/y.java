package com.ipd.dsp.internal.i;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f38344a;
    public final Handler b = new Handler(Looper.getMainLooper(), new a());

    public static final class a implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f38345a = 1;

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((v) message.obj).e();
            return true;
        }
    }

    public synchronized void a(v<?> vVar, boolean z) {
        if (!this.f38344a && !z) {
            this.f38344a = true;
            vVar.e();
            this.f38344a = false;
            return;
        }
        this.b.obtainMessage(1, vVar).sendToTarget();
    }
}
