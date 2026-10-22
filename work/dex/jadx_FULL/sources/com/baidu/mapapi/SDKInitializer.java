package com.baidu.mapapi;

import android.content.Context;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comapi.Initializer;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class SDKInitializer {
    public static final String SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR = "network error";
    public static final String SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR = "permission check error";
    public static final String SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_OK = "permission check ok";
    public static final String SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE = "error_code";
    public static final String SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_MESSAGE = "error_message";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static CoordType f26483a = CoordType.BD09LL;

    private SDKInitializer() {
    }

    public static boolean getAgreePrivacy() {
        return Initializer.isAgreePrivacyMode();
    }

    public static CommonInfo getCommonInfo() {
        return Initializer.getCommonInfo();
    }

    public static CoordType getCoordType() {
        return f26483a;
    }

    public static void initialize(Context context) {
        Initializer.initialize(context, false, null, null, null, null);
    }

    public static boolean isHttpsEnable() {
        return HttpClient.isHttpsEnable;
    }

    public static boolean isInitialized() {
        return Initializer.isInitialized();
    }

    public static void onBackground() {
        Initializer.onBackground();
    }

    public static void onForeground() {
        Initializer.onForeground();
    }

    public static void setAgreePrivacy(Context context, boolean z) {
        Initializer.setPrivacyMode(context, z);
    }

    public static void setApiKey(String str) {
        PermissionCheck.setApiKey(str);
    }

    public static void setCommonInfo(CommonInfo commonInfo) {
        Initializer.setCommonInfo(commonInfo);
    }

    public static void setCoordType(CoordType coordType) {
        f26483a = coordType;
    }

    public static void setHttpsEnable(boolean z) {
    }

    public static void unRegisterNetworkCallback() {
        if (Initializer.isInitialized()) {
            com.baidu.platform.comapi.util.NetworkUtil.unregisterNetworkCallback();
        }
    }

    public static void initialize(Context context, ISDKInitializerListener iSDKInitializerListener) {
        Initializer.initialize(context, false, null, null, null, iSDKInitializerListener);
    }

    public static void initialize(String str, Context context) {
        Initializer.initialize(context, false, null, str, null, null);
    }

    public static void initialize(Context context, boolean z, String str, String str2) {
        Initializer.initialize(context, z, str, str2, null, null);
    }
}
