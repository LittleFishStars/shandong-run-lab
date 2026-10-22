package com.ali.auth.third.core.rpc;

import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.IOUtils;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PureHttpConnectionHelper extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23427a = "PureHttpConnectionHelper";

    public static String get(String str) {
        Throwable th;
        HttpURLConnection httpURLConnection;
        OutputStreamWriter outputStreamWriter;
        Throwable th2;
        SDKLogger.d(f23427a, "get url = " + str);
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(15000);
                outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream());
                try {
                    outputStreamWriter.flush();
                    if (httpURLConnection.getResponseCode() == 200) {
                        String string = a.a(httpURLConnection.getInputStream()).toString(a.a(httpURLConnection.getContentType()));
                        IOUtils.closeQuietly(outputStreamWriter);
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception unused) {
                        }
                        return string;
                    }
                    throw new RuntimeException("http request exception, response code: " + httpURLConnection.getResponseCode());
                } catch (Throwable th3) {
                    th2 = th3;
                    try {
                        throw new RuntimeException(th2);
                    } catch (Throwable th4) {
                        IOUtils.closeQuietly(outputStreamWriter);
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th4;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                Throwable th6 = th;
                outputStreamWriter = null;
                th2 = th6;
                throw new RuntimeException(th2);
            }
        } catch (Throwable th7) {
            th = th7;
            httpURLConnection = null;
        }
    }
}
