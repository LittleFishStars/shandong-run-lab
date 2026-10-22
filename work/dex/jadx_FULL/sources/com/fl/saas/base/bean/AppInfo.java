package com.fl.saas.base.bean;

import androidx.annotation.Keep;
import com.fl.saas.config.utils.DeviceUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Keep
public class AppInfo {
    private static final String name = DeviceUtil.getAppName();
    private static final String bundle = DeviceUtil.getMyPackageName();
    private static final String version = DeviceUtil.getVersionName();
    private final String id = DeviceUtil.appId;
    private final String channel = DeviceUtil.channelId;
    private final String sub_channel = DeviceUtil.subChannel;
    private final int orientation = 3;

    public static AppInfo create() {
        return new AppInfo();
    }
}
