package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.kwad.sdk.utils.az;
import com.zj.adlib.c49;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class j extends p {
    private final com.kwad.sdk.core.videocache.d.c aZN;
    private final com.kwad.sdk.core.videocache.b.b aZO;
    private n bal;
    private InputStream ban;
    private OkHttpClient bas = new OkHttpClient();

    public j(String str, com.kwad.sdk.core.videocache.d.c cVar, com.kwad.sdk.core.videocache.b.b bVar) {
        this.aZN = (com.kwad.sdk.core.videocache.d.c) az.checkNotNull(cVar);
        this.aZO = (com.kwad.sdk.core.videocache.b.b) az.checkNotNull(bVar);
        n nVarFG = cVar.fG(str);
        this.bal = nVarFG == null ? new n(str, -2147483648L, l.fE(str)) : nVarFG;
    }

    private void Pe() {
        Response responseEP = null;
        try {
            try {
                responseEP = eP(10000);
                if (responseEP == null || !responseEP.isSuccessful()) {
                    throw new ProxyCacheException("Fail to fetchContentInfo: " + getUrl());
                }
                n nVar = new n(this.bal.url, c(responseEP), responseEP.header("Content-Type"));
                this.bal = nVar;
                this.aZN.a(nVar.url, nVar);
                com.kwad.sdk.core.d.c.d(com.ipd.dsp.internal.v0.e.e, "Source info fetched: " + this.bal);
                if (responseEP.body() == null) {
                    return;
                }
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) responseEP.body());
            } catch (IOException unused) {
                com.kwad.sdk.core.d.c.e(com.ipd.dsp.internal.v0.e.e, "Error fetching info from " + this.bal.url);
                if (0 == 0 || responseEP.body() == null) {
                }
            }
        } catch (Throwable th) {
            if (0 != 0 && responseEP.body() != null) {
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) responseEP.body());
            }
            throw th;
        }
    }

    private void Pg() {
        n nVarFG;
        com.kwad.sdk.core.videocache.d.c cVar = this.aZN;
        if (cVar == null || !(cVar instanceof com.kwad.sdk.core.videocache.d.b) || (nVarFG = cVar.fG(getUrl())) == null || TextUtils.isEmpty(nVarFG.baC) || nVarFG.baB == -2147483648L) {
            return;
        }
        this.bal = nVarFG;
    }

    private long a(Response response, long j) {
        int iCode = response.code();
        long jContentLength = response.body().contentLength();
        if (iCode == 200) {
            return jContentLength;
        }
        return iCode == 206 ? jContentLength + j : this.bal.baB;
    }

    private static long c(Response response) {
        String strHeader = response.header("Content-Length");
        if (strHeader == null) {
            return -1L;
        }
        return Long.parseLong(strHeader);
    }

    private Response eP(int i) throws ProxyCacheException {
        Response responseExecute;
        OkHttpClient.Builder builderNewBuilder = new OkHttpClient().newBuilder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builderNewBuilder.connectTimeout(10000L, timeUnit);
        builderNewBuilder.readTimeout(10000L, timeUnit);
        builderNewBuilder.writeTimeout(10000L, timeUnit);
        int i2 = 0;
        builderNewBuilder.connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
        try {
            builderNewBuilder.dns(new com.kwad.sdk.core.network.a.d());
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
        this.bas = builderNewBuilder.build();
        String url = getUrl();
        boolean zIsRedirect = false;
        do {
            Request.Builder builder = new Request.Builder();
            builder.head();
            builder.url(url);
            responseExecute = this.bas.newCall(builder.build()).execute();
            if (responseExecute.isRedirect()) {
                url = responseExecute.header("Location");
                zIsRedirect = responseExecute.isRedirect();
                i2++;
            }
            if (i2 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i2);
            }
        } while (zIsRedirect);
        return responseExecute;
    }

    private Response f(long j, int i) throws ProxyCacheException {
        Response responseExecute;
        OkHttpClient.Builder builderNewBuilder = this.bas.newBuilder();
        int i2 = 0;
        builderNewBuilder.connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
        try {
            builderNewBuilder.dns(new com.kwad.sdk.core.network.a.d());
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
        this.bas = builderNewBuilder.build();
        String url = getUrl();
        boolean zIsRedirect = false;
        do {
            Request.Builder builder = new Request.Builder();
            builder.get();
            builder.url(url);
            if (j > 0) {
                builder.addHeader("Range", "bytes=" + j + c49.f40900a);
            }
            responseExecute = this.bas.newCall(builder.build()).execute();
            if (responseExecute.isRedirect()) {
                url = responseExecute.header("Location");
                zIsRedirect = responseExecute.isRedirect();
                i2++;
            }
            if (i2 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i2);
            }
        } while (zIsRedirect);
        return responseExecute;
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final synchronized String Pf() {
        if (TextUtils.isEmpty(this.bal.baC)) {
            Pg();
        }
        if (TextUtils.isEmpty(this.bal.baC)) {
            Pe();
        }
        return this.bal.baC;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final void aP(long j) throws ProxyCacheException {
        try {
            Response responseF = f(j, -1);
            String string = responseF.body().contentType().toString();
            long jA = a(responseF, j);
            this.ban = new BufferedInputStream(responseF.body().byteStream(), 1024);
            n nVar = new n(this.bal.url, jA, string);
            this.bal = nVar;
            this.aZN.a(nVar.url, nVar);
        } catch (IOException e) {
            throw new ProxyCacheException("Error opening connection for " + getUrl() + " with offset " + j, e);
        }
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final void close() {
        com.kwad.sdk.crash.utils.b.closeQuietly(this.ban);
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final String getUrl() {
        return this.bal.url;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final synchronized long length() {
        if (this.bal.baB == -2147483648L) {
            Pg();
        }
        if (this.bal.baB == -2147483648L) {
            Pe();
        }
        return this.bal.baB;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final int read(byte[] bArr) throws ProxyCacheException {
        InputStream inputStream = this.ban;
        if (inputStream == null) {
            throw new ProxyCacheException("Error reading data from " + this.bal.url + ": connection is absent!");
        }
        try {
            return inputStream.read(bArr, 0, 1024);
        } catch (InterruptedIOException e) {
            throw new InterruptedProxyCacheException("Reading source " + this.bal.url + " is interrupted", e);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error reading data from " + this.bal.url, e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final String toString() {
        return "HttpUrlSource{sourceInfo='" + this.bal + "}";
    }

    public j(j jVar) {
        this.bal = jVar.bal;
        this.aZN = jVar.aZN;
        this.aZO = jVar.aZO;
    }
}
