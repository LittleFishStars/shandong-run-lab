package com.czhj.sdk.common.json;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.czhj.sdk.logger.SigmobLog;
import com.google.common.net.c;
import com.zj.adlib.bv9;
import com.zj.adlib.u15;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class JSONSerializer {
    private static final String[] HTML_SAFE_REPLACEMENT_CHARS;
    private static final String[] REPLACEMENT_CHARS = new String[128];
    private static final Pattern linePattern;

    static {
        for (int i = 0; i <= 31; i++) {
            REPLACEMENT_CHARS[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = REPLACEMENT_CHARS;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        HTML_SAFE_REPLACEMENT_CHARS = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
        linePattern = Pattern.compile("_(\\w)");
    }

    @SuppressLint({"UseSparseArrays"})
    public static String Serialize(Object obj) throws CyclicObjectException {
        return Serialize(obj, new HashMap(), null, false, false);
    }

    public static String Serialize(Object obj, String str) throws CyclicObjectException {
        return Serialize(obj, new HashMap(), str, false, false);
    }

    public static String Serialize(Object obj, String str, boolean z) throws CyclicObjectException {
        return Serialize(obj, new HashMap(), str, z, false);
    }

    public static String Serialize(Object obj, String str, boolean z, boolean z2) throws CyclicObjectException {
        return Serialize(obj, new HashMap(), str, z, z2);
    }

    private static String Serialize(Object obj, HashMap<Integer, Object> map, String str, boolean z, boolean z2) throws CyclicObjectException {
        String strSerializePrimitive;
        if (obj == null) {
            return "null";
        }
        Class<?> cls = obj.getClass();
        if (obj instanceof String) {
            strSerializePrimitive = SerializeString((String) obj);
        } else if (cls.isPrimitive() || cls == Boolean.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == Byte.class || cls == Character.class) {
            strSerializePrimitive = SerializePrimitive(obj);
        } else {
            if (!z2 && map.get(Integer.valueOf(obj.hashCode())) != null) {
                return "null";
            }
            strSerializePrimitive = null;
        }
        map.put(Integer.valueOf(obj.hashCode()), obj);
        if (TextUtils.isEmpty(strSerializePrimitive)) {
            if (obj instanceof List) {
                List list = (List) obj;
                strSerializePrimitive = SerializeArray(list.toArray(new Object[list.size()]), map, z, z2);
            } else if (obj instanceof Map) {
                strSerializePrimitive = SerializeMap((Map) obj, map, z, z2);
            } else {
                strSerializePrimitive = cls.isArray() ? SerializeArray(obj, map, z, z2) : SerializeObject(obj, map, z, z2);
            }
        }
        if (TextUtils.isEmpty(str)) {
            return strSerializePrimitive;
        }
        StringBuilder sb = new StringBuilder(bv9.b);
        if (z) {
            str = lineToHump(str);
        }
        sb.append(SerializeString(str));
        sb.append(c.b);
        sb.append(strSerializePrimitive);
        sb.append('}');
        return sb.toString();
    }

    private static String SerializeArray(Object obj, HashMap<Integer, Object> map, boolean z, boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            sb.append(Serialize(Array.get(obj, i), map, null, z, z2));
            if (i < length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private static String SerializeMap(Map map, HashMap<Integer, Object> map2, boolean z, boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append(bv9.b);
        boolean z3 = false;
        for (Map.Entry entry : map.entrySet()) {
            String string = entry.getKey().toString();
            Object value = entry.getValue();
            if (z3) {
                sb.append(",");
            }
            String strSerializeString = SerializeString(string);
            if (z) {
                strSerializeString = lineToHump(strSerializeString);
            }
            sb.append(strSerializeString);
            sb.append(u15.f19942b);
            sb.append(Serialize(value, map2, null, z, z2));
            z3 = true;
        }
        sb.append("}");
        return sb.toString();
    }

    private static String SerializeObject(Object obj, HashMap<Integer, Object> map, boolean z, boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append(bv9.b);
        boolean z3 = false;
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object obj2 = field.get(obj);
                String name = field.getName();
                boolean zIsStatic = Modifier.isStatic(field.getModifiers());
                boolean zIsAnnotationPresent = field.isAnnotationPresent(Transient.class);
                if (!name.startsWith("this$") && !zIsStatic && (obj2 == null || !zIsAnnotationPresent)) {
                    if (z3) {
                        sb.append(",");
                    }
                    String strSerializeString = SerializeString(name);
                    if (z) {
                        strSerializeString = lineToHump(strSerializeString);
                    }
                    sb.append(strSerializeString);
                    sb.append(u15.f19942b);
                    sb.append(Serialize(obj2, map, null, z, z2));
                    z3 = true;
                }
            } catch (Throwable th) {
                SigmobLog.e("json seriallize error", th);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    private static String SerializePrimitive(Object obj) {
        return obj.toString();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0030 A[Catch: all -> 0x0047, TryCatch #0 {all -> 0x0047, blocks: (B:3:0x0009, B:5:0x0014, B:7:0x001c, B:19:0x003a, B:17:0x0030, B:18:0x0035, B:21:0x003f, B:22:0x0043), top: B:28:0x0009 }] */
    private static String SerializeString(String str) {
        String str2;
        String[] strArr = HTML_SAFE_REPLACEMENT_CHARS;
        StringWriter stringWriter = new StringWriter();
        try {
            stringWriter.write(34);
            int length = str.length();
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = str.charAt(i2);
                if (cCharAt < 128) {
                    str2 = strArr[cCharAt];
                    if (str2 != null) {
                        if (i < i2) {
                            stringWriter.write(str, i, i2 - i);
                        }
                        stringWriter.write(str2);
                        i = i2 + 1;
                    }
                } else {
                    if (cCharAt == 8232) {
                        str2 = "\\u2028";
                    } else if (cCharAt == 8233) {
                        str2 = "\\u2029";
                    }
                    if (i < i2) {
                        stringWriter.write(str, i, i2 - i);
                    }
                    stringWriter.write(str2);
                    i = i2 + 1;
                }
            }
            if (i < length) {
                stringWriter.write(str, i, length - i);
            }
            stringWriter.write(34);
        } catch (Throwable th) {
            SigmobLog.e("SerializeString", th);
        }
        return stringWriter.toString();
    }

    private static String lineToHump(String str) {
        Pattern pattern = linePattern;
        if (!pattern.matcher(str).find()) {
            return str;
        }
        Matcher matcher = pattern.matcher(str.toLowerCase());
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}
