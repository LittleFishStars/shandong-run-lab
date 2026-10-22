package com.alibaba.ariver.commonability.file;

import android.content.Context;
import android.os.Environment;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f24013a = "DiskUtil";

    public static String a(Context context) {
        File filesDir = context.getFilesDir();
        if (FileUtils.exists(filesDir)) {
            return filesDir.getParent();
        }
        return null;
    }

    public static String a(Context context, String str) {
        String strA = a(context);
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        return strA + WVNativeCallbackUtil.SEPERATER + str;
    }

    public static boolean a() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Throwable th) {
            RVLogger.e(f24013a, th);
            return false;
        }
    }
}
