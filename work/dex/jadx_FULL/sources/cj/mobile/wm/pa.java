package cj.mobile.wm;

import com.aliyun.tea.logging.DefaultLogger;
import com.baidu.mapapi.http.wrapper.HttpManager;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class pa extends ja {
    public final dexb dexa;
    public final SSLSocketFactory dexb;

    public static class dexa extends FilterInputStream {
        public final HttpURLConnection dexa;

        public dexa(HttpURLConnection httpURLConnection) {
            super(pa.dexb(httpURLConnection));
            this.dexa = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            this.dexa.disconnect();
        }
    }

    public interface dexb extends ta {
    }

    public pa() {
        this(null);
    }

    public pa(dexb dexbVar) {
        this(dexbVar, null);
    }

    public pa(dexb dexbVar, SSLSocketFactory sSLSocketFactory) {
        this.dexa = dexbVar;
        this.dexb = sSLSocketFactory;
    }

    private oa dexa(com.wangmai.insightvision.openadsdk.j.j.m<?> mVar, String str, HashMap<String, String> map) {
        HttpURLConnection httpURLConnectionDexa = dexa(new URL(str), mVar);
        httpURLConnectionDexa.setInstanceFollowRedirects(false);
        try {
            for (String str2 : map.keySet()) {
                httpURLConnectionDexa.setRequestProperty(str2, map.get(str2));
            }
            dexa(httpURLConnectionDexa, mVar);
            int responseCode = httpURLConnectionDexa.getResponseCode();
            if (responseCode != 301 && responseCode != 302) {
                if (responseCode == -1) {
                    throw new IOException("Could not retrieve response code from HttpUrlConnection.");
                }
                if (dexa(mVar.dexe(), responseCode)) {
                    return new oa(responseCode, dexa(httpURLConnectionDexa.getHeaderFields()), httpURLConnectionDexa.getContentLength(), dexa(mVar, httpURLConnectionDexa));
                }
                oa oaVar = new oa(responseCode, dexa(httpURLConnectionDexa.getHeaderFields()));
                httpURLConnectionDexa.disconnect();
                return oaVar;
            }
            String headerField = httpURLConnectionDexa.getHeaderField("Location");
            httpURLConnectionDexa.disconnect();
            oa oaVarDexa = dexa(mVar, headerField, map);
            httpURLConnectionDexa.disconnect();
            return oaVarDexa;
        } catch (Throwable th) {
            if (0 == 0) {
                httpURLConnectionDexa.disconnect();
            }
            throw th;
        }
    }

    private HttpURLConnection dexa(URL url, com.wangmai.insightvision.openadsdk.j.j.m<?> mVar) {
        SSLSocketFactory sSLSocketFactory;
        HttpURLConnection httpURLConnectionDexa = dexa(url);
        int iDexm = mVar.dexm();
        httpURLConnectionDexa.setConnectTimeout(iDexm);
        httpURLConnectionDexa.setReadTimeout(iDexm);
        httpURLConnectionDexa.setUseCaches(false);
        httpURLConnectionDexa.setDoInput(true);
        if ("https".equals(url.getProtocol()) && (sSLSocketFactory = this.dexb) != null) {
            ((HttpsURLConnection) httpURLConnectionDexa).setSSLSocketFactory(sSLSocketFactory);
        }
        return httpURLConnectionDexa;
    }

    public static List<aa> dexa(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    arrayList.add(new aa(entry.getKey(), it.next()));
                }
            }
        }
        return arrayList;
    }

    private void dexa(HttpURLConnection httpURLConnection, com.wangmai.insightvision.openadsdk.j.j.m<?> mVar, byte[] bArr) throws IOException {
        httpURLConnection.setDoOutput(true);
        if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
            httpURLConnection.setRequestProperty("Content-Type", mVar.dexb());
        }
        DataOutputStream dataOutputStream = new DataOutputStream(dexa(mVar, httpURLConnection, bArr.length));
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }

    public static boolean dexa(int i, int i2) {
        return (i == 4 || (100 <= i2 && i2 < 200) || i2 == 204 || i2 == 304) ? false : true;
    }

    public static InputStream dexb(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    private void dexb(HttpURLConnection httpURLConnection, com.wangmai.insightvision.openadsdk.j.j.m<?> mVar) throws IOException {
        byte[] bArrDexa = mVar.dexa();
        if (bArrDexa != null) {
            dexa(httpURLConnection, mVar, bArrDexa);
        }
    }

    @Override // cj.mobile.wm.ja
    public oa dexa(com.wangmai.insightvision.openadsdk.j.j.m<?> mVar, Map<String, String> map) throws IOException {
        String strDexo = mVar.dexo();
        HashMap<String, String> map2 = new HashMap<>();
        map2.putAll(map);
        map2.putAll(mVar.dexd());
        dexb dexbVar = this.dexa;
        if (dexbVar != null) {
            String strA = dexbVar.a(strDexo);
            if (strA == null) {
                throw new IOException("URL blocked by rewriter: " + strDexo);
            }
            strDexo = strA;
        }
        return dexa(mVar, strDexo, map2);
    }

    public InputStream dexa(com.wangmai.insightvision.openadsdk.j.j.m<?> mVar, HttpURLConnection httpURLConnection) {
        return new dexa(httpURLConnection);
    }

    public OutputStream dexa(com.wangmai.insightvision.openadsdk.j.j.m<?> mVar, HttpURLConnection httpURLConnection, int i) {
        return httpURLConnection.getOutputStream();
    }

    public HttpURLConnection dexa(URL url) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }

    public void dexa(HttpURLConnection httpURLConnection, com.wangmai.insightvision.openadsdk.j.j.m<?> mVar) throws IOException {
        String str;
        String str2;
        switch (mVar.dexe()) {
            case -1:
                byte[] bArrDexh = mVar.dexh();
                if (bArrDexh != null) {
                    httpURLConnection.setRequestMethod("POST");
                    dexa(httpURLConnection, mVar, bArrDexh);
                    return;
                }
                return;
            case 0:
                str = "GET";
                httpURLConnection.setRequestMethod(str);
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                dexb(httpURLConnection, mVar);
                return;
            case 2:
                str2 = HttpManager.HTTP_PUT;
                httpURLConnection.setRequestMethod(str2);
                dexb(httpURLConnection, mVar);
                return;
            case 3:
                str = HttpManager.HTTP_DELETE;
                httpURLConnection.setRequestMethod(str);
                return;
            case 4:
                str = com.ipd.dsp.internal.g0.c.f38307a;
                httpURLConnection.setRequestMethod(str);
                return;
            case 5:
                str = "OPTIONS";
                httpURLConnection.setRequestMethod(str);
                return;
            case 6:
                str = DefaultLogger.TRACE;
                httpURLConnection.setRequestMethod(str);
                return;
            case 7:
                str2 = "PATCH";
                httpURLConnection.setRequestMethod(str2);
                dexb(httpURLConnection, mVar);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }
}
