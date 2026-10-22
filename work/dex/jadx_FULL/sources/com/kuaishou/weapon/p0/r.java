package com.kuaishou.weapon.p0;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.android.arouter.utils.Consts;
import com.kuaishou.weapon.p0.jni.Engine;
import com.zj.adlib.c49;
import com.zj.adlib.u15;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class r {
    private static r c;
    private static Application d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f40138a;
    private String e;
    private static Random f = new Random();
    private static Map<String, s> g = new ConcurrentHashMap();
    private static Map<String, s> h = new ConcurrentHashMap();
    public static List<Integer> b = new ArrayList();

    private r() {
    }

    public static r a(Context context, boolean z) {
        try {
            if (c == null) {
                d = (Application) context.getApplicationContext();
                c = new r();
            }
        } catch (Throwable unused) {
        }
        return c;
    }

    public static boolean e(String str) {
        try {
            File file = new File(str);
            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }
            if (file.exists()) {
                return true;
            }
            file.mkdirs();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean b(String str) {
        s sVar = h.get(str);
        if (sVar == null) {
            return false;
        }
        g.remove(sVar.e);
        h.remove(str);
        dl.c(sVar.m);
        Application application = d;
        if (application == null) {
            return true;
        }
        dl.c(application.getFileStreamPath(sVar.c).getAbsolutePath());
        return true;
    }

    public s c(String str) {
        try {
            return g.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public s d(String str) {
        try {
            return h.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static r a() {
        return c;
    }

    public boolean a(s sVar, boolean z) {
        this.f40138a = z;
        this.e = sVar.d;
        return a(sVar);
    }

    public Map<String, s> b() {
        return h;
    }

    private synchronized boolean a(s sVar) {
        boolean z;
        if (sVar != null) {
            if (!TextUtils.isEmpty(sVar.e)) {
                s sVar2 = g.get(sVar.e);
                if (sVar2 != null) {
                    if (sVar2.d.equals(sVar.d)) {
                        return true;
                    }
                    a(sVar2.e);
                }
                try {
                    sVar.f = d;
                    if (sVar.p == 1) {
                        try {
                            try {
                                if (!TextUtils.isEmpty(sVar.c) && !TextUtils.isEmpty(sVar.e)) {
                                    sVar.m = d.getFilesDir().getCanonicalPath() + bg.j + sVar.f40139a;
                                    String str = sVar.m + "/dex";
                                    String str2 = sVar.m + "/lib/" + this.e;
                                    dl.c(sVar.m + "/lib");
                                    String str3 = str2 + WVNativeCallbackUtil.SEPERATER + f.nextInt();
                                    e(str);
                                    dl.a(str, Boolean.FALSE);
                                    e(str3);
                                    a(sVar, str3, str, false);
                                    h.put(sVar.c, sVar);
                                    g.put(sVar.e, sVar);
                                } else {
                                    throw new RuntimeException("apkPackageName or apkPkgPath is null");
                                }
                            } catch (Throwable unused) {
                                a(sVar.e);
                                z = true;
                            }
                        } catch (Throwable unused2) {
                            return false;
                        }
                    }
                    z = false;
                    if (sVar.p != 1 || z) {
                        PackageInfo packageArchiveInfo = sVar.r;
                        if (packageArchiveInfo == null || TextUtils.isEmpty(packageArchiveInfo.packageName) || TextUtils.isEmpty(packageArchiveInfo.versionName)) {
                            packageArchiveInfo = d.getPackageManager().getPackageArchiveInfo(sVar.e, 1);
                        }
                        if (!TextUtils.isEmpty(packageArchiveInfo.packageName) && packageArchiveInfo.packageName.startsWith("com.kuaishou.weapon")) {
                            if (sVar.p != 1 && sVar.b != 1 && !((Boolean) a(sVar.j, sVar.e).first).booleanValue()) {
                                return false;
                            }
                            sVar.c = packageArchiveInfo.packageName;
                            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
                            sVar.o = applicationInfo.className;
                            sVar.d = packageArchiveInfo.versionName;
                            sVar.l = packageArchiveInfo.activities;
                            sVar.q = applicationInfo.theme;
                            sVar.m = d.getFilesDir().getCanonicalPath() + bg.j + sVar.f40139a;
                            String str4 = sVar.m + "/dex";
                            String str5 = sVar.m + "/lib/" + this.e;
                            dl.c(sVar.m + "/lib");
                            String str6 = str5 + WVNativeCallbackUtil.SEPERATER + f.nextInt();
                            e(str4);
                            dl.a(str4, Boolean.FALSE);
                            e(str6);
                            a(sVar, str6, str4, true);
                            h.put(sVar.c, sVar);
                            g.put(sVar.e, sVar);
                            b.add(Integer.valueOf(sVar.f40139a));
                        } else {
                            throw new Exception("weapon package name check failed");
                        }
                    }
                    return true;
                } catch (Throwable unused3) {
                    a(sVar.e);
                    return false;
                }
            }
        }
        return false;
    }

    private Pair<Boolean, String> a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str2);
            if (!dl.a(file)) {
                return new Pair<>(Boolean.FALSE, "");
            }
            String strA = f.a(file);
            if (TextUtils.isEmpty(strA)) {
                return new Pair<>(Boolean.FALSE, "");
            }
            if (!strA.equalsIgnoreCase(str)) {
                return new Pair<>(Boolean.FALSE, strA);
            }
            return new Pair<>(Boolean.TRUE, "");
        }
        return new Pair<>(Boolean.FALSE, "");
    }

    public boolean a(String str) {
        s sVar = g.get(str);
        if (sVar == null) {
            return false;
        }
        g.remove(str);
        h.remove(sVar.c);
        dl.c(sVar.m);
        Application application = d;
        if (application == null) {
            return true;
        }
        dl.c(application.getFileStreamPath(sVar.c).getAbsolutePath());
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0031  */
    /* JADX WARN: Code duplicated, block: B:148:0x02af  */
    /* JADX WARN: Code duplicated, block: B:150:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:158:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:160:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:168:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:170:0x02f0  */
    /* JADX WARN: Code duplicated, block: B:172:0x02f5 A[PHI: r11 r17 r18 r21 r22
      0x02f5: PHI (r11v11 ??) = (r11v8 ??), (r11v9 ??), (r11v12 ??), (r11v16 ??) binds: [B:151:0x02b7, B:171:0x02f3, B:161:0x02d5, B:121:0x0238] A[DONT_GENERATE, DONT_INLINE]
      0x02f5: PHI (r17v12 java.io.InputStream) = (r17v9 java.io.InputStream), (r17v10 java.io.InputStream), (r17v13 java.io.InputStream), (r17v20 java.io.InputStream) binds: [B:151:0x02b7, B:171:0x02f3, B:161:0x02d5, B:121:0x0238] A[DONT_GENERATE, DONT_INLINE]
      0x02f5: PHI (r18v9 ??) = (r18v6 ??), (r18v7 ??), (r18v10 ??), (r18v14 ??) binds: [B:151:0x02b7, B:171:0x02f3, B:161:0x02d5, B:121:0x0238] A[DONT_GENERATE, DONT_INLINE]
      0x02f5: PHI (r21v8 ??) = (r21v4 ??), (r21v5 ??), (r21v9 ??), (r21v19 ??) binds: [B:151:0x02b7, B:171:0x02f3, B:161:0x02d5, B:121:0x0238] A[DONT_GENERATE, DONT_INLINE]
      0x02f5: PHI (r22v8 java.lang.String) = (r22v4 java.lang.String), (r22v5 java.lang.String), (r22v9 java.lang.String), (r22v19 java.lang.String) binds: [B:151:0x02b7, B:171:0x02f3, B:161:0x02d5, B:121:0x0238] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:175:0x0306  */
    /* JADX WARN: Code duplicated, block: B:178:0x0320 A[Catch: all -> 0x0334, TRY_LEAVE, TryCatch #8 {all -> 0x0334, blocks: (B:176:0x0318, B:178:0x0320), top: B:240:0x0318 }] */
    /* JADX WARN: Code duplicated, block: B:182:0x0338  */
    /* JADX WARN: Code duplicated, block: B:183:0x0355  */
    /* JADX WARN: Code duplicated, block: B:186:0x0374 A[Catch: all -> 0x0392, TRY_LEAVE, TryCatch #34 {all -> 0x0392, blocks: (B:184:0x036c, B:186:0x0374), top: B:261:0x036c }] */
    /* JADX WARN: Code duplicated, block: B:188:0x0392  */
    /* JADX WARN: Code duplicated, block: B:191:0x039a  */
    /* JADX WARN: Code duplicated, block: B:193:0x03a4  */
    /* JADX WARN: Code duplicated, block: B:195:0x03aa  */
    /* JADX WARN: Code duplicated, block: B:204:0x03f9 A[Catch: all -> 0x046f, TryCatch #5 {, blocks: (B:201:0x03d8, B:202:0x03eb, B:204:0x03f9, B:206:0x0403, B:210:0x044d, B:211:0x046e, B:208:0x040d), top: B:235:0x03d8, inners: #32 }] */
    /* JADX WARN: Code duplicated, block: B:206:0x0403 A[Catch: all -> 0x046f, TRY_LEAVE, TryCatch #5 {, blocks: (B:201:0x03d8, B:202:0x03eb, B:204:0x03f9, B:206:0x0403, B:210:0x044d, B:211:0x046e, B:208:0x040d), top: B:235:0x03d8, inners: #32 }] */
    /* JADX WARN: Code duplicated, block: B:212:0x046f A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:216:0x0475  */
    /* JADX WARN: Code duplicated, block: B:218:0x047a  */
    /* JADX WARN: Code duplicated, block: B:220:0x047f  */
    /* JADX WARN: Code duplicated, block: B:261:0x036c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0238, code lost:
    
        if (r18 != 0) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:291:?, code lost:
    
        return;
     */
    /* JADX WARN: Instruction removed from duplicated block: B:175:0x0306, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:178:0x0320, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:182:0x0338, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:183:0x0355, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:186:0x0374, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r11v16, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v44 */
    /* JADX WARN: Type inference failed for: r11v45 */
    /* JADX WARN: Type inference failed for: r11v46 */
    /* JADX WARN: Type inference failed for: r11v49 */
    /* JADX WARN: Type inference failed for: r11v50 */
    /* JADX WARN: Type inference failed for: r11v51 */
    /* JADX WARN: Type inference failed for: r11v52 */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r18v10 */
    /* JADX WARN: Type inference failed for: r18v11 */
    /* JADX WARN: Type inference failed for: r18v12 */
    /* JADX WARN: Type inference failed for: r18v13 */
    /* JADX WARN: Type inference failed for: r18v14 */
    /* JADX WARN: Type inference failed for: r18v15 */
    /* JADX WARN: Type inference failed for: r18v16 */
    /* JADX WARN: Type inference failed for: r18v17 */
    /* JADX WARN: Type inference failed for: r18v18 */
    /* JADX WARN: Type inference failed for: r18v19 */
    /* JADX WARN: Type inference failed for: r18v20 */
    /* JADX WARN: Type inference failed for: r18v21 */
    /* JADX WARN: Type inference failed for: r18v22 */
    /* JADX WARN: Type inference failed for: r18v23 */
    /* JADX WARN: Type inference failed for: r18v24 */
    /* JADX WARN: Type inference failed for: r18v25 */
    /* JADX WARN: Type inference failed for: r18v26 */
    /* JADX WARN: Type inference failed for: r18v27 */
    /* JADX WARN: Type inference failed for: r18v28 */
    /* JADX WARN: Type inference failed for: r18v29 */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v30 */
    /* JADX WARN: Type inference failed for: r18v31 */
    /* JADX WARN: Type inference failed for: r18v32 */
    /* JADX WARN: Type inference failed for: r18v33 */
    /* JADX WARN: Type inference failed for: r18v34 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v5 */
    /* JADX WARN: Type inference failed for: r18v6 */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r18v8 */
    /* JADX WARN: Type inference failed for: r18v9, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v20, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r21v13 */
    /* JADX WARN: Type inference failed for: r21v14 */
    /* JADX WARN: Type inference failed for: r21v15 */
    /* JADX WARN: Type inference failed for: r21v16 */
    /* JADX WARN: Type inference failed for: r21v17 */
    /* JADX WARN: Type inference failed for: r21v18 */
    /* JADX WARN: Type inference failed for: r21v19 */
    /* JADX WARN: Type inference failed for: r21v22 */
    /* JADX WARN: Type inference failed for: r21v23 */
    /* JADX WARN: Type inference failed for: r21v24 */
    /* JADX WARN: Type inference failed for: r21v27 */
    /* JADX WARN: Type inference failed for: r21v28 */
    /* JADX WARN: Type inference failed for: r21v29 */
    /* JADX WARN: Type inference failed for: r21v33 */
    /* JADX WARN: Type inference failed for: r21v35 */
    /* JADX WARN: Type inference failed for: r21v36 */
    /* JADX WARN: Type inference failed for: r21v37 */
    /* JADX WARN: Type inference failed for: r21v38 */
    /* JADX WARN: Type inference failed for: r21v39 */
    /* JADX WARN: Type inference failed for: r21v4 */
    /* JADX WARN: Type inference failed for: r21v40 */
    /* JADX WARN: Type inference failed for: r21v41 */
    /* JADX WARN: Type inference failed for: r21v42 */
    /* JADX WARN: Type inference failed for: r21v43 */
    /* JADX WARN: Type inference failed for: r21v44 */
    /* JADX WARN: Type inference failed for: r21v5 */
    /* JADX WARN: Type inference failed for: r21v6 */
    /* JADX WARN: Type inference failed for: r21v7 */
    /* JADX WARN: Type inference failed for: r21v8 */
    /* JADX WARN: Type inference failed for: r21v9 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(s sVar, String str, String str2, boolean z) throws Throwable {
        boolean z2;
        InputStream inputStream;
        ?? r18;
        String str3;
        ZipFile zipFile;
        ZipFile zipFile2;
        ZipFile zipFile3;
        Object obj;
        ?? r19;
        Object obj2;
        Object obj3;
        ?? r21;
        String str4;
        String str5;
        String str6;
        String strA;
        String str7;
        String str8;
        String str9;
        ?? r22;
        File file;
        String str10;
        String str11;
        String str12 = ".so";
        ?? r11 = "armeabi";
        HashSet<String> hashSet = new HashSet<>();
        if (z || TextUtils.isEmpty(sVar.n)) {
            z2 = true;
        } else {
            File file2 = new File(sVar.n);
            if (file2.exists() && file2.isFile()) {
                z2 = false;
            } else {
                z2 = true;
            }
        }
        String str13 = "";
        String strReplace = !TextUtils.isEmpty(sVar.d) ? sVar.d.replace(Consts.DOT, "") : "";
        StringBuilder sb = new StringBuilder();
        if (!z2) {
            sb.append(sVar.n);
        }
        byte[] bArr = new byte[4096];
        ?? r16 = 0;
        str = null;
        String str14 = null;
        try {
            try {
                try {
                    ZipFile zipFile4 = new ZipFile(sVar.e);
                    try {
                        Enumeration<? extends ZipEntry> enumerationEntries = zipFile4.entries();
                        inputStream = null;
                        r19 = 0;
                        r11 = r11;
                        while (enumerationEntries.hasMoreElements()) {
                            try {
                                try {
                                    try {
                                        ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                                        ?? name = zipEntryNextElement.getName();
                                        Enumeration<? extends ZipEntry> enumeration = enumerationEntries;
                                        if (name.contains("../")) {
                                            str3 = str13;
                                        } else {
                                            if (!name.startsWith("lib/") || zipEntryNextElement.isDirectory()) {
                                                r11 = r11;
                                                str3 = str13;
                                                r19 = r19;
                                            } else {
                                                String str15 = Build.CPU_ABI;
                                                try {
                                                    str10 = Build.CPU_ABI2;
                                                } catch (Throwable unused) {
                                                    str10 = null;
                                                }
                                                if (name.contains(str15)) {
                                                    str3 = str13;
                                                } else {
                                                    try {
                                                        if (TextUtils.isEmpty(str10)) {
                                                            str3 = str13;
                                                            str11 = str10;
                                                        } else {
                                                            str3 = str13;
                                                            str11 = str10;
                                                            try {
                                                                if (!name.contains(str11)) {
                                                                }
                                                            } catch (EOFException unused2) {
                                                                r22 = r11;
                                                                r11 = zipFile4;
                                                                r19 = r19;
                                                                r21 = r22;
                                                                a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                                                                if (r11 != 0) {
                                                                    r11.close();
                                                                }
                                                                if (inputStream != null) {
                                                                    inputStream.close();
                                                                }
                                                                if (r19 != 0) {
                                                                    r19.close();
                                                                }
                                                                str4 = Build.CPU_ABI;
                                                                if (hashSet.contains(str4)) {
                                                                    str7 = str + WVNativeCallbackUtil.SEPERATER + str4;
                                                                    try {
                                                                        str9 = Build.CPU_ABI2;
                                                                        if (hashSet.contains(str9)) {
                                                                            str14 = str + WVNativeCallbackUtil.SEPERATER + str9;
                                                                        }
                                                                    } catch (Throwable unused3) {
                                                                    }
                                                                    str8 = str14;
                                                                    if (str8 != null) {
                                                                        str5 = str7 + u15.f19942b + str8 + u15.f19942b + System.getProperty("java.library.path");
                                                                    } else {
                                                                        str5 = str7 + u15.f19942b + System.getProperty("java.library.path");
                                                                    }
                                                                } else {
                                                                    try {
                                                                        str6 = Build.CPU_ABI2;
                                                                        if (hashSet.contains(str6)) {
                                                                            str5 = str + WVNativeCallbackUtil.SEPERATER + str6 + u15.f19942b + System.getProperty("java.library.path");
                                                                        } else {
                                                                            str5 = str3;
                                                                        }
                                                                    } catch (Throwable unused4) {
                                                                    }
                                                                }
                                                                if (TextUtils.isEmpty(str5)) {
                                                                    ?? r1 = r21;
                                                                    if ((!"armeabi-v7a".equals(Build.CPU_ABI) && hashSet.contains(r1)) || ("armeabi-v7a".equals(Build.CPU_ABI2) && hashSet.contains(r1))) {
                                                                        str5 = str + "/armeabi:" + System.getProperty("java.library.path");
                                                                    }
                                                                }
                                                                sVar.h = str5;
                                                                sVar.n = sb.toString();
                                                                String absolutePath = new File(str2, "apkDex").getAbsolutePath();
                                                                dl.c(absolutePath);
                                                                e(absolutePath);
                                                                strA = dk.a(d);
                                                                if (TextUtils.isEmpty(sVar.n)) {
                                                                    if (!sVar.c.endsWith("v7") || sVar.c.endsWith("v8")) {
                                                                        try {
                                                                            dm.a(getClass().getClassLoader(), new File(str + WVNativeCallbackUtil.SEPERATER + strA));
                                                                            Engine.soPath = str + WVNativeCallbackUtil.SEPERATER + strA;
                                                                            Engine.soVersion = sVar.d;
                                                                            Engine.getInstance(d);
                                                                        } catch (Throwable unused5) {
                                                                            throw new RuntimeException("can't load WeaponEngineImpl by both dexFile:" + sb.toString() + " and ZipFile:" + sVar.e);
                                                                        }
                                                                    }
                                                                    return;
                                                                }
                                                            } catch (FileNotFoundException | ZipException unused6) {
                                                                r22 = r11;
                                                                r11 = zipFile4;
                                                                r19 = r19;
                                                                r21 = r22;
                                                                a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                                                                if (r11 != 0) {
                                                                    r11.close();
                                                                }
                                                                if (inputStream != null) {
                                                                    inputStream.close();
                                                                }
                                                                if (r19 != 0) {
                                                                    r19.close();
                                                                }
                                                                str4 = Build.CPU_ABI;
                                                                if (hashSet.contains(str4)) {
                                                                    str7 = str + WVNativeCallbackUtil.SEPERATER + str4;
                                                                    str9 = Build.CPU_ABI2;
                                                                    if (hashSet.contains(str9)) {
                                                                        str14 = str + WVNativeCallbackUtil.SEPERATER + str9;
                                                                    }
                                                                    str8 = str14;
                                                                    if (str8 != null) {
                                                                        str5 = str7 + u15.f19942b + str8 + u15.f19942b + System.getProperty("java.library.path");
                                                                    } else {
                                                                        str5 = str7 + u15.f19942b + System.getProperty("java.library.path");
                                                                    }
                                                                } else {
                                                                    str6 = Build.CPU_ABI2;
                                                                    if (hashSet.contains(str6)) {
                                                                        str5 = str + WVNativeCallbackUtil.SEPERATER + str6 + u15.f19942b + System.getProperty("java.library.path");
                                                                    } else {
                                                                        str5 = str3;
                                                                    }
                                                                }
                                                                if (TextUtils.isEmpty(str5)) {
                                                                    ?? r2 = r21;
                                                                    if (!"armeabi-v7a".equals(Build.CPU_ABI)) {
                                                                        str5 = str + "/armeabi:" + System.getProperty("java.library.path");
                                                                    } else {
                                                                        str5 = str + "/armeabi:" + System.getProperty("java.library.path");
                                                                    }
                                                                }
                                                                sVar.h = str5;
                                                                sVar.n = sb.toString();
                                                                String absolutePath2 = new File(str2, "apkDex").getAbsolutePath();
                                                                dl.c(absolutePath2);
                                                                e(absolutePath2);
                                                                strA = dk.a(d);
                                                                if (TextUtils.isEmpty(sVar.n)) {
                                                                    if (sVar.c.endsWith("v7")) {
                                                                    }
                                                                    dm.a(getClass().getClassLoader(), new File(str + WVNativeCallbackUtil.SEPERATER + strA));
                                                                    Engine.soPath = str + WVNativeCallbackUtil.SEPERATER + strA;
                                                                    Engine.soVersion = sVar.d;
                                                                    Engine.getInstance(d);
                                                                }
                                                            } catch (IOException unused7) {
                                                                r22 = r11;
                                                                r11 = zipFile4;
                                                                r19 = r19;
                                                                r21 = r22;
                                                                a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                                                                if (r11 != 0) {
                                                                    r11.close();
                                                                }
                                                                if (inputStream != null) {
                                                                    inputStream.close();
                                                                }
                                                                if (r19 != 0) {
                                                                    r19.close();
                                                                }
                                                                str4 = Build.CPU_ABI;
                                                                if (hashSet.contains(str4)) {
                                                                    str7 = str + WVNativeCallbackUtil.SEPERATER + str4;
                                                                    str9 = Build.CPU_ABI2;
                                                                    if (hashSet.contains(str9)) {
                                                                        str14 = str + WVNativeCallbackUtil.SEPERATER + str9;
                                                                    }
                                                                    str8 = str14;
                                                                    if (str8 != null) {
                                                                        str5 = str7 + u15.f19942b + str8 + u15.f19942b + System.getProperty("java.library.path");
                                                                    } else {
                                                                        str5 = str7 + u15.f19942b + System.getProperty("java.library.path");
                                                                    }
                                                                } else {
                                                                    str6 = Build.CPU_ABI2;
                                                                    if (hashSet.contains(str6)) {
                                                                        str5 = str + WVNativeCallbackUtil.SEPERATER + str6 + u15.f19942b + System.getProperty("java.library.path");
                                                                    } else {
                                                                        str5 = str3;
                                                                    }
                                                                }
                                                                if (TextUtils.isEmpty(str5)) {
                                                                    ?? r3 = r21;
                                                                    if (!"armeabi-v7a".equals(Build.CPU_ABI)) {
                                                                        str5 = str + "/armeabi:" + System.getProperty("java.library.path");
                                                                    } else {
                                                                        str5 = str + "/armeabi:" + System.getProperty("java.library.path");
                                                                    }
                                                                }
                                                                sVar.h = str5;
                                                                sVar.n = sb.toString();
                                                                String absolutePath3 = new File(str2, "apkDex").getAbsolutePath();
                                                                dl.c(absolutePath3);
                                                                e(absolutePath3);
                                                                strA = dk.a(d);
                                                                if (TextUtils.isEmpty(sVar.n)) {
                                                                    if (sVar.c.endsWith("v7")) {
                                                                    }
                                                                    dm.a(getClass().getClassLoader(), new File(str + WVNativeCallbackUtil.SEPERATER + strA));
                                                                    Engine.soPath = str + WVNativeCallbackUtil.SEPERATER + strA;
                                                                    Engine.soVersion = sVar.d;
                                                                    Engine.getInstance(d);
                                                                }
                                                            }
                                                        }
                                                        if (!name.contains(r11) || (!"armeabi-v7a".equalsIgnoreCase(str15) && (TextUtils.isEmpty(str11) || !"armeabi-v7a".equalsIgnoreCase(str11)))) {
                                                        }
                                                    } catch (EOFException unused8) {
                                                        str3 = str13;
                                                    } catch (FileNotFoundException | ZipException unused9) {
                                                        str3 = str13;
                                                    } catch (IOException unused10) {
                                                        str3 = str13;
                                                    }
                                                }
                                                StringBuilder sb2 = new StringBuilder();
                                                sb2.append(str);
                                                r22 = r11;
                                                try {
                                                    try {
                                                        sb2.append(name.substring(3).replace(str12, strReplace + str12));
                                                        String string = sb2.toString();
                                                        String strSubstring = string.substring(0, string.lastIndexOf(47));
                                                        hashSet.add(strSubstring.substring(strSubstring.lastIndexOf(47) + 1));
                                                        e(strSubstring);
                                                        new File(string).delete();
                                                        InputStream inputStream2 = zipFile4.getInputStream(zipEntryNextElement);
                                                        try {
                                                            FileOutputStream fileOutputStream = new FileOutputStream(string);
                                                            while (true) {
                                                                try {
                                                                    int i = inputStream2.read(bArr);
                                                                    if (i <= 0) {
                                                                        break;
                                                                    }
                                                                    inputStream = inputStream2;
                                                                    try {
                                                                        fileOutputStream.write(bArr, 0, i);
                                                                        inputStream2 = inputStream;
                                                                    } catch (EOFException unused11) {
                                                                        r11 = zipFile4;
                                                                        r19 = fileOutputStream;
                                                                        r21 = r22;
                                                                        a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                                                                        if (r11 != 0) {
                                                                            r11.close();
                                                                        }
                                                                        if (inputStream != null) {
                                                                            inputStream.close();
                                                                        }
                                                                        if (r19 != 0) {
                                                                            r19.close();
                                                                        }
                                                                        str4 = Build.CPU_ABI;
                                                                        if (hashSet.contains(str4)) {
                                                                            str7 = str + WVNativeCallbackUtil.SEPERATER + str4;
                                                                            str9 = Build.CPU_ABI2;
                                                                            if (hashSet.contains(str9)) {
                                                                                str14 = str + WVNativeCallbackUtil.SEPERATER + str9;
                                                                            }
                                                                            str8 = str14;
                                                                            if (str8 != null) {
                                                                                str5 = str7 + u15.f19942b + str8 + u15.f19942b + System.getProperty("java.library.path");
                                                                            } else {
                                                                                str5 = str7 + u15.f19942b + System.getProperty("java.library.path");
                                                                            }
                                                                        } else {
                                                                            str6 = Build.CPU_ABI2;
                                                                            if (hashSet.contains(str6)) {
                                                                                str5 = str + WVNativeCallbackUtil.SEPERATER + str6 + u15.f19942b + System.getProperty("java.library.path");
                                                                            } else {
                                                                                str5 = str3;
                                                                            }
                                                                        }
                                                                        if (TextUtils.isEmpty(str5)) {
                                                                            ?? r4 = r21;
                                                                            if (!"armeabi-v7a".equals(Build.CPU_ABI)) {
                                                                                str5 = str + "/armeabi:" + System.getProperty("java.library.path");
                                                                            } else {
                                                                                str5 = str + "/armeabi:" + System.getProperty("java.library.path");
                                                                            }
                                                                        }
                                                                        sVar.h = str5;
                                                                        sVar.n = sb.toString();
                                                                        String absolutePath4 = new File(str2, "apkDex").getAbsolutePath();
                                                                        dl.c(absolutePath4);
                                                                        e(absolutePath4);
                                                                        strA = dk.a(d);
                                                                        if (TextUtils.isEmpty(sVar.n)) {
                                                                            if (sVar.c.endsWith("v7")) {
                                                                            }
                                                                            dm.a(getClass().getClassLoader(), new File(str + WVNativeCallbackUtil.SEPERATER + strA));
                                                                            Engine.soPath = str + WVNativeCallbackUtil.SEPERATER + strA;
                                                                            Engine.soVersion = sVar.d;
                                                                            Engine.getInstance(d);
                                                                        }
                                                                    } catch (FileNotFoundException | ZipException unused12) {
                                                                        r11 = zipFile4;
                                                                        r19 = fileOutputStream;
                                                                        r21 = r22;
                                                                        a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                                                                        if (r11 != 0) {
                                                                            r11.close();
                                                                        }
                                                                        if (inputStream != null) {
                                                                            inputStream.close();
                                                                        }
                                                                        if (r19 != 0) {
                                                                            r19.close();
                                                                        }
                                                                        str4 = Build.CPU_ABI;
                                                                        if (hashSet.contains(str4)) {
                                                                            str7 = str + WVNativeCallbackUtil.SEPERATER + str4;
                                                                            str9 = Build.CPU_ABI2;
                                                                            if (hashSet.contains(str9)) {
                                                                                str14 = str + WVNativeCallbackUtil.SEPERATER + str9;
                                                                            }
                                                                            str8 = str14;
                                                                            if (str8 != null) {
                                                                                str5 = str7 + u15.f19942b + str8 + u15.f19942b + System.getProperty("java.library.path");
                                                                            } else {
                                                                                str5 = str7 + u15.f19942b + System.getProperty("java.library.path");
                                                                            }
                                                                        } else {
                                                                            str6 = Build.CPU_ABI2;
                                                                            if (hashSet.contains(str6)) {
                                                                                str5 = str + WVNativeCallbackUtil.SEPERATER + str6 + u15.f19942b + System.getProperty("java.library.path");
                                                                            } else {
                                                                                str5 = str3;
                                                                            }
                                                                        }
                                                                        if (TextUtils.isEmpty(str5)) {
                                                                            ?? r5 = r21;
                                                                            if (!"armeabi-v7a".equals(Build.CPU_ABI)) {
                                                                                str5 = str + "/armeabi:" + System.getProperty("java.library.path");
                                                                            } else {
                                                                                str5 = str + "/armeabi:" + System.getProperty("java.library.path");
                                                                            }
                                                                        }
                                                                        sVar.h = str5;
                                                                        sVar.n = sb.toString();
                                                                        String absolutePath5 = new File(str2, "apkDex").getAbsolutePath();
                                                                        dl.c(absolutePath5);
                                                                        e(absolutePath5);
                                                                        strA = dk.a(d);
                                                                        if (TextUtils.isEmpty(sVar.n)) {
                                                                            if (sVar.c.endsWith("v7")) {
                                                                            }
                                                                            dm.a(getClass().getClassLoader(), new File(str + WVNativeCallbackUtil.SEPERATER + strA));
                                                                            Engine.soPath = str + WVNativeCallbackUtil.SEPERATER + strA;
                                                                            Engine.soVersion = sVar.d;
                                                                            Engine.getInstance(d);
                                                                        }
                                                                    } catch (IOException unused13) {
                                                                        r11 = zipFile4;
                                                                        r19 = fileOutputStream;
                                                                        r21 = r22;
                                                                        a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                                                                        if (r11 != 0) {
                                                                            r11.close();
                                                                        }
                                                                        if (inputStream != null) {
                                                                            inputStream.close();
                                                                        }
                                                                        if (r19 != 0) {
                                                                            r19.close();
                                                                        }
                                                                        str4 = Build.CPU_ABI;
                                                                        if (hashSet.contains(str4)) {
                                                                            str7 = str + WVNativeCallbackUtil.SEPERATER + str4;
                                                                            str9 = Build.CPU_ABI2;
                                                                            if (hashSet.contains(str9)) {
                                                                                str14 = str + WVNativeCallbackUtil.SEPERATER + str9;
                                                                            }
                                                                            str8 = str14;
                                                                            if (str8 != null) {
                                                                                str5 = str7 + u15.f19942b + str8 + u15.f19942b + System.getProperty("java.library.path");
                                                                            } else {
                                                                                str5 = str7 + u15.f19942b + System.getProperty("java.library.path");
                                                                            }
                                                                        } else {
                                                                            str6 = Build.CPU_ABI2;
                                                                            if (hashSet.contains(str6)) {
                                                                                str5 = str + WVNativeCallbackUtil.SEPERATER + str6 + u15.f19942b + System.getProperty("java.library.path");
                                                                            } else {
                                                                                str5 = str3;
                                                                            }
                                                                        }
                                                                        if (TextUtils.isEmpty(str5)) {
                                                                            ?? r6 = r21;
                                                                            if (!"armeabi-v7a".equals(Build.CPU_ABI)) {
                                                                                str5 = str + "/armeabi:" + System.getProperty("java.library.path");
                                                                            } else {
                                                                                str5 = str + "/armeabi:" + System.getProperty("java.library.path");
                                                                            }
                                                                        }
                                                                        sVar.h = str5;
                                                                        sVar.n = sb.toString();
                                                                        String absolutePath6 = new File(str2, "apkDex").getAbsolutePath();
                                                                        dl.c(absolutePath6);
                                                                        e(absolutePath6);
                                                                        strA = dk.a(d);
                                                                        if (TextUtils.isEmpty(sVar.n)) {
                                                                            if (sVar.c.endsWith("v7")) {
                                                                            }
                                                                            dm.a(getClass().getClassLoader(), new File(str + WVNativeCallbackUtil.SEPERATER + strA));
                                                                            Engine.soPath = str + WVNativeCallbackUtil.SEPERATER + strA;
                                                                            Engine.soVersion = sVar.d;
                                                                            Engine.getInstance(d);
                                                                        }
                                                                    } catch (Throwable th) {
                                                                        th = th;
                                                                        r16 = zipFile4;
                                                                        r18 = fileOutputStream;
                                                                        if (r16 != 0) {
                                                                            r16.close();
                                                                        }
                                                                        if (inputStream != null) {
                                                                            inputStream.close();
                                                                        }
                                                                        if (r18 != 0) {
                                                                            r18.close();
                                                                        }
                                                                        throw th;
                                                                    }
                                                                } catch (EOFException unused14) {
                                                                    inputStream = inputStream2;
                                                                } catch (FileNotFoundException | ZipException unused15) {
                                                                    inputStream = inputStream2;
                                                                } catch (IOException unused16) {
                                                                    inputStream = inputStream2;
                                                                } catch (Throwable th2) {
                                                                    th = th2;
                                                                    inputStream = inputStream2;
                                                                }
                                                            }
                                                            inputStream = inputStream2;
                                                            dl.a(string, Boolean.TRUE);
                                                            r19 = fileOutputStream;
                                                            r11 = r22;
                                                        } catch (EOFException unused17) {
                                                            inputStream = inputStream2;
                                                            r11 = zipFile4;
                                                            r19 = r19;
                                                            r21 = r22;
                                                            a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                                                            if (r11 != 0) {
                                                                r11.close();
                                                            }
                                                            if (inputStream != null) {
                                                                inputStream.close();
                                                            }
                                                            if (r19 != 0) {
                                                                r19.close();
                                                            }
                                                            str4 = Build.CPU_ABI;
                                                            if (hashSet.contains(str4)) {
                                                                str7 = str + WVNativeCallbackUtil.SEPERATER + str4;
                                                                str9 = Build.CPU_ABI2;
                                                                if (hashSet.contains(str9)) {
                                                                    str14 = str + WVNativeCallbackUtil.SEPERATER + str9;
                                                                }
                                                                str8 = str14;
                                                                if (str8 != null) {
                                                                    str5 = str7 + u15.f19942b + str8 + u15.f19942b + System.getProperty("java.library.path");
                                                                } else {
                                                                    str5 = str7 + u15.f19942b + System.getProperty("java.library.path");
                                                                }
                                                            } else {
                                                                str6 = Build.CPU_ABI2;
                                                                if (hashSet.contains(str6)) {
                                                                    str5 = str + WVNativeCallbackUtil.SEPERATER + str6 + u15.f19942b + System.getProperty("java.library.path");
                                                                } else {
                                                                    str5 = str3;
                                                                }
                                                            }
                                                            if (TextUtils.isEmpty(str5)) {
                                                                ?? r7 = r21;
                                                                if (!"armeabi-v7a".equals(Build.CPU_ABI)) {
                                                                    str5 = str + "/armeabi:" + System.getProperty("java.library.path");
                                                                } else {
                                                                    str5 = str + "/armeabi:" + System.getProperty("java.library.path");
                                                                }
                                                            }
                                                            sVar.h = str5;
                                                            sVar.n = sb.toString();
                                                            String absolutePath7 = new File(str2, "apkDex").getAbsolutePath();
                                                            dl.c(absolutePath7);
                                                            e(absolutePath7);
                                                            strA = dk.a(d);
                                                            if (TextUtils.isEmpty(sVar.n)) {
                                                                if (sVar.c.endsWith("v7")) {
                                                                }
                                                                dm.a(getClass().getClassLoader(), new File(str + WVNativeCallbackUtil.SEPERATER + strA));
                                                                Engine.soPath = str + WVNativeCallbackUtil.SEPERATER + strA;
                                                                Engine.soVersion = sVar.d;
                                                                Engine.getInstance(d);
                                                            }
                                                        } catch (FileNotFoundException | ZipException unused18) {
                                                            inputStream = inputStream2;
                                                            r11 = zipFile4;
                                                            r19 = r19;
                                                            r21 = r22;
                                                            a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                                                            if (r11 != 0) {
                                                                r11.close();
                                                            }
                                                            if (inputStream != null) {
                                                                inputStream.close();
                                                            }
                                                            if (r19 != 0) {
                                                                r19.close();
                                                            }
                                                            str4 = Build.CPU_ABI;
                                                            if (hashSet.contains(str4)) {
                                                                str7 = str + WVNativeCallbackUtil.SEPERATER + str4;
                                                                str9 = Build.CPU_ABI2;
                                                                if (hashSet.contains(str9)) {
                                                                    str14 = str + WVNativeCallbackUtil.SEPERATER + str9;
                                                                }
                                                                str8 = str14;
                                                                if (str8 != null) {
                                                                    str5 = str7 + u15.f19942b + str8 + u15.f19942b + System.getProperty("java.library.path");
                                                                } else {
                                                                    str5 = str7 + u15.f19942b + System.getProperty("java.library.path");
                                                                }
                                                            } else {
                                                                str6 = Build.CPU_ABI2;
                                                                if (hashSet.contains(str6)) {
                                                                    str5 = str + WVNativeCallbackUtil.SEPERATER + str6 + u15.f19942b + System.getProperty("java.library.path");
                                                                } else {
                                                                    str5 = str3;
                                                                }
                                                            }
                                                            if (TextUtils.isEmpty(str5)) {
                                                                ?? r8 = r21;
                                                                if (!"armeabi-v7a".equals(Build.CPU_ABI)) {
                                                                    str5 = str + "/armeabi:" + System.getProperty("java.library.path");
                                                                } else {
                                                                    str5 = str + "/armeabi:" + System.getProperty("java.library.path");
                                                                }
                                                            }
                                                            sVar.h = str5;
                                                            sVar.n = sb.toString();
                                                            String absolutePath8 = new File(str2, "apkDex").getAbsolutePath();
                                                            dl.c(absolutePath8);
                                                            e(absolutePath8);
                                                            strA = dk.a(d);
                                                            if (TextUtils.isEmpty(sVar.n)) {
                                                                if (sVar.c.endsWith("v7")) {
                                                                }
                                                                dm.a(getClass().getClassLoader(), new File(str + WVNativeCallbackUtil.SEPERATER + strA));
                                                                Engine.soPath = str + WVNativeCallbackUtil.SEPERATER + strA;
                                                                Engine.soVersion = sVar.d;
                                                                Engine.getInstance(d);
                                                            }
                                                        } catch (IOException unused19) {
                                                            inputStream = inputStream2;
                                                            r11 = zipFile4;
                                                            r19 = r19;
                                                            r21 = r22;
                                                            a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                                                            if (r11 != 0) {
                                                                r11.close();
                                                            }
                                                            if (inputStream != null) {
                                                                inputStream.close();
                                                            }
                                                            if (r19 != 0) {
                                                                r19.close();
                                                            }
                                                            str4 = Build.CPU_ABI;
                                                            if (hashSet.contains(str4)) {
                                                                str7 = str + WVNativeCallbackUtil.SEPERATER + str4;
                                                                str9 = Build.CPU_ABI2;
                                                                if (hashSet.contains(str9)) {
                                                                    str14 = str + WVNativeCallbackUtil.SEPERATER + str9;
                                                                }
                                                                str8 = str14;
                                                                if (str8 != null) {
                                                                    str5 = str7 + u15.f19942b + str8 + u15.f19942b + System.getProperty("java.library.path");
                                                                } else {
                                                                    str5 = str7 + u15.f19942b + System.getProperty("java.library.path");
                                                                }
                                                            } else {
                                                                str6 = Build.CPU_ABI2;
                                                                if (hashSet.contains(str6)) {
                                                                    str5 = str + WVNativeCallbackUtil.SEPERATER + str6 + u15.f19942b + System.getProperty("java.library.path");
                                                                } else {
                                                                    str5 = str3;
                                                                }
                                                            }
                                                            if (TextUtils.isEmpty(str5)) {
                                                                ?? r9 = r21;
                                                                if (!"armeabi-v7a".equals(Build.CPU_ABI)) {
                                                                    str5 = str + "/armeabi:" + System.getProperty("java.library.path");
                                                                } else {
                                                                    str5 = str + "/armeabi:" + System.getProperty("java.library.path");
                                                                }
                                                            }
                                                            sVar.h = str5;
                                                            sVar.n = sb.toString();
                                                            String absolutePath9 = new File(str2, "apkDex").getAbsolutePath();
                                                            dl.c(absolutePath9);
                                                            e(absolutePath9);
                                                            strA = dk.a(d);
                                                            if (TextUtils.isEmpty(sVar.n)) {
                                                                if (sVar.c.endsWith("v7")) {
                                                                }
                                                                dm.a(getClass().getClassLoader(), new File(str + WVNativeCallbackUtil.SEPERATER + strA));
                                                                Engine.soPath = str + WVNativeCallbackUtil.SEPERATER + strA;
                                                                Engine.soVersion = sVar.d;
                                                                Engine.getInstance(d);
                                                            }
                                                        } catch (Throwable th3) {
                                                            th = th3;
                                                            inputStream = inputStream2;
                                                            r16 = zipFile4;
                                                            r18 = r19;
                                                            if (r16 != 0) {
                                                                r16.close();
                                                            }
                                                            if (inputStream != null) {
                                                                inputStream.close();
                                                            }
                                                            if (r18 != 0) {
                                                                r18.close();
                                                            }
                                                            throw th;
                                                        }
                                                    } catch (FileNotFoundException | ZipException unused20) {
                                                    }
                                                } catch (EOFException unused21) {
                                                } catch (IOException unused22) {
                                                }
                                            }
                                            try {
                                                if (name.endsWith(".dex") && !zipEntryNextElement.isDirectory() && z2) {
                                                    String str16 = sVar.m;
                                                    e(str16);
                                                    file = new File(str16, sVar.f40139a + c49.f40900a + sVar.d + ".dex");
                                                    try {
                                                        InputStream inputStream3 = zipFile4.getInputStream(zipEntryNextElement);
                                                        try {
                                                            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                                                            while (true) {
                                                                try {
                                                                    int i2 = inputStream3.read(bArr);
                                                                    if (i2 <= 0) {
                                                                        break;
                                                                    }
                                                                    try {
                                                                        fileOutputStream2.write(bArr, 0, i2);
                                                                    } catch (Throwable unused23) {
                                                                        inputStream = inputStream3;
                                                                        r19 = fileOutputStream2;
                                                                        if (file != null && file.exists()) {
                                                                            file.delete();
                                                                        }
                                                                        enumerationEntries = enumeration;
                                                                        r11 = r11;
                                                                        str13 = str3;
                                                                        str12 = str12;
                                                                        r19 = r19;
                                                                    }
                                                                } catch (Throwable unused24) {
                                                                }
                                                            }
                                                            fileOutputStream2.close();
                                                            inputStream3.close();
                                                            sb.append(file.getAbsolutePath());
                                                            dl.a(sb.toString(), Boolean.TRUE);
                                                            inputStream = inputStream3;
                                                            r19 = fileOutputStream2;
                                                        } catch (Throwable unused25) {
                                                            inputStream = inputStream3;
                                                            r19 = r19;
                                                        }
                                                    } catch (Throwable unused26) {
                                                        r19 = r19;
                                                    }
                                                }
                                            } catch (Throwable unused27) {
                                                file = null;
                                                r19 = r19;
                                            }
                                            enumerationEntries = enumeration;
                                            r11 = r11;
                                            str13 = str3;
                                            str12 = str12;
                                            r19 = r19;
                                        }
                                        enumerationEntries = enumeration;
                                        r11 = r11;
                                        str13 = str3;
                                        str12 = str12;
                                        r19 = r19;
                                    } catch (FileNotFoundException | ZipException unused28) {
                                        r22 = r11;
                                        str3 = str13;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                }
                            } catch (EOFException unused29) {
                                r22 = r11;
                                str3 = str13;
                            } catch (IOException unused30) {
                                r22 = r11;
                                str3 = str13;
                            }
                        }
                        r21 = r11;
                        str3 = str13;
                        zipFile4.close();
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (EOFException unused31) {
                        obj3 = "armeabi";
                        str3 = "";
                        zipFile3 = zipFile4;
                        inputStream = null;
                        r19 = inputStream;
                        r11 = zipFile3;
                        r21 = obj3;
                        a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                        if (r11 != 0) {
                            r11.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (r19 != 0) {
                            r19.close();
                        }
                        str4 = Build.CPU_ABI;
                        if (hashSet.contains(str4)) {
                            str7 = str + WVNativeCallbackUtil.SEPERATER + str4;
                            str9 = Build.CPU_ABI2;
                            if (hashSet.contains(str9)) {
                                str14 = str + WVNativeCallbackUtil.SEPERATER + str9;
                            }
                            str8 = str14;
                            if (str8 != null) {
                                str5 = str7 + u15.f19942b + str8 + u15.f19942b + System.getProperty("java.library.path");
                            } else {
                                str5 = str7 + u15.f19942b + System.getProperty("java.library.path");
                            }
                        } else {
                            str6 = Build.CPU_ABI2;
                            if (hashSet.contains(str6)) {
                                str5 = str + WVNativeCallbackUtil.SEPERATER + str6 + u15.f19942b + System.getProperty("java.library.path");
                            } else {
                                str5 = str3;
                            }
                        }
                        if (TextUtils.isEmpty(str5)) {
                            ?? r10 = r21;
                            if (!"armeabi-v7a".equals(Build.CPU_ABI)) {
                                str5 = str + "/armeabi:" + System.getProperty("java.library.path");
                            } else {
                                str5 = str + "/armeabi:" + System.getProperty("java.library.path");
                            }
                        }
                        sVar.h = str5;
                        sVar.n = sb.toString();
                        String absolutePath10 = new File(str2, "apkDex").getAbsolutePath();
                        dl.c(absolutePath10);
                        e(absolutePath10);
                        strA = dk.a(d);
                        if (TextUtils.isEmpty(sVar.n)) {
                            if (sVar.c.endsWith("v7")) {
                            }
                            dm.a(getClass().getClassLoader(), new File(str + WVNativeCallbackUtil.SEPERATER + strA));
                            Engine.soPath = str + WVNativeCallbackUtil.SEPERATER + strA;
                            Engine.soVersion = sVar.d;
                            Engine.getInstance(d);
                        }
                    } catch (FileNotFoundException | ZipException unused32) {
                        obj2 = "armeabi";
                        str3 = "";
                        zipFile2 = zipFile4;
                        inputStream = null;
                        r19 = inputStream;
                        r11 = zipFile2;
                        r21 = obj2;
                        a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                        if (r11 != 0) {
                            r11.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (r19 != 0) {
                            r19.close();
                        }
                        str4 = Build.CPU_ABI;
                        if (hashSet.contains(str4)) {
                            str7 = str + WVNativeCallbackUtil.SEPERATER + str4;
                            str9 = Build.CPU_ABI2;
                            if (hashSet.contains(str9)) {
                                str14 = str + WVNativeCallbackUtil.SEPERATER + str9;
                            }
                            str8 = str14;
                            if (str8 != null) {
                                str5 = str7 + u15.f19942b + str8 + u15.f19942b + System.getProperty("java.library.path");
                            } else {
                                str5 = str7 + u15.f19942b + System.getProperty("java.library.path");
                            }
                        } else {
                            str6 = Build.CPU_ABI2;
                            if (hashSet.contains(str6)) {
                                str5 = str + WVNativeCallbackUtil.SEPERATER + str6 + u15.f19942b + System.getProperty("java.library.path");
                            } else {
                                str5 = str3;
                            }
                        }
                        if (TextUtils.isEmpty(str5)) {
                            ?? r12 = r21;
                            if (!"armeabi-v7a".equals(Build.CPU_ABI)) {
                                str5 = str + "/armeabi:" + System.getProperty("java.library.path");
                            } else {
                                str5 = str + "/armeabi:" + System.getProperty("java.library.path");
                            }
                        }
                        sVar.h = str5;
                        sVar.n = sb.toString();
                        String absolutePath11 = new File(str2, "apkDex").getAbsolutePath();
                        dl.c(absolutePath11);
                        e(absolutePath11);
                        strA = dk.a(d);
                        if (TextUtils.isEmpty(sVar.n)) {
                            if (sVar.c.endsWith("v7")) {
                            }
                            dm.a(getClass().getClassLoader(), new File(str + WVNativeCallbackUtil.SEPERATER + strA));
                            Engine.soPath = str + WVNativeCallbackUtil.SEPERATER + strA;
                            Engine.soVersion = sVar.d;
                            Engine.getInstance(d);
                        }
                    } catch (IOException unused33) {
                        obj = "armeabi";
                        str3 = "";
                        zipFile = zipFile4;
                        inputStream = null;
                        r19 = inputStream;
                        r11 = zipFile;
                        r21 = obj;
                        a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                        if (r11 != 0) {
                            r11.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (r19 != 0) {
                            r19.close();
                        }
                        str4 = Build.CPU_ABI;
                        if (hashSet.contains(str4)) {
                            str7 = str + WVNativeCallbackUtil.SEPERATER + str4;
                            str9 = Build.CPU_ABI2;
                            if (hashSet.contains(str9)) {
                                str14 = str + WVNativeCallbackUtil.SEPERATER + str9;
                            }
                            str8 = str14;
                            if (str8 != null) {
                                str5 = str7 + u15.f19942b + str8 + u15.f19942b + System.getProperty("java.library.path");
                            } else {
                                str5 = str7 + u15.f19942b + System.getProperty("java.library.path");
                            }
                        } else {
                            str6 = Build.CPU_ABI2;
                            if (hashSet.contains(str6)) {
                                str5 = str + WVNativeCallbackUtil.SEPERATER + str6 + u15.f19942b + System.getProperty("java.library.path");
                            } else {
                                str5 = str3;
                            }
                        }
                        if (TextUtils.isEmpty(str5)) {
                            ?? r13 = r21;
                            if (!"armeabi-v7a".equals(Build.CPU_ABI)) {
                                str5 = str + "/armeabi:" + System.getProperty("java.library.path");
                            } else {
                                str5 = str + "/armeabi:" + System.getProperty("java.library.path");
                            }
                        }
                        sVar.h = str5;
                        sVar.n = sb.toString();
                        String absolutePath12 = new File(str2, "apkDex").getAbsolutePath();
                        dl.c(absolutePath12);
                        e(absolutePath12);
                        strA = dk.a(d);
                        if (TextUtils.isEmpty(sVar.n)) {
                            if (sVar.c.endsWith("v7")) {
                            }
                            dm.a(getClass().getClassLoader(), new File(str + WVNativeCallbackUtil.SEPERATER + strA));
                            Engine.soPath = str + WVNativeCallbackUtil.SEPERATER + strA;
                            Engine.soVersion = sVar.d;
                            Engine.getInstance(d);
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        inputStream = null;
                        r19 = 0;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    r16 = r11;
                    r18 = r19;
                }
            } catch (IOException e) {
                Object obj4 = "armeabi";
                str3 = "";
                try {
                    throw new FileNotFoundException(e.getMessage() + "--backupFile not exists");
                } catch (EOFException unused34) {
                    zipFile3 = null;
                    inputStream = null;
                    obj3 = obj4;
                    r19 = inputStream;
                    r11 = zipFile3;
                    r21 = obj3;
                    a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                    if (r11 != 0) {
                        r11.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (r19 != 0) {
                        r19.close();
                    }
                    str4 = Build.CPU_ABI;
                    if (hashSet.contains(str4)) {
                        str7 = str + WVNativeCallbackUtil.SEPERATER + str4;
                        str9 = Build.CPU_ABI2;
                        if (hashSet.contains(str9)) {
                            str14 = str + WVNativeCallbackUtil.SEPERATER + str9;
                        }
                        str8 = str14;
                        if (str8 != null) {
                            str5 = str7 + u15.f19942b + str8 + u15.f19942b + System.getProperty("java.library.path");
                        } else {
                            str5 = str7 + u15.f19942b + System.getProperty("java.library.path");
                        }
                    } else {
                        str6 = Build.CPU_ABI2;
                        if (hashSet.contains(str6)) {
                            str5 = str + WVNativeCallbackUtil.SEPERATER + str6 + u15.f19942b + System.getProperty("java.library.path");
                        } else {
                            str5 = str3;
                        }
                    }
                    if (TextUtils.isEmpty(str5)) {
                        ?? r14 = r21;
                        if (!"armeabi-v7a".equals(Build.CPU_ABI)) {
                            str5 = str + "/armeabi:" + System.getProperty("java.library.path");
                        } else {
                            str5 = str + "/armeabi:" + System.getProperty("java.library.path");
                        }
                    }
                    sVar.h = str5;
                    sVar.n = sb.toString();
                    String absolutePath13 = new File(str2, "apkDex").getAbsolutePath();
                    dl.c(absolutePath13);
                    e(absolutePath13);
                    strA = dk.a(d);
                    if (TextUtils.isEmpty(sVar.n)) {
                        if (sVar.c.endsWith("v7")) {
                        }
                        dm.a(getClass().getClassLoader(), new File(str + WVNativeCallbackUtil.SEPERATER + strA));
                        Engine.soPath = str + WVNativeCallbackUtil.SEPERATER + strA;
                        Engine.soVersion = sVar.d;
                        Engine.getInstance(d);
                    }
                } catch (FileNotFoundException | ZipException unused35) {
                    zipFile2 = null;
                    inputStream = null;
                    obj2 = obj4;
                    r19 = inputStream;
                    r11 = zipFile2;
                    r21 = obj2;
                    a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                    if (r11 != 0) {
                        r11.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (r19 != 0) {
                        r19.close();
                    }
                    str4 = Build.CPU_ABI;
                    if (hashSet.contains(str4)) {
                        str7 = str + WVNativeCallbackUtil.SEPERATER + str4;
                        str9 = Build.CPU_ABI2;
                        if (hashSet.contains(str9)) {
                            str14 = str + WVNativeCallbackUtil.SEPERATER + str9;
                        }
                        str8 = str14;
                        if (str8 != null) {
                            str5 = str7 + u15.f19942b + str8 + u15.f19942b + System.getProperty("java.library.path");
                        } else {
                            str5 = str7 + u15.f19942b + System.getProperty("java.library.path");
                        }
                    } else {
                        str6 = Build.CPU_ABI2;
                        if (hashSet.contains(str6)) {
                            str5 = str + WVNativeCallbackUtil.SEPERATER + str6 + u15.f19942b + System.getProperty("java.library.path");
                        } else {
                            str5 = str3;
                        }
                    }
                    if (TextUtils.isEmpty(str5)) {
                        ?? r15 = r21;
                        if (!"armeabi-v7a".equals(Build.CPU_ABI)) {
                            str5 = str + "/armeabi:" + System.getProperty("java.library.path");
                        } else {
                            str5 = str + "/armeabi:" + System.getProperty("java.library.path");
                        }
                    }
                    sVar.h = str5;
                    sVar.n = sb.toString();
                    String absolutePath14 = new File(str2, "apkDex").getAbsolutePath();
                    dl.c(absolutePath14);
                    e(absolutePath14);
                    strA = dk.a(d);
                    if (TextUtils.isEmpty(sVar.n)) {
                        if (sVar.c.endsWith("v7")) {
                        }
                        dm.a(getClass().getClassLoader(), new File(str + WVNativeCallbackUtil.SEPERATER + strA));
                        Engine.soPath = str + WVNativeCallbackUtil.SEPERATER + strA;
                        Engine.soVersion = sVar.d;
                        Engine.getInstance(d);
                    }
                } catch (IOException unused36) {
                    zipFile = null;
                    inputStream = null;
                    obj = obj4;
                    r19 = inputStream;
                    r11 = zipFile;
                    r21 = obj;
                    a(sVar, str, strReplace, hashSet, bArr, sb, z2);
                    if (r11 != 0) {
                        r11.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (r19 != 0) {
                        r19.close();
                    }
                    str4 = Build.CPU_ABI;
                    if (hashSet.contains(str4)) {
                        str7 = str + WVNativeCallbackUtil.SEPERATER + str4;
                        str9 = Build.CPU_ABI2;
                        if (hashSet.contains(str9)) {
                            str14 = str + WVNativeCallbackUtil.SEPERATER + str9;
                        }
                        str8 = str14;
                        if (str8 != null) {
                            str5 = str7 + u15.f19942b + str8 + u15.f19942b + System.getProperty("java.library.path");
                        } else {
                            str5 = str7 + u15.f19942b + System.getProperty("java.library.path");
                        }
                    } else {
                        str6 = Build.CPU_ABI2;
                        if (hashSet.contains(str6)) {
                            str5 = str + WVNativeCallbackUtil.SEPERATER + str6 + u15.f19942b + System.getProperty("java.library.path");
                        } else {
                            str5 = str3;
                        }
                    }
                    if (TextUtils.isEmpty(str5)) {
                        ?? r17 = r21;
                        if (!"armeabi-v7a".equals(Build.CPU_ABI)) {
                            str5 = str + "/armeabi:" + System.getProperty("java.library.path");
                        } else {
                            str5 = str + "/armeabi:" + System.getProperty("java.library.path");
                        }
                    }
                    sVar.h = str5;
                    sVar.n = sb.toString();
                    String absolutePath15 = new File(str2, "apkDex").getAbsolutePath();
                    dl.c(absolutePath15);
                    e(absolutePath15);
                    strA = dk.a(d);
                    if (TextUtils.isEmpty(sVar.n)) {
                        if (sVar.c.endsWith("v7")) {
                        }
                        dm.a(getClass().getClassLoader(), new File(str + WVNativeCallbackUtil.SEPERATER + strA));
                        Engine.soPath = str + WVNativeCallbackUtil.SEPERATER + strA;
                        Engine.soVersion = sVar.d;
                        Engine.getInstance(d);
                    }
                }
            }
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
            r18 = 0;
        }
    }

    private void a(s sVar, String str, String str2, HashSet<String> hashSet, byte[] bArr, StringBuilder sb, boolean z) throws Throwable {
        File file;
        String str3;
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(sVar.e));
        FileOutputStream fileOutputStream = null;
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    break;
                }
                String name = nextEntry.getName();
                if (!name.contains("../")) {
                    if (name.startsWith("lib/") && !nextEntry.isDirectory()) {
                        String str4 = Build.CPU_ABI;
                        try {
                            str3 = Build.CPU_ABI2;
                        } catch (Throwable unused) {
                            str3 = null;
                        }
                        if (name.contains(str4) || ((!TextUtils.isEmpty(str3) && name.contains(str3)) || (name.contains("armeabi") && ("armeabi-v7a".equalsIgnoreCase(str4) || (!TextUtils.isEmpty(str3) && "armeabi-v7a".equalsIgnoreCase(str3)))))) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(str);
                            sb2.append(name.substring(3).replace(".so", str2 + ".so"));
                            String string = sb2.toString();
                            String strSubstring = string.substring(0, string.lastIndexOf(47));
                            hashSet.add(strSubstring.substring(strSubstring.lastIndexOf(47) + 1));
                            e(strSubstring);
                            File file2 = new File(string);
                            file2.delete();
                            file2.createNewFile();
                            FileOutputStream fileOutputStream2 = new FileOutputStream(string);
                            while (true) {
                                try {
                                    int i = zipInputStream.read(bArr);
                                    if (i <= 0) {
                                        break;
                                    } else {
                                        fileOutputStream2.write(bArr, 0, i);
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    fileOutputStream = fileOutputStream2;
                                    zipInputStream.close();
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    throw th;
                                }
                            }
                            fileOutputStream2.close();
                            dl.a(string, Boolean.TRUE);
                            fileOutputStream = fileOutputStream2;
                        }
                    }
                    try {
                        if (name.endsWith(".dex") && !nextEntry.isDirectory() && z) {
                            String str5 = sVar.m;
                            e(str5);
                            file = new File(str5, sVar.f40139a + c49.f40900a + sVar.d + ".dex");
                            try {
                                file.delete();
                                file.createNewFile();
                                FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                                while (true) {
                                    try {
                                        int i2 = zipInputStream.read(bArr);
                                        if (i2 <= 0) {
                                            break;
                                        } else {
                                            fileOutputStream3.write(bArr, 0, i2);
                                        }
                                    } catch (Throwable unused2) {
                                        fileOutputStream = fileOutputStream3;
                                        if (file != null && file.exists()) {
                                            file.delete();
                                        }
                                    }
                                }
                                fileOutputStream3.close();
                                if (sb.length() > 0) {
                                    sb.setLength(0);
                                }
                                sb.append(file.getAbsolutePath());
                                dl.a(sb.toString(), Boolean.TRUE);
                                fileOutputStream = fileOutputStream3;
                            } catch (Throwable unused3) {
                            }
                        }
                    } catch (Throwable unused4) {
                        file = null;
                    }
                    zipInputStream.closeEntry();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        zipInputStream.close();
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
    }
}
