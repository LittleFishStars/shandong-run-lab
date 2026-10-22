package com.kwad.sdk.core.e.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class c {
    public C1283c aUF;
    public Context mContext;
    public final a aUG = new a();
    public final b aUH = new b();
    public final CountDownLatch mCountDownLatch = new CountDownLatch(2);

    public class a extends com.kwad.sdk.core.e.b.c.a {
        public a() {
        }

        @Override // com.kwad.sdk.core.e.b.c.a
        public final void a(int i, Bundle bundle) {
            com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", "OAIDCallBack handleResult retCode = " + i + " retInfo = " + bundle);
            if (i == 0) {
                try {
                    C1283c c1283c = c.this.aUF;
                    if (c1283c != null) {
                        c1283c.id = bundle.getString("oa_id_flag");
                        com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", "OAIDCallBack handleResult success");
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", "OAIDCallBack handleResult error: " + th.getMessage());
                    return;
                }
            }
            c.a(c.this);
        }
    }

    public class b extends com.kwad.sdk.core.e.b.c.a {
        public b() {
        }

        @Override // com.kwad.sdk.core.e.b.c.a
        public final void a(int i, Bundle bundle) {
            com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", "OAIDLimitCallback handleResult retCode=" + i + " retInfo= " + bundle);
            if (i == 0) {
                try {
                    if (c.this.aUF != null) {
                        boolean z = bundle.getBoolean("oa_id_limit_state");
                        c.this.aUF.aUJ = z;
                        com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", "OAIDLimitCallback handleResult success  isLimit=" + z);
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", "OAIDLimitCallback handleResult error:  " + th.getMessage());
                    return;
                }
            }
            c.a(c.this);
        }
    }

    /* JADX INFO: renamed from: com.kwad.sdk.core.e.a.c$c, reason: collision with other inner class name */
    public static final class C1283c {
        public boolean aUJ;
        public String id;
    }

    public static void a(c cVar) {
        try {
            cVar.mCountDownLatch.countDown();
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.d("HONORDeviceIDHelper", "doCountDown  error:  " + e.getMessage());
        }
    }

    public static boolean isAdvertisingIdAvailable(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
            return !packageManager.queryIntentServices(intent, 0).isEmpty();
        } catch (Exception unused) {
        }
    }
}
