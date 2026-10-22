package com.amap.api.location;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.amap.api.col.p0003l.fj;
import com.amap.api.col.p0003l.fo;
import com.amap.api.col.p0003l.hl;
import com.amap.api.col.p0003l.m;
import com.autonavi.aps.amapapi.utils.b;
import com.autonavi.aps.amapapi.utils.g;
import com.zj.adlib.lua;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AMapLocationClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f26079a;
    lua b;

    public AMapLocationClient(Context context) throws Exception {
        a(context);
        try {
            if (context == null) {
                throw new IllegalArgumentException("Context参数不能为null");
            }
            this.f26079a = context.getApplicationContext();
            this.b = new lua(context, null, null);
        } catch (Throwable th) {
            b.a(th, "AMClt", "ne1");
        }
    }

    private static void a(Context context) throws Exception {
        m mVarA = fo.a(context, b.c());
        if (mVarA.f26036a == fo.c.SuccessCode) {
            return;
        }
        Log.e("AMapLocationClient", mVarA.f1069a);
        throw new Exception(mVarA.f1069a);
    }

    public static String getDeviceId(Context context) {
        return fj.f0(context);
    }

    public static void setApiKey(String str) {
        try {
            AMapLocationClientOption.f26080a = str;
        } catch (Throwable th) {
            b.a(th, "AMClt", "sKey");
        }
    }

    public static void setHost(String str) {
        if (TextUtils.isEmpty(str)) {
            hl.f25967a = -1;
            hl.f924a = "";
        } else {
            hl.f25967a = 1;
            hl.f924a = str;
        }
    }

    public static void updatePrivacyAgree(Context context, boolean z) {
        fo.i(context, z, b.c());
    }

    public static void updatePrivacyShow(Context context, boolean z, boolean z2) {
        fo.j(context, z, z2, b.c());
    }

    public void disableBackgroundLocation(boolean z) {
        try {
            lua luaVar = this.b;
            if (luaVar != null) {
                luaVar.B(z);
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "dBackL");
        }
    }

    public void enableBackgroundLocation(int i, Notification notification) {
        try {
            lua luaVar = this.b;
            if (luaVar != null) {
                luaVar.e(i, notification);
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "eBackL");
        }
    }

    public AMapLocation getLastKnownLocation() {
        try {
            lua luaVar = this.b;
            if (luaVar != null) {
                return luaVar.c0();
            }
            return null;
        } catch (Throwable th) {
            b.a(th, "AMClt", "gLastL");
            return null;
        }
    }

    public String getVersion() {
        return "6.1.0";
    }

    public boolean isStarted() {
        try {
            lua luaVar = this.b;
            if (luaVar != null) {
                return luaVar.C();
            }
            return false;
        } catch (Throwable th) {
            b.a(th, "AMClt", "isS");
            return false;
        }
    }

    public void onDestroy() {
        try {
            lua luaVar = this.b;
            if (luaVar != null) {
                luaVar.W();
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "onDy");
        }
    }

    public void setLocationListener(AMapLocationListener aMapLocationListener) {
        try {
            if (aMapLocationListener == null) {
                throw new IllegalArgumentException("listener参数不能为null");
            }
            lua luaVar = this.b;
            if (luaVar != null) {
                luaVar.r(aMapLocationListener);
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "sLocL");
        }
    }

    public void setLocationOption(AMapLocationClientOption aMapLocationClientOption) {
        try {
            if (aMapLocationClientOption == null) {
                throw new IllegalArgumentException("LocationManagerOption参数不能为null");
            }
            lua luaVar = this.b;
            if (luaVar != null) {
                luaVar.q(aMapLocationClientOption);
            }
            if (aMapLocationClientOption.b) {
                aMapLocationClientOption.b = false;
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(aMapLocationClientOption.c)) {
                    jSONObject.put("amap_loc_scenes_type", aMapLocationClientOption.c);
                }
                g.a(this.f26079a, "O019", jSONObject);
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "sLocnO");
        }
    }

    public void startAssistantLocation(WebView webView) {
        try {
            lua luaVar = this.b;
            if (luaVar != null) {
                luaVar.m(webView);
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "sttAssL1");
        }
    }

    public void startLocation() {
        try {
            lua luaVar = this.b;
            if (luaVar != null) {
                luaVar.G();
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "stl");
        }
    }

    public void stopAssistantLocation() {
        try {
            lua luaVar = this.b;
            if (luaVar != null) {
                luaVar.f0();
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "stAssL");
        }
    }

    public void stopLocation() {
        try {
            lua luaVar = this.b;
            if (luaVar != null) {
                luaVar.R();
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "stl");
        }
    }

    public void unRegisterLocationListener(AMapLocationListener aMapLocationListener) {
        try {
            lua luaVar = this.b;
            if (luaVar != null) {
                luaVar.K(aMapLocationListener);
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "unRL");
        }
    }

    public AMapLocationClient(Context context, Intent intent) throws Exception {
        a(context);
        try {
            if (context != null) {
                this.f26079a = context.getApplicationContext();
                this.b = new lua(this.f26079a, intent, null);
                return;
            }
            throw new IllegalArgumentException("Context参数不能为null");
        } catch (Throwable th) {
            b.a(th, "AMClt", "ne2");
        }
    }

    public AMapLocationClient(Looper looper, Context context) throws Exception {
        a(context);
        try {
            if (context != null) {
                this.f26079a = context.getApplicationContext();
                this.b = new lua(this.f26079a, null, looper);
                return;
            }
            throw new IllegalArgumentException("Context参数不能为null");
        } catch (Throwable th) {
            b.a(th, "AMClt", "ne3");
        }
    }
}
