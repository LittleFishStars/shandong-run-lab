package com.getui.gtc.g.a;

import android.content.Context;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Pair;
import com.getui.gtc.base.util.CommonUtil;
import com.igexin.push.GtPushInterface;
import com.kuaishou.weapon.p0.t;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Handler f30362a;
    public GtPushInterface b;

    public a(final b bVar) {
        final HandlerThread handlerThread = new HandlerThread("Plugin Handler Thread");
        handlerThread.start();
        this.f30362a = new Handler(handlerThread.getLooper()) { // from class: com.getui.gtc.g.a.a.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                try {
                    if (message.what < 0) {
                        b bVar2 = bVar;
                        if (bVar2 != null) {
                            bVar2.a(false);
                            return;
                        }
                        return;
                    }
                    boolean zLoadSdk = a.this.b.loadSdk(message.getData());
                    b bVar3 = bVar;
                    if (bVar3 != null) {
                        bVar3.a(zLoadSdk);
                    }
                    handlerThread.quit();
                    a.this.f30362a = null;
                } catch (Exception e) {
                    com.getui.gtc.i.c.a.b(e);
                    b bVar4 = bVar;
                    if (bVar4 != null) {
                        bVar4.a(false);
                    }
                }
            }
        };
    }

    public static Pair<ServiceInfo, Class> a(Context context, Class cls) {
        boolean z;
        try {
            ServiceInfo[] serviceInfoArr = CommonUtil.getPackageInfoForSelf(context).services;
            if (serviceInfoArr == null || serviceInfoArr.length <= 0) {
                com.getui.gtc.i.c.a.b("no any service");
            } else {
                int length = serviceInfoArr.length;
                for (int i = 0; i < length; i++) {
                    ServiceInfo serviceInfo = serviceInfoArr[i];
                    try {
                        Class<?> cls2 = Class.forName(serviceInfo.name);
                        if (cls2 != cls) {
                            int i2 = 5;
                            Class<?> superclass = cls2;
                            while (true) {
                                if (superclass == null || cls == null || i2 <= 0) {
                                    z = false;
                                    break;
                                }
                                if (superclass == cls) {
                                    z = true;
                                    break;
                                }
                                if (superclass.getSuperclass() == null) {
                                    z = false;
                                    break;
                                }
                                superclass = superclass.getSuperclass();
                                i2--;
                            }
                            if (z) {
                                return Pair.create(serviceInfo, cls2);
                            }
                            continue;
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.a("findGtImplClassInManifest error", th);
        }
        return Pair.create(null, null);
    }

    public final void a(String str, String str2, String str3, String str4, String str5) {
        Bundle bundle = new Bundle();
        bundle.putString(t.q, str);
        bundle.putString("od", str2);
        bundle.putString("cn", str3);
        bundle.putString("ad", str4);
        bundle.putString("gd", str5);
        Message messageObtain = Message.obtain();
        messageObtain.setData(bundle);
        messageObtain.what = 0;
        Handler handler = this.f30362a;
        if (handler != null) {
            messageObtain.setTarget(handler);
            messageObtain.sendToTarget();
        }
    }
}
