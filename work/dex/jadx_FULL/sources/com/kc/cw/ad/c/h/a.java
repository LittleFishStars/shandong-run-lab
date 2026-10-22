package com.kc.cw.ad.c.h;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f38746a = null;
    public String b = null;
    public String c = null;
    public Object d = new Object();
    public ServiceConnection e = new d(this);

    /* JADX INFO: renamed from: com.kc.cw.ad.c.h.a$a, reason: collision with other inner class name */
    @Keep
    public static class C0978a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f38748a = new a(null);
    }

    public a(d dVar) {
    }

    public final String a(Context context, String str) {
        if (TextUtils.isEmpty(this.b)) {
            this.b = context.getPackageName();
        }
        String strA = null;
        if (TextUtils.isEmpty(this.c)) {
            this.c = new g(new g.a(this) { // from class: com.kc.cw.ad.c.h.a.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final a f38747a;

                {
                    this.f38747a = this;
                }

                @Override // com.kc.cw.ad.c.h.g.a
                public String a(String str2, String str3, String str4) {
                    return str3;
                }
            }).a(context, null);
        }
        try {
            strA = ((c.a.C0979a) this.f38746a).a(this.b, this.c, str);
        } catch (RemoteException unused) {
        }
        return TextUtils.isEmpty(strA) ? "" : strA;
    }

    public boolean a(Context context) {
        boolean z = false;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0);
            if (Build.VERSION.SDK_INT >= 28) {
                if (packageInfo != null && packageInfo.getLongVersionCode() >= 1) {
                    z = true;
                }
            } else if (packageInfo != null && packageInfo.versionCode >= 1) {
                z = true;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return z;
    }

    public String b(Context context, String str) {
        synchronized (this) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new IllegalStateException("Cannot run on MainThread");
            }
            if (this.f38746a == null) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                if (context.bindService(intent, this.e, 1)) {
                    synchronized (this.d) {
                        try {
                            this.d.wait(3000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (this.f38746a == null) {
                    return "";
                }
            }
            return a(context, str);
        }
    }
}
