package com.alibaba.triver.kit.api.utils;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.Log;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TRLanguageManager {
    private static TRLanguageManager mInstance;

    private TRLanguageManager() {
    }

    private Locale getAppLanguageLocale() {
        String appLanguage = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getAppLanguage();
        if (TextUtils.isEmpty(appLanguage)) {
            return null;
        }
        String[] strArrSplit = appLanguage.split(LoginConstants.UNDER_LINE);
        return new Locale(strArrSplit[0], strArrSplit[1]);
    }

    public static TRLanguageManager getInstance() {
        if (mInstance == null) {
            synchronized (TRLanguageManager.class) {
                if (mInstance == null) {
                    mInstance = new TRLanguageManager();
                }
            }
        }
        return mInstance;
    }

    public void reset() {
    }

    public void updateLanguage(Activity activity) {
        try {
            Locale appLanguageLocale = getInstance().getAppLanguageLocale();
            Configuration configuration = new Configuration();
            configuration.setLocale(appLanguageLocale);
            LocaleList localeList = new LocaleList(appLanguageLocale);
            LocaleList.setDefault(localeList);
            configuration.setLocales(localeList);
            configuration.setLayoutDirection(null);
            activity.applyOverrideConfiguration(configuration);
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
        }
    }
}
