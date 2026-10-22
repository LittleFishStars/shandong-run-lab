package com.getui.gtc.dim.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.annotation.MutableMethod;
import com.getui.gtc.base.util.io.IOUtils;
import com.zj.adlib.u15;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c {
    @MutableMethod
    public static Object a(int i, String str, Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
            if (telephonyManager == null || i < 0) {
                return null;
            }
            return telephonyManager.getClass().getMethod(str, c(str)).invoke(telephonyManager, Integer.valueOf(i));
        } catch (Throwable th) {
            b.a(th);
            return null;
        }
    }

    public static Object a(byte[] bArr) throws Exception {
        byte b = bArr[0];
        byte[] bArr2 = new byte[bArr.length - 1];
        System.arraycopy(bArr, 1, bArr2, 0, bArr.length - 1);
        if (b == 0) {
            return b(bArr2);
        }
        if (b != 1) {
            throw new RuntimeException("bytesToObject failed, invalid type");
        }
        Object objC = c(bArr2);
        return objC instanceof com.getui.gtc.dim.d.c ? ((com.getui.gtc.dim.d.c) objC).getParcelables() : objC;
    }

    public static Process a(String str) throws Throwable {
        Class<?> cls = Class.forName(new String(Base64.decode("amF2YS5sYW5nLlJ1bnRpbWU=", 0)));
        Method declaredMethod = cls.getDeclaredMethod(new String(Base64.decode("Z2V0UnVudGltZQ==", 0)), new Class[0]);
        declaredMethod.setAccessible(true);
        Object objInvoke = declaredMethod.invoke(null, new Object[0]);
        Method declaredMethod2 = cls.getDeclaredMethod(new String(Base64.decode("ZXhlYw==", 0)), String.class);
        declaredMethod2.setAccessible(true);
        return (Process) declaredMethod2.invoke(objInvoke, str);
    }

    public static String a(String str, String str2) {
        try {
            String[] strArrSplit = str.split("#");
            int length = strArrSplit.length;
            int i = 0;
            while (true) {
                String str3 = "";
                if (i >= length) {
                    return "";
                }
                String str4 = strArrSplit[i];
                if (!str4.trim().isEmpty()) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(a("getprop ".concat(str4)).getInputStream()));
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        str3 = str3 + line;
                    }
                    bufferedReader.close();
                    if (!str3.trim().isEmpty()) {
                        return str3;
                    }
                }
                i++;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static void a(Context context, String str, boolean z) {
        try {
            z = context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th) {
            b.a(th);
        }
        if (z) {
            return;
        }
        throw new IllegalStateException("permission " + str + " not granted");
    }

    @MutableMethod
    @SuppressLint({"MissingPermission"})
    public static boolean a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
        } catch (Throwable th) {
            b.a(th);
            return false;
        }
    }

    public static boolean a(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th) {
            b.a(th);
            return true;
        }
    }

    public static boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof CharSequence) {
            return !TextUtils.isEmpty((CharSequence) obj);
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).size() > 0;
        }
        return !(obj instanceof Map) || ((Map) obj).size() > 0;
    }

    public static boolean a(byte[] bArr, File file) throws Exception {
        if (bArr == null) {
            return false;
        }
        FileOutputStream fileOutputStream = null;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr2 = new byte[MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_INFOS];
                while (true) {
                    int i = byteArrayInputStream.read(bArr2);
                    if (i == -1) {
                        fileOutputStream2.flush();
                        IOUtils.safeClose(fileOutputStream2);
                        return true;
                    }
                    fileOutputStream2.write(bArr2, 0, i);
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                IOUtils.safeClose(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static byte[] a(Parcelable parcelable) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeParcelable(parcelable, 0);
            byte[] bArrMarshall = parcelObtain.marshall();
            byte[] bArr = new byte[bArrMarshall.length + 1];
            bArr[0] = 1;
            System.arraycopy(bArrMarshall, 0, bArr, 1, bArrMarshall.length);
            return bArr;
        } finally {
            parcelObtain.recycle();
        }
    }

    public static byte[] a(File file) throws Exception {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_INFOS];
                while (true) {
                    int i = fileInputStream2.read(bArr);
                    if (i == -1) {
                        byteArrayOutputStream.flush();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        IOUtils.safeClose(fileInputStream2);
                        return byteArray;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                IOUtils.safeClose(fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static byte[] a(Serializable serializable) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try {
            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream2.writeObject(serializable);
                objectOutputStream2.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byte[] bArr = new byte[byteArray.length + 1];
                bArr[0] = 0;
                System.arraycopy(byteArray, 0, bArr, 1, byteArray.length);
                try {
                    objectOutputStream2.close();
                } catch (Throwable unused) {
                }
                return bArr;
            } catch (Throwable th) {
                th = th;
                objectOutputStream = objectOutputStream2;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (Throwable unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static Object b(byte[] bArr) {
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bArr));
            try {
                Object object = objectInputStream.readObject();
                try {
                    objectInputStream.close();
                } catch (Throwable unused) {
                }
                return object;
            } catch (Throwable th) {
                th = th;
                try {
                    b.a(th);
                    return null;
                } finally {
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Throwable unused2) {
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            objectInputStream = null;
        }
    }

    public static String b(String str) {
        Process processA;
        if (TextUtils.isEmpty(str) || "0.0.0.0".equalsIgnoreCase(str)) {
            return "";
        }
        BufferedReader bufferedReader = null;
        try {
            try {
                processA = a(new String(Base64.decode("aXAgbmVpZ2hib3Vy", 0)));
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(processA.getInputStream()));
                    int i = 0;
                    while (true) {
                        try {
                            String line = bufferedReader2.readLine();
                            if (line == null) {
                                break;
                            }
                            try {
                                if (line.contains("192.168") || line.contains("wlan0")) {
                                    if (!line.contains("FAILED")) {
                                        String[] strArrSplit = line.split(" +");
                                        if (strArrSplit.length >= 6) {
                                            int i2 = i + 1;
                                            if (i > 256) {
                                                break;
                                            }
                                            try {
                                                String strReplaceAll = strArrSplit[4].replaceAll(u15.f19942b, "");
                                                if (str.equalsIgnoreCase(strArrSplit[0])) {
                                                    try {
                                                        bufferedReader2.close();
                                                    } catch (IOException e) {
                                                        b.a(e);
                                                    }
                                                    try {
                                                        processA.destroy();
                                                    } catch (Throwable th) {
                                                        b.a(th);
                                                    }
                                                    return strReplaceAll;
                                                }
                                                i = i2;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                i = i2;
                                                b.a(th);
                                            }
                                        } else {
                                            continue;
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            bufferedReader = bufferedReader2;
                            try {
                                b.a(th);
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e2) {
                                        b.a(e2);
                                    }
                                }
                                if (processA != null) {
                                }
                                return "";
                            } finally {
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e3) {
                                        b.a(e3);
                                    }
                                }
                                if (processA != null) {
                                    try {
                                        processA.destroy();
                                    } catch (Throwable th5) {
                                        b.a(th5);
                                    }
                                }
                            }
                        }
                    }
                    try {
                        bufferedReader2.close();
                    } catch (IOException e4) {
                        b.a(e4);
                    }
                    processA.destroy();
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Throwable th7) {
            }
        } catch (Throwable th8) {
            th = th8;
            processA = null;
        }
        return "";
    }

    @MutableMethod
    @SuppressLint({"MissingPermission"})
    public static boolean b(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.getType() == 0;
        } catch (Throwable th) {
            b.a(th);
            return false;
        }
    }

    public static byte[] b(Object obj) throws Exception {
        if (obj instanceof Parcelable) {
            return a((Parcelable) obj);
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.get(0) instanceof Parcelable) {
                return a((Parcelable) new com.getui.gtc.dim.d.c((List<Parcelable>) list));
            }
        }
        if (obj instanceof Serializable) {
            return a((Serializable) obj);
        }
        throw new IllegalArgumentException("objectToBytes failed, object type is not support: " + obj.getClass().getName());
    }

    private static Object c(byte[] bArr) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.unmarshall(bArr, 0, bArr.length);
            parcelObtain.setDataPosition(0);
            return parcelObtain.readParcelable(GtcProvider.context().getClassLoader());
        } finally {
            parcelObtain.recycle();
        }
    }

    @MutableMethod
    @SuppressLint({"MissingPermission"})
    public static boolean c(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
        } catch (Throwable th) {
            b.a(th);
            return false;
        }
    }

    @MutableMethod
    private static Class<?>[] c(String str) {
        Class<?>[] parameterTypes = null;
        try {
            for (Method method : TelephonyManager.class.getDeclaredMethods()) {
                if (str.equals(method.getName())) {
                    parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length > 0) {
                        break;
                    }
                }
            }
        } catch (Throwable th) {
            b.a(th);
        }
        return parameterTypes;
    }
}
