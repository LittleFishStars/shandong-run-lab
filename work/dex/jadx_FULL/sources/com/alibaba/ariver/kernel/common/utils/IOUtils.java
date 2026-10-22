package com.alibaba.ariver.kernel.common.utils;

import android.content.res.Resources;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.io.ByteArrayPool;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class IOUtils {
    public static final int MAP_FILE_THRESHOLD_MIN = 65536;
    public static final int MAP_FILE_THRESHOOLD_MAX = 5242880;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f24280a = 2048;
    private static final ByteArrayPool b = new ByteArrayPool(20480);

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                RVLogger.e("close stream exception", e);
            }
        }
    }

    public static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        copy(inputStream, outputStream, 4096);
    }

    public static void freeMappedBuffer(MappedByteBuffer mappedByteBuffer) {
        if (mappedByteBuffer == null) {
            return;
        }
        try {
            Method declaredMethod = Class.forName("java.nio.NioUtils").getDeclaredMethod("freeDirectBuffer", ByteBuffer.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, mappedByteBuffer);
        } catch (Throwable th) {
            RVLogger.e("AriverKernel", "freeMappedBuffer Exception!", th);
        }
    }

    public static byte[] getBuf(int i) {
        return getByteArrayPool().getBuf(i);
    }

    public static ByteArrayPool getByteArrayPool() {
        return b;
    }

    public static boolean isNIOEnabled() {
        return "yes".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_nebulaUseNIO", "no"));
    }

    public static String read(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        return new String(readToByte(inputStream));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v2 */
    @Nullable
    public static String readAsset(Resources resources, String str) throws Throwable {
        InputStream inputStreamOpen;
        ?? r0 = 0;
        try {
            try {
                inputStreamOpen = resources.getAssets().open(str);
                try {
                    String str2 = read(inputStreamOpen);
                    closeQuietly(inputStreamOpen);
                    return str2;
                } catch (IOException e) {
                    e = e;
                    RVLogger.e("read asset exception", e);
                    closeQuietly(inputStreamOpen);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                r0 = resources;
                closeQuietly(r0);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            inputStreamOpen = null;
        } catch (Throwable th2) {
            th = th2;
            closeQuietly(r0);
            throw th;
        }
    }

    public static byte[] readToByte(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            try {
                try {
                    int i = inputStream.read(bArr, 0, 2048);
                    if (i < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                } catch (Exception e) {
                    RVLogger.e("read exception", e);
                }
            } catch (Throwable th) {
                closeQuietly(inputStream);
                throw th;
            }
        }
        closeQuietly(inputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static void returnBuf(byte[] bArr) {
        getByteArrayPool().returnBuf(bArr);
    }

    public static void write(String str, String str2, boolean z) throws Throwable {
        BufferedWriter bufferedWriter;
        Throwable th;
        File file = new File(str);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException unused) {
            }
        }
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, z)));
            try {
                bufferedWriter.write(str2);
                try {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                } catch (IOException unused2) {
                }
            } catch (Throwable th2) {
                th = th2;
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.flush();
                        bufferedWriter.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            bufferedWriter = null;
            th = th3;
        }
    }

    public static void copy(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        byte[] buf = getBuf(i);
        while (true) {
            int i2 = inputStream.read(buf);
            if (-1 == i2) {
                return;
            } else {
                outputStream.write(buf, 0, i2);
            }
        }
    }

    public static String read(String str) {
        try {
            return read(new FileInputStream(str));
        } catch (Exception e) {
            RVLogger.e("read exception", e);
            return null;
        }
    }
}
