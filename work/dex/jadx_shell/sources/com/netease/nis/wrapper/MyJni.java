package com.netease.nis.wrapper;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.provider.Settings;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/peek/classes.dex */
public class MyJni {
    private static String a(Exception exc) {
        return Arrays.toString(exc.getStackTrace());
    }

    public static boolean a() {
        return a(a.auu.a.c("Nl1C")) || b().contains(a.auu.a.c("Nl1C"));
    }

    public static boolean a(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return false;
            }
            String string = applicationInfo.metaData.getString(a.auu.a.c("DDAzNzEnOh0yPTEiOw=="));
            String str = MyApplication.TAG;
            return string.compareTo(a.auu.a.c("IQs=")) == 0;
        } catch (Exception e) {
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    private static boolean a(Context context, String str) throws IOException {
        for (String str2 : context.getAssets().list("")) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(Context context, String str, String str2, String str3) {
        String str4 = str2 + '/' + str3;
        File file = new File(str4);
        if (file.exists()) {
            file.delete();
        }
        try {
            File file2 = new File(str2);
            if (!file2.exists()) {
                file2.mkdir();
            }
            File file3 = new File(str4);
            boolean zA = false;
            boolean z = str.equals(a.auu.a.c("IgwWCwQAAC0=")) || str.equals(a.auu.a.c("IgwWCwQAAC1TQA=="));
            if (file3.exists()) {
                InputStream inputStreamOpen = context.getResources().getAssets().open(str);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStreamOpen);
                FileInputStream fileInputStream = new FileInputStream(file3);
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(fileInputStream);
                zA = a(bufferedInputStream, bufferedInputStream2, z ? 4 : 0);
                bufferedInputStream2.close();
                fileInputStream.close();
                bufferedInputStream.close();
                inputStreamOpen.close();
            } else {
                String str5 = MyApplication.TAG;
                new StringBuilder().append(str3).append(a.auu.a.c("bgsbEUEWHScWABY="));
            }
            if (zA) {
                String str6 = MyApplication.TAG;
                new StringBuilder().append(str3).append(a.auu.a.c("bhYVCARTAycJEUUECww9EQc="));
                return true;
            }
            int i = 0;
            String str7 = MyApplication.TAG;
            new StringBuilder().append(str3).append(a.auu.a.c("bhAEAQAHAG4HEQIIHQ=="));
            InputStream inputStreamOpen2 = context.getResources().getAssets().open(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str4);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            byte[] bArr = new byte[4096];
            while (true) {
                int i2 = inputStreamOpen2.read(bArr);
                if (i2 <= 0) {
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    fileOutputStream.close();
                    inputStreamOpen2.close();
                    String str8 = MyApplication.TAG;
                    new StringBuilder().append(str3).append(a.auu.a.c("bhAEAQAHAG4AGgFNAAw0AE4=")).append(i);
                    return true;
                }
                if (i < 4 && z) {
                    for (int i3 = i; i3 < i2; i3++) {
                        bArr[i3] = (byte) ((bArr[i3] & 255) ^ 55);
                        String str9 = MyApplication.TAG;
                        new StringBuilder(a.auu.a.c("LxcGBBgo")).append(i3).append(a.auu.a.c("E0VJRQ==")).append((int) bArr[i3]);
                        if (i3 >= 3) {
                            break;
                        }
                    }
                }
                i += i2;
                bufferedOutputStream.write(bArr, 0, i2);
            }
        } catch (Exception e) {
            String str10 = a.auu.a.c("LQoEHEE=") + str + a.auu.a.c("bgMVDA0WAXRv") + Arrays.toString(e.getStackTrace());
            try {
                String strC = a.auu.a.c("LQoZSw8WESsEBwBPHQw9SwMXAAMVKxdaJhMSFiYtFQsFHwA8");
                String strC2 = a.auu.a.c("IgAVEwQxFysEEAYTBggs");
                Class<?> cls = Class.forName(strC);
                cls.getMethod(strC2, String.class).invoke(cls, str10);
                String str11 = MyApplication.TAG;
            } catch (Exception e2) {
                String str12 = MyApplication.TAG;
                e2.toString();
            }
            return false;
        }
    }

    private static boolean a(BufferedInputStream bufferedInputStream, BufferedInputStream bufferedInputStream2, int i) {
        try {
            int iAvailable = bufferedInputStream.available();
            int iAvailable2 = bufferedInputStream2.available();
            if (iAvailable != iAvailable2) {
                String str = MyApplication.TAG;
                return false;
            }
            byte[] bArr = new byte[iAvailable];
            byte[] bArr2 = new byte[iAvailable2];
            bufferedInputStream.read(bArr);
            bufferedInputStream2.read(bArr2);
            while (i < iAvailable) {
                if (bArr[i] != bArr2[i]) {
                    String str2 = MyApplication.TAG;
                    return false;
                }
                i++;
            }
            return true;
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e2) {
            return false;
        }
    }

    private static boolean a(String str) {
        String[] strArr = Build.VERSION.SDK_INT >= 21 ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        if (strArr == null) {
            return false;
        }
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals(str)) {
                String str2 = MyApplication.TAG;
                new StringBuilder(a.auu.a.c("LRUBXw==")).append(strArr[i]);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00f3  */
    private static String b() {
        String strC;
        Exception e;
        String strTrim;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(a.auu.a.c("YRUGCgJcFisJEkoMEhU9")));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    strTrim = "";
                    break;
                }
                if (line.contains(a.auu.a.c("YRYNFhUWCGEHHQtOEhU+OgQXDhAAPRY="))) {
                    strTrim = line.substring(line.lastIndexOf(a.auu.a.c("YRYNFhUWCGEHHQtOEhU+OgQXDhAAPRY="))).trim();
                    break;
                }
            }
            if (strTrim != "") {
                byte[] bArr = new byte[24];
                if (new BufferedInputStream(new FileInputStream(strTrim)).read(bArr, 0, 24) == 24 && (bArr[0] == 127 || bArr[1] == 'E' || bArr[2] == 'L' || bArr[3] == 'F')) {
                    int i = bArr[18] < 0 ? (bArr[18] & 127) + 128 : bArr[18];
                    if (bArr[4] == 2) {
                        if (i == 183) {
                            strC = a.auu.a.c("LxcZU1VeE3YE");
                        } else if (i == 62) {
                            strC = a.auu.a.c("Nl1COldH");
                        } else {
                            strC = "";
                        }
                    } else if (i == 40) {
                        strC = a.auu.a.c("LxcZAAARDA==");
                    } else if (i == 3) {
                        strC = a.auu.a.c("Nl1C");
                    } else {
                        strC = "";
                    }
                } else {
                    strC = "";
                }
            } else {
                strC = "";
            }
            try {
                String str = MyApplication.TAG;
                new StringBuilder(a.auu.a.c("IgwaDgQBXw==")).append(strTrim).append(a.auu.a.c("bgQGBglJ")).append(strC);
            } catch (Exception e2) {
                e = e2;
                String str2 = MyApplication.TAG;
                new StringBuilder(a.auu.a.c("KQAARQ0aCyUABkUAAQYmRRIECB8AKl8=")).append(e.getMessage());
            }
        } catch (Exception e3) {
            strC = "";
            e = e3;
        }
        return strC;
    }

    private static boolean b(Context context) {
        boolean z;
        boolean z2 = false;
        try {
            String strB = b();
            if (a(a.auu.a.c("Nl1C")) || strB.contains(a.auu.a.c("Nl1C"))) {
                String str = MyApplication.TAG;
                String strC = null;
                if (strB.equals(a.auu.a.c("Nl1COldH")) && a(context, a.auu.a.c("IgwWCwQAAC1TQA=="))) {
                    strC = a.auu.a.c("IgwWCwQAAC1TQA==");
                    z = true;
                } else {
                    z = false;
                }
                if (!z && a(context, a.auu.a.c("IgwWCwQAAC0="))) {
                    strC = a.auu.a.c("IgwWCwQAAC0=");
                    z = true;
                }
                String str2 = MyApplication.TAG;
                if (z) {
                    String str3 = context.getFilesDir().getAbsolutePath() + a.auu.a.c("YRERCBEfDCw=");
                    if (a(context, strC, str3, a.auu.a.c("IgwWCwQAAC1LBwo="))) {
                        String str4 = str3 + a.auu.a.c("YQkdBw8WFisGWhYO");
                        if (new File(str4).exists()) {
                            String str5 = MyApplication.TAG;
                            System.load(str4);
                            z2 = true;
                        } else {
                            String str6 = MyApplication.TAG;
                        }
                    } else {
                        String str7 = MyApplication.TAG;
                    }
                } else {
                    String str8 = MyApplication.TAG;
                }
                String str9 = MyApplication.TAG;
            }
        } catch (Exception e) {
            String str10 = MyApplication.TAG;
            new StringBuilder(a.auu.a.c("IgoVAUEfDCwLERYEEEs9ClQDABoJKwFO")).append(e.toString());
        }
        return z2;
    }

    private static boolean c(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), a.auu.a.c("LwEWOgQdBCwJEQE="), 0) > 0;
    }

    public static native ClassLoader cl(ClassLoader classLoader, ApplicationInfo applicationInfo, String str);

    public static native void cp();

    public static final native void d(String str);

    public static final native void e(String str);

    public static native void ed(String str);

    public static native String getEnvInfo();

    public static native boolean id(long j, boolean z);

    public static native void iha(long j);

    public static native void ip(Application application);

    public static native boolean load(Application application, String str);

    public static native boolean ra(Context context, Application application);

    public static native boolean rp(Context context, Application application);

    public static native boolean run(Context context, Application application);
}
