package com.byazt.rc;

import com.byazt.nr.m;
import com.byazt.yj.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FORMATER_CREATE_TIME, 20})
public class c implements com.byazt.yj.n<uj> {
    private Map<String, String> c(HttpURLConnection httpURLConnection) {
        HashMap map = new HashMap();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        for (String str : headerFields.keySet()) {
            List<String> list = headerFields.get(str);
            if (list != null && list.size() > 0) {
                map.put(str, list.get(0));
            }
        }
        return map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.io.ByteArrayOutputStream, java.io.Closeable] */
    @Override // com.byazt.yj.n
    public uj<byte[]> call(a aVar) throws Throwable {
        InputStream inputStream;
        byte[] byteArray;
        ?? byteArrayOutputStream;
        String message;
        ?? r6;
        InputStream inputStream2 = null;
        Map<String, String> mapC = null;
        int i = 0;
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(aVar.c()).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.connect();
                inputStream = httpURLConnection.getInputStream();
                try {
                    byte[] bArr = new byte[1024];
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        while (true) {
                            try {
                                int i2 = inputStream.read(bArr);
                                if (i2 == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, i2);
                            } catch (MalformedURLException e) {
                                e = e;
                                byteArray = null;
                            } catch (IOException e2) {
                                e = e2;
                                byteArray = null;
                            }
                            m.tt("InternalHttpClient", "MalformedURLException:" + e.getMessage());
                            message = e.getMessage();
                            r6 = byteArrayOutputStream;
                            com.byazt.as.tt.c(inputStream);
                            com.byazt.as.tt.c(r6);
                            return new uj<>(i, byteArray, message, mapC);
                        }
                        mapC = aVar.tt() ? c(httpURLConnection) : null;
                        com.byazt.as.tt.c(inputStream);
                        com.byazt.as.tt.c(byteArrayOutputStream);
                        message = "success";
                    } catch (MalformedURLException e3) {
                        e = e3;
                        m.tt("InternalHttpClient", "MalformedURLException:" + e.getMessage());
                        message = e.getMessage();
                        r6 = byteArrayOutputStream;
                        com.byazt.as.tt.c(inputStream);
                        com.byazt.as.tt.c(r6);
                    } catch (IOException e4) {
                        e = e4;
                        m.tt("InternalHttpClient", "IOException:" + e.getMessage());
                        message = e.getMessage();
                        r6 = byteArrayOutputStream;
                        com.byazt.as.tt.c(inputStream);
                        com.byazt.as.tt.c(r6);
                    }
                    i = 200;
                    byteArray = byteArrayOutputStream.toByteArray();
                } catch (MalformedURLException e5) {
                    e = e5;
                    byteArray = null;
                    byteArrayOutputStream = byteArray;
                } catch (IOException e6) {
                    e = e6;
                    byteArray = null;
                    byteArrayOutputStream = byteArray;
                    m.tt("InternalHttpClient", "IOException:" + e.getMessage());
                    message = e.getMessage();
                    r6 = byteArrayOutputStream;
                    com.byazt.as.tt.c(inputStream);
                    com.byazt.as.tt.c(r6);
                    return new uj<>(i, byteArray, message, mapC);
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = inputStream;
                    com.byazt.as.tt.c(inputStream2);
                    com.byazt.as.tt.c(0);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (MalformedURLException e7) {
            e = e7;
            inputStream = null;
            byteArray = null;
        } catch (IOException e8) {
            e = e8;
            inputStream = null;
            byteArray = null;
        } catch (Throwable th3) {
            th = th3;
            com.byazt.as.tt.c(inputStream2);
            com.byazt.as.tt.c(0);
            throw th;
        }
        return new uj<>(i, byteArray, message, mapC);
    }
}
