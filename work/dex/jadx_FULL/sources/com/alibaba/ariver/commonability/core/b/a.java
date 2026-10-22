package com.alibaba.ariver.commonability.core.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.alibaba.ariver.commonability.core.util.CommonUtils;
import com.alibaba.ariver.commonability.core.util.d;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.multiinstance.InstanceType;
import com.alibaba.ariver.kernel.common.multiinstance.MultiInstanceUtils;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.baidu.location.BDLocation;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.hjq.permissions.Permission;
import com.zj.adlib.ze1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f23933a = 16.0f;
    private static final String b = "CommonAbility#systemInfo";

    /* JADX INFO: renamed from: com.alibaba.ariver.commonability.core.b.a$a, reason: collision with other inner class name */
    public static class C0141a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f23934a;
        public boolean b;
        public String c;
        public String d;
        public float e;
        public String f;
        public int g;
        public float h;
        public float i;
        public float j;
        public boolean k;
        public boolean l;
        public String m;
        public int n;
        public InstanceType o = MultiInstanceUtils.getDefaultInstanceType();

        public static C0141a a() {
            return new C0141a();
        }
    }

    private int b(Activity activity, float f) {
        try {
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            float fB = rect.top;
            if (fB == 0.0f) {
                fB = b(activity);
            }
            if (f == 0.0f) {
                f = CommonUtils.dip2px(activity, 48.0f);
            }
            return (int) (f + fB);
        } catch (Throwable unused) {
            return CommonUtils.dip2px(activity, 1.0f) * 73;
        }
    }

    public JSONObject a(Activity activity, C0141a c0141a) {
        JSONObject jSONObject = new JSONObject();
        if (activity == null) {
            return jSONObject;
        }
        try {
            DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
            jSONObject.put("apiLevel", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("storage", a(activity));
            jSONObject.put(BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_SYSTEM, Build.VERSION.RELEASE);
            jSONObject.put("platform", "Android");
            jSONObject.put(ze1.k, Build.MANUFACTURER + " " + Build.MODEL);
            if (displayMetrics == null) {
                return jSONObject;
            }
            float f = displayMetrics.density;
            int iRound = Math.round(displayMetrics.widthPixels / f);
            jSONObject.put("screenHeight", Integer.valueOf(displayMetrics.heightPixels));
            jSONObject.put("screenWidth", Integer.valueOf(displayMetrics.widthPixels));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", (Object) Integer.valueOf(Math.round(displayMetrics.widthPixels / f)));
            jSONObject2.put("height", (Object) Integer.valueOf(Math.round(displayMetrics.heightPixels / f)));
            jSONObject.put("screen", (Object) jSONObject2);
            jSONObject.put("pixelRatio", Float.valueOf(f));
            jSONObject.put("windowWidth", Integer.valueOf(iRound));
            jSONObject.put("statusBarHeight", Float.valueOf(a(activity, f)));
            if (c0141a == null) {
                return jSONObject;
            }
            jSONObject.put("windowHeight", Integer.valueOf(a(activity, displayMetrics, c0141a)));
            jSONObject.put("currentBattery", c0141a.g + "%");
            jSONObject.put("transparentTitle", Boolean.valueOf(c0141a.k));
            jSONObject.put("titleBarHeight", Integer.valueOf(Math.round(c0141a.h / f)));
            jSONObject.put(NativeCallContext.DOMAIN_APP, c0141a.f23934a);
            jSONObject.put("performance", c0141a.c);
            jSONObject.put(MediaFormat.KEY_LANGUAGE, c0141a.d);
            jSONObject.put("version", c0141a.f);
            float f2 = c0141a.e;
            if (f2 == 0.0f) {
                f2 = 16.0f;
            }
            jSONObject.put("fontSizeSetting", Float.valueOf(f2));
            jSONObject.put("platformType", c0141a.o.getValue());
            a(activity, jSONObject);
        } catch (Exception e) {
            RVLogger.e("CommonAbility#systemInfo", "exception detail: " + e.getMessage());
        }
        return jSONObject;
    }

    private static float b(Context context) {
        if (context == null) {
            return 0.0f;
        }
        int identifier = context.getResources().getIdentifier(com.gyf.immersionbar.b.f6802a, "dimen", "android");
        return identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0;
    }

    public void a(Activity activity, JSONObject jSONObject) {
        boolean z = true;
        if (com.alibaba.ariver.commonability.core.util.b.a("ta_systeminfo_update_setting", true)) {
            jSONObject.put("cameraAuthorized", (Object) Boolean.valueOf(b.a(activity, Permission.CAMERA)));
            if (!b.a(activity, "android.permission.ACCESS_COARSE_LOCATION") && !b.a(activity, "android.permission.ACCESS_FINE_LOCATION")) {
                z = false;
            }
            jSONObject.put("locationAuthorized", (Object) Boolean.valueOf(z));
            jSONObject.put("microphoneAuthorized", (Object) Boolean.valueOf(b.a(activity, Permission.RECORD_AUDIO)));
            jSONObject.put("notificationAuthorized", (Object) Boolean.valueOf(b.a(activity)));
            jSONObject.put("bluetoothEnabled", (Object) Boolean.valueOf(b.a()));
            jSONObject.put("locationEnabled", (Object) Boolean.valueOf(b.b(activity)));
            jSONObject.put("wifiEnabled", (Object) Boolean.valueOf(b.c(activity)));
        }
    }

    private float a(Activity activity, float f) {
        Rect rect = new Rect();
        if (activity == null || f <= 0.0f) {
            return 0.0f;
        }
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        float fB = rect.top;
        if (fB == 0.0f) {
            fB = b(activity);
        }
        return fB / f;
    }

    private int a(Activity activity, DisplayMetrics displayMetrics, C0141a c0141a) {
        int iRound = 0;
        if (!c0141a.b && !c0141a.k) {
            int iB = b(activity, c0141a.h);
            if (displayMetrics != null) {
                iRound = Math.round((a(c0141a, displayMetrics, activity) - iB) / displayMetrics.density);
            }
        } else if (displayMetrics != null) {
            iRound = Math.round(a(c0141a, displayMetrics, activity) / displayMetrics.density);
        }
        if (c0141a.l) {
            iRound -= Math.round(c0141a.i / displayMetrics.density);
        }
        float f = c0141a.j;
        if (f > 0.0f) {
            int iRound2 = Math.round(f / displayMetrics.density);
            if (iRound2 > 0) {
                iRound = iRound2;
            }
            RVLogger.d("CommonAbility#systemInfo", "use webView Height");
        }
        RVLogger.d("CommonAbility#systemInfo", "webView height：" + c0141a.j + ",fullScreen：" + c0141a.b + ",transparentTitle：" + c0141a.k + ",enableTabBar：" + c0141a.l + ",final height：" + iRound);
        return iRound;
    }

    private static int a(C0141a c0141a, DisplayMetrics displayMetrics, Activity activity) {
        int i = displayMetrics.heightPixels;
        if (activity == null) {
            return i;
        }
        if (!a(c0141a)) {
            RVLogger.d("CommonAbility#systemInfo", "disable adapter navigationBar");
            return i;
        }
        if (d.a((Context) activity)) {
            RVLogger.d("CommonAbility#systemInfo", "has physical NavigationBar");
            return i;
        }
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        d.a(c0141a.n == 1);
        boolean zC = d.c(activity);
        WindowManager windowManager = (WindowManager) activity.getSystemService("window");
        if (windowManager == null) {
            return i;
        }
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics2);
        if (!zC) {
            int i2 = displayMetrics2.heightPixels;
            RVLogger.d("CommonAbility#systemInfo", "navigationBar is hiding");
            return i2;
        }
        int iB = displayMetrics2.heightPixels - d.b(activity);
        RVLogger.d("CommonAbility#systemInfo", "navigationBar is showing");
        return iB;
    }

    private static boolean a(C0141a c0141a) {
        RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
        if (rVConfigService != null && c0141a != null) {
            String config = rVConfigService.getConfig("ta_systemInfo_enable_height_adaptation", "");
            if (!TextUtils.isEmpty(config) && !TextUtils.isEmpty(c0141a.m)) {
                if (TextUtils.equals(config, "all")) {
                    return true;
                }
                try {
                    for (String str : config.split(",")) {
                        if (c0141a.m.equals(str.trim())) {
                            return true;
                        }
                    }
                } catch (Throwable th) {
                    RVLogger.e("CommonAbility#systemInfo", th);
                }
            }
        }
        return false;
    }

    public static String a(Context context) {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return com.alibaba.ariver.commonability.core.util.a.a(statFs.getBlockCountLong() * statFs.getBlockSizeLong());
        } catch (Throwable th) {
            RVLogger.e("CommonAbility#systemInfo", "getInternalMemorySize...", th);
            return "";
        }
    }
}
