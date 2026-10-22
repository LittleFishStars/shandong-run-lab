package com.alibaba.triver.kit.api.utils;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.StringRes;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class InternationalUtil {
    public static String getString(ApiContext apiContext, @StringRes int i) {
        if (apiContext == null || apiContext.getActivity() == null) {
            return (apiContext == null || apiContext.getAppContext() == null) ? getStringDefault(i) : apiContext.getAppContext().getString(i);
        }
        return apiContext.getActivity().getString(i);
    }

    private static String getStringDefault(@StringRes int i) {
        Activity activity;
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        WeakReference<Activity> topActivity = rVEnvironmentService.getTopActivity();
        return (topActivity == null || (activity = topActivity.get()) == null) ? rVEnvironmentService.getApplicationContext().getString(i) : activity.getString(i);
    }

    public static String getString(Page page, @StringRes int i) {
        if (page != null && page.getPageContext() != null && page.getPageContext().getActivity() != null) {
            return page.getPageContext().getActivity().getString(i);
        }
        return getStringDefault(i);
    }

    public static String getString(Context context, @StringRes int i) {
        if (context != null) {
            return context.getString(i);
        }
        return getStringDefault(i);
    }

    public static String getString(@StringRes int i) {
        return getStringDefault(i);
    }
}
