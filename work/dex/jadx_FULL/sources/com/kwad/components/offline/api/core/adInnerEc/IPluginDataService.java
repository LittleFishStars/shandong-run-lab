package com.kwad.components.offline.api.core.adInnerEc;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Keep
public interface IPluginDataService {
    void convert(String str);

    Activity getActivityFromContext(Context context);

    String getAppChannel();

    String getAppOriginChannel();

    String getAppVersion();

    String getBoardPlatform();

    int getCloudIdTag();

    int getDeviceIdTag();

    String getDeviceName();

    int getIntConfig(String str);

    String getKwaiServiceId();

    String getKwaiServiceToken();

    String getKwaiUserId();

    String getLaneId();

    String getODeviceId();

    int getOperatorType();

    String getRDeviceId();

    String getSocNameV2();

    String getThermalStatus();

    String getUserId();

    boolean isAgreePrivacy();

    boolean isAppOnForeground();

    boolean isOpenTeenageMode();

    void onDestroy();

    void reportException(Throwable th);

    void request(Map<String, Object> map, IKRNRequestListener iKRNRequestListener);

    void showToast(String str);
}
