package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.aliyun.openapiutil.Client;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class BksUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f37743a = "BksUtil";
    private static final String b = "com.huawei.hwid";
    private static final String c = "com.huawei.hwid";
    private static final String d = "com.huawei.hms";
    private static final String e = "com.huawei.hwid.tv";
    private static final String g = "files/hmsrootcas.bks";
    private static final String h = "4.0.2.300";
    private static final String i = "aegis";
    private static final String j = "hmsrootcas.bks";
    private static final long k = 604800000;
    private static final String l = "last_update_time";
    private static final String m = "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05";
    private static final String n = "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C";
    private static final String o = "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539";
    private static final String q = "";
    private static final String r = "bks_hash";
    private static final Uri f = Uri.parse("content://com.huawei.hwid");
    private static final String[] p = {"B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05", "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539"};

    private BksUtil() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    private static void a(InputStream inputStream, Context context) throws Throwable {
        if (inputStream == null || context == null) {
            return;
        }
        String strA = a(context);
        if (!new File(strA).exists()) {
            a(strA);
        }
        File file = new File(strA, "hmsrootcas.bks");
        if (file.exists()) {
            file.delete();
        }
        ?? r7 = 0;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                e.c(f37743a, "write output stream ");
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                r7 = 2048;
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int i2 = inputStream.read(bArr, 0, 2048);
                        if (i2 == -1) {
                            break;
                        } else {
                            fileOutputStream2.write(bArr, 0, i2);
                        }
                    }
                    d.a((OutputStream) fileOutputStream2);
                } catch (IOException unused) {
                    fileOutputStream = fileOutputStream2;
                    e.b(f37743a, " IOException");
                    d.a((OutputStream) fileOutputStream);
                    r7 = fileOutputStream;
                } catch (Throwable th) {
                    th = th;
                    r7 = fileOutputStream2;
                    d.a((OutputStream) r7);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused2) {
        }
    }

    private static boolean a(int i2) {
        return i2 >= 40002300;
    }

    private static String b(Context context) {
        return a(context) + File.separator + "hmsrootcas.bks";
    }

    private static boolean c(Context context) {
        return new File(a(context) + File.separator + "hmsrootcas.bks").exists();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0116: MOVE (r8 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:59:0x0116 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.OutputStream] */
    public static synchronized InputStream getBksFromTss(Context context) {
        ByteArrayInputStream byteArrayInputStream;
        ?? r2;
        ByteArrayInputStream byteArrayInputStream2;
        InputStream inputStreamOpenInputStream;
        ?? r3;
        boolean zB;
        e.c(f37743a, "get bks from tss begin");
        if (context != null) {
            ContextUtil.setContext(context);
        }
        Context contextUtil = ContextUtil.getInstance();
        ByteArrayInputStream byteArrayInputStream3 = null;
        if (contextUtil == null) {
            e.b(f37743a, "context is null");
            return null;
        }
        if (!b(f.a("com.huawei.hwid")) && !b(f.a("com.huawei.hms"))) {
            e.b(f37743a, "hms version code is too low : " + f.a("com.huawei.hwid"));
            return null;
        }
        boolean zC = c(contextUtil, "com.huawei.hwid");
        boolean z = zC;
        if (!zC && !(zB = b(contextUtil, "com.huawei.hms"))) {
            z = zB;
            e.b(f37743a, "hms sign error");
            return null;
        }
        try {
            z = zB;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                inputStreamOpenInputStream = contextUtil.getContentResolver().openInputStream(Uri.withAppendedPath(f, g));
                try {
                    byte[] bArr = new byte[1024];
                    try {
                        while (true) {
                            int i2 = inputStreamOpenInputStream.read(bArr);
                            if (i2 <= -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i2);
                            e.b(f37743a, "Get bks from HMS_VERSION_CODE exception : No content provider" + e.getMessage());
                            d.a(inputStreamOpenInputStream);
                            d.a((OutputStream) byteArrayOutputStream);
                            d.a((InputStream) byteArrayInputStream3);
                            return getFilesBksIS(contextUtil);
                        }
                        String strA = g.a(r, "", contextUtil);
                        String strB = b(byteArrayOutputStream.toByteArray());
                        if (c(contextUtil) && strA.equals(strB)) {
                            e.c(f37743a, "bks not update");
                        } else {
                            e.c(f37743a, "update bks and sp");
                            a(byteArrayInputStream2, contextUtil);
                            g.b(r, strB, contextUtil);
                        }
                        d.a(inputStreamOpenInputStream);
                        d.a((OutputStream) byteArrayOutputStream);
                        d.a((InputStream) byteArrayInputStream2);
                    } catch (Exception e2) {
                        e = e2;
                        byteArrayInputStream3 = byteArrayInputStream2;
                        e.b(f37743a, "Get bks from HMS_VERSION_CODE exception : No content provider" + e.getMessage());
                        d.a(inputStreamOpenInputStream);
                        d.a((OutputStream) byteArrayOutputStream);
                        d.a((InputStream) byteArrayInputStream3);
                    } catch (Throwable th) {
                        th = th;
                        r3 = byteArrayOutputStream;
                        d.a(inputStreamOpenInputStream);
                        d.a((OutputStream) r3);
                        d.a((InputStream) byteArrayInputStream2);
                        throw th;
                    }
                    byteArrayOutputStream.flush();
                    byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Exception e4) {
                e = e4;
                inputStreamOpenInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                r2 = byteArrayOutputStream;
                byteArrayInputStream2 = null;
                inputStreamOpenInputStream = byteArrayInputStream3;
                r3 = r2;
                d.a(inputStreamOpenInputStream);
                d.a((OutputStream) r3);
                d.a((InputStream) byteArrayInputStream2);
                throw th;
            }
            return getFilesBksIS(contextUtil);
        } catch (Throwable th3) {
            th = th3;
            byteArrayInputStream3 = byteArrayInputStream;
            r2 = z;
        }
    }

    public static InputStream getFilesBksIS(Context context) {
        if (!c(context)) {
            return null;
        }
        e.c(f37743a, "getFilesBksIS ");
        try {
            return new FileInputStream(b(context));
        } catch (FileNotFoundException unused) {
            e.b(f37743a, "FileNotFoundExceptio: ");
            return null;
        }
    }

    private static boolean b(String str) {
        int i2;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        e.c(f37743a, "hms version code is : " + str);
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = h.split("\\.");
        int length = strArrSplit.length;
        int length2 = strArrSplit2.length;
        int iMax = Math.max(length, length2);
        int i3 = 0;
        while (i3 < iMax) {
            if (i3 < length) {
                try {
                    i2 = Integer.parseInt(strArrSplit[i3]);
                } catch (Exception e2) {
                    e.b(f37743a, " exception : " + e2.getMessage());
                    return i3 >= length2;
                }
            } else {
                i2 = 0;
            }
            int i4 = i3 < length2 ? Integer.parseInt(strArrSplit2[i3]) : 0;
            if (i2 < i4) {
                return false;
            }
            if (i2 > i4) {
                return true;
            }
            i3++;
        }
        return true;
    }

    private static boolean c(Context context, String str) {
        byte[] bArrA = a(context, str);
        for (String str2 : p) {
            if (str2.equalsIgnoreCase(c(bArrA))) {
                return true;
            }
        }
        return false;
    }

    private static String c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return a(MessageDigest.getInstance(Client.HASH_SHA256).digest(bArr));
        } catch (NoSuchAlgorithmException e2) {
            Log.e(f37743a, "NoSuchAlgorithmException" + e2.getMessage());
            return "";
        }
    }

    private static boolean b(Context context, String str) {
        return "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539".equalsIgnoreCase(c(a(context, str)));
    }

    private static String b(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Client.HASH_SHA256);
            messageDigest.update(bArr);
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            e.b(f37743a, "inputstraem exception");
            return "";
        }
    }

    private static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        File file = new File(str);
        if (file.exists()) {
            e.e(f37743a, "The directory  has already exists");
            return 1;
        }
        if (file.mkdirs()) {
            e.a(f37743a, "create directory  success");
            return 0;
        }
        e.b(f37743a, "create directory  failed");
        return -1;
    }

    private static String a(Context context) {
        return context.createDeviceProtectedStorageContext().getFilesDir() + File.separator + i;
    }

    private static byte[] a(Context context, String str) {
        PackageInfo packageInfo;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && (packageInfo = packageManager.getPackageInfo(str, 64)) != null) {
                    return packageInfo.signatures[0].toByteArray();
                }
            } catch (PackageManager.NameNotFoundException e2) {
                Log.e(f37743a, "PackageManager.NameNotFoundException : " + e2.getMessage());
            } catch (Exception e3) {
                Log.e(f37743a, "get pm exception : " + e3.getMessage());
            }
            return new byte[0];
        }
        Log.e(f37743a, "packageName is null or context is null");
        return new byte[0];
    }

    private static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }
}
