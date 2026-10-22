package com.byazt.ue;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.webkit.WebView;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.byazt.bwm.sp;
import com.byazt.bzd.x;
import com.byazt.nr.gt;
import com.byazt.nr.m;
import com.byazt.qg.MultiWebview;
import com.byazt.ukr.yp;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileLock;
import java.util.Arrays;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1265, 15})
public class uj {
    public static void c(final Context context) {
        if (context == null) {
            return;
        }
        MultiWebview.uj = new com.byazt.el.c() { // from class: com.byazt.ue.uj.1
            @Override // com.byazt.el.c
            public void c(String str, Throwable th) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("threadName", str);
                    jSONObject.put(AliyunLogCommon.SubModule.RECORD, Arrays.toString(th.getStackTrace()));
                } catch (Exception unused) {
                }
                yp.c().c("webview_init_failed", jSONObject, th);
            }
        };
        com.byazt.yy.ve.c(context.getApplicationContext());
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                if (gt.c(context)) {
                    x.c(new sp("tt_webview_file_path") { // from class: com.byazt.ue.uj.2
                        @Override // java.lang.Runnable
                        public void run() throws Throwable {
                            uj.ve(context);
                        }
                    });
                    return;
                }
                String strTt = gt.tt(context);
                try {
                    if (TextUtils.isEmpty(strTt)) {
                        strTt = context.getPackageName() + Process.myPid();
                    }
                    WebView.setDataDirectorySuffix(strTt);
                } catch (IllegalStateException unused) {
                    c(strTt);
                } catch (Exception unused2) {
                }
            }
        } catch (Throwable th) {
            m.ve(th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ve(Context context) throws Throwable {
        RandomAccessFile randomAccessFile;
        Throwable th;
        String strC = c();
        File file = new File(com.byazt.nys.tt.c(context, TextUtils.isEmpty(strC) ? "webview" : "webview_".concat(String.valueOf(strC)), 0).getPath(), "webview_data.lock");
        m.c("TTMultiInitHelper", file.getAbsolutePath());
        if (!file.exists()) {
            return;
        }
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
                try {
                    FileLock fileLockTryLock = randomAccessFile.getChannel().tryLock();
                    if (fileLockTryLock != null) {
                        fileLockTryLock.close();
                    } else {
                        c(file, file.delete());
                    }
                    com.byazt.as.tt.c(randomAccessFile);
                } catch (Exception unused) {
                    randomAccessFile2 = randomAccessFile;
                    c(file, file.exists() ? file.delete() : false);
                    com.byazt.as.tt.c(randomAccessFile2);
                } catch (Throwable th2) {
                    th = th2;
                    com.byazt.as.tt.c(randomAccessFile);
                    throw th;
                }
            } catch (Exception unused2) {
            }
        } catch (Throwable th3) {
            randomAccessFile = randomAccessFile2;
            th = th3;
        }
    }

    private static void c(String str) {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            declaredMethod2.setAccessible(true);
            Class cls = (Class) declaredMethod.invoke(null, "android.webkit.WebViewFactory");
            Field field = (Field) declaredMethod2.invoke(cls, "sDataDirectorySuffix");
            field.setAccessible(true);
            if (TextUtils.isEmpty((String) field.get(cls))) {
                field.set(cls, str);
            }
        } catch (Throwable unused) {
        }
    }

    private static void c(File file, boolean z) {
        if (!z || file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            m.c(e);
        }
    }

    private static String c() {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            declaredMethod2.setAccessible(true);
            Class cls = (Class) declaredMethod.invoke(null, "android.webkit.WebViewFactory");
            return (String) ((Field) declaredMethod2.invoke(cls, "sDataDirectorySuffix")).get(cls);
        } catch (Throwable unused) {
            return null;
        }
    }
}
