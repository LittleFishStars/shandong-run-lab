package com.kc.dw.core.safe;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class l extends TimerTask {
    public void a() {
        throw null;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (Exception e) {
            e.printStackTrace();
            com.kc.dw.base.middleware.a.a(e);
        }
    }
}
