package com.efs.sdk.memleaksdk.monitor;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.efs.sdk.memleaksdk.monitor.shark.g;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class UMonitorHeapResult extends ResultReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f29634a;

    public interface a {
        void a();

        void b();
    }

    public UMonitorHeapResult() {
        super(null);
    }

    public void a(a aVar) {
        this.f29634a = aVar;
    }

    @Override // android.os.ResultReceiver
    public void onReceiveResult(int i, Bundle bundle) {
        super.onReceiveResult(i, bundle);
        try {
            a aVar = this.f29634a;
            if (aVar != null) {
                if (i == 1001) {
                    aVar.a();
                } else {
                    aVar.b();
                }
            }
        } catch (Throwable th) {
            g.b("UMonitorHeapResult", "onReceiveResult", th);
        }
    }
}
