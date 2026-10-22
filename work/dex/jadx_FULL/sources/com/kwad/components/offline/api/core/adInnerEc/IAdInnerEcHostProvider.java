package com.kwad.components.offline.api.core.adInnerEc;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.IPlayerReconnect;
import com.kwad.components.offline.api.core.adInnerEc.pay.IHostPayResultListener;
import com.kwad.components.offline.api.core.downloader.ResourceDownloader;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface IAdInnerEcHostProvider {
    void asyncExecute(Runnable runnable);

    boolean bridgeEnable(String str, String str2);

    void convert(String str);

    Intent createIntentWithAnyUri(Context context, Uri uri, boolean z, boolean z2);

    ResourceDownloader createResourceDownloader();

    void followUser(String str, Callback callback);

    Activity getActivityFromContext(Context context);

    String getAndroidId();

    Application getApp();

    String getAppChannel();

    String getAppOriginChannel();

    String getAppVersion();

    String getBoardPlatform();

    boolean getBooleanConfig(String str, boolean z);

    String getClientKey();

    int getCloudIdTag();

    Activity getCurrentactivity();

    String getDeviceId();

    int getDeviceIdTag();

    String getDeviceName();

    String getEGid();

    String getIMEI();

    String getIcaver();

    int getIntConfig(String str);

    String getKPF();

    String getKPN();

    String getKwaiServiceId();

    String getKwaiServiceToken();

    String getKwaiUserId();

    String getLaneId();

    boolean getLocationPermission(String str);

    String getLongConnectionTestHost();

    String getMac();

    String getMccc();

    String getMerchantVersion();

    String getNetworkType();

    String getOAID();

    String getODeviceId();

    int getOperatorType();

    String getPassportPassToken();

    String getPassportServiceSecurity();

    IPlayerReconnect getPlayerReconnect(String str);

    String getRDeviceId();

    String getSocNameV2();

    String getStringConfig(String str, String str2);

    String getThermalStatus();

    String getUserId();

    void handleCaughtException(Throwable th);

    boolean handleWebUrlJump(Activity activity, String str, Map<String, Object> map);

    boolean isAgreePrivacy();

    boolean isAppOnForeground();

    boolean isDebugMode();

    boolean isInMainProcess(Context context);

    boolean isLogined();

    boolean isOpenTeenageMode();

    boolean isPrtEnv();

    boolean isTestMode();

    void onCreateCookieMap(Map<String, String> map);

    void onDestroy();

    void putComponentProxy(Class<?> cls, Class<?> cls2);

    void reportException(Throwable th);

    void setPageTitle(WebView webView, String str);

    void showToast(String str);

    void startMerchantPay(Activity activity, boolean z, String str, String str2, IHostPayResultListener iHostPayResultListener);

    boolean useNetworkStateDisable();
}
