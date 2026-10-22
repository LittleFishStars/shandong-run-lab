package com.zj.adlib;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.col.p0003l.fh;
import com.amap.api.col.p0003l.it;
import com.amap.api.col.p0003l.z;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class j4b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f42508a = "";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f17326a = false;
    public static String b = "";
    public static String c = "";
    public static String d = "";
    public static String e;

    public static class a extends it {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f42509a;
        public final /* synthetic */ String f;

        public a(Context context, String str) {
            this.f42509a = context;
            this.f = str;
        }

        @Override // com.amap.api.col.p0003l.it
        public final void runTask() {
            FileOutputStream fileOutputStream = null;
            try {
                File file = new File(y6b.i(this.f42509a, "k.store"));
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(s4b.p(this.f));
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    try {
                        v6b.b(th, "AI", "stf");
                    } finally {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th3) {
                                th3.printStackTrace();
                            }
                        }
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    public static String a(Context context) {
        try {
            return l(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return d;
        }
    }

    public static void b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d = str;
        if (context != null) {
            z.g().b(new a(context, str));
        }
    }

    public static void c(String str) {
        b = str;
    }

    public static boolean d() {
        try {
            if (f17326a) {
                return true;
            }
            if (f(e)) {
                f17326a = true;
                return true;
            }
            if (!TextUtils.isEmpty(e)) {
                f17326a = false;
                e = null;
                return false;
            }
            if (f(b)) {
                f17326a = true;
                return true;
            }
            if (!TextUtils.isEmpty(b)) {
                f17326a = false;
                b = null;
                return false;
            }
            return true;
        } catch (Throwable unused) {
        }
    }

    public static String e(Context context) {
        try {
            if (!"".equals(f42508a)) {
                return f42508a;
            }
            PackageManager packageManager = context.getPackageManager();
            f42508a = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
            return f42508a;
        } catch (Throwable th) {
            v6b.b(th, "AI", "gAN");
        }
    }

    public static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.toCharArray();
        for (char c2 : str.toCharArray()) {
            if (('A' > c2 || c2 > 'z') && (('0' > c2 || c2 > ':') && c2 != '.')) {
                try {
                    a7b.l(s4b.a(), str, "errorPackage");
                } catch (Throwable unused) {
                }
                return false;
            }
        }
        return true;
    }

    public static String g(Context context) {
        try {
            String str = b;
            if (str != null && !"".equals(str)) {
                return b;
            }
            String packageName = context.getPackageName();
            b = packageName;
            if (!f(packageName)) {
                b = context.getPackageName();
            }
            return b;
        } catch (Throwable th) {
            v6b.b(th, "AI", "gpck");
        }
    }

    public static String h(Context context) {
        try {
            if (!"".equals(c)) {
                return c;
            }
            c = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            String str = c;
            return str == null ? "" : str;
        } catch (Throwable th) {
            v6b.b(th, "AI", "gAV");
        }
    }

    public static String i(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            byte[] bArrDigest = MessageDigest.getInstance(s4b.v("IU0hBMQ")).digest(packageInfo.signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : bArrDigest) {
                String upperCase = Integer.toHexString(b2 & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                stringBuffer.append(u15.f19942b);
            }
            String strG = packageInfo.packageName;
            if (f(strG)) {
                strG = packageInfo.packageName;
            }
            if (!TextUtils.isEmpty(b)) {
                strG = g(context);
            }
            stringBuffer.append(strG);
            String string = stringBuffer.toString();
            e = string;
            return string;
        } catch (Throwable th) {
            v6b.b(th, "AI", "gsp");
            return e;
        }
    }

    public static String j(Context context) {
        try {
            fh.g(context);
        } catch (Throwable unused) {
        }
        try {
            return l(context);
        } catch (Throwable th) {
            v6b.b(th, "AI", "gKy");
            return d;
        }
    }

    public static String k(Context context) {
        FileInputStream fileInputStream;
        Throwable th;
        File file = new File(y6b.i(context, "k.store"));
        if (!file.exists()) {
            return "";
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String strG = s4b.g(bArr);
                String str = strG.length() == 32 ? strG : "";
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                return str;
            } catch (Throwable th3) {
                th = th3;
                try {
                    v6b.b(th, "AI", "gKe");
                    try {
                        if (file.exists()) {
                            file.delete();
                        }
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                    return "";
                } catch (Throwable th6) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th7) {
                            th7.printStackTrace();
                        }
                    }
                    throw th6;
                }
            }
        } catch (Throwable th8) {
            fileInputStream = null;
            th = th8;
        }
    }

    public static String l(Context context) throws PackageManager.NameNotFoundException {
        Bundle bundle;
        String str = d;
        if (str == null || str.equals("")) {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return d;
            }
            String string = bundle.getString("com.amap.api.v2.apikey");
            d = string;
            if (string == null) {
                d = k(context);
            }
        }
        return d;
    }
}
