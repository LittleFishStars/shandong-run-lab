package com.alibaba.ariver.commonability.device.jsapi.system.field.group;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ui.ViewUtils;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h extends com.alibaba.ariver.commonability.device.jsapi.system.field.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23997a = "CommonAbility#ViewPropFieldGroup";
    private static final String b = "screen";
    private static final String c = "screenHeight";
    private static final String d = "screenWidth";
    private static final String e = "pixelRatio";
    private static final String f = "windowHeight";
    private static final String g = "windowWidth";
    private static final String h = "titleBarHeight";
    private static final String i = "statusBarHeight";
    private static final String j = "transparentTitle";
    private int k = 0;
    private int l = 0;

    private int c(Context context) {
        int i2 = this.k;
        if (i2 != 0) {
            return i2;
        }
        if (context == null) {
            return 0;
        }
        int identifier = context.getResources().getIdentifier(com.gyf.immersionbar.b.f6802a, "dimen", "android");
        if (identifier > 0) {
            this.k = Math.round(context.getResources().getDimensionPixelSize(identifier) / context.getResources().getDisplayMetrics().density);
        }
        return this.k;
    }

    @Override // com.alibaba.ariver.commonability.device.jsapi.system.field.a.b
    public List<String> a() {
        ArrayList arrayList = new ArrayList(9);
        arrayList.add(b);
        arrayList.add(c);
        arrayList.add(d);
        arrayList.add(e);
        arrayList.add(f);
        arrayList.add(g);
        arrayList.add(h);
        arrayList.add(i);
        arrayList.add("transparentTitle");
        return arrayList;
    }

    @Override // com.alibaba.ariver.commonability.device.jsapi.system.field.a.b
    public void a(Context context, App app, Map<String, Object> map) {
        int iA;
        if (app == null) {
            return;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float f2 = displayMetrics.density;
        map.put(e, Float.valueOf(f2));
        Page activePage = app.getActivePage() != null ? app.getActivePage() : null;
        Bundle startParams = (activePage == null || activePage.getStartParams() == null) ? app.getStartParams() : activePage.getStartParams();
        boolean zIsTransparentTitle = ViewUtils.isTransparentTitle(startParams, startParams.getString("transparentTitle"));
        map.put("transparentTitle", Boolean.valueOf(zIsTransparentTitle));
        map.put(h, Integer.valueOf(a(context, app)));
        map.put(i, Integer.valueOf(c(context)));
        map.put(c, Integer.valueOf(displayMetrics.heightPixels));
        map.put(d, Integer.valueOf(displayMetrics.widthPixels));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", (Object) Integer.valueOf(Math.round(displayMetrics.widthPixels / f2)));
        jSONObject.put("height", (Object) Integer.valueOf(Math.round(displayMetrics.heightPixels / f2)));
        map.put(b, jSONObject);
        map.put(g, Integer.valueOf(Math.round(displayMetrics.widthPixels / f2)));
        if (activePage != null && activePage.getRender() != null && activePage.getRender().getView() != null && activePage.getRender().getView().getHeight() != 0) {
            iA = Math.round(activePage.getRender().getView().getHeight() / f2);
            RVLogger.d(f23997a, "use webView height");
        } else {
            RVLogger.d(f23997a, "use calculate height");
            iA = a(context, app, startParams, zIsTransparentTitle);
        }
        map.put(f, Integer.valueOf(iA));
    }

    private int a(Context context, App app, Bundle bundle, boolean z) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        boolean zEquals = TextUtils.equals(bundle.getString("enableTabBar"), "YES");
        int iRound = Math.round(a(displayMetrics, context, bundle.getInt(RVStartParams.KEY_NAVIGATION_BAR_STATUS)) / displayMetrics.density);
        if (!bundle.getBoolean("fullscreen", false) && !z) {
            iRound -= a(context, app) + c(context);
            RVLogger.d(f23997a, "No fullScreen:" + iRound);
        }
        if (!zEquals || !app.isFirstPage()) {
            return iRound;
        }
        int iRound2 = iRound - Math.round(View.MeasureSpec.getSize(app.getAppContext().getViewSpecProvider().getTabBarHeightSpec()) / displayMetrics.density);
        RVLogger.d(f23997a, "has tabBar:" + iRound2);
        return iRound2;
    }

    private int a(DisplayMetrics displayMetrics, Context context, int i2) {
        int i3 = displayMetrics.heightPixels;
        if (context == null) {
            return i3;
        }
        if (com.alibaba.ariver.commonability.core.util.d.a(context)) {
            RVLogger.d(f23997a, "has physical NavigationBar");
            return i3;
        }
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        com.alibaba.ariver.commonability.core.util.d.a(i2 == 1);
        boolean zC = com.alibaba.ariver.commonability.core.util.d.c(context);
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics2);
        if (!zC) {
            int i4 = displayMetrics2.heightPixels;
            RVLogger.d(f23997a, "navigationBar is hiding");
            return i4;
        }
        int iB = displayMetrics2.heightPixels - com.alibaba.ariver.commonability.core.util.d.b(context);
        RVLogger.d(f23997a, "navigationBar is showing");
        return iB;
    }

    private int a(Context context, App app) {
        int i2 = this.l;
        if (i2 != 0) {
            return i2;
        }
        if (context == null || app.getAppContext() == null || app.getAppContext().getViewSpecProvider() == null) {
            return 0;
        }
        int iRound = Math.round(app.getAppContext().getViewSpecProvider().getTitleBarRawHeight() / context.getResources().getDisplayMetrics().density);
        this.l = iRound;
        return iRound;
    }
}
