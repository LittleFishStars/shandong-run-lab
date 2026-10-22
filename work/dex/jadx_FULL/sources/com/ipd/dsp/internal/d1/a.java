package com.ipd.dsp.internal.d1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.byazt.tk.AdBaseConstants;
import com.ipd.dsp.Dsp;
import com.ipd.dsp.internal.c2.f;
import com.ipd.dsp.internal.c2.k;
import com.ipd.dsp.internal.c2.r;
import com.ipd.dsp.internal.j1.b;
import com.ipd.dsp.open.IPDFileProvider;
import java.io.File;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a {
    public static void a(@NonNull Context context, b bVar, File file) {
        com.ipd.dsp.internal.h1.a.a(bVar, com.ipd.dsp.internal.h1.a.e.i);
        try {
            a(context, file);
        } catch (Throwable unused) {
            Activity activityB = f.a().b();
            if (activityB == null || activityB.isFinishing()) {
                return;
            }
            Toast.makeText(activityB, "请同意安装应用权限", 0).show();
            try {
                Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + context.getPackageName()));
                intent.setFlags(268435456);
                activityB.startActivity(intent);
            } catch (Throwable unused2) {
            }
        }
    }

    public static void a(@NonNull Context context, File file) {
        Uri uri = IPDFileProvider.getUri(file);
        if (uri != null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435459);
            intent.addFlags(1);
            intent.setDataAndType(uri, AdBaseConstants.MIME_APK);
            try {
                Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 65536).iterator();
                while (it.hasNext()) {
                    context.grantUriPermission(it.next().activityInfo.packageName, uri, 3);
                }
                context.startActivity(intent);
                return;
            } catch (Throwable th) {
                r.a(th);
                return;
            }
        }
        if (Dsp.isDebugLogEnable()) {
            k.a("AIH", "install error, apk file uri is null");
        }
    }

    public static boolean a(@NonNull Context context) {
        return context.getPackageManager().canRequestPackageInstalls();
    }
}
