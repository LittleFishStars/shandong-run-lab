package com.alibaba.ariver.app;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.app.api.model.AppConfigModel;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f23812a = false;
    private static int b;
    private static int c;
    private static float d;

    private static void a(Context context) {
        if (f23812a) {
            return;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        d = displayMetrics.density;
        if (i < i2) {
            b = i;
            c = i2;
        } else {
            b = i2;
            c = i;
        }
        f23812a = true;
    }

    public static String getAliasPage(Bundle bundle, App app) {
        AppConfigModel appConfigModel;
        JSONObject appLaunchParams;
        JSONObject jSONObject;
        if (bundle == null || app == null) {
            return null;
        }
        String string = BundleUtils.getString(bundle, RVStartParams.KEY_PAGE_ALIAS);
        if (TextUtils.isEmpty(string) || (appConfigModel = (AppConfigModel) app.getData(AppConfigModel.class)) == null || (appLaunchParams = appConfigModel.getAppLaunchParams()) == null || (jSONObject = appLaunchParams.getJSONObject("pageAliasMapping")) == null) {
            return null;
        }
        String string2 = jSONObject.getString(string);
        RVLogger.d("AriverApp:alias", "onRestart pageAlias " + string + " resolve to " + string2);
        return string2;
    }

    public static int getContainerHeight(PageContext pageContext) {
        int contentViewHeight = pageContext.getContentViewHeight();
        if (contentViewHeight > 0) {
            return contentViewHeight;
        }
        a(pageContext.getActivity());
        return c;
    }

    public static int getContainerWidth(PageContext pageContext) {
        int contentViewWidth = pageContext.getContentViewWidth();
        if (contentViewWidth > 0) {
            return contentViewWidth;
        }
        a(pageContext.getActivity());
        return b;
    }

    public static void sendToApp(@NonNull App app, String str, @Nullable JSONObject jSONObject, @Nullable SendToRenderCallback sendToRenderCallback) {
        Page activePage = app.getActivePage();
        if (activePage == null || activePage.getRender() == null) {
            return;
        }
        EngineUtils.sendToRender(activePage.getRender(), str, jSONObject, sendToRenderCallback);
    }
}
