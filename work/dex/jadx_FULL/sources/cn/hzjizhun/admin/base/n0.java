package cn.hzjizhun.admin.base;

import android.content.Context;
import android.content.pm.PackageManager;
import cn.hzjizhun.admin.base.ad.RcSdk;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile int f22704a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final /* synthetic */ boolean f284a = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String[] f285a = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
    public static final String[] b = {"com.noshufou.android.su", "com.noshufou.android.su.elite", "eu.chainfire.supersu", "com.koushikdutta.superuser", "com.thirdparty.superuser", "com.yellowes.su"};
    public static final String[] c = {"com.koushikdutta.rommanager", "com.dimonvideo.luckypatcher", "com.chelpus.lackypatch", "com.ramdroid.appquarantine"};
    public static final String[] d = {"com.devadvance.rootcloak", "de.robv.android.xposed.installer", "com.saurik.substrate", "com.devadvance.rootcloakplus", "com.zachspong.temprootremovejb", "com.amphoras.hidemyroot", "com.formyhm.hideroot"};
    public static final String[] e = {"/system", "/system/bin", "/system/sbin", "/system/xbin", "/vendor/bin", "/sbin", "/etc"};

    static {
        new HashMap();
    }

    public static String a(String str) {
        InputStream inputStream;
        try {
            inputStream = Runtime.getRuntime().exec("getprop ".concat(str)).getInputStream();
        } catch (Throwable th) {
            th.toString();
            inputStream = null;
        }
        if (inputStream == null) {
            return null;
        }
        try {
            return new Scanner(inputStream).useDelimiter("\\A").next();
        } catch (Throwable th2) {
            th2.toString();
            return "";
        }
    }

    public static ArrayList b() {
        InputStream inputStream;
        String next;
        String[] strArrSplit = null;
        try {
            inputStream = Runtime.getRuntime().exec("mount").getInputStream();
        } catch (Throwable th) {
            th.toString();
            inputStream = null;
        }
        if (inputStream != null) {
            try {
                next = new Scanner(inputStream).useDelimiter("\\A").next();
            } catch (NoSuchElementException e2) {
                e2.toString();
                next = "";
            }
            strArrSplit = next.split("\n");
        }
        ArrayList arrayList = new ArrayList();
        if (!f284a && strArrSplit == null) {
            throw new AssertionError();
        }
        for (String str : strArrSplit) {
            String[] strArrSplit2 = str.split(" ");
            if (strArrSplit2.length >= 4) {
                String str2 = strArrSplit2[1];
                String str3 = strArrSplit2[3];
                String[] strArr = e;
                for (int i = 0; i < 7; i++) {
                    String str4 = strArr[i];
                    if (str2.equalsIgnoreCase(str4)) {
                        for (String str5 : str3.split(",")) {
                            if ("rw".equalsIgnoreCase(str5)) {
                                arrayList.add(str4);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static ArrayList c(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            ArrayList<String> arrayList2 = new ArrayList();
            arrayList2.addAll(Arrays.asList(b));
            arrayList2.addAll(Arrays.asList(c));
            arrayList2.addAll(Arrays.asList(d));
            PackageManager packageManager = context.getPackageManager();
            for (String str : arrayList2) {
                try {
                    packageManager.getPackageInfo(str, 0);
                    arrayList.add(str);
                } catch (Throwable th) {
                    th.toString();
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    public static boolean d() {
        try {
            ?? r3 = 1;
            r3 = 1;
            r3 = 1;
            r3 = 1;
            if (f22704a != -1) {
                return f22704a == 1;
            }
            if (b().size() <= 0 && c(RcSdk.e()).size() <= 0) {
                ArrayList arrayList = new ArrayList();
                try {
                    String strA = a("ro.debuggable");
                    String strA2 = a("ro.secure");
                    if (strA != null && strA.contains("1")) {
                        arrayList.add(strA);
                    }
                    if (strA2 != null && strA2.contains("0")) {
                        arrayList.add(strA2);
                    }
                } catch (Throwable unused) {
                }
                if (arrayList.size() <= 0) {
                    ArrayList arrayList2 = new ArrayList();
                    String[] strArr = f285a;
                    for (int i = 0; i < 10; i++) {
                        String str = strArr[i];
                        if (new File(str).exists()) {
                            arrayList2.add(str);
                        }
                    }
                    if (arrayList2.size() <= 0) {
                        r3 = 0;
                    }
                }
            }
            f22704a = r3;
            return r3;
        } catch (Throwable unused2) {
        }
    }
}
