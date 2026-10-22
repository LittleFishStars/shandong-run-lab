package com.efs.sdk.base.core.d;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.efs.sdk.base.core.controller.ControllerCenter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class a extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ControllerCenter f29600a;

    public a() {
        super(com.efs.sdk.base.core.util.concurrent.a.f29618a.getLooper());
        sendEmptyMessageDelayed(0, 60000L);
    }

    public abstract void a();

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        super.handleMessage(message);
        a();
        sendEmptyMessageDelayed(0, 60000L);
    }
}
