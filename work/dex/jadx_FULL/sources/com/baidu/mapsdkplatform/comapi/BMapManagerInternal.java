package com.baidu.mapsdkplatform.comapi;

import android.content.Context;
import android.content.IntentFilter;
import android.util.Log;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapapi.VersionInfo;
import com.baidu.mapapi.common.BaiduMapSDKException;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;
import com.baidu.mapsdkplatform.comapi.util.c;
import com.baidu.mapsdkplatform.comapi.util.f;
import com.baidu.mapsdkplatform.comjni.tools.a;
import com.igexin.sdk.PushConsts;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BMapManagerInternal implements PermissionCheck.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static BMapManagerInternal f26670a;
    private Context b;
    private NetworkListener c;
    private int d;
    private CopyOnWriteArrayList<MapAuthListener> e = new CopyOnWriteArrayList<>();

    static {
        NativeLoader.getInstance().loadLibrary(VersionInfo.getKitName());
        a.a();
    }

    private BMapManagerInternal() {
    }

    private void b() {
        Context context;
        NetworkListener networkListener = this.c;
        if (networkListener == null || (context = this.b) == null) {
            return;
        }
        context.unregisterReceiver(networkListener);
    }

    public static BMapManagerInternal getInstance() {
        if (f26670a == null) {
            f26670a = new BMapManagerInternal();
        }
        return f26670a;
    }

    public void a(Context context) {
        this.b = context;
    }

    public void c() {
        int i = this.d - 1;
        this.d = i;
        if (i == 0) {
            b();
            Iterator<MapAuthListener> it = this.e.iterator();
            while (it.hasNext()) {
                this.e.remove(it.next());
            }
            f.u();
        }
    }

    public Context d() {
        if (this.b == null) {
            this.b = JNIInitializer.getCachedContext();
        }
        return this.b;
    }

    public void e() {
        if (this.d == 0) {
            if (this.b == null) {
                Context cachedContext = JNIInitializer.getCachedContext();
                this.b = cachedContext;
                if (cachedContext == null) {
                    Log.e("BDMapSDK", "BDMapSDKException: you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
                    return;
                }
            }
            this.c = new NetworkListener();
            a();
            SysUpdateObservable.getInstance().updateNetworkInfo(this.b);
        }
        this.d++;
    }

    public boolean permcheck() {
        if (this.b == null) {
            Context cachedContext = JNIInitializer.getCachedContext();
            this.b = cachedContext;
            if (cachedContext == null) {
                Log.e("BDMapSDK", "BDMapSDKException: you have not supplyed the global app context info from SDKInitializer.initialize(Context) function.");
                return false;
            }
        }
        f.e(this.b);
        if (Initializer.isAgreePrivacyMode()) {
            PermissionCheck.setPrivacyMode(true);
        } else {
            PermissionCheck.setPrivacyMode(false);
        }
        f.b(this.b);
        c.a().a(this.b);
        f.v();
        PermissionCheck.init(this.b);
        PermissionCheck.setPermissionCheckResultListener(this);
        PermissionCheck.permissionCheck();
        if (Initializer.isAgreePrivacyMode()) {
            return true;
        }
        throw new BaiduMapSDKException("not agree privacyMode, please invoke SDKInitializer.setAgreePrivacy(Context, boolean) function");
    }

    public void removeMapAuthListener(MapAuthListener mapAuthListener) {
        if (mapAuthListener != null) {
            this.e.remove(mapAuthListener);
        }
    }

    public void setMapAuthListener(MapAuthListener mapAuthListener) {
        if (mapAuthListener != null) {
            this.e.add(mapAuthListener);
        }
    }

    private void a() {
        NetworkListener networkListener;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        Context context = this.b;
        if (context == null || (networkListener = this.c) == null) {
            return;
        }
        context.registerReceiver(networkListener, intentFilter);
    }

    @Override // com.baidu.mapsdkplatform.comapi.util.PermissionCheck.d
    public void a(PermissionCheck.c cVar) {
        if (cVar == null) {
            return;
        }
        if (cVar.f26683a == 0) {
            f.F = cVar.e;
            for (MapAuthListener mapAuthListener : this.e) {
                if (mapAuthListener != null) {
                    mapAuthListener.setAuthParam(f.F);
                }
            }
            f.a(cVar.b, cVar.c);
        } else {
            Log.e("baidumapsdk", "Authentication Error\n" + cVar.toString());
        }
        int i = cVar.f26683a;
        if (i == PermissionCheck.k || i == PermissionCheck.j || i == PermissionCheck.l) {
            return;
        }
        c.a().c(cVar.f);
        c.a().d(cVar.g);
    }
}
