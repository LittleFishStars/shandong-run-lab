package com.alibaba.triver.kit.api.systemInfo;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.commonability.core.b.a;
import com.alibaba.ariver.commonability.device.proxy.RVCommonAbilityProxy;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;
import com.alibaba.fastjson.JSONObject;
import com.baidu.location.BDLocation;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.ut.device.UTDevice;
import com.zj.adlib.ze1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SystemInfoUtil {
    private static void appendProxyInfo(a.C0141a c0141a) {
        RVCommonAbilityProxy rVCommonAbilityProxy = (RVCommonAbilityProxy) RVProxy.get(RVCommonAbilityProxy.class);
        if (rVCommonAbilityProxy == null) {
            return;
        }
        c0141a.f23934a = rVCommonAbilityProxy.getAppAlias();
        c0141a.c = rVCommonAbilityProxy.getDevicePerformance();
        c0141a.d = rVCommonAbilityProxy.getLocalLanguage();
        c0141a.e = rVCommonAbilityProxy.getFontSizeSetting();
    }

    public static JSONObject getClientInfo(Context context) {
        if (context == null) {
            context = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("os.name", (Object) "Android");
        jSONObject.put("os.version", (Object) Build.VERSION.RELEASE);
        jSONObject.put("device.id", (Object) UTDevice.getUtdid(context));
        jSONObject.put("client.version", (Object) RVKernelUtils.getClientVersion());
        jSONObject.put(ze1.k, (Object) Build.MODEL);
        return jSONObject;
    }

    public static JSONObject getSystemInfo(Context context, a.C0141a c0141a) {
        JSONObject jSONObject = new JSONObject();
        if (context == null) {
            return jSONObject;
        }
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            jSONObject.put("apiLevel", (Object) Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.put("brand", (Object) Build.BRAND);
            jSONObject.put("storage", (Object) a.a(context));
            jSONObject.put(BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_SYSTEM, (Object) Build.VERSION.RELEASE);
            jSONObject.put("platform", (Object) "Android");
            jSONObject.put(ze1.k, (Object) (Build.MANUFACTURER + " " + Build.MODEL));
            if (displayMetrics == null) {
                return jSONObject;
            }
            float f = displayMetrics.density;
            int iRound = Math.round(displayMetrics.widthPixels / f);
            jSONObject.put("screenHeight", (Object) Integer.valueOf(displayMetrics.heightPixels));
            jSONObject.put("screenWidth", (Object) Integer.valueOf(displayMetrics.widthPixels));
            jSONObject.put("pixelRatio", (Object) Float.valueOf(f));
            jSONObject.put("windowWidth", (Object) Integer.valueOf(iRound));
            if (c0141a == null) {
                return jSONObject;
            }
            jSONObject.put("currentBattery", (Object) (c0141a.g + "%"));
            jSONObject.put("transparentTitle", (Object) Boolean.valueOf(c0141a.k));
            jSONObject.put("titleBarHeight", (Object) Integer.valueOf(Math.round(c0141a.h / f)));
            jSONObject.put(NativeCallContext.DOMAIN_APP, (Object) c0141a.f23934a);
            jSONObject.put("performance", (Object) c0141a.c);
            jSONObject.put(MediaFormat.KEY_LANGUAGE, (Object) c0141a.d);
            jSONObject.put("version", (Object) c0141a.f);
            float f2 = c0141a.e;
            if (f2 == 0.0f) {
                f2 = 16.0f;
            }
            jSONObject.put("fontSizeSetting", (Object) Float.valueOf(f2));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static String getSystemInfoInner(Page page) {
        return getSystemInfoInnerJSON(page).toJSONString();
    }

    public static JSONObject getSystemInfoInnerJSON(Page page) {
        try {
            a aVar = new a();
            a.C0141a c0141aA = a.C0141a.a();
            RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
            if (TextUtils.equals(rVConfigService != null ? rVConfigService.getConfig("ta_getDefaultHeight", "YES") : null, "YES") && page != null) {
                Bundle startParams = page.getStartParams();
                String string = startParams.getString("enableTabBar");
                String string2 = startParams.getString(RVStartParams.KEY_FRAGMENT_TYPE);
                if (TextUtils.equals(string, "YES") || TextUtils.equals(string2, RVStartParams.FRAGMENT_TYPE_SUB_TAB)) {
                    c0141aA.l = true;
                }
                c0141aA.b = startParams.getBoolean("fullscreen", false);
            }
            if (page != null) {
                if (page.getApp() != null) {
                    c0141aA.m = page.getApp().getAppId();
                }
                c0141aA.h = page.getApp().getAppContext().getViewSpecProvider().getTitleBarRawHeight();
                c0141aA.i = View.MeasureSpec.getSize(page.getApp().getAppContext().getViewSpecProvider().getTabBarHeightSpec());
                if (page.getRender() != null && page.getRender().getView() != null) {
                    c0141aA.j = page.getRender().getView().getHeight();
                }
            }
            RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
            if (rVEnvironmentService != null) {
                c0141aA.f = rVEnvironmentService.getProductVersion();
            }
            appendProxyInfo(c0141aA);
            if (page != null) {
                String string3 = page.getStartParams().getString("transparentTitle");
                if (TextUtils.equals(string3, "auto") || TextUtils.equals(string3, RVStartParams.TRANSPARENT_TITLE_ALWAYS) || TextUtils.equals(string3, "custom")) {
                    c0141aA.k = true;
                } else {
                    c0141aA.k = false;
                }
            }
            return page != null ? aVar.a(page.getPageContext().getActivity(), c0141aA) : getSystemInfo(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext(), c0141aA);
        } catch (Exception unused) {
            return new JSONObject();
        }
    }
}
