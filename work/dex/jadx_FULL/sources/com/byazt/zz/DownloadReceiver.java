package com.byazt.zz;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.byazt.n.DownloadNotificationService;
import com.igexin.sdk.PushConsts;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 189, 1002})
public class DownloadReceiver extends BroadcastReceiver {
    public static final String c = "DownloadReceiver";

    private void c(final Context context, final String str) {
        if (ve.cu()) {
            ve.c(new Runnable() { // from class: com.byazt.zz.DownloadReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Intent intent = new Intent(context, (Class<?>) DownloadNotificationService.class);
                        intent.setAction(str);
                        if (com.byazt.k.c.ve().tt("enable_target_34") > 0) {
                            com.byazt.l.c.c().c(intent);
                        } else {
                            context.startService(intent);
                        }
                    } catch (Throwable th) {
                        com.byazt.nr.m.c(th);
                    }
                }
            }, 2000L, TimeUnit.MILLISECONDS);
        }
    }

    private void tt(final Context context, final String str) {
        ve.c(new Runnable() { // from class: com.byazt.zz.DownloadReceiver.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Intent intent = new Intent(context, (Class<?>) DownloadNotificationService.class);
                    intent.setAction(str);
                    if (com.byazt.k.c.ve().tt("enable_target_34") > 0) {
                        com.byazt.l.c.c().c(intent);
                    } else {
                        context.startService(intent);
                    }
                } catch (Throwable th) {
                    com.byazt.nr.m.c(th);
                }
            }
        });
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        if (action.equals(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE)) {
            if (com.byazt.x.c.c()) {
                com.byazt.x.c.c(c, "Received broadcast intent for android.net.conn.CONNECTIVITY_CHANGE");
            }
            c(context, action);
        } else if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
            tt(context, action);
        }
    }
}
