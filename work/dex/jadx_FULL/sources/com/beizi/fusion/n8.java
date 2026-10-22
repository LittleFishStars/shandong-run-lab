package com.beizi.fusion;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class n8 extends qa {
    public n8(ke keVar, sa saVar) {
        super(keVar, saVar);
    }

    private void a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            a(ui.a.ERROR_UNEXPECTED);
            return;
        }
        InputStream inputStream = null;
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                String contentEncoding = httpURLConnection.getContentEncoding();
                inputStream = (TextUtils.isEmpty(contentEncoding) || !contentEncoding.contains("gzip")) ? httpURLConnection.getInputStream() : new GZIPInputStream(httpURLConnection.getInputStream());
                a(responseCode, inputStream);
            } else if (responseCode == 302) {
                a(httpURLConnection.getHeaderField("Location"), responseCode);
            } else {
                a(new ui(responseCode, "request failed..."));
            }
        } finally {
            zd.a((Closeable) null);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        ke keVar = this.f27685a;
        if (keVar == null) {
            a(ui.a.ERROR_INVALID_URL);
            return;
        }
        HttpURLConnection httpURLConnectionA = null;
        try {
            httpURLConnectionA = y5.a(keVar);
            a(this.f27685a.a());
            a(httpURLConnectionA);
        } catch (Exception e) {
            a(new ui(-100, e.getMessage()));
        } finally {
            if (httpURLConnectionA != null) {
                httpURLConnectionA.disconnect();
            }
        }
    }
}
