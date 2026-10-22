package com.fl.saas.adx.api.mixNative;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface NativeAdAppInfo {

    public interface ClickEvent {
        void onClick();
    }

    String getAppName();

    String getAppPermissionUrl();

    String getAppPrivacyUrl();

    String getAppVersion();

    ClickEvent getFunctionClick();

    String getFunctionUrl();

    ClickEvent getPermissonClick();

    ClickEvent getPrivacyClick();

    String getPublisher();
}
