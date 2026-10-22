package com.alibaba.ariver.commonability.file;

import android.net.Uri;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f24023a = "image";
    public static final String b = "video";
    public static final String c = "audio";
    public static final String d = "other";
    public static final String e = "https://resource/";

    public static String a(String str, String str2) {
        return e + str + Consts.DOT + str2;
    }

    public static String a(String str) {
        Uri uriB;
        String[] strArrSplit;
        if (!TextUtils.isEmpty(str) && str.startsWith(e) && ((str.endsWith("image") || str.endsWith("video") || str.endsWith("audio") || str.endsWith("other")) && (uriB = i.b(str)) != null && !TextUtils.isEmpty(uriB.getPath()) && (strArrSplit = uriB.getPath().replace(WVNativeCallbackUtil.SEPERATER, "").split("\\.")) != null && strArrSplit.length > 1)) {
            String str2 = strArrSplit[0];
            try {
                if (!TextUtils.isEmpty(str2)) {
                    return com.alibaba.ariver.commonability.file.proxy.b.a().b(str2);
                }
            } catch (Exception e2) {
                RVLogger.e("", e2);
            }
        }
        return str;
    }
}
