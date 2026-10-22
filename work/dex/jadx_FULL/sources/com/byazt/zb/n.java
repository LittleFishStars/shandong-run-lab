package com.byazt.zb;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import com.ali.auth.third.login.LoginConstants;
import com.byazt.nr.m;
import com.hjq.permissions.Permission;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 184, 46})
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f29233a = 0;
    public static String c = "images";
    public static int da = 8;
    public static int i = 4;
    public static long n = 15360;
    public static int sl = 16;
    public static int sp = 1;
    public static int t = 32;
    public static String tt = null;
    public static int uj = 30;
    public static int ve = 1;
    public static int x = 2;

    public static boolean c(Context context, String str) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr.length > 0) {
                for (String str2 : strArr) {
                    if (str.equals(str2)) {
                        return true;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static Bitmap tt(String str) {
        byte[] bArrDecode = Base64.decode(str, 2);
        return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
    }

    @RequiresApi(api = 23)
    public static boolean tt(Context context, String str) {
        return context.checkSelfPermission(str) == 0;
    }

    public static File c() {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), Environment.DIRECTORY_DCIM + File.separator + c);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "JPG_Playable_Photo.jpg");
            if (!file2.exists()) {
                file2.createNewFile();
            }
            tt = file2.getAbsolutePath();
            return file2;
        } catch (IOException unused) {
            return null;
        }
    }

    public static File c(String str) {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), Environment.DIRECTORY_DCIM + File.separator + "Camera");
            if (!file.exists()) {
                file.mkdirs();
            }
            Calendar calendar = Calendar.getInstance();
            File file2 = new File(file, (calendar.get(12) + LoginConstants.UNDER_LINE + calendar.get(13) + LoginConstants.UNDER_LINE + calendar.get(14)) + LoginConstants.UNDER_LINE + str);
            if (!file2.exists()) {
                file2.createNewFile();
            }
            return file2;
        } catch (IOException unused) {
            return null;
        }
    }

    public static File c(String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            File fileC = c(str);
            if (fileC != null && fileC.exists()) {
                byte[] bArrDecode = Base64.decode(str2, 2);
                fileOutputStream = new FileOutputStream(fileC);
                try {
                    fileOutputStream.write(bArrDecode, 0, bArrDecode.length);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        m.c(e);
                    }
                    return fileC;
                } catch (IOException unused) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e2) {
                            m.c(e2);
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e3) {
                            m.c(e3);
                        }
                    }
                    throw th;
                }
            }
            return null;
        } catch (IOException unused2) {
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean c(Context context, int i2) {
        boolean zC;
        boolean zC2;
        if (f29233a == 0) {
            if (Build.VERSION.SDK_INT >= 33) {
                zC = c(context, Permission.READ_MEDIA_IMAGES);
                zC2 = true;
            } else {
                zC = c(context, "android.permission.READ_EXTERNAL_STORAGE");
                zC2 = c(context, "android.permission.WRITE_EXTERNAL_STORAGE");
            }
            boolean zC3 = c(context, Permission.CAMERA);
            boolean zC4 = c(context, Permission.RECORD_AUDIO);
            PackageManager packageManager = context.getPackageManager();
            if (zC && zC2) {
                f29233a |= sp;
            }
            if (zC3 && packageManager.hasSystemFeature("android.hardware.camera")) {
                f29233a |= x;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.gyroscope")) {
                f29233a |= i;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.accelerometer")) {
                f29233a |= da;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.compass")) {
                f29233a |= sl;
            }
            if (zC4 && packageManager.hasSystemFeature("android.hardware.microphone")) {
                f29233a |= t;
            }
        }
        return (f29233a & i2) != 0;
    }

    @RequiresApi(api = 23)
    public static boolean c(Context context) {
        boolean z;
        boolean z2;
        if (Build.VERSION.SDK_INT >= 33) {
            z = context.checkSelfPermission(Permission.READ_MEDIA_IMAGES) == 0;
        } else {
            z = context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0;
            if (context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                z2 = false;
            }
            return !z2 && z;
        }
        z2 = true;
        if (z2) {
        }
    }
}
