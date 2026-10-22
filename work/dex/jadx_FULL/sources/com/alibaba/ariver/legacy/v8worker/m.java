package com.alibaba.ariver.legacy.v8worker;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.jsengine.v8.Releasable;
import com.alipay.mobile.jsengine.v8.V8;
import com.alipay.mobile.jsengine.v8.V8Array;
import com.alipay.mobile.jsengine.v8.V8ArrayBuffer;
import com.alipay.mobile.jsengine.v8.V8Object;
import com.alipay.mobile.jsengine.v8.V8Value;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24326a = "V8Worker";
    private static RVConfigService b;

    public static RVConfigService a() {
        if (b == null) {
            b = (RVConfigService) RVProxy.get(RVConfigService.class);
        }
        return b;
    }

    public static boolean b() {
        RVConfigService rVConfigServiceA = a();
        if (rVConfigServiceA == null) {
            return false;
        }
        try {
            return "1".equals(rVConfigServiceA.getConfig("ta_v8ReportJSError", "").trim());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static byte[] c(Object obj) {
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        byte[] bArr = new byte[byteBuffer.capacity()];
        byteBuffer.get(bArr);
        return bArr;
    }

    public static boolean a(Bundle bundle, String str, String str2, String str3, boolean z) {
        String[] strArrSplit;
        if (str != null) {
            String string = BundleUtils.getString(bundle, str, null);
            if ("YES".equalsIgnoreCase(string) || "1".equals(string)) {
                return true;
            }
        }
        RVConfigService rVConfigService = b;
        if (rVConfigService != null && str2 != null && str3 != null) {
            try {
                String config = rVConfigService.getConfig(str2, "");
                if (config == null) {
                    return z;
                }
                String strTrim = config.trim();
                if (TextUtils.isEmpty(strTrim) || (strArrSplit = strTrim.split(",")) == null) {
                    return z;
                }
                if (strArrSplit.length == 1 && "*".equals(strArrSplit[0])) {
                    return true;
                }
                for (String str4 : strArrSplit) {
                    if (str3.equals(str4.trim())) {
                        return true;
                    }
                }
            } catch (Exception e) {
                RVLogger.e(f24326a, "getConfig exception", e);
            }
        }
        return z;
    }

    public static Object b(Object obj) {
        Double d = (Double) obj;
        double dDoubleValue = d.doubleValue();
        if (-9.223372036854776E18d >= dDoubleValue || dDoubleValue >= 9.223372036854776E18d) {
            return obj;
        }
        long jLongValue = d.longValue();
        return ((double) jLongValue) == dDoubleValue ? Long.valueOf(jLongValue) : obj;
    }

    public static void a(Set<String> set, JSONArray jSONArray) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.size(); i++) {
                a(set, jSONArray.getString(i));
            }
        }
    }

    public static void a(Set<String> set, String str) {
        String strTrim = str != null ? str.trim() : null;
        if (TextUtils.isEmpty(strTrim)) {
            return;
        }
        set.add(strTrim);
    }

    public static String a(Throwable th) {
        try {
            String string = th.toString();
            int length = string.length();
            if (length <= 3000) {
                return string;
            }
            return string.substring(0, 1500).trim() + " ... " + string.substring(length - 1500).trim();
        } catch (Throwable unused) {
            return "*** makeLogMsg :(";
        }
    }

    public static JSONObject a(Object obj) {
        if (obj == null || !(obj instanceof V8Object)) {
            return null;
        }
        try {
            return (JSONObject) a((V8Object) obj, new HashSet());
        } catch (Throwable th) {
            RVLogger.e(f24326a, "Exception", th);
            return null;
        }
    }

    public static JSON a(V8Value v8Value, Set<V8Value> set) {
        JSONObject jSONObject = null;
        if (v8Value != null && !v8Value.isUndefined()) {
            if (set != null) {
                if (!set.contains(v8Value)) {
                    set.add(v8Value);
                } else {
                    throw new IllegalArgumentException("Failed to convert V8 to JSON - Circular dependencies");
                }
            }
            int i = 0;
            if (v8Value instanceof V8Array) {
                JSONArray jSONArray = new JSONArray();
                V8Array v8Array = (V8Array) v8Value;
                while (i < v8Array.length()) {
                    Object obj = v8Array.get(i);
                    if (obj instanceof ByteBuffer) {
                        jSONArray.add(c(obj));
                    } else if (obj instanceof V8Value) {
                        jSONArray.add(a((V8Value) obj, set));
                    } else if (obj instanceof Double) {
                        jSONArray.add(b(obj));
                    } else {
                        jSONArray.add(obj);
                    }
                    if (obj != null && (obj instanceof Releasable)) {
                        ((Releasable) obj).release();
                    }
                    i++;
                }
                v8Array.release();
                return jSONArray;
            }
            if (v8Value instanceof V8Object) {
                jSONObject = new JSONObject();
                V8Object v8Object = (V8Object) v8Value;
                String[] keys = v8Object.getKeys();
                while (keys != null && i < keys.length) {
                    String str = keys[i];
                    Object obj2 = v8Object.get(str);
                    if (obj2 instanceof ByteBuffer) {
                        jSONObject.put(str, (Object) c(obj2));
                    } else if (obj2 instanceof V8Value) {
                        jSONObject.put(str, (Object) a((V8Value) obj2, set));
                    } else if (obj2 instanceof Double) {
                        jSONObject.put(str, b(obj2));
                    } else {
                        jSONObject.put(str, obj2);
                    }
                    if (obj2 != null && (obj2 instanceof Releasable)) {
                        ((Releasable) obj2).release();
                    }
                    i++;
                }
                v8Object.release();
            }
        }
        return jSONObject;
    }

    public static V8Value a(V8 v8, Object obj) {
        Object[] array;
        int i = 0;
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            V8Object v8Object = new V8Object(v8);
            int i2 = 0;
            while (true) {
                if (i2 >= 10) {
                    array = null;
                    break;
                }
                try {
                    array = jSONObject.entrySet().toArray();
                    break;
                } catch (Throwable unused) {
                    i2++;
                }
            }
            while (array != null && i < array.length) {
                Map.Entry entry = (Map.Entry) array[i];
                String str = (String) entry.getKey();
                if (!TextUtils.isEmpty(str)) {
                    Object value = entry.getValue();
                    if (value == null) {
                        v8Object.addNull(str);
                    } else if (value instanceof Boolean) {
                        v8Object.add(str, ((Boolean) value).booleanValue());
                    } else if (value instanceof Float) {
                        v8Object.add(str, ((Float) value).floatValue());
                    } else if (value instanceof Double) {
                        v8Object.add(str, ((Double) value).doubleValue());
                    } else if (value instanceof BigDecimal) {
                        v8Object.add(str, ((BigDecimal) value).doubleValue());
                    } else if (value instanceof Integer) {
                        v8Object.add(str, ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        v8Object.add(str, ((Long) value).doubleValue());
                    } else if (value instanceof String) {
                        v8Object.add(str, (String) value);
                    } else if (value instanceof ByteBuffer) {
                        ByteBuffer byteBuffer = (ByteBuffer) value;
                        if (byteBuffer.isDirect()) {
                            V8ArrayBuffer v8ArrayBuffer = new V8ArrayBuffer(v8, byteBuffer);
                            v8Object.add(str, v8ArrayBuffer);
                            v8ArrayBuffer.release();
                        } else {
                            V8ArrayBuffer v8ArrayBuffer2 = new V8ArrayBuffer(v8, byteBuffer.capacity());
                            v8ArrayBuffer2.put(byteBuffer);
                            v8Object.add(str, v8ArrayBuffer2);
                            v8ArrayBuffer2.release();
                        }
                    } else if (value instanceof byte[]) {
                        RVLogger.d(f24326a, "http-request responseType is arrayBuffer");
                        byte[] bArr = (byte[]) value;
                        V8ArrayBuffer v8ArrayBuffer3 = new V8ArrayBuffer(v8, bArr.length);
                        v8ArrayBuffer3.put(bArr);
                        v8Object.add(str, v8ArrayBuffer3);
                        v8ArrayBuffer3.release();
                    } else {
                        V8Value v8ValueA = a(v8, JSON.toJSON(value));
                        v8Object.add(str, v8ValueA);
                        v8ValueA.release();
                    }
                }
                i++;
            }
            return v8Object;
        }
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            V8Array v8Array = new V8Array(v8);
            while (i < jSONArray.size()) {
                Object obj2 = jSONArray.get(i);
                if (obj2 == null) {
                    v8Array.pushNull();
                } else if (obj2 instanceof Boolean) {
                    v8Array.push((Boolean) obj2);
                } else if (obj2 instanceof Float) {
                    v8Array.push(((Float) obj2).floatValue());
                } else if (obj2 instanceof Double) {
                    v8Array.push((Double) obj2);
                } else if (obj2 instanceof BigDecimal) {
                    v8Array.push(((BigDecimal) obj2).doubleValue());
                } else if (obj2 instanceof Integer) {
                    v8Array.push((Integer) obj2);
                } else if (obj2 instanceof Long) {
                    v8Array.push(((Long) obj2).doubleValue());
                } else if (obj2 instanceof String) {
                    v8Array.push((String) obj2);
                } else if (obj2 instanceof ByteBuffer) {
                    ByteBuffer byteBuffer2 = (ByteBuffer) obj2;
                    if (byteBuffer2.isDirect()) {
                        V8ArrayBuffer v8ArrayBuffer4 = new V8ArrayBuffer(v8, byteBuffer2);
                        v8Array.push((V8Value) v8ArrayBuffer4);
                        v8ArrayBuffer4.release();
                    } else {
                        V8ArrayBuffer v8ArrayBuffer5 = new V8ArrayBuffer(v8, byteBuffer2.capacity());
                        v8ArrayBuffer5.put(byteBuffer2);
                        v8Array.push((V8Value) v8ArrayBuffer5);
                        v8ArrayBuffer5.release();
                    }
                } else if (obj2 instanceof byte[]) {
                    byte[] bArr2 = (byte[]) obj2;
                    V8ArrayBuffer v8ArrayBuffer6 = new V8ArrayBuffer(v8, bArr2.length);
                    v8ArrayBuffer6.put(bArr2);
                    v8Array.push((V8Value) v8ArrayBuffer6);
                    v8ArrayBuffer6.release();
                } else {
                    V8Value v8ValueA2 = a(v8, JSON.toJSON(obj2));
                    v8Array.push(v8ValueA2);
                    v8ValueA2.release();
                }
                i++;
            }
            return v8Array;
        }
        throw new IllegalArgumentException("Failed to convert JSON to V8 - unsupported data: " + obj + ", class: " + obj.getClass().getName());
    }
}
