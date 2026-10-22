package com.igexin.sdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.getui.gtc.base.GtcProvider;
import com.igexin.c.a.c.a;
import com.igexin.c.a.c.a.c;
import com.igexin.c.a.c.a.d;
import com.igexin.push.core.ServiceManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class PushService extends Service {
    private final String TAG = getClass().getName();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        String type = (intent == null || intent.getType() == null) ? "" : intent.getType();
        if (type.startsWith("GB-") || type.startsWith("PB-")) {
            ServiceManager.getInstance().a(this, intent, 0, 0);
            return null;
        }
        if (c.f37833a.equals(type)) {
            return d.a().f37835a.getBinder();
        }
        return type.startsWith("GTC-") ? ServiceManager.getInstance().a((Service) this, intent) : ServiceManager.getInstance().a((Service) this, intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        try {
            GtcProvider.setContext(this);
        } catch (Exception e) {
            a.a(e);
        }
        super.onCreate();
        ServiceManager.getInstance();
        ServiceManager.a((Context) this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ServiceManager serviceManager = ServiceManager.getInstance();
        a.a("ServiceManager|onDestroy...", new Object[0]);
        IPushCore iPushCore = serviceManager.f37915a;
        if (iPushCore != null) {
            iPushCore.onServiceDestroy();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        ServiceManager.getInstance();
        ServiceManager.a();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        ServiceManager.getInstance().a(this, intent, i, i2);
        return 2;
    }
}
