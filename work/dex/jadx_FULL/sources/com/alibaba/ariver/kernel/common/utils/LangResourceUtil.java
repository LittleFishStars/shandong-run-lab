package com.alibaba.ariver.kernel.common.utils;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.StringRes;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LangResourceUtil {
    private static String a(@StringRes int i) {
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        Activity activity = rVEnvironmentService.getTopActivity().get();
        return activity != null ? activity.getString(i) : rVEnvironmentService.getApplicationContext().getString(i);
    }

    public static String getString(Context context, @StringRes int i) {
        return context != null ? context.getString(i) : a(i);
    }

    public static String getString(@StringRes int i) {
        return a(i);
    }
}
