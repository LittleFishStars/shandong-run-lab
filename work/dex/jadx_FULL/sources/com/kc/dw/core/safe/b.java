package com.kc.dw.core.safe;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b extends Handler {
    public b() {
    }

    public b(Looper looper) {
        super(looper);
    }

    public void a(Message message) {
        super.handleMessage(message);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        try {
            a(message);
        } catch (Exception e) {
            e.printStackTrace();
            com.kc.dw.base.middleware.a.a(e);
        }
    }
}
