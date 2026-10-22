package com.kc.dw.core.utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import com.byazt.tk.AdBaseConstants;
import com.kc.dw.core.safe.SafeBroadcastReceiver;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.v39;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class DownloadUtils {
    public static Map<Integer, i0> h = new HashMap();
    public static final ConcurrentHashMap<String, e0> i = new ConcurrentHashMap<>();
    public static int j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NotificationManager f39336a;
    public RemoteViews b;
    public Notification c;
    public Handler d = new Handler(Looper.getMainLooper());
    public long e;
    public long f;
    public boolean g;

    @Keep
    public static class InstallSuccessReceiver extends SafeBroadcastReceiver {
        @Override // com.kc.dw.core.safe.SafeBroadcastReceiver
        public void a(Context context, Intent intent) {
            String[] strArr;
            if (intent != null) {
                try {
                    String action = intent.getAction();
                    intent.getPackage();
                    LogUtil.i("DownloadUtils", "InstallSuccessReceiver." + action);
                    if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                        String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                        Map<Integer, i0> map = DownloadUtils.h;
                        e0 e0Var = TextUtils.isEmpty(schemeSpecificPart) ? null : DownloadUtils.i.get(schemeSpecificPart);
                        if (e0Var != null && (strArr = e0Var.f39360a) != null) {
                            LogUtil.d("DownloadUtils", "Report send dn_inst_succ");
                            for (String str : strArr) {
                                if (!TextUtils.isEmpty(str)) {
                                    z.a(context, str, new j());
                                }
                            }
                        }
                        if (TextUtils.isEmpty(schemeSpecificPart)) {
                            return;
                        }
                        DownloadUtils.i.remove(schemeSpecificPart);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Keep
    public class NotificationClickReceiver extends SafeBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DownloadUtils f39337a;

        public NotificationClickReceiver(DownloadUtils downloadUtils) {
            this.f39337a = downloadUtils;
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0062  */
        @Override // com.kc.dw.core.safe.SafeBroadcastReceiver
        public void a(Context context, Intent intent) {
            com.kc.dw.core.download.b bVar;
            RemoteViews remoteViews;
            String str;
            Map<Integer, i0> map;
            Integer numValueOf;
            com.kc.dw.core.download.a aVar;
            com.kc.dw.core.download.d dVarB;
            com.kc.dw.core.download.b bVar2;
            try {
                String action = intent.getAction();
                DownloadUtils downloadUtils = this.f39337a;
                long jCurrentTimeMillis = System.currentTimeMillis();
                DownloadUtils downloadUtils2 = this.f39337a;
                downloadUtils.f = jCurrentTimeMillis - downloadUtils2.e;
                downloadUtils2.e = System.currentTimeMillis();
                if (this.f39337a.f < 500) {
                    return;
                }
                String stringExtra = intent.getStringExtra("notify_url");
                byte b = 0;
                int intExtra = intent.getIntExtra("notify_id", 0);
                int iHashCode = action.hashCode();
                if (iHashCode != 1099814334) {
                    if (iHashCode != 1111837832) {
                        if (iHashCode == 1777068973 && action.equals("ACTION_DOWNLOAD_INSTALL")) {
                            b = 2;
                        } else {
                            b = -1;
                        }
                    } else if (!action.equals("ACTION_DOWNLOAD_PAUSE")) {
                        b = -1;
                    }
                } else if (action.equals("ACTION_DOWNLOAD_CACEL")) {
                    b = 1;
                } else {
                    b = -1;
                }
                if (b != 0) {
                    if (b == 1) {
                        com.kc.dw.core.download.a.C1023a.f39242a.a(stringExtra);
                        NotificationManager notificationManager = this.f39337a.f39336a;
                        if (notificationManager != null) {
                            notificationManager.cancel(intExtra);
                        }
                        map = DownloadUtils.h;
                        numValueOf = Integer.valueOf(DownloadUtils.a(stringExtra));
                    } else {
                        if (b != 2 || (dVarB = (aVar = com.kc.dw.core.download.a.C1023a.f39242a).b(stringExtra)) == null || (bVar2 = dVarB.f39245a) == null || bVar2.g != 5) {
                            return;
                        }
                        aVar.a(stringExtra);
                        NotificationManager notificationManager2 = this.f39337a.f39336a;
                        if (notificationManager2 != null) {
                            notificationManager2.cancel(intExtra);
                        }
                        DownloadUtils.a(context, stringExtra);
                        map = DownloadUtils.h;
                        numValueOf = Integer.valueOf(DownloadUtils.a(stringExtra));
                    }
                    map.remove(numValueOf);
                    return;
                }
                com.kc.dw.core.download.d dVarB2 = com.kc.dw.core.download.a.C1023a.f39242a.b(stringExtra);
                if (dVarB2 != null && (bVar = dVarB2.f39245a) != null) {
                    int identifier = context.getResources().getIdentifier("ms_notification_pause", "id", context.getPackageName());
                    if (identifier == 0) {
                        identifier = R.id.ms_notification_pause;
                    }
                    if (bVar.g == 3) {
                        dVarB2.a();
                        remoteViews = this.f39337a.b;
                        if (remoteViews != null) {
                            str = "暂停";
                            remoteViews.setTextViewText(identifier, str);
                        }
                    } else {
                        dVarB2.c.remove(dVarB2);
                        com.kc.dw.core.download.b bVar3 = dVarB2.f39245a;
                        int i = bVar3.g;
                        if (i == 1) {
                            bVar3.g = 3;
                            com.kc.dw.core.download.d.g.post(new com.kc.dw.core.download.f(dVarB2, bVar3));
                        } else if (i == 2) {
                            bVar3.g = 3;
                        }
                        remoteViews = this.f39337a.b;
                        if (remoteViews != null) {
                            str = "继续";
                            remoteViews.setTextViewText(identifier, str);
                        }
                    }
                }
                if (this.f39337a.f39336a == null || !DownloadUtils.h.containsKey(Integer.valueOf(intExtra))) {
                    return;
                }
                this.f39337a.f39336a.notify(intExtra, DownloadUtils.h.get(Integer.valueOf(intExtra)).f39373a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Keep
    public class a implements com.kc.dw.core.download.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f39338a;
        public final String[] b;
        public final Context c;
        public final String d;
        public final String e;
        public final String[] f;
        public final String[] g;
        public final String[] h;
        public final DownloadUtils i;

        /* JADX INFO: renamed from: com.kc.dw.core.utils.DownloadUtils$a$a, reason: collision with other inner class name */
        @Keep
        public class C1049a extends com.kc.dw.core.safe.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final com.kc.dw.core.download.b f39339a;
            public final a b;

            public C1049a(a aVar, com.kc.dw.core.download.b bVar) {
                this.b = aVar;
                this.f39339a = bVar;
            }

            @Override // com.kc.dw.core.safe.j
            public void safeRun() {
                try {
                    com.kc.dw.core.download.b bVar = this.f39339a;
                    int i = (int) (((bVar.f * 1.0f) / bVar.e) * 100.0f);
                    if (i > 100) {
                        i = 100;
                    }
                    a aVar = this.b;
                    DownloadUtils downloadUtils = aVar.i;
                    if (downloadUtils.f39336a == null || downloadUtils.b == null) {
                        return;
                    }
                    int iA = y0.a(aVar.c, "ms_notification_progressText");
                    int iA2 = y0.a(this.b.c, "ms_notification_pregressBar");
                    if (iA == 0) {
                        iA = R.id.ms_notification_progressText;
                    }
                    if (iA2 == 0) {
                        iA2 = R.id.ms_notification_pregressBar;
                    }
                    this.b.i.b.setTextViewText(iA, i + "%");
                    this.b.i.b.setProgressBar(iA2, 100, i, false);
                    int iA3 = DownloadUtils.a(this.f39339a.f39243a);
                    if (DownloadUtils.h.containsKey(Integer.valueOf(iA3))) {
                        this.b.i.f39336a.notify(iA3, DownloadUtils.h.get(Integer.valueOf(iA3)).f39373a);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        public a(DownloadUtils downloadUtils, String str, String[] strArr, Context context, String str2, String str3, String[] strArr2, String[] strArr3, String[] strArr4) {
            this.i = downloadUtils;
            this.f39338a = str;
            this.b = strArr;
            this.c = context;
            this.d = str2;
            this.e = str3;
            this.f = strArr2;
            this.g = strArr3;
            this.h = strArr4;
        }

        @Override // com.kc.dw.core.download.h
        public void a(com.kc.dw.core.download.b bVar) {
            try {
                if (DownloadUtils.h == null) {
                    DownloadUtils.h = new HashMap();
                }
                if (DownloadUtils.h.containsKey(Integer.valueOf(DownloadUtils.a(this.f39338a)))) {
                    return;
                }
                try {
                    if (this.b != null) {
                        LogUtil.d("DownloadUtils", "Report send dn_start");
                        for (String str : this.b) {
                            if (!TextUtils.isEmpty(str)) {
                                z.a(this.c, str, new j());
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i0 i0Var = new i0();
                i0Var.b = this.d;
                i0Var.c = this.e;
                i0Var.d = this.b;
                i0Var.e = this.f;
                i0Var.f = this.g;
                i0Var.g = this.h;
                DownloadUtils.h.put(Integer.valueOf(DownloadUtils.a(this.f39338a)), i0Var);
                DownloadUtils.a(this.i, this.f39338a, this.c, this.d, this.e);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.kc.dw.core.download.h
        public void a(com.kc.dw.core.download.b bVar, String str) {
            try {
                LogUtil.e("DownloadUtils", "err=" + str);
                com.kc.dw.core.download.a.C1023a.f39242a.a(this.f39338a);
                NotificationManager notificationManager = this.i.f39336a;
                if (notificationManager != null) {
                    notificationManager.cancel(DownloadUtils.a(this.f39338a));
                }
                DownloadUtils.h.remove(Integer.valueOf(DownloadUtils.a(this.f39338a)));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.kc.dw.core.download.h
        public void a(File file, com.kc.dw.core.download.b bVar) {
            try {
                DownloadUtils downloadUtils = this.i;
                Context context = this.c;
                downloadUtils.d.post(new o(downloadUtils, bVar.f39243a, context));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.kc.dw.core.download.h
        public void b(com.kc.dw.core.download.b bVar) {
            this.i.d.post(new C1049a(this, bVar));
        }
    }

    @Keep
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DownloadUtils f39340a = new DownloadUtils();
    }

    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return Math.abs(str.hashCode() + 199);
    }

    public static void a(Context context) {
        if (com.kc.dw.base.a.adConfig() == null || !com.kc.dw.base.a.adConfig().enableInstallBroadcast()) {
            return;
        }
        DownloadUtils downloadUtils = b.f39340a;
        if (downloadUtils.g) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
            intentFilter.addDataScheme("package");
            context.registerReceiver(new InstallSuccessReceiver(), intentFilter);
            downloadUtils.g = true;
        } catch (Exception e) {
            LogUtil.w("DownloadUtils", "Failed registerReceiver InstallSuccessReceiver");
            e.printStackTrace();
        }
    }

    public static void a(Context context, File file, i0 i0Var) {
        if (file != null) {
            try {
                if (file.exists()) {
                    if (i0Var != null) {
                        try {
                            String[] strArr = i0Var.f;
                            if (strArr != null) {
                                LogUtil.d("DownloadUtils", "Report send dn_inst_start");
                                for (String str : strArr) {
                                    if (!TextUtils.isEmpty(str)) {
                                        z.a(context, str, new j());
                                    }
                                }
                            }
                            a(i0Var);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        Intent intent = new Intent("android.intent.action.INSTALL_PACKAGE");
                        intent.addFlags(268435456);
                        intent.addFlags(1);
                        if (TextUtils.isEmpty(s.f39404a)) {
                            s.a(context, com.kc.dw.base.a.adConfig() != null ? com.kc.dw.base.a.adConfig().getAuthority() : null);
                        }
                        intent.setDataAndType(FileProvider.getUriForFile(context, s.f39404a, file), AdBaseConstants.MIME_APK);
                        context.startActivity(intent);
                        return;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return;
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
                return;
            }
        }
        LogUtil.e("DownloadUtils", "file not exists");
    }

    public static void a(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String strReplace = str.substring(str.lastIndexOf(WVNativeCallbackUtil.SEPERATER)).replace(WVNativeCallbackUtil.SEPERATER, "");
            String str2 = com.kc.dw.core.download.a.C1023a.f39242a.c;
            try {
                strReplace = o1.a(MessageDigest.getInstance("MD5").digest(str.getBytes())).toLowerCase() + ".apk";
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            a(context, new File(str2, strReplace), h.get(Integer.valueOf(a(str))));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(DownloadUtils downloadUtils, String str, Context context, String str2, String str3) {
        i0 i0Var;
        downloadUtils.getClass();
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("ACTION_DOWNLOAD_PAUSE");
            intentFilter.addAction("ACTION_DOWNLOAD_CACEL");
            intentFilter.addAction("ACTION_DOWNLOAD_INSTALL");
            if (Build.VERSION.SDK_INT < 34 || context.getApplicationInfo().targetSdkVersion < 34) {
                context.registerReceiver(new NotificationClickReceiver(downloadUtils), intentFilter);
            } else {
                context.registerReceiver(new NotificationClickReceiver(downloadUtils), intentFilter, 4);
            }
            a(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        downloadUtils.f39336a = (NotificationManager) context.getSystemService("notification");
        int i2 = Build.VERSION.SDK_INT;
        NotificationChannel notificationChannel = new NotificationChannel("ms_download", "正在下载应用" + str2 + v39.CHARACTER_ELLIPSIZE, 4);
        notificationChannel.setSound(null, null);
        downloadUtils.f39336a.createNotificationChannel(notificationChannel);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context.getApplicationContext(), "ms_download");
        builder.setContentTitle("正在下载应用" + str2 + v39.CHARACTER_ELLIPSIZE);
        int identifier = context.getResources().getIdentifier("ms_ic_launcher", "mipmap", context.getPackageName());
        if (identifier == 0) {
            identifier = android.R.drawable.stat_sys_download;
        }
        builder.setSmallIcon(identifier);
        builder.setAutoCancel(true);
        downloadUtils.c = builder.build();
        int identifier2 = context.getResources().getIdentifier("ms_notification_item", "layout", context.getPackageName());
        if (identifier2 == 0) {
            downloadUtils.b = new RemoteViews(context.getPackageName(), R.layout.ssd_notification_item);
        } else {
            downloadUtils.b = new RemoteViews(context.getPackageName(), identifier2);
        }
        int identifier3 = context.getResources().getIdentifier("ms_notification_title", "id", context.getPackageName());
        int identifier4 = context.getResources().getIdentifier("ms_notification_cancel", "id", context.getPackageName());
        int identifier5 = context.getResources().getIdentifier("ms_notification_pause", "id", context.getPackageName());
        int identifier6 = context.getResources().getIdentifier("ms_notification_progressText", "id", context.getPackageName());
        int identifier7 = context.getResources().getIdentifier("ms_notification_pregressBar", "id", context.getPackageName());
        int identifier8 = context.getResources().getIdentifier("ms_notification_rootView", "id", context.getPackageName());
        if (identifier3 != 0) {
            downloadUtils.b.setTextViewText(identifier3, "正在下载:" + str2 + v39.CHARACTER_ELLIPSIZE);
        } else {
            downloadUtils.b.setTextViewText(R.id.ms_notification_title, "正在下载:" + str2 + v39.CHARACTER_ELLIPSIZE);
        }
        RemoteViews remoteViews = downloadUtils.b;
        if (identifier4 != 0) {
            remoteViews.setViewVisibility(identifier4, 0);
        } else {
            remoteViews.setViewVisibility(R.id.ms_notification_cancel, 0);
        }
        RemoteViews remoteViews2 = downloadUtils.b;
        if (identifier5 != 0) {
            remoteViews2.setViewVisibility(identifier5, 0);
        } else {
            remoteViews2.setViewVisibility(R.id.ms_notification_pause, 0);
        }
        RemoteViews remoteViews3 = downloadUtils.b;
        if (identifier6 != 0) {
            remoteViews3.setTextViewText(identifier6, "0%");
        } else {
            remoteViews3.setTextViewText(R.id.ms_notification_progressText, "0%");
        }
        if (identifier7 != 0) {
            downloadUtils.b.setProgressBar(identifier7, 100, 0, false);
        } else {
            downloadUtils.b.setProgressBar(R.id.ms_notification_pregressBar, 100, 0, false);
        }
        int iA = a(str);
        j = iA;
        Intent intent = new Intent();
        intent.setAction("ACTION_DOWNLOAD_PAUSE");
        intent.putExtra("notify_id", iA);
        intent.putExtra("notify_url", str);
        int i3 = j;
        PendingIntent broadcast = i2 >= 31 ? PendingIntent.getBroadcast(context, i3, intent, 201326592) : PendingIntent.getBroadcast(context, i3, intent, 134217728);
        if (identifier5 == 0) {
            identifier5 = R.id.ms_notification_pause;
        }
        downloadUtils.b.setOnClickPendingIntent(identifier5, broadcast);
        Intent intent2 = new Intent();
        intent2.setAction("ACTION_DOWNLOAD_CACEL");
        intent2.putExtra("notify_id", iA);
        intent2.putExtra("notify_url", str);
        PendingIntent broadcast2 = PendingIntent.getBroadcast(context, j, intent2, i2 >= 31 ? 335544320 : 268435456);
        if (identifier4 == 0) {
            identifier4 = R.id.ms_notification_cancel;
        }
        downloadUtils.b.setOnClickPendingIntent(identifier4, broadcast2);
        Intent intent3 = new Intent();
        intent3.setAction("ACTION_DOWNLOAD_INSTALL");
        intent3.putExtra("notify_id", iA);
        intent3.putExtra("notify_url", str);
        PendingIntent broadcast3 = i2 >= 31 ? PendingIntent.getBroadcast(context, j, intent3, 201326592) : PendingIntent.getBroadcast(context, j, intent3, 134217728);
        if (identifier8 == 0) {
            identifier8 = R.id.ms_notification_rootView;
        }
        downloadUtils.b.setOnClickPendingIntent(identifier8, broadcast3);
        if (h.containsKey(Integer.valueOf(iA)) && (i0Var = h.get(Integer.valueOf(iA))) != null) {
            i0Var.f39373a = downloadUtils.c;
            h.put(Integer.valueOf(iA), i0Var);
        }
        Notification notification = downloadUtils.c;
        notification.contentView = downloadUtils.b;
        downloadUtils.f39336a.notify(iA, notification);
    }

    public static void a(i0 i0Var) {
        String str = i0Var.c;
        e0 e0Var = new e0(i0Var.b, str, i0Var.d, i0Var.e, i0Var.f, i0Var.g);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        i.put(str, e0Var);
    }

    public void a(Context context, String str, String str2, String str3, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.kc.dw.core.download.a aVar = com.kc.dw.core.download.a.C1023a.f39242a;
        com.kc.dw.core.download.d dVar = aVar.f39241a.get(str);
        if (dVar == null) {
            dVar = new com.kc.dw.core.download.d(str, str2, "", str);
            aVar.f39241a.put(str, dVar);
        }
        com.kc.dw.core.download.d dVar2 = dVar;
        dVar2.e.put(dVar2.b, new a(this, str, strArr, context, str2, str3, strArr2, strArr3, strArr4));
        dVar2.a();
    }
}
