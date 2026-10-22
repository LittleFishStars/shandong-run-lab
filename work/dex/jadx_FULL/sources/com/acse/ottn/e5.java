package com.acse.ottn;

import android.content.pm.PackageManager;
import android.os.Process;
import android.text.TextUtils;
import com.acse.ottn.util.HelpShopAppUtil;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e5 {
    public static boolean a() {
        try {
            HashSet<String> hashSet = new HashSet();
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/maps"));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                if (line.endsWith(".so") || line.endsWith(".jar")) {
                    hashSet.add(line.substring(line.lastIndexOf(" ") + 1));
                }
            }
            bufferedReader.close();
            for (String str : hashSet) {
                if (str.contains("XposedBridge.jar")) {
                    h2.a("HookDetection", "Xposed JAR found: " + str);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            h2.a("HookDetection", e.toString());
            return false;
        }
    }

    public static void b() {
        boolean z = false;
        try {
            HelpShopAppUtil.getContext();
            PackageManager packageManager = HelpShopAppUtil.getContext().getPackageManager();
            if (!TextUtils.isEmpty(packageManager.getApplicationLabel(packageManager.getPackageInfo("de.robv.android.xposed.installer", 0).applicationInfo).toString())) {
                n3.a().a("xposed_state", Boolean.FALSE);
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        n3.a().a("xposed_state", Boolean.valueOf(z));
    }

    public static boolean c() {
        return false;
    }

    public static void d() {
        try {
            b();
        } catch (Exception unused) {
        }
    }
}
