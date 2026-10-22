package cj.mobile.wm;

import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b3 implements y2<InputStream> {
    public static final dexc dexf = new dexb();
    public final n4 dexa;
    public final dexc dexb;
    public HttpURLConnection dexc;
    public InputStream dexd;
    public volatile boolean dexe;

    public static class dexb implements dexc {
        public dexb() {
        }

        @Override // cj.mobile.wm.b3.dexc
        public HttpURLConnection dexa(URL url) {
            return (HttpURLConnection) url.openConnection();
        }
    }

    public interface dexc {
        HttpURLConnection dexa(URL url);
    }

    public b3(n4 n4Var) {
        this(n4Var, dexf);
    }

    public b3(n4 n4Var, dexc dexcVar) {
        this.dexa = n4Var;
        this.dexb = dexcVar;
    }

    private InputStream dexa(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream;
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            inputStream = y8.dexa(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable(com.ipd.dsp.internal.g.h.l, 3)) {
                f1.dexa(com.ipd.dsp.internal.g.h.l, "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            inputStream = httpURLConnection.getInputStream();
        }
        this.dexd = inputStream;
        return this.dexd;
    }

    private InputStream dexa(URL url, int i, URL url2, Map<String, String> map) throws IOException {
        if (i >= 5) {
            throw new IOException("Too many (> 5) redirects!");
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new IOException("In re-direct loop");
                }
            } catch (URISyntaxException unused) {
            }
        }
        this.dexc = this.dexb.dexa(url);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.dexc.addRequestProperty(entry.getKey(), entry.getValue());
        }
        this.dexc.setConnectTimeout(2500);
        this.dexc.setReadTimeout(2500);
        this.dexc.setUseCaches(false);
        this.dexc.setDoInput(true);
        this.dexc.connect();
        if (this.dexe) {
            return null;
        }
        int responseCode = this.dexc.getResponseCode();
        int i2 = responseCode / 100;
        if (i2 == 2) {
            return dexa(this.dexc);
        }
        if (i2 == 3) {
            String headerField = this.dexc.getHeaderField("Location");
            if (TextUtils.isEmpty(headerField)) {
                throw new IOException("Received empty or null redirect url");
            }
            return dexa(new URL(url, headerField), i + 1, url, map);
        }
        if (responseCode == -1) {
            throw new IOException("Unable to retrieve response code from HttpUrlConnection.");
        }
        throw new IOException("Request failed " + responseCode + ": " + this.dexc.getResponseMessage());
    }

    @Override // cj.mobile.wm.y2
    public void a() {
        InputStream inputStream = this.dexd;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.dexc;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    @Override // cj.mobile.wm.y2
    public void b() {
        this.dexe = true;
    }

    @Override // cj.mobile.wm.y2
    /* JADX INFO: renamed from: dexb, reason: merged with bridge method [inline-methods] */
    public InputStream dexa(com.wangmai.insightvision.openadsdk.image.b.i iVar) {
        return dexa(this.dexa.dexc(), 0, null, this.dexa.dexb());
    }

    @Override // cj.mobile.wm.y2
    public String getId() {
        return this.dexa.dexa();
    }
}
