package com.beizi.fusion;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.bun.miitmdid.content.StringValues;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class pq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f27661a;
    String b = "com.mdid.msa";
    public final LinkedBlockingQueue c = new LinkedBlockingQueue(1);
    ServiceConnection d = new a();

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                pq.this.c.put(iBinder);
            } catch (Exception e) {
                om.a(e);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public pq(Context context) {
        this.f27661a = context;
    }

    private int a() {
        try {
            this.f27661a.getPackageManager().getPackageInfo(this.b, 0);
            return 1;
        } catch (Exception e) {
            om.a(e);
            return 0;
        }
    }

    private void a(String str) {
        a();
        Intent intent = new Intent();
        intent.setClassName(this.b, "com.mdid.msa.service.MsaKlService");
        intent.setAction(StringValues.ACTION_START_MSASERVICE);
        intent.putExtra(StringValues.PARAM_BIND_PKGNAME, str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            this.f27661a.startService(intent);
        } catch (Exception e) {
            om.a(e);
        }
    }

    public void a(c7.a aVar) {
        try {
            this.f27661a.getPackageManager().getPackageInfo(this.b, 0);
        } catch (Exception e) {
            om.a(e);
        }
        String packageName = this.f27661a.getPackageName();
        a(packageName);
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction(StringValues.ACTION_BINDTO_MSASERVICE);
        intent.putExtra(StringValues.PARAM_BIND_PKGNAME, packageName);
        if (this.f27661a.bindService(intent, this.d, 1)) {
            try {
                String oaid = new sq((IBinder) this.c.take()).getOAID();
                if (aVar != null) {
                    aVar.a(oaid);
                }
                this.f27661a.unbindService(this.d);
            } catch (Exception e2) {
                om.a(e2);
            }
        }
    }
}
