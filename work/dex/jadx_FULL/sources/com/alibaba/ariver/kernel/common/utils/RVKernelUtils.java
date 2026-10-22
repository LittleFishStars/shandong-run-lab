package com.alibaba.ariver.kernel.common.utils;

import android.app.Application;
import android.content.res.Resources;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RVKernelUtils {
    public static final String TAG = "AriverKernel";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Boolean f24283a;

    public static String getClientVersion() {
        try {
            Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
            return applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "";
        }
    }

    public static Resources getResources() {
        return ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getResources(RVConstants.ARIVER_BUNDLE_NAME);
    }

    public static boolean isDebug() {
        if (f24283a == null) {
            Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
            if (applicationContext == null) {
                return false;
            }
            try {
                f24283a = Boolean.valueOf((applicationContext.getApplicationInfo().flags & 2) != 0);
            } catch (Throwable th) {
                RVLogger.e("AriverKernel", "exception detail", th);
            }
        }
        if (f24283a == null) {
            f24283a = Boolean.FALSE;
        }
        return f24283a.booleanValue();
    }
}
