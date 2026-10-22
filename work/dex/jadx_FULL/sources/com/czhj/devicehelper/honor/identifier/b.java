package com.czhj.devicehelper.honor.identifier;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class b implements ServiceConnection {
    public Context b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.czhj.devicehelper.honor.identifier.a.C0612a f29369a = new com.czhj.devicehelper.honor.identifier.a.C0612a();
    public a c = new a();
    public BinderC0613b d = new BinderC0613b();
    public CountDownLatch e = new CountDownLatch(2);

    public class a extends com.czhj.devicehelper.honor.oaid.a.AbstractBinderC0614a {
        public a() {
        }

        @Override // com.czhj.devicehelper.honor.oaid.a
        public void a(int i, long j, boolean z, float f, double d, String str) {
        }

        @Override // com.czhj.devicehelper.honor.oaid.a
        public void a(int i, Bundle bundle) {
            Log.e("AdvertisingIdPlatform", "OAIDCallBack handleResult retCode=" + i + " retInfo=" + bundle);
            if (i != 0 || bundle == null) {
                Log.e("AdvertisingIdPlatform", "OAIDCallBack handleResult error retCode=$ " + i);
            } else if (b.this.f29369a != null) {
                String string = bundle.getString("oa_id_flag");
                b.this.f29369a.f29368a = string;
                Log.i("AdvertisingIdPlatform", "OAIDCallBack handleResult success " + string);
            }
            b.this.e.countDown();
        }
    }

    /* JADX INFO: renamed from: com.czhj.devicehelper.honor.identifier.b$b, reason: collision with other inner class name */
    public class BinderC0613b extends com.czhj.devicehelper.honor.oaid.a.AbstractBinderC0614a {
        public BinderC0613b() {
        }

        @Override // com.czhj.devicehelper.honor.oaid.a
        public void a(int i, long j, boolean z, float f, double d, String str) {
        }

        @Override // com.czhj.devicehelper.honor.oaid.a
        public void a(int i, Bundle bundle) {
            Log.e("AdvertisingIdPlatform", "OAIDCallBack handleResult retCode=" + i + " retInfo= " + bundle);
            if (i != 0 || bundle == null) {
                Log.e("AdvertisingIdPlatform", "OAIDLimitCallback handleResult error retCode= " + i);
            } else if (b.this.f29369a != null) {
                boolean z = bundle.getBoolean("oa_id_limit_state");
                b.this.f29369a.b = z;
                Log.i("AdvertisingIdPlatform", "OAIDLimitCallback handleResult success  isLimit=" + z);
            }
            b.this.e.countDown();
        }
    }

    public b() {
        Log.i("AdvertisingIdPlatform", "HonorSC");
    }

    public final void a() {
        Log.i("AdvertisingIdPlatform", "disconnect");
        try {
            this.b.unbindService(this);
        } catch (Exception e) {
            Log.e("AdvertisingIdPlatform", "OAIDClientImpl#disconnect#Disconnect error::" + e.getMessage());
        }
    }

    public boolean a(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getPackageInfo("com.hihonor.id", 0);
            Intent intent = new Intent("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
            return !packageManager.queryIntentServices(intent, 0).isEmpty();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        Log.i("AdvertisingIdPlatform", "onServiceConnected ");
        new Thread(new Runnable() { // from class: com.czhj.devicehelper.honor.identifier.b.1
            @Override // java.lang.Runnable
            public void run() {
                com.czhj.devicehelper.honor.oaid.b c0615a;
                try {
                    Binder.getCallingPid();
                    IBinder iBinder2 = iBinder;
                    if (iBinder2 == null) {
                        c0615a = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinder2.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                        c0615a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.czhj.devicehelper.honor.oaid.b)) ? new com.czhj.devicehelper.honor.oaid.b.a.C0615a(iBinder) : (com.czhj.devicehelper.honor.oaid.b) iInterfaceQueryLocalInterface;
                    }
                    try {
                        Log.i("AdvertisingIdPlatform", "onServiceConnected-debug4-" + c0615a);
                        c0615a.a(b.this.c);
                        Log.i("AdvertisingIdPlatform", "onServiceConnected-debug5-");
                        c0615a.b(b.this.d);
                        Log.i("AdvertisingIdPlatform", "onServiceConnected-debug6-");
                    } catch (Exception e) {
                        e = e;
                        Log.i("AdvertisingIdPlatform", "onServiceConnected4");
                        Log.e("AdvertisingIdPlatform", "onServiceConnected error:" + e.getMessage());
                        b.this.e.countDown();
                        b.this.e.countDown();
                        b.this.a();
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }
        }).start();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Log.i("AdvertisingIdPlatform", "onServiceDisconnected ");
        this.e.countDown();
        this.e.countDown();
    }
}
