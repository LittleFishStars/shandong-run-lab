package com.ipd.dsp.internal.j0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.internal.c2.j;
import com.ipd.dsp.internal.c2.r;
import com.ipd.dsp.internal.f0.g;
import com.ipd.dsp.internal.f0.i;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b implements com.ipd.dsp.internal.j0.a, com.ipd.dsp.internal.j0.a.InterfaceC0886a {
    public static final String f = "DownloadUrlConnection";
    public URLConnection b;
    public a c;
    public URL d;
    public g e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Proxy f38363a;
        public Integer b;
        public Integer c;

        public a a(Proxy proxy) {
            this.f38363a = proxy;
            return this;
        }

        public a b(int i) {
            this.b = Integer.valueOf(i);
            return this;
        }

        public a a(int i) {
            this.c = Integer.valueOf(i);
            return this;
        }
    }

    /* JADX INFO: renamed from: com.ipd.dsp.internal.j0.b$b, reason: collision with other inner class name */
    public static class C0887b implements com.ipd.dsp.internal.j0.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f38364a;

        public C0887b() {
            this(null);
        }

        public com.ipd.dsp.internal.j0.a a(URL url) throws IOException {
            return new b(url, this.f38364a);
        }

        public C0887b(a aVar) {
            this.f38364a = aVar;
        }

        @Override // com.ipd.dsp.internal.j0.a.b
        public com.ipd.dsp.internal.j0.a a(String str) throws IOException {
            return new b(str, this.f38364a);
        }
    }

    public static final class c implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f38365a;

        @Override // com.ipd.dsp.internal.f0.g
        public void a(com.ipd.dsp.internal.j0.a aVar, com.ipd.dsp.internal.j0.a.InterfaceC0886a interfaceC0886a, Map<String, List<String>> map) throws IOException {
            b bVar = (b) aVar;
            int i = 0;
            for (int iF = interfaceC0886a.f(); i.a(iF); iF = bVar.f()) {
                bVar.a();
                i++;
                if (i > 10) {
                    throw new ProtocolException("Too many redirect requests: " + i);
                }
                this.f38365a = i.a(interfaceC0886a, iF);
                bVar.d = new URL(this.f38365a);
                bVar.h();
                com.ipd.dsp.internal.g0.c.a(map, bVar);
                bVar.b.connect();
            }
        }

        @Override // com.ipd.dsp.internal.f0.g
        @Nullable
        public String b() {
            return this.f38365a;
        }
    }

    public b(URLConnection uRLConnection) {
        this(uRLConnection, new c());
    }

    @Override // com.ipd.dsp.internal.j0.a
    public boolean b(@NonNull String str) throws ProtocolException {
        URLConnection uRLConnection = this.b;
        if (!(uRLConnection instanceof HttpURLConnection)) {
            return false;
        }
        ((HttpURLConnection) uRLConnection).setRequestMethod(str);
        return true;
    }

    @Override // com.ipd.dsp.internal.j0.a.InterfaceC0886a
    public InputStream c() throws IOException {
        return this.b.getInputStream();
    }

    @Override // com.ipd.dsp.internal.j0.a
    public Map<String, List<String>> d() {
        return this.b.getRequestProperties();
    }

    @Override // com.ipd.dsp.internal.j0.a.InterfaceC0886a
    public Map<String, List<String>> e() {
        return this.b.getHeaderFields();
    }

    @Override // com.ipd.dsp.internal.j0.a.InterfaceC0886a
    public int f() throws IOException {
        URLConnection uRLConnection = this.b;
        if (uRLConnection instanceof HttpURLConnection) {
            return ((HttpURLConnection) uRLConnection).getResponseCode();
        }
        return 0;
    }

    @Override // com.ipd.dsp.internal.j0.a
    public com.ipd.dsp.internal.j0.a.InterfaceC0886a g() throws IOException {
        Map<String, List<String>> mapD = d();
        this.b.connect();
        this.e.a(this, this, mapD);
        return this;
    }

    public void h() throws IOException {
        com.ipd.dsp.internal.g0.c.a(f, "config connection for " + this.d);
        a aVar = this.c;
        if (aVar == null || aVar.f38363a == null) {
            this.b = this.d.openConnection();
        } else {
            this.b = this.d.openConnection(this.c.f38363a);
        }
        URLConnection uRLConnection = this.b;
        if (uRLConnection instanceof HttpURLConnection) {
            ((HttpURLConnection) uRLConnection).setInstanceFollowRedirects(false);
        }
        URLConnection uRLConnection2 = this.b;
        if (uRLConnection2 instanceof HttpsURLConnection) {
            try {
                ((HttpsURLConnection) uRLConnection2).setSSLSocketFactory(j.a());
                ((HttpsURLConnection) this.b).setHostnameVerifier(j.f38226a);
            } catch (Throwable th) {
                r.a(th);
            }
        }
        a aVar2 = this.c;
        if (aVar2 != null) {
            if (aVar2.b != null) {
                this.b.setReadTimeout(this.c.b.intValue());
            }
            if (this.c.c != null) {
                this.b.setConnectTimeout(this.c.c.intValue());
            }
        }
    }

    public b(URLConnection uRLConnection, g gVar) {
        this.b = uRLConnection;
        this.d = uRLConnection.getURL();
        this.e = gVar;
    }

    @Override // com.ipd.dsp.internal.j0.a
    public void a(String str, String str2) {
        this.b.addRequestProperty(str, str2);
    }

    @Override // com.ipd.dsp.internal.j0.a
    public String c(String str) {
        return this.b.getRequestProperty(str);
    }

    @Override // com.ipd.dsp.internal.j0.a.InterfaceC0886a
    public String a(String str) {
        return this.b.getHeaderField(str);
    }

    @Override // com.ipd.dsp.internal.j0.a.InterfaceC0886a
    public String b() {
        return this.e.b();
    }

    @Override // com.ipd.dsp.internal.j0.a
    public void a() {
        try {
            InputStream inputStream = this.b.getInputStream();
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException unused) {
        }
    }

    public b(String str, a aVar) throws IOException {
        this(new URL(str), aVar);
    }

    public b(URL url, a aVar) throws IOException {
        this(url, aVar, new c());
    }

    public b(URL url, a aVar, g gVar) throws IOException {
        this.c = aVar;
        this.d = url;
        this.e = gVar;
        h();
    }

    public b(String str) throws IOException {
        this(str, (a) null);
    }
}
