package com.kc.dw.core.download;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.kc.dw.core.safe.SafeBroadcastReceiver;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class InstallManager$InstallReceiver extends SafeBroadcastReceiver {
    @Override // com.kc.dw.core.safe.SafeBroadcastReceiver
    public void a(Context context, Intent intent) {
        String schemeSpecificPart;
        StringBuilder sb;
        String str;
        context.getPackageManager();
        if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
            schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            sb = new StringBuilder();
            str = "onReceive:  app_added  ";
        } else {
            if (!intent.getAction().equals("android.intent.action.PACKAGE_REMOVED")) {
                return;
            }
            schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            sb = new StringBuilder();
            str = "onReceive:  app_removed  ";
        }
        sb.append(str);
        sb.append(schemeSpecificPart);
        Log.e("InstallManager", sb.toString());
    }
}
