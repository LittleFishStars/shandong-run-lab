package com.kc.dw.core.timeout;

import android.graphics.Bitmap;
import com.kc.dw.core.safe.j;
import com.kc.dw.core.utils.SdkHandler;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b implements com.kc.dw.cache.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.kc.dw.cache.d f39327a;
    public final Object b = new Object();
    public volatile int c = 0;

    @Keep
    public class a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f39328a;

        /* JADX INFO: renamed from: com.kc.dw.core.timeout.b$a$a, reason: collision with other inner class name */
        @Keep
        public class C1047a extends j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final a f39329a;

            public C1047a(a aVar) {
                this.f39329a = aVar;
            }

            @Override // com.kc.dw.core.safe.j
            public void safeRun() {
                b.a(this.f39329a.f39328a, com.kc.dw.core.exception.b.f.intValue());
            }
        }

        public a(b bVar) {
            this.f39328a = bVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            cancel();
            this.f39328a.c(2);
            if (this.f39328a.c != 2) {
                return;
            }
            this.f39328a.d(com.kc.dw.core.exception.b.f.intValue());
            SdkHandler.getInstance().runOnUiThread(new C1047a(this));
        }
    }

    /* JADX INFO: renamed from: com.kc.dw.core.timeout.b$b, reason: collision with other inner class name */
    @Keep
    public class C1048b extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f39330a;
        public final b b;

        public C1048b(b bVar, int i) {
            this.b = bVar;
            this.f39330a = i;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            b.a(this.b, this.f39330a);
        }
    }

    public b(int i, com.kc.dw.cache.d dVar) {
        this.f39327a = dVar;
        try {
            new Timer().schedule(new a(this), i > 0 ? i : 2000L);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(b bVar, int i) {
        bVar.getClass();
        try {
            synchronized (bVar.b) {
                try {
                    com.kc.dw.cache.d dVar = bVar.f39327a;
                    if (dVar != null) {
                        dVar.b(i);
                        bVar.f39327a = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.kc.dw.cache.d
    public void a() {
        if (this.c == 2) {
            return;
        }
        try {
            synchronized (this.b) {
                try {
                    com.kc.dw.cache.d dVar = this.f39327a;
                    if (dVar != null) {
                        dVar.a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.kc.dw.cache.d
    public void a(Bitmap bitmap, byte[] bArr, boolean z) {
        c(1);
        if (this.c != 1) {
            return;
        }
        try {
            synchronized (this.b) {
                com.kc.dw.cache.d dVar = this.f39327a;
                if (dVar != null) {
                    dVar.a(bitmap, bArr, z);
                    this.f39327a = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.kc.dw.cache.d
    public void b(int i) {
        c(1);
        if (this.c != 1) {
            return;
        }
        d(i);
        SdkHandler.getInstance().runOnUiThread(new C1048b(this, i));
    }

    public final void c(int i) {
        synchronized (this.b) {
            if (this.c == 0) {
                this.c = i;
            }
        }
    }

    public final void d(int i) {
        try {
            synchronized (this.b) {
                try {
                    com.kc.dw.cache.d dVar = this.f39327a;
                    if (dVar instanceof com.kc.dw.cache.c) {
                        ((com.kc.dw.cache.c) dVar).a(i);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
