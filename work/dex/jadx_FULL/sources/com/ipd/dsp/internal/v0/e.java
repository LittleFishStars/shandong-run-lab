package com.ipd.dsp.internal.v0;

import android.text.TextUtils;
import com.ipd.dsp.Dsp;
import com.ipd.dsp.internal.c2.r;
import com.zj.adlib.c49;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class e implements m {
    public static final String e = "HttpUrlSource";
    public static final int f = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ipd.dsp.internal.x0.b f38564a;
    public n b;
    public HttpURLConnection c;
    public InputStream d;

    public e(String str) {
        this(str, c.c());
    }

    @Override // com.ipd.dsp.internal.v0.m
    public void a(long j) throws k {
        try {
            HttpURLConnection httpURLConnectionA = a(j, -1);
            this.c = httpURLConnectionA;
            String contentType = httpURLConnectionA.getContentType();
            this.d = new BufferedInputStream(this.c.getInputStream(), 8192);
            HttpURLConnection httpURLConnection = this.c;
            n nVar = new n(this.b.f38570a, a(httpURLConnection, j, httpURLConnection.getResponseCode()), contentType);
            this.b = nVar;
            this.f38564a.a(nVar.f38570a, nVar);
        } catch (IOException e2) {
            throw new k("Error opening connection for " + this.b.f38570a + " with offset " + j, e2);
        }
    }

    public synchronized String b() throws k {
        if (TextUtils.isEmpty(this.b.c)) {
            a();
        }
        return this.b.c;
    }

    public String c() {
        return this.b.f38570a;
    }

    @Override // com.ipd.dsp.internal.v0.m
    public void close() throws k {
        HttpURLConnection httpURLConnection = this.c;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.ipd.dsp.internal.v0.m
    public synchronized long length() throws k {
        if (this.b.b == -2147483648L) {
            a();
        }
        return this.b.b;
    }

    @Override // com.ipd.dsp.internal.v0.m
    public int read(byte[] bArr) throws k {
        InputStream inputStream = this.d;
        if (inputStream == null) {
            throw new k("Error reading data from " + this.b.f38570a + ": connection is absent!");
        }
        try {
            return inputStream.read(bArr, 0, bArr.length);
        } catch (InterruptedIOException e2) {
            throw new g("Reading source " + this.b.f38570a + " is interrupted", e2);
        } catch (IOException e3) {
            throw new k("Error reading data from " + this.b.f38570a, e3);
        }
    }

    public e(e eVar) {
        this.b = eVar.b;
        this.f38564a = eVar.f38564a;
        this.c = null;
        this.d = null;
    }

    public e(String str, com.ipd.dsp.internal.x0.b bVar) {
        this.f38564a = (com.ipd.dsp.internal.x0.b) i.a(bVar);
        n nVarA = bVar.a(str);
        this.b = nVarA == null ? new n(str, -2147483648L, l.c(str)) : nVarA;
    }

    public final long a(HttpURLConnection httpURLConnection, long j, int i) {
        long jA = a(httpURLConnection);
        if (i == 200) {
            return jA;
        }
        return i == 206 ? jA + j : this.b.b;
    }

    public final long a(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00aa  */
    public final void a() throws Throwable {
        InputStream inputStream;
        if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.a(e, "Read content info from " + this.b.f38570a);
        }
        HttpURLConnection httpURLConnection = null;
        inputStream = null;
        InputStream inputStream2 = null;
        httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnectionA = a(0L, 5000);
            try {
                long jA = a(httpURLConnectionA);
                String contentType = httpURLConnectionA.getContentType();
                inputStream2 = httpURLConnectionA.getInputStream();
                n nVar = new n(this.b.f38570a, jA, contentType);
                this.b = nVar;
                this.f38564a.a(nVar.f38570a, nVar);
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.a(e, "Source info fetched: " + this.b.toString());
                }
                l.a(inputStream2);
                httpURLConnectionA.disconnect();
            } catch (IOException e2) {
                e = e2;
                InputStream inputStream3 = inputStream2;
                httpURLConnection = httpURLConnectionA;
                inputStream = inputStream3;
                try {
                    if (Dsp.isDebugLogEnable()) {
                        com.ipd.dsp.internal.c2.k.b(e, "Error fetching info from " + this.b.f38570a, e);
                    }
                    l.a(inputStream);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } catch (Throwable th) {
                    th = th;
                    l.a(inputStream);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                InputStream inputStream4 = inputStream2;
                httpURLConnection = httpURLConnectionA;
                inputStream = inputStream4;
                l.a(inputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }

    public final HttpURLConnection a(long j, int i) throws k, IOException {
        HttpURLConnection httpURLConnection;
        boolean z;
        String str;
        String headerField = this.b.f38570a;
        int i2 = 0;
        do {
            if (Dsp.isDebugLogEnable()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Open conn ");
                if (j > 0) {
                    str = " with offset " + j;
                } else {
                    str = "";
                }
                sb.append(str);
                sb.append(" to ");
                sb.append(headerField);
                com.ipd.dsp.internal.c2.k.a(e, sb.toString());
            }
            httpURLConnection = (HttpURLConnection) new URL(headerField).openConnection();
            if (httpURLConnection instanceof HttpsURLConnection) {
                try {
                    ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(com.ipd.dsp.internal.c2.j.a());
                    ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(com.ipd.dsp.internal.c2.j.f38226a);
                } catch (Throwable th) {
                    r.a(th);
                }
            }
            if (j > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j + c49.f40900a);
            }
            if (i > 0) {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i);
            }
            int responseCode = httpURLConnection.getResponseCode();
            z = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z) {
                headerField = httpURLConnection.getHeaderField("Location");
                i2++;
                httpURLConnection.disconnect();
            }
            if (i2 > 5) {
                throw new k("Too many redirects: " + i2);
            }
        } while (z);
        return httpURLConnection;
    }
}
