package com.fl.saas;

import android.text.TextUtils;
import com.fl.saas.adx.util.LogcatUtil;
import com.zj.adlib.c49;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class X implements V0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final X0 f30096a;
    private final Q b;
    private W0 c;
    private HttpURLConnection d;
    private InputStream e;

    public X(X x) {
        this.c = x.c;
        this.f30096a = x.f30096a;
        this.b = x.b;
    }

    private long a(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x009d  */
    private void b() throws Throwable {
        InputStream inputStream;
        LogcatUtil.d("Read content info from " + this.c.f30095a);
        HttpURLConnection httpURLConnection = null;
        inputStream = null;
        InputStream inputStream2 = null;
        httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnectionA = a(0L, 10000);
            try {
                long jA = a(httpURLConnectionA);
                String contentType = httpURLConnectionA.getContentType();
                inputStream2 = httpURLConnectionA.getInputStream();
                W0 w0 = new W0(this.c.f30095a, jA, contentType);
                this.c = w0;
                this.f30096a.a(w0.f30095a, w0);
                LogcatUtil.d("Source info fetched: " + this.c.toString());
                A0.a(inputStream2);
                httpURLConnectionA.disconnect();
            } catch (IOException e) {
                e = e;
                InputStream inputStream3 = inputStream2;
                httpURLConnection = httpURLConnectionA;
                inputStream = inputStream3;
                try {
                    LogcatUtil.e("Error fetching info from " + this.c.f30095a + e.toString());
                    A0.a(inputStream);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } catch (Throwable th) {
                    th = th;
                    A0.a(inputStream);
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
                A0.a(inputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }

    public synchronized String c() {
        if (TextUtils.isEmpty(this.c.c)) {
            b();
        }
        return this.c.c;
    }

    @Override // com.fl.saas.V0
    public void close() {
        HttpURLConnection httpURLConnection = this.d;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException e) {
                LogcatUtil.e("Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue :(", e.toString());
            } catch (IllegalArgumentException e2) {
                e = e2;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (NullPointerException e3) {
                e = e3;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            }
        }
    }

    public String d() {
        return this.c.f30095a;
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.c + "}";
    }

    public X(String str) {
        this(str, Y0.a());
    }

    private void a(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry entry : this.b.a(str).entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
    }

    public X(String str, X0 x0) {
        this(str, x0, new I());
    }

    @Override // com.fl.saas.V0
    public synchronized long a() {
        if (this.c.b == -2147483648L) {
            b();
        }
        return this.c.b;
    }

    public X(String str, X0 x0, Q q) {
        this.f30096a = (X0) AbstractC1442w0.a(x0);
        this.b = (Q) AbstractC1442w0.a(q);
        W0 w0A = x0.a(str);
        this.c = w0A == null ? new W0(str, -2147483648L, A0.d(str)) : w0A;
    }

    @Override // com.fl.saas.V0
    public void a(long j) throws C1448z0 {
        try {
            HttpURLConnection httpURLConnectionA = a(j, -1);
            this.d = httpURLConnectionA;
            String contentType = httpURLConnectionA.getContentType();
            this.e = new BufferedInputStream(this.d.getInputStream(), 8192);
            HttpURLConnection httpURLConnection = this.d;
            W0 w0 = new W0(this.c.f30095a, a(httpURLConnection, j, httpURLConnection.getResponseCode()), contentType);
            this.c = w0;
            this.f30096a.a(w0.f30095a, w0);
        } catch (IOException e) {
            throw new C1448z0("Error opening connection for " + this.c.f30095a + " with offset " + j, e);
        }
    }

    private HttpURLConnection a(long j, int i) throws IOException, C1448z0 {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z;
        String headerField = this.c.f30095a;
        int i2 = 0;
        do {
            StringBuilder sb = new StringBuilder();
            sb.append("Open connection ");
            if (j > 0) {
                str = " with offset " + j;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(" to ");
            sb.append(headerField);
            LogcatUtil.d(sb.toString());
            httpURLConnection = (HttpURLConnection) new URL(headerField).openConnection();
            a(httpURLConnection, headerField);
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
                throw new C1448z0("Too many redirects: " + i2);
            }
        } while (z);
        return httpURLConnection;
    }

    @Override // com.fl.saas.V0
    public int a(byte[] bArr) throws C1448z0 {
        InputStream inputStream = this.e;
        if (inputStream == null) {
            throw new C1448z0("Error reading data from " + this.c.f30095a + ": connection is absent!");
        }
        try {
            return inputStream.read(bArr, 0, bArr.length);
        } catch (InterruptedIOException e) {
            throw new C1400b0("Reading source " + this.c.f30095a + " is interrupted", e);
        } catch (IOException e2) {
            throw new C1448z0("Error reading data from " + this.c.f30095a, e2);
        }
    }

    private long a(HttpURLConnection httpURLConnection, long j, int i) {
        long jA = a(httpURLConnection);
        if (i == 200) {
            return jA;
        }
        return i == 206 ? jA + j : this.c.b;
    }
}
