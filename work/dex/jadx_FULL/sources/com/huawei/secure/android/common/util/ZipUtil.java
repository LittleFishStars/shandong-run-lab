package com.huawei.secure.android.common.util;

import android.annotation.SuppressLint;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.ipd.dsp.internal.l0.g;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class ZipUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f37768a = "ZipUtil";
    private static final int b = 104857600;
    private static final int c = 100;
    private static final int d = 4096;
    private static final String e = "..";
    private static final String[] f = {"..\\", "../", "./", ".\\.\\", "%00", "..%2F", "..%5C", ".%2F"};

    /* JADX WARN: Code duplicated, block: B:110:0x01b8  */
    @SuppressLint({"NewApi"})
    private static List<File> a(File file, File file2, long j, boolean z, boolean z2) throws Throwable {
        boolean z3;
        ZipFile zipFile;
        ZipFile zipFile2;
        boolean z4;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        ZipFile zipFile3 = null;
        fileOutputStream = null;
        FileOutputStream fileOutputStream = null;
        zipFile3 = null;
        if (file == null || file2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        boolean z5 = true;
        try {
            if (z2) {
                LogsUtil.i(f37768a, "not a utf8 zip file, use gbk open zip file : " + file);
                zipFile = new ZipFile(file, Charset.forName("GBK"));
            } else {
                zipFile = new ZipFile(file);
            }
            ZipFile zipFile4 = zipFile;
            try {
                try {
                    Enumeration<? extends ZipEntry> enumerationEntries = zipFile4.entries();
                    boolean z6 = true;
                    int i = 0;
                    while (true) {
                        try {
                            if (!enumerationEntries.hasMoreElements()) {
                                z4 = z6;
                                break;
                            }
                            try {
                                ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                                String name = zipEntryNextElement.getName();
                                if (!TextUtils.isEmpty(name)) {
                                    String strNormalize = Normalizer.normalize(name, Normalizer.Form.NFKC);
                                    if (e(strNormalize)) {
                                        Log.e(f37768a, "zipPath is a invalid path: " + d(strNormalize));
                                        z4 = false;
                                        break;
                                    }
                                    File file3 = new File(file2, strNormalize.replaceAll("\\\\", WVNativeCallbackUtil.SEPERATER));
                                    if (z) {
                                        try {
                                            if (file3.exists() && file3.isFile()) {
                                                e(file3);
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            zipFile3 = zipFile4;
                                        }
                                    }
                                    arrayList.add(file3);
                                    if (zipEntryNextElement.isDirectory()) {
                                        if (!a(file3)) {
                                            IOUtil.closeSecure(zipFile4);
                                            a(arrayList);
                                            return null;
                                        }
                                    } else {
                                        if (!b(file3)) {
                                            IOUtil.closeSecure(zipFile4);
                                            a(arrayList);
                                            return null;
                                        }
                                        try {
                                            bufferedInputStream = new BufferedInputStream(zipFile4.getInputStream(zipEntryNextElement));
                                            try {
                                                FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
                                                try {
                                                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream2);
                                                    try {
                                                        byte[] bArr = new byte[1024];
                                                        while (true) {
                                                            int i2 = bufferedInputStream.read(bArr);
                                                            if (i2 == -1) {
                                                                zipFile2 = zipFile4;
                                                                z3 = false;
                                                                break;
                                                            }
                                                            i += i2;
                                                            zipFile2 = zipFile4;
                                                            if (i > j) {
                                                                try {
                                                                    Log.e(f37768a, "unzipFileNew: over than top size");
                                                                    z3 = false;
                                                                    z6 = false;
                                                                    break;
                                                                } catch (Throwable th2) {
                                                                    th = th2;
                                                                    fileOutputStream = fileOutputStream2;
                                                                    IOUtil.closeSecure((InputStream) bufferedInputStream);
                                                                    IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                                                                    IOUtil.closeSecure((OutputStream) fileOutputStream);
                                                                    throw th;
                                                                }
                                                            }
                                                            try {
                                                                bufferedOutputStream.write(bArr, 0, i2);
                                                                zipFile4 = zipFile2;
                                                            } catch (Throwable th3) {
                                                                th = th3;
                                                                fileOutputStream = fileOutputStream2;
                                                                IOUtil.closeSecure((InputStream) bufferedInputStream);
                                                                IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                                                                IOUtil.closeSecure((OutputStream) fileOutputStream);
                                                                throw th;
                                                            }
                                                        }
                                                        try {
                                                            IOUtil.closeSecure((InputStream) bufferedInputStream);
                                                            IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                                                            IOUtil.closeSecure((OutputStream) fileOutputStream2);
                                                            zipFile4 = zipFile2;
                                                        } catch (IOException e2) {
                                                            e = e2;
                                                            zipFile3 = zipFile2;
                                                            try {
                                                                Log.e(f37768a, "unzip new IOException : " + e.getMessage());
                                                                IOUtil.closeSecure(zipFile3);
                                                                a(arrayList);
                                                                return arrayList;
                                                            } catch (Throwable th4) {
                                                                th = th4;
                                                            }
                                                        } catch (Throwable th5) {
                                                            th = th5;
                                                            zipFile3 = zipFile2;
                                                            z3 = z6;
                                                            z5 = z3;
                                                            IOUtil.closeSecure(zipFile3);
                                                            if (!z5) {
                                                                a(arrayList);
                                                            }
                                                            throw th;
                                                        }
                                                    } catch (Throwable th6) {
                                                        th = th6;
                                                    }
                                                } catch (Throwable th7) {
                                                    th = th7;
                                                    bufferedOutputStream = null;
                                                }
                                            } catch (Throwable th8) {
                                                th = th8;
                                                bufferedOutputStream = null;
                                            }
                                        } catch (Throwable th9) {
                                            th = th9;
                                            bufferedInputStream = null;
                                            bufferedOutputStream = null;
                                        }
                                    }
                                    th = th;
                                    zipFile3 = zipFile4;
                                    z3 = z6;
                                    z5 = z3;
                                    IOUtil.closeSecure(zipFile3);
                                    if (!z5) {
                                        a(arrayList);
                                    }
                                    throw th;
                                }
                            } catch (IllegalArgumentException e3) {
                                ZipFile zipFile5 = zipFile4;
                                LogsUtil.i(f37768a, "not a utf8 zip file, IllegalArgumentException : " + e3.getMessage());
                                List<File> listA = a(file, file2, j, z, true);
                                IOUtil.closeSecure(zipFile5);
                                if (!z6) {
                                    a(arrayList);
                                }
                                return listA;
                            }
                        } catch (Throwable th10) {
                            th = th10;
                            zipFile2 = zipFile4;
                        }
                    }
                    IOUtil.closeSecure(zipFile4);
                    if (!z4) {
                        a(arrayList);
                    }
                } catch (Throwable th11) {
                    th = th11;
                    zipFile3 = zipFile4;
                    z3 = true;
                }
            } catch (IOException e4) {
                e = e4;
                zipFile2 = zipFile4;
                z3 = false;
            }
        } catch (IOException e5) {
            e = e5;
            z3 = false;
        } catch (Throwable th12) {
            th = th12;
        }
        return arrayList;
    }

    private static boolean b(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!a(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            Log.e(f37768a, "createOrExistsFile IOException ");
            return false;
        }
    }

    private static File c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return b(str);
    }

    private static String d(String str) {
        int iLastIndexOf;
        return (TextUtils.isEmpty(str) || (iLastIndexOf = str.lastIndexOf(File.separator)) == -1) ? str : str.substring(iLastIndexOf + 1);
    }

    private static void e(File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            c(file);
            return;
        }
        if (file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                c(file);
                return;
            }
            for (File file2 : fileArrListFiles) {
                e(file2);
            }
            c(file);
        }
    }

    @Deprecated
    public static boolean unZip(String str, String str2, boolean z) throws SecurityCommonException {
        return unZip(str, str2, g.g, 100, z);
    }

    public static List<File> unZipNew(String str, String str2, boolean z) throws SecurityCommonException {
        return unZipNew(str, str2, g.g, 100, z);
    }

    private static void c(File file) {
        if (file == null || file.delete()) {
            return;
        }
        LogsUtil.e(f37768a, "delete file error");
    }

    /* JADX WARN: Code duplicated, block: B:92:0x015d  */
    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public static boolean unZip(String str, String str2, long j, int i, boolean z) throws Throwable {
        ZipInputStream zipInputStream;
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        int i2;
        FileOutputStream fileOutputStream2;
        FileInputStream fileInputStream;
        boolean z2;
        FileOutputStream fileOutputStream3;
        String strSubstring = str2;
        int i3 = 0;
        if (!a(str, str2, j, i)) {
            return false;
        }
        String str3 = File.separator;
        if (strSubstring.endsWith(str3) && str2.length() > str3.length()) {
            strSubstring = strSubstring.substring(0, str2.length() - str3.length());
        }
        int i4 = 4096;
        byte[] bArr = new byte[4096];
        ArrayList arrayList = new ArrayList();
        FileInputStream fileInputStream2 = null;
        BufferedOutputStream bufferedOutputStream2 = null;
        fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                zipInputStream = new ZipInputStream(new BufferedInputStream(fileInputStream));
                int i5 = 0;
                int i6 = 1;
                fileOutputStream2 = null;
                try {
                    while (true) {
                        try {
                            try {
                                ZipEntry nextEntry = zipInputStream.getNextEntry();
                                if (nextEntry == null) {
                                    i2 = i3;
                                    break;
                                }
                                String strReplaceAll = nextEntry.getName().replaceAll("\\\\", WVNativeCallbackUtil.SEPERATER);
                                File file = new File(strSubstring, strReplaceAll);
                                String strNormalize = Normalizer.normalize(strReplaceAll, Normalizer.Form.NFKC);
                                if (e(strNormalize)) {
                                    Log.e(f37768a, "zipPath is a invalid path: " + d(strNormalize));
                                    i2 = i3;
                                    i6 = i2;
                                    break;
                                }
                                if (z && file.exists() && file.isFile()) {
                                    e(file);
                                }
                                if (nextEntry.isDirectory()) {
                                    d(file);
                                    arrayList.add(file);
                                    i2 = i3;
                                } else {
                                    File parentFile = file.getParentFile();
                                    if (parentFile != null && !parentFile.exists()) {
                                        d(parentFile);
                                    }
                                    fileOutputStream = new FileOutputStream(file);
                                    try {
                                        bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                                        while (true) {
                                            try {
                                                try {
                                                    int i7 = zipInputStream.read(bArr, i3, i4);
                                                    if (i7 == -1) {
                                                        i2 = i3;
                                                        break;
                                                    }
                                                    i5 += i7;
                                                    if (i5 > j) {
                                                        try {
                                                            Log.e(f37768a, "unzip  over than top size");
                                                            i2 = 0;
                                                            i6 = 0;
                                                            break;
                                                        } catch (IOException e2) {
                                                            e = e2;
                                                            fileOutputStream3 = fileOutputStream;
                                                            i2 = 0;
                                                            fileOutputStream = fileOutputStream3;
                                                            fileInputStream2 = fileInputStream;
                                                            LogsUtil.e(f37768a, "Unzip IOException : " + e.getMessage());
                                                            z2 = i2;
                                                            fileInputStream = fileInputStream2;
                                                            bufferedOutputStream2 = bufferedOutputStream;
                                                            fileOutputStream2 = fileOutputStream;
                                                            a(fileInputStream, bufferedOutputStream2, zipInputStream, fileOutputStream2);
                                                            if (z2 == 0) {
                                                                a(arrayList);
                                                            }
                                                            return z2;
                                                        }
                                                    }
                                                    bufferedOutputStream.write(bArr, 0, i7);
                                                    i3 = 0;
                                                    i4 = 4096;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    fileInputStream2 = fileInputStream;
                                                    a(fileInputStream2, bufferedOutputStream, zipInputStream, fileOutputStream);
                                                    throw th;
                                                }
                                            } catch (IOException e3) {
                                                e = e3;
                                                i2 = i3;
                                            }
                                        }
                                        try {
                                            arrayList.add(file);
                                            bufferedOutputStream.flush();
                                            IOUtil.closeSecure((OutputStream) bufferedOutputStream);
                                            IOUtil.closeSecure((OutputStream) fileOutputStream);
                                            bufferedOutputStream2 = bufferedOutputStream;
                                            fileOutputStream2 = fileOutputStream;
                                        } catch (IOException e4) {
                                            e = e4;
                                            fileOutputStream3 = fileOutputStream;
                                            fileOutputStream = fileOutputStream3;
                                            fileInputStream2 = fileInputStream;
                                            LogsUtil.e(f37768a, "Unzip IOException : " + e.getMessage());
                                            z2 = i2;
                                            fileInputStream = fileInputStream2;
                                            bufferedOutputStream2 = bufferedOutputStream;
                                            fileOutputStream2 = fileOutputStream;
                                            a(fileInputStream, bufferedOutputStream2, zipInputStream, fileOutputStream2);
                                            if (z2 == 0) {
                                                a(arrayList);
                                            }
                                            return z2;
                                        }
                                    } catch (IOException e5) {
                                        e = e5;
                                        i2 = i3;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        fileInputStream2 = fileInputStream;
                                        a(fileInputStream2, bufferedOutputStream, zipInputStream, fileOutputStream);
                                        throw th;
                                    }
                                }
                                try {
                                    zipInputStream.closeEntry();
                                    i3 = i2;
                                    i4 = 4096;
                                } catch (IOException e6) {
                                    e = e6;
                                    FileOutputStream fileOutputStream4 = fileOutputStream2;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    fileOutputStream3 = fileOutputStream4;
                                    fileOutputStream = fileOutputStream3;
                                    fileInputStream2 = fileInputStream;
                                    LogsUtil.e(f37768a, "Unzip IOException : " + e.getMessage());
                                    z2 = i2;
                                    fileInputStream = fileInputStream2;
                                    bufferedOutputStream2 = bufferedOutputStream;
                                    fileOutputStream2 = fileOutputStream;
                                    a(fileInputStream, bufferedOutputStream2, zipInputStream, fileOutputStream2);
                                    if (z2 == 0) {
                                        a(arrayList);
                                    }
                                    return z2;
                                }
                                fileOutputStream = fileOutputStream2;
                                bufferedOutputStream = bufferedOutputStream2;
                                fileInputStream2 = fileInputStream;
                                try {
                                    LogsUtil.e(f37768a, "Unzip IOException : " + e.getMessage());
                                    z2 = i2;
                                    fileInputStream = fileInputStream2;
                                    bufferedOutputStream2 = bufferedOutputStream;
                                    fileOutputStream2 = fileOutputStream;
                                    a(fileInputStream, bufferedOutputStream2, zipInputStream, fileOutputStream2);
                                    if (z2 == 0) {
                                        a(arrayList);
                                    }
                                    return z2;
                                } catch (Throwable th3) {
                                    th = th3;
                                    a(fileInputStream2, bufferedOutputStream, zipInputStream, fileOutputStream);
                                    throw th;
                                }
                            } catch (IOException e7) {
                                e = e7;
                                i2 = i3;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            fileOutputStream = fileOutputStream2;
                        }
                    }
                    IOUtil.closeSecure((InputStream) zipInputStream);
                    IOUtil.closeSecure((InputStream) fileInputStream);
                    z2 = i6;
                } catch (IOException e8) {
                    e = e8;
                    fileOutputStream = fileOutputStream2;
                    bufferedOutputStream = bufferedOutputStream2;
                    fileInputStream2 = fileInputStream;
                    LogsUtil.e(f37768a, "Unzip IOException : " + e.getMessage());
                    z2 = i2;
                    fileInputStream = fileInputStream2;
                    bufferedOutputStream2 = bufferedOutputStream;
                    fileOutputStream2 = fileOutputStream;
                }
            } catch (IOException e9) {
                e = e9;
                i2 = 0;
                zipInputStream = null;
                bufferedOutputStream = null;
                fileOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                zipInputStream = null;
                bufferedOutputStream = null;
                fileOutputStream = null;
            }
        } catch (IOException e10) {
            e = e10;
            i2 = 0;
            zipInputStream = null;
            bufferedOutputStream = null;
            fileOutputStream = null;
        } catch (Throwable th6) {
            th = th6;
            zipInputStream = null;
            bufferedOutputStream = null;
            fileOutputStream = null;
        }
        a(fileInputStream, bufferedOutputStream2, zipInputStream, fileOutputStream2);
        if (z2 == 0) {
            a(arrayList);
        }
        return z2;
    }

    public static List<File> unZipNew(String str, String str2, long j, int i, boolean z) throws SecurityCommonException {
        if (!a(str, str2, j, i)) {
            return null;
        }
        String str3 = File.separator;
        if (str2.endsWith(str3) && str2.length() > str3.length()) {
            str2 = str2.substring(0, str2.length() - str3.length());
        }
        return a(c(str), c(str2), j, z, false);
    }

    private static void d(File file) {
        if (file == null || file.exists() || file.mkdirs()) {
            return;
        }
        LogsUtil.e(f37768a, "mkdirs error , files exists or IOException.");
    }

    private static File b(String str) {
        a(str);
        return new File(str);
    }

    private static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e(f37768a, "isContainInvalidStr: name is null");
            return false;
        }
        if (str.equals(e)) {
            return true;
        }
        for (String str2 : f) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    private static void a(String str) {
        if (TextUtils.isEmpty(str) || !e(str)) {
            return;
        }
        Log.e(f37768a, "IllegalArgumentException--path is not a standard path");
        throw new IllegalArgumentException("path is not a standard path");
    }

    private static boolean a(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    @RequiresApi(api = 24)
    private static boolean a(String str, long j, int i, boolean z) {
        ZipFile zipFile;
        ZipEntry zipEntryNextElement;
        ZipFile zipFile2 = null;
        boolean zA = false;
        try {
            try {
                try {
                    if (!z) {
                        zipFile = new ZipFile(str);
                    } else {
                        LogsUtil.i(f37768a, "not a utf8 zip file, use gbk open zip file : " + str);
                        zipFile = new ZipFile(str, Charset.forName("GBK"));
                    }
                    ZipFile zipFile3 = zipFile;
                    Enumeration<? extends ZipEntry> enumerationEntries = zipFile3.entries();
                    long size = 0;
                    int i2 = 0;
                    do {
                        if (enumerationEntries.hasMoreElements()) {
                            try {
                                zipEntryNextElement = enumerationEntries.nextElement();
                                size += zipEntryNextElement.getSize();
                                i2++;
                                if (e(zipEntryNextElement.getName()) || i2 >= i || size > j) {
                                    break;
                                }
                            } catch (IllegalArgumentException e2) {
                                LogsUtil.i(f37768a, "not a utf8 zip file, IllegalArgumentException : " + e2.getMessage());
                                zA = a(str, j, i, true);
                            }
                        } else {
                            zA = true;
                        }
                        zipFile3.close();
                        return zA;
                    } while (zipEntryNextElement.getSize() != -1);
                    LogsUtil.e(f37768a, "File name is invalid or too many files or too big");
                    zipFile3.close();
                } catch (IOException unused) {
                    LogsUtil.e(f37768a, "close zipFile IOException ");
                }
            } catch (IOException e3) {
                LogsUtil.e(f37768a, "not a valid zip file, IOException : " + e3.getMessage());
                if (0 != 0) {
                    zipFile2.close();
                }
            }
            return zA;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    zipFile2.close();
                } catch (IOException unused2) {
                    LogsUtil.e(f37768a, "close zipFile IOException ");
                }
            }
            throw th;
        }
    }

    private static boolean a(String str, String str2, long j, int i) throws SecurityCommonException {
        if (!TextUtils.isEmpty(str) && !e(str)) {
            if (!TextUtils.isEmpty(str2) && !e(str2)) {
                if (a(str, j, i, false)) {
                    return true;
                }
                LogsUtil.e(f37768a, "zip file contains valid chars or too many files");
                throw new SecurityCommonException("unsecure zipfile!");
            }
            LogsUtil.e(f37768a, "target directory is not valid");
            return false;
        }
        LogsUtil.e(f37768a, "zip file is not valid");
        return false;
    }

    private static boolean a(List<File> list) {
        try {
            Iterator<File> it = list.iterator();
            while (it.hasNext()) {
                e(it.next());
            }
            return true;
        } catch (Exception e2) {
            LogsUtil.e(f37768a, "unzip fail delete file failed" + e2.getMessage());
            return false;
        }
    }

    private static void a(FileInputStream fileInputStream, BufferedOutputStream bufferedOutputStream, ZipInputStream zipInputStream, FileOutputStream fileOutputStream) {
        IOUtil.closeSecure((InputStream) fileInputStream);
        IOUtil.closeSecure((OutputStream) bufferedOutputStream);
        IOUtil.closeSecure((InputStream) zipInputStream);
        IOUtil.closeSecure((OutputStream) fileOutputStream);
    }
}
