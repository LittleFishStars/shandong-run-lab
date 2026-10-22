package com.ltmb.ltadsdk.core.download;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ltmb.ltadsdk.pkg.d9;
import com.ltmb.ltadsdk.pkg.hb;
import com.ltmb.ltadsdk.pkg.kb;
import com.ltmb.ltadsdk.pkg.s7;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000  2\u00020\u0001:\u0001 B\t\b\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J&\u0010\r\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u001a\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eJ\u001a\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001a\u001a\u00020\bJ\u001a\u0010\u001c\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u001a\u0010\u001d\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¨\u0006!"}, d2 = {"Lcom/ltmb/ltadsdk/core/download/SYDownloadManager;", "", "Landroid/content/Context;", "context", "Lcom/ltmb/ltadsdk/pkg/hb;", "config", "", "init", "", "pkgName", "versionName", "Lcom/ltmb/ltadsdk/core/download/SYDownloadQueryCallback;", RenderCallContext.TYPE_CALLBACK, "queryApkDownloadInfo", "Lcom/ltmb/ltadsdk/core/download/SYDownloadTask;", "task", "tryUpdatePreQueryInfo", "onAppInstalled", "onAppUnInstalled", "Lcom/ltmb/ltadsdk/core/download/SYDownloadListenerInner;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "startDownloadApk", "pauseDownloadApk", "resumeDownloadApk", "installApk", "startDownload", "url", "queryDownloadInfo", "registerDownloadListener", "unRegisterDownloadListener", "<init>", "()V", "Companion", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public final class SYDownloadManager {

    @NotNull
    public static final String DOWNLOAD_TYPE_APK = "apk";
    public static final int MAX_RUNNING_TASKS = 5;
    public static final int NET_TYPE_ALL = 2;
    public static final int NET_TYPE_MOBILE = 1;
    public static final int NET_TYPE_WIFI = 0;
    public static final int PRIORITY_HIGH = 10;
    public static final int PRIORITY_LOW = 1;
    public static final int PRIORITY_NORMAL = 5;
    public static final int STATUS_COMPLETED = 4;
    public static final int STATUS_DOWNLOADING = 2;
    public static final int STATUS_FAILED = 5;
    public static final int STATUS_INSTALLED = 7;
    public static final int STATUS_INSTALL_START = 6;
    public static final int STATUS_PAUSED = 3;
    public static final int STATUS_PENDING = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ServiceConnection f40342a;
    public com.ltmb.ltadsdk.a b;
    public boolean c;
    public SYDownloadTask d;
    public String e;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Lazy f = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, a.f40343a);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0016\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0016\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0016\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\rR\u0016\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\rR\u0016\u0010\u0017\u001a\u00020\u000b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\rR\u0016\u0010\u0018\u001a\u00020\u000b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\rR\u0016\u0010\u0019\u001a\u00020\u000b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\rR\u0016\u0010\u001a\u001a\u00020\u000b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/ltmb/ltadsdk/core/download/SYDownloadManager$Companion;", "", "Lcom/ltmb/ltadsdk/core/download/SYDownloadManager;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/ltmb/ltadsdk/core/download/SYDownloadManager;", "instance", "", "DOWNLOAD_TYPE_APK", "Ljava/lang/String;", "", "MAX_RUNNING_TASKS", "I", "NET_TYPE_ALL", "NET_TYPE_MOBILE", "NET_TYPE_WIFI", "PRIORITY_HIGH", "PRIORITY_LOW", "PRIORITY_NORMAL", "STATUS_COMPLETED", "STATUS_DOWNLOADING", "STATUS_FAILED", "STATUS_INSTALLED", "STATUS_INSTALL_START", "STATUS_PAUSED", "STATUS_PENDING", "<init>", "()V", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final SYDownloadManager getInstance() {
            Lazy lazy = SYDownloadManager.f;
            Companion companion = SYDownloadManager.INSTANCE;
            return (SYDownloadManager) lazy.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class a extends Lambda implements Function0<SYDownloadManager> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f40343a = new a();

        public a() {
            super(0);
        }

        public Object invoke() {
            return new SYDownloadManager(null);
        }
    }

    public static final class b implements ServiceConnection {
        public final /* synthetic */ long b;
        public final /* synthetic */ Context c;

        public b(long j, Context context) {
            this.b = j;
            this.c = context;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(@Nullable ComponentName componentName, @Nullable IBinder iBinder) {
            com.ltmb.ltadsdk.a c1319a;
            d9.d.a("bindService end cost=" + (System.currentTimeMillis() - this.b));
            SYDownloadManager sYDownloadManager = SYDownloadManager.this;
            int i = com.ltmb.ltadsdk.a.AbstractBinderC1318a.f40289a;
            if (iBinder == null) {
                c1319a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.ltmb.ltadsdk.ISYDownloadProxy");
                c1319a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof com.ltmb.ltadsdk.a)) ? new com.ltmb.ltadsdk.a.AbstractBinderC1318a.C1319a(iBinder) : (com.ltmb.ltadsdk.a) iInterfaceQueryLocalInterface;
            }
            sYDownloadManager.b = c1319a;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(@Nullable ComponentName componentName) {
            d9.d.a("onServiceDisconnected");
            SYDownloadManager.this.b = null;
            SYDownloadManager.this.a(this.c);
        }
    }

    public SYDownloadManager() {
        this.e = "";
    }

    public static /* synthetic */ void queryApkDownloadInfo$default(SYDownloadManager sYDownloadManager, String str, String str2, SYDownloadQueryCallback sYDownloadQueryCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            sYDownloadQueryCallback = null;
        }
        sYDownloadManager.queryApkDownloadInfo(str, str2, sYDownloadQueryCallback);
    }

    public static /* synthetic */ void startDownload$default(SYDownloadManager sYDownloadManager, SYDownloadTask sYDownloadTask, SYDownloadListenerInner sYDownloadListenerInner, int i, Object obj) {
        if ((i & 2) != 0) {
            sYDownloadListenerInner = null;
        }
        sYDownloadManager.startDownload(sYDownloadTask, sYDownloadListenerInner);
    }

    public static /* synthetic */ void startDownloadApk$default(SYDownloadManager sYDownloadManager, SYDownloadTask sYDownloadTask, SYDownloadListenerInner sYDownloadListenerInner, int i, Object obj) {
        if ((i & 2) != 0) {
            sYDownloadListenerInner = null;
        }
        sYDownloadManager.startDownloadApk(sYDownloadTask, sYDownloadListenerInner);
    }

    public final void a(Context context) {
        if (this.f40342a != null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        d9.d.a("bindService start ts=" + jCurrentTimeMillis);
        this.f40342a = new b(jCurrentTimeMillis, context);
        Intent intent = new Intent(context, (Class<?>) SYDownloadService.class);
        intent.setPackage(context.getPackageName());
        ServiceConnection serviceConnection = this.f40342a;
        Intrinsics.checkNotNull(serviceConnection);
        context.bindService(intent, serviceConnection, 1);
    }

    public final void init(@NotNull Context context, @NotNull hb config) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        if (this.c) {
            return;
        }
        try {
            SYDownloadNotifier.INSTANCE.getInstance().init();
            s7.a.a(new kb(context), "SYDownloadProcessor init ");
            this.c = true;
        } catch (Throwable th) {
            d9.d.a(th);
        }
    }

    public final void installApk(@NotNull SYDownloadTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        SYDownloadProcessor.l.a().a(task);
    }

    public final void onAppInstalled(@NotNull String pkgName) {
        SYDownloadTask sYDownloadTask;
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        String str = this.e;
        if (str == null || str.length() == 0) {
            return;
        }
        String str2 = this.e;
        Intrinsics.checkNotNull(str2);
        if (!StringsKt.startsWith$default(str2, pkgName, false, 2, (Object) null) || (sYDownloadTask = this.d) == null) {
            return;
        }
        sYDownloadTask.setStatus(7);
    }

    public final void onAppUnInstalled(@NotNull String pkgName) {
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        String str = this.e;
        if (str == null || str.length() == 0) {
            return;
        }
        String str2 = this.e;
        Intrinsics.checkNotNull(str2);
        if (StringsKt.startsWith$default(str2, pkgName, false, 2, (Object) null)) {
            this.e = null;
            this.d = null;
        }
    }

    public final void pauseDownloadApk(@NotNull SYDownloadTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        SYDownloadProcessor.l.a().a(task.getDownloadId());
    }

    public final void queryApkDownloadInfo(@Nullable String pkgName, @Nullable String versionName, @Nullable SYDownloadQueryCallback callback) {
        SYDownloadTask sYDownloadTaskA;
        try {
            d9 d9Var = d9.d;
            d9Var.a("main queryApkDownloadInfo pkgName=" + pkgName + ", version=" + versionName);
            d9Var.a("mDownloadProxy=" + this.b);
            String str = pkgName + '_' + versionName;
            if (TextUtils.equals(this.e, str)) {
                d9Var.a("main queryApkDownloadInfo use memory result");
                sYDownloadTaskA = this.d;
            } else {
                sYDownloadTaskA = SYDownloadProcessor.l.a().a(pkgName, versionName);
                this.d = sYDownloadTaskA;
                this.e = str;
            }
            d9Var.a("main queryApkDownloadInfo result=" + sYDownloadTaskA);
            if (callback != null) {
                callback.onQueryResult(sYDownloadTaskA);
            }
        } catch (Throwable unused) {
        }
    }

    @Nullable
    public final SYDownloadTask queryDownloadInfo(@NotNull String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        SYDownloadTask downloadTask = SYDownloadNotifier.INSTANCE.getInstance().getDownloadTask(url);
        return (downloadTask == null || !new File(downloadTask.getFilePath()).exists()) ? SYDownloadProcessor.l.a().b(url) : downloadTask;
    }

    public final void registerDownloadListener(@Nullable String pkgName, @Nullable SYDownloadListenerInner listener) {
        if (TextUtils.isEmpty(pkgName) || listener == null) {
            return;
        }
        SYDownloadNotifier companion = SYDownloadNotifier.INSTANCE.getInstance();
        Intrinsics.checkNotNull(pkgName);
        companion.register(pkgName, listener);
    }

    public final void resumeDownloadApk(@NotNull SYDownloadTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        SYDownloadProcessor.l.a().c(task.getDownloadId());
    }

    public final void startDownload(@NotNull SYDownloadTask task, @Nullable SYDownloadListenerInner listener) {
        Intrinsics.checkNotNullParameter(task, "task");
        d9.d.a("mDownloadProxy=" + this.b);
        SYDownloadProcessor.l.a().b(task);
        if (listener != null) {
            SYDownloadNotifier.INSTANCE.getInstance().register(task.getUrl(), listener);
        }
    }

    public final void startDownloadApk(@NotNull SYDownloadTask task, @Nullable SYDownloadListenerInner listener) {
        Intrinsics.checkNotNullParameter(task, "task");
        d9.d.a("startDownloadApk task=" + task + ", mDownloadProxy=" + this.b);
        SYDownloadProcessor.l.a().b(task);
        if (listener != null) {
            SYDownloadNotifier.INSTANCE.getInstance().register(task.getAppPkgName(), listener);
        }
    }

    public final void tryUpdatePreQueryInfo(@NotNull SYDownloadTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (TextUtils.equals(task.getAppPkgName() + '_' + task.getAppVersion(), this.e)) {
            this.d = task;
        }
    }

    public final void unRegisterDownloadListener(@Nullable String pkgName, @Nullable SYDownloadListenerInner listener) {
        if (TextUtils.isEmpty(pkgName) || listener == null) {
            return;
        }
        SYDownloadNotifier companion = SYDownloadNotifier.INSTANCE.getInstance();
        Intrinsics.checkNotNull(pkgName);
        companion.unRegister(pkgName, listener);
    }

    public /* synthetic */ SYDownloadManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
