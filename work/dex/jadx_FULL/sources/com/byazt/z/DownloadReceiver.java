package com.byazt.z;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.byazt.c.yv;
import com.byazt.m.BaseException;
import com.byazt.nr.m;
import com.byazt.t.DownloadInfo;
import com.byazt.tk.AdBaseConstants;
import com.byazt.zz.Downloader;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 133, 1002})
public class DownloadReceiver extends BroadcastReceiver {
    public static final String c = "DownloadReceiver";
    public Handler tt = new Handler(Looper.getMainLooper());

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
            if (com.byazt.x.c.c()) {
                com.byazt.x.c.c(c, "Received broadcast intent for android.intent.action.MEDIA_MOUNTED");
            }
            c(context, action);
        } else if (action.equals("android.intent.action.PACKAGE_ADDED") || action.equals("android.intent.action.PACKAGE_REPLACED")) {
            com.byazt.zz.ve.t().execute(new Runnable() { // from class: com.byazt.z.DownloadReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    Uri data = intent.getData();
                    if (data == null) {
                        return;
                    }
                    String schemeSpecificPart = data.getSchemeSpecificPart();
                    com.byazt.s.n nVarVe = uj.sl().ve();
                    if (nVarVe != null) {
                        nVarVe.c(context, schemeSpecificPart);
                    }
                    List<DownloadInfo> successedDownloadInfosWithMimeType = Downloader.getInstance(context).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
                    if (successedDownloadInfosWithMimeType != null) {
                        for (final DownloadInfo downloadInfo : successedDownloadInfosWithMimeType) {
                            if (downloadInfo != null && ve.c(downloadInfo, schemeSpecificPart)) {
                                yv downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
                                if (downloadNotificationEventListener != null && com.byazt.w.a.a(downloadNotificationEventListener.c())) {
                                    downloadNotificationEventListener.c(9, downloadInfo, schemeSpecificPart, "");
                                }
                                com.byazt.n.c cVarN = com.byazt.n.tt.c().n(downloadInfo.getId());
                                if (cVarN != null) {
                                    cVarN.c((BaseException) null, false);
                                }
                                if (com.byazt.k.c.c(downloadInfo.getId()).c("install_queue_enable", 0) == 1) {
                                    sp.c().c(downloadInfo, schemeSpecificPart);
                                }
                                DownloadReceiver.this.tt.postDelayed(new Runnable() { // from class: com.byazt.z.DownloadReceiver.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        com.byazt.zz.ve.t().execute(new Runnable() { // from class: com.byazt.z.DownloadReceiver.1.1.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                try {
                                                    if (downloadInfo.isSavePathRedirected()) {
                                                        com.byazt.w.a.tt(downloadInfo);
                                                    }
                                                } catch (Throwable th) {
                                                    m.c(th);
                                                }
                                            }
                                        });
                                    }
                                }, 1000L);
                                return;
                            }
                        }
                    }
                }
            });
        }
    }

    private void c(final Context context, final String str) {
        if (com.byazt.zz.ve.cu()) {
            com.byazt.zz.ve.c(new Runnable() { // from class: com.byazt.z.DownloadReceiver.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Intent intent = new Intent(context, (Class<?>) DownloadHandlerService.class);
                        intent.setAction(str);
                        context.startService(intent);
                    } catch (Throwable th) {
                        m.c(th);
                    }
                }
            }, 2000L, TimeUnit.MILLISECONDS);
        }
    }
}
