package com.kc.openset.util;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.byazt.tk.AdBaseConstants;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.sdk.adv.ADVDeviceUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class ApkDownloader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f39935a;
    private long b;
    private String c;
    private com.kc.openset.sdk.apiad.tools.c d;
    private boolean f;
    private boolean g;
    private boolean h;
    private HashMap<String, Object> e = new HashMap<>();
    private Handler i = new a(this, Looper.getMainLooper());
    private final BroadcastReceiver j = new b(this);
    private final BroadcastReceiver k = new c(this);

    @Keep
    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ApkDownloader f39936a;

        static {
            OSETSDKProtected.interface11(4915);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ApkDownloader apkDownloader, Looper looper) {
            super(looper);
            this.f39936a = apkDownloader;
        }

        @Override // android.os.Handler
        public native void handleMessage(Message message);
    }

    @Keep
    public class b extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ApkDownloader f39937a;

        static {
            OSETSDKProtected.interface11(4916);
        }

        public b(ApkDownloader apkDownloader) {
            this.f39937a = apkDownloader;
        }

        @Override // android.content.BroadcastReceiver
        public native void onReceive(Context context, Intent intent);
    }

    @Keep
    public class c extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ApkDownloader f39938a;

        static {
            OSETSDKProtected.interface11(4917);
        }

        public c(ApkDownloader apkDownloader) {
            this.f39938a = apkDownloader;
        }

        @Override // android.content.BroadcastReceiver
        public native void onReceive(Context context, Intent intent);
    }

    public ApkDownloader(Context context) {
        this.f39935a = context;
    }

    private com.kc.openset.sdk.adv.report.b a(int i) {
        String strX;
        HashMap map = new HashMap();
        com.kc.openset.sdk.apiad.tools.c cVar = this.d;
        if (cVar != null) {
            strX = cVar.X();
            if (!TextUtils.isEmpty(this.d.r())) {
                map.put("__CLICK_ID__", this.d.r());
            }
            com.kc.openset.sdk.apiad.tools.f.a(map, System.currentTimeMillis());
        } else {
            strX = "";
        }
        return com.kc.openset.sdk.apiad.tools.f.a(i, map, strX);
    }

    public static File a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        File externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        if (externalFilesDir == null) {
            externalFilesDir = context.getFilesDir();
            LogUtils.writeW("ApkDownloader", "外部存储不可用，使用内部存储：" + externalFilesDir.getPath());
        } else {
            LogUtils.writeD("ApkDownloader", "文件路径：" + externalFilesDir.getPath());
        }
        return new File(externalFilesDir, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File a(String str) {
        return a(this.f39935a, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file) {
        if (file == null) {
            LogUtils.writeE("ApkDownloader", "安装失败，apkFile为空！");
            return;
        }
        Context context = this.f39935a;
        if (context == null) {
            LogUtils.writeE("ApkDownloader", "安装失败，context 为空！");
            return;
        }
        int i = Build.VERSION.SDK_INT;
        if (!context.getPackageManager().canRequestPackageInstalls()) {
            LogUtils.writeD("ApkDownloader", "应用无安装权限，去申请！");
            Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + this.f39935a.getPackageName()));
            intent.addFlags(268435456);
            this.f39935a.startActivity(intent);
            return;
        }
        LogUtils.writeD("ApkDownloader", "开始安装apk: " + file.getPath());
        if (!file.exists()) {
            LogUtils.writeE("ApkDownloader", "安装失败，文件不存在！");
            return;
        }
        b(40);
        Intent intent2 = new Intent("android.intent.action.VIEW");
        Uri uriForFile = FileProvider.getUriForFile(this.f39935a, this.f39935a.getPackageName() + ".osetfileprovider", file);
        intent2.addFlags(1);
        intent2.setDataAndType(uriForFile, AdBaseConstants.MIME_APK);
        intent2.addFlags(268435456);
        this.f39935a.startActivity(intent2);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        if (i >= 33) {
            this.f39935a.registerReceiver(this.k, intentFilter, 4);
        } else {
            this.f39935a.registerReceiver(this.k, intentFilter);
        }
    }

    public static String b(Context context, String str) {
        ApplicationInfo applicationInfo;
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1);
            if (packageArchiveInfo == null || (applicationInfo = packageArchiveInfo.applicationInfo) == null) {
                return "";
            }
            applicationInfo.sourceDir = str;
            applicationInfo.publicSourceDir = str;
            return packageArchiveInfo.packageName;
        } catch (Exception unused) {
            return "";
        }
    }

    private String b(String str) {
        return b(this.f39935a, str);
    }

    private void b() {
        try {
            this.f39935a.unregisterReceiver(this.j);
        } catch (Exception unused) {
        }
        try {
            this.f39935a.unregisterReceiver(this.k);
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        LogUtils.writeD("ApkDownloader", "事件上报：" + com.kc.openset.sdk.adv.report.b.a(i));
        com.kc.openset.sdk.adv.report.a.b(a(i), this.d);
    }

    public static boolean c(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (context.getPackageManager().getLaunchIntentForPackage(str) != null) {
            return true;
        }
        Iterator<String> it = ADVDeviceUtils.q().iterator();
        while (it.hasNext()) {
            if (str.equals(it.next())) {
                return true;
            }
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 1) != null;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    private boolean c(String str) {
        return c(this.f39935a, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        LogUtils.writeD("ApkDownloader", "openApp: " + str);
        Context context = this.f39935a;
        if (context == null) {
            return;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                LogUtils.writeD("ApkDownloader", "包名直接启动");
                launchIntentForPackage.setFlags(268435456);
                this.f39935a.startActivity(launchIntentForPackage);
                b(42);
                this.h = true;
                return;
            }
            LogUtils.writeD("ApkDownloader", "尝试手动构造 launcher activity");
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(str);
            List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
            if (listQueryIntentActivities.isEmpty()) {
                b(43);
                this.h = false;
                return;
            }
            ActivityInfo activityInfo = listQueryIntentActivities.get(0).activityInfo;
            intent.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
            intent.setFlags(268435456);
            this.f39935a.startActivity(intent);
            b(42);
            this.h = true;
        } catch (Exception e) {
            LogUtils.writeE("ApkDownloader", "打开失败：" + e.getMessage());
            b(43);
            this.h = false;
        }
    }

    public void a() {
        b();
        HashMap<String, Object> map = this.e;
        if (map != null) {
            map.clear();
            this.e = null;
        }
    }

    public void a(com.kc.openset.sdk.apiad.tools.c cVar) {
        StringBuilder sb;
        String strA;
        if (cVar == null) {
            return;
        }
        String strR = cVar.R();
        if (TextUtils.isEmpty(this.c)) {
            if (TextUtils.isEmpty(strR)) {
                sb = new StringBuilder();
                strA = h0.a(cVar.j());
            } else {
                sb = new StringBuilder();
                strA = cVar.R();
            }
            sb.append(strA);
            sb.append(".apk");
            this.c = sb.toString();
        }
        File fileA = a(this.c);
        if (TextUtils.isEmpty(strR) && fileA != null && fileA.exists()) {
            strR = b(fileA.getPath());
        }
        LogUtils.writeD("ApkDownloader", "检查状态，包名：" + strR);
        if (c(strR)) {
            LogUtils.writeD("ApkDownloader", "检查状态，apk已安装。是否已经打开过了：" + this.h);
            if (this.h) {
                return;
            }
            d(strR);
            return;
        }
        if (!this.f) {
            LogUtils.writeD("ApkDownloader", "检查状态，去下载");
            b(cVar);
            return;
        }
        if (this.g) {
            if (this.h) {
                return;
            }
            LogUtils.writeD("ApkDownloader", "检查状态，已安装未打开，去打开");
            d(strR);
            return;
        }
        LogUtils.writeD("ApkDownloader", "检查状态，已下载未安装，去安装");
        boolean z = fileA != null && fileA.exists();
        LogUtils.writeD("ApkDownloader", "安装apk，是否存在：" + z);
        if (z) {
            a(fileA);
        } else {
            b(this.d);
        }
    }

    public void b(com.kc.openset.sdk.apiad.tools.c cVar) {
        if (cVar == null) {
            LogUtils.writeE("ApkDownloader", "API广告数据为空，不下载");
            return;
        }
        if (this.f39935a == null) {
            LogUtils.writeE("ApkDownloader", "Context = null，不下载");
            return;
        }
        String strR = cVar.R();
        if (TextUtils.isEmpty(strR)) {
            File fileA = a(h0.a(cVar.j()) + ".apk");
            if (fileA != null && fileA.exists()) {
                strR = b(fileA.getPath());
            }
        }
        LogUtils.writeD("ApkDownloader", "准备下载，包名：" + strR);
        if (c(strR)) {
            LogUtils.writeD("ApkDownloader", "apk已安装。无需下载，直接打开");
            d(strR);
            return;
        }
        File fileA2 = a(strR);
        if (fileA2 != null && fileA2.exists()) {
            LogUtils.writeD("ApkDownloader", "apk已下载，无需重复下载，直接安装");
            a(fileA2);
            return;
        }
        if (k.a(this.f39935a, this.b) == 2) {
            LogUtils.writeD("ApkDownloader", "下载中，可在通知栏查看结果");
            return;
        }
        String strJ = cVar.j();
        if (TextUtils.isEmpty(strJ)) {
            LogUtils.writeE("ApkDownloader", "下载地址不能为空！");
            return;
        }
        this.d = cVar.a();
        HashMap<String, Object> mapA = com.kc.openset.sdk.apiad.tools.e.a().a(cVar.X());
        if (mapA != null) {
            this.e.putAll(mapA);
        }
        String strA = TextUtils.isEmpty(strR) ? h0.a(strJ) : strR;
        this.c = strA + ".apk";
        String str = strA + ".tmp";
        File fileA3 = a(str);
        File fileA4 = a(str + ".oplusdownload");
        StringBuilder sb = new StringBuilder();
        sb.append("准备下载apk: ");
        sb.append(fileA3 != null ? fileA3.getPath() : "");
        LogUtils.writeD("ApkDownloader", sb.toString());
        if ((fileA3 != null && fileA3.exists()) || (fileA4 != null && fileA4.exists())) {
            LogUtils.writeD("ApkDownloader", "临时文件存在，正在下载中。。。");
            return;
        }
        File fileA5 = a(this.c);
        if (fileA5 != null && fileA5.exists()) {
            if (c(b(fileA5.getPath()))) {
                LogUtils.writeD("ApkDownloader", "apk已安装。直接打开。");
                d(strR);
                return;
            } else {
                LogUtils.writeD("ApkDownloader", "apk已存在，去安装。。。");
                this.f = true;
                a(fileA5);
                return;
            }
        }
        b(30);
        String strL = cVar.l();
        String strH = cVar.h();
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(strJ));
        request.setAllowedNetworkTypes(3);
        request.setDestinationInExternalFilesDir(this.f39935a, Environment.DIRECTORY_DOWNLOADS, this.c);
        request.setTitle(strL);
        request.setDescription(strH);
        request.setVisibleInDownloadsUi(true);
        int i = Build.VERSION.SDK_INT;
        request.setRequiresDeviceIdle(false);
        request.setRequiresCharging(false);
        request.setNotificationVisibility(3);
        this.b = ((DownloadManager) this.f39935a.getSystemService("download")).enqueue(request);
        LogUtils.writeD("ApkDownloader", "开始下载apk，downloadId：" + this.b);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE");
        if (i >= 33) {
            this.f39935a.registerReceiver(this.j, intentFilter, 4);
        } else {
            this.f39935a.registerReceiver(this.j, intentFilter);
        }
    }
}
