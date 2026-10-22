package com.ltmb.ltadsdk.core.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.ltmb.ltadsdk.pkg.d9;
import com.ltmb.ltadsdk.pkg.u6;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ltmb/ltadsdk/core/download/SYDownloadReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "a", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public final class SYDownloadReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion();

    /* JADX INFO: renamed from: com.ltmb.ltadsdk.core.download.SYDownloadReceiver$a, reason: from kotlin metadata */
    public static final class Companion {
        @NotNull
        public final String a() {
            Context contextA = u6.n.a();
            if (contextA == null) {
                return "com.ltmb.ltadsdk.download.PRIVATE_BROADCAST_PERMISSION";
            }
            return contextA.getPackageName() + ".download.PRIVATE_BROADCAST_PERMISSION";
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        if (intent != null) {
            d9.d.a("action=" + intent.getAction());
            if (TextUtils.equals("com.ltmb.ltadsdk.download.notify_progress", intent.getAction())) {
                SYDownloadNotifier.INSTANCE.getInstance().updateDownloadProgress(Build.VERSION.SDK_INT >= 33 ? (SYDownloadTask) intent.getParcelableExtra("downloadTask", SYDownloadTask.class) : (SYDownloadTask) intent.getParcelableExtra("downloadTask"), intent.getLongExtra("totalBytes", 0L), intent.getLongExtra("downloadedBytes", 0L));
                return;
            }
            if (TextUtils.equals("com.ltmb.ltadsdk.download.notify_status", intent.getAction())) {
                SYDownloadNotifier.INSTANCE.getInstance().updateDownloadStatus(Build.VERSION.SDK_INT >= 33 ? (SYDownloadTask) intent.getParcelableExtra("downloadTask", SYDownloadTask.class) : (SYDownloadTask) intent.getParcelableExtra("downloadTask"), intent.getIntExtra("status", 0));
                return;
            }
            if (!TextUtils.equals("com.ltmb.ltadsdk.download.will_install_pkg", intent.getAction())) {
                if (TextUtils.equals("com.ltmb.ltadsdk.download.notify_fail", intent.getAction())) {
                    SYDownloadNotifier.INSTANCE.getInstance().downloadFail(Build.VERSION.SDK_INT >= 33 ? (SYDownloadTask) intent.getParcelableExtra("downloadTask", SYDownloadTask.class) : (SYDownloadTask) intent.getParcelableExtra("downloadTask"), intent.getIntExtra("errorCode", 0), intent.getStringExtra("errorMsg"));
                    return;
                }
                return;
            }
            String stringExtra = intent.getStringExtra("installed_pkg");
            String stringExtra2 = intent.getStringExtra("requestId");
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            Intrinsics.checkNotNullExpressionValue(stringExtra2, "intent.getStringExtra(SY…ier.KEY_REQUEST_ID) ?: \"\"");
            if (stringExtra != null) {
                SYDownloadNotifier.INSTANCE.getInstance().onAppInstalled(stringExtra, stringExtra2);
            }
        }
    }
}
