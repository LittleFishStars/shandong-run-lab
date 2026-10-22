package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class s {
    public static com.kwad.sdk.k.a.d boM;

    public static class a extends com.kwad.sdk.k.a.a {
        public a() {
            UF();
        }

        private void UF() {
            ArrayList arrayList = new ArrayList();
            this.bms = arrayList;
            arrayList.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.s.a.1
                @Override // com.kwad.sdk.k.a.a
                public final boolean cH(Context context) {
                    String str = Build.PRODUCT;
                    int i = (str.contains("sdk") || str.contains("Andy") || str.contains("ttVM_Hdragon") || str.contains("google_sdk") || str.contains("Droid4X") || str.contains("nox") || str.contains("sdk_x86") || str.contains("sdk_google") || str.contains("vbox86p") || str.contains("aries")) ? 1 : 0;
                    String str2 = Build.MANUFACTURER;
                    if (str2.equals("unknown") || str2.equals("Genymotion") || str2.contains("Andy") || str2.contains("MIT") || str2.contains("nox") || str2.contains("TiantianVM")) {
                        i++;
                    }
                    String str3 = Build.BRAND;
                    if (str3.equals("generic") || str3.equals("generic_x86") || str3.equals("TTVM") || str3.contains("Andy")) {
                        i++;
                    }
                    String str4 = Build.DEVICE;
                    if (str4.contains("generic") || str4.contains("generic_x86") || str4.contains("Andy") || str4.contains("ttVM_Hdragon") || str4.contains("Droid4X") || str4.contains("nox") || str4.contains("generic_x86_64") || str4.contains("vbox86p") || str4.contains("aries")) {
                        i++;
                    }
                    String str5 = Build.MODEL;
                    if (str5.equals("sdk") || str5.contains("Emulator") || str5.equals("google_sdk") || str5.contains("Droid4X") || str5.contains("TiantianVM") || str5.contains("Andy") || str5.equals("Android SDK built for x86_64") || str5.equals("Android SDK built for x86")) {
                        i++;
                    }
                    String str6 = Build.HARDWARE;
                    if (str6.equals("goldfish") || str6.equals("vbox86") || str6.contains("nox") || str6.contains("ttVM_x86")) {
                        i++;
                    }
                    String str7 = Build.FINGERPRINT;
                    if (str7.contains("generic/sdk/generic") || str7.contains("generic_x86/sdk_x86/generic_x86") || str7.contains("Andy") || str7.contains("ttVM_Hdragon") || str7.contains("generic_x86_64") || str7.contains("generic/google_sdk/generic") || str7.contains("vbox86p") || str7.contains("generic/vbox86p/vbox86p")) {
                        i++;
                    }
                    try {
                        if (!be.useStoragePermissionDisable()) {
                            if (new File(Environment.getExternalStorageDirectory().toString() + File.separatorChar + "windows" + File.separatorChar + "BstSharedFolder").exists()) {
                                i += 10;
                            }
                        }
                    } catch (Exception unused) {
                    }
                    return i > 3;
                }
            });
            this.bms.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.s.a.2
                @Override // com.kwad.sdk.k.a.a
                public final boolean cH(Context context) {
                    return "1".equals(bs.get("ro.kernel.qemu"));
                }
            });
        }
    }

    public static class b extends com.kwad.sdk.k.a.a {
    }

    public static class c extends com.kwad.sdk.k.a.a {
    }

    public static class d extends com.kwad.sdk.k.a.a {
        public d() {
            UF();
        }

        private void UF() {
            ArrayList arrayList = new ArrayList();
            this.bms = arrayList;
            arrayList.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.s.d.1
                @Override // com.kwad.sdk.k.a.a
                public final boolean cH(Context context) {
                    return new File("/system/app/Superuser.apk").exists();
                }
            });
            this.bms.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.s.d.2
                @Override // com.kwad.sdk.k.a.a
                public final boolean cH(Context context) {
                    String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
                    for (int i = 0; i < 5; i++) {
                        if (new File(strArr[i] + "su").exists()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            this.bms.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.s.d.3
                @Override // com.kwad.sdk.k.a.a
                public final boolean cH(Context context) {
                    return !TextUtils.isEmpty(s.g(new String[]{"/system/xbin/which", "su"}));
                }
            });
            this.bms.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.s.d.4
                @Override // com.kwad.sdk.k.a.a
                public final boolean cH(Context context) {
                    Charset charsetForName = Charset.forName("UTF-8");
                    File file = new File("/data/su_test");
                    try {
                        y.a(file, "ok", charsetForName, false);
                        return y.a(file, charsetForName).equals("ok");
                    } catch (Throwable unused) {
                        return false;
                    }
                }
            });
        }
    }

    public static class e extends com.kwad.sdk.k.a.a {
        public e() {
            UF();
        }

        private void UF() {
            ArrayList arrayList = new ArrayList();
            this.bms = arrayList;
            arrayList.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.s.e.1
                @Override // com.kwad.sdk.k.a.a
                public final boolean cH(Context context) {
                    return au.aw(context, "de.robv.android.xposed.installer") || au.aw(context, "com.saurik.substrate");
                }
            });
            this.bms.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.s.e.2
                @Override // com.kwad.sdk.k.a.a
                public final boolean cH(Context context) {
                    try {
                        throw new Exception("empty");
                    } catch (Exception e) {
                        boolean z = false;
                        int i = 0;
                        for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                            String className = stackTraceElement.getClassName();
                            String methodName = stackTraceElement.getMethodName();
                            if (className.equals("com.android.internal.os.ZygoteInit") && (i = i + 1) == 2) {
                                z = true;
                            }
                            if (className.equals("com.saurik.substrate.MS$2") && methodName.equals("invoked")) {
                                Log.wtf("HookDetection", "A method on the stack trace has been hooked using Substrate.");
                                z = true;
                            }
                            if (className.equals(com.kuaishou.weapon.p0.an.b) && methodName.equals("main")) {
                                z = true;
                            }
                            if (className.equals(com.kuaishou.weapon.p0.an.b) && methodName.equals("handleHookedMethod")) {
                                z = true;
                            }
                        }
                        return z;
                    }
                }
            });
            this.bms.add(new com.kwad.sdk.k.a.a(this.enabled) { // from class: com.kwad.sdk.utils.s.e.3
                @Override // com.kwad.sdk.k.a.a
                public final boolean cH(Context context) throws Throwable {
                    FileReader fileReader;
                    boolean z = false;
                    BufferedReader bufferedReader = null;
                    try {
                        HashSet<String> hashSet = new HashSet();
                        fileReader = new FileReader("/proc/" + Process.myPid() + "/maps");
                        try {
                            BufferedReader bufferedReader2 = new BufferedReader(fileReader);
                            while (true) {
                                try {
                                    String line = bufferedReader2.readLine();
                                    if (line == null) {
                                        break;
                                    }
                                    if (line.endsWith(".so") || line.endsWith(".jar")) {
                                        hashSet.add(line.substring(line.lastIndexOf(" ") + 1));
                                    }
                                } catch (Exception unused) {
                                    bufferedReader = bufferedReader2;
                                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                                } catch (Throwable th) {
                                    th = th;
                                    bufferedReader = bufferedReader2;
                                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                                    throw th;
                                }
                            }
                            for (String str : hashSet) {
                                if (str.contains("com.saurik.substrate")) {
                                    Log.wtf("HookDetection", "Substrate shared object found: " + str);
                                    z = true;
                                }
                                if (str.contains("XposedBridge.jar")) {
                                    Log.wtf("HookDetection", "Xposed JAR found: " + str);
                                    z = true;
                                }
                            }
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                        } catch (Exception unused2) {
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Exception unused3) {
                        fileReader = null;
                    } catch (Throwable th3) {
                        th = th3;
                        fileReader = null;
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileReader);
                    return z;
                }
            });
        }
    }

    @WorkerThread
    public static synchronized com.kwad.sdk.k.a.d UE() {
        if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).FI()) {
            return null;
        }
        com.kwad.sdk.k.a.d dVar = boM;
        if (dVar != null) {
            return dVar;
        }
        Context applicationContext = ServiceProvider.getContext().getApplicationContext();
        com.kwad.sdk.k.a.d dVar2 = new com.kwad.sdk.k.a.d(applicationContext);
        boolean zCG = new d().cG(applicationContext);
        boolean zCG2 = new e().cG(applicationContext);
        boolean zCG3 = new b().cG(applicationContext);
        boolean zCG4 = new a().cG(applicationContext);
        boolean zCG5 = new c().cG(applicationContext);
        dVar2.cl(zCG);
        dVar2.cm(zCG2);
        dVar2.cn(zCG3);
        dVar2.cp(zCG4);
        dVar2.cq(zCG5);
        boM = dVar2;
        return dVar2;
    }

    public static String g(String[] strArr) {
        try {
            return com.kwad.sdk.crash.utils.h.c(Runtime.getRuntime().exec(strArr).getInputStream());
        } catch (Exception unused) {
            return null;
        }
    }
}
