package com.alibaba.ariver.kernel.common.utils;

import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.deserializer.ParseProcess;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class JSONUtils {
    public static boolean contains(JSONObject jSONObject, String str) {
        return (jSONObject == null || jSONObject.isEmpty() || !jSONObject.containsKey(str)) ? false : true;
    }

    public static JSONObject deepCopy(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        for (String str : jSONObject.keySet()) {
            Object obj = jSONObject.get(str);
            if (obj instanceof JSONArray) {
                jSONObject2.put(str, (Object) deepCopy((JSONArray) obj));
            } else if (obj instanceof JSONObject) {
                jSONObject2.put(str, (Object) deepCopy((JSONObject) obj));
            } else {
                jSONObject2.put(str, obj);
            }
        }
        return jSONObject2;
    }

    public static boolean getBoolean(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject == null || jSONObject.isEmpty() || !jSONObject.containsKey(str)) {
            return z;
        }
        try {
            return jSONObject.getBooleanValue(str);
        } catch (Throwable unused) {
            return z;
        }
    }

    public static Integer getColorInt(JSONObject jSONObject, String str) {
        Object obj;
        if (jSONObject == null || (obj = jSONObject.get(str)) == null) {
            return null;
        }
        return TypeUtils.parseColorInt(obj);
    }

    public static Long getColorLong(JSONObject jSONObject, String str) {
        Object obj;
        if (jSONObject == null || (obj = jSONObject.get(str)) == null) {
            return null;
        }
        return TypeUtils.parseColorLong(obj);
    }

    public static float getFloat(JSONObject jSONObject, String str) {
        return getFloat(jSONObject, str, 0.0f);
    }

    public static int getInt(JSONObject jSONObject, String str) {
        return getInt(jSONObject, str, 0);
    }

    public static JSONArray getJSONArray(JSONObject jSONObject, String str, JSONArray jSONArray) {
        if (jSONObject == null || jSONObject.isEmpty() || !jSONObject.containsKey(str)) {
            return jSONArray;
        }
        try {
            return jSONObject.getJSONArray(str);
        } catch (Throwable unused) {
            return jSONArray;
        }
    }

    public static JSONObject getJSONObject(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject.isEmpty() || !jSONObject.containsKey(str)) {
            return jSONObject2;
        }
        try {
            return jSONObject.getJSONObject(str);
        } catch (Throwable unused) {
            return jSONObject2;
        }
    }

    public static long getLong(JSONObject jSONObject, String str) {
        return getLong(jSONObject, str, 0L);
    }

    public static String getString(JSONObject jSONObject, String str) {
        return getString(jSONObject, str, "");
    }

    public static <T> T getValue(JSONObject jSONObject, String str, T t) {
        return (jSONObject == null || jSONObject.isEmpty() || !jSONObject.containsKey(str)) ? t : (T) jSONObject.get(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.Map<java.lang.String, T>] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.Map<java.lang.String, T>] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.HashMap, java.util.Map] */
    public static <T> Map<String, T> jsonToMap(JSONObject jSONObject, Map<String, T> map) {
        if (jSONObject != null && !jSONObject.isEmpty()) {
            map = new HashMap();
            for (String str : jSONObject.keySet()) {
                try {
                    map.put(str, jSONObject.get(str));
                } catch (Throwable th) {
                    RVLogger.e(RVConstants.TAG, th);
                }
            }
        }
        return (Map<String, T>) map;
    }

    public static byte[] marshallJSONArray(JSONArray jSONArray) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeSerializable(jSONArray);
            byte[] bArrMarshall = parcelObtain.marshall();
            parcelObtain.recycle();
            return bArrMarshall;
        } catch (Throwable th) {
            try {
                RVLogger.e("AriverKernel", "marshallJSONArray", th);
                return null;
            } finally {
                parcelObtain.recycle();
            }
        }
    }

    public static byte[] marshallJSONObject(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new byte[0];
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeSerializable(jSONObject);
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }

    public static JSONArray parseArray(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return JSON.parseArray(str);
        } catch (Exception e) {
            RVLogger.e("parseArray error!", e);
            return null;
        }
    }

    public static JSONObject parseObject(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return JSON.parseObject(str);
        } catch (Exception e) {
            RVLogger.e("parseObject error!", e);
            return null;
        }
    }

    public static Bundle toBundle(JSONObject jSONObject) {
        return toBundle(null, jSONObject);
    }

    public static String toString(JSONObject jSONObject) {
        return jSONObject == null ? "" : jSONObject.toString();
    }

    @Nullable
    public static List<String> toStringArray(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            int size = jSONArray.size();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                arrayList.add(jSONArray.getString(i));
            }
            return arrayList;
        } catch (Throwable th) {
            RVLogger.e("toStringArray error!", th);
            return null;
        }
    }

    public static JSONArray unmarshallJSONArray(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new JSONArray();
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.unmarshall(bArr, 0, bArr.length);
            parcelObtain.setDataPosition(0);
            JSONArray jSONArray = (JSONArray) parcelObtain.readSerializable();
            parcelObtain.recycle();
            return jSONArray;
        } catch (Throwable th) {
            try {
                RVLogger.e("AriverKernel", "unmarshallJSONObject error!", th);
                return null;
            } finally {
                parcelObtain.recycle();
            }
        }
    }

    public static JSONObject unmarshallJSONObject(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new JSONObject();
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.unmarshall(bArr, 0, bArr.length);
            parcelObtain.setDataPosition(0);
            JSONObject jSONObject = (JSONObject) parcelObtain.readSerializable();
            parcelObtain.recycle();
            return jSONObject;
        } catch (Throwable th) {
            try {
                RVLogger.e("AriverKernel", "unmarshallJSONObject error!", th);
                return null;
            } finally {
                parcelObtain.recycle();
            }
        }
    }

    public static float getFloat(JSONObject jSONObject, String str, float f) {
        if (jSONObject == null || jSONObject.isEmpty() || !jSONObject.containsKey(str)) {
            return f;
        }
        try {
            return jSONObject.getFloatValue(str);
        } catch (Throwable unused) {
            return f;
        }
    }

    public static int getInt(JSONObject jSONObject, String str, int i) {
        if (jSONObject == null || jSONObject.isEmpty() || !jSONObject.containsKey(str)) {
            return i;
        }
        try {
            return jSONObject.getIntValue(str);
        } catch (Throwable unused) {
            return i;
        }
    }

    public static long getLong(JSONObject jSONObject, String str, long j) {
        if (jSONObject == null || jSONObject.isEmpty() || !jSONObject.containsKey(str)) {
            return j;
        }
        try {
            return jSONObject.getLongValue(str);
        } catch (Throwable unused) {
            return j;
        }
    }

    public static String getString(JSONObject jSONObject, String str, String str2) {
        if (jSONObject == null || jSONObject.isEmpty() || !jSONObject.containsKey(str)) {
            return str2;
        }
        try {
            String string = jSONObject.getString(str);
            return string != null ? string : str2;
        } catch (Throwable th) {
            RVLogger.e(RVConstants.TAG, "getString exception!", th);
            return str2;
        }
    }

    public static Bundle toBundle(Bundle bundle, JSONObject jSONObject) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (jSONObject != null && !jSONObject.isEmpty()) {
            for (String str : jSONObject.keySet()) {
                try {
                    Object obj = jSONObject.get(str);
                    if (obj instanceof Integer) {
                        bundle.putInt(str, ((Integer) obj).intValue());
                    } else if (obj instanceof Boolean) {
                        bundle.putBoolean(str, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof String) {
                        bundle.putString(str, (String) obj);
                    } else if (obj instanceof Long) {
                        bundle.putLong(str, ((Long) obj).longValue());
                    } else if (obj instanceof Double) {
                        bundle.putDouble(str, ((Double) obj).doubleValue());
                    } else if (obj instanceof Float) {
                        bundle.putDouble(str, new BigDecimal(Float.toString(((Float) obj).floatValue())).doubleValue());
                    } else if (obj instanceof JSON) {
                        bundle.putString(str, ((JSON) obj).toJSONString());
                    } else if (obj instanceof BigDecimal) {
                        bundle.putDouble(str, ((BigDecimal) obj).doubleValue());
                    }
                } catch (Exception e) {
                    RVLogger.e("toBundle exception", e);
                }
            }
        }
        return bundle;
    }

    public static JSONObject parseObject(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return JSON.parseObject(new String(bArr, "UTF-8"));
        } catch (Exception e) {
            RVLogger.e("parseObject error!", e);
            return null;
        }
    }

    public static <T> T parseObject(byte[] bArr, Class<T> cls) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            return (T) JSON.parseObject(bArr, cls, new Feature[0]);
        } catch (Exception e) {
            RVLogger.e("parseObject error!", e);
            return null;
        }
    }

    public static <T> T parseObject(byte[] bArr, Class<T> cls, ParseProcess parseProcess) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            return (T) JSON.parseObject(new String(bArr, "UTF-8"), (Class) cls, parseProcess, new Feature[0]);
        } catch (Exception e) {
            RVLogger.e("parseObject error!", e);
            return null;
        }
    }

    public static JSONArray deepCopy(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        for (Object obj : jSONArray) {
            if (obj instanceof JSONArray) {
                jSONArray2.add(deepCopy((JSONArray) obj));
            } else if (obj instanceof JSONObject) {
                jSONArray2.add(deepCopy((JSONObject) obj));
            } else {
                jSONArray2.add(obj);
            }
        }
        return jSONArray2;
    }
}
