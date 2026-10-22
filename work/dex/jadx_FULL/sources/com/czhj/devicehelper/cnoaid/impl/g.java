package com.czhj.devicehelper.cnoaid.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.czhj.sdk.logger.SigmobLog;
import java.lang.reflect.Method;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
class g implements com.czhj.devicehelper.cnoaid.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f29340a;
    private final Handler b = new Handler(Looper.getMainLooper());
    private boolean c;

    public g(Context context) {
        this.f29340a = context;
    }

    private void a(final com.czhj.devicehelper.cnoaid.c cVar, final com.czhj.devicehelper.cnoaid.f fVar) {
        this.b.post(new Runnable() { // from class: com.czhj.devicehelper.cnoaid.impl.g.3
            @Override // java.lang.Runnable
            public void run() {
                cVar.a(fVar);
            }
        });
    }

    private void a(final com.czhj.devicehelper.cnoaid.c cVar, final String str) {
        this.b.post(new Runnable() { // from class: com.czhj.devicehelper.cnoaid.impl.g.2
            @Override // java.lang.Runnable
            public void run() {
                cVar.a(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.czhj.devicehelper.cnoaid.c cVar) {
        String str;
        try {
            if (this.c) {
                com.czhj.devicehelper.honor.identifier.a.C0612a c0612aA = com.czhj.devicehelper.honor.identifier.a.a(this.f29340a);
                if (c0612aA == null) {
                    return;
                } else {
                    str = c0612aA.f29368a;
                }
            } else {
                Method method = Class.forName("com.hihonor.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", Context.class);
                if (method == null) {
                    return;
                }
                Object objInvoke = method.invoke(null, this.f29340a);
                if (objInvoke == null) {
                    a(cVar, new com.czhj.devicehelper.cnoaid.f("HIDeviceIDHelper info is null"));
                    return;
                }
                Object obj = objInvoke.getClass().getField("id").get(objInvoke);
                if (!(obj instanceof String)) {
                    return;
                } else {
                    str = (String) obj;
                }
            }
            a(cVar, str);
        } catch (Throwable th) {
            a(cVar, new com.czhj.devicehelper.cnoaid.f(th));
        }
    }

    @Override // com.czhj.devicehelper.cnoaid.d
    public void a(final com.czhj.devicehelper.cnoaid.c cVar) {
        if (this.f29340a == null || cVar == null) {
            return;
        }
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.czhj.devicehelper.cnoaid.impl.g.1
            @Override // java.lang.Runnable
            public void run() {
                g.this.b(cVar);
            }
        });
    }

    @Override // com.czhj.devicehelper.cnoaid.d
    public boolean a() {
        if (this.f29340a == null) {
            return false;
        }
        try {
            Object objInvoke = Class.forName("com.hihonor.ads.identifier.AdvertisingIdClient").getMethod("isAdvertisingIdAvailable", Context.class).invoke(null, this.f29340a);
            if (objInvoke instanceof Boolean) {
                return ((Boolean) objInvoke).booleanValue();
            }
            return false;
        } catch (Throwable th) {
            SigmobLog.e("HIDeviceIDHelper isAdvertisingIdAvailable error ", th);
            try {
                boolean zB = com.czhj.devicehelper.honor.identifier.a.b(this.f29340a);
                this.c = true;
                return zB;
            } catch (Throwable unused) {
            }
        }
    }
}
