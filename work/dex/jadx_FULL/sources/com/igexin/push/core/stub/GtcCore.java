package com.igexin.push.core.stub;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.Menu;
import com.getui.gtc.api.GtcIdCallback;
import com.getui.gtc.api.GtcManager;
import com.getui.gtc.dim.Caller;
import com.igexin.c.a.c.a;
import com.igexin.push.core.a.b;
import com.igexin.push.core.e;
import com.igexin.push.core.e.f;
import com.igexin.push.core.e.f.AnonymousClass31;
import com.igexin.push.g.n;
import com.igexin.sdk.IPushCore;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class GtcCore implements IPushCore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f38082a = "GtcCore";

    public static /* synthetic */ void a(String str) {
        try {
            if (str.equals(e.C)) {
                return;
            }
            f fVarA = f.a();
            e.C = str;
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) fVarA.new AnonymousClass31(), false, true);
            if (e.u) {
                b.d().i();
            }
        } catch (Exception e) {
            a.a(e);
        }
    }

    private static void b(String str) {
        try {
            if (str.equals(e.C)) {
                return;
            }
            f fVarA = f.a();
            e.C = str;
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) fVarA.new AnonymousClass31(), false, true);
            if (e.u) {
                b.d().i();
            }
        } catch (Exception e) {
            a.a(e);
        }
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityConfigurationChanged(Activity activity, Configuration configuration) {
    }

    @Override // com.igexin.sdk.IPushCore
    public boolean onActivityCreateOptionsMenu(Activity activity, Menu menu) {
        return false;
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityDestroy(Activity activity) {
    }

    @Override // com.igexin.sdk.IPushCore
    public boolean onActivityKeyDown(Activity activity, int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityNewIntent(Activity activity, Intent intent) {
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityPause(Activity activity) {
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityRestart(Activity activity) {
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityResume(Activity activity) {
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityStart(Activity activity, Intent intent) {
    }

    @Override // com.igexin.sdk.IPushCore
    public void onActivityStop(Activity activity) {
    }

    @Override // com.igexin.sdk.IPushCore
    public IBinder onServiceBind(Intent intent) {
        return null;
    }

    @Override // com.igexin.sdk.IPushCore
    public void onServiceDestroy() {
    }

    @Override // com.igexin.sdk.IPushCore
    public int onServiceStartCommand(Intent intent, int i, int i2) {
        return 2;
    }

    @Override // com.igexin.sdk.IPushCore
    public boolean start(Context context) {
        a.a("GtcCore | ready to start gtc ", new Object[0]);
        final long jCurrentTimeMillis = System.currentTimeMillis();
        final AtomicInteger atomicInteger = new AtomicInteger(1);
        try {
            n.u();
            String strInitialize = GtcManager.getInstance().initialize(context, Caller.PUSH, new GtcIdCallback.Stub() { // from class: com.igexin.push.core.stub.GtcCore.1
                @Override // com.getui.gtc.api.GtcIdCallback
                public final void onFailure(String str) throws RemoteException {
                    a.a("GtcCore|gtcid callback error ,error info is :".concat(String.valueOf(str)), new Object[0]);
                }

                @Override // com.getui.gtc.api.GtcIdCallback
                public final void onSuccess(final String str) throws RemoteException {
                    System.currentTimeMillis();
                    a.a("GtcCore|gtcid = ".concat(String.valueOf(str)), new Object[0]);
                    if (e.m.get()) {
                        GtcCore.a(str);
                    } else {
                        final Handler handler = new Handler(Looper.getMainLooper());
                        handler.postDelayed(new Runnable() { // from class: com.igexin.push.core.stub.GtcCore.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                if (e.m.get()) {
                                    atomicInteger.get();
                                    GtcCore.a(str);
                                } else if (atomicInteger.incrementAndGet() <= 30) {
                                    atomicInteger.get();
                                    handler.postDelayed(this, 300L);
                                }
                            }
                        }, 300L);
                    }
                }
            });
            System.currentTimeMillis();
            a.a("GtcCore|gtcid = ".concat(String.valueOf(strInitialize)), new Object[0]);
        } catch (Throwable th) {
            a.a("GtcCore|init gtc error =  " + th.toString(), new Object[0]);
        }
        System.currentTimeMillis();
        return true;
    }
}
