package cj.mobile.wm;

import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ke {
    public static String dexa(String str) {
        String strDexb = dexb(str);
        return (!TextUtils.isEmpty(strDexb) && str.startsWith(strDexb) && strDexb.endsWith(".apk")) ? strDexb : str;
    }

    public static String dexb(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Uri uri = Uri.parse(str);
        if (TextUtils.isEmpty(uri.getScheme())) {
            str2 = "";
        } else {
            str2 = uri.getScheme() + "://";
        }
        return str2 + (str.contains(uri.getEncodedAuthority()) ? uri.getEncodedAuthority() : uri.getAuthority()) + (str.contains(uri.getEncodedPath()) ? uri.getEncodedPath() : uri.getPath());
    }
}
