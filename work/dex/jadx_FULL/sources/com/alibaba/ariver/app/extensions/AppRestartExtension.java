package com.alibaba.ariver.app.extensions;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppRestartResult;
import com.alibaba.ariver.app.api.ParamUtils;
import com.alibaba.ariver.app.api.model.AppConfigModel;
import com.alibaba.ariver.app.api.point.app.AppRestartPoint;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppRestartExtension implements AppRestartPoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23831a = "AriverApp:AppRestartExtension";
    private String b = null;
    private String c = null;

    private boolean a(App app, Bundle bundle, Bundle bundle2) {
        if (bundle == null || bundle.getBoolean("IS_LITE_MOVE_TASK", false) || RVConstants.CHINFO_NAVIGATE_BACK.equalsIgnoreCase(bundle.getString(RVStartParams.KEY_CHINFO)) || "YES".equalsIgnoreCase(bundle.getString(RVStartParams.KEY_DISABLE_RELAUNCH))) {
            return false;
        }
        String strA = a(bundle, bundle2);
        String str = this.c;
        this.c = strA;
        String string = bundle.getString("page");
        if (!TextUtils.isEmpty(string)) {
            return false;
        }
        String strA2 = a(app);
        if (TextUtils.isEmpty(strA2)) {
            return false;
        }
        if (TextUtils.isEmpty(strA) && TextUtils.isEmpty(str)) {
            return false;
        }
        RVLogger.d(f23831a, "needRelaunch targetPage: " + string + " homePage: " + strA2 + " chInfo: " + strA + " lastChInfo: " + str);
        return TextUtils.isEmpty(str) || !str.equals(strA);
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppRestartPoint
    public AppRestartResult onAppRestart(App app, Bundle bundle, Bundle bundle2) {
        AppRestartResult appRestartResult = new AppRestartResult();
        if (this.c == null) {
            this.c = a(app.getStartParams(), app.getSceneParams());
        }
        appRestartResult.startParam = bundle;
        appRestartResult.closeAllWindow = true;
        appRestartResult.canRestart = true;
        if (app.isTinyApp()) {
            String strPurifyUrl = UrlUtils.purifyUrl(app.getStartUrl());
            if (strPurifyUrl == null || !a(app, bundle, bundle2)) {
                appRestartResult.canRestart = false;
            } else {
                bundle.putBoolean(RVConstants.EXTRA_START_FROM_RELAUNCH, true);
                appRestartResult.startUrl = strPurifyUrl + "#" + this.b;
            }
        } else {
            ParamUtils.unify(bundle, "url", false);
            String string = BundleUtils.getString(bundle, "url");
            RVLogger.d(f23831a, "onAppRestart for h5 app , url = " + string);
            appRestartResult.startUrl = string;
        }
        return appRestartResult;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    private String a(App app) {
        if (!TextUtils.isEmpty(this.b)) {
            return this.b;
        }
        AppConfigModel appConfigModel = (AppConfigModel) app.getData(AppConfigModel.class);
        if (appConfigModel == null) {
            return this.b;
        }
        if (appConfigModel.getPages() != null && appConfigModel.getPages().size() > 0) {
            this.b = appConfigModel.getPages().get(0);
        }
        return this.b;
    }

    @Nullable
    private static String a(Bundle bundle, Bundle bundle2) {
        String string = bundle.getString(RVStartParams.KEY_CHINFO);
        if (TextUtils.isEmpty(string)) {
            string = BundleUtils.getString(bundle2, RVStartParams.KEY_CHINFO);
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        int iIndexOf = string.indexOf("__");
        return iIndexOf > 0 ? string.substring(0, iIndexOf) : string;
    }
}
