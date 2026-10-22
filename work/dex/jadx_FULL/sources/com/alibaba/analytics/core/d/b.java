package com.alibaba.analytics.core.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.alibaba.analytics.a.j;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f23773a;

    public static final class a {
        private final boolean H;
        private final String au;

        public a(String str, boolean z) {
            this.au = str;
            this.H = z;
        }
    }

    /* JADX INFO: renamed from: com.alibaba.analytics.core.d.b$b, reason: collision with other inner class name */
    public static final class ServiceConnectionC0134b implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f23774a;
        boolean retrieved;

        private ServiceConnectionC0134b() {
            this.retrieved = false;
            this.f23774a = new LinkedBlockingQueue<>();
        }

        public IBinder getBinder() throws InterruptedException {
            if (this.retrieved) {
                throw new IllegalStateException();
            }
            this.retrieved = true;
            return this.f23774a.poll(5L, TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f23774a.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static final class c implements IInterface {
        private IBinder b;

        public c(IBinder iBinder) {
            this.b = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.b;
        }

        public boolean d(boolean z) throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                parcelObtain.writeInt(z ? 1 : 0);
                this.b.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readInt() != 0;
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }

        public String getId() throws RemoteException {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.b.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    public static synchronized void b(Context context) {
        if (f23773a != null) {
            return;
        }
        try {
            ServiceConnectionC0134b serviceConnectionC0134b = new ServiceConnectionC0134b();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (context.bindService(intent, serviceConnectionC0134b, 1)) {
                    try {
                        IBinder binder = serviceConnectionC0134b.getBinder();
                        if (binder != null) {
                            c cVar = new c(binder);
                            f23773a = new a(cVar.getId(), cVar.d(true));
                        }
                    } catch (Exception e) {
                        j.w("GoogleAdvertisingIdClient", e, new Object[0]);
                    }
                    context.unbindService(serviceConnectionC0134b);
                }
            } catch (Throwable th) {
                context.unbindService(serviceConnectionC0134b);
                throw th;
            }
        } catch (Throwable unused) {
        }
        if (f23773a == null) {
            f23773a = new a("", true);
        }
    }
}
