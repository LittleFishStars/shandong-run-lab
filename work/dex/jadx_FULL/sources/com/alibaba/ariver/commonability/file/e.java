package com.alibaba.ariver.commonability.file;

import android.content.Context;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.io.File;
import java.security.MessageDigest;
import java.util.Stack;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f24015a = "FileCache";
    public static final long b = 604800000;
    private String c;

    public e(Context context) {
        b(context);
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i = 0; i < charArray.length; i++) {
                bArr[i] = (byte) charArray[i];
            }
            byte[] bArrDigest = messageDigest.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : bArrDigest) {
                int i2 = b2 & 255;
                if (i2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i2));
            }
            return stringBuffer.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public String b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = h.b(str) + Consts.DOT + f.l(str);
        String str3 = "/h5/download/temp/";
        if (!TextUtils.isEmpty(this.c)) {
            str3 = "/h5/download/temp/" + this.c + WVNativeCallbackUtil.SEPERATER;
        }
        String strA = c.a(context, str3 + str2);
        if (!f.e(strA)) {
            f.a(strA);
        }
        return strA;
    }

    public void c(Context context) {
        String strA;
        if (TextUtils.isEmpty(this.c)) {
            strA = c.a(context, "/h5/download/temp");
        } else {
            strA = c.a(context, "/h5/download/temp/" + this.c);
        }
        f.a(new File(strA));
    }

    public e(final Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            this.c = str + WVNativeCallbackUtil.SEPERATER + a(str2);
        } else {
            this.c = str;
        }
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.IO).execute(new Runnable() { // from class: com.alibaba.ariver.commonability.file.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.b(context);
            }
        });
    }

    private void c(String str) {
        File[] fileArrListFiles;
        if (f.e(str)) {
            Stack stack = new Stack();
            stack.push(str);
            long jCurrentTimeMillis = System.currentTimeMillis();
            while (!stack.isEmpty()) {
                File file = new File((String) stack.pop());
                if (jCurrentTimeMillis - file.lastModified() > 604800000) {
                    f.a(file);
                } else if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length != 0) {
                    for (File file2 : fileArrListFiles) {
                        stack.push(file2.getAbsolutePath());
                    }
                }
            }
        }
    }

    public void b(Context context) {
        String strA;
        String strA2;
        if (context == null) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(this.c)) {
                strA = c.a(context, "/h5/download/temp/" + this.c);
            } else {
                strA = c.a(context, "/h5/download/temp");
            }
            if (f.e(strA)) {
                c(strA);
            }
            if (!TextUtils.isEmpty(this.c)) {
                strA2 = c.a(context, "/h5/download/cache/" + this.c);
            } else {
                strA2 = c.a(context, "/h5/download/cache");
            }
            if (f.e(strA2)) {
                c(strA2);
            }
        } catch (Exception e) {
            RVLogger.e(f24015a, e);
        }
    }

    public String a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = h.b(str) + Consts.DOT + f.l(str);
        String str3 = "/h5/download/cache/";
        if (!TextUtils.isEmpty(this.c)) {
            str3 = "/h5/download/cache/" + this.c + WVNativeCallbackUtil.SEPERATER;
        }
        return c.a(context, str3 + str2);
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("/h5/download/temp") || str.contains("/h5/download/cache");
    }

    public String a(Context context) {
        String str = "/h5/download/cache/";
        if (!TextUtils.isEmpty(this.c)) {
            str = "/h5/download/cache/" + this.c + WVNativeCallbackUtil.SEPERATER;
        }
        return c.a(context, str);
    }

    public String a(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str3 = h.b(str) + Consts.DOT + str2;
        String str4 = "/h5/download/temp/";
        if (!TextUtils.isEmpty(this.c)) {
            str4 = "/h5/download/temp/" + this.c + WVNativeCallbackUtil.SEPERATER;
        }
        String strA = c.a(context, str4 + str3);
        if (!f.e(strA)) {
            f.a(strA);
        }
        return strA;
    }

    public String a() {
        return this.c;
    }
}
