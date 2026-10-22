package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.VpnService;
import androidx.annotation.NonNull;
import java.util.Collections;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
class PermissionDelegateImplBase implements PermissionDelegate {
    public static Intent getApplicationDetailsIntent(@NonNull Context context) {
        return PermissionIntentManager.getApplicationDetailsIntent(context);
    }

    private static Intent getVpnPermissionIntent(@NonNull Context context) {
        Intent intentPrepare = VpnService.prepare(context);
        return !PermissionUtils.areActivityIntent(context, intentPrepare) ? PermissionIntentManager.getApplicationDetailsIntent(context) : intentPrepare;
    }

    private static boolean isGrantedVpnPermission(@NonNull Context context) {
        return VpnService.prepare(context) == null;
    }

    @Override // com.hjq.permissions.PermissionDelegate
    public Intent getPermissionSettingIntent(@NonNull Context context, @NonNull String str) {
        return PermissionUtils.equalsPermission(str, Permission.BIND_VPN_SERVICE) ? getVpnPermissionIntent(context) : PermissionIntentManager.getApplicationDetailsIntent(context, Collections.singletonList(str));
    }

    @Override // com.hjq.permissions.PermissionDelegate
    public boolean isDoNotAskAgainPermission(@NonNull Activity activity, @NonNull String str) {
        PermissionUtils.equalsPermission(str, Permission.BIND_VPN_SERVICE);
        return false;
    }

    @Override // com.hjq.permissions.PermissionDelegate
    public boolean isGrantedPermission(@NonNull Context context, @NonNull String str) {
        if (PermissionUtils.equalsPermission(str, Permission.BIND_VPN_SERVICE)) {
            return isGrantedVpnPermission(context);
        }
        return true;
    }

    @Override // com.hjq.permissions.PermissionDelegate
    public boolean recheckPermissionResult(@NonNull Context context, @NonNull String str, boolean z) {
        return (!PermissionApi.isSpecialPermission(str) && PermissionHelper.findAndroidVersionByPermission(str) <= AndroidVersion.getAndroidVersionCode()) ? z : isGrantedPermission(context, str);
    }
}
