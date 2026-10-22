package com.fl.saas.s2s.sdk.helper.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.fl.saas.s2s.sdk.helper.CommNotificationHelper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class DownloadActionReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intent intent2;
        String str;
        if (intent != null) {
            String action = intent.getAction();
            String stringExtra = intent.getStringExtra("downLoadUrl");
            if (TextUtils.isEmpty(action)) {
                return;
            }
            if (CommNotificationHelper.NOTIFICATION_START_DOWNLOAD.equals(action)) {
                intent2 = new Intent();
                str = DownLoadSupportPauseUtil.YD_START_DOWNLOAD;
            } else if (CommNotificationHelper.NOTIFICATION_PAUSE_DOWNLOAD.equals(action)) {
                intent2 = new Intent();
                str = DownLoadSupportPauseUtil.YD_PAUSE_DOWNLOAD;
            } else {
                if (!CommNotificationHelper.NOTIFICATION_CANCEL_DOWNLOAD.equals(action)) {
                    return;
                }
                intent2 = new Intent();
                str = DownLoadSupportPauseUtil.YD_CANCEL_DOWNLOAD;
            }
            intent2.setAction(str);
            intent2.putExtra("downLoadUrl", stringExtra);
            context.sendBroadcast(intent2);
        }
    }
}
