package com.baidu.mapauto.auth.net;

import android.text.TextUtils;
import com.alipay.sdk.m.t.e;
import com.baidu.mapauto.auth.util.LogUtil;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class a implements com.baidu.mapauto.auth.net.base.a {
    public static final String b = "a";
    public static final /* synthetic */ boolean c = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f26600a;

    public a() {
    }

    public a(c cVar) {
        this.f26600a = cVar;
    }

    public static String a(InputStream inputStream) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            try {
                StringWriter stringWriter = new StringWriter();
                char[] cArr = new char[8192];
                while (true) {
                    int i = bufferedReader.read(cArr);
                    if (i < 0) {
                        String string = stringWriter.toString();
                        bufferedReader.close();
                        return string;
                    }
                    stringWriter.write(cArr, 0, i);
                    return null;
                }
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:81:0x01c9  */
    public final b a(String str, HashMap map) throws Exception {
        HttpURLConnection httpURLConnection;
        com.baidu.mapauto.auth.net.format.a aVar = new com.baidu.mapauto.auth.net.format.a();
        HttpURLConnection httpURLConnection2 = null;
        try {
            c cVar = this.f26600a;
            if (!c && !"POST".equals("POST") && !"POST".equals("GET")) {
                throw new AssertionError();
            }
            if (cVar == null) {
                throw new IllegalArgumentException("net config 不能为空");
            }
            String str2 = cVar.b;
            if (!(!TextUtils.isEmpty(str2) && (str2.startsWith("https") || str2.startsWith("HTTPS")))) {
                throw new IllegalArgumentException("net config 检验失败");
            }
            String str3 = cVar.b + str;
            if ("POST".equals("GET") && !map.isEmpty()) {
                str3 = "?" + aVar.a(map);
            }
            URL url = new URL(str3);
            if (str3.startsWith("https") || str3.startsWith("HTTPS")) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                try {
                    HostnameVerifier hostnameVerifier = cVar.d;
                    httpURLConnection = httpsURLConnection;
                    if (hostnameVerifier != null) {
                        httpsURLConnection.setHostnameVerifier(hostnameVerifier);
                        httpURLConnection = httpsURLConnection;
                    }
                } catch (Throwable th) {
                    th = th;
                    httpURLConnection2 = httpsURLConnection;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection2 = httpURLConnection;
            httpURLConnection2.setRequestMethod("POST");
            if ("POST".equals("POST")) {
                httpURLConnection2.setDoInput(true);
            }
            httpURLConnection2.setDoOutput(true);
            httpURLConnection2.setReadTimeout(cVar.f26602a);
            httpURLConnection2.setConnectTimeout(5000);
            Map<String, Object> map2 = cVar.c;
            if (map2 != null) {
                for (String str4 : map2.keySet()) {
                    Object obj = map2.get(str4);
                    Objects.requireNonNull(obj);
                    httpURLConnection2.setRequestProperty(str4, obj.toString());
                }
            }
            if ("POST".equals("POST")) {
                httpURLConnection2.setRequestProperty(e.f, "multipart/form-data; boundary=" + com.baidu.mapauto.auth.net.format.a.f26604a);
            }
            LogUtil logUtil = LogUtil.getInstance();
            String str5 = b;
            logUtil.i(str5, "请求地址: " + str3);
            LogUtil.getInstance().i(str5, "请求方式: POST");
            LogUtil.getInstance().i(str5, "请求头: " + map2);
            LogUtil.getInstance().i(str5, "请求参数: " + map);
            if ("POST".equals("POST")) {
                OutputStream outputStream = httpURLConnection2.getOutputStream();
                String strA = aVar.a(map);
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                try {
                    dataOutputStream.writeBytes(strA);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    try {
                        dataOutputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
            httpURLConnection2.connect();
            b bVar = new b();
            int responseCode = httpURLConnection2.getResponseCode();
            bVar.f26601a = Integer.valueOf(responseCode);
            bVar.b = httpURLConnection2.getResponseMessage();
            if (responseCode == 200) {
                bVar.c = a(httpURLConnection2.getInputStream());
            }
            httpURLConnection2.disconnect();
            return bVar;
        } catch (Throwable th4) {
            th = th4;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }
}
