package com.kc.dw.core.exception;

import android.content.Context;
import android.os.MessageQueue;
import com.kc.dw.core.utils.f0;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a implements MessageQueue.IdleHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f39251a;

    public a(Context context) {
        this.f39251a = context;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        try {
            Context context = this.f39251a;
            if (c.c) {
                return false;
            }
            try {
                c.c = true;
                ExecutorService executorService = f0.f39362a;
                f0.b.f39363a.a(new d(context));
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
