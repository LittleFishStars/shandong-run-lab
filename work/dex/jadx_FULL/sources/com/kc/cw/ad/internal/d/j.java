package com.kc.cw.ad.internal.d;

import android.text.TextUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.c49;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class j implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.kc.cw.ad.internal.d.b.c f38969a;
    private final f b;
    private s c;
    private HttpURLConnection d;
    private InputStream e;

    public j(j jVar) {
        this.c = jVar.c;
        this.f38969a = jVar.f38969a;
        this.b = jVar.b;
    }

    public j(String str) {
        this(str, com.kc.cw.ad.internal.d.b.d.a());
    }

    public j(String str, com.kc.cw.ad.internal.d.b.c cVar) {
        this(str, cVar, new d());
    }

    public j(String str, com.kc.cw.ad.internal.d.b.c cVar, f fVar) {
        this.f38969a = (com.kc.cw.ad.internal.d.b.c) n.a(cVar);
        this.b = (f) n.a(fVar);
        s sVarA = cVar.a(str);
        this.c = sVarA == null ? new s(str, -2147483648L, q.a(str)) : sVarA;
    }

    private long a(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    private long a(HttpURLConnection httpURLConnection, long j, int i) throws IOException {
        long jA = a(httpURLConnection);
        if (i == 200) {
            return jA;
        }
        return i == 206 ? jA + j : this.c.b;
    }

    private HttpURLConnection a(long j, int i) throws IOException, p {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z;
        String headerField = this.c.f38975a;
        int i2 = 0;
        do {
            String str2 = com.kc.cw.ad.internal.c.f.r;
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
            com.kc.cw.ad.internal.c.f.b(str2, sb.toString());
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
                throw new p("Too many redirects: " + i2);
            }
        } while (z);
        return httpURLConnection;
    }

    private void a(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.b.a(str).entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:34:? A[SYNTHETIC] */
    private void e() throws Throwable {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        Throwable th;
        HttpURLConnection httpURLConnectionA;
        com.kc.cw.ad.internal.c.f.b(com.kc.cw.ad.internal.c.f.r, "Read content info from " + this.c.f38975a);
        InputStream inputStream2 = null;
        inputStream2 = null;
        inputStream2 = null;
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnectionA = a(0L, 10000);
            try {
                long jA = a(httpURLConnectionA);
                String contentType = httpURLConnectionA.getContentType();
                inputStream2 = httpURLConnectionA.getInputStream();
                s sVar = new s(this.c.f38975a, jA, contentType);
                this.c = sVar;
                this.f38969a.a(sVar.f38975a, sVar);
                com.kc.cw.ad.internal.c.f.b(com.kc.cw.ad.internal.c.f.r, "Source info fetched: " + this.c);
                q.a(inputStream2);
            } catch (Exception e) {
                e = e;
                InputStream inputStream3 = inputStream2;
                httpURLConnection2 = httpURLConnectionA;
                inputStream = inputStream3;
                try {
                    com.kc.cw.ad.internal.c.f.e(com.kc.cw.ad.internal.c.f.r, "Error fetching info from " + this.c.f38975a + e.getMessage());
                    q.a(inputStream);
                    if (httpURLConnection2 == null) {
                        return;
                    } else {
                        httpURLConnectionA = httpURLConnection2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    HttpURLConnection httpURLConnection3 = httpURLConnection2;
                    inputStream2 = inputStream;
                    httpURLConnectionA = httpURLConnection3;
                    Throwable th3 = th;
                    httpURLConnection = httpURLConnectionA;
                    th = th3;
                    q.a(inputStream2);
                    if (httpURLConnection == null) {
                        throw th;
                    }
                    httpURLConnection.disconnect();
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                Throwable th5 = th;
                httpURLConnection = httpURLConnectionA;
                th = th5;
                q.a(inputStream2);
                if (httpURLConnection == null) {
                    throw th;
                }
                httpURLConnection.disconnect();
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            inputStream = null;
        } catch (Throwable th6) {
            th = th6;
            httpURLConnection = null;
            q.a(inputStream2);
            if (httpURLConnection == null) {
                throw th;
            }
            httpURLConnection.disconnect();
            throw th;
        }
        httpURLConnectionA.disconnect();
    }

    @Override // com.kc.cw.ad.internal.d.r
    public int a(byte[] bArr) throws p {
        InputStream inputStream = this.e;
        if (inputStream == null) {
            throw new p("Error reading data from " + this.c.f38975a + ": connection is absent!");
        }
        try {
            return inputStream.read(bArr, 0, bArr.length);
        } catch (InterruptedIOException e) {
            throw new l("Reading source " + this.c.f38975a + " is interrupted", e);
        } catch (Exception e2) {
            throw new p("Error reading data from " + this.c.f38975a, e2);
        }
    }

    @Override // com.kc.cw.ad.internal.d.r
    public long a() throws p {
        long j;
        synchronized (this) {
            if (this.c.b == -2147483648L) {
                e();
            }
            j = this.c.b;
        }
        return j;
    }

    @Override // com.kc.cw.ad.internal.d.r
    public void a(long j) throws p {
        try {
            HttpURLConnection httpURLConnectionA = a(j, -1);
            this.d = httpURLConnectionA;
            String contentType = httpURLConnectionA.getContentType();
            this.e = new BufferedInputStream(this.d.getInputStream(), 8192);
            HttpURLConnection httpURLConnection = this.d;
            s sVar = new s(this.c.f38975a, a(httpURLConnection, j, httpURLConnection.getResponseCode()), contentType);
            this.c = sVar;
            this.f38969a.a(sVar.f38975a, sVar);
        } catch (Exception e) {
            throw new p("Error opening connection for " + this.c.f38975a + " with offset " + j, e);
        }
    }

    @Override // com.kc.cw.ad.internal.d.r
    public void b() throws p {
        HttpURLConnection httpURLConnection = this.d;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException e) {
                com.kc.cw.ad.internal.c.f.e(com.kc.cw.ad.internal.c.f.r, "Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue :(" + e.getMessage());
            } catch (IllegalArgumentException | NullPointerException unused) {
            }
        }
    }

    public String c() throws p {
        String str;
        synchronized (this) {
            if (TextUtils.isEmpty(this.c.c)) {
                e();
            }
            str = this.c.c;
        }
        return str;
    }

    public String d() {
        return this.c.f38975a;
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.c + "}";
    }
}
