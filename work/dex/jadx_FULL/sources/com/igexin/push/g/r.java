package com.igexin.push.g;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.zj.adlib.u15;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38160a = "com.igexin.push.g.r";
    public static final String b = "utf-8";
    private static final String c = "POST";
    private static final String d = "GET";
    private static final String e = "GETUI";
    private static final int f = 30000;

    private static String a(InputStream inputStream, String str) throws Exception {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str));
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[256];
            while (true) {
                int i = bufferedReader.read(cArr);
                if (i <= 0) {
                    break;
                }
                stringWriter.write(cArr, 0, i);
            }
            return stringWriter.toString();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    private static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split(com.alipay.sdk.m.y.l.b)) {
                String strTrim = str2.trim();
                if (strTrim.startsWith("charset")) {
                    String[] strArrSplit = strTrim.split("=", 2);
                    if (strArrSplit.length != 2 || TextUtils.isEmpty(strArrSplit[1])) {
                        break;
                        break;
                    }
                    return strArrSplit[1].trim();
                }
            }
        }
        return "utf-8";
    }

    private static String a(Map<String, String> map, String str) throws Exception {
        if (map == null || map.isEmpty()) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            str = "utf-8";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                if (z) {
                    sb.append("&");
                } else {
                    z = true;
                }
                sb.append(key);
                sb.append("=");
                sb.append(URLEncoder.encode(value, str));
            }
        }
        return sb.toString();
    }

    private static HttpURLConnection a(URL url, String str, String str2) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod(str);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setRequestProperty("User-Agent", e);
        httpURLConnection.setRequestProperty("Content-Type", str2);
        httpURLConnection.setRequestProperty("HOST", url.getHost() + u15.f19942b + url.getPort());
        return httpURLConnection;
    }

    private static URL a(String str, String str2) throws Exception {
        String str3;
        StringBuilder sb;
        StringBuilder sb2;
        String string;
        URL url = new URL(str);
        if (TextUtils.isEmpty(str2)) {
            return url;
        }
        if (TextUtils.isEmpty(url.getQuery())) {
            str3 = "?";
            if (str.endsWith("?")) {
                sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(str2);
                string = sb2.toString();
            } else {
                sb = new StringBuilder();
                sb.append(str);
                sb.append(str3);
                sb.append(str2);
                string = sb.toString();
            }
        } else {
            str3 = "&";
            if (str.endsWith("&")) {
                sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(str2);
                string = sb2.toString();
            } else {
                sb = new StringBuilder();
                sb.append(str);
                sb.append(str3);
                sb.append(str2);
                string = sb.toString();
            }
        }
        return new URL(string);
    }

    private static URL a(String str, Map<String, String> map, String str2) throws Exception {
        return a(str, a(map, str2));
    }

    private static byte[] a(InputStream inputStream) throws Throwable {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = bufferedInputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i);
                        th = th;
                        bufferedInputStream2 = bufferedInputStream;
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e2) {
                                com.igexin.c.a.c.a.a(e2);
                            }
                        }
                        throw th;
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e3) {
                        com.igexin.c.a.c.a.a(e3);
                    }
                    return byteArray;
                } catch (Exception e4) {
                    e = e4;
                    com.igexin.c.a.c.a.a(e);
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e5) {
                            com.igexin.c.a.c.a.a(e5);
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                bufferedInputStream2 = bufferedInputStream;
            }
        } catch (Exception e6) {
            e = e6;
            bufferedInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static byte[] a(String str, String str2, String str3) throws IOException {
        return ("Content-Disposition:form-data;name=\"" + str + "\"\r\nContent-Type:text/plain\r\n\r\n" + str2).getBytes(str3);
    }

    private static byte[] a(String str, String str2, byte[] bArr, int i, int i2) throws Exception {
        HttpURLConnection httpURLConnectionA;
        OutputStream outputStream = null;
        try {
            httpURLConnectionA = a(new URL(str), "POST", str2);
            try {
                try {
                    httpURLConnectionA.setConnectTimeout(i);
                    httpURLConnectionA.setReadTimeout(i2);
                    try {
                        outputStream = httpURLConnectionA.getOutputStream();
                        outputStream.write(bArr);
                        byte[] bArrA = a(httpURLConnectionA);
                        outputStream.close();
                        httpURLConnectionA.disconnect();
                        return bArrA;
                    } catch (Exception e2) {
                        com.igexin.c.a.c.a.a(e2);
                        throw e2;
                    }
                } catch (IOException e3) {
                    e = e3;
                    com.igexin.c.a.c.a.a(e);
                    throw e;
                }
            } catch (Throwable th) {
                th = th;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (httpURLConnectionA != null) {
                    httpURLConnectionA.disconnect();
                }
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
        } catch (Throwable th2) {
            th = th2;
            httpURLConnectionA = null;
        }
    }

    private static byte[] a(String str, Map<String, String> map, int i, int i2) throws Exception {
        return a(str, map, "utf-8", i, i2);
    }

    private static byte[] a(String str, Map<String, String> map, int i, int i2, String str2) throws Exception {
        HttpURLConnection httpURLConnectionB = b(str, map, i, i2, str2);
        try {
            try {
                byte[] bArrA = a(httpURLConnectionB);
                if (httpURLConnectionB != null) {
                    httpURLConnectionB.disconnect();
                }
                return bArrA;
            } catch (Exception e2) {
                throw e2;
            }
        } catch (Throwable th) {
            if (httpURLConnectionB != null) {
                httpURLConnectionB.disconnect();
            }
            throw th;
        }
    }

    private static byte[] a(String str, Map<String, String> map, String str2, int i, int i2) throws Exception {
        String strConcat = "application/x-www-form-urlencoded;charset=".concat(String.valueOf(str2));
        String strA = a(map, str2);
        byte[] bytes = new byte[0];
        if (strA != null) {
            bytes = strA.getBytes(str2);
        }
        return a(str, strConcat, bytes, i, i2);
    }

    private static byte[] a(String str, Map<String, String> map, Map<String, i> map2, int i, int i2) throws Exception {
        return (map2 == null || map2.isEmpty()) ? a(str, map, "utf-8", i, i2) : a(str, map, map2, "utf-8", i, i2);
    }

    /* JADX WARN: Code duplicated, block: B:113:0x0226  */
    /* JADX WARN: Code duplicated, block: B:115:0x022b  */
    /* JADX WARN: Code duplicated, block: B:64:0x015f  */
    /* JADX WARN: Code duplicated, block: B:65:0x0162 A[Catch: all -> 0x01fc, Exception -> 0x01fe, TryCatch #9 {Exception -> 0x01fe, all -> 0x01fc, blocks: (B:62:0x0159, B:75:0x017f, B:77:0x0188, B:80:0x01a4, B:82:0x01c8, B:65:0x0162, B:68:0x016b, B:71:0x0174, B:33:0x00fd, B:35:0x0103, B:38:0x010e, B:40:0x0114, B:42:0x011d, B:46:0x0128, B:48:0x012f, B:50:0x0136, B:52:0x013e, B:84:0x01d3), top: B:126:0x0159 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x0168  */
    /* JADX WARN: Code duplicated, block: B:68:0x016b A[Catch: all -> 0x01fc, Exception -> 0x01fe, TryCatch #9 {Exception -> 0x01fe, all -> 0x01fc, blocks: (B:62:0x0159, B:75:0x017f, B:77:0x0188, B:80:0x01a4, B:82:0x01c8, B:65:0x0162, B:68:0x016b, B:71:0x0174, B:33:0x00fd, B:35:0x0103, B:38:0x010e, B:40:0x0114, B:42:0x011d, B:46:0x0128, B:48:0x012f, B:50:0x0136, B:52:0x013e, B:84:0x01d3), top: B:126:0x0159 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0171  */
    /* JADX WARN: Code duplicated, block: B:71:0x0174 A[Catch: all -> 0x01fc, Exception -> 0x01fe, TryCatch #9 {Exception -> 0x01fe, all -> 0x01fc, blocks: (B:62:0x0159, B:75:0x017f, B:77:0x0188, B:80:0x01a4, B:82:0x01c8, B:65:0x0162, B:68:0x016b, B:71:0x0174, B:33:0x00fd, B:35:0x0103, B:38:0x010e, B:40:0x0114, B:42:0x011d, B:46:0x0128, B:48:0x012f, B:50:0x0136, B:52:0x013e, B:84:0x01d3), top: B:126:0x0159 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x017a  */
    /* JADX WARN: Code duplicated, block: B:74:0x017d  */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0221: MOVE (r17 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:111:0x0221 */
    private static byte[] a(String str, Map<String, String> map, Map<String, i> map2, String str2, int i, int i2) throws Exception {
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        String str3;
        Iterator<Map.Entry<String, i>> it;
        Object obj;
        String str4;
        File file;
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        String string = sb.toString();
        try {
            try {
                HttpURLConnection httpURLConnectionA = a(new URL(str), "POST", "multipart/form-data;charset=" + str2 + ";boundary=" + string);
                try {
                    httpURLConnectionA.setConnectTimeout(i);
                    httpURLConnectionA.setReadTimeout(i2);
                    try {
                        OutputStream outputStream2 = httpURLConnectionA.getOutputStream();
                        try {
                            byte[] bytes = ("\r\n--" + string + "\r\n").getBytes(str2);
                            for (Map.Entry<String, String> entry : map.entrySet()) {
                                byte[] bytes2 = ("Content-Disposition:form-data;name=\"" + entry.getKey() + "\"\r\nContent-Type:text/plain\r\n\r\n" + entry.getValue()).getBytes(str2);
                                outputStream2.write(bytes);
                                outputStream2.write(bytes2);
                            }
                            Iterator<Map.Entry<String, i>> it2 = map2.entrySet().iterator();
                            while (it2.hasNext()) {
                                Map.Entry<String, i> next = it2.next();
                                i value = next.getValue();
                                next.getKey();
                                if (value.f38149a == null && (file = value.c) != null && file.exists()) {
                                    value.f38149a = value.c.getName();
                                }
                                String str5 = value.f38149a;
                                if (value.b == null) {
                                    byte[] bArrA = value.a();
                                    try {
                                        if (bArrA != null) {
                                            it = it2;
                                            if (bArrA.length < 10) {
                                                str3 = string;
                                                httpURLConnection = httpURLConnectionA;
                                            } else {
                                                byte b2 = bArrA[0];
                                                httpURLConnection = httpURLConnectionA;
                                                if (b2 == 71 && bArrA[1] == 73 && bArrA[2] == 70) {
                                                    str3 = string;
                                                    obj = "GIF";
                                                } else {
                                                    byte b3 = bArrA[1];
                                                    if (b3 == 80) {
                                                        str3 = string;
                                                        if (bArrA[2] == 78 && bArrA[3] == 71) {
                                                            obj = "PNG";
                                                        }
                                                    } else {
                                                        str3 = string;
                                                    }
                                                    if (bArrA[6] == 74 && bArrA[7] == 70 && bArrA[8] == 73 && bArrA[9] == 70) {
                                                        obj = "JPG";
                                                    } else if (b2 == 66 && b3 == 77) {
                                                        obj = "BMP";
                                                    }
                                                }
                                                if ("JPG".equals(obj)) {
                                                    str4 = "image/jpeg";
                                                } else if ("GIF".equals(obj)) {
                                                    str4 = "image/gif";
                                                } else if ("PNG".equals(obj)) {
                                                    str4 = "image/png";
                                                } else if ("BMP".equals(obj)) {
                                                    str4 = "image/bmp";
                                                } else {
                                                    str4 = OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE;
                                                }
                                                value.b = str4;
                                            }
                                        } else {
                                            str3 = string;
                                            httpURLConnection = httpURLConnectionA;
                                            it = it2;
                                        }
                                        if ("JPG".equals(obj)) {
                                            str4 = "image/jpeg";
                                        } else if ("GIF".equals(obj)) {
                                            str4 = "image/gif";
                                        } else if ("PNG".equals(obj)) {
                                            str4 = "image/png";
                                        } else if ("BMP".equals(obj)) {
                                            str4 = "image/bmp";
                                        } else {
                                            str4 = OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE;
                                        }
                                        value.b = str4;
                                    } catch (Exception e2) {
                                        e = e2;
                                        outputStream = outputStream2;
                                        try {
                                            com.igexin.c.a.c.a.a(e);
                                            throw e;
                                        } catch (Throwable th) {
                                            th = th;
                                            if (outputStream != null) {
                                                outputStream.close();
                                            }
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        outputStream = outputStream2;
                                        if (outputStream != null) {
                                            outputStream.close();
                                        }
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        throw th;
                                    }
                                    obj = null;
                                } else {
                                    str3 = string;
                                    httpURLConnection = httpURLConnectionA;
                                    it = it2;
                                }
                                String str6 = value.b;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Content-Disposition:form-data;name=\"");
                                sb2.append("dp_data");
                                sb2.append("\";filename=\"");
                                if (TextUtils.isEmpty(str5)) {
                                    str5 = "filename";
                                }
                                sb2.append(str5);
                                sb2.append("\"\r\nContent-Type:");
                                sb2.append(str6);
                                sb2.append("\r\n\r\n");
                                byte[] bytes3 = sb2.toString().getBytes(str2);
                                outputStream2.write(bytes);
                                outputStream2.write(bytes3);
                                byte[] bArrA2 = value.a();
                                if (bArrA2 != null) {
                                    outputStream2.write(bArrA2);
                                }
                                it2 = it;
                                string = str3;
                                httpURLConnectionA = httpURLConnection;
                            }
                            httpURLConnection = httpURLConnectionA;
                            outputStream2.write(("\r\n--" + string + "--\r\n").getBytes(str2));
                            byte[] bArrA3 = a(httpURLConnection);
                            outputStream2.close();
                            httpURLConnection.disconnect();
                            return bArrA3;
                        } catch (Exception e3) {
                            e = e3;
                            httpURLConnection = httpURLConnectionA;
                        } catch (Throwable th3) {
                            th = th3;
                            httpURLConnection = httpURLConnectionA;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        httpURLConnection = httpURLConnectionA;
                        outputStream = null;
                    }
                } catch (IOException e5) {
                    throw e5;
                }
            } catch (Throwable th4) {
                th = th4;
                httpURLConnection = httpURLConnection2;
                outputStream = null;
            }
        } catch (IOException e6) {
            throw e6;
        } catch (Throwable th5) {
            th = th5;
            outputStream = null;
            httpURLConnection = null;
        }
    }

    public static byte[] a(String str, byte[] bArr) throws Exception {
        return a(str, OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE, bArr, 10000, 10000);
    }

    private static byte[] a(HttpURLConnection httpURLConnection) throws Exception {
        return httpURLConnection.getErrorStream() == null ? a(httpURLConnection.getInputStream()) : b(httpURLConnection).getBytes();
    }

    private static String b(HttpURLConnection httpURLConnection) throws Exception {
        String strA = a(httpURLConnection.getErrorStream(), a(httpURLConnection.getContentType()));
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        throw new IOException(httpURLConnection.getResponseCode() + u15.f19942b + httpURLConnection.getResponseMessage());
    }

    private static HttpURLConnection b(String str, Map<String, String> map, int i, int i2, String str2) throws Exception {
        HttpURLConnection httpURLConnectionA = a(a(str, a(map, str2)), "GET", "application/x-www-form-urlencoded;charset=".concat(String.valueOf(str2)));
        httpURLConnectionA.setConnectTimeout(i);
        httpURLConnectionA.setReadTimeout(i2);
        return httpURLConnectionA;
    }

    private static byte[] b(String str, String str2, String str3) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Content-Disposition:form-data;name=\"");
        sb.append("dp_data");
        sb.append("\";filename=\"");
        if (TextUtils.isEmpty(str)) {
            str = "filename";
        }
        sb.append(str);
        sb.append("\"\r\nContent-Type:");
        sb.append(str2);
        sb.append("\r\n\r\n");
        return sb.toString().getBytes(str3);
    }

    private static byte[] b(String str, Map<String, String> map, int i, int i2) throws Exception {
        return a(str, map, i, i2, "utf-8");
    }

    private static byte[] c(String str, Map<String, String> map, int i, int i2) throws Exception {
        HttpURLConnection httpURLConnectionB = b(str, map, i, i2, "utf-8");
        try {
            try {
                byte[] bArrA = a(httpURLConnectionB);
                if (httpURLConnectionB != null) {
                    httpURLConnectionB.disconnect();
                }
                return bArrA;
            } catch (Exception e2) {
                throw e2;
            }
        } catch (Throwable th) {
            if (httpURLConnectionB != null) {
                httpURLConnectionB.disconnect();
            }
            throw th;
        }
    }
}
