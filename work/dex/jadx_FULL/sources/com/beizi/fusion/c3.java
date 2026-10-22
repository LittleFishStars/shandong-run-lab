package com.beizi.fusion;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f27120a = 50;
    private final Context b;
    private final int c;
    private dd d;
    private final Handler e;
    private xc f;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 50) {
                xc xcVar = c3.this.f;
                if (xcVar instanceof bg) {
                    ((bg) xcVar).b(dd.a.INVOKE_INTERACTIVE_TRIGGER);
                }
            }
        }
    }

    public c3(Context context, int i) {
        this.b = context;
        this.c = i;
        this.e = new a(context.getMainLooper());
        this.f = xf.a(context, BridgeDSL.INVOKE, false);
    }

    public void a(dd ddVar) {
        this.d = ddVar;
    }

    public void b() {
        int i = this.c;
        if (i > 0) {
            this.e.sendEmptyMessageDelayed(50, i);
        }
    }

    public void a(dc dcVar, Object obj) {
        xc xcVar;
        if (!(dcVar instanceof ha) || (xcVar = this.f) == null) {
            return;
        }
        xcVar.a((Object) null);
        this.f.a(obj, null);
        this.f.a();
        this.f.a(dcVar);
        xc xcVar2 = this.f;
        if (xcVar2 instanceof wa) {
            ((wa) xcVar2).d().a(this.d);
        }
    }

    public void a() {
        xc xcVar = this.f;
        if (xcVar instanceof bg) {
            ((bg) xcVar).f();
        }
    }
}
