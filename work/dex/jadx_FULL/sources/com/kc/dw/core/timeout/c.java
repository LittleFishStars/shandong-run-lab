package com.kc.dw.core.timeout;

import com.kc.dw.core.utils.SdkHandler;
import com.kc.dw.core.utils.x1;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c<T> implements x1.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public x1.a<T> f39331a;
    public boolean b;
    public final Object c = new Object();

    @Keep
    public class a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f39332a;

        public a(c cVar) {
            this.f39332a = cVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            cancel();
            c cVar = this.f39332a;
            int iIntValue = com.kc.dw.core.exception.b.f.intValue();
            if (cVar.b) {
                SdkHandler.runOnMainThread(new d(cVar, iIntValue, "OnVideoLoadTimeout"));
            } else {
                cVar.b(iIntValue, "OnVideoLoadTimeout");
            }
        }
    }

    public c(long j, x1.a<T> aVar, boolean z) {
        this.f39331a = aVar;
        this.b = z;
        try {
            Timer timer = new Timer();
            a aVar2 = new a(this);
            if (j <= 0) {
                j = 5000;
            }
            timer.schedule(aVar2, j);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kc.dw.core.utils.x1.a
    public void a(int i, String str) {
        if (this.b) {
            SdkHandler.runOnMainThread(new d(this, i, str));
        } else {
            b(i, str);
        }
    }

    @Override // com.kc.dw.core.utils.x1.a
    public void a(String str, T t, boolean z) {
        try {
            synchronized (this.c) {
                x1.a<T> aVar = this.f39331a;
                if (aVar != null) {
                    aVar.a(str, t, z);
                    this.f39331a = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void b(int i, String str) {
        try {
            synchronized (this.c) {
                x1.a<T> aVar = this.f39331a;
                if (aVar != null) {
                    aVar.a(i, str);
                    this.f39331a = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.kc.dw.core.utils.x1.a
    public void onStartDownload() {
        try {
            synchronized (this.c) {
                x1.a<T> aVar = this.f39331a;
                if (aVar != null) {
                    aVar.onStartDownload();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
