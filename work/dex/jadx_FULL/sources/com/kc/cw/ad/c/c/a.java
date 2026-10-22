package com.kc.cw.ad.c.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.kc.cw.ad.c.c;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a implements c {

    /* JADX INFO: renamed from: com.kc.cw.ad.c.c.a$a, reason: collision with other inner class name */
    @Keep
    public static final class ServiceConnectionC0975a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f38733a;
        private final LinkedBlockingQueue<IBinder> b;

        private ServiceConnectionC0975a() {
            this.f38733a = false;
            this.b = new LinkedBlockingQueue<>();
        }

        public IBinder a() throws InterruptedException {
            if (this.f38733a) {
                throw new IllegalStateException();
            }
            this.f38733a = true;
            return this.b.poll(5L, TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    @Keep
    public static final class b implements IInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private IBinder f38734a;

        public b(IBinder iBinder) {
            this.f38734a = iBinder;
        }

        public String a() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(com.alipay.sdk.m.d.b.f25422a);
                this.f38734a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f38734a;
        }
    }

    @Override // com.kc.cw.ad.c.c
    public String a(Context context) {
        ServiceConnectionC0975a serviceConnectionC0975a = new ServiceConnectionC0975a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        if (context.bindService(intent, serviceConnectionC0975a, 1)) {
            try {
                return new b(serviceConnectionC0975a.a()).a();
            } catch (Exception unused) {
            } finally {
                context.unbindService(serviceConnectionC0975a);
            }
        }
        return null;
    }
}
