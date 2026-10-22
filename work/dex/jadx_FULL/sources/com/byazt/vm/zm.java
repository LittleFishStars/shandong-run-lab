package com.byazt.vm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import androidx.annotation.Nullable;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 165, 482})
public final class zm<SERVICE, RESULT> {
    public final CountDownLatch c = new CountDownLatch(1);
    public final Intent tt;
    public final Context uj;
    public final tt<SERVICE, RESULT> ve;

    @com.byazt.zqa.c(c = {0, 1, 165, 21})
    public class c implements ServiceConnection {

        @Nullable
        public SERVICE c;
        public final tt<SERVICE, RESULT> uj;
        public final CountDownLatch ve;

        public c(CountDownLatch countDownLatch, tt<SERVICE, RESULT> ttVar) {
            this.ve = countDownLatch;
            this.uj = ttVar;
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.byazt.yv.da.c("ServiceBlockBinder#onServiceConnected ".concat(String.valueOf(componentName)));
            try {
                this.c = this.uj.tt(iBinder);
                try {
                    this.ve.countDown();
                } catch (Exception e) {
                    com.byazt.yv.da.c(e);
                }
            } catch (Throwable th) {
                try {
                    com.byazt.yv.da.ve("ServiceBlockBinder#onServiceConnected", th);
                } finally {
                    try {
                        this.ve.countDown();
                    } catch (Exception e2) {
                        com.byazt.yv.da.c(e2);
                    }
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            com.byazt.yv.da.c("ServiceBlockBinder#onServiceDisconnected".concat(String.valueOf(componentName)));
            try {
                this.ve.countDown();
            } catch (Exception e) {
                com.byazt.yv.da.c(e);
            }
        }
    }

    public interface tt<T, RESULT> {
        RESULT c(T t) throws Exception;

        T tt(IBinder iBinder);
    }

    public zm(Context context, Intent intent, tt<SERVICE, RESULT> ttVar) {
        this.uj = context;
        this.tt = intent;
        this.ve = ttVar;
    }

    public RESULT c() {
        zm<SERVICE, RESULT>.c cVar;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.byazt.yv.da.ve("Don't do this in ui thread.", null);
            return null;
        }
        try {
            cVar = new c(this.c, this.ve);
            this.uj.bindService(this.tt, cVar, 1);
            this.c.await();
            try {
                RESULT resultC = this.ve.c(cVar.c);
                c(cVar);
                return resultC;
            } catch (Throwable th) {
                th = th;
                try {
                    com.byazt.yv.da.c(th);
                    return null;
                } finally {
                    c(cVar);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cVar = null;
        }
    }

    private void c(zm<SERVICE, RESULT>.c cVar) {
        if (cVar != null) {
            try {
                this.uj.unbindService(cVar);
            } catch (Throwable th) {
                com.byazt.yv.da.c(th);
            }
        }
    }
}
