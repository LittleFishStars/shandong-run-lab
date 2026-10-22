package com.alibaba.ariver.v8worker;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.jsi.standard.js.s;
import com.alibaba.jsi.standard.js.t;
import com.alibaba.jsi.standard.js.w;
import com.alibaba.jsi.standard.js.y;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f24529a = 500;
    private static final String b = "V8Worker_JSI";
    private static RVConfigService c;

    public static RVConfigService a() {
        if (c == null) {
            c = (RVConfigService) RVProxy.get(RVConfigService.class);
        }
        return c;
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

    public static String a(String str, String str2) {
        try {
            String config = a().getConfig(str, null);
            return TextUtils.isEmpty(config) ? str2 : config;
        } catch (Exception e) {
            RVLogger.e(b, "getConfigForAB exception", e);
            return str2;
        }
    }

    private static JSONArray b(Object obj) {
        int length = Array.getLength(obj);
        JSONArray jSONArray = new JSONArray(length);
        for (int i = 0; i < length; i++) {
            jSONArray.add(a(Array.get(obj, i)));
        }
        return jSONArray;
    }

    public static boolean a(String str, boolean z) {
        try {
            String config = a().getConfig(str, null);
            return TextUtils.isEmpty(config) ? z : a(config);
        } catch (Exception e) {
            RVLogger.e(b, "getBooleanConfig exception", e);
            return z;
        }
    }

    public static boolean b(String str, String str2) {
        int length = str.length();
        int length2 = str2.length();
        if (length < length2) {
            return false;
        }
        if (length == length2) {
            return str.equalsIgnoreCase(str2);
        }
        return str.substring(0, length2).equalsIgnoreCase(str2);
    }

    public static int a(String str, int i) {
        try {
            String config = a().getConfig(str, null);
            return TextUtils.isEmpty(config) ? i : Integer.valueOf(config.trim()).intValue();
        } catch (Exception e) {
            RVLogger.e(b, "getIntConfig exception", e);
            return i;
        }
    }

    public static boolean a(Bundle bundle, String str, String str2, String str3, boolean z) {
        String[] strArrSplit;
        if (str != null) {
            String string = BundleUtils.getString(bundle, str, null);
            if ("YES".equalsIgnoreCase(string) || "1".equals(string)) {
                return true;
            }
        }
        if (a() != null && str2 != null && str3 != null) {
            try {
                String config = a().getConfig(str2, "");
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
                RVLogger.e(b, "getConfig exception", e);
            }
        }
        return z;
    }

    public static boolean a(String str, String str2, boolean z) {
        String[] strArrSplit;
        if (a() != null && str != null && str2 != null) {
            try {
                String config = a().getConfig(str, null);
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
                for (String str3 : strArrSplit) {
                    if (str2.equals(str3.trim())) {
                        return true;
                    }
                }
            } catch (Exception e) {
                RVLogger.e(b, "getConfigForAB exception", e);
            }
        }
        return z;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String strTrim = str.trim();
        return "YES".equalsIgnoreCase(strTrim) || "TRUE".equalsIgnoreCase(strTrim) || "1".equals(strTrim);
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

    public static JSONObject a(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    jSONObject2.put(key, a(entry.getValue()));
                }
            }
            return jSONObject2;
        } catch (Throwable th) {
            RVLogger.e(b, "copyJSONObject exception", th);
            return jSONObject;
        }
    }

    private static Object a(Object obj) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof byte[]) || (obj instanceof ByteBuffer)) {
            return obj;
        }
        if (obj instanceof JSONObject) {
            return a((JSONObject) obj);
        }
        if (obj instanceof JSONArray) {
            return a((JSONArray) obj);
        }
        if (obj instanceof Map) {
            return a((Map<Object, Object>) obj);
        }
        if (obj instanceof Collection) {
            return a((Collection<Object>) obj);
        }
        return obj.getClass().isArray() ? b(obj) : obj;
    }

    private static JSONArray a(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.size(); i++) {
            jSONArray2.add(a(jSONArray.get(i)));
        }
        return jSONArray2;
    }

    private static JSONObject a(Map<Object, Object> map) {
        int size = map.size();
        JSONObject jSONObject = new JSONObject((Map<String, Object>) (map instanceof LinkedHashMap ? new LinkedHashMap(size) : map instanceof TreeMap ? new TreeMap() : new HashMap(size)));
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            Object key = entry.getKey();
            if (key != null) {
                jSONObject.put(key.toString(), a(entry.getValue()));
            }
        }
        return jSONObject;
    }

    private static JSONArray a(Collection<Object> collection) {
        JSONArray jSONArray = new JSONArray();
        Iterator<Object> it = collection.iterator();
        while (it.hasNext()) {
            jSONArray.add(a(it.next()));
        }
        return jSONArray;
    }

    public static JSONObject a(w wVar, com.alibaba.jsi.standard.b bVar) {
        if (wVar != null && !wVar.u()) {
            try {
                return (JSONObject) a(wVar, bVar, 0);
            } catch (Throwable th) {
                RVLogger.e(b, "Exception", th);
            }
        }
        return null;
    }

    public static JSON a(w wVar, com.alibaba.jsi.standard.b bVar, int i) {
        if (wVar == null || wVar.u()) {
            return null;
        }
        if (i < 500) {
            int i2 = 0;
            if (wVar.b()) {
                JSONArray jSONArray = new JSONArray();
                com.alibaba.jsi.standard.js.d dVar = (com.alibaba.jsi.standard.js.d) wVar;
                while (i2 < dVar.a(bVar)) {
                    w wVarA = dVar.a(bVar, i2);
                    if (wVarA.d()) {
                        jSONArray.add(Boolean.valueOf(a((com.alibaba.jsi.standard.js.f) wVarA)));
                    } else if (wVarA.e()) {
                        jSONArray.add(Boolean.valueOf(a((com.alibaba.jsi.standard.js.g) wVarA, bVar)));
                    } else if (wVarA.i()) {
                        jSONArray.add(a((com.alibaba.jsi.standard.js.m) wVarA));
                    } else if (wVarA.d_()) {
                        jSONArray.add(a((com.alibaba.jsi.standard.js.n) wVarA, bVar));
                    } else if (wVarA.p()) {
                        jSONArray.add(a((s) wVarA));
                    } else if (wVarA.q()) {
                        jSONArray.add(a((t) wVarA, bVar));
                    } else if (wVarA.c()) {
                        jSONArray.add(a(bVar, (com.alibaba.jsi.standard.js.e) wVarA));
                    } else if (wVarA.u() && !((y) wVarA).w()) {
                        jSONArray.add(null);
                    } else if (!wVarA.f() && (wVarA.b() || wVarA.k())) {
                        jSONArray.add(a(wVarA, bVar, i + 1));
                    }
                    wVarA.a();
                    i2++;
                }
                dVar.a();
                return jSONArray;
            }
            if (!wVar.k()) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            com.alibaba.jsi.standard.js.o oVar = (com.alibaba.jsi.standard.js.o) wVar;
            com.alibaba.jsi.standard.js.d dVarI = oVar.i(bVar);
            while (dVarI != null && i2 < dVarI.a(bVar)) {
                w wVarA2 = dVarI.a(bVar, i2);
                w wVarD = oVar.d(bVar, wVarA2);
                String strA_ = wVarA2.a_(bVar);
                if (wVarD.d()) {
                    jSONObject.put(strA_, (Object) Boolean.valueOf(a((com.alibaba.jsi.standard.js.f) wVarD)));
                } else if (wVarD.e()) {
                    jSONObject.put(strA_, (Object) Boolean.valueOf(a((com.alibaba.jsi.standard.js.g) wVarD, bVar)));
                } else if (wVarD.i()) {
                    jSONObject.put(strA_, a((com.alibaba.jsi.standard.js.m) wVarD));
                } else if (wVarD.d_()) {
                    jSONObject.put(strA_, a((com.alibaba.jsi.standard.js.n) wVarD, bVar));
                } else if (wVarD.p()) {
                    jSONObject.put(strA_, (Object) a((s) wVarD));
                } else if (wVarD.q()) {
                    jSONObject.put(strA_, (Object) a((t) wVarD, bVar));
                } else if (wVarD.c()) {
                    jSONObject.put(strA_, (Object) a(bVar, (com.alibaba.jsi.standard.js.e) wVarD));
                } else if (wVarD.u() && !((y) wVarD).w()) {
                    jSONObject.put(strA_, (Object) null);
                } else if (!wVarD.f() && (wVarD.b() || wVarD.k())) {
                    jSONObject.put(strA_, (Object) a(wVarD, bVar, i + 1));
                }
                wVarD.a();
                wVarA2.a();
                i2++;
            }
            oVar.a();
            if (dVarI != null) {
                dVarI.a();
            }
            return jSONObject;
        }
        throw new IllegalArgumentException("Failed to convert V8 to JSON - Exceed max depth (500)");
    }

    public static boolean a(com.alibaba.jsi.standard.js.f fVar) {
        return fVar.b_();
    }

    public static boolean a(com.alibaba.jsi.standard.js.g gVar, com.alibaba.jsi.standard.b bVar) {
        return gVar.c(bVar);
    }

    public static String a(s sVar) {
        return sVar.f_();
    }

    public static String a(t tVar, com.alibaba.jsi.standard.b bVar) {
        return tVar.c(bVar);
    }

    public static Object a(com.alibaba.jsi.standard.js.m mVar) {
        Double dValueOf = Double.valueOf(mVar.c_());
        double dDoubleValue = dValueOf.doubleValue();
        if (-2.147483648E9d < dDoubleValue && dDoubleValue < 2.147483647E9d) {
            int iIntValue = dValueOf.intValue();
            if (iIntValue == dDoubleValue) {
                return Integer.valueOf(iIntValue);
            }
        }
        if (-9.223372036854776E18d >= dDoubleValue || dDoubleValue >= 9.223372036854776E18d) {
            return dValueOf;
        }
        long jLongValue = dValueOf.longValue();
        return ((double) jLongValue) == dDoubleValue ? Long.valueOf(jLongValue) : dValueOf;
    }

    public static Object a(com.alibaba.jsi.standard.js.n nVar, com.alibaba.jsi.standard.b bVar) {
        Double dValueOf = Double.valueOf(nVar.c(bVar));
        double dDoubleValue = dValueOf.doubleValue();
        if (-2.147483648E9d < dDoubleValue && dDoubleValue < 2.147483647E9d) {
            int iIntValue = dValueOf.intValue();
            if (iIntValue == dDoubleValue) {
                return Integer.valueOf(iIntValue);
            }
        }
        if (-9.223372036854776E18d >= dDoubleValue || dDoubleValue >= 9.223372036854776E18d) {
            return dValueOf;
        }
        long jLongValue = dValueOf.longValue();
        return ((double) jLongValue) == dDoubleValue ? Long.valueOf(jLongValue) : dValueOf;
    }

    public static byte[] a(com.alibaba.jsi.standard.b bVar, com.alibaba.jsi.standard.js.e eVar) {
        ByteBuffer byteBufferF = eVar.f(bVar);
        byte[] bArr = new byte[byteBufferF.capacity()];
        byteBufferF.get(bArr);
        return bArr;
    }

    public static w a(com.alibaba.jsi.standard.b bVar, Object obj) {
        if (obj instanceof JSONObject) {
            com.alibaba.jsi.standard.js.o oVar = new com.alibaba.jsi.standard.js.o(bVar);
            Object[] array = ((JSONObject) obj).entrySet().toArray();
            for (int i = 0; array != null && i < array.length; i++) {
                Map.Entry entry = (Map.Entry) array[i];
                String str = (String) entry.getKey();
                if (!TextUtils.isEmpty(str)) {
                    Object value = entry.getValue();
                    if (value == null) {
                        y yVar = new y(false);
                        oVar.a(bVar, str, yVar);
                        yVar.a();
                    } else if (value instanceof Boolean) {
                        com.alibaba.jsi.standard.js.f fVar = new com.alibaba.jsi.standard.js.f(((Boolean) value).booleanValue());
                        oVar.a(bVar, str, fVar);
                        fVar.a();
                    } else if (value instanceof Float) {
                        com.alibaba.jsi.standard.js.m mVar = new com.alibaba.jsi.standard.js.m(((Float) value).doubleValue());
                        oVar.a(bVar, str, mVar);
                        mVar.a();
                    } else if (value instanceof Double) {
                        com.alibaba.jsi.standard.js.m mVar2 = new com.alibaba.jsi.standard.js.m(((Double) value).doubleValue());
                        oVar.a(bVar, str, mVar2);
                        mVar2.a();
                    } else if (value instanceof BigDecimal) {
                        com.alibaba.jsi.standard.js.m mVar3 = new com.alibaba.jsi.standard.js.m(((BigDecimal) value).doubleValue());
                        oVar.a(bVar, str, mVar3);
                        mVar3.a();
                    } else if (value instanceof Integer) {
                        com.alibaba.jsi.standard.js.m mVar4 = new com.alibaba.jsi.standard.js.m(((Integer) value).intValue());
                        oVar.a(bVar, str, mVar4);
                        mVar4.a();
                    } else if (value instanceof Long) {
                        com.alibaba.jsi.standard.js.m mVar5 = new com.alibaba.jsi.standard.js.m(((Long) value).doubleValue());
                        oVar.a(bVar, str, mVar5);
                        mVar5.a();
                    } else if (value instanceof String) {
                        s sVar = new s((String) value);
                        oVar.a(bVar, str, sVar);
                        sVar.a();
                    } else if (value instanceof ByteBuffer) {
                        ByteBuffer byteBuffer = (ByteBuffer) value;
                        if (byteBuffer.isDirect()) {
                            com.alibaba.jsi.standard.js.e eVar = new com.alibaba.jsi.standard.js.e(bVar, 0, byteBuffer);
                            oVar.a(bVar, str, eVar);
                            eVar.a();
                        } else {
                            com.alibaba.jsi.standard.js.e eVar2 = new com.alibaba.jsi.standard.js.e(bVar, 0, byteBuffer.capacity());
                            eVar2.f(bVar).put(byteBuffer);
                            oVar.a(bVar, str, eVar2);
                            eVar2.a();
                        }
                    } else if (value instanceof byte[]) {
                        RVLogger.d(b, "http-request responseType is arrayBuffer");
                        byte[] bArr = (byte[]) value;
                        com.alibaba.jsi.standard.js.e eVar3 = new com.alibaba.jsi.standard.js.e(bVar, 0, bArr.length);
                        eVar3.f(bVar).put(bArr);
                        oVar.a(bVar, str, eVar3);
                        eVar3.a();
                    } else {
                        w wVarA = a(bVar, JSON.toJSON(value));
                        oVar.a(bVar, str, wVarA);
                        wVarA.a();
                    }
                }
            }
            return oVar;
        }
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            com.alibaba.jsi.standard.js.d dVar = new com.alibaba.jsi.standard.js.d(bVar);
            for (int i2 = 0; i2 < jSONArray.size(); i2++) {
                Object obj2 = jSONArray.get(i2);
                if (obj2 == null) {
                    y yVar2 = new y(false);
                    dVar.a(bVar, i2, yVar2);
                    yVar2.a();
                } else if (obj2 instanceof Boolean) {
                    com.alibaba.jsi.standard.js.f fVar2 = new com.alibaba.jsi.standard.js.f(((Boolean) obj2).booleanValue());
                    dVar.a(bVar, i2, fVar2);
                    fVar2.a();
                } else if (obj2 instanceof Float) {
                    com.alibaba.jsi.standard.js.m mVar6 = new com.alibaba.jsi.standard.js.m(((Float) obj2).doubleValue());
                    dVar.a(bVar, i2, mVar6);
                    mVar6.a();
                } else if (obj2 instanceof Double) {
                    com.alibaba.jsi.standard.js.m mVar7 = new com.alibaba.jsi.standard.js.m(((Double) obj2).doubleValue());
                    dVar.a(bVar, i2, mVar7);
                    mVar7.a();
                } else if (obj2 instanceof BigDecimal) {
                    com.alibaba.jsi.standard.js.m mVar8 = new com.alibaba.jsi.standard.js.m(((BigDecimal) obj2).doubleValue());
                    dVar.a(bVar, i2, mVar8);
                    mVar8.a();
                } else if (obj2 instanceof Integer) {
                    com.alibaba.jsi.standard.js.m mVar9 = new com.alibaba.jsi.standard.js.m(((Integer) obj2).intValue());
                    dVar.a(bVar, i2, mVar9);
                    mVar9.a();
                } else if (obj2 instanceof Long) {
                    com.alibaba.jsi.standard.js.m mVar10 = new com.alibaba.jsi.standard.js.m(((Long) obj2).doubleValue());
                    dVar.a(bVar, i2, mVar10);
                    mVar10.a();
                } else if (obj2 instanceof String) {
                    s sVar2 = new s((String) obj2);
                    dVar.a(bVar, i2, sVar2);
                    sVar2.a();
                } else if (obj2 instanceof ByteBuffer) {
                    ByteBuffer byteBuffer2 = (ByteBuffer) obj2;
                    if (byteBuffer2.isDirect()) {
                        com.alibaba.jsi.standard.js.e eVar4 = new com.alibaba.jsi.standard.js.e(bVar, 0, byteBuffer2);
                        dVar.a(bVar, i2, eVar4);
                        eVar4.a();
                    } else {
                        com.alibaba.jsi.standard.js.e eVar5 = new com.alibaba.jsi.standard.js.e(bVar, 0, byteBuffer2.capacity());
                        eVar5.f(bVar).put(byteBuffer2);
                        dVar.a(bVar, i2, eVar5);
                        eVar5.a();
                    }
                } else if (obj2 instanceof byte[]) {
                    RVLogger.d(b, "http-request responseType is arrayBuffer");
                    byte[] bArr2 = (byte[]) obj2;
                    com.alibaba.jsi.standard.js.e eVar6 = new com.alibaba.jsi.standard.js.e(bVar, 0, bArr2.length);
                    eVar6.f(bVar).put(bArr2);
                    dVar.a(bVar, i2, eVar6);
                    eVar6.a();
                } else {
                    w wVarA2 = a(bVar, JSON.toJSON(obj2));
                    dVar.a(bVar, i2, wVarA2);
                    wVarA2.a();
                }
            }
            return dVar;
        }
        throw new IllegalArgumentException("Failed to convert JSON to V8 - unsupported data: " + obj + ", class: " + obj.getClass().getName());
    }

    public static String a(com.alibaba.jsi.standard.js.a aVar) {
        int iA = aVar.a();
        com.alibaba.jsi.standard.b bVarB = aVar.b();
        String str = "[" + iA + "] {";
        for (int i = 0; i < iA; i++) {
            if (i > 0) {
                str = str + ", ";
            }
            w wVarA = aVar.a(i);
            if (wVarA != null) {
                str = str + wVarA.a_(bVarB);
                wVarA.a();
            } else {
                str = str + "(null)";
            }
        }
        return str + "}";
    }

    public static String a(Context context, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            InputStream inputStreamOpenRawResource = context.getResources().openRawResource(i);
            for (int i2 = inputStreamOpenRawResource.read(); i2 != -1; i2 = inputStreamOpenRawResource.read()) {
                byteArrayOutputStream.write(i2);
            }
            inputStreamOpenRawResource.close();
            return byteArrayOutputStream.toString();
        } catch (Throwable th) {
            RVLogger.e(b, "readRawFile error: " + th);
            return null;
        }
    }

    public static String a(long j, long j2) {
        return String.valueOf(j2 - j);
    }
}
