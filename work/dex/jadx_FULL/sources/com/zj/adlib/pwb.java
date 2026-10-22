package com.zj.adlib;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cn.hzjizhun.admin.base.b0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class pwb extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b0 f44075a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pwb(b0 b0Var, Looper looper) {
        super(looper);
        this.f44075a = b0Var;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        super.handleMessage(message);
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            b0.b(this.f44075a);
            return;
        }
        b0 b0Var = this.f44075a;
        if (b0Var.m <= 0) {
            try {
                vob vobVar = b0Var.g;
                if (vobVar == null) {
                    return;
                }
                b0Var.r.sendEmptyMessageDelayed(2, vobVar.c);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        try {
            aqb aqbVar = b0Var.h;
            b0Var.l.startScroll(b0Var.getScrollX(), b0Var.getScrollY(), 0, aqbVar.f40589a, aqbVar.b);
            b0Var.m--;
            b0Var.invalidate();
        } catch (Throwable unused2) {
        }
        sendEmptyMessageDelayed(1, this.f44075a.h.b + 100);
    }
}
