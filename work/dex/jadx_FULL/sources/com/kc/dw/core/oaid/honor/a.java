package com.kc.dw.core.oaid.honor;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.Parcel;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f39275a;
    public ServiceConnection b = new ServiceConnectionC1026a(this);

    /* JADX INFO: renamed from: com.kc.dw.core.oaid.honor.a$a, reason: collision with other inner class name */
    @Keep
    public class ServiceConnectionC1026a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f39276a;

        public ServiceConnectionC1026a(a aVar) {
            this.f39276a = aVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                b bVar = new b(this.f39276a);
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                    parcelObtain.writeStrongBinder(bVar);
                    iBinder.transact(2, parcelObtain, parcelObtain, 0);
                    parcelObtain.readException();
                } catch (Exception unused) {
                } finally {
                    parcelObtain.recycle();
                    parcelObtain.recycle();
                }
                parcelObtain.recycle();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    @Keep
    public class b extends com.kc.dw.core.oaid.honor.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f39277a;

        public b(a aVar) {
            this.f39277a = aVar;
        }
    }

    @Keep
    public interface c {
    }

    public void a(Context context) {
        boolean z = false;
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getPackageInfo("com.hihonor.id", 0);
            Intent intent = new Intent("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
            z = !packageManager.queryIntentServices(intent, 0).isEmpty();
        } catch (Throwable unused) {
        }
        if (z) {
            try {
                Intent intent2 = new Intent();
                intent2.setAction("com.hihonor.id.HnOaIdService");
                intent2.setPackage("com.hihonor.id");
                context.bindService(intent2, this.b, 1);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
