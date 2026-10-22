package com.ali.auth.third.login.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.acse.ottn.p3;
import com.zj.adlib.e57;
import com.zj.adlib.tv0;
import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class QRCodeUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Class f23493a;
    private static Method b;
    private static Method c;
    private static Object d;
    private static Object e;

    static {
        try {
            d = a("com.google.zxing.BarcodeFormat", "QR_CODE");
            e = a("com.google.zxing.EncodeHintType", "MARGIN");
            f23493a = e57.class;
            Class cls = Integer.TYPE;
            b = tv0.class.getMethod(p3.f, cls, cls);
            for (Method method : f23493a.getDeclaredMethods()) {
                if (method.getName().equals("encode") && method.getParameterTypes().length == 5) {
                    c = method;
                    return;
                }
            }
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    private static Object a(String str, String str2) throws NoSuchMethodException {
        Method method = Enum.class.getMethod("name", new Class[0]);
        for (Object obj : Class.forName(str).getEnumConstants()) {
            if (str2.equals(method.invoke(obj, new Object[0]))) {
                return obj;
            }
        }
        return null;
    }

    public static Bitmap createQRCodeBitmap(String str, int i, int i2, String str2) {
        return createQRCodeBitmap(str, i, i2, "UTF-8", str2, "0", -16777216, -1);
    }

    public static Bitmap createQRCodeBitmap(String str, int i, int i2, String str2, String str3, String str4, int i3, int i4) {
        if (TextUtils.isEmpty(str) || i < 0 || i2 < 0) {
            return null;
        }
        try {
            HashMap map = new HashMap();
            if (!TextUtils.isEmpty(str4)) {
                map.put(e, str4);
            }
            Object objInvoke = c.invoke(f23493a.newInstance(), str, d, Integer.valueOf(i), Integer.valueOf(i2), map);
            int[] iArr = new int[i * i2];
            for (int i5 = 0; i5 < i2; i5++) {
                for (int i6 = 0; i6 < i; i6++) {
                    if (((Boolean) b.invoke(objInvoke, Integer.valueOf(i6), Integer.valueOf(i5))).booleanValue()) {
                        iArr[(i5 * i) + i6] = i3;
                    } else {
                        iArr[(i5 * i) + i6] = i4;
                    }
                }
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
            return bitmapCreateBitmap;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
