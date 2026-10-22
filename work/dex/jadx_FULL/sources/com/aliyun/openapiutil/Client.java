package com.aliyun.openapiutil;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import androidx.room.FtsOptions;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.triver.kit.api.model.SubscribeResouceItemModel;
import com.alipay.sdk.m.t.e;
import com.alipay.sdk.m.y.l;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.TeaRequest;
import com.aliyun.tea.utils.StringUtils;
import com.baidu.mapauto.auth.util.RSAUtil;
import com.google.gson.GsonBuilder;
import com.zj.adlib.b85;
import com.zj.adlib.cs4;
import com.zj.adlib.fx3;
import com.zj.adlib.hs7;
import com.zj.adlib.u15;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SimpleTimeZone;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.c;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Client {
    public static final String ALGORITHM_NAME = "HmacSHA1";
    public static final String HASH_SHA256 = "SHA-256";
    public static final String HASH_SM3 = "SM3";
    public static final String HMAC_SHA256 = "ACS3-HMAC-SHA256";
    public static final String HMAC_SM3 = "ACS3-HMAC-SM3";
    public static final String PEM_BEGIN = "-----BEGIN RSA PRIVATE KEY-----\n";
    public static final String PEM_END = "\n-----END RSA PRIVATE KEY-----";
    public static final String RSA_SHA256 = "ACS3-RSA-SHA256";
    public static final String SEPARATOR = "&";
    public static final String URL_ENCODING = "UTF-8";
    public static final String UTF8 = "UTF-8";

    public static byte[] SignatureMethod(String str, String str2, String str3) throws Exception {
        if (str == null || str2 == null || "".equals(str2) || str3 == null) {
            return null;
        }
        if (str3.equals(HMAC_SHA256)) {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(str2.getBytes(), "HmacSHA256"));
            return mac.doFinal(str.getBytes());
        }
        if (str3.equals(RSA_SHA256)) {
            String strCheckRSASecret = checkRSASecret(str2);
            Signature signature = Signature.getInstance(RSAUtil.SIGNATURE_ALGORITHM);
            signature.initSign(KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(c.s(strCheckRSASecret))));
            signature.update(str.getBytes("UTF-8"));
            return signature.sign();
        }
        if (!str3.equals(HMAC_SM3)) {
            return null;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("UTF-8"), "HMAC-SM3");
        fx3 fx3Var = new fx3(new hs7());
        byte[] bArr = new byte[fx3Var.d()];
        byte[] bytes = str.getBytes("UTF-8");
        fx3Var.a(new cs4(secretKeySpec.getEncoded()));
        fx3Var.update(bytes, 0, bytes.length);
        fx3Var.c(bArr, 0);
        return bArr;
    }

    public static String arrayToStringWithSpecifiedStyle(Object obj, String str, String str2) throws Exception {
        if (obj == null) {
            return "";
        }
        str2.hashCode();
        switch (str2) {
            case "simple":
            case "spaceDelimited":
            case "pipeDelimited":
                return flatArray((List) obj, str2);
            case "json":
                return new GsonBuilder().disableHtmlEscaping().create().toJson(TeaModel.parseObject(obj));
            case "repeatList":
                HashMap map = new HashMap();
                map.put(str, obj);
                return toFormWithSymbol(map, "&&");
            default:
                return "";
        }
    }

    public static String checkRSASecret(String str) {
        if (str == null) {
            return str;
        }
        if (str.startsWith(PEM_BEGIN)) {
            str = str.replace(PEM_BEGIN, "");
        }
        while (true) {
            if (!str.endsWith("\n") && !str.endsWith(b85.b)) {
                break;
            }
            str = str.substring(0, str.length() - 1);
        }
        return str.endsWith(PEM_END) ? str.replace(PEM_END, "") : str;
    }

    public static void convert(TeaModel teaModel, TeaModel teaModel2) throws Exception {
        if (teaModel == null || teaModel2 == null) {
            return;
        }
        TeaModel.toModel((Map) exceptStream(teaModel.toMap()), teaModel2);
    }

    private static Object exceptStream(Object obj) throws Exception {
        if (!(obj instanceof List)) {
            if (!(obj instanceof Map)) {
                if ((obj instanceof InputStream) || (obj instanceof OutputStream)) {
                    return null;
                }
                return obj;
            }
            HashMap map = new HashMap();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object value = entry.getValue();
                if (value != null) {
                    Object objExceptStream = exceptStream(value);
                    if (objExceptStream != null) {
                        map.put(entry.getKey(), objExceptStream);
                    }
                } else {
                    map.put(entry.getKey(), value);
                }
            }
            return map;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            List list = (List) obj;
            if (i >= list.size()) {
                return arrayList;
            }
            Object obj2 = list.get(i);
            if (obj2 != null) {
                Object objExceptStream2 = exceptStream(obj2);
                if (objExceptStream2 != null) {
                    arrayList.add(objExceptStream2);
                }
            } else {
                arrayList.add(obj2);
            }
            i++;
        }
    }

    private static String flatArray(List list, String str) {
        if (list == null || list.size() <= 0 || str == null) {
            return "";
        }
        String str2 = FtsOptions.TOKENIZER_SIMPLE.equalsIgnoreCase(str) ? "," : "spaceDelimited".equalsIgnoreCase(str) ? " " : "|";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            sb.append(str2);
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public static String getAuthorization(TeaRequest teaRequest, String str, String str2, String str3, String str4) throws Exception {
        if (teaRequest == null) {
            return null;
        }
        if (str4 == null) {
            throw new Exception("Need secret!");
        }
        if (StringUtils.isEmpty((CharSequence) str)) {
            throw new Exception("Need signAlgorithm!");
        }
        String str5 = teaRequest.pathname;
        if (str5 == null || StringUtils.isEmpty((CharSequence) str5) || "".equals(str5.trim())) {
            str5 = WVNativeCallbackUtil.SEPERATER;
        }
        String str6 = teaRequest.method;
        Map<String, String> map = teaRequest.headers;
        Map<String, String> map2 = teaRequest.query;
        Map<String, String> canonicalizedHeadersMap = getCanonicalizedHeadersMap(map);
        String str7 = canonicalizedHeadersMap.get("signedHeaders");
        String strHexEncode = hexEncode(hash((str6 + "\n" + str5 + "\n" + getCanonicalizedResource(map2) + "\n" + canonicalizedHeadersMap.get("canonicalHeaders") + "\n" + str7 + "\n" + str2).getBytes("UTF-8"), str));
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("\n");
        sb.append(strHexEncode);
        return str + " Credential=" + str3 + ",SignedHeaders=" + str7 + ",Signature=" + hexEncode(SignatureMethod(sb.toString(), str4, str));
    }

    public static String getCanonicalizedHeaders(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        Set<String> setKeySet = map.keySet();
        ArrayList arrayList = new ArrayList();
        for (String str : setKeySet) {
            if (str.startsWith("x-acs-")) {
                arrayList.add(str);
            }
        }
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        Arrays.sort(strArr);
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArr) {
            sb.append(str2);
            sb.append(u15.f19942b);
            sb.append(map.get(str2).trim());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static Map<String, String> getCanonicalizedHeadersMap(Map<String, String> map) {
        HashMap map2 = new HashMap();
        if (map == null) {
            return map2;
        }
        Set<String> setKeySet = map.keySet();
        ArrayList arrayList = new ArrayList();
        HashMap map3 = new HashMap();
        for (String str : setKeySet) {
            String lowerCase = str.toLowerCase();
            if (lowerCase.startsWith("x-acs-") || lowerCase.equals(com.alipay.sdk.m.n.c.f) || lowerCase.equals(e.f)) {
                if (!arrayList.contains(lowerCase)) {
                    arrayList.add(lowerCase);
                }
                map3.put(lowerCase, map.get(str).trim());
            }
        }
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        Arrays.sort(strArr);
        String strJoin = StringUtils.join(l.b, Arrays.asList(strArr));
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArr) {
            sb.append(str2);
            sb.append(u15.f19942b);
            sb.append((String) map3.get(str2));
            sb.append("\n");
        }
        map2.put("canonicalHeaders", sb.toString());
        map2.put("signedHeaders", strJoin);
        return map2;
    }

    public static String getCanonicalizedQueryString(StringBuilder sb, Map<String, String> map, String[] strArr) throws Exception {
        if (map == null || map.size() == 0 || strArr == null || strArr.length == 0) {
            return "";
        }
        if (sb == null) {
            sb = new StringBuilder();
        }
        Arrays.sort(strArr);
        for (String str : strArr) {
            sb.append(percentEncode(str));
            String str2 = map.get(str);
            sb.append("=");
            if (!StringUtils.isEmpty((CharSequence) str2)) {
                sb.append(percentEncode(str2));
            }
            sb.append("&");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public static String getCanonicalizedQueryStringForROA(StringBuilder sb, Map<String, String> map, String[] strArr) throws Exception {
        if (map == null || map.size() == 0 || strArr == null || strArr.length == 0) {
            return "";
        }
        if (sb == null) {
            sb = new StringBuilder();
        }
        Arrays.sort(strArr);
        for (String str : strArr) {
            sb.append(str);
            String str2 = map.get(str);
            if (!StringUtils.isEmpty((CharSequence) str2)) {
                sb.append("=");
                sb.append(str2);
            }
            sb.append("&");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public static String getCanonicalizedResource(Map<String, String> map) throws Exception {
        if (map == null || map.size() == 0) {
            return "";
        }
        return getCanonicalizedQueryString(new StringBuilder(), map, (String[]) map.keySet().toArray(new String[map.size()]));
    }

    public static String getEncodeParam(String str) throws UnsupportedEncodingException {
        return StringUtils.isEmpty((CharSequence) str) ? str : percentEncode(str);
    }

    public static String getEncodePath(String str) throws UnsupportedEncodingException {
        if (StringUtils.isEmpty((CharSequence) str) || WVNativeCallbackUtil.SEPERATER.equals(str)) {
            return str;
        }
        String[] strArrSplit = str.split(WVNativeCallbackUtil.SEPERATER);
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArrSplit) {
            sb.append(percentEncode(str2));
            sb.append(WVNativeCallbackUtil.SEPERATER);
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public static String getEndpoint(String str, boolean z, String str2) {
        if ("internal".equals(str2)) {
            String[] strArrSplit = str.split("\\.");
            strArrSplit[0] = strArrSplit[0] + "-internal";
            str = StringUtils.join(Consts.DOT, Arrays.asList(strArrSplit));
        }
        return (z && "accelerate".equals(str2)) ? "oss-accelerate.aliyuncs.com" : str;
    }

    public static String getROASignature(String str, String str2) throws Exception {
        if (StringUtils.isEmpty((CharSequence) str2)) {
            return str2;
        }
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(str2.getBytes("UTF-8"), "HmacSHA1"));
        return c.A(mac.doFinal(str.getBytes("UTF-8")));
    }

    public static String getRPCSignature(Map<String, String> map, String str, String str2) throws Exception {
        if (map == null || StringUtils.isEmpty((CharSequence) str2)) {
            return str2;
        }
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
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec((str2 + "&").getBytes("UTF-8"), "HmacSHA1"));
        return c.A(mac.doFinal((str + "&" + percentEncode(WVNativeCallbackUtil.SEPERATER) + "&" + percentEncode(sb.toString().substring(1))).getBytes("UTF-8")));
    }

    public static String getStringToSign(TeaRequest teaRequest) throws Exception {
        if (teaRequest == null) {
            return "";
        }
        String str = teaRequest.method;
        String str2 = teaRequest.pathname;
        Map<String, String> map = teaRequest.headers;
        Map<String, String> map2 = teaRequest.query;
        return (str + "\n" + (map.get(SubscribeResouceItemModel.ACCEPT) == null ? "" : map.get(SubscribeResouceItemModel.ACCEPT)) + "\n" + (map.get("content-md5") == null ? "" : map.get("content-md5")) + "\n" + (map.get(e.f) == null ? "" : map.get(e.f)) + "\n" + (map.get("date") != null ? map.get("date") : "") + "\n") + getCanonicalizedHeaders(map) + getCanonicalizedResource(str2, map2);
    }

    public static String getTimestamp() throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "UTC"));
        return simpleDateFormat.format(new Date());
    }

    public static byte[] hash(byte[] bArr, String str) throws Exception {
        if (str == null) {
            return null;
        }
        if (str.equals(HMAC_SHA256) || str.equals(RSA_SHA256)) {
            return MessageDigest.getInstance(HASH_SHA256).digest(bArr);
        }
        if (str.equals(HMAC_SM3)) {
            return MessageDigest.getInstance(HASH_SM3, (Provider) new BouncyCastleProvider()).digest(bArr);
        }
        return null;
    }

    public static String hexEncode(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString();
    }

    public static Object mapToFlatStyle(Object obj) throws Exception {
        if (obj == null) {
            return obj;
        }
        int i = 0;
        if (!(obj instanceof List)) {
            if (!(obj instanceof TeaModel)) {
                if (!(obj instanceof Map)) {
                    return obj;
                }
                HashMap map = new HashMap();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    map.put("#" + ((String) entry.getKey()).length() + "#" + ((String) entry.getKey()), mapToFlatStyle(entry.getValue()));
                }
                return map;
            }
            TeaModel teaModel = (TeaModel) obj;
            Field[] fields = teaModel.getClass().getFields();
            int length = fields.length;
            while (i < length) {
                Field field = fields[i];
                Object obj2 = field.get(obj);
                if (obj2 instanceof Map) {
                    HashMap map2 = new HashMap();
                    for (Map.Entry entry2 : ((Map) obj2).entrySet()) {
                        map2.put("#" + ((String) entry2.getKey()).length() + "#" + ((String) entry2.getKey()), mapToFlatStyle(entry2.getValue()));
                    }
                    field.set(obj, map2);
                } else {
                    field.set(obj, mapToFlatStyle(obj2));
                }
                i++;
            }
            return teaModel;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            List list = (List) obj;
            if (i >= list.size()) {
                return arrayList;
            }
            arrayList.add(mapToFlatStyle(list.get(i)));
            i++;
        }
    }

    public static Map<String, Object> parseToMap(Object obj) {
        if (obj == null) {
            return null;
        }
        return (Map) TeaModel.parseObject(obj);
    }

    public static String percentEncode(String str) throws UnsupportedEncodingException {
        if (str != null) {
            return URLEncoder.encode(str, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
        }
        return null;
    }

    private static void processObject(Map<String, String> map, String str, Object obj) throws UnsupportedEncodingException {
        if (obj == null) {
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
                processObject(map, sb.toString(), list.get(i));
                i = i2;
            }
            return;
        }
        if (obj instanceof TeaModel) {
            for (Map.Entry<String, Object> entry : ((TeaModel) obj).toMap().entrySet()) {
                processObject(map, str + Consts.DOT + entry.getKey(), entry.getValue());
            }
            return;
        }
        if (!(obj instanceof Map)) {
            if (str.startsWith(Consts.DOT)) {
                str = str.substring(1);
            }
            if (obj instanceof byte[]) {
                map.put(str, new String((byte[]) obj, "UTF-8"));
                return;
            } else {
                map.put(str, String.valueOf(obj));
                return;
            }
        }
        for (Map.Entry entry2 : ((Map) obj).entrySet()) {
            processObject(map, str + Consts.DOT + ((String) entry2.getKey()), entry2.getValue());
        }
    }

    public static Map<String, String> query(Map<String, ?> map) throws Exception {
        HashMap map2 = new HashMap();
        if (map != null) {
            processObject(map2, "", map);
        }
        return map2;
    }

    public static String toForm(Map<String, ?> map) throws Exception {
        return toFormWithSymbol(map, "&");
    }

    private static String toFormWithSymbol(Map<String, ?> map, String str) throws Exception {
        Map<String, String> mapQuery = query(map);
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry<String, String> entry : mapQuery.entrySet()) {
            if (!StringUtils.isEmpty((Object) entry.getValue())) {
                if (z) {
                    z = false;
                } else {
                    sb.append(str);
                }
                sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(String.valueOf(entry.getValue()), "UTF-8"));
            }
        }
        return sb.toString();
    }

    public static String getCanonicalizedResource(String str, Map<String, String> map) throws Exception {
        if (map == null || map.size() == 0) {
            return str;
        }
        String[] strArr = (String[]) map.keySet().toArray(new String[map.size()]);
        if (str == null || strArr.length <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        sb.append("?");
        return getCanonicalizedQueryStringForROA(sb, map, strArr);
    }
}
