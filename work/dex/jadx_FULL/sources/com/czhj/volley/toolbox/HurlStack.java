package com.czhj.volley.toolbox;

import com.aliyun.tea.logging.DefaultLogger;
import com.baidu.mapapi.http.wrapper.HttpManager;
import com.czhj.volley.AuthFailureError;
import com.czhj.volley.Header;
import com.czhj.volley.Request;
import com.ipd.dsp.internal.g0.c;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class HurlStack extends BaseHttpStack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f29486a = 100;
    private final UrlRewriter b;
    private final SSLSocketFactory c;

    public static class UrlConnectionInputStream extends FilterInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final HttpURLConnection f29487a;

        public UrlConnectionInputStream(HttpURLConnection httpURLConnection) {
            super(HurlStack.b(httpURLConnection));
            this.f29487a = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            this.f29487a.disconnect();
        }
    }

    public interface UrlRewriter {
        String rewriteUrl(String str);
    }

    public HurlStack() {
        this(null);
    }

    public HurlStack(UrlRewriter urlRewriter) {
        this(urlRewriter, null);
    }

    public HurlStack(UrlRewriter urlRewriter, SSLSocketFactory sSLSocketFactory) {
        this.b = urlRewriter;
        this.c = sSLSocketFactory;
    }

    private HttpURLConnection a(URL url, Request<?> request) throws IOException {
        HttpURLConnection httpURLConnectionCreateConnection = createConnection(url);
        int timeoutMs = request.getTimeoutMs();
        httpURLConnectionCreateConnection.setConnectTimeout(request.getConnectTimeoutMs());
        httpURLConnectionCreateConnection.setReadTimeout(timeoutMs);
        httpURLConnectionCreateConnection.setUseCaches(false);
        httpURLConnectionCreateConnection.setDoInput(true);
        return httpURLConnectionCreateConnection;
    }

    public static List<Header> a(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    arrayList.add(new Header(entry.getKey(), it.next()));
                }
            }
        }
        return arrayList;
    }

    public static void a(HttpURLConnection httpURLConnection, Request<?> request) throws AuthFailureError, IOException {
        String str;
        String str2;
        switch (request.getMethod()) {
            case -1:
                byte[] body = request.getBody();
                if (body != null) {
                    httpURLConnection.setRequestMethod("POST");
                    a(httpURLConnection, request, body);
                    return;
                }
                return;
            case 0:
                str = "GET";
                httpURLConnection.setRequestMethod(str);
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                b(httpURLConnection, request);
                return;
            case 2:
                str2 = HttpManager.HTTP_PUT;
                httpURLConnection.setRequestMethod(str2);
                b(httpURLConnection, request);
                return;
            case 3:
                str = HttpManager.HTTP_DELETE;
                httpURLConnection.setRequestMethod(str);
                return;
            case 4:
                str = c.f38307a;
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
                b(httpURLConnection, request);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    private static void a(HttpURLConnection httpURLConnection, Request<?> request, byte[] bArr) throws IOException {
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", request.getBodyContentType());
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }

    private static boolean a(int i, int i2) {
        return (i == 4 || (100 <= i2 && i2 < 200) || i2 == 204 || i2 == 304) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InputStream b(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    private static void b(HttpURLConnection httpURLConnection, Request<?> request) throws AuthFailureError, IOException {
        byte[] body = request.getBody();
        if (body != null) {
            a(httpURLConnection, request, body);
        }
    }

    public HttpURLConnection createConnection(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }

    @Override // com.czhj.volley.toolbox.BaseHttpStack
    public HttpResponse executeRequest(Request<?> request, Map<String, String> map) throws AuthFailureError, IOException {
        String url = request.getUrl();
        HashMap map2 = new HashMap();
        map2.putAll(map);
        map2.putAll(request.getHeaders());
        UrlRewriter urlRewriter = this.b;
        if (urlRewriter != null) {
            String strRewriteUrl = urlRewriter.rewriteUrl(url);
            if (strRewriteUrl == null) {
                throw new IOException("URL blocked by rewriter: " + url);
            }
            url = strRewriteUrl;
        }
        HttpURLConnection httpURLConnectionA = a(new URL(url), request);
        try {
            for (String str : map2.keySet()) {
                httpURLConnectionA.setRequestProperty(str, (String) map2.get(str));
            }
            a(httpURLConnectionA, request);
            int responseCode = httpURLConnectionA.getResponseCode();
            if (responseCode == -1) {
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            }
            if (a(request.getMethod(), responseCode)) {
                return new HttpResponse(responseCode, a(httpURLConnectionA.getHeaderFields()), httpURLConnectionA.getContentLength(), new UrlConnectionInputStream(httpURLConnectionA));
            }
            HttpResponse httpResponse = new HttpResponse(responseCode, a(httpURLConnectionA.getHeaderFields()));
            httpURLConnectionA.disconnect();
            return httpResponse;
        } catch (Throwable th) {
            if (0 == 0) {
                httpURLConnectionA.disconnect();
            }
            throw th;
        }
    }
}
