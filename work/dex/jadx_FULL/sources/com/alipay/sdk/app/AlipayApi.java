package com.alipay.sdk.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import com.alipay.sdk.app.debug.AlipayDebugOptions;
import com.alipay.sdk.m.o.b;
import com.alipay.sdk.m.y.g;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlipayApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25364a = "com.eg.android.AlipayGphone";
    public static final String b = "com.eg.android.AlipayGphone.CashierSDKRegister";
    public static final String c = "appId";
    public static final int d = 3670;
    public static ServiceConnection e = null;
    public static boolean f = false;
    public static WeakReference<Context> g;
    public static AlipayDebugOptions h;

    public class a implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
            AlipayApi.f = false;
            AlipayApi.e = null;
            g.d(com.alipay.sdk.m.n.a.B, "AlipayApi registerApp onBindingDied");
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
            AlipayApi.f = true;
            g.d(com.alipay.sdk.m.n.a.B, "AlipayApi registerApp onNullBinding");
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            g.d(com.alipay.sdk.m.n.a.B, "AlipayApi registerApp onServiceConnected");
            AlipayApi.f = true;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            AlipayApi.f = false;
            AlipayApi.e = null;
            g.d(com.alipay.sdk.m.n.a.B, "AlipayApi registerApp onServiceDisconnected");
        }
    }

    public static boolean a(Context context) {
        PackageManager packageManager;
        try {
            boolean z = true;
            if (b.i().w()) {
                return true;
            }
            if (context == null || (packageManager = context.getPackageManager()) == null) {
                return false;
            }
            PackageInfo packageInfo = packageManager.getPackageInfo("com.eg.android.AlipayGphone", 0);
            if (packageInfo == null) {
                g.d(com.alipay.sdk.m.n.a.B, "AlipayApi isAlipayVersionSupportRegister packageInfo is null");
                return false;
            }
            int i = packageInfo.versionCode;
            if (i < 3670) {
                z = false;
            }
            g.d(com.alipay.sdk.m.n.a.B, "AlipayApi isAlipayVersionSupportRegister versionCode:" + i + " isSupport:" + z);
            return z;
        } catch (Exception e2) {
            g.a(e2);
            g.d(com.alipay.sdk.m.n.a.B, "AlipayApi isAlipayVersionSupportRegister exception");
            return false;
        }
    }

    public static void registerApp(Context context, String str) {
        if (context == null) {
            return;
        }
        com.alipay.sdk.m.w.b.c().a(context);
        boolean z = !b.i().c(null);
        g.d(com.alipay.sdk.m.n.a.B, "AlipayApi registerApp appId: " + str + " isSupportRegisterApp:" + z + " registerAppServiceConnectSuccess:" + f);
        if (z) {
            if (!a(context.getApplicationContext())) {
                g.d(com.alipay.sdk.m.n.a.B, "AlipayApi version not support registerApp");
                return;
            }
            boolean zF = b.i().f(null);
            g.d(com.alipay.sdk.m.n.a.B, "AlipayApi registerApp isFetchConfigWhenRegisterApp: " + zF);
            if (zF) {
                PayTask.fetchSdkConfig(context);
            }
            if (f) {
                return;
            }
            Intent intent = new Intent();
            intent.setPackage("com.eg.android.AlipayGphone");
            intent.setAction(b);
            Bundle bundle = new Bundle();
            bundle.putString("appId", str);
            intent.putExtras(bundle);
            a aVar = new a();
            e = aVar;
            try {
                g.d(com.alipay.sdk.m.n.a.B, "AlipayApi registerApp bindServiceResult:" + context.bindService(intent, aVar, 1));
            } catch (Throwable th) {
                g.a(th);
            }
            g = new WeakReference<>(context);
        }
    }

    public static void setAlipayDebugOptions(AlipayDebugOptions alipayDebugOptions) {
        h = alipayDebugOptions;
    }
}
