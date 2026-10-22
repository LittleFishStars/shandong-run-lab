package com.hailiang.advlib.open;

import android.content.Context;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public class AliCheatParams {

    @Keep
    public interface IListener {
        void onError(Throwable th);

        void onSuccess(String str);
    }

    static {
        try {
            System.loadLibrary("qmcheat");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static native String base64Decode(String str);

    public static native String base64Encode(String str, boolean z);

    public static String decodeByBase64(String str) {
        try {
            return base64Decode(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String encodeByBase64(String str, boolean z) {
        try {
            return base64Encode(str, z);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String getBootMark() {
        try {
            return stringFromJNI2();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static void getId(Context context, IListener iListener) {
        try {
            c.a(context, iListener);
        } catch (Throwable unused) {
        }
    }

    public static String getUpdateMark() {
        try {
            return stringFromJNI1();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static boolean isSupportBase64() {
        return true;
    }

    public static native String stringFromJNI1();

    public static native String stringFromJNI2();
}
