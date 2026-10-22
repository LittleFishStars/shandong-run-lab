package com.zj.adlib;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cn.hzjizhun.admin.base.b0;
import cn.hzjizhun.admin.base.utils.CrashRecorder;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class bbb extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dqb f40717a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bbb(dqb dqbVar, Looper looper) {
        super(looper);
        this.f40717a = dqbVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        super.handleMessage(message);
        int i = message.what;
        if (i != 3) {
            if (i != 4) {
                return;
            }
            rzb.a().f19459a.push(this.f40717a.f41258a);
            return;
        }
        b0 b0Var = this.f40717a.f41258a;
        b0Var.getClass();
        try {
            String str = b0Var.b;
            b0Var.c = "";
            b0Var.b = "";
            b0Var.d = "";
            b0Var.i = "";
            b0Var.k = "";
            b0Var.e = "";
            b0Var.h = null;
            b0Var.g = null;
            b0Var.n = true;
            b0Var.l.startScroll(b0Var.getScrollX(), b0Var.getScrollY(), -b0Var.getScrollX(), -b0Var.getScrollY());
            b0Var.m = 0;
            b0Var.r.removeCallbacksAndMessages(null);
            HashMap map = new HashMap();
            map.put("__TS_END__", System.currentTimeMillis() + "");
            b0Var.a(41, map);
            CrashRecorder.getInstance().releasePager(str);
        } catch (Throwable unused) {
        }
        sendEmptyMessageDelayed(4, 500L);
    }
}
