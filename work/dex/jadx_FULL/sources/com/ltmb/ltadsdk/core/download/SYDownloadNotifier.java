package com.ltmb.ltadsdk.core.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ltmb.ltadsdk.pkg.d9;
import com.ltmb.ltadsdk.pkg.o7;
import com.ltmb.ltadsdk.pkg.u6;
import com.ltmb.ltadsdk.pkg.x6;
import com.ltmb.ltadsdk.pkg.y6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000  2\u00020\u0001:\u0002 !B\t\b\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J \u0010\u000f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fJ\u0018\u0010\u0012\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u0010J\"\u0010\u0015\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0019\u001a\u00020\u0004J\u0016\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004¨\u0006\""}, d2 = {"Lcom/ltmb/ltadsdk/core/download/SYDownloadNotifier;", "", "", "init", "", CachedContentIndex.a.e, "Lcom/ltmb/ltadsdk/core/download/SYDownloadListenerInner;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "register", "unRegister", "Lcom/ltmb/ltadsdk/core/download/SYDownloadTask;", "task", "", "totalBytes", "downloadedBytes", "updateDownloadProgress", "", "status", "updateDownloadStatus", "errorCode", "errorMsg", "downloadFail", "Landroid/content/Context;", "context", "destroy", "url", "getDownloadTask", "pkgName", "requestId", "onAppInstalled", "<init>", "()V", "Companion", "PackageReceiver", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public final class SYDownloadNotifier {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Lazy e = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, a.f40346a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile ConcurrentHashMap<String, List<SYDownloadListenerInner>> f40345a;
    public SYDownloadReceiver b;
    public WeakHashMap<String, SYDownloadTask> c;
    public PackageReceiver d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0016\u0010\f\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0016\u0010\r\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\nR\u0016\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0016\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0016\u0010\u0010\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0016\u0010\u0011\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\nR\u0016\u0010\u0012\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\nR\u0016\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\nR\u0016\u0010\u0014\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\nR\u0016\u0010\u0015\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/ltmb/ltadsdk/core/download/SYDownloadNotifier$Companion;", "", "Lcom/ltmb/ltadsdk/core/download/SYDownloadNotifier;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/ltmb/ltadsdk/core/download/SYDownloadNotifier;", "instance", "", "ACTION_DOWNLOAD_FAIL", "Ljava/lang/String;", "ACTION_INSTALL_SUCCESS", "ACTION_UPDATE_PROGRESS", "ACTION_UPDATE_STATUS", "KEY_DOWNLOAD_BYTES", "KEY_DOWNLOAD_TASK", "KEY_ERROR_CODE", "KEY_ERROR_MSG", "KEY_INSTALLED_PKG", "KEY_REQUEST_ID", "KEY_STATUS", "KEY_TOTAL_BYTES", "<init>", "()V", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final SYDownloadNotifier getInstance() {
            Lazy lazy = SYDownloadNotifier.e;
            Companion companion = SYDownloadNotifier.INSTANCE;
            return (SYDownloadNotifier) lazy.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ltmb/ltadsdk/core/download/SYDownloadNotifier$PackageReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "(Lcom/ltmb/ltadsdk/core/download/SYDownloadNotifier;)V", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
    public final class PackageReceiver extends BroadcastReceiver {
        public PackageReceiver(SYDownloadNotifier sYDownloadNotifier) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            d9.d.a("intent.action=" + intent.getAction());
            if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", intent.getAction())) {
                Uri data = intent.getData();
                Intrinsics.checkNotNull(data);
                Intrinsics.checkNotNullExpressionValue(data, "intent.data!!");
                String schemeSpecificPart = data.getSchemeSpecificPart();
                y6 y6Var = y6.g;
                Intrinsics.checkNotNullExpressionValue(schemeSpecificPart, "installedPackageName");
                Intrinsics.checkNotNullParameter(schemeSpecificPart, "pkgName");
                if (context != null && y6.c.contains(schemeSpecificPart)) {
                    ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) y6.a;
                    if (concurrentHashMap.containsKey(schemeSpecificPart)) {
                        return;
                    }
                    concurrentHashMap.put(schemeSpecificPart, Boolean.TRUE);
                    y6Var.b(context);
                    return;
                }
                return;
            }
            if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", intent.getAction())) {
                Uri data2 = intent.getData();
                Intrinsics.checkNotNull(data2);
                Intrinsics.checkNotNullExpressionValue(data2, "intent.data!!");
                String schemeSpecificPart2 = data2.getSchemeSpecificPart();
                y6 y6Var2 = y6.g;
                Intrinsics.checkNotNullExpressionValue(schemeSpecificPart2, "unInstalledPackageName");
                Intrinsics.checkNotNullParameter(schemeSpecificPart2, "pkgName");
                if (context != null) {
                    ConcurrentHashMap concurrentHashMap2 = (ConcurrentHashMap) y6.a;
                    if (concurrentHashMap2.containsKey(schemeSpecificPart2)) {
                        concurrentHashMap2.remove(schemeSpecificPart2);
                        y6Var2.b(context);
                    }
                    x6 x6Var = x6.g;
                    if (schemeSpecificPart2 != null) {
                        try {
                            if (x6.f.containsKey(schemeSpecificPart2)) {
                                x6.f.remove(schemeSpecificPart2);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
                SYDownloadManager.INSTANCE.getInstance().onAppUnInstalled(schemeSpecificPart2);
            }
        }
    }

    public static final class a extends Lambda implements Function0<SYDownloadNotifier> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f40346a = new a();

        public a() {
            super(0);
        }

        public Object invoke() {
            return new SYDownloadNotifier(null);
        }
    }

    public SYDownloadNotifier() {
        this.f40345a = new ConcurrentHashMap<>();
        this.c = new WeakHashMap<>();
    }

    public final void destroy(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            SYDownloadReceiver sYDownloadReceiver = this.b;
            if (sYDownloadReceiver != null) {
                context.unregisterReceiver(sYDownloadReceiver);
            }
            PackageReceiver packageReceiver = this.d;
            if (packageReceiver != null) {
                context.unregisterReceiver(packageReceiver);
            }
        } catch (Throwable th) {
            d9.d.a(th);
        }
    }

    public final void downloadFail(@Nullable SYDownloadTask task, int errorCode, @Nullable String errorMsg) {
        List<SYDownloadListenerInner> list;
        if (task == null || (list = this.f40345a.get(task.getUniqueKey())) == null) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((SYDownloadListenerInner) it.next()).onDownloadFailed(task, errorCode, errorMsg);
        }
    }

    @Nullable
    public final SYDownloadTask getDownloadTask(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return this.c.get(url);
    }

    public final void init() {
        Context contextA = u6.n.a();
        if (contextA != null) {
            d9.d.a("registerLocalBroadcast");
            try {
                this.b = new SYDownloadReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.ltmb.ltadsdk.download.notify_progress");
                intentFilter.addAction("com.ltmb.ltadsdk.download.notify_status");
                intentFilter.addAction("com.ltmb.ltadsdk.download.will_install_pkg");
                intentFilter.addAction("com.ltmb.ltadsdk.download.notify_fail");
                if (Build.VERSION.SDK_INT >= 33) {
                    contextA.registerReceiver(this.b, intentFilter, SYDownloadReceiver.INSTANCE.a(), null, 4);
                } else {
                    contextA.registerReceiver(this.b, intentFilter, SYDownloadReceiver.INSTANCE.a(), null);
                }
                if (o7.a.a(contextA)) {
                    this.d = new PackageReceiver(this);
                    IntentFilter intentFilter2 = new IntentFilter();
                    intentFilter2.addAction("android.intent.action.PACKAGE_ADDED");
                    intentFilter2.addAction("android.intent.action.PACKAGE_REMOVED");
                    intentFilter2.addAction("android.intent.action.PACKAGE_REPLACED");
                    intentFilter2.addDataScheme("package");
                    contextA.registerReceiver(this.d, intentFilter2);
                }
            } catch (Throwable th) {
                d9.d.a(th);
            }
        }
    }

    public final void onAppInstalled(@NotNull String pkgName, @NotNull String requestId) {
        List<SYDownloadListenerInner> list;
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        d9 d9Var = d9.d;
        d9Var.a("通知回调，安装成功 pkgName=" + pkgName + ", requestId=" + requestId);
        StringBuilder sb = new StringBuilder();
        sb.append("mNotifyMap=");
        sb.append(this.f40345a);
        d9Var.a(sb.toString());
        SYDownloadManager.INSTANCE.getInstance().onAppInstalled(pkgName);
        if (!this.f40345a.containsKey(pkgName) || (list = this.f40345a.get(pkgName)) == null) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((SYDownloadListenerInner) it.next()).onInstalled(requestId);
        }
    }

    public final synchronized void register(@NotNull String key, @NotNull SYDownloadListenerInner listener) {
        Intrinsics.checkNotNullParameter(key, CachedContentIndex.a.e);
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        List<SYDownloadListenerInner> arrayList = this.f40345a.get(key);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f40345a.put(key, arrayList);
        }
        if (!arrayList.contains(listener)) {
            arrayList.add(listener);
        }
    }

    public final void unRegister(@NotNull String key, @NotNull SYDownloadListenerInner listener) {
        List<SYDownloadListenerInner> list;
        Intrinsics.checkNotNullParameter(key, CachedContentIndex.a.e);
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        if (!this.f40345a.containsKey(key) || (list = this.f40345a.get(key)) == null) {
            return;
        }
        list.remove(listener);
        if (list.isEmpty()) {
            this.f40345a.remove(key);
        }
    }

    public final void updateDownloadProgress(@Nullable SYDownloadTask task, long totalBytes, long downloadedBytes) {
        List<SYDownloadListenerInner> list;
        if (task == null || (list = this.f40345a.get(task.getUniqueKey())) == null) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((SYDownloadListenerInner) it.next()).onDownloadUpdate(task, totalBytes, downloadedBytes);
        }
    }

    public final void updateDownloadStatus(@Nullable SYDownloadTask task, int status) {
        List<SYDownloadListenerInner> list;
        if (task == null) {
            return;
        }
        SYDownloadManager.INSTANCE.getInstance().tryUpdatePreQueryInfo(task);
        d9 d9Var = d9.d;
        d9Var.a("updateDownloadStatus, key=" + task.getUniqueKey() + ", status=" + status);
        StringBuilder sb = new StringBuilder();
        sb.append("mNotifyMap = ");
        sb.append(this.f40345a);
        d9Var.a(sb.toString());
        if (!this.f40345a.containsKey(task.getUniqueKey()) || (list = this.f40345a.get(task.getUniqueKey())) == null) {
            return;
        }
        for (SYDownloadListenerInner sYDownloadListenerInner : list) {
            if (status == 2) {
                sYDownloadListenerInner.onDownloadStart(task);
                this.c.put(task.getUrl(), task);
            } else if (status == 3) {
                sYDownloadListenerInner.onDownloadPaused(task);
            } else if (status == 4) {
                sYDownloadListenerInner.onDownloadCompleted(task);
            } else if (status == 5) {
                this.c.remove(task.getUrl());
            } else if (status == 6) {
                sYDownloadListenerInner.onInstallStart(task.getRequestId());
            }
        }
    }

    public /* synthetic */ SYDownloadNotifier(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
