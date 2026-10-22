package cj.mobile.wm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class gb implements va {

    public static final class dexb implements ServiceConnection {
        public boolean dexa;
        public final LinkedBlockingQueue<IBinder> dexb;

        public dexb() {
            this.dexa = false;
            this.dexb = new LinkedBlockingQueue<>();
        }

        public IBinder dexa() {
            if (this.dexa) {
                throw new IllegalStateException();
            }
            this.dexa = true;
            return this.dexb.poll(5L, TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.dexb.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static final class dexc implements IInterface {
        public IBinder dexa;

        public dexc(IBinder iBinder) {
            this.dexa = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.dexa;
        }

        public String dexa() {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(com.alipay.sdk.m.d.b.f25422a);
                this.dexa.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                return parcelObtain2.readString();
            } finally {
                parcelObtain2.recycle();
                parcelObtain.recycle();
            }
        }
    }

    @Override // cj.mobile.wm.va
    public String a(Context context) {
        dexb dexbVar = new dexb();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        if (context.bindService(intent, dexbVar, 1)) {
            try {
                return new dexc(dexbVar.dexa()).dexa();
            } catch (Exception unused) {
            } finally {
                context.unbindService(dexbVar);
            }
        }
        return null;
    }
}
