package com.kwad.sdk.core.download.b;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.baichuan.log.TLogConstant;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.api.push.KsNotificationCompat;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.d;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.v;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a implements d {
    private static c aSm;
    private boolean aSo = false;
    private boolean aSp = false;
    private int aSq = 0;
    private static HashMap<String, WeakReference<Bitmap>> aSl = new HashMap<>();
    private static final Handler aSn = new HandlerC1281a();

    /* JADX INFO: renamed from: com.kwad.sdk.core.download.b.a$a, reason: collision with other inner class name */
    public static class HandlerC1281a extends Handler {
        private final SparseArray<Long> aSr;

        public HandlerC1281a() {
            super(Looper.getMainLooper());
            this.aSr = new SparseArray<>();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            boolean z = message.arg1 == 1;
            int i = message.arg2;
            boolean z2 = i == 1;
            boolean z3 = i == 2;
            Long l = this.aSr.get(message.what);
            NotificationManager notificationManager = (NotificationManager) com.kwad.sdk.c.Ey().getContext().getSystemService("notification");
            if (notificationManager == null) {
                return;
            }
            if (com.kwad.sdk.c.Ey().dk(message.what) == null && !z3) {
                removeMessages(message.what);
                notificationManager.cancel(message.what);
            } else {
                if (!z && l != null && System.currentTimeMillis() - l.longValue() < 110) {
                    sendMessageDelayed(Message.obtain(message), (l.longValue() + 110) - System.currentTimeMillis());
                    return;
                }
                if (z2) {
                    notificationManager.cancel(message.what);
                }
                a.a(message.what, (Notification) message.obj);
                this.aSr.put(message.what, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    public static class b {
        private static String aSs = "ksad_notification_default_icon";
        private String aSt;
        private String aSu;
        private String aSw;
        private String auA;
        private String name;
        private int progress;
        private File aSv = null;
        private boolean aSx = false;

        private b() {
        }

        public static String LF() {
            return aSs;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b a(DownloadTask downloadTask, String str, String str2, boolean z, int i) {
            b bVar = new b();
            Object tag = downloadTask.getTag();
            if (tag instanceof DownloadParams) {
                DownloadParams downloadParams = (DownloadParams) tag;
                File fileCO = ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).cO(downloadParams.mAppIcon);
                if (fileCO != null && fileCO.exists()) {
                    bVar.aSv = fileCO;
                }
                bVar.name = downloadParams.mAppName;
            }
            bVar.aSx = downloadTask.isPaused();
            bVar.auA = str;
            bVar.aSw = str2;
            bVar.aSu = a.P(downloadTask.getSmallFileTotalBytes());
            int iA = v.a(downloadTask.getSmallFileSoFarBytes(), downloadTask.getSmallFileTotalBytes(), z, i);
            bVar.progress = iA;
            bVar.aSt = a.P((long) (((double) downloadTask.getSmallFileTotalBytes()) * ((((double) iA) * 1.0d) / 100.0d))) + " / " + a.P(downloadTask.getSmallFileTotalBytes());
            return bVar;
        }

        public final String LG() {
            return this.aSt;
        }

        public final String LH() {
            return this.aSu;
        }

        public final String LI() {
            return this.auA;
        }

        public final File LJ() {
            return this.aSv;
        }

        public final String LK() {
            return "正在下载 " + this.progress + "%";
        }

        public final String LL() {
            return this.aSw;
        }

        public final String getName() {
            String str = this.name;
            return str == null ? "" : str;
        }

        public final int getProgress() {
            return this.progress;
        }

        public final boolean isPaused() {
            return this.aSx;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b a(DownloadParams downloadParams, String str, String str2) {
            File fileCO;
            b bVar = new b();
            bVar.name = downloadParams.mAppName;
            if (!TextUtils.isEmpty(downloadParams.mAppIcon) && (fileCO = ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).cO(downloadParams.mAppIcon)) != null && fileCO.exists()) {
                bVar.aSv = fileCO;
            }
            bVar.auA = str;
            bVar.aSu = a.P(downloadParams.mAppSize);
            bVar.aSw = str2;
            return bVar;
        }
    }

    public static class c extends BroadcastReceiver {
        private static void e(@NonNull Intent intent) {
            DownloadTask downloadTaskG = g(intent);
            if (downloadTaskG == null) {
                return;
            }
            com.kwad.sdk.c.Ey().dm(downloadTaskG.getId());
        }

        private static void f(@NonNull Intent intent) {
            DownloadTask downloadTaskG = g(intent);
            if (downloadTaskG == null) {
                return;
            }
            downloadTaskG.setNotificationRemoved(true);
        }

        @Nullable
        private static DownloadTask g(Intent intent) {
            int i = intent.getExtras().getInt(TLogConstant.PERSIST_TASK_ID, 0);
            if (i == 0) {
                return null;
            }
            return com.kwad.sdk.c.Ey().dk(i);
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getExtras() == null) {
                return;
            }
            String action = intent.getAction();
            if ("com.ksad.action.ACTION_NOTIFICATION_CLICK_CONTROL_BTN".equals(action)) {
                e(intent);
            } else if ("com.ksad.action.ACTION_NOTIFICATION_REMOVED".equals(action)) {
                f(intent);
            }
        }
    }

    private static Bitmap J(Context context, String str) {
        WeakReference<Bitmap> weakReference = aSl.get(str);
        Bitmap bitmap = weakReference != null ? weakReference.get() : null;
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(bc.dN(context), bc.aD(context, str));
        aSl.put(str, new WeakReference<>(bitmapDecodeResource));
        return bitmapDecodeResource;
    }

    private static void LE() {
        if (aSm != null) {
            return;
        }
        aSm = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.ksad.action.ACTION_NOTIFICATION_CLICK_CONTROL_BTN");
        intentFilter.addAction("com.ksad.action.ACTION_NOTIFICATION_REMOVED");
        if (Build.VERSION.SDK_INT >= 33) {
            ServiceProvider.Ud().registerReceiver(aSm, intentFilter, 2);
        } else {
            ServiceProvider.Ud().registerReceiver(aSm, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"DefaultLocale"})
    public static String P(long j) {
        return String.format("%.2fMB", Float.valueOf((j / 1000.0f) / 1000.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(int i, Notification notification) {
        LE();
        NotificationManager notificationManager = (NotificationManager) ServiceProvider.Ud().getSystemService("notification");
        try {
            NotificationChannel notificationChannel = new NotificationChannel("download_channel", "ksad", 3);
            notificationChannel.enableLights(false);
            notificationChannel.enableVibration(false);
            notificationChannel.setSound(null, null);
            notificationChannel.setShowBadge(false);
            notificationManager.createNotificationChannel(notificationChannel);
            notificationManager.notify(i, notification);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    private static DownloadParams m(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return null;
        }
        Object tag = downloadTask.getTag();
        DownloadParams downloadParams = tag instanceof DownloadParams ? (DownloadParams) tag : new DownloadParams();
        downloadParams.mAppSize = downloadTask.getSmallFileTotalBytes();
        downloadParams.mTaskId = downloadTask.getId();
        downloadParams.filePath = downloadTask.getTargetFilePath();
        return downloadParams;
    }

    private static Bitmap q(File file) {
        String absolutePath = file.getAbsolutePath();
        WeakReference<Bitmap> weakReference = aSl.get(absolutePath);
        Bitmap bitmap = weakReference != null ? weakReference.get() : null;
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(absolutePath);
        aSl.put(absolutePath, new WeakReference<>(bitmapDecodeFile));
        return bitmapDecodeFile;
    }

    @Override // com.kwad.sdk.d
    public final void cM(String str) {
        Context contextUd = ServiceProvider.Ud();
        DownloadParams downloadParamsDS = com.kwad.sdk.core.a.IH().dS(str);
        com.kwad.sdk.core.a.IH().dT(str);
        if (contextUd == null || downloadParamsDS == null) {
            return;
        }
        com.kwad.sdk.core.a.IH().dT(downloadParamsDS.filePath);
        b bVarA = b.a(downloadParamsDS, "安装完成", "立刻打开");
        com.kwad.sdk.core.download.b.b bVarBT = com.kwad.sdk.core.download.b.b.bT(contextUd);
        if (bVarBT == null) {
            return;
        }
        a(contextUd, bVarBT, bVarA);
        a(contextUd, bVarBT.build(), false, false, av.d(contextUd, downloadParamsDS.mPkgname, downloadParamsDS.mTaskId), downloadParamsDS.mTaskId, 1, 2);
    }

    @Override // com.kwad.sdk.d
    public final void dn(int i) {
        Context contextUd = ServiceProvider.Ud();
        if (contextUd == null) {
            return;
        }
        ((NotificationManager) contextUd.getSystemService("notification")).cancel(i);
    }

    @Override // com.kwad.sdk.d
    public final void g(File file) {
        Context contextUd = ServiceProvider.Ud();
        if (contextUd == null) {
            return;
        }
        DownloadParams downloadParamsDS = com.kwad.sdk.core.a.IH().dS(file.getAbsolutePath());
        com.kwad.sdk.core.a.IH().dT(file.getAbsolutePath());
        if (downloadParamsDS == null) {
            return;
        }
        AdTemplate adTemplateDU = com.kwad.sdk.core.a.IH().dU(downloadParamsDS.mDownloadid);
        if (adTemplateDU != null) {
            adTemplateDU.installFrom = "recall";
        }
        b bVarA = b.a(downloadParamsDS, "下载完成", com.ipd.dsp.internal.b1.b.a.o);
        com.kwad.sdk.core.download.b.b bVarBT = com.kwad.sdk.core.download.b.b.bT(contextUd);
        if (bVarBT == null) {
            return;
        }
        a(contextUd, bVarBT, bVarA);
        a(contextUd, bVarBT.build(), false, false, av.a(contextUd, file, downloadParamsDS.mTaskId, downloadParamsDS.requestInstallPermission), downloadParamsDS.mTaskId, 1, 2);
    }

    @Override // com.kwad.sdk.d
    public final void i(DownloadTask downloadTask) {
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            String str = ((DownloadParams) tag).mAppIcon;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File fileCO = ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).cO(str);
            if (fileCO == null || !fileCO.exists()) {
                ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).a(true, str, "", "");
            }
        }
    }

    @Override // com.kwad.sdk.d
    public final void j(DownloadTask downloadTask) {
        Context contextUd = ServiceProvider.Ud();
        if (contextUd == null || downloadTask.isNotificationRemoved()) {
            return;
        }
        String str = downloadTask.getSmallFileSoFarBytes() > 0 && downloadTask.getSmallFileTotalBytes() > 0 ? "正在下载" : "准备下载";
        if (!this.aSo) {
            this.aSo = true;
            this.aSp = ((h) ServiceProvider.get(h.class)).Gi();
            this.aSq = ((h) ServiceProvider.get(h.class)).Gj();
        }
        com.kwad.sdk.core.d.c.d("AdDownloadNotificationPerformer", "DownloadProgressTransformUtil in notifyDownloadError");
        b bVarA = b.a(downloadTask, str, null, this.aSp, this.aSq);
        com.kwad.sdk.core.download.b.c cVarA = com.kwad.sdk.core.download.b.c.a(contextUd, downloadTask.getId(), downloadTask.downloadEnablePause);
        if (cVarA == null) {
            return;
        }
        a(contextUd, cVarA, bVarA);
        a(contextUd, cVarA.build(), false, true, null, downloadTask.getId(), 1, downloadTask.isCompleted() ? 1 : 0);
    }

    @Override // com.kwad.sdk.d
    public final void k(DownloadTask downloadTask) {
        DownloadParams downloadParamsM;
        com.kwad.sdk.core.download.b.b bVarBT;
        Context contextUd = ServiceProvider.Ud();
        if (contextUd == null || (downloadParamsM = m(downloadTask)) == null || (bVarBT = com.kwad.sdk.core.download.b.b.bT(contextUd)) == null) {
            return;
        }
        if (!this.aSo) {
            this.aSo = true;
            this.aSp = ((h) ServiceProvider.get(h.class)).Gi();
            this.aSq = ((h) ServiceProvider.get(h.class)).Gj();
        }
        com.kwad.sdk.core.d.c.d("AdDownloadNotificationPerformer", "DownloadProgressTransformUtil in notifyDownloadCompleted");
        a(contextUd, bVarBT, b.a(downloadTask, "下载完成", com.ipd.dsp.internal.b1.b.a.o, this.aSp, this.aSq));
        com.kwad.sdk.core.a.IH().a(downloadTask.getTargetFilePath(), downloadParamsM);
        com.kwad.sdk.core.a.IH().a(downloadParamsM.mPkgname, downloadParamsM);
        a(contextUd, bVarBT.build(), false, false, av.a(contextUd, new File(downloadTask.getTargetFilePath()), downloadParamsM.mTaskId, downloadParamsM.requestInstallPermission), downloadTask.getId(), 1, 1);
    }

    @Override // com.kwad.sdk.d
    public final void a(DownloadTask downloadTask, boolean z) {
        com.kwad.sdk.core.download.b.c cVarA;
        Context contextUd = ServiceProvider.Ud();
        if (contextUd == null || downloadTask.isNotificationRemoved() || (cVarA = com.kwad.sdk.core.download.b.c.a(contextUd, downloadTask.getId(), downloadTask.downloadEnablePause)) == null) {
            return;
        }
        if (!this.aSo) {
            this.aSo = true;
            this.aSp = ((h) ServiceProvider.get(h.class)).Gi();
            this.aSq = ((h) ServiceProvider.get(h.class)).Gj();
        }
        com.kwad.sdk.core.d.c.d("AdDownloadNotificationPerformer", "DownloadProgressTransformUtil in notifyDownloadProgress");
        a(contextUd, cVarA, b.a(downloadTask, "正在下载", null, this.aSp, this.aSq));
        a(contextUd, cVarA.build(), false, true, null, downloadTask.getId(), z ? 1 : 0, downloadTask.isCompleted() ? 1 : 0);
    }

    private boolean a(com.kwad.sdk.core.download.b.c cVar, File file) {
        try {
            cVar.setIcon(q(file));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            com.kwad.sdk.service.d.gatherException(e);
            return false;
        }
    }

    private boolean a(Context context, com.kwad.sdk.core.download.b.c cVar, String str) {
        try {
            cVar.setIcon(J(context, str));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            com.kwad.sdk.service.d.gatherException(e);
            return false;
        }
    }

    private boolean a(com.kwad.sdk.core.download.b.b bVar, File file) {
        try {
            bVar.setIcon(q(file));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            com.kwad.sdk.service.d.gatherException(e);
            return false;
        }
    }

    private boolean a(Context context, com.kwad.sdk.core.download.b.b bVar, String str) {
        try {
            bVar.setIcon(J(context, str));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            com.kwad.sdk.service.d.gatherException(e);
            return false;
        }
    }

    private void a(Context context, RemoteViews remoteViews, boolean z, boolean z2, @Nullable PendingIntent pendingIntent, int i, int i2, int i3) {
        KsNotificationCompat.Builder builder = new KsNotificationCompat.Builder(context, "download_channel");
        builder.setWhen(System.currentTimeMillis()).setOngoing(false).setAutoCancel(false).setOnlyAlertOnce(true).setPriority(-1).setContentIntent(pendingIntent).setSmallIcon(bc.getAppIconId(context));
        a(builder, remoteViews);
        if (z2) {
            Intent intent = new Intent("com.ksad.action.ACTION_NOTIFICATION_REMOVED");
            intent.putExtra(TLogConstant.PERSIST_TASK_ID, i);
            builder.setDeleteIntent(av.a(context, i, intent));
        }
        Handler handler = aSn;
        handler.removeMessages(i);
        handler.obtainMessage(i, i2, i3, builder.build()).sendToTarget();
    }

    private static void a(KsNotificationCompat.Builder builder, RemoteViews remoteViews) {
        try {
            builder.setDecoratedCustomStyle().setCustomBigContentView(remoteViews).setCustomContentView(remoteViews);
        } catch (Throwable unused) {
            builder.setContent(remoteViews);
        }
    }

    private void a(Context context, com.kwad.sdk.core.download.b.c cVar, b bVar) {
        cVar.setName(bVar.getName());
        File fileLJ = bVar.LJ();
        if (!((fileLJ == null || !fileLJ.exists()) ? false : a(cVar, fileLJ))) {
            a(context, cVar, b.LF());
        }
        cVar.setStatus(bVar.LI());
        cVar.setSize(bVar.LG());
        cVar.setPercentNum(bVar.LK());
        cVar.setProgress(100, bVar.getProgress(), false);
        cVar.setControlBtnPaused(bVar.isPaused());
    }

    private void a(Context context, com.kwad.sdk.core.download.b.b bVar, b bVar2) {
        bVar.setName(bVar2.getName());
        File fileLJ = bVar2.LJ();
        if (!((fileLJ == null || !fileLJ.exists()) ? false : a(bVar, fileLJ))) {
            a(context, bVar, b.LF());
        }
        bVar.setStatus(bVar2.LI());
        bVar.setSize(bVar2.LH());
        bVar.setInstallText(bVar2.LL());
    }
}
