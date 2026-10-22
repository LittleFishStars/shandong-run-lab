package com.beizi.fusion;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class gh extends qa {
    private File e;

    public gh(ke keVar, sa saVar) {
        super(keVar, saVar);
    }

    public void a(File file) {
        this.e = file;
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
            try {
                httpURLConnectionA = y5.a(keVar);
                a(this.f27685a.a());
                httpURLConnectionA.setConnectTimeout(5000);
                httpURLConnectionA.setReadTimeout(5000);
                a(httpURLConnectionA);
                httpURLConnectionA.disconnect();
            } catch (Exception e) {
                a(new ui(-100, e.getMessage()));
                if (httpURLConnectionA != null) {
                    httpURLConnectionA.disconnect();
                }
            }
        } catch (Throwable th) {
            if (httpURLConnectionA != null) {
                httpURLConnectionA.disconnect();
            }
            throw th;
        }
    }

    private void a(HttpURLConnection httpURLConnection) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        InputStream inputStream;
        Throwable th;
        if (httpURLConnection == null) {
            a(ui.a.ERROR_UNEXPECTED);
            return;
        }
        InputStream inputStream2 = null;
        fileOutputStream = null;
        FileOutputStream fileOutputStream3 = null;
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                String contentEncoding = httpURLConnection.getContentEncoding();
                inputStream = (TextUtils.isEmpty(contentEncoding) || !contentEncoding.contains("gzip")) ? httpURLConnection.getInputStream() : new GZIPInputStream(httpURLConnection.getInputStream());
                try {
                    File file = this.e;
                    if (file != null) {
                        if (!file.exists()) {
                            this.e.createNewFile();
                        }
                        if (this.e.canWrite()) {
                            fileOutputStream2 = new FileOutputStream(this.e);
                            try {
                                a(inputStream, fileOutputStream2);
                            } catch (Throwable th2) {
                                th = th2;
                                zd.a((Closeable) inputStream);
                                zd.a(fileOutputStream2);
                                throw th;
                            }
                        } else {
                            fileOutputStream2 = null;
                        }
                        try {
                            a(responseCode, (InputStream) null);
                            fileOutputStream3 = fileOutputStream2;
                        } catch (Throwable th3) {
                            fileOutputStream = fileOutputStream2;
                            th = th3;
                            inputStream2 = inputStream;
                            inputStream = inputStream2;
                            th = th;
                            fileOutputStream2 = fileOutputStream;
                            zd.a((Closeable) inputStream);
                            zd.a(fileOutputStream2);
                            throw th;
                        }
                    } else {
                        a(ui.a.ERROR_UNEXPECTED);
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                }
            } else {
                if (responseCode == 302) {
                    a(httpURLConnection.getHeaderField("Location"), responseCode);
                } else {
                    a(new ui(responseCode, "request failed..."));
                }
                inputStream = null;
            }
            zd.a((Closeable) inputStream);
            zd.a(fileOutputStream3);
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
        }
    }

    private void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream == null || outputStream == null) {
            return;
        }
        zd.a(inputStream, outputStream);
    }
}
