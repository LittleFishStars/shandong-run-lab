package com.byazt.wzi;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.byazt.mb.a;
import com.byazt.mb.n;
import com.byazt.mb.sp;
import com.byazt.mb.tt;
import com.byazt.mb.uj;
import com.byazt.mb.ve;
import com.byazt.nr.m;
import com.byazt.omf.da;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1656, 20})
public class c {
    public static volatile c ve;
    public Context c;
    public da tt;
    public CountDownLatch uj;
    public final Object n = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f29172a = 0;
    public ServiceConnection sp = new ServiceConnection() { // from class: com.byazt.wzi.c.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            c.this.tt = da.c.c(iBinder);
            try {
                c.this.tt.asBinder().linkToDeath(c.this.x, 0);
            } catch (RemoteException e) {
                m.ve("MultiProcess", "onServiceConnected throws :", e);
            }
            c.this.uj.countDown();
            System.currentTimeMillis();
            long unused = c.this.f29172a;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            m.c("MultiProcess", "BinderPool......onServiceDisconnected");
        }
    };
    public IBinder.DeathRecipient x = new IBinder.DeathRecipient() { // from class: com.byazt.wzi.c.2
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            m.tt("MultiProcess", "binder died.");
            c.this.tt.asBinder().unlinkToDeath(c.this.x, 0);
            c.this.tt = null;
            c.this.c();
        }
    };

    /* JADX INFO: renamed from: com.byazt.wzi.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 1656, 44})
    public static class BinderC0573c extends da.c {
        @Override // com.byazt.omf.da
        public IBinder c(int i) throws RemoteException {
            if (i == 0) {
                return sp.tt();
            }
            if (i == 1) {
                return n.tt();
            }
            if (i == 2) {
                return ve.tt();
            }
            if (i == 3) {
                return tt.tt();
            }
            if (i == 4) {
                return uj.tt();
            }
            if (i != 5) {
                return null;
            }
            return a.tt();
        }
    }

    private c(Context context) {
        this.c = context.getApplicationContext();
        c();
    }

    public static c c(Context context) {
        if (ve == null) {
            synchronized (c.class) {
                if (ve == null) {
                    ve = new c(context);
                }
            }
        }
        return ve;
    }

    public IBinder c(int i) {
        try {
            da daVar = this.tt;
            if (daVar != null) {
                return daVar.c(i);
            }
            return null;
        } catch (RemoteException e) {
            m.c(e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c() {
        m.c("MultiProcess", "BinderPool......connectBinderPoolService");
        this.uj = new CountDownLatch(1);
        try {
            this.c.bindService(new Intent(this.c, (Class<?>) BinderPoolService.class), this.sp, 1);
            this.f29172a = System.currentTimeMillis();
            this.uj.await();
        } catch (Exception e) {
            m.ve("MultiProcess", "connectBinderPoolService throws: ", e);
        }
    }
}
