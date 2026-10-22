package com.alibaba.ariver.kernel.common.utils;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BundleUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24274a = "AriverKernel:BundleUtils";

    public static Bundle clone(Bundle bundle) {
        return bundle == null ? new Bundle() : (Bundle) bundle.clone();
    }

    public static boolean contains(Bundle bundle, String str) {
        if (bundle == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return bundle.containsKey(str);
    }

    public static boolean getBoolean(Bundle bundle, String str, boolean z) {
        Boolean boolCastToBoolean;
        if (bundle != null) {
            try {
                return (TextUtils.isEmpty(str) || !bundle.containsKey(str) || (boolCastToBoolean = com.alibaba.fastjson.util.TypeUtils.castToBoolean(bundle.get(str))) == null) ? z : boolCastToBoolean.booleanValue();
            } catch (Exception e) {
                RVLogger.e("get json value exception", e);
            }
        }
        return z;
    }

    public static byte[] getByteArray(Bundle bundle, @Nullable String str) {
        if (bundle != null && !TextUtils.isEmpty(str)) {
            try {
                return bundle.getByteArray(str);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static double getDouble(Bundle bundle, String str) {
        return getDouble(bundle, str, AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public static int getInt(Bundle bundle, String str) {
        return getInt(bundle, str, 0);
    }

    public static long getLong(Bundle bundle, String str) {
        return getLong(bundle, str, 0L);
    }

    public static <T extends Parcelable> T getParcelable(Bundle bundle, @Nullable String str) {
        if (bundle != null && !TextUtils.isEmpty(str)) {
            try {
                return (T) bundle.getParcelable(str);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static Object getSerializable(Bundle bundle, @Nullable String str) {
        if (bundle != null && !TextUtils.isEmpty(str)) {
            try {
                return bundle.getSerializable(str);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String getString(Bundle bundle, String str) {
        return getString(bundle, str, "");
    }

    public static String getStringOnly(Bundle bundle, String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        return (String) getValue(bundle, str, str2);
    }

    public static <T> T getValue(Bundle bundle, String str, T t) {
        T t2;
        if (bundle != null) {
            try {
                return (TextUtils.isEmpty(str) || t == null || !bundle.containsKey(str) || (t2 = (T) bundle.get(str)) == null || !t.getClass().isAssignableFrom(t2.getClass())) ? t : t2;
            } catch (Exception e) {
                RVLogger.e("get json value exception", e);
            }
        }
        return t;
    }

    public static JSONObject toJSONObject(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        if (bundle == null) {
            return jSONObject;
        }
        for (String str : bundle.keySet()) {
            jSONObject.put(str, bundle.get(str));
        }
        return jSONObject;
    }

    public static void tryUnparcel(Bundle bundle) {
        if (bundle != null) {
            try {
                bundle.get("aaa");
            } catch (Throwable th) {
                RVLogger.e(f24274a, "unparcel exception!", th);
            }
        }
    }

    public static double getDouble(Bundle bundle, String str, double d) {
        Double dCastToDouble;
        if (bundle != null) {
            try {
                return (TextUtils.isEmpty(str) || !bundle.containsKey(str) || (dCastToDouble = com.alibaba.fastjson.util.TypeUtils.castToDouble(bundle.get(str))) == null) ? d : dCastToDouble.doubleValue();
            } catch (Exception e) {
                RVLogger.e("get json value exception", e);
            }
        }
        return d;
    }

    public static int getInt(Bundle bundle, String str, int i) {
        Integer numCastToInt;
        if (bundle != null) {
            try {
                return (TextUtils.isEmpty(str) || !bundle.containsKey(str) || (numCastToInt = com.alibaba.fastjson.util.TypeUtils.castToInt(bundle.get(str))) == null) ? i : numCastToInt.intValue();
            } catch (Exception e) {
                RVLogger.e("get json value exception", e);
            }
        }
        return i;
    }

    public static long getLong(Bundle bundle, String str, long j) {
        Long lCastToLong;
        if (bundle != null) {
            try {
                return (TextUtils.isEmpty(str) || !bundle.containsKey(str) || (lCastToLong = com.alibaba.fastjson.util.TypeUtils.castToLong(bundle.get(str))) == null) ? j : lCastToLong.longValue();
            } catch (Exception e) {
                RVLogger.e("get json value exception", e);
            }
        }
        return j;
    }

    public static String getString(Bundle bundle, String str, String str2) {
        String strCastToString;
        if (str2 == null) {
            str2 = "";
        }
        if (bundle != null) {
            try {
                if (!TextUtils.isEmpty(str) && bundle.containsKey(str) && (strCastToString = com.alibaba.fastjson.util.TypeUtils.castToString(bundle.get(str))) != null) {
                    return strCastToString;
                }
            } catch (Exception e) {
                RVLogger.e("get json value exception", e);
            }
        }
        return str2;
    }
}
