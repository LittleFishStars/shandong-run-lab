package com.alibaba.alibclinkpartner.smartlink.a;

import com.acse.ottn.p3;
import com.alibaba.alibclinkpartner.smartlink.util.ALSLLogUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    public static b a(String str, Map<String, String> map) throws Throwable {
        b bVar = new b();
        BufferedReader bufferedReader = null;
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                a(httpURLConnection, map);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                int responseCode = httpURLConnection.getResponseCode();
                bVar.f23568a = responseCode;
                if (responseCode != 200) {
                    bVar.c = httpURLConnection.getHeaderFields();
                    ALSLLogUtil.d("ALSLHttpManager", "get请求", "http get请求失败，错误码：" + httpURLConnection.getResponseCode());
                    return bVar;
                }
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                    }
                    bVar.b = sb.toString();
                    bVar.c = httpURLConnection.getHeaderFields();
                    ALSLLogUtil.d("ALSLHttpManager", "get请求", "http get请求成功");
                    try {
                        bufferedReader2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return bVar;
                } catch (Exception e2) {
                    e = e2;
                    bufferedReader = bufferedReader2;
                    ALSLLogUtil.e("ALSLHttpManager", p3.f, "http get请求失败，错误信息为：" + e.toString());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return bVar;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (httpURLConnection == null || map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }
}
