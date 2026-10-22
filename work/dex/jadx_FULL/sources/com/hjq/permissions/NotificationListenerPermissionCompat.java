package com.hjq.permissions;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.zj.adlib.u15;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
final class NotificationListenerPermissionCompat {
    private static final String SETTING_ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";

    public static Intent getPermissionIntent(@NonNull Context context) {
        AndroidManifestInfo.ServiceInfo serviceInfo;
        Intent intent = null;
        if (AndroidVersion.isAndroid11()) {
            AndroidManifestInfo androidManifestInfo = PermissionUtils.getAndroidManifestInfo(context);
            if (androidManifestInfo == null) {
                serviceInfo = null;
                break;
            }
            serviceInfo = null;
            for (AndroidManifestInfo.ServiceInfo serviceInfo2 : androidManifestInfo.serviceInfoList) {
                if (TextUtils.equals(serviceInfo2.permission, Permission.BIND_NOTIFICATION_LISTENER_SERVICE)) {
                    if (serviceInfo != null) {
                        serviceInfo = null;
                        break;
                    }
                    serviceInfo = serviceInfo2;
                }
            }
            if (serviceInfo != null) {
                Intent intent2 = new Intent("android.settings.NOTIFICATION_LISTENER_DETAIL_SETTINGS");
                intent2.putExtra("android.provider.extra.NOTIFICATION_LISTENER_COMPONENT_NAME", new ComponentName(context, serviceInfo.name).flattenToString());
                if (PermissionUtils.areActivityIntent(context, intent2)) {
                    intent = intent2;
                }
            }
        }
        if (intent == null) {
            intent = AndroidVersion.isAndroid5_1() ? new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS") : new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
        }
        return !PermissionUtils.areActivityIntent(context, intent) ? PermissionIntentManager.getApplicationDetailsIntent(context) : intent;
    }

    public static boolean isGrantedPermission(@NonNull Context context) {
        if (!AndroidVersion.isAndroid4_3()) {
            return true;
        }
        String string = Settings.Secure.getString(context.getContentResolver(), SETTING_ENABLED_NOTIFICATION_LISTENERS);
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        for (String str : string.split(u15.f19942b)) {
            ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
            if (componentNameUnflattenFromString != null && TextUtils.equals(componentNameUnflattenFromString.getPackageName(), context.getPackageName())) {
                try {
                    Class.forName(componentNameUnflattenFromString.getClassName());
                    return true;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
