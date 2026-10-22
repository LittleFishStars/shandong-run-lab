package com.fl.saas.s2s.sdk.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.byazt.tk.AdBaseConstants;
import com.fl.saas.s2s.sdk.helper.AdInfoPoJo;
import com.fl.saas.s2s.sdk.helper.CommClickHelper;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ApkUtils {
    public static Intent getApkInStallIntent(Context context, File file) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".update.provider", file);
        intent.addFlags(1);
        intent.setDataAndType(uriForFile, AdBaseConstants.MIME_APK);
        return intent;
    }

    private static Uri getApkUri(File file) {
        try {
            new ProcessBuilder("chmod", "777", file.toString()).start();
        } catch (IOException unused) {
        }
        return Uri.fromFile(file);
    }

    public static void installAPk(Context context, File file, AdInfoPoJo adInfoPoJo) {
        context.startActivity(getApkInStallIntent(context, file));
        if (adInfoPoJo != null) {
            CommClickHelper.getInstance().report(context, adInfoPoJo, 6);
        }
    }
}
