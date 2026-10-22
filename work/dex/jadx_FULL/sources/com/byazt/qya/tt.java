package com.byazt.qya;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 689, 13})
public class tt {
    public static String c;
    public static String tt;
    public static Map<String, Integer> ve = new HashMap();

    static {
        if (uj.c()) {
            tt = Build.SUPPORTED_ABIS[0];
        } else {
            tt = Build.CPU_ABI;
        }
        ve.put("arm64-v8a", 64);
        ve.put("armeabi-v7a", 32);
        ve.put("armeabi", 32);
        ve.put("x86_64", 64);
        ve.put("x86", 32);
        ve.put("mips64", 64);
        ve.put("mips", 32);
        c = tt();
    }

    private static Map<String, List<ZipEntry>> c(ZipFile zipFile) {
        String[] strArrSplit;
        HashMap map = new HashMap();
        Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
        Pattern patternCompile = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
        while (enumerationEntries.hasMoreElements()) {
            ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
            if (!zipEntryNextElement.isDirectory() && patternCompile.matcher(zipEntryNextElement.getName()).matches() && (strArrSplit = zipEntryNextElement.getName().split(File.separator)) != null && strArrSplit.length >= 2) {
                String str = strArrSplit[strArrSplit.length - 2];
                if (ve.containsKey(str)) {
                    if (map.get(str) == null) {
                        map.put(str, new LinkedList());
                    }
                    ((List) map.get(str)).add(zipEntryNextElement);
                }
            }
        }
        m.c("NativeLibHelper", "NativeLibHelper getAllSoZipEntries, zipFile=" + zipFile.getName() + ", soEntries=" + map.toString());
        return map;
    }

    private static String tt() {
        JSONObject jSONObjectVe = ve();
        String strC = c(jSONObjectVe);
        return strC == null ? tt(jSONObjectVe) : strC;
    }

    private static JSONObject ve() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("primaryCpuAbi", "0");
            jSONObject.put("processMode", "0");
            jSONObject.put("supportedABI0", "0");
            jSONObject.put("matchCpuAbi", "0");
            jSONObject.put("defaultABI0", "0");
            jSONObject.put("defaultABI", "0");
            jSONObject.put("autoError", "0");
            jSONObject.put("manualError", "0");
        } catch (JSONException e) {
            m.c(e);
        }
        return jSONObject;
    }

    private static String tt(JSONObject jSONObject) {
        try {
            Context context = gt.getContext();
            ZipFile zipFile = new ZipFile(new File(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir));
            HashSet hashSet = new HashSet(c(zipFile).keySet());
            try {
                zipFile.close();
            } catch (IOException unused) {
                m.tt("NativeLibHelper", "NativeLibHelper inferHostAbiManual, close sourceApkZipFile error!");
            }
            String[] strArr = uj.c() ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2};
            if (hashSet.isEmpty()) {
                m.tt("NativeLibHelper", "NativeLibHelper inferHostAbiManual, host source apk .so is empty, use supportedABIs[0]=" + strArr[0]);
                c(jSONObject, "supportedABI0", strArr[0]);
                return strArr[0];
            }
            for (String str : strArr) {
                if (hashSet.contains(str)) {
                    m.tt("NativeLibHelper", "NativeLibHelper inferHostAbiManual, match cpuAbi=".concat(String.valueOf(str)));
                    c(jSONObject, "matchCpuAbi", str);
                    return str;
                }
            }
            if (uj.c()) {
                String[] strArr2 = Build.SUPPORTED_ABIS;
                c(jSONObject, "defaultABI0", strArr2[0]);
                return strArr2[0];
            }
            String str2 = Build.CPU_ABI;
            c(jSONObject, "defaultABI", str2);
            return str2;
        } catch (Throwable th) {
            m.ve("NativeLibHelper", "NativeLibHelper inferHostAbiManual failed!", th);
            c(jSONObject, "manualError", "1");
        }
    }

    public static String c() {
        String str = c;
        if (str != null) {
            return str;
        }
        String strTt = tt();
        c = strTt;
        return strTt;
    }

    private static String c(JSONObject jSONObject) {
        if (!uj.c()) {
            return null;
        }
        try {
            String str = (String) c.c(gt.getContext().getApplicationInfo(), "primaryCpuAbi");
            m.tt("NativeLibHelper", "NativeLibHelper inferHostAbiAuto, primaryCpuAbi=".concat(String.valueOf(str)));
            c(jSONObject, "primaryCpuAbi", str);
            if (str == null) {
                return null;
            }
            int i = 0;
            if (uj.tt()) {
                try {
                    i = Process.is64Bit() ? 64 : 32;
                    m.tt("NativeLibHelper", "NativeLibHelper inferHostAbiAuto, processMode=".concat(String.valueOf(i)));
                } catch (Exception unused) {
                    m.tt("NativeLibHelper", "NativeLibHelper inferHostAbiAuto, processMode exception default=".concat(String.valueOf(i)));
                }
            } else {
                m.tt("NativeLibHelper", "NativeLibHelper inferHostAbiAuto, processMode default=0");
            }
            c(jSONObject, "processMode", String.valueOf(i));
            if (i != 0) {
                if (ve.get(str).intValue() != i) {
                    return null;
                }
                m.tt("NativeLibHelper", "NativeLibHelper inferHostAbiAuto2, sHostAbi=".concat(str));
                return str;
            }
            m.tt("NativeLibHelper", "NativeLibHelper inferHostAbiAuto1, sHostAbi=".concat(str));
            return str;
        } catch (Exception e) {
            m.ve("NativeLibHelper", "NativeLibHelper inferHostAbiAuto failed!", e);
            c(jSONObject, "autoError", "1");
            return null;
        }
    }

    private static void c(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e) {
            m.c(e);
        }
    }
}
