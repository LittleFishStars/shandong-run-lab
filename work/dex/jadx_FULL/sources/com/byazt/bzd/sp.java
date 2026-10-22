package com.byazt.bzd;

import android.content.Context;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.byazt.omf.rh;
import com.byazt.ukr.yp;
import com.kwad.sdk.collector.AppStatusRules;
import dalvik.system.BaseDexClassLoader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 724, 91})
public class sp {
    public static Boolean c = null;
    public static Method tt = null;
    public static boolean ve = c().exists();

    public static File c() {
        return new File(com.byazt.nr.sp.c(gt.getContext(), false, null), ".csj_so");
    }

    private static boolean tt(String str) {
        try {
            if (tt == null) {
                Method declaredMethod = Runtime.class.getDeclaredMethod("nativeLoad", String.class, ClassLoader.class);
                tt = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            BaseDexClassLoader baseDexClassLoader = (BaseDexClassLoader) sp.class.getClassLoader();
            if (tt != null && baseDexClassLoader != null) {
                String strFindLibrary = baseDexClassLoader.findLibrary(str);
                synchronized (sp.class) {
                    tt.invoke(null, strFindLibrary, baseDexClassLoader);
                }
                return true;
            }
        } catch (Throwable th) {
            ve = false;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("lib", str);
                jSONObject.putOpt("msg", "lock load failed!");
            } catch (JSONException unused) {
            }
            yp.c().c("so_load_fail", jSONObject, th);
        }
        return false;
    }

    public static void c(final String str) {
        if (gt.tt().vr() == 1) {
            if (!a.c(str) && gt.tt().ls() == 1) {
                rh.c = false;
                if ("maparmor".equals(str) || "panglearmor".equals(str)) {
                    throw new a.ve("SoVerfailed: ".concat(String.valueOf(str)));
                }
            }
        } else if (gt.tt().vr() == 2) {
            com.byazt.bwm.n.c(new com.byazt.bwm.sp("har") { // from class: com.byazt.bzd.sp.1
                @Override // java.lang.Runnable
                public void run() {
                    a.c(str);
                }
            }, 5000);
        }
        try {
            if (ve && !TextUtils.equals(str, "pangleflipped") && tt(str)) {
                return;
            }
            System.loadLibrary(str);
        } catch (Throwable th) {
            if (!(th instanceof a.ve)) {
                th.printStackTrace();
                c(str, th);
                return;
            }
            throw th;
        }
    }

    public static boolean tt() {
        Boolean bool = c;
        if (bool != null) {
            return bool.booleanValue();
        }
        c = Boolean.FALSE;
        try {
            Context context = gt.getContext();
            if ((context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).applicationInfo.flags & 1) != 0) {
                c = Boolean.TRUE;
            }
        } catch (Exception e) {
            m.tt("SoLoaderUtil", e);
        }
        return c.booleanValue();
    }

    private static boolean c(String str, Throwable th) {
        String strSp = p.sp();
        String str2 = "lib" + str + ".so";
        File file = new File(strSp, "/lib/".concat(String.valueOf(str2)));
        if (file.exists() && file.length() > 0) {
            return c(str, file.getAbsolutePath());
        }
        File file2 = new File(strSp, "apk/base-1.apk");
        if (file2.exists() && file2.length() > 0) {
            c(file2, file, str2);
            File file3 = new File(strSp, "/lib/".concat(String.valueOf(str2)));
            if (file3.exists() && file3.length() > 0) {
                try {
                    System.loadLibrary(str);
                    return true;
                } catch (Throwable unused) {
                    return c(str, file3.getAbsolutePath());
                }
            }
            c(str, str2 + " unzip failed !", th);
            return false;
        }
        c(str, "load so filed! apk not exist! ", th);
        return false;
    }

    private static boolean c(String str, String str2) {
        try {
            System.load(str2);
            return true;
        } catch (Throwable th) {
            new File(str2).delete();
            c(str, "load so " + str + " filed! ", th);
            throw th;
        }
    }

    private static void c(File file, File file2, String str) {
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        try {
            ZipFile zipFile = new ZipFile(file);
            ZipEntry entry = zipFile.getEntry("lib/" + com.byazt.qya.tt.c() + WVNativeCallbackUtil.SEPERATER + str);
            if (entry == null) {
                entry = zipFile.getEntry("lib/armeabi/".concat(String.valueOf(str)));
            }
            if (entry == null) {
                return;
            }
            file2.getParentFile().mkdirs();
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(entry));
                    try {
                        bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                        try {
                            byte[] bArr = new byte[AppStatusRules.UploadConfig.DEFAULT_FILE_MAX_SIZE];
                            while (true) {
                                int i = bufferedInputStream.read(bArr);
                                if (i != -1) {
                                    bufferedOutputStream.write(bArr, 0, i);
                                } else {
                                    com.byazt.as.tt.c(bufferedInputStream);
                                    com.byazt.as.tt.c(bufferedOutputStream);
                                    com.byazt.as.tt.c(fileOutputStream);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            com.byazt.as.tt.c(bufferedInputStream);
                            com.byazt.as.tt.c(bufferedOutputStream);
                            com.byazt.as.tt.c(fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedOutputStream = null;
                    }
                } catch (Throwable th4) {
                    bufferedInputStream = null;
                    th = th4;
                    bufferedOutputStream = null;
                }
            } catch (Throwable th5) {
                bufferedInputStream = null;
                fileOutputStream = null;
                th = th5;
                bufferedOutputStream = null;
            }
        } catch (Throwable th6) {
            m.tt("SoLoaderUtil", th6);
        }
    }

    private static void c(String str, String str2, Throwable th) {
        if ("maparmor".equals(str)) {
            rh.c = false;
        }
        if (tt()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("lib", str);
            jSONObject.putOpt("msg", str2);
        } catch (JSONException unused) {
        }
        yp.c().c("so_load_fail", jSONObject, th);
    }
}
