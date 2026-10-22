package com.fl.saas;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.byazt.tk.AdBaseConstants;
import java.io.File;
import java.io.IOException;

/* JADX INFO: renamed from: com.fl.saas.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class AbstractC1419l {
    public static Intent a(Context context, File file) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".update.provider", file);
        intent.addFlags(1);
        intent.setDataAndType(uriForFile, AdBaseConstants.MIME_APK);
        return intent;
    }

    private static Uri a(File file) {
        try {
            new ProcessBuilder("chmod", "777", file.toString()).start();
        } catch (IOException unused) {
        }
        return Uri.fromFile(file);
    }

    public static void a(Context context, File file, C1415j c1415j) {
        context.startActivity(a(context, file));
        if (c1415j != null) {
            C1435t.a().a(c1415j, 6);
        }
    }
}
