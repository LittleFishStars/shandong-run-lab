package com.alibaba.ariver.commonability.file.fs;

import android.content.Context;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.alibaba.ariver.commonability.file.a;
import com.alibaba.ariver.commonability.file.c;
import com.alibaba.ariver.commonability.file.h;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class ConversionPathTool {
    public static final String PATH_PREFIX = "https://usr/";
    public static final String PATH_ROOT = "https://usr";
    public static final int PATH_ROOT_LENGTH = 11;
    private static final String TAG = "ConversionPathTool";

    public static String localPathToUsrPath(String str, ApiContext apiContext) {
        if (apiContext == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String strA = a.a(apiContext);
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        String strA2 = a.a();
        if (TextUtils.isEmpty(strA2)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("usr/");
        sb.append(h.a(strA + strA2));
        String strA3 = c.a(apiContext.getAppContext(), sb.toString());
        if (TextUtils.isEmpty(strA3)) {
            return null;
        }
        if (str.equals(strA3)) {
            return "https://usr";
        }
        if (!str.startsWith(strA3 + WVNativeCallbackUtil.SEPERATER)) {
            return null;
        }
        return "https://usr" + str.substring(strA3.length());
    }

    public static String usrPathToLocalPath(String str, ApiContext apiContext) {
        int length;
        int i;
        if (TextUtils.isEmpty(str) || (length = str.length()) < (i = PATH_ROOT_LENGTH)) {
            return null;
        }
        if (length == i) {
            if (!str.equals("https://usr")) {
                return null;
            }
        } else if (!str.startsWith("https://usr/")) {
            return null;
        }
        if (apiContext == null) {
            return null;
        }
        String strA = a.a(apiContext);
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        String strA2 = a.a();
        if (TextUtils.isEmpty(strA2)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("usr/");
        sb.append(h.a(strA + strA2));
        String strA3 = c.a(apiContext.getAppContext(), sb.toString());
        if (TextUtils.isEmpty(strA3)) {
            return null;
        }
        File file = new File(strA3);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (length == i) {
            return strA3;
        }
        String str2 = strA3 + str.substring(i);
        RVLogger.d(TAG, str2);
        return str2;
    }

    public static String usrPathToLocalPath(String str, Context context, String str2) {
        int length;
        int i;
        if (TextUtils.isEmpty(str) || (length = str.length()) < (i = PATH_ROOT_LENGTH)) {
            return null;
        }
        if (length == i) {
            if (!str.equals("https://usr")) {
                return null;
            }
        } else if (!str.startsWith("https://usr/")) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        String strA = a.a();
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("usr/");
        sb.append(h.a(str2 + strA));
        String strA2 = c.a(context, sb.toString());
        if (TextUtils.isEmpty(strA2)) {
            return null;
        }
        File file = new File(strA2);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (length == i) {
            return strA2;
        }
        String str3 = strA2 + str.substring(i);
        RVLogger.d(TAG, str3);
        return str3;
    }
}
