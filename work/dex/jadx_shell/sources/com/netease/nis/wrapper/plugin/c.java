package com.netease.nis.wrapper.plugin;

import android.content.Context;
import android.os.Build;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/peek/classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String f15a = a.auu.a.c("PQoRHRUBBC0RGxc=");

    private static Boolean a(String str) {
        if (str.contains(a.auu.a.c("YQkdB04SFyNTQA=="))) {
            return true;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        File[] fileArrListFiles = file.listFiles();
        for (File file2 : fileArrListFiles) {
            try {
                byte[] bArr = new byte[5];
                if (new BufferedInputStream(new FileInputStream(file2)).read(bArr, 0, 5) == 5 && bArr[0] == 127 && bArr[1] == 69 && bArr[2] == 76 && bArr[3] == 70) {
                    return bArr[4] == 2;
                }
            } catch (Exception e) {
                e.toString();
            }
        }
        return false;
    }

    public static void a(Context context) {
        Long lValueOf = Long.valueOf(System.currentTimeMillis());
        try {
            String str = context.getFilesDir() + a.auu.a.c("YRERCBEfDCxKGAwDAEs0DAQ=");
            String str2 = context.getFilesDir() + a.auu.a.c("YRERCBEfDCw=");
            String str3 = context.getApplicationInfo().nativeLibraryDir;
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            try {
                a(context.getClassLoader(), file);
            } catch (Throwable th) {
                th.toString();
            }
            if (!a(context, a.auu.a.c("YAsRFgQQOj4EAAYJ"), str2, str, str3)) {
                return;
            }
        } catch (Exception e) {
            e.toString();
        }
        new StringBuilder(a.auu.a.c("KwsQRQ4VRRUADBETEgY6KR0HPFMRJwgRXw==")).append(String.valueOf(System.currentTimeMillis() - lValueOf.longValue()));
    }

    public static void a(ClassLoader classLoader, File file) throws IllegalAccessException, NoSuchFieldException {
        if (!file.exists()) {
            new StringBuilder(a.auu.a.c("JwsHEQAfCQAEAAwXFiknBwYEEwo1LxEcSUEVCiIBERdBVhZuDAdFCB8JKwIVCUE=")).append(file.getAbsolutePath());
            return;
        }
        if (Build.VERSION.SDK_INT >= 25) {
            try {
                f.a(classLoader, file);
                return;
            } catch (Throwable th) {
                String.format(a.auu.a.c("JwsHEQAfCQAEAAwXFiknBwYEEwo1LxEcSUEFV3tFEgQIH0luFhAOW1NAKklUABMBCjxfVEASX0U6Fw1FFRxFKAQYCQMSBiVFAApBJVd9"), Integer.valueOf(Build.VERSION.SDK_INT), th);
                e.a(classLoader, file);
                return;
            }
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (Build.VERSION.SDK_INT >= 14) {
                d.a(classLoader, file);
                return;
            } else {
                g.a(classLoader, file);
                return;
            }
        }
        try {
            e.a(classLoader, file);
        } catch (Throwable th2) {
            String.format(a.auu.a.c("JwsHEQAfCQAEAAwXFiknBwYEEwo1LxEcSUEFV31FEgQIH0luFhAOW1NAKklUABMBCjxfVEASX0U6Fw1FFRxFKAQYCQMSBiVFAApBJVR6"), Integer.valueOf(Build.VERSION.SDK_INT), th2);
            d.a(classLoader, file);
        }
    }

    private static boolean a(Context context, String str, String str2, String str3) throws IOException {
        InputStream inputStreamOpen = context.getAssets().open(str);
        if (inputStreamOpen == null) {
            return false;
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdir();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(new File(str3));
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStreamOpen.read(bArr);
            if (i == -1) {
                fileOutputStream.flush();
                fileOutputStream.close();
                inputStreamOpen.close();
                return true;
            }
            for (int i2 = 0; i2 < i; i2++) {
                bArr[i2] = (byte) (bArr[i2] ^ 127);
            }
            fileOutputStream.write(bArr, 0, i);
        }
    }

    private static boolean a(Context context, String str, String str2, String str3, String str4) {
        long jLastModified = new File(context.getPackageCodePath()).lastModified();
        String str5 = context.getFilesDir() + a.auu.a.c("YRERCBEfDCw=");
        File file = new File(str5 + a.auu.a.c("YQ==") + jLastModified);
        if (file.exists()) {
            return false;
        }
        for (File file2 : new File(str5).listFiles()) {
            if (file2.isFile()) {
                file2.delete();
            }
        }
        try {
            if (a(context, str, str2, str3)) {
                for (int i = 3; i > 0; i--) {
                    if (a(str3, str2, str4)) {
                        file.createNewFile();
                        break;
                    }
                }
                new File(str3).delete();
            }
        } catch (Exception e) {
            e.toString();
        }
        return true;
    }

    public static boolean a(String str, String str2, String str3) {
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            ZipFile zipFile = new ZipFile(str);
            Boolean boolA = a(str3);
            String[] strArrC = c(b(str3));
            for (int i = 0; i < strArrC.length; i++) {
                if (!str3.contains(a.auu.a.c("Nl1C")) && boolA != null && !boolA.booleanValue() && strArrC[i].contains(a.auu.a.c("LxcZU1U="))) {
                    new StringBuilder(a.auu.a.c("JwIaChMWRToNEUU=")).append(strArrC[i]).append(a.auu.a.c("bgMbF0EHDStFGgQVGhMrKR0HExIXN0UdFkEdCjpFQlFBEQw6"));
                } else if (str3.contains(a.auu.a.c("Nl1C")) || boolA == null || !boolA.booleanValue() || strArrC[i].contains(a.auu.a.c("LxcZU1U="))) {
                    new StringBuilder(a.auu.a.c("OwsODBFTFiFF")).append(strArrC[i]);
                    if (a(zipFile, strArrC[i], str2)) {
                        break;
                    }
                } else {
                    new StringBuilder(a.auu.a.c("JwIaChMWRToNEUU=")).append(strArrC[i]).append(a.auu.a.c("bgMbF0EHDStFGgQVGhMrKR0HExIXN0UdFkFFUW4HHRE="));
                }
            }
            zipFile.close();
            return true;
        } catch (Exception e) {
            e.toString();
            return false;
        }
    }

    private static boolean a(ZipFile zipFile, String str, String str2) {
        Exception exc;
        boolean z;
        boolean z2 = false;
        try {
            byte[] bArr = new byte[1024];
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            Method method = Class.forName(a.auu.a.c("JAQCBE8GEScJWh8IA0sUDAQgDwcXNw==")).getMethod(a.auu.a.c("KQAAKwAeAA=="), new Class[0]);
            while (enumerationEntries.hasMoreElements()) {
                ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                String str3 = (String) method.invoke(zipEntryNextElement, new Object[0]);
                if (str3.contains(str + a.auu.a.c("YQ=="))) {
                    try {
                        if (str3.contains("../")) {
                            z2 = true;
                        } else {
                            InputStream inputStream = zipFile.getInputStream(zipEntryNextElement);
                            File file = new File(str2 + File.separator + str3.split(a.auu.a.c("YQ=="))[1]);
                            new File(file.getParent()).mkdirs();
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            while (true) {
                                int i = inputStream.read(bArr);
                                if (i <= 0) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, i);
                            }
                            fileOutputStream.close();
                            inputStream.close();
                            z2 = true;
                        }
                    } catch (Exception e) {
                        exc = e;
                        z = true;
                        exc.toString();
                        return z;
                    }
                }
            }
            if (z2) {
                return z2;
            }
            z = z2;
            return z;
        } catch (Exception e2) {
            exc = e2;
            z = z2;
        }
    }

    private static String b(String str) {
        if (!new File(str).exists()) {
            return a.auu.a.c("OwsfCw4ECw==");
        }
        String strC = a.auu.a.c("YQkdBw8WFisGWhYO");
        if (str.contains(a.auu.a.c("YQkdB04LXXg="))) {
            strC = a.auu.a.c("YQkdBw8WFisGWR1ZRUs9Cg==");
        }
        File file = new File(str + strC);
        byte[] bArr = new byte[24];
        String strC2 = a.auu.a.c("OwsfCw4ECw==");
        try {
            new BufferedInputStream(new FileInputStream(file)).read(bArr, 0, 24);
            int i = bArr[18] < 0 ? (bArr[18] & 127) + 128 : bArr[18];
            if (bArr[4] == 2) {
                if (i == 183) {
                    return a.auu.a.c("LxcZU1VeE3YE");
                }
                return i == 62 ? a.auu.a.c("Nl1COldH") : strC2;
            }
            if (i == 40) {
                return a.auu.a.c("LxcZAAARDA==");
            }
            return i == 3 ? a.auu.a.c("Nl1C") : strC2;
        } catch (Exception e) {
            e.toString();
            return strC2;
        }
    }

    private static void b(Context context) {
        try {
            a(context, a.auu.a.c("IAAHAAIsFS8RFw1T"), context.getFilesDir() + a.auu.a.c("YRERCBEfDCw="), context.getFilesDir() + a.auu.a.c("YRERCBEfDCxKGAwDHQA9ABdLEhw="));
        } catch (Exception e) {
            e.toString();
        }
    }

    private static String[] c(String str) {
        ArrayList arrayList = new ArrayList();
        if (str.equals(a.auu.a.c("LxcZAAARDA=="))) {
            arrayList.add(a.auu.a.c("LxcZAAARDGMTQwQ="));
            arrayList.add(a.auu.a.c("LxcZAAARDA=="));
        } else if (!str.equals(a.auu.a.c("OwsfCw4ECw=="))) {
            arrayList.add(str);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            for (int i = 0; i < Build.SUPPORTED_ABIS.length; i++) {
                arrayList.add(Build.SUPPORTED_ABIS[i]);
            }
        } else {
            String str2 = Build.CPU_ABI;
            String str3 = Build.CPU_ABI2;
            if (!str2.equals(a.auu.a.c("OwsfCw4ECw=="))) {
                arrayList.add(str2);
            }
            if (!str3.equals(a.auu.a.c("OwsfCw4ECw=="))) {
                arrayList.add(str3);
            }
            if (!((String) arrayList.get(arrayList.size() - 1)).equals(a.auu.a.c("LxcZAAARDA=="))) {
                arrayList.add(a.auu.a.c("LxcZAAARDA=="));
            }
        }
        new StringBuilder(a.auu.a.c("OgQGAgQHRQ8nPRZb")).append(arrayList.toString());
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
