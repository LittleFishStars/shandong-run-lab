package com.ipd.dsp.internal.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.ipd.dsp.Dsp;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class h implements d<InputStream> {
    public static final String l = "HttpUrlFetcher";
    public static final int m = 5;

    @VisibleForTesting
    public static final String n = "Location";

    @VisibleForTesting
    public static final b o = new a();

    @VisibleForTesting
    public static final int p = -1;
    public final com.ipd.dsp.internal.n.h f;
    public final int g;
    public final b h;
    public HttpURLConnection i;
    public InputStream j;
    public volatile boolean k;

    public static class a implements b {
        @Override // com.ipd.dsp.internal.g.h.b
        public HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    public interface b {
        HttpURLConnection a(URL url) throws IOException;
    }

    public h(com.ipd.dsp.internal.n.h hVar, int i) {
        this(hVar, i, o);
    }

    public static boolean b(int i) {
        return i / 100 == 3;
    }

    @Override // com.ipd.dsp.internal.g.d
    public void a(@NonNull com.ipd.dsp.internal.b.e eVar, @NonNull d.a<? super InputStream> aVar) {
        long jA = com.ipd.dsp.internal.d0.i.a();
        try {
            aVar.a(a(this.f.g(), 0, null, this.f.c()));
        } catch (IOException e) {
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.a(l, "Failed to load data for url", e);
            }
            aVar.onLoadFailed(e);
        } finally {
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.e(l, "Finished http url fetcher fetch in " + com.ipd.dsp.internal.d0.i.a(jA));
            }
        }
    }

    @Override // com.ipd.dsp.internal.g.d
    @NonNull
    public com.ipd.dsp.internal.f.a c() {
        return com.ipd.dsp.internal.f.a.REMOTE;
    }

    @Override // com.ipd.dsp.internal.g.d
    public void cancel() {
        this.k = true;
    }

    @VisibleForTesting
    public h(com.ipd.dsp.internal.n.h hVar, int i, b bVar) {
        this.f = hVar;
        this.g = i;
        this.h = bVar;
    }

    public final InputStream b(HttpURLConnection httpURLConnection) throws com.ipd.dsp.internal.f.e {
        try {
            if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                this.j = com.ipd.dsp.internal.d0.c.a(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
            } else {
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.a(l, "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
                }
                this.j = httpURLConnection.getInputStream();
            }
            return this.j;
        } catch (IOException e) {
            throw new com.ipd.dsp.internal.f.e("Failed to obtain InputStream", a(httpURLConnection), e);
        }
    }

    @Override // com.ipd.dsp.internal.g.d
    public void b() {
        InputStream inputStream = this.j;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.i;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.i = null;
    }

    public final InputStream a(URL url, int i, URL url2, Map<String, String> map) throws com.ipd.dsp.internal.f.e {
        if (i < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new com.ipd.dsp.internal.f.e("In re-direct loop", -1);
                    }
                } catch (URISyntaxException unused) {
                }
            }
            HttpURLConnection httpURLConnectionA = a(url, map);
            this.i = httpURLConnectionA;
            try {
                httpURLConnectionA.connect();
                this.j = this.i.getInputStream();
                if (this.k) {
                    return null;
                }
                int iA = a(this.i);
                if (a(iA)) {
                    return b(this.i);
                }
                if (!b(iA)) {
                    if (iA == -1) {
                        throw new com.ipd.dsp.internal.f.e(iA);
                    }
                    try {
                        throw new com.ipd.dsp.internal.f.e(this.i.getResponseMessage(), iA);
                    } catch (IOException e) {
                        throw new com.ipd.dsp.internal.f.e("Failed to get a response message", iA, e);
                    }
                }
                String headerField = this.i.getHeaderField("Location");
                if (!TextUtils.isEmpty(headerField)) {
                    try {
                        URL url3 = new URL(url, headerField);
                        b();
                        return a(url3, i + 1, url, map);
                    } catch (MalformedURLException e2) {
                        throw new com.ipd.dsp.internal.f.e("Bad redirect url: " + headerField, iA, e2);
                    }
                }
                throw new com.ipd.dsp.internal.f.e("Received empty or null redirect url", iA);
            } catch (IOException e3) {
                throw new com.ipd.dsp.internal.f.e("Failed to connect or obtain data", a(this.i), e3);
            }
        }
        throw new com.ipd.dsp.internal.f.e("Too many (> 5) redirects!", -1);
    }

    public static int a(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e) {
            if (!Dsp.isDebugLogEnable()) {
                return -1;
            }
            com.ipd.dsp.internal.c2.k.a(l, "Failed to get a response code", e);
            return -1;
        }
    }

    public final HttpURLConnection a(URL url, Map<String, String> map) throws com.ipd.dsp.internal.f.e {
        try {
            HttpURLConnection httpURLConnectionA = this.h.a(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpURLConnectionA.addRequestProperty(entry.getKey(), entry.getValue());
            }
            httpURLConnectionA.setConnectTimeout(this.g);
            httpURLConnectionA.setReadTimeout(this.g);
            httpURLConnectionA.setUseCaches(false);
            httpURLConnectionA.setDoInput(true);
            httpURLConnectionA.setInstanceFollowRedirects(false);
            return httpURLConnectionA;
        } catch (IOException e) {
            throw new com.ipd.dsp.internal.f.e("URL.openConnection threw", 0, e);
        }
    }

    public static boolean a(int i) {
        return i / 100 == 2;
    }

    @Override // com.ipd.dsp.internal.g.d
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }
}
