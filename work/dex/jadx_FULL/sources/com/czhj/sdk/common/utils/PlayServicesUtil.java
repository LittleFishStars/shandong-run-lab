package com.czhj.sdk.common.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.czhj.sdk.logger.SigmobLog;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class PlayServicesUtil {

    public static final class AdvertisingConnection implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f29445a;
        private final LinkedBlockingQueue<IBinder> b;

        private AdvertisingConnection() {
            this.f29445a = false;
            this.b = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() throws InterruptedException {
            if (this.f29445a) {
                throw new IllegalStateException();
            }
            this.f29445a = true;
            return this.b.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.b.put(iBinder);
            } catch (Throwable th) {
                SigmobLog.e(th.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static class AdvertisingInfo {
        public final String advertisingId;
        public final boolean limitAdTracking;

        public AdvertisingInfo(String str, boolean z) {
            this.advertisingId = str;
            this.limitAdTracking = z;
        }
    }

    public static final class AdvertisingInterface implements IInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IBinder f29446a;

        public AdvertisingInterface(IBinder iBinder) {
            this.f29446a = iBinder;
        }

        public String a() throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f29446a;
        }

        public boolean b() throws RemoteException {
            return false;
        }
    }

    public static AdvertisingInfo getAdvertisingIdInfo(Context context) throws Exception {
        Looper.myLooper();
        Looper.getMainLooper();
        return null;
    }
}
