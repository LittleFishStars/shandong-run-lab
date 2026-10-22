package com.aliyun.credentials.utils;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import com.aliyun.credentials.exception.CredentialException;
import com.aliyun.credentials.http.MethodType;
import com.zj.adlib.l72;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.SimpleTimeZone;
import java.util.UUID;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ParameterHelper {
    private static final String ALGORITHM_NAME = "HmacSHA1";
    public static final String ENCODING = "UTF-8";
    private static final String FORMAT_ISO8601 = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    private static final String SEPARATOR = "&";
    private static final String TIME_ZONE = "UTC";

    public static String getISO8601Time(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_ISO8601);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, TIME_ZONE));
        return simpleDateFormat.format(date);
    }

    public static Date getUTCDate(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_ISO8601);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, TIME_ZONE));
        try {
            return simpleDateFormat.parse(str);
        } catch (ParseException e) {
            throw new CredentialException(e.getMessage(), e);
        }
    }

    public static String getUniqueNonce() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(UUID.randomUUID().toString());
        stringBuffer.append(System.currentTimeMillis());
        stringBuffer.append(Thread.currentThread().getId());
        return stringBuffer.toString();
    }

    public String composeStringToSign(MethodType methodType, Map<String, String> map) {
        String[] strArr = (String[]) map.keySet().toArray(new String[0]);
        Arrays.sort(strArr);
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append("&");
            sb.append(AcsURLEncoder.percentEncode(str));
            sb.append("=");
            sb.append(AcsURLEncoder.percentEncode(map.get(str)));
        }
        return methodType.toString() + "&" + AcsURLEncoder.percentEncode(WVNativeCallbackUtil.SEPERATER) + "&" + AcsURLEncoder.percentEncode(sb.toString().substring(1));
    }

    public String composeUrl(String str, Map<String, String> map, String str2) {
        StringBuilder sb = new StringBuilder("");
        sb.append(str2);
        sb.append("://");
        sb.append(str);
        sb.append("/?");
        StringBuilder sb2 = new StringBuilder("");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value != null) {
                sb2.append(AcsURLEncoder.encode(key));
                sb2.append("=");
                sb2.append(AcsURLEncoder.encode(value));
                sb2.append("&");
            }
        }
        sb2.deleteCharAt(sb2.length() - 1);
        sb.append(sb2.toString());
        return sb.toString();
    }

    public String signString(String str, String str2) {
        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(new SecretKeySpec(str2.getBytes("UTF-8"), "HmacSHA1"));
            return l72.v(mac.doFinal(str.getBytes("UTF-8")));
        } catch (Exception e) {
            throw new CredentialException(e.getMessage(), e);
        }
    }
}
