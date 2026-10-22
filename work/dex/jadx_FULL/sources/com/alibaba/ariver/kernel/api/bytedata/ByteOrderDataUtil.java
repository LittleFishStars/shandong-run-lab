package com.alibaba.ariver.kernel.api.bytedata;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ByteOrderDataUtil {
    static final int BYTE_127 = 127;
    static final int BYTE_2 = 2;
    static final int BYTE_4 = 4;
    static final int BYTE_8 = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ByteArrayPools.ByteArray2Pool f24195a = new ByteArrayPools.ByteArray2Pool();
    private static ByteArrayPools.ByteArray4Pool b = new ByteArrayPools.ByteArray4Pool();
    private static ByteArrayPools.ByteArray8Pool c = new ByteArrayPools.ByteArray8Pool();
    private static ByteArrayPools.ByteArray127Pool d = new ByteArrayPools.ByteArray127Pool();

    @Deprecated
    public static boolean readBoolean(BufferedInputStream bufferedInputStream) {
        return bufferedInputStream.read() > 0;
    }

    public static boolean readBoolean2(BufferedInputStream bufferedInputStream) {
        return readByte(bufferedInputStream) > 0;
    }

    public static byte readByte(BufferedInputStream bufferedInputStream) throws IOException {
        int i = bufferedInputStream.read();
        if (i != -1) {
            return (byte) i;
        }
        throw new IOException("end of the stream has been reached");
    }

    public static int readBytes(BufferedInputStream bufferedInputStream, byte[] bArr) throws IOException {
        int i = bufferedInputStream.read(bArr);
        if (i != -1) {
            return i;
        }
        throw new IOException("end of the stream has been reached, expect length " + bArr.length + " but got " + i);
    }

    public static double readDouble(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] bArrObtain = c.obtain();
        readBytes(bufferedInputStream, bArrObtain);
        double d2 = ByteOrderValues.getDouble(bArrObtain);
        c.free(bArrObtain);
        return d2;
    }

    public static float readFloat(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] bArrObtain = b.obtain();
        readBytes(bufferedInputStream, bArrObtain);
        float f = ByteOrderValues.getFloat(bArrObtain);
        b.free(bArrObtain);
        return f;
    }

    public static int readInt(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] bArrObtain = b.obtain();
        readBytes(bufferedInputStream, bArrObtain);
        int i = ByteOrderValues.getInt(bArrObtain);
        b.free(bArrObtain);
        return i;
    }

    public static long readLong(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] bArrObtain = c.obtain();
        readBytes(bufferedInputStream, bArrObtain);
        long j = ByteOrderValues.getLong(bArrObtain);
        c.free(bArrObtain);
        return j;
    }

    public static short readShort(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] bArrObtain = f24195a.obtain();
        readBytes(bufferedInputStream, bArrObtain);
        short s = ByteOrderValues.getShort(bArrObtain);
        f24195a.free(bArrObtain);
        return s;
    }

    @Deprecated
    public static String readString(BufferedInputStream bufferedInputStream) throws IOException {
        int i = bufferedInputStream.read();
        if (i == 0) {
            return null;
        }
        if (i > 127) {
            byte[] bArr = new byte[i];
            bufferedInputStream.read(bArr);
            return new String(bArr, "utf-8");
        }
        byte[] bArrObtain = d.obtain();
        bufferedInputStream.read(bArrObtain, 0, i);
        String str = new String(bArrObtain, 0, i, "utf-8");
        d.free(bArrObtain);
        return str;
    }

    public static String readString2(BufferedInputStream bufferedInputStream) throws IOException {
        String str;
        int i = readInt(bufferedInputStream);
        if (i < 0) {
            return null;
        }
        if (i == 0) {
            return "";
        }
        if (i > 127) {
            synchronized (ByteOrderDataUtil.class) {
                byte[] bArr = new byte[i];
                readBytes(bufferedInputStream, bArr);
                str = new String(bArr, "utf-8");
            }
            return str;
        }
        byte[] bArrObtain = d.obtain();
        readBytes(bufferedInputStream, bArrObtain, 0, i);
        String str2 = new String(bArrObtain, 0, i, "utf-8");
        d.free(bArrObtain);
        return str2;
    }

    @Deprecated
    public static String[] readStringArray(BufferedInputStream bufferedInputStream) throws IOException {
        int i = bufferedInputStream.read();
        if (i == 0) {
            return null;
        }
        String[] strArr = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            strArr[i2] = readString(bufferedInputStream);
        }
        return strArr;
    }

    public static String[] readStringArray2(BufferedInputStream bufferedInputStream) throws IOException {
        int i = readInt(bufferedInputStream);
        if (i < 0) {
            return null;
        }
        if (i == 0) {
            return new String[0];
        }
        String[] strArr = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            strArr[i2] = readString2(bufferedInputStream);
        }
        return strArr;
    }

    @Deprecated
    public static List<String> readStringList(BufferedInputStream bufferedInputStream) throws IOException {
        int i = bufferedInputStream.read();
        if (i <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(readString(bufferedInputStream));
        }
        return arrayList;
    }

    public static List<String> readStringList2(BufferedInputStream bufferedInputStream) throws IOException {
        int i = readInt(bufferedInputStream);
        if (i < 0) {
            return null;
        }
        if (i == 0) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(readString2(bufferedInputStream));
        }
        return arrayList;
    }

    @Deprecated
    public static void writeBoolean(BufferedOutputStream bufferedOutputStream, boolean z) throws IOException {
        bufferedOutputStream.write(z ? 1 : 0);
    }

    public static void writeBoolean2(BufferedOutputStream bufferedOutputStream, boolean z) throws IOException {
        writeByte(bufferedOutputStream, z ? (byte) 1 : (byte) 0);
    }

    public static void writeByte(BufferedOutputStream bufferedOutputStream, byte b2) throws IOException {
        bufferedOutputStream.write(b2);
    }

    public static void writeDouble(BufferedOutputStream bufferedOutputStream, double d2) throws IOException {
        byte[] bArrObtain = c.obtain();
        ByteOrderValues.putDouble(d2, bArrObtain);
        bufferedOutputStream.write(bArrObtain);
        c.free(bArrObtain);
    }

    public static void writeFloat(BufferedOutputStream bufferedOutputStream, float f) throws IOException {
        byte[] bArrObtain = b.obtain();
        ByteOrderValues.putFloat(f, bArrObtain);
        bufferedOutputStream.write(bArrObtain);
        b.free(bArrObtain);
    }

    public static void writeInt(BufferedOutputStream bufferedOutputStream, int i) throws IOException {
        byte[] bArrObtain = b.obtain();
        ByteOrderValues.putInt(i, bArrObtain);
        b.free(bArrObtain);
        bufferedOutputStream.write(bArrObtain);
    }

    public static void writeLong(BufferedOutputStream bufferedOutputStream, long j) throws IOException {
        byte[] bArrObtain = c.obtain();
        ByteOrderValues.putLong(j, bArrObtain);
        bufferedOutputStream.write(bArrObtain);
        c.free(bArrObtain);
    }

    public static void writeShort(BufferedOutputStream bufferedOutputStream, short s) throws IOException {
        byte[] bArrObtain = f24195a.obtain();
        ByteOrderValues.putShort(s, bArrObtain);
        bufferedOutputStream.write(bArrObtain);
        f24195a.free(bArrObtain);
    }

    @Deprecated
    public static void writeString(BufferedOutputStream bufferedOutputStream, String str) throws IOException {
        if (str == null || str.length() == 0) {
            bufferedOutputStream.write(0);
            return;
        }
        byte[] bytes = str.getBytes();
        bufferedOutputStream.write(bytes.length);
        bufferedOutputStream.write(bytes);
    }

    public static void writeString2(BufferedOutputStream bufferedOutputStream, String str) throws IOException {
        if (str == null) {
            writeInt(bufferedOutputStream, -1);
        } else {
            if (str.length() == 0) {
                writeInt(bufferedOutputStream, 0);
                return;
            }
            byte[] bytes = str.getBytes();
            writeInt(bufferedOutputStream, bytes.length);
            bufferedOutputStream.write(bytes);
        }
    }

    @Deprecated
    public static void writeStringArray(BufferedOutputStream bufferedOutputStream, String[] strArr) throws IOException {
        if (strArr == null || strArr.length == 0) {
            bufferedOutputStream.write(0);
            return;
        }
        bufferedOutputStream.write(strArr.length);
        for (String str : strArr) {
            writeString(bufferedOutputStream, str);
        }
    }

    public static void writeStringArray2(BufferedOutputStream bufferedOutputStream, String[] strArr) throws IOException {
        if (strArr == null) {
            writeInt(bufferedOutputStream, -1);
            return;
        }
        if (strArr.length == 0) {
            writeInt(bufferedOutputStream, 0);
            return;
        }
        writeInt(bufferedOutputStream, strArr.length);
        for (String str : strArr) {
            writeString2(bufferedOutputStream, str);
        }
    }

    @Deprecated
    public static void writeStringList(BufferedOutputStream bufferedOutputStream, List<String> list) throws IOException {
        if (list == null || list.isEmpty()) {
            bufferedOutputStream.write(0);
            return;
        }
        bufferedOutputStream.write(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            writeString(bufferedOutputStream, it.next());
        }
    }

    public static void writeStringList2(BufferedOutputStream bufferedOutputStream, List<String> list) throws IOException {
        if (list == null) {
            writeInt(bufferedOutputStream, -1);
            return;
        }
        if (list.isEmpty()) {
            writeInt(bufferedOutputStream, 0);
            return;
        }
        writeInt(bufferedOutputStream, list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            writeString2(bufferedOutputStream, it.next());
        }
    }

    public static int readBytes(BufferedInputStream bufferedInputStream, byte[] bArr, int i, int i2) throws IOException {
        int i3 = bufferedInputStream.read(bArr, i, i2);
        if (i3 != -1) {
            return i3;
        }
        throw new IOException("end of the stream has been reached, expect count " + i2 + " but got " + i3);
    }
}
