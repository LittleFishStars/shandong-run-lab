package com.alibaba.triver.open.api;

import android.util.Base64;
import android.util.Log;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.kernel.common.network.http.RVHttpResponse;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25039a = "statusText";
    public static final String b = "status";
    private static final Pattern c = Pattern.compile("charset=([a-z0-9-]+)");

    public static Map<String, Object> a(int i, InputStream inputStream, Map<String, String> map, NetworkOptions.Type type) {
        HashMap map2 = new HashMap();
        if (-1 == i) {
            map2.put("status", -1);
            map2.put(f25039a, c.c);
            map2.put("ok", Boolean.FALSE);
        } else {
            map2.put("status", Integer.valueOf(i));
            map2.put("ok", Boolean.valueOf(i >= 200 && i <= 299));
            if (inputStream == null) {
                map2.put("data", null);
            } else {
                try {
                    if (NetworkOptions.Type.arraybuffer.equals(type)) {
                        map2.put("data", b(inputStream));
                    } else if (NetworkOptions.Type.base64.equals(type)) {
                        map2.put("data", a(inputStream));
                    } else {
                        map2.put("data", a(a(inputStream, map != null ? a(map, "Content-Type") : ""), type));
                    }
                } catch (JSONException e) {
                    RVLogger.w(Log.getStackTraceString(e));
                    map2.put("ok", Boolean.FALSE);
                    map2.put("data", "{'err':'Data parse failed!'}");
                }
            }
            map2.put(f25039a, c.a(String.valueOf(i)));
        }
        map2.put("headers", map);
        return map2;
    }

    private static byte[] b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (UnsupportedEncodingException e) {
            RVLogger.w(Log.getStackTraceString(e));
            return null;
        } catch (IOException e2) {
            RVLogger.w(Log.getStackTraceString(e2));
            return null;
        }
    }

    private static Object a(String str, NetworkOptions.Type type) {
        if (type == NetworkOptions.Type.json) {
            return JSON.parse(str);
        }
        if (type != NetworkOptions.Type.jsonp) {
            return str;
        }
        if (str != null && !str.isEmpty()) {
            int iIndexOf = str.indexOf("(") + 1;
            int iLastIndexOf = str.lastIndexOf(")");
            if (iIndexOf != 0 && iIndexOf < iLastIndexOf && iLastIndexOf > 0) {
                return JSON.parse(str.substring(iIndexOf, iLastIndexOf));
            }
            return new JSONObject();
        }
        return new JSONObject();
    }

    private static String a(Map<String, String> map, String str) {
        if (map == null || str == null) {
            return null;
        }
        if (map.containsKey(str)) {
            return map.get(str);
        }
        return map.get(str.toLowerCase());
    }

    /* JADX WARN: Code duplicated, block: B:6:0x0018  */
    private static String a(InputStream inputStream, String str) {
        String strGroup;
        if (str != null) {
            Matcher matcher = c.matcher(str.toLowerCase());
            if (matcher.find()) {
                strGroup = matcher.group(1);
            } else {
                strGroup = "utf-8";
            }
        } else {
            strGroup = "utf-8";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    return byteArrayOutputStream.toString(strGroup);
                }
            }
        } catch (UnsupportedEncodingException e) {
            RVLogger.w(Log.getStackTraceString(e));
            return byteArrayOutputStream.toString();
        } catch (IOException e2) {
            RVLogger.w(Log.getStackTraceString(e2));
            return "";
        }
    }

    private static String a(InputStream inputStream) {
        byte[] bArrB = b(inputStream);
        if (bArrB == null) {
            return null;
        }
        try {
            return Base64.encodeToString(bArrB, 2);
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
            return null;
        }
    }

    public static String a(JSONObject jSONObject) {
        String str = "";
        try {
            int i = 0;
            for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
                String key = entry.getKey();
                String string = entry.getValue().toString();
                str = i >= jSONObject.size() - 1 ? str + key + "=" + URLEncoder.encode(string, "UTF-8") : str + key + "=" + URLEncoder.encode(string, "UTF-8") + "&";
                i++;
            }
        } catch (Exception unused) {
        }
        return str;
    }

    public static Map<String, String> a(RVHttpResponse rVHttpResponse) {
        HashMap map = new HashMap();
        if (rVHttpResponse.getHeaders() != null) {
            for (Map.Entry<String, List<String>> entry : rVHttpResponse.getHeaders().entrySet()) {
                if (entry.getValue().size() > 0) {
                    map.put(entry.getKey() == null ? LoginConstants.UNDER_LINE : entry.getKey(), entry.getValue().get(0));
                }
            }
        }
        return map;
    }

    public static void a(JSONObject jSONObject, NetworkOptions.a aVar) {
        if (jSONObject != null) {
            for (String str : jSONObject.keySet()) {
                aVar.a(str, jSONObject.getString(str));
            }
        }
    }
}
