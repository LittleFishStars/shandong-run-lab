package com.kwad.sdk.api.loader;

import com.kwad.sdk.api.core.TLSConnectionUtils;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public final class k {
    /* JADX WARN: Code duplicated, block: B:29:0x0051  */
    /* JADX WARN: Multi-variable type inference failed */
    public static void c(String str, File file) throws Throwable {
        HttpURLConnection httpURLConnection;
        FileOutputStream fileOutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            if (file.exists()) {
                j.j(file);
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, false);
            try {
                HttpURLConnection httpURLConnectionCreateUrlConnection = createUrlConnection(str);
                try {
                    bufferedInputStream = new BufferedInputStream(httpURLConnectionCreateUrlConnection.getInputStream());
                    try {
                        byte[] bArr = new byte[10240];
                        while (true) {
                            int i = bufferedInputStream.read(bArr);
                            if (i == -1) {
                                closeQuietly(fileOutputStream2);
                                closeQuietly(bufferedInputStream);
                                httpURLConnectionCreateUrlConnection.disconnect();
                                return;
                            }
                            fileOutputStream2.write(bArr, 0, i);
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        httpURLConnection = httpURLConnectionCreateUrlConnection;
                        closeQuietly(fileOutputStream);
                        closeQuietly(bufferedInputStream);
                        if (httpURLConnection != 0) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = fileOutputStream2;
                httpURLConnection = fileOutputStream;
                closeQuietly(fileOutputStream);
                closeQuietly(bufferedInputStream);
                if (httpURLConnection != 0) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private static HttpURLConnection createUrlConnection(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        TLSConnectionUtils.wrapHttpURLConnection(httpURLConnection);
        httpURLConnection.setRequestProperty(com.google.common.net.b.k, "zh-CN");
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(120000);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty("Connection", "keep-alive");
        httpURLConnection.setRequestProperty("Charset", "UTF-8");
        return httpURLConnection;
    }
}
