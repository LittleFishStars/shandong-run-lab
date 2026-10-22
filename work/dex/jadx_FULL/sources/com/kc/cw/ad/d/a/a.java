package com.kc.cw.ad.d.a;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import com.kc.cw.ad.SSAd;
import com.kc.cw.ad.d.a.b.k;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f38772a = true;
    private static String b = "";
    private Application c;
    private String d;
    private String e;

    /* JADX INFO: renamed from: com.kc.cw.ad.d.a.a$a, reason: collision with other inner class name */
    @Keep
    public static class C0982a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final a f38773a = new a();
    }

    private a() {
    }

    public static String a() {
        String str = C0982a.f38773a.e;
        return str == null ? "" : str;
    }

    public static String a(Context context) {
        String str;
        if (Build.VERSION.SDK_INT >= 29) {
            str = "IMEI/MEID not allowed on Android 10+";
        } else {
            if (context == null) {
                return "";
            }
            if (context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
                return d(context);
            }
            str = "android.permission.READ_PHONE_STATE not granted";
        }
        f.a(str);
        return "";
    }

    public static void a(Application application) {
        if (application == null) {
            return;
        }
        a aVar = C0982a.f38773a;
        aVar.c = application;
        a(application, aVar);
    }

    public static void a(Context context, c cVar) {
        try {
            k.a(context).a(cVar);
        } catch (Throwable th) {
            f.a(th);
        }
    }

    private static void a(Context context, String str) {
        if (context == null) {
            return;
        }
        if (Settings.System.canWrite(context)) {
            try {
                Settings.System.putString(context.getContentResolver(), "GUID_uuid", str);
                f.a("Save uuid to system settings: " + str);
                return;
            } catch (Exception e) {
                e = e;
            }
        } else {
            e = "android.permission.WRITE_SETTINGS not granted";
        }
        f.a(e);
    }

    public static String b() {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.BOARD.length() % 10);
        sb.append(Arrays.deepToString(Build.SUPPORTED_ABIS).length() % 10);
        sb.append(Build.DEVICE.length() % 10);
        sb.append(Build.DISPLAY.length() % 10);
        sb.append(Build.HOST.length() % 10);
        sb.append(Build.ID.length() % 10);
        sb.append(Build.MANUFACTURER.length() % 10);
        sb.append(Build.BRAND.length() % 10);
        sb.append(Build.MODEL.length() % 10);
        sb.append(Build.PRODUCT.length() % 10);
        sb.append(Build.BOOTLOADER.length() % 10);
        sb.append(Build.HARDWARE.length() % 10);
        sb.append(Build.TAGS.length() % 10);
        sb.append(Build.TYPE.length() % 10);
        sb.append(Build.USER.length() % 10);
        return sb.toString();
    }

    public static String b(Context context) {
        if (f38772a) {
            f38772a = false;
            if (SSAd.getCustomController() == null || SSAd.getCustomController().isCanUsePhoneState()) {
                String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                b = string;
                if (string == null) {
                    b = "";
                }
            }
        }
        return b;
    }

    private static void b(Context context, String str) {
        if (context == null) {
            return;
        }
        File fileG = g(context);
        if (fileG == null) {
            f.a("UUID file in external storage is null");
            return;
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileG));
            try {
                if (!fileG.exists()) {
                    fileG.createNewFile();
                }
                bufferedWriter.write(str);
                bufferedWriter.flush();
                f.a("Save uuid to external storage: " + str);
                bufferedWriter.close();
            } catch (Throwable th) {
                try {
                    bufferedWriter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception e) {
            f.a(e);
        }
    }

    public static String c(Context context) {
        String strE = e(context);
        if (TextUtils.isEmpty(strE)) {
            strE = f(context);
        }
        if (TextUtils.isEmpty(strE)) {
            strE = h(context);
        }
        if (!TextUtils.isEmpty(strE)) {
            return strE;
        }
        String string = UUID.randomUUID().toString();
        f.a("Generate uuid by random: " + string);
        c(context, string);
        a(context, string);
        b(context, string);
        return string;
    }

    private static void c(Context context, String str) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences("GUID", 0).edit().putString("uuid", str).apply();
        f.a("Save uuid to shared preferences: " + str);
    }

    private static String d(Context context) {
        return "";
    }

    private static String e(Context context) {
        if (context == null) {
            return "";
        }
        String string = Settings.System.getString(context.getContentResolver(), "GUID_uuid");
        f.a("Get uuid from system settings: " + string);
        return string;
    }

    private static String f(Context context) {
        String line = "";
        if (context == null) {
            return "";
        }
        File fileG = g(context);
        if (fileG != null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(fileG));
                try {
                    line = bufferedReader.readLine();
                    bufferedReader.close();
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Exception e) {
                f.a(e);
            }
        }
        f.a("Get uuid from external storage: " + line);
        return line;
    }

    private static File g(Context context) {
        if ((Build.VERSION.SDK_INT < 30 && context != null && context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) && "mounted".equals(Environment.getExternalStorageState())) {
            return new File(Environment.getExternalStorageDirectory(), "Android/.GUID_uuid");
        }
        return null;
    }

    private static String h(Context context) {
        if (context == null) {
            return "";
        }
        String string = context.getSharedPreferences("GUID", 0).getString("uuid", "");
        f.a("Get uuid from shared preferences: " + string);
        return string;
    }

    @Override // com.kc.cw.ad.d.a.c
    public void a(Exception exc) {
        StringBuilder sb;
        String str;
        f.a("onOAIDGetError: " + exc.getMessage());
        String strB = b(this.c);
        if (TextUtils.isEmpty(strB)) {
            String strA = a((Context) this.c);
            if (TextUtils.isEmpty(strA)) {
                String strB2 = b();
                if (TextUtils.isEmpty(strB2)) {
                    this.d = c(this.c);
                    sb = new StringBuilder();
                    str = "Client id is GUID: ";
                } else {
                    this.d = strB2;
                    sb = new StringBuilder();
                    str = "Client id is PseudoID: ";
                }
            } else {
                this.d = strA;
                sb = new StringBuilder();
                str = "Client id is IMEI/MEID: ";
            }
        } else {
            this.d = strB;
            sb = new StringBuilder();
            str = "Client id is AndroidID: ";
        }
        sb.append(str);
        sb.append(this.d);
        f.a(sb.toString());
    }

    @Override // com.kc.cw.ad.d.a.c
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            a(new e("OAID is empty"));
            return;
        }
        this.d = str;
        this.e = str;
        f.a("Client id is OAID: " + this.d);
    }
}
