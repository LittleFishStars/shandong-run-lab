package com.beizi.fusion;

import android.os.AsyncTask;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class v8 extends AsyncTask {
    private static String c = "HTTPGet";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f27861a;
    private boolean b;

    public v8(boolean z, boolean z2) {
        this.f27861a = z;
        this.b = z2;
    }

    private HttpURLConnection a(URL url) throws ProtocolException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setDoOutput(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod("GET");
        return httpURLConnection;
    }

    public abstract String a();

    @Override // android.os.AsyncTask
    public w8 doInBackground(Void... voidArr) {
        w8 w8Var = new w8();
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                try {
                    URL url = new URL(a());
                    if (url.getHost() == null) {
                        w8Var.a(false);
                        return w8Var;
                    }
                    HttpURLConnection httpURLConnectionA = a(url);
                    a(httpURLConnectionA);
                    httpURLConnectionA.connect();
                    int responseCode = httpURLConnectionA.getResponseCode();
                    kh.a(c, "HTTPGet code:" + responseCode);
                    w8Var.a(httpURLConnectionA.getHeaderFields());
                    w8Var.a(responseCode == 200 || responseCode == 302);
                    if (responseCode == 302) {
                        w8Var.a(responseCode);
                        w8Var.a(httpURLConnectionA.getHeaderField("Location"));
                    }
                    if (this.b) {
                        InputStream inputStream = httpURLConnectionA.getInputStream();
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = inputStream.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i);
                        }
                        inputStream.close();
                        if (this.f27861a) {
                            w8Var.a(byteArrayOutputStream);
                        } else {
                            w8Var.b(byteArrayOutputStream.toString("UTF-8"));
                        }
                    }
                    httpURLConnectionA.disconnect();
                    return w8Var;
                } catch (MalformedURLException unused) {
                    w8Var.a(false);
                    w8Var.a(i9.URL_FORMAT_ERROR);
                    if (0 != 0) {
                        httpURLConnection.disconnect();
                    }
                    return w8Var;
                }
            } catch (IOException unused2) {
                w8Var.a(false);
                w8Var.a(i9.TRANSPORT_ERROR);
                if (0 != 0) {
                    httpURLConnection.disconnect();
                }
                return w8Var;
            } catch (Exception unused3) {
                w8Var.a(false);
                w8Var.a(i9.TRANSPORT_ERROR);
                if (0 != 0) {
                    httpURLConnection.disconnect();
                }
                return w8Var;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    @Override // android.os.AsyncTask
    public void onCancelled(w8 w8Var) {
        super.onCancelled((Object) null);
    }

    private void a(HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestProperty("User-Agent", a4.j().g);
    }
}
