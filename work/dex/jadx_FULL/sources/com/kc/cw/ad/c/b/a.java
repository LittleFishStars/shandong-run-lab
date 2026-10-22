package com.kc.cw.ad.c.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import com.kc.openset.constant.DeviceIdType;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a implements com.kc.cw.ad.c.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f38729a = "";

    /* JADX INFO: renamed from: com.kc.cw.ad.c.b.a$a, reason: collision with other inner class name */
    @Keep
    public static final class BinderC0972a extends com.kc.cw.ad.c.b.b.a {
        private BinderC0972a() {
        }

        @Override // com.kc.cw.ad.c.b.b
        public void a(int i, long j, boolean z, float f, double d, String str) throws RemoteException {
        }

        @Override // com.kc.cw.ad.c.b.b
        public void a(int i, Bundle bundle) throws RemoteException {
            if (i != 0 || bundle == null) {
                return;
            }
            String string = bundle.getString("oa_id_flag");
            if (a.a(string)) {
                String unused = a.f38729a = string;
            }
        }
    }

    @Keep
    public static final class b implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f38730a;
        private final LinkedBlockingQueue<IBinder> b;

        private b() {
            this.f38730a = false;
            this.b = new LinkedBlockingQueue<>();
        }

        public IBinder a() throws InterruptedException {
            if (this.f38730a) {
                throw new IllegalStateException();
            }
            this.f38730a = true;
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

    public static boolean a(String str) {
        return (TextUtils.isEmpty(str) || str.equalsIgnoreCase("00000000-0000-0000-0000-000000000000")) ? false : true;
    }

    @Override // com.kc.cw.ad.c.c
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (!Boolean.parseBoolean(Settings.Secure.getString(context.getContentResolver(), "oaid_limit_state"))) {
                String string = Settings.Global.getString(context.getContentResolver(), DeviceIdType.OAID);
                if (a(string)) {
                    f38729a = string;
                    return string;
                }
            }
        } catch (Throwable unused) {
        }
        b bVar = new b();
        Intent intent = new Intent();
        intent.setAction("com.hihonor.id.HnOaIdService");
        intent.setPackage("com.hihonor.id");
        if (context.bindService(intent, bVar, 1)) {
            try {
                c.a.a(bVar.a()).a(new BinderC0972a());
                return f38729a;
            } catch (Exception unused2) {
            } finally {
                context.unbindService(bVar);
            }
        }
        return null;
    }
}
