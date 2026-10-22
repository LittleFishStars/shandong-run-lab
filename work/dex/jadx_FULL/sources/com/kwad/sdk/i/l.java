package com.kwad.sdk.i;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.zj.adlib.ze1;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
class l {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static int biQ;

    public interface a {
        void onSuccess();
    }

    @WorkerThread
    public static void a(List<k> list, a aVar) {
        if (biQ > 10) {
            j.an("LogReportUtil", "request error");
            return;
        }
        g gVarRU = h.RQ().RU();
        Map<String, String> requestHeader = gVarRU.getRequestHeader();
        JSONObject jSONObjectRP = gVarRU.RP();
        c.putValue(jSONObjectRP, "actionList", list);
        c.putValue(jSONObjectRP, "timestamp", System.currentTimeMillis());
        a(gVarRU.RO(), requestHeader, a(requestHeader, jSONObjectRP), aVar);
    }

    private static String c(Map<String, String> map, String str) {
        g gVarRU = h.RQ().RU();
        JSONObject jSONObject = new JSONObject();
        c.putValue(jSONObject, "version", gVarRU.getSdkVersion());
        c.putValue(jSONObject, "appId", gVarRU.getAppId());
        c.putValue(jSONObject, "message", com.kwad.sdk.i.a.ax(str));
        com.kwad.sdk.i.a.a(gVarRU.RO(), map, jSONObject.toString());
        return jSONObject.toString();
    }

    private static String inputStream2String(InputStream inputStream) {
        try {
            return c(inputStream);
        } catch (IOException unused) {
            j.Sa();
            return null;
        } finally {
            j.closeQuietly(inputStream);
        }
    }

    private static void setConnectionHeader(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map == null || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private static String c(InputStream inputStream) throws Throwable {
        InputStreamReader inputStreamReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            inputStreamReader = new InputStreamReader(inputStream);
            try {
                bufferedReader = new BufferedReader(inputStreamReader, 1024);
                try {
                    String strA = a(bufferedReader);
                    j.closeQuietly(bufferedReader);
                    j.closeQuietly(inputStreamReader);
                    return strA;
                } catch (Throwable th2) {
                    th = th2;
                    j.closeQuietly(bufferedReader);
                    j.closeQuietly(inputStreamReader);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            inputStreamReader = null;
            th = th4;
            bufferedReader = null;
        }
    }

    private static String a(Map<String, String> map, JSONObject jSONObject) {
        if (h.RQ().RU().RN()) {
            return jSONObject.toString();
        }
        return c(map, jSONObject.toString());
    }

    private static void a(String str, Map<String, String> map, String str2, a aVar) throws Throwable {
        Closeable closeable;
        HttpURLConnection httpURLConnection = null;
        OutputStream outputStream = null;
        httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setRequestProperty("Content-Type", ze1.g);
                httpURLConnection2.setConnectTimeout(10000);
                httpURLConnection2.setReadTimeout(30000);
                httpURLConnection2.setUseCaches(false);
                setConnectionHeader(httpURLConnection2, map);
                httpURLConnection2.connect();
                if (!TextUtils.isEmpty(str2)) {
                    outputStream = httpURLConnection2.getOutputStream();
                    outputStream.write(str2.getBytes());
                    outputStream.flush();
                }
                if (httpURLConnection2.getResponseCode() == 200) {
                    String strInputStream2String = inputStream2String(httpURLConnection2.getInputStream());
                    j.Sb();
                    if (!TextUtils.isEmpty(strInputStream2String) && new JSONObject(strInputStream2String).optInt("result") == 1) {
                        biQ = 0;
                        aVar.onSuccess();
                    } else {
                        biQ++;
                        j.Sb();
                    }
                } else {
                    biQ++;
                    j.Sb();
                }
                j.closeQuietly(httpURLConnection2);
                j.closeQuietly(outputStream);
            } catch (Exception unused) {
                httpURLConnection = httpURLConnection2;
                closeable = null;
                try {
                    biQ++;
                    j.Sa();
                    j.closeQuietly(httpURLConnection);
                    j.closeQuietly(closeable);
                } catch (Throwable th) {
                    th = th;
                    j.closeQuietly(httpURLConnection);
                    j.closeQuietly(closeable);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = httpURLConnection2;
                closeable = null;
                j.closeQuietly(httpURLConnection);
                j.closeQuietly(closeable);
                throw th;
            }
        } catch (Exception unused2) {
            closeable = null;
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
        }
    }

    private static String a(Reader reader) throws Throwable {
        StringWriter stringWriter;
        Throwable th;
        StringWriter stringWriter2 = new StringWriter();
        try {
            stringWriter = new StringWriter();
            try {
                char[] cArr = new char[1024];
                while (true) {
                    int i = reader.read(cArr);
                    if (i != -1) {
                        stringWriter.write(cArr, 0, i);
                    } else {
                        String string = stringWriter.toString();
                        j.closeQuietly(reader);
                        j.closeQuietly(stringWriter);
                        return string;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                j.closeQuietly(reader);
                j.closeQuietly(stringWriter);
                throw th;
            }
        } catch (Throwable th3) {
            stringWriter = stringWriter2;
            th = th3;
        }
    }
}
