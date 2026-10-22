package com.aliyun.common;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import androidx.camera.video.AudioStats;
import com.alibaba.android.arouter.utils.Consts;
import com.alipay.sdk.m.t.e;
import com.aliyun.common.models.ErrorResponse;
import com.aliyun.common.utils.XmlUtil;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.TeaRequest;
import com.aliyun.tea.TeaResponse;
import com.aliyun.tea.utils.StringUtils;
import com.google.gson.Gson;
import com.zj.adlib.l72;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.SimpleTimeZone;
import java.util.UUID;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Common {
    public static final String ALGORITHM_NAME = "HmacSHA1";
    public static final String SEPARATOR = "&";
    public static final String URL_ENCODING = "UTF-8";
    public static final String coreVersion = "0.1.0";
    public static final String defaultUserAgent;

    static {
        Properties properties = System.getProperties();
        defaultUserAgent = String.format("AlibabaCloud (%s; %s) Java/%s %s/%s TeaDSL/1", properties.getProperty("os.name"), properties.getProperty("os.arch"), properties.getProperty("java.runtime.version"), "Common", coreVersion);
    }

    public static String _default(String str, String str2) {
        return !StringUtils.isEmpty((CharSequence) str) ? str : str2;
    }

    public static void convert(TeaModel teaModel, TeaModel teaModel2) {
        if (teaModel == null || teaModel2 == null) {
            return;
        }
        try {
            Class<?> cls = teaModel.getClass();
            Class<?> cls2 = teaModel2.getClass();
            Field[] declaredFields = cls.getDeclaredFields();
            TeaModel teaModel3 = (TeaModel) cls.newInstance();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                if (!InputStream.class.isAssignableFrom(field.getType())) {
                    field.set(teaModel3, field.get(teaModel));
                }
            }
            Gson gson = new Gson();
            Object objFromJson = gson.fromJson(gson.toJson(teaModel3), (Class<Object>) cls2);
            for (Field field2 : objFromJson.getClass().getFields()) {
                field2.setAccessible(true);
                field2.set(teaModel2, field2.get(objFromJson));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Number defaultNumber(Integer num, long j) {
        return (num == null || num.intValue() < 0) ? Long.valueOf(j) : num;
    }

    public static boolean empty(String str) {
        return StringUtils.isEmpty((CharSequence) str);
    }

    public static boolean equal(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public static String getBoundary() {
        return String.format("%014d", Long.valueOf((long) (Math.random() * 1.0E14d)));
    }

    public static String getDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        return simpleDateFormat.format(new Date());
    }

    public static String getEndpoint(String str, boolean z, String str2) {
        if ("internal".equals(str2)) {
            String[] strArrSplit = str.split("\\.");
            strArrSplit[0] = strArrSplit[0] + "-internal";
            str = StringUtils.join(Consts.DOT, Arrays.asList(strArrSplit));
        }
        return (z && "accelerate".equals(str2)) ? "oss-accelerate.aliyuncs.com" : str;
    }

    public static Map<String, Object> getErrMessage(String str) {
        try {
            Map<String, Object> mapDeserializeXml = XmlUtil.DeserializeXml(str, ErrorResponse.class);
            return mapDeserializeXml.get("Error") == null ? mapDeserializeXml : (Map) mapDeserializeXml.get("Error");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getHost(String str, String str2, String str3) {
        return str3 == null ? String.format("%s.%s.aliyuncs.com", str.split("\\_")[0].toLowerCase(), str2) : str3;
    }

    public static String getNonce() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(UUID.randomUUID().toString());
        stringBuffer.append(System.currentTimeMillis());
        stringBuffer.append(Thread.currentThread().getId());
        return stringBuffer.toString();
    }

    public static String getOpenPlatFormEndpoint(String str, String str2) {
        if (StringUtils.isEmpty((CharSequence) str2)) {
            return str;
        }
        Iterator it = Arrays.asList("ap-southeast-1", "ap-northeast-1", "eu-central-1", "cn-hongkong", "ap-south-1").iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (((String) it.next()).equals(str2.toLowerCase())) {
                z = true;
            }
        }
        if (!z) {
            return str;
        }
        String[] strArrSplit = str.split("\\.");
        strArrSplit[0] = strArrSplit[0] + Consts.DOT + str2;
        return StringUtils.join(Consts.DOT, Arrays.asList(strArrSplit));
    }

    public static String getSignature(TeaRequest teaRequest, String str) {
        return getSignature(teaRequest.query, teaRequest.method, str);
    }

    public static String getSignatureV1(Map<String, String> map, String str, String str2) {
        return getSignature(map, str, str2);
    }

    public static String getTimestamp() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "UTC"));
        return simpleDateFormat.format(new Date());
    }

    public static String getUserAgent() {
        return getUserAgent(null);
    }

    public static boolean hasError(Map<String, ?> map) {
        if (map == null) {
            return true;
        }
        try {
            Object obj = map.get("Code");
            return obj != null && Double.parseDouble(String.valueOf(obj)) > AudioStats.AUDIO_AMPLITUDE_NONE;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean isFail(TeaResponse teaResponse) {
        if (teaResponse == null) {
            return false;
        }
        int i = teaResponse.statusCode;
        return 200 > i || 300 <= i;
    }

    public static Map<String, Object> json(TeaResponse teaResponse) {
        try {
            return (Map) new Gson().fromJson(teaResponse.getResponseBody(), Map.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, Object> parseXml(String str, Class<?> cls) {
        try {
            return XmlUtil.DeserializeXml(str, cls);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String percentEncode(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLEncoder.encode(str, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private static void processeObject(Map<String, String> map, String str, Object obj) {
        if (StringUtils.isEmpty(obj)) {
            return;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int i = 0;
            while (i < list.size()) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(Consts.DOT);
                int i2 = i + 1;
                sb.append(i2);
                processeObject(map, sb.toString(), list.get(i));
                i = i2;
            }
            return;
        }
        if (!(obj instanceof Map)) {
            if (str.startsWith(Consts.DOT)) {
                str = str.substring(1);
            }
            map.put(str, String.valueOf(obj));
            return;
        }
        for (Map.Entry entry : ((Map) obj).entrySet()) {
            processeObject(map, str + Consts.DOT + ((String) entry.getKey()), entry.getValue());
        }
    }

    public static Map<String, String> query(Map<String, ?> map) {
        HashMap map2 = new HashMap();
        if (map != null) {
            processeObject(map2, "", map);
        }
        return map2;
    }

    public static String readAsString(InputStream inputStream) {
        if (inputStream == null) {
            return "";
        }
        try {
            byte[] bArr = new byte[4096];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int i = inputStream.read(bArr);
                if (i <= 0) {
                    return byteArrayOutputStream.toString("UTF-8");
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static InputStream toForm(Map<String, ?> map, InputStream inputStream, String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (map == null) {
            return inputStream;
        }
        StringBuilder sb = new StringBuilder();
        Object objRemove = map.remove("file");
        if (!StringUtils.isEmpty(map.get("UserMeta"))) {
            for (Map.Entry entry : ((Map) map.remove("UserMeta")).entrySet()) {
                sb.append("--");
                sb.append(str);
                sb.append("\r\n");
                sb.append("Content-Disposition: form-data; name=\"x-oss-meta-");
                sb.append((String) entry.getKey());
                sb.append("\"\r\n\r\n");
                sb.append((String) entry.getValue());
                sb.append("\r\n");
            }
        }
        for (Map.Entry<String, ?> entry2 : map.entrySet()) {
            if (!StringUtils.isEmpty(entry2.getValue())) {
                sb.append("--");
                sb.append(str);
                sb.append("\r\n");
                sb.append("Content-Disposition: form-data; name=\"");
                sb.append(entry2.getKey());
                sb.append("\"\r\n\r\n");
                sb.append(entry2.getValue());
                sb.append("\r\n");
            }
        }
        try {
            if (objRemove != null) {
                Map<String, Object> map2 = ((TeaModel) objRemove).toMap();
                sb.append("--");
                sb.append(str);
                sb.append("\r\n");
                sb.append("Content-Disposition: form-data; name=\"file\"; filename=\"");
                sb.append(map2.get("filename"));
                sb.append("\"\r\n");
                sb.append("Content-Type: ");
                sb.append(map2.get(e.f));
                sb.append("\r\n\r\n");
                byteArrayOutputStream.write(sb.toString().getBytes("UTF-8"));
                byte[] bArr = new byte[4096];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                }
                inputStream.close();
                byteArrayOutputStream.write("\r\n".getBytes("UTF-8"));
            } else {
                byteArrayOutputStream.write(sb.toString().getBytes("UTF-8"));
            }
            byteArrayOutputStream.write(("--" + str + "--\r\n").getBytes());
            byteArrayOutputStream.flush();
            return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String getSignature(Map<String, String> map, String str, String str2) {
        String[] strArr = (String[]) map.keySet().toArray(new String[0]);
        Arrays.sort(strArr);
        StringBuilder sb = new StringBuilder();
        for (String str3 : strArr) {
            if (!StringUtils.isEmpty((CharSequence) map.get(str3))) {
                sb.append("&");
                sb.append(percentEncode(str3));
                sb.append("=");
                sb.append(percentEncode(map.get(str3)));
            }
        }
        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(new SecretKeySpec((str2 + "&").getBytes("UTF-8"), "HmacSHA1"));
            return l72.v(mac.doFinal((str + "&" + percentEncode(WVNativeCallbackUtil.SEPERATER) + "&" + percentEncode(sb.toString().substring(1))).getBytes("UTF-8")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getUserAgent(String str) {
        if (StringUtils.isEmpty((CharSequence) str)) {
            return defaultUserAgent;
        }
        return defaultUserAgent + " " + str;
    }
}
