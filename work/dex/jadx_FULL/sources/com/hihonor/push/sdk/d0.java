package com.hihonor.push.sdk;

import android.os.Looper;
import android.util.Log;
import com.hihonor.push.framework.aidl.IPushInvoke;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class d0 implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f32641a = new AtomicInteger(1);
    public volatile IPushInvoke b;
    public final b0.a c;
    public f0 d;

    public d0(b0.a aVar) {
        this.c = aVar;
    }

    public boolean a() {
        return this.f32641a.get() == 3 || this.f32641a.get() == 4;
    }

    public final void a(int i) {
        Log.i("PushConnectionClient", "notifyFailed result: " + i);
        b0.a aVar = this.c;
        if (aVar != null) {
            z.a aVar2 = (z.a) aVar;
            if (Looper.myLooper() == z.this.f32685a.getLooper()) {
                aVar2.a(HonorPushErrorEnum.fromCode(i));
            } else {
                z.this.f32685a.post(new y(aVar2, i));
            }
        }
    }
}
