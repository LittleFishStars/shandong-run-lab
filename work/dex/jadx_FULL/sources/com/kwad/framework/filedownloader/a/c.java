package com.kwad.framework.filedownloader.a;

import com.kwad.sdk.api.core.TLSConnectionUtils;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.j;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c implements com.kwad.framework.filedownloader.a.b {
    protected URLConnection aAq;

    public static class a {
        private Proxy aAr;
        private Integer aAs;
        private Integer aAt;
    }

    public static class b implements com.kwad.framework.filedownloader.f.c.b {
        private final a aAu;

        public b() {
            this(null);
        }

        @Override // com.kwad.framework.filedownloader.f.c.b
        public final com.kwad.framework.filedownloader.a.b bX(String str) {
            return new c(str, this.aAu);
        }

        private b(a aVar) {
            this.aAu = null;
        }
    }

    public c(String str, a aVar) {
        this(new URL(str), aVar);
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final Map<String, List<String>> BO() {
        return this.aAq.getRequestProperties();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final Map<String, List<String>> BP() {
        return this.aAq.getHeaderFields();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void BQ() {
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void addHeader(String str, String str2) {
        this.aAq.addRequestProperty(str, str2);
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final String bW(String str) {
        return this.aAq.getHeaderField(str);
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void execute() throws IOException {
        this.aAq.connect();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final InputStream getInputStream() throws IOException {
        return ((j) ServiceProvider.get(j.class)).wrapInputStream(this.aAq.getInputStream());
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final int getResponseCode() throws IOException {
        URLConnection uRLConnection = this.aAq;
        if (!(uRLConnection instanceof HttpURLConnection)) {
            return 0;
        }
        try {
            return ((HttpURLConnection) uRLConnection).getResponseCode();
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    private c(URL url, a aVar) {
        if (aVar == null || aVar.aAr == null) {
            this.aAq = url.openConnection();
        } else {
            this.aAq = url.openConnection(aVar.aAr);
        }
        try {
            TLSConnectionUtils.wrapHttpURLConnection(this.aAq);
        } catch (Throwable unused) {
        }
        if (aVar != null) {
            if (aVar.aAs != null) {
                this.aAq.setReadTimeout(aVar.aAs.intValue());
            }
            if (aVar.aAt != null) {
                this.aAq.setConnectTimeout(aVar.aAt.intValue());
            }
        }
    }
}
