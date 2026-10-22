package com.alibaba.ariver.kernel.common.service;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.common.Proxiable;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface RVEnvironmentService extends Proxiable {
    public static final String GROUP_ALI_APP = "AliApp";
    public static final String GROUP_ARIVER_APP = "AriverApp";
    public static final String PLATFORM_AP = "AP";
    public static final String PLATFORM_TB = "TB";

    String convertPlatform(String str);

    String defaultPlatform();

    @Nullable
    String extractAppIdFromUrl(String str);

    String getAppCurrency();

    String getAppExternalStoragePath();

    String getAppGroup();

    String getAppLanguage();

    int getAppLayoutDirection();

    String getAppName();

    String getAppRegion();

    Application getApplicationContext();

    int getLpid();

    String getProductId();

    String getProductVersion();

    Resources getResources(@Nullable String str);

    WeakReference<Activity> getTopActivity();

    boolean isBackgroundRunning();

    void openUrl(String str);
}
