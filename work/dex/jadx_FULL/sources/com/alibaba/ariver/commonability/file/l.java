package com.alibaba.ariver.commonability.file;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.io.File;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24035a = "TinyAppFileUtils";

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("../") || str.endsWith("/..") || str.contains("/../");
    }

    public static boolean a(File file, String str) {
        if (file == null || !file.exists()) {
            return false;
        }
        try {
            String canonicalPath = file.getCanonicalPath();
            if (TextUtils.equals(canonicalPath, WVNativeCallbackUtil.SEPERATER)) {
                return false;
            }
            try {
                String absolutePath = file.getAbsolutePath();
                if (TextUtils.equals(absolutePath, WVNativeCallbackUtil.SEPERATER)) {
                    return false;
                }
                if (!TextUtils.isEmpty(str)) {
                    try {
                        if (!absolutePath.startsWith(str) && !canonicalPath.startsWith(str)) {
                            return false;
                        }
                    } catch (Exception e) {
                        RVLogger.e(f24035a, e);
                    }
                }
                return file.delete();
            } catch (Exception e2) {
                RVLogger.e(f24035a, e2);
                return false;
            }
        } catch (Exception e3) {
            RVLogger.e(f24035a, e3);
            return false;
        }
    }

    public static void a(FileLock fileLock) {
        if (fileLock != null) {
            try {
                fileLock.release();
            } catch (Exception e) {
                RVLogger.e(f24035a, e);
            }
        }
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.endsWith(WVNativeCallbackUtil.SEPERATER)) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (TextUtils.isEmpty(str2)) {
                return str + file.getName();
            }
            String strSubstring = str2.substring(str2.lastIndexOf(WVNativeCallbackUtil.SEPERATER) + 1);
            if (TextUtils.isEmpty(strSubstring)) {
                return str + file.getName();
            }
            return str + strSubstring;
        }
        File parentFile = new File(str).getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        return str;
    }
}
