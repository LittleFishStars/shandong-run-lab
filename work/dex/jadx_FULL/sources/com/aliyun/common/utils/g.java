package com.aliyun.common.utils;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.aliyun.vod.common.utils.FileUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BigInteger f25578a;
    public static final BigInteger b;
    public static final BigInteger c;
    public static final BigInteger d;
    public static final BigInteger e;
    public static final BigInteger f;

    static {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(1024L);
        f25578a = bigIntegerValueOf;
        BigInteger bigIntegerMultiply = bigIntegerValueOf.multiply(bigIntegerValueOf);
        b = bigIntegerMultiply;
        BigInteger bigIntegerMultiply2 = bigIntegerValueOf.multiply(bigIntegerMultiply);
        c = bigIntegerMultiply2;
        BigInteger bigIntegerMultiply3 = bigIntegerValueOf.multiply(bigIntegerMultiply2);
        d = bigIntegerMultiply3;
        BigInteger bigIntegerMultiply4 = bigIntegerValueOf.multiply(bigIntegerMultiply3);
        e = bigIntegerMultiply4;
        bigIntegerValueOf.multiply(bigIntegerMultiply4);
        BigInteger bigIntegerMultiply5 = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(FileUtils.ONE_EB));
        f = bigIntegerMultiply5;
        bigIntegerValueOf.multiply(bigIntegerMultiply5);
        Charset.forName("UTF-8");
    }

    private static void a(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        }
        if (file.isDirectory()) {
            return;
        }
        throw new IllegalArgumentException(file + " is not a directory");
    }

    public static void a(File file, File file2) throws Throwable {
        a(file, file2, true);
    }

    public static void a(File file, File file2, boolean z) throws Throwable {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
        if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is a directory");
        }
        if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        }
        File parentFile = file2.getParentFile();
        if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
            throw new IOException("Destination '" + parentFile + "' directory cannot be created");
        }
        if (!file2.exists() || file2.canWrite()) {
            b(file, file2, z);
            return;
        }
        throw new IOException("Destination '" + file2 + "' exists but is read-only");
    }

    public static void a(String str, String[] strArr) {
        FileChannel channel = null;
        try {
            channel = new FileOutputStream(str).getChannel();
            for (String str2 : strArr) {
                FileChannel channel2 = new FileInputStream(str2).getChannel();
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8192);
                while (channel2.read(byteBufferAllocate) != -1) {
                    byteBufferAllocate.flip();
                    channel.write(byteBufferAllocate);
                    byteBufferAllocate.clear();
                }
                channel2.close();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } finally {
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException unused) {
                }
            }
        }
    }

    public static boolean a(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        file.delete();
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x006c  */
    /* JADX WARN: Code duplicated, block: B:43:0x007b A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:58:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
    
        if (r3 != null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String b(String str) throws Throwable {
        String strGuessContentTypeFromStream;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            strGuessContentTypeFromStream = Files.probeContentType(new File(str).toPath());
        } catch (IOException e2) {
            Log.e("AliYunLog", "Get mime type failed!", e2);
            strGuessContentTypeFromStream = null;
        }
        if (strGuessContentTypeFromStream == null) {
            strGuessContentTypeFromStream = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str));
        }
        try {
            try {
                if (strGuessContentTypeFromStream == null) {
                    try {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
                        try {
                            strGuessContentTypeFromStream = URLConnection.guessContentTypeFromStream(bufferedInputStream);
                            bufferedInputStream.close();
                        } catch (FileNotFoundException e3) {
                            e = e3;
                            bufferedInputStream2 = bufferedInputStream;
                            Log.e("AliYunLog", "Get mime type failed!", e);
                        } catch (IOException e4) {
                            e = e4;
                            bufferedInputStream2 = bufferedInputStream;
                            Log.e("AliYunLog", "Get mime type failed!", e);
                            if (bufferedInputStream2 != null) {
                                bufferedInputStream2.close();
                            }
                            if (strGuessContentTypeFromStream == null) {
                                BitmapFactory.Options options = new BitmapFactory.Options();
                                options.inJustDecodeBounds = true;
                                BitmapFactory.decodeFile(str, options);
                                strGuessContentTypeFromStream = options.outMimeType;
                            }
                            if (strGuessContentTypeFromStream == null) {
                                return "";
                            }
                            return strGuessContentTypeFromStream;
                        } catch (Throwable th) {
                            th = th;
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e6) {
                        e = e6;
                    } catch (IOException e7) {
                        e = e7;
                    }
                }
            } catch (IOException e8) {
                e8.printStackTrace();
            }
            if (strGuessContentTypeFromStream == null) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options2);
                strGuessContentTypeFromStream = options2.outMimeType;
            }
            if (strGuessContentTypeFromStream == null) {
                return "";
            }
            return strGuessContentTypeFromStream;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = bufferedInputStream2;
        }
    }

    public static void b(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                c(file2);
            } else {
                file2.delete();
            }
        }
    }

    private static void b(File file, File file2, boolean z) throws Throwable {
        Throwable th;
        FileChannel fileChannel;
        FileChannel fileChannel2;
        FileOutputStream fileOutputStream;
        FileChannel fileChannel3;
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        FileInputStream fileInputStream = null;
        FileChannel channel = null;
        FileChannel fileChannel4 = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    FileChannel channel2 = fileInputStream2.getChannel();
                    try {
                        channel = fileOutputStream.getChannel();
                        long size = channel2.size();
                        long jTransferFrom = 0;
                        while (jTransferFrom < size) {
                            long j = size - jTransferFrom;
                            jTransferFrom += channel.transferFrom(channel2, jTransferFrom, j > 31457280 ? 31457280L : j);
                        }
                        i.a(channel);
                        i.a((OutputStream) fileOutputStream);
                        i.a(channel2);
                        i.a((InputStream) fileInputStream2);
                        if (file.length() == file2.length()) {
                            if (z) {
                                file2.setLastModified(file.lastModified());
                            }
                        } else {
                            throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "'");
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileChannel3 = channel;
                        fileChannel4 = channel2;
                        fileChannel2 = fileChannel3;
                        fileChannel = fileChannel4;
                        fileInputStream = fileInputStream2;
                        i.a(fileChannel2);
                        i.a((OutputStream) fileOutputStream);
                        i.a(fileChannel);
                        i.a((InputStream) fileInputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileChannel3 = null;
                }
            } catch (Throwable th4) {
                th = th4;
                fileChannel = null;
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                fileChannel2 = null;
            }
        } catch (Throwable th5) {
            th = th5;
            fileChannel = null;
            fileChannel2 = null;
            fileOutputStream = null;
        }
    }

    public static boolean c(File file) {
        b(file);
        return file.delete();
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static File d(String str) throws IOException {
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            return file;
        }
        File parentFile = file.getParentFile();
        if ((parentFile.exists() || parentFile.mkdirs()) && file.createNewFile()) {
            return file;
        }
        return null;
    }

    public static boolean d(File file) throws IOException {
        if (file == null) {
            throw new NullPointerException("File must not be null");
        }
        if (h.a()) {
            return false;
        }
        if (file.getParent() != null) {
            file = new File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        return !file.getCanonicalFile().equals(file.getAbsoluteFile());
    }

    public static long e(File file) {
        if (file.exists()) {
            return file.isDirectory() ? f(file) : file.length();
        }
        throw new IllegalArgumentException(file + " does not exist");
    }

    public static long f(File file) {
        a(file);
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return 0L;
        }
        long jE = 0;
        for (File file2 : fileArrListFiles) {
            try {
                if (!d(file2)) {
                    jE += e(file2);
                    if (jE < 0) {
                        break;
                    }
                } else {
                    continue;
                }
            } catch (IOException unused) {
            }
        }
        return jE;
    }
}
