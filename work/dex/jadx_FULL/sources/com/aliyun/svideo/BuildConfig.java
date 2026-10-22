package com.aliyun.svideo;

import com.huawei.hms.api.ConnectionResult;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public final class BuildConfig {
    public static final String BUILD_TYPE = "release";
    public static final boolean DEBUG = false;
    public static final String LIBRARY_PACKAGE_NAME = "com.aliyun.svideo";
    public static final Boolean LIB_3A_SUPPORTED;
    public static final Boolean LIB_ALI_FACE_AR_ENGINE_SUPPORTED;
    public static final Boolean LIB_VOICE_CHANGE_SUPPORTED;
    public static final Integer LICENSE_VERSION_CODE;
    public static final String LOG_MODULE = "svideo_pro";
    public static final String NATIVE_CORE_NAME = "all_in_one";
    public static final Boolean SDK_INFO_IS_AIO;
    public static final String SDK_VERSION = "6.7.0";

    static {
        Boolean bool = Boolean.TRUE;
        LIB_3A_SUPPORTED = bool;
        LIB_ALI_FACE_AR_ENGINE_SUPPORTED = bool;
        LIB_VOICE_CHANGE_SUPPORTED = bool;
        LICENSE_VERSION_CODE = Integer.valueOf(ConnectionResult.RESTRICTED_PROFILE);
        SDK_INFO_IS_AIO = bool;
    }
}
