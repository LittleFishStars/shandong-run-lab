package com.aliyun.teautil;

import androidx.camera.video.AudioStats;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.utils.StringUtils;
import com.aliyun.teautil.models.TeaUtilException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.SimpleTimeZone;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class Common {
    private static final String defaultUserAgent;
    private static AtomicLong seqId = new AtomicLong(0);
    private static final long processStartTime = System.currentTimeMillis();

    static {
        Properties properties = System.getProperties();
        defaultUserAgent = String.format("AlibabaCloud (%s; %s) Java/%s %s/%s TeaDSL/1", properties.getProperty("os.name"), properties.getProperty("os.arch"), properties.getProperty("java.runtime.version"), "tea-util", JavaProject.teaUtilVersion);
    }

    public static Map<String, Object> anyifyMapValue(Map<String, ?> map) {
        HashMap map2 = new HashMap();
        if (map == null) {
            return null;
        }
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            map2.put(entry.getKey(), entry.getValue());
        }
        return map2;
    }

    public static List<Object> assertAsArray(Object obj) {
        if (obj == null || !List.class.isAssignableFrom(obj.getClass())) {
            throw new TeaUtilException("The value is not a array");
        }
        return (List) obj;
    }

    public static Boolean assertAsBoolean(Object obj) {
        try {
            return (Boolean) obj;
        } catch (Exception unused) {
            throw new TeaUtilException("The value is not a Boolean");
        }
    }

    public static byte[] assertAsBytes(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        throw new TeaUtilException("The value is not a byteArray");
    }

    public static Integer assertAsInteger(Object obj) {
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        throw new TeaUtilException("The value is not a Integer");
    }

    public static Map<String, Object> assertAsMap(Object obj) {
        if (obj == null || !Map.class.isAssignableFrom(obj.getClass())) {
            throw new TeaUtilException("The value is not a object");
        }
        return (Map) obj;
    }

    public static Number assertAsNumber(Object obj) {
        if (obj instanceof Number) {
            return (Number) obj;
        }
        throw new TeaUtilException("The value is not a Number");
    }

    public static InputStream assertAsReadable(Object obj) {
        if (obj == null || !InputStream.class.isAssignableFrom(obj.getClass())) {
            throw new TeaUtilException("The value is not a readable");
        }
        return (InputStream) obj;
    }

    public static String assertAsString(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        throw new TeaUtilException("The value is not a String");
    }

    public static Number defaultNumber(Number number, Number number2) {
        return (number == null || number.doubleValue() < AudioStats.AUDIO_AMPLITUDE_NONE) ? number2 : number;
    }

    public static String defaultString(String str, String str2) {
        return !StringUtils.isEmpty((CharSequence) str) ? str : str2;
    }

    public static boolean empty(String str) {
        return StringUtils.isEmpty((CharSequence) str);
    }

    public static boolean equalNumber(Number number, Number number2) {
        return (number == null || number2 == null || number.doubleValue() != number2.doubleValue()) ? false : true;
    }

    public static boolean equalString(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public static String getDateUTCString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        return simpleDateFormat.format(new Date());
    }

    public static String getNonce() {
        long id = Thread.currentThread().getId();
        long jCurrentTimeMillis = System.currentTimeMillis();
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        long andIncrement = seqId.getAndIncrement();
        long jNextLong = threadLocalRandomCurrent.nextLong();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(processStartTime);
        stringBuffer.append('-');
        stringBuffer.append(id);
        stringBuffer.append('-');
        stringBuffer.append(jCurrentTimeMillis);
        stringBuffer.append('-');
        stringBuffer.append(andIncrement);
        stringBuffer.append('-');
        stringBuffer.append(jNextLong);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bytes = stringBuffer.toString().getBytes();
            stringBuffer.setLength(0);
            for (byte b : messageDigest.digest(bytes)) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() < 2) {
                    stringBuffer.append(0);
                }
                stringBuffer.append(hexString);
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new TeaUtilException(e.getMessage(), e);
        }
    }

    public static String getUserAgent(String str) {
        if (StringUtils.isEmpty((CharSequence) str)) {
            return defaultUserAgent;
        }
        return defaultUserAgent + " " + str;
    }

    public static boolean is2xx(Number number) {
        return number != null && number.intValue() >= 200 && number.intValue() < 300;
    }

    public static boolean is3xx(Number number) {
        return number != null && number.intValue() >= 300 && number.intValue() < 400;
    }

    public static boolean is4xx(Number number) {
        return number != null && number.intValue() >= 400 && number.intValue() < 500;
    }

    public static boolean is5xx(Number number) {
        return number != null && number.intValue() >= 500 && number.intValue() < 600;
    }

    public static boolean isUnset(Object obj) {
        return obj == null;
    }

    public static Object parseJSON(String str) {
        Gson gsonCreate = new GsonBuilder().registerTypeAdapter(new TypeToken<Map<String, Object>>() { // from class: com.aliyun.teautil.Common.1
        }.getType(), new MapTypeAdapter()).create();
        return ((JsonElement) gsonCreate.fromJson(str, JsonElement.class)).isJsonArray() ? gsonCreate.fromJson(str, List.class) : gsonCreate.fromJson(str, new TypeToken<Map<String, Object>>() { // from class: com.aliyun.teautil.Common.2
        }.getType());
    }

    public static byte[] readAsBytes(InputStream inputStream) {
        try {
            try {
                if (inputStream == null) {
                    byte[] bArr = new byte[0];
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            throw new TeaUtilException(e.getMessage(), e);
                        }
                    }
                    return bArr;
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr2 = new byte[1024];
                while (true) {
                    int i = inputStream.read(bArr2);
                    if (i == -1) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        try {
                            inputStream.close();
                            return byteArray;
                        } catch (IOException e2) {
                            throw new TeaUtilException(e2.getMessage(), e2);
                        }
                    }
                    byteArrayOutputStream.write(bArr2, 0, i);
                }
            } catch (Exception e3) {
                throw new TeaUtilException(e3.getMessage(), e3);
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    throw new TeaUtilException(e4.getMessage(), e4);
                }
            }
            throw th;
        }
    }

    public static Object readAsJSON(InputStream inputStream) {
        String asString = readAsString(inputStream);
        try {
            return parseJSON(asString);
        } catch (Exception unused) {
            throw new TeaUtilException("Error: convert to JSON, response is:\n" + asString);
        }
    }

    public static String readAsString(InputStream inputStream) {
        try {
            return new String(readAsBytes(inputStream), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new TeaUtilException(e.getMessage(), e);
        }
    }

    public static void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            throw new TeaUtilException(e.getMessage(), e);
        }
    }

    public static Map<String, String> stringifyMapValue(Map<String, ?> map) {
        HashMap map2 = new HashMap();
        if (map == null) {
            return null;
        }
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            if (entry.getValue() != null) {
                map2.put(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        return map2;
    }

    public static List<Map<String, Object>> toArray(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (TeaModel teaModel : (List) obj) {
                if (teaModel != null) {
                    arrayList.add(teaModel.toMap());
                }
            }
            return arrayList;
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] toBytes(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new TeaUtilException(e.getMessage(), e);
        }
    }

    public static String toFormString(Map<String, ?> map) {
        if (map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            boolean z = true;
            for (Map.Entry<String, ?> entry : map.entrySet()) {
                if (!StringUtils.isEmpty(entry.getValue())) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append("&");
                    }
                    sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                    sb.append("=");
                    sb.append(URLEncoder.encode(String.valueOf(entry.getValue()), "UTF-8"));
                }
            }
            return sb.toString();
        } catch (Exception e) {
            throw new TeaUtilException(e.getMessage(), e);
        }
    }

    public static String toJSONString(Object obj) {
        return obj instanceof String ? (String) obj : new GsonBuilder().disableHtmlEscaping().create().toJson(obj);
    }

    public static Map<String, Object> toMap(TeaModel teaModel) {
        try {
            return TeaModel.toMap(teaModel);
        } catch (Exception e) {
            throw new TeaUtilException(e.getMessage(), e);
        }
    }

    public static String toString(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new TeaUtilException(e.getMessage(), e);
        }
    }

    public static void validateModel(TeaModel teaModel) {
        if (teaModel == null) {
            throw new TeaUtilException("parameter is not allowed as null");
        }
        try {
            teaModel.validate();
        } catch (Exception e) {
            throw new TeaUtilException(e.getMessage(), e);
        }
    }
}
