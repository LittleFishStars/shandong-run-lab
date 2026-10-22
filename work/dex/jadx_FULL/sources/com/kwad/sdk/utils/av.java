package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.byazt.tk.AdBaseConstants;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.kwad.sdk.api.core.fragment.FileProvider;
import java.io.File;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class av {
    @SuppressLint({"UnspecifiedImmutableFlag"})
    public static PendingIntent a(Context context, int i, @NonNull Intent intent) {
        return PendingIntent.getBroadcast(context, i, intent, 201326592);
    }

    @SuppressLint({"UnspecifiedImmutableFlag"})
    private static PendingIntent b(Context context, int i, @NonNull Intent intent) {
        return PendingIntent.getActivity(context, i, intent, 201326592);
    }

    private static Uri c(Context context, File file) {
        return FileProvider.getUriForFile(context, context.getPackageName() + ".adFileProvider", file);
    }

    @Nullable
    public static PendingIntent d(Context context, String str, int i) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        return b(context, i, launchIntentForPackage);
    }

    private static Intent j(Intent intent) {
        Intent intent2 = new Intent("intent.action.requestInstallPermission");
        intent2.putExtra("fromNotification", true);
        intent2.putExtra(BaseGmsClient.i, intent);
        intent2.addFlags(268435456);
        return intent2;
    }

    @SuppressLint({"QueryPermissionsNeeded"})
    public static PendingIntent a(Context context, File file, int i, boolean z) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435459);
        Uri uriC = c(context, file);
        intent.setDataAndType(uriC, AdBaseConstants.MIME_APK);
        Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 65536).iterator();
        while (it.hasNext()) {
            context.grantUriPermission(it.next().activityInfo.packageName, uriC, 3);
        }
        if (z) {
            com.kwad.sdk.c.Ey();
            if (com.kwad.sdk.c.EB()) {
                intent = j(intent);
            }
        }
        return b(context, i, intent);
    }
}
