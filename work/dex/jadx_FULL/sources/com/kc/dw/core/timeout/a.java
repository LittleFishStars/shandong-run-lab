package com.kc.dw.core.timeout;

import android.graphics.Bitmap;
import com.kc.dw.core.safe.j;
import com.kc.dw.core.utils.SdkHandler;
import com.kc.dw.core.utils.w;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w f39324a;
    public final Object b = new Object();
    public volatile int c = 0;

    /* JADX INFO: renamed from: com.kc.dw.core.timeout.a$a, reason: collision with other inner class name */
    @Keep
    public class C1045a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f39325a;

        /* JADX INFO: renamed from: com.kc.dw.core.timeout.a$a$a, reason: collision with other inner class name */
        @Keep
        public class C1046a extends j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final C1045a f39326a;

            public C1046a(C1045a c1045a) {
                this.f39326a = c1045a;
            }

            @Override // com.kc.dw.core.safe.j
            public void safeRun() {
                this.f39326a.f39325a.c(com.kc.dw.core.exception.b.f.intValue(), new IOException("HttpGetBitmapTimeout"));
            }
        }

        public C1045a(a aVar) {
            this.f39325a = aVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            cancel();
            this.f39325a.a(2);
            if (this.f39325a.c != 2) {
                return;
            }
            a aVar = this.f39325a;
            int iIntValue = com.kc.dw.core.exception.b.f.intValue();
            IOException iOException = new IOException("HttpGetBitmapTimeout");
            aVar.getClass();
            try {
                synchronized (aVar.b) {
                    w wVar = aVar.f39324a;
                    if (wVar != null) {
                        wVar.a(iIntValue, iOException);
                    }
                }
            } catch (Exception unused) {
            }
            SdkHandler.getInstance().runOnUiThread(new C1046a(this));
        }
    }

    public a(int i, w wVar) {
        this.f39324a = wVar;
        try {
            new Timer().schedule(new C1045a(this), i > 0 ? i : 2000L);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(int i) {
        synchronized (this.b) {
            if (this.c == 0) {
                this.c = i;
            }
        }
    }

    @Override // com.kc.dw.core.utils.w
    public void a(int i, IOException iOException) {
        a(1);
        if (this.c != 1) {
            return;
        }
        try {
            synchronized (this.b) {
                try {
                    w wVar = this.f39324a;
                    if (wVar != null) {
                        wVar.a(i, iOException);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.kc.dw.core.utils.w
    public void a(byte[] bArr, Bitmap bitmap, Bitmap bitmap2, boolean z) throws IOException {
        a(1);
        if (this.c != 1) {
            return;
        }
        b(bArr, bitmap, bitmap2, z);
    }

    @Override // com.kc.dw.core.utils.w
    public void b(int i, IOException iOException) {
        a(1);
        if (this.c != 1) {
            return;
        }
        c(i, iOException);
    }

    public final void b(byte[] bArr, Bitmap bitmap, Bitmap bitmap2, boolean z) {
        try {
            synchronized (this.b) {
                w wVar = this.f39324a;
                if (wVar != null) {
                    wVar.a(bArr, bitmap, bitmap2, z);
                    this.f39324a = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void c(int i, IOException iOException) {
        try {
            synchronized (this.b) {
                w wVar = this.f39324a;
                if (wVar != null) {
                    wVar.b(i, iOException);
                    this.f39324a = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.kc.dw.core.utils.w
    public void onStartDownload() {
        if (this.c == 2) {
            return;
        }
        try {
            synchronized (this.b) {
                try {
                    w wVar = this.f39324a;
                    if (wVar != null) {
                        wVar.onStartDownload();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Exception unused) {
        }
    }
}
