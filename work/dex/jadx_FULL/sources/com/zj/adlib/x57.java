package com.zj.adlib;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.net.URLDecoder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class x57 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f45748a = "QuickAppUtil";

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("hap://") || str.contains("hnquickapp://") || str.contains("hwfastapp://");
    }

    public static boolean b(Intent intent) {
        if (intent == null || intent.getData() == null) {
            return false;
        }
        String scheme = intent.getScheme();
        if (!TextUtils.isEmpty(scheme) && (scheme.startsWith("hap") || scheme.startsWith("hnquickapp") || scheme.startsWith("hwfastapp"))) {
            return true;
        }
        Uri data = intent.getData();
        if (data != null) {
            String host = data.getHost();
            if (!TextUtils.isEmpty(scheme) && ((scheme.startsWith("http") || scheme.startsWith("intent")) && !TextUtils.isEmpty(host) && host.startsWith("hapjs.org"))) {
                return true;
            }
            String query = data.getQuery();
            if (!TextUtils.isEmpty(scheme) && ((scheme.startsWith("hiapp") || scheme.startsWith("higame")) && !TextUtils.isEmpty(query) && query.contains("params="))) {
                try {
                    if (a(URLDecoder.decode(query, "UTF-8"))) {
                        return true;
                    }
                } catch (Exception e) {
                    Log.e(f45748a, e.getMessage());
                }
            }
        }
        return false;
    }
}
