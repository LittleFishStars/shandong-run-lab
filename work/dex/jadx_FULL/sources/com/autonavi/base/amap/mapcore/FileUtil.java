package com.autonavi.base.amap.mapcore;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.amap.mapcore.tools.GLFileUtil;
import com.zj.adlib.a7b;
import com.zj.adlib.axa;
import com.zj.adlib.bxa;
import com.zj.adlib.zwa;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class FileUtil {
    private static final int BUFFER = 1024;
    private static final String FILE_PATH_ENTRY_BACK = "..";
    private static final String FILE_PATH_ENTRY_SEPARATOR1 = "\\";
    private static final String FILE_PATH_ENTRY_SEPARATOR2 = "%";
    private static final String TAG = "FileUtil";
    private static final char UNIX_SEPARATOR = '/';
    private static final char WINDOWS_SEPARATOR = '\\';

    public static class UnZipFileBrake {
        public boolean mIsAborted = false;
    }

    public interface ZipCompressProgressListener {
        void onFinishProgress(long j);
    }

    public static boolean checkCanWrite(File file) {
        if (file == null || !file.canWrite()) {
            return false;
        }
        File file2 = new File(file, "amap.tmp");
        try {
            file2.createNewFile();
            if (!file2.exists()) {
                return false;
            }
            try {
                file2.delete();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static byte[] compress(String str, String str2) throws Throwable {
        GZIPOutputStream gZIPOutputStream = null;
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream2.write(str.getBytes(str2));
                    gZIPOutputStream2.close();
                    safelyCloseFile(gZIPOutputStream2);
                } catch (IOException e) {
                    e = e;
                    gZIPOutputStream = gZIPOutputStream2;
                    Log.e("gzip compress error.", e.getMessage());
                    safelyCloseFile(gZIPOutputStream);
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    safelyCloseFile(gZIPOutputStream);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void createNoMediaFileIfNotExist(String str) {
    }

    public static void decompress(InputStream inputStream, String str) throws Exception {
        decompress(inputStream, str, 0L, null);
    }

    private static int decompressFile(File file, ZipInputStream zipInputStream, long j, long j2, ZipCompressProgressListener zipCompressProgressListener, UnZipFileBrake unZipFileBrake) throws Exception {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        byte[] bArr = new byte[1024];
        int i = 0;
        while (true) {
            int i2 = zipInputStream.read(bArr, 0, 1024);
            if (i2 == -1) {
                bufferedOutputStream.close();
                return i;
            }
            if (unZipFileBrake != null && unZipFileBrake.mIsAborted) {
                bufferedOutputStream.close();
                return i;
            }
            bufferedOutputStream.write(bArr, 0, i2);
            i += i2;
            if (j2 > 0 && zipCompressProgressListener != null) {
                long j3 = ((((long) i) + j) * 100) / j2;
                if (unZipFileBrake == null || !unZipFileBrake.mIsAborted) {
                    zipCompressProgressListener.onFinishProgress(j3);
                }
            }
        }
    }

    public static boolean deleteFile(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (int i = 0; i < fileArrListFiles.length; i++) {
                if (fileArrListFiles[i].isFile()) {
                    if (!fileArrListFiles[i].delete()) {
                        return false;
                    }
                } else {
                    if (!deleteFile(fileArrListFiles[i])) {
                        return false;
                    }
                    fileArrListFiles[i].delete();
                }
            }
        }
        file.delete();
        return true;
    }

    private static void fileProber(File file) {
        File parentFile = file.getParentFile();
        if (parentFile.exists()) {
            return;
        }
        fileProber(parentFile);
        parentFile.mkdir();
    }

    public static String getExternalStroragePath(Context context) {
        if (context == null) {
            return null;
        }
        return context.getExternalFilesDir("").getAbsolutePath() + File.separatorChar;
    }

    public static String getMapBaseStorage(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("base_path", 0);
        String str2 = MapsInitializer.sdcardDir;
        if (str2 == null || str2.trim().length() <= 0) {
            String string = sharedPreferences.getString("map_base_path_v44", "");
            String externalStroragePath = getExternalStroragePath(context);
            if (string == null || string.contains(externalStroragePath)) {
                str = string;
            }
        } else {
            str = MapsInitializer.sdcardDir + File.separatorChar;
        }
        if (str != null && str.length() > 2) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdir();
            }
            if (file.isDirectory()) {
                if (checkCanWrite(file)) {
                    return str;
                }
                String str3 = context.getCacheDir().toString() + AeUtil.ROOTPATH;
                if (str3 != null && str3.length() > 2) {
                    File file2 = new File(str3);
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    if (file2.isDirectory()) {
                        return str3;
                    }
                }
            }
        }
        String str4 = getExternalStroragePath(context) + AeUtil.ROOTPATH;
        if (str4 != null && str4.length() > 2) {
            File file3 = new File(str4);
            if (!file3.exists()) {
                file3.mkdir();
            }
            if (file3.isDirectory() && file3.canWrite()) {
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putString("map_base_path_v44", str4);
                editorEdit.commit();
                createNoMediaFileIfNotExist(str4);
                return str4;
            }
        }
        String str5 = context.getCacheDir().toString() + AeUtil.ROOTPATH;
        if (str5 != null && str5.length() > 2) {
            File file4 = new File(str5);
            if (!file4.exists()) {
                file4.mkdir();
            }
            file4.isDirectory();
        }
        return str5;
    }

    public static String getName(String str) {
        if (str == null) {
            return null;
        }
        return str.substring(indexOfLastSeparator(str) + 1);
    }

    private static InputStream getZipInputStream(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return isGzip(bArr) ? new GZIPInputStream(byteArrayInputStream) : new ZipInputStream(byteArrayInputStream);
    }

    public static int indexOfLastSeparator(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static boolean isGzip(byte[] bArr) {
        return ((bArr[1] & 255) | (bArr[0] << 8)) == 8075;
    }

    public static boolean isSafeEntryName(String str) {
        return (str.contains(FILE_PATH_ENTRY_BACK) || str.contains("\\") || str.contains(FILE_PATH_ENTRY_SEPARATOR2)) ? false : true;
    }

    private static byte[] readByteByStream(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                try {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        safelyCloseFile(byteArrayOutputStream);
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                } catch (IOException e) {
                    throw e;
                }
            } catch (Throwable th) {
                safelyCloseFile(byteArrayOutputStream);
                throw th;
            }
        }
    }

    public static byte[] readFileContents(String str) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            File file = new File(str);
            if (!file.exists()) {
                safelyCloseFile((OutputStream) null);
                safelyCloseFile((InputStream) null);
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[1024];
                byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    try {
                        int i = fileInputStream.read(bArr);
                        if (i == -1) {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            safelyCloseFile(byteArrayOutputStream);
                            safelyCloseFile(fileInputStream);
                            return byteArray;
                        }
                        byteArrayOutputStream.write(bArr, 0, i);
                    } catch (Throwable th) {
                        th = th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            byteArrayOutputStream = null;
        }
        try {
            a7b.m(th, TAG, "readFileContents");
            zwa.D(th);
            bxa.l(axa.d, "read file from disk failed " + th.getMessage());
            return null;
        } finally {
            safelyCloseFile(byteArrayOutputStream);
            safelyCloseFile(fileInputStream);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public static byte[] readFileContentsFromAssets(Context context, String str) throws Throwable {
        InputStream inputStreamOpen;
        AssetManager assets = context.getAssets();
        ?? r1 = 0;
        try {
            try {
                inputStreamOpen = assets.open(str);
                try {
                    int iAvailable = inputStreamOpen.available();
                    if (iAvailable == 0) {
                        safelyCloseFile(inputStreamOpen);
                        return null;
                    }
                    byte[] bArr = new byte[iAvailable];
                    for (int i = 0; i < iAvailable; i += inputStreamOpen.read(bArr, i, iAvailable - i)) {
                    }
                    safelyCloseFile(inputStreamOpen);
                    return bArr;
                } catch (IOException e) {
                    e = e;
                    bxa.l(axa.d, "read file from assets failed " + e.getMessage());
                    safelyCloseFile(inputStreamOpen);
                    return null;
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    bxa.l(axa.d, "read file from assets failed " + e.getMessage());
                    safelyCloseFile(inputStreamOpen);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                r1 = assets;
                safelyCloseFile((InputStream) r1);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            inputStreamOpen = null;
        } catch (OutOfMemoryError e4) {
            e = e4;
            inputStreamOpen = null;
        } catch (Throwable th2) {
            th = th2;
            safelyCloseFile((InputStream) r1);
            throw th;
        }
    }

    public static byte[] readFileContentsFromAssetsByPreName(Context context, String str, String str2) {
        if (context != null && str != null && str2 != null) {
            try {
                String[] list = context.getAssets().list(str);
                if (list == null) {
                    return null;
                }
                for (String str3 : list) {
                    if (str3 != null && str3.contains(str2)) {
                        return readFileContentsFromAssets(context, str + WVNativeCallbackUtil.SEPERATER + str3);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static void safelyCloseFile(InputStream inputStream) {
        if (inputStream != null) {
            try {
                if (inputStream instanceof ZipInputStream) {
                    ((ZipInputStream) inputStream).closeEntry();
                }
                inputStream.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void saveFileContents(String str, byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str));
            try {
                fileOutputStream2.write(bArr);
                safelyCloseFile(fileOutputStream2);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                try {
                    a7b.m(th, TAG, "saveFileContents");
                    zwa.D(th);
                    bxa.l(axa.d, "save file from disk failed " + th.getMessage());
                } finally {
                    safelyCloseFile(fileOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static byte[] uncompress(byte[] bArr) {
        InputStream zipInputStream;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            zipInputStream = getZipInputStream(bArr);
            if (zipInputStream != null) {
                try {
                    byte[] bArr2 = new byte[256];
                    while (true) {
                        int i = zipInputStream.read(bArr2);
                        if (i < 0) {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            safelyCloseFile(zipInputStream);
                            return byteArray;
                        }
                        byteArrayOutputStream.write(bArr2, 0, i);
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        Log.e("gzip compress error.", th.getMessage());
                        return null;
                    } finally {
                        safelyCloseFile(zipInputStream);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            zipInputStream = null;
        }
        return null;
    }

    public static Pair<String, byte[]> uncompressToByte(byte[] bArr) {
        InputStream zipInputStream;
        String name;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            zipInputStream = getZipInputStream(bArr);
            try {
                if (zipInputStream instanceof ZipInputStream) {
                    name = ((ZipInputStream) zipInputStream).getNextEntry().getName();
                    if (!isSafeEntryName(name)) {
                        Log.e("gzip compress error.", "gzip name contains ../ ".concat(String.valueOf(name)));
                        safelyCloseFile(zipInputStream);
                        return null;
                    }
                } else {
                    name = "";
                }
                if (zipInputStream != null) {
                    byte[] bArr2 = new byte[256];
                    while (true) {
                        int i = zipInputStream.read(bArr2);
                        if (i < 0) {
                            Pair<String, byte[]> pair = new Pair<>(name, byteArrayOutputStream.toByteArray());
                            safelyCloseFile(zipInputStream);
                            return pair;
                        }
                        byteArrayOutputStream.write(bArr2, 0, i);
                    }
                }
            } catch (Throwable th) {
                th = th;
                try {
                    Log.e("gzip compress error.", th.getMessage());
                } finally {
                    safelyCloseFile(zipInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            zipInputStream = null;
        }
        return null;
    }

    public static byte[] uncompressToByteArray(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            try {
                byte[] bArr2 = new byte[256];
                while (true) {
                    int i = gZIPInputStream.read(bArr2);
                    if (i < 0) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        GLFileUtil.closeQuietly(byteArrayOutputStream);
                        GLFileUtil.closeQuietly(byteArrayInputStream);
                        GLFileUtil.closeQuietly(gZIPInputStream);
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr2, 0, i);
                }
            } catch (Throwable th) {
                th = th;
                try {
                    zwa.D(th);
                    th.printStackTrace();
                    return null;
                } finally {
                    GLFileUtil.closeQuietly(byteArrayOutputStream);
                    GLFileUtil.closeQuietly(byteArrayInputStream);
                    GLFileUtil.closeQuietly(gZIPInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            gZIPInputStream = null;
        }
    }

    public static Map<String, byte[]> uncompressToByteWithKeys(byte[] bArr, String[] strArr) {
        HashMap map = new HashMap();
        if (bArr == null || bArr.length == 0) {
            return map;
        }
        InputStream inputStream = null;
        try {
            InputStream zipInputStream = getZipInputStream(bArr);
            try {
                if (zipInputStream instanceof ZipInputStream) {
                    ZipInputStream zipInputStream2 = (ZipInputStream) zipInputStream;
                    while (true) {
                        ZipEntry nextEntry = zipInputStream2.getNextEntry();
                        if (nextEntry == null) {
                            break;
                        }
                        if (!nextEntry.isDirectory()) {
                            try {
                                String name = nextEntry.getName();
                                if (!isSafeEntryName(name)) {
                                    Log.e("gzip compress error.", "gzip name contains ../ ".concat(String.valueOf(name)));
                                    safelyCloseFile(zipInputStream);
                                    return null;
                                }
                                if (strArr == null) {
                                    byte[] byteByStream = readByteByStream(zipInputStream2);
                                    if (byteByStream != null) {
                                        map.put(name, byteByStream);
                                    }
                                } else {
                                    for (String str : strArr) {
                                        if (name.equals(str)) {
                                            byte[] byteByStream2 = readByteByStream(zipInputStream2);
                                            if (byteByStream2 == null) {
                                                break;
                                            }
                                            map.put(str, byteByStream2);
                                            break;
                                        }
                                    }
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        zipInputStream2.closeEntry();
                    }
                }
                safelyCloseFile(zipInputStream);
            } catch (Throwable th) {
                th = th;
                inputStream = zipInputStream;
                try {
                    Log.e("gzip compress error.", th.getMessage());
                } finally {
                    safelyCloseFile(inputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return map;
    }

    public static String uncompressToString(byte[] bArr) {
        return uncompressToString(bArr, "UTF-8");
    }

    public static void writeDatasToFile(String str, byte[] bArr) throws Throwable {
        ReentrantReadWriteLock.WriteLock writeLock = new ReentrantReadWriteLock().writeLock();
        writeLock.lock();
        FileOutputStream fileOutputStream = null;
        if (bArr != null) {
            try {
                try {
                    if (bArr.length != 0) {
                        File file = new File(str);
                        if (file.exists()) {
                            file.delete();
                        }
                        file.createNewFile();
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            fileOutputStream2.write(bArr);
                            fileOutputStream2.flush();
                            writeLock.unlock();
                            safelyCloseFile(fileOutputStream2);
                            return;
                        } catch (Exception e) {
                            fileOutputStream = fileOutputStream2;
                            e = e;
                        } catch (Throwable th) {
                            fileOutputStream = fileOutputStream2;
                            th = th;
                            writeLock.unlock();
                            safelyCloseFile(fileOutputStream);
                            throw th;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            e.printStackTrace();
            writeLock.unlock();
            safelyCloseFile(fileOutputStream);
            return;
        }
        writeLock.unlock();
        safelyCloseFile((OutputStream) null);
    }

    private static void decompress(InputStream inputStream, String str, long j, ZipCompressProgressListener zipCompressProgressListener) throws Exception {
        CheckedInputStream checkedInputStream = new CheckedInputStream(inputStream, new CRC32());
        ZipInputStream zipInputStream = new ZipInputStream(checkedInputStream);
        decompress(null, new File(str), zipInputStream, j, zipCompressProgressListener, null);
        zipInputStream.close();
        checkedInputStream.close();
    }

    public static String uncompressToString(byte[] bArr, String str) throws Throwable {
        InputStream zipInputStream;
        InputStream inputStream = null;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            zipInputStream = getZipInputStream(bArr);
            if (zipInputStream != null) {
                try {
                    try {
                        byte[] bArr2 = new byte[256];
                        while (true) {
                            int i = zipInputStream.read(bArr2);
                            if (i < 0) {
                                String string = byteArrayOutputStream.toString(str);
                                safelyCloseFile(zipInputStream);
                                return string;
                            }
                            byteArrayOutputStream.write(bArr2, 0, i);
                            th = th;
                            inputStream = zipInputStream;
                            safelyCloseFile(inputStream);
                            throw th;
                        }
                    } catch (IOException e) {
                        e = e;
                        Log.e("gzip compress error.", e.getMessage());
                        safelyCloseFile(zipInputStream);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream = zipInputStream;
                }
            }
        } catch (IOException e2) {
            e = e2;
            zipInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
        safelyCloseFile(zipInputStream);
        return null;
    }

    private static void safelyCloseFile(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Throwable unused) {
            }
        }
    }

    private static void decompress(File file, File file2, ZipInputStream zipInputStream, long j, ZipCompressProgressListener zipCompressProgressListener, UnZipFileBrake unZipFileBrake) throws Exception {
        boolean z = false;
        int iDecompressFile = 0;
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                break;
            }
            if (unZipFileBrake != null && unZipFileBrake.mIsAborted) {
                zipInputStream.closeEntry();
                return;
            }
            String name = nextEntry.getName();
            if (TextUtils.isEmpty(name) || !isSafeEntryName(name)) {
                z = true;
                break;
            }
            File file3 = new File(file2.getPath() + File.separator + name);
            fileProber(file3);
            if (nextEntry.isDirectory()) {
                file3.mkdirs();
            } else {
                iDecompressFile += decompressFile(file3, zipInputStream, iDecompressFile, j, zipCompressProgressListener, unZipFileBrake);
            }
            zipInputStream.closeEntry();
        }
        if (!z || file == null) {
            return;
        }
        try {
            file.delete();
        } catch (Exception unused) {
        }
    }

    public static byte[] compress(byte[] bArr) throws Throwable {
        GZIPOutputStream gZIPOutputStream = null;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream2.write(bArr);
                    gZIPOutputStream2.close();
                    safelyCloseFile(gZIPOutputStream2);
                } catch (IOException e) {
                    e = e;
                    gZIPOutputStream = gZIPOutputStream2;
                    Log.e("gzip compress error.", e.getMessage());
                    safelyCloseFile(gZIPOutputStream);
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    safelyCloseFile(gZIPOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
        return byteArrayOutputStream.toByteArray();
    }
}
