package com.blankj.utilcode.util;

import android.util.Log;
import androidx.camera.video.AudioStats;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class FileIOUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f28135a = 524288;

    public interface OnProgressUpdateListener {
        void a(double d);
    }

    public FileIOUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean A(File file, byte[] bArr, boolean z, boolean z2) {
        if (bArr == null || !i.s(file)) {
            Log.e("FileIOUtils", "create file <" + file + "> failed.");
            return false;
        }
        AbstractInterruptibleChannel abstractInterruptibleChannel = null;
        try {
            try {
                FileChannel channel = new FileOutputStream(file, z).getChannel();
                if (channel == null) {
                    Log.e("FileIOUtils", "fc is null.");
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return false;
                }
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, channel.size(), bArr.length);
                map.put(bArr);
                if (z2) {
                    map.force();
                }
                try {
                    channel.close();
                    return true;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return true;
                }
            } catch (IOException e3) {
                e3.printStackTrace();
                if (0 != 0) {
                    try {
                        abstractInterruptibleChannel.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                return false;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    abstractInterruptibleChannel.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static boolean B(String str, byte[] bArr, boolean z) {
        return C(str, bArr, false, z);
    }

    public static boolean C(String str, byte[] bArr, boolean z, boolean z2) {
        return A(i.O(str), bArr, z, z2);
    }

    public static boolean D(File file, byte[] bArr) {
        return G(file, bArr, false, null);
    }

    public static boolean E(File file, byte[] bArr, OnProgressUpdateListener onProgressUpdateListener) {
        return G(file, bArr, false, onProgressUpdateListener);
    }

    public static boolean F(File file, byte[] bArr, boolean z) {
        return G(file, bArr, z, null);
    }

    public static boolean G(File file, byte[] bArr, boolean z, OnProgressUpdateListener onProgressUpdateListener) {
        if (bArr == null) {
            return false;
        }
        return O(file, new ByteArrayInputStream(bArr), z, onProgressUpdateListener);
    }

    public static boolean H(String str, byte[] bArr) {
        return G(i.O(str), bArr, false, null);
    }

    public static boolean I(String str, byte[] bArr, OnProgressUpdateListener onProgressUpdateListener) {
        return G(i.O(str), bArr, false, onProgressUpdateListener);
    }

    public static boolean J(String str, byte[] bArr, boolean z) {
        return G(i.O(str), bArr, z, null);
    }

    public static boolean K(String str, byte[] bArr, boolean z, OnProgressUpdateListener onProgressUpdateListener) {
        return G(i.O(str), bArr, z, onProgressUpdateListener);
    }

    public static boolean L(File file, InputStream inputStream) {
        return O(file, inputStream, false, null);
    }

    public static boolean M(File file, InputStream inputStream, OnProgressUpdateListener onProgressUpdateListener) {
        return O(file, inputStream, false, onProgressUpdateListener);
    }

    public static boolean N(File file, InputStream inputStream, boolean z) {
        return O(file, inputStream, z, null);
    }

    public static boolean O(File file, InputStream inputStream, boolean z, OnProgressUpdateListener onProgressUpdateListener) throws Throwable {
        if (inputStream == null || !i.s(file)) {
            Log.e("FileIOUtils", "create file <" + file + "> failed.");
            return false;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file, z), f28135a);
            try {
                try {
                    try {
                        if (onProgressUpdateListener == null) {
                            byte[] bArr = new byte[f28135a];
                            while (true) {
                                int i = inputStream.read(bArr);
                                if (i == -1) {
                                    break;
                                }
                                bufferedOutputStream2.write(bArr, 0, i);
                            }
                            inputStream.close();
                            bufferedOutputStream2.close();
                            return true;
                        }
                        double dAvailable = inputStream.available();
                        onProgressUpdateListener.a(AudioStats.AUDIO_AMPLITUDE_NONE);
                        byte[] bArr2 = new byte[f28135a];
                        int i2 = 0;
                        while (true) {
                            int i3 = inputStream.read(bArr2);
                            if (i3 == -1) {
                                break;
                            }
                            bufferedOutputStream2.write(bArr2, 0, i3);
                            i2 += i3;
                            onProgressUpdateListener.a(((double) i2) / dAvailable);
                        }
                        inputStream.close();
                        bufferedOutputStream2.close();
                        return true;
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    bufferedOutputStream2.close();
                    return true;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return true;
                }
            } catch (IOException e3) {
                e = e3;
                bufferedOutputStream = bufferedOutputStream2;
                e.printStackTrace();
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                return false;
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    inputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
                if (bufferedOutputStream == null) {
                    throw th;
                }
                try {
                    bufferedOutputStream.close();
                    throw th;
                } catch (IOException e7) {
                    e7.printStackTrace();
                    throw th;
                }
            }
        } catch (IOException e8) {
            e = e8;
        }
    }

    public static boolean P(String str, InputStream inputStream) {
        return O(i.O(str), inputStream, false, null);
    }

    public static boolean Q(String str, InputStream inputStream, OnProgressUpdateListener onProgressUpdateListener) {
        return O(i.O(str), inputStream, false, onProgressUpdateListener);
    }

    public static boolean R(String str, InputStream inputStream, boolean z) {
        return O(i.O(str), inputStream, z, null);
    }

    public static boolean S(String str, InputStream inputStream, boolean z, OnProgressUpdateListener onProgressUpdateListener) {
        return O(i.O(str), inputStream, z, onProgressUpdateListener);
    }

    public static boolean T(File file, String str) {
        return U(file, str, false);
    }

    public static boolean U(File file, String str, boolean z) throws Throwable {
        if (file == null || str == null) {
            return false;
        }
        if (!i.s(file)) {
            Log.e("FileIOUtils", "create file <" + file + "> failed.");
            return false;
        }
        BufferedWriter bufferedWriter = null;
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file, z));
                try {
                    bufferedWriter2.write(str);
                    try {
                        bufferedWriter2.close();
                        return true;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return true;
                    }
                } catch (IOException e2) {
                    e = e2;
                    bufferedWriter = bufferedWriter2;
                    e.printStackTrace();
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean V(String str, String str2) {
        return U(i.O(str), str2, false);
    }

    public static boolean W(String str, String str2, boolean z) {
        return U(i.O(str), str2, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.nio.channels.spi.AbstractInterruptibleChannel] */
    public static byte[] a(File file) throws Throwable {
        FileChannel channel;
        ?? r1 = 0;
        try {
            if (!i.t0(file)) {
                return null;
            }
            try {
                channel = new RandomAccessFile(file, "r").getChannel();
                try {
                    if (channel == null) {
                        Log.e("FileIOUtils", "fc is null.");
                        byte[] bArr = new byte[0];
                        if (channel != null) {
                            try {
                                channel.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        return bArr;
                    }
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) channel.size());
                    while (channel.read(byteBufferAllocate) > 0) {
                    }
                    byte[] bArrArray = byteBufferAllocate.array();
                    try {
                        channel.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return bArrArray;
                } catch (IOException e3) {
                    e = e3;
                    e.printStackTrace();
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (IOException e5) {
                e = e5;
                channel = null;
            } catch (Throwable th) {
                th = th;
                if (r1 != 0) {
                    try {
                        r1.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            r1 = file;
        }
    }

    public static byte[] b(String str) {
        return a(i.O(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.nio.channels.spi.AbstractInterruptibleChannel] */
    public static byte[] c(File file) throws Throwable {
        FileChannel channel;
        ?? r1 = 0;
        try {
            if (!i.t0(file)) {
                return null;
            }
            try {
                channel = new RandomAccessFile(file, "r").getChannel();
                try {
                    if (channel == null) {
                        Log.e("FileIOUtils", "fc is null.");
                        byte[] bArr = new byte[0];
                        if (channel != null) {
                            try {
                                channel.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        return bArr;
                    }
                    int size = (int) channel.size();
                    byte[] bArr2 = new byte[size];
                    channel.map(FileChannel.MapMode.READ_ONLY, 0L, size).load().get(bArr2, 0, size);
                    try {
                        channel.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return bArr2;
                } catch (IOException e3) {
                    e = e3;
                    e.printStackTrace();
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (IOException e5) {
                e = e5;
                channel = null;
            } catch (Throwable th) {
                th = th;
                if (r1 != 0) {
                    try {
                        r1.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            r1 = file;
        }
    }

    public static byte[] d(String str) {
        return c(i.O(str));
    }

    public static byte[] e(File file) {
        return f(file, null);
    }

    /* JADX WARN: Code duplicated, block: B:71:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:? A[Catch: FileNotFoundException -> 0x0090, SYNTHETIC, TRY_LEAVE, TryCatch #0 {FileNotFoundException -> 0x0090, blocks: (B:5:0x0008, B:24:0x005b, B:20:0x0053, B:41:0x0078, B:36:0x006e, B:53:0x008f, B:52:0x008c, B:47:0x0082, B:21:0x0056, B:38:0x0073, B:44:0x007d, B:17:0x004e, B:33:0x0069, B:49:0x0087), top: B:57:0x0008, inners: #1, #3, #5, #6, #8, #10 }] */
    public static byte[] f(File file, OnProgressUpdateListener onProgressUpdateListener) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        if (!i.t0(file)) {
            return null;
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), f28135a);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    try {
                        byte[] bArr = new byte[f28135a];
                        if (onProgressUpdateListener != null) {
                            double dAvailable = bufferedInputStream.available();
                            onProgressUpdateListener.a(AudioStats.AUDIO_AMPLITUDE_NONE);
                            int i = 0;
                            while (true) {
                                int i2 = bufferedInputStream.read(bArr, 0, f28135a);
                                if (i2 == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, i2);
                                i += i2;
                                onProgressUpdateListener.a(((double) i) / dAvailable);
                            }
                        } else {
                            while (true) {
                                int i3 = bufferedInputStream.read(bArr, 0, f28135a);
                                if (i3 == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, i3);
                            }
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        return byteArray;
                    } catch (IOException e3) {
                        e = e3;
                        e.printStackTrace();
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                    if (byteArrayOutputStream != null) {
                        throw th;
                    }
                    try {
                        byteArrayOutputStream.close();
                        throw th;
                    } catch (IOException e7) {
                        e7.printStackTrace();
                        throw th;
                    }
                }
            } catch (IOException e8) {
                e = e8;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
                bufferedInputStream.close();
                if (byteArrayOutputStream != null) {
                    throw th;
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (FileNotFoundException e9) {
            e9.printStackTrace();
            return null;
        }
    }

    public static byte[] g(String str) {
        return f(i.O(str), null);
    }

    public static byte[] h(String str, OnProgressUpdateListener onProgressUpdateListener) {
        return f(i.O(str), onProgressUpdateListener);
    }

    public static List<String> i(File file) {
        return k(file, 0, Integer.MAX_VALUE, null);
    }

    public static List<String> j(File file, int i, int i2) {
        return k(file, i, i2, null);
    }

    /* JADX WARN: Code duplicated, block: B:51:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static List<String> k(File file, int i, int i2, String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        if (!i.t0(file) || i > i2) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            int i3 = 1;
            bufferedReader = i.C0(str) ? new BufferedReader(new InputStreamReader(new FileInputStream(file))) : new BufferedReader(new InputStreamReader(new FileInputStream(file), str));
            while (true) {
                try {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null || i3 > i2) {
                            break;
                            break;
                        }
                        if (i <= i3 && i3 <= i2) {
                            arrayList.add(line);
                        }
                        i3++;
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            try {
                bufferedReader.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            return arrayList;
        } catch (IOException e5) {
            e = e5;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            throw th;
        }
    }

    public static List<String> l(File file, String str) {
        return k(file, 0, Integer.MAX_VALUE, str);
    }

    public static List<String> m(String str) {
        return l(i.O(str), null);
    }

    public static List<String> n(String str, int i, int i2) {
        return k(i.O(str), i, i2, null);
    }

    public static List<String> o(String str, int i, int i2, String str2) {
        return k(i.O(str), i, i2, str2);
    }

    public static List<String> p(String str, String str2) {
        return l(i.O(str), str2);
    }

    public static String q(File file) {
        return r(file, null);
    }

    public static String r(File file, String str) {
        byte[] bArrE = e(file);
        if (bArrE == null) {
            return null;
        }
        if (i.C0(str)) {
            return new String(bArrE);
        }
        try {
            return new String(bArrE, str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String s(String str) {
        return r(i.O(str), null);
    }

    public static String t(String str, String str2) {
        return r(i.O(str), str2);
    }

    public static void u(int i) {
        f28135a = i;
    }

    public static boolean v(File file, byte[] bArr, boolean z) {
        return w(file, bArr, false, z);
    }

    public static boolean w(File file, byte[] bArr, boolean z, boolean z2) {
        if (bArr == null) {
            Log.e("FileIOUtils", "bytes is null.");
            return false;
        }
        if (!i.s(file)) {
            Log.e("FileIOUtils", "create file <" + file + "> failed.");
            return false;
        }
        AbstractInterruptibleChannel abstractInterruptibleChannel = null;
        try {
            try {
                FileChannel channel = new FileOutputStream(file, z).getChannel();
                if (channel == null) {
                    Log.e("FileIOUtils", "fc is null.");
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return false;
                }
                channel.position(channel.size());
                channel.write(ByteBuffer.wrap(bArr));
                if (z2) {
                    channel.force(true);
                }
                try {
                    channel.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return true;
            } catch (IOException e3) {
                e3.printStackTrace();
                if (0 != 0) {
                    try {
                        abstractInterruptibleChannel.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                return false;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    abstractInterruptibleChannel.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static boolean x(String str, byte[] bArr, boolean z) {
        return w(i.O(str), bArr, false, z);
    }

    public static boolean y(String str, byte[] bArr, boolean z, boolean z2) {
        return w(i.O(str), bArr, z, z2);
    }

    public static boolean z(File file, byte[] bArr, boolean z) {
        return A(file, bArr, false, z);
    }
}
