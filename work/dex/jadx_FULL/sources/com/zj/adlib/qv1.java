package com.zj.adlib;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.aliyun.vod.common.utils.FileUtils;
import com.blankj.utilcode.util.i;
import com.google.common.base.a;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class qv1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f44305a = 8192;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final char[] f19175a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public qv1() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String A(String str) {
        return (i.C0(str) || !Charset.isSupported(str)) ? "UTF-8" : str;
    }

    public static int B(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c < 'A' || c > 'F') {
            throw new IllegalArgumentException();
        }
        return (c - 'A') + 10;
    }

    public static byte[] C(String str) {
        if (i.C0(str)) {
            return new byte[0];
        }
        int length = str.length();
        if (length % 2 != 0) {
            str = "0" + str;
            length++;
        }
        char[] charArray = str.toUpperCase().toCharArray();
        byte[] bArr = new byte[length >> 1];
        for (int i = 0; i < length; i += 2) {
            bArr[i >> 1] = (byte) ((B(charArray[i]) << 4) | B(charArray[i + 1]));
        }
        return bArr;
    }

    public static int D(String str) {
        return Integer.parseInt(str, 16);
    }

    public static ByteArrayOutputStream E(InputStream inputStream) {
        try {
            if (inputStream == null) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[8192];
            while (true) {
                int i = inputStream.read(bArr, 0, 8192);
                if (i != -1) {
                    byteArrayOutputStream.write(bArr, 0, i);
                }
            }
            return byteArrayOutputStream;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                inputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static byte[] F(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        return E(inputStream).toByteArray();
    }

    public static List<String> G(InputStream inputStream) {
        return H(inputStream, "");
    }

    public static List<String> H(InputStream inputStream, String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            ArrayList arrayList = new ArrayList();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, A(str)));
            while (true) {
                try {
                    try {
                        String line = bufferedReader.readLine();
                        if (line != null) {
                            arrayList.add(line);
                        } else {
                            try {
                                break;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                }
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
            bufferedReader.close();
            return arrayList;
        } catch (IOException e5) {
            e = e5;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String I(InputStream inputStream, String str) {
        if (inputStream == null) {
            return "";
        }
        try {
            ByteArrayOutputStream byteArrayOutputStreamE = E(inputStream);
            return byteArrayOutputStreamE == null ? "" : byteArrayOutputStreamE.toString(A(str));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String J(int i) {
        return Integer.toHexString(i);
    }

    public static byte[] K(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        return jSONArray.toString().getBytes();
    }

    public static byte[] L(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString().getBytes();
    }

    public static long M(long j, int i) {
        if (j < 0) {
            return -1L;
        }
        return j * ((long) i);
    }

    public static String N(long j, int i) {
        return i.H0(j, i);
    }

    public static long O(long j, int i) {
        return j / ((long) i);
    }

    public static ByteArrayInputStream P(OutputStream outputStream) {
        if (outputStream == null) {
            return null;
        }
        return new ByteArrayInputStream(((ByteArrayOutputStream) outputStream).toByteArray());
    }

    public static byte[] Q(OutputStream outputStream) {
        if (outputStream == null) {
            return null;
        }
        return ((ByteArrayOutputStream) outputStream).toByteArray();
    }

    public static String R(OutputStream outputStream, String str) {
        if (outputStream == null) {
            return "";
        }
        try {
            return new String(Q(outputStream), A(str));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static byte[] S(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelable.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }

    public static int T(float f) {
        return i.M0(f);
    }

    public static int U(float f) {
        return i.N0(f);
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0033: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:26:0x0033 */
    public static byte[] V(Serializable serializable) throws Throwable {
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2;
        ObjectOutputStream objectOutputStream3 = null;
        try {
            if (serializable == null) {
                return null;
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream2.writeObject(serializable);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        objectOutputStream2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return byteArray;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (objectOutputStream2 != null) {
                        try {
                            objectOutputStream2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (Exception e4) {
                e = e4;
                objectOutputStream2 = null;
            } catch (Throwable th) {
                th = th;
                if (objectOutputStream3 != null) {
                    try {
                        objectOutputStream3.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream3 = objectOutputStream;
        }
    }

    public static int W(float f) {
        return i.W0(f);
    }

    public static byte[] X(String str) {
        return Y(str, "");
    }

    public static byte[] Y(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(A(str2));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str.getBytes();
        }
    }

    public static InputStream Z(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return new ByteArrayInputStream(str.getBytes(A(str2)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] a(Bitmap bitmap) {
        return i.e(bitmap);
    }

    public static OutputStream a0(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return r(str.getBytes(A(str2)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] b(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i) {
        return i.f(bitmap, compressFormat, i);
    }

    public static long b0(long j, int i) {
        return j * ((long) i);
    }

    public static Drawable c(Bitmap bitmap) {
        return i.g(bitmap);
    }

    public static Bitmap c0(View view) {
        return i.e1(view);
    }

    public static byte[] d(String str) {
        int length = str.length() % 8;
        int length2 = str.length() / 8;
        if (length != 0) {
            while (length < 8) {
                str = "0" + str;
                length++;
            }
            length2++;
        }
        byte[] bArr = new byte[length2];
        for (int i = 0; i < length2; i++) {
            for (int i2 = 0; i2 < 8; i2++) {
                byte b2 = (byte) (bArr[i] << 1);
                bArr[i] = b2;
                bArr[i] = (byte) (b2 | (str.charAt((i * 8) + i2) - '0'));
            }
        }
        return bArr;
    }

    @SuppressLint({"DefaultLocale"})
    public static String e(long j) {
        return f(j, 3);
    }

    @SuppressLint({"DefaultLocale"})
    public static String f(long j, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("precision shouldn't be less than zero!");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteSize shouldn't be less than zero!");
        }
        if (j < 1024) {
            return String.format("%." + i + "fB", Double.valueOf(j));
        }
        if (j < 1048576) {
            return String.format("%." + i + "fKB", Double.valueOf(j / 1024.0d));
        }
        if (j < FileUtils.ONE_GB) {
            return String.format("%." + i + "fMB", Double.valueOf(j / 1048576.0d));
        }
        return String.format("%." + i + "fGB", Double.valueOf(j / 1.073741824E9d));
    }

    public static double g(long j, int i) {
        if (j < 0) {
            return -1.0d;
        }
        return j / ((double) i);
    }

    public static Bitmap h(byte[] bArr) {
        return i.i(bArr);
    }

    public static String i(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            for (int i = 7; i >= 0; i--) {
                sb.append(((b2 >> i) & 1) == 0 ? '0' : '1');
            }
        }
        return sb.toString();
    }

    public static char[] j(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) <= 0) {
            return null;
        }
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = (char) (bArr[i] & 255);
        }
        return cArr;
    }

    public static Drawable k(byte[] bArr) {
        return i.j(bArr);
    }

    public static String l(byte[] bArr) {
        return m(bArr, true);
    }

    public static String m(byte[] bArr, boolean z) {
        if (bArr == null) {
            return "";
        }
        char[] cArr = z ? f19175a : b;
        int length = bArr.length;
        if (length <= 0) {
            return "";
        }
        char[] cArr2 = new char[length << 1];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b2 >> 4) & 15];
            i = i2 + 1;
            cArr2[i2] = cArr[b2 & a.q];
        }
        return new String(cArr2);
    }

    public static InputStream n(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        return new ByteArrayInputStream(bArr);
    }

    public static JSONArray o(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return new JSONArray(new String(bArr));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONObject p(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return new JSONObject(new String(bArr));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0033 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static Object q(byte[] bArr) throws Throwable {
        ObjectInputStream objectInputStream;
        ObjectInputStream objectInputStream2 = null;
        if (bArr == null) {
            return null;
        }
        try {
            objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bArr));
            try {
                try {
                    Object object = objectInputStream.readObject();
                    try {
                        objectInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return object;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                objectInputStream2 = objectInputStream;
                if (objectInputStream2 != null) {
                    try {
                        objectInputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            objectInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (objectInputStream2 != null) {
                objectInputStream2.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static OutputStream r(byte[] bArr) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                try {
                    byteArrayOutputStream.write(bArr);
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return byteArrayOutputStream;
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream2 = byteArrayOutputStream;
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (byteArrayOutputStream2 != null) {
                byteArrayOutputStream2.close();
            }
            throw th;
        }
    }

    public static <T> T s(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        T tCreateFromParcel = creator.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return tCreateFromParcel;
    }

    public static String t(byte[] bArr) {
        return u(bArr, "");
    }

    public static String u(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, A(str));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return new String(bArr);
        }
    }

    public static byte[] v(char[] cArr) {
        if (cArr == null || cArr.length <= 0) {
            return null;
        }
        int length = cArr.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) cArr[i];
        }
        return bArr;
    }

    public static int w(float f) {
        return i.v(f);
    }

    public static Bitmap x(Drawable drawable) {
        return i.w(drawable);
    }

    public static byte[] y(Drawable drawable) {
        return i.x(drawable);
    }

    public static byte[] z(Drawable drawable, Bitmap.CompressFormat compressFormat, int i) {
        return i.y(drawable, compressFormat, i);
    }
}
