package com.kwad.components.core.innerEc;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.offline.api.adInnerEc.login.IAdInnerEcLoginBindListener;
import com.kwad.components.offline.api.adInnerEc.login.InnerEcLoginResponse;
import com.kwad.components.offline.api.core.adInnerEc.IAdInnerEcExternalModule;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bz;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class e {
    private static volatile e ST;
    private static final AtomicBoolean SV = new AtomicBoolean(false);
    private static final AtomicBoolean SW = new AtomicBoolean(false);
    private static final AtomicBoolean SX = new AtomicBoolean(false);
    private IAdInnerEcExternalModule SU;
    private final String TAG = "InnerEcLoginManager";
    private InnerEcUserLoginBindInfo SY = new InnerEcUserLoginBindInfo();

    public static void b(String str, c cVar, String str2) {
        new d().a(str, cVar, str2);
    }

    private long getExpire() {
        return this.SY.expire;
    }

    private void init() {
        AtomicBoolean atomicBoolean = SV;
        if (atomicBoolean.get() || SX.get()) {
            return;
        }
        AtomicBoolean atomicBoolean2 = SW;
        if (!atomicBoolean2.get()) {
            if (bz.aE(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion(), "4.10.30")) {
                try {
                    com.kwad.sdk.service.c.putComponentProxy(Class.forName("com.kwad.auth.login.KwadRouteHandlerActivity"), RouteHandlerActivityProxy.class);
                } catch (Throwable unused) {
                    SX.set(true);
                    return;
                }
            } else {
                try {
                    com.kwad.sdk.service.c.putComponentProxy(Class.forName("com.kwai.auth.login.kwailogin.applogin.RouteHandlerActivity"), RouteHandlerActivityProxy.class);
                } catch (Throwable unused2) {
                    SX.set(true);
                    return;
                }
            }
            atomicBoolean2.set(true);
        }
        com.kwad.components.core.offline.a.a.a aVar = (com.kwad.components.core.offline.a.a.a) com.kwad.sdk.components.d.f(com.kwad.components.core.offline.a.a.a.class);
        if (aVar == null || !aVar.tr()) {
            return;
        }
        Context context = ServiceProvider.getContext();
        com.kwad.sdk.core.d.c.w("InnerEcLoginManager", "getApp: " + context);
        context.getApplicationContext();
        IAdInnerEcExternalModule iAdInnerEcExternalModuleTs = aVar.ts();
        this.SU = iAdInnerEcExternalModuleTs;
        if (iAdInnerEcExternalModuleTs != null) {
            atomicBoolean.set(true);
            rh();
        }
    }

    public static boolean isReady() {
        return SV.get();
    }

    public static e rf() {
        if (ST == null) {
            synchronized (e.class) {
                if (ST == null) {
                    ST = new e();
                }
            }
        }
        if (!SV.get()) {
            ST.init();
        }
        return ST;
    }

    private boolean rh() {
        try {
            String strF = ai.f(ServiceProvider.getContext(), true);
            if (!TextUtils.isEmpty(strF)) {
                InnerEcUserLoginBindInfo innerEcUserLoginBindInfo = new InnerEcUserLoginBindInfo();
                innerEcUserLoginBindInfo.parseJson(new JSONObject(strF));
                this.SY = innerEcUserLoginBindInfo;
            }
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            return false;
        }
    }

    public final void a(Activity activity, IAdInnerEcLoginBindListener iAdInnerEcLoginBindListener, String str) {
        com.kwad.sdk.core.d.c.i("InnerEcLoginManager", "click start");
        if (!SV.get()) {
            iAdInnerEcLoginBindListener.onFailed(-1, "adInnerEcExternalModule is null", 2);
            return;
        }
        IAdInnerEcExternalModule iAdInnerEcExternalModule = this.SU;
        if (iAdInnerEcExternalModule == null) {
            iAdInnerEcLoginBindListener.onFailed(-1, "adInnerEcExternalModule is null", 2);
        } else {
            iAdInnerEcExternalModule.startLoginAuth(activity, iAdInnerEcLoginBindListener, str);
        }
    }

    @Nullable
    public final String getServiceToken() {
        return this.SY.serviceToken;
    }

    @Nullable
    public final String getSid() {
        return this.SY.sid;
    }

    public final long getUserId() {
        return this.SY.userId;
    }

    public final String re() {
        return this.SY.userName;
    }

    public final boolean rg() {
        if (SV.get() && !ai.Vf()) {
            return (!ai.Ve() || rh()) && getExpire() > 0 && !TextUtils.isEmpty(getServiceToken()) && !TextUtils.isEmpty(getSid()) && getUserId() > 0 && System.currentTimeMillis() < getExpire();
        }
        return false;
    }

    public final void b(InnerEcUserLoginBindInfo innerEcUserLoginBindInfo) {
        if (innerEcUserLoginBindInfo != null) {
            this.SY = innerEcUserLoginBindInfo;
            ai.c(ServiceProvider.getContext(), innerEcUserLoginBindInfo.toJson().toString(), false);
        }
    }

    public final void a(InnerEcLoginResponse innerEcLoginResponse, Activity activity) {
        if (!SV.get()) {
            activity.finish();
            return;
        }
        IAdInnerEcExternalModule iAdInnerEcExternalModule = this.SU;
        if (iAdInnerEcExternalModule == null) {
            activity.finish();
        } else {
            iAdInnerEcExternalModule.handleLoginResponse(innerEcLoginResponse, activity);
        }
    }
}
