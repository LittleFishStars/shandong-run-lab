package com.androidquery.callback;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Xml;
import android.view.View;
import com.acse.ottn.p3;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.kernel.common.log.ConnectionLog;
import com.alipay.sdk.m.y.l;
import com.androidquery.auth.AccountHandle;
import com.androidquery.util.Constants;
import com.baidu.mapapi.SDKInitializer;
import com.google.common.net.b;
import com.zj.adlib.bx6;
import com.zj.adlib.c30;
import com.zj.adlib.g17;
import com.zj.adlib.gq;
import com.zj.adlib.j6a;
import com.zj.adlib.rv3;
import com.zj.adlib.vp1;
import com.zj.adlib.xv0;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class AbstractAjaxCallback<T, K> implements Runnable {
    public static int O = 30000;
    public static int P = 4;
    public static int Q = 200;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ExecutorService f26163a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static SocketFactory f1159a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static DefaultHttpClient f1160a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Class<?>[] f1161a = {String.class, Object.class, c30.class};
    public static Transformer b = null;
    public static boolean i = true;
    public static String j = null;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public static boolean f1162j = true;
    public static final String k = "\r\n";
    public static final String l = "--";
    public static final String m = "*****";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f1163a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AccountHandle f1164a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Transformer f1165a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c30 f1166a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public File f1167a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Class<T> f1168a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f1169a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Reference<Object> f1170a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WeakReference<Object> f1171a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, Object> f1172a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HttpHost f1173a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HttpUriRequest f1174a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1175a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public File f1176b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public T f1177b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public WeakReference<Activity> f1178b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Map<String, String> f1179b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f1180b;
    public Map<String, String> c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f1181c;
    public boolean e;
    public String f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f1182f;
    public String g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public boolean f1183g;
    public String h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public boolean f1184h;
    public int K = 0;
    public int L = 0;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public String f1185i = "UTF-8";
    public int M = 4;
    public boolean d = true;
    public int N = 0;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Object f1186a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f1187a;

        public a(Object obj, boolean z) {
            this.f1186a = obj;
            this.f1187a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            vp1.n(this.f1186a, AbstractAjaxCallback.this.g, this.f1187a);
        }
    }

    public static int C() {
        ExecutorService executorService = f26163a;
        if (executorService instanceof ThreadPoolExecutor) {
            return ((ThreadPoolExecutor) executorService).getActiveCount();
        }
        return 0;
    }

    public static DefaultHttpClient G() {
        if (f1160a == null || !f1162j) {
            gq.i("creating http client");
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, O);
            HttpConnectionParams.setSoTimeout(basicHttpParams, O);
            ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(25));
            HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            SocketFactory socketFactory = f1159a;
            if (socketFactory == null) {
                socketFactory = SSLSocketFactory.getSocketFactory();
            }
            schemeRegistry.register(new Scheme("https", socketFactory, 443));
            f1160a = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        }
        return f1160a;
    }

    public static void K0(DataOutputStream dataOutputStream, String str, String str2, InputStream inputStream) throws IOException {
        dataOutputStream.writeBytes("--*****\r\n");
        dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"\r\n");
        dataOutputStream.writeBytes("Content-Type: application/octet-stream");
        dataOutputStream.writeBytes("\r\n");
        dataOutputStream.writeBytes("Content-Transfer-Encoding: binary");
        dataOutputStream.writeBytes("\r\n");
        dataOutputStream.writeBytes("\r\n");
        gq.g(inputStream, dataOutputStream);
        dataOutputStream.writeBytes("\r\n");
    }

    public static void L0(DataOutputStream dataOutputStream, String str, String str2) throws IOException {
        dataOutputStream.writeBytes("--*****\r\n");
        dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str + "\"");
        dataOutputStream.writeBytes("\r\n");
        dataOutputStream.writeBytes("\r\n");
        dataOutputStream.write(str2.getBytes("UTF-8"));
        dataOutputStream.writeBytes("\r\n");
    }

    public static void M0(DataOutputStream dataOutputStream, String str, Object obj) throws IOException {
        if (obj == null) {
            return;
        }
        if (obj instanceof File) {
            File file = (File) obj;
            K0(dataOutputStream, str, file.getName(), new FileInputStream(file));
        } else if (obj instanceof byte[]) {
            K0(dataOutputStream, str, str, new ByteArrayInputStream((byte[]) obj));
        } else if (obj instanceof InputStream) {
            K0(dataOutputStream, str, str, (InputStream) obj);
        } else {
            L0(dataOutputStream, str, obj.toString());
        }
    }

    public static boolean Z(Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            gq.j(entry.getKey(), value);
            if ((value instanceof File) || (value instanceof byte[]) || (value instanceof InputStream)) {
                return true;
            }
        }
        return false;
    }

    public static int getLastStatus() {
        return Q;
    }

    public static String k0(String str) {
        return str.replaceAll(" ", "%20").replaceAll("\\|", "%7C");
    }

    public static void m() {
        ExecutorService executorService = f26163a;
        if (executorService != null) {
            executorService.shutdownNow();
            f26163a = null;
        }
        xv0.clearTasks();
    }

    public static void t0(String str) {
        j = str;
    }

    public static void u(Runnable runnable) {
        if (f26163a == null) {
            f26163a = Executors.newFixedThreadPool(P);
        }
        f26163a.execute(runnable);
    }

    public static void u0(boolean z) {
        i = z;
    }

    public static void v0(int i2) {
        int iMax = Math.max(1, Math.min(25, i2));
        P = iMax;
        f26163a = null;
        gq.j("setting network limit", Integer.valueOf(iMax));
    }

    public static Map<String, Object> w(Uri uri) {
        HashMap map = new HashMap();
        for (String str : uri.getQuery().split("&")) {
            String[] strArrSplit = str.split("=");
            if (strArrSplit.length >= 2) {
                map.put(strArrSplit[0], strArrSplit[1]);
            } else if (strArrSplit.length == 1) {
                map.put(strArrSplit[0], "");
            }
        }
        return map;
    }

    public static void w0(boolean z) {
        f1162j = z;
        f1160a = null;
    }

    public static String x(Uri uri) {
        String str = uri.getScheme() + "://" + uri.getAuthority() + uri.getPath();
        String fragment = uri.getFragment();
        if (fragment == null) {
            return str;
        }
        return str + "#" + fragment;
    }

    public static void x0(SocketFactory socketFactory) {
        f1159a = socketFactory;
        f1160a = null;
    }

    public static void y0(int i2) {
        O = i2;
    }

    public static void z0(Transformer transformer) {
        b = transformer;
    }

    public final void A() {
        if (this.f1177b == null || !this.f1175a) {
            return;
        }
        byte[] data = this.f1166a.getData();
        if (data != null) {
            try {
                if (this.f1166a.o() == 1) {
                    File cacheFile = getCacheFile();
                    if (!this.f1166a.getInvalid()) {
                        filePut(this.g, this.f1177b, cacheFile, data);
                    } else if (cacheFile.exists()) {
                        cacheFile.delete();
                    }
                }
            } catch (Exception e) {
                gq.k(e);
            }
        }
        this.f1166a.data(null);
    }

    public K A0(File file) {
        this.f1176b = file;
        return s0();
    }

    public final void B() {
        File fileAccessFile = accessFile(this.f1167a, D());
        if (fileAccessFile != null) {
            this.f1166a.source(3);
            T tFileGet = fileGet(this.g, fileAccessFile, this.f1166a);
            this.f1177b = tFileGet;
            if (tFileGet != null) {
                this.f1166a.time(new Date(fileAccessFile.lastModified())).c();
            }
        }
    }

    public K B0(int i2) {
        this.L = i2;
        return s0();
    }

    public final byte[] C0(String str, InputStream inputStream) throws IOException {
        if ("gzip".equalsIgnoreCase(str)) {
            inputStream = new GZIPInputStream(inputStream);
        }
        return gq.b0(inputStream);
    }

    public final String D() {
        AccountHandle accountHandle = this.f1164a;
        return accountHandle != null ? accountHandle.f(this.g) : this.g;
    }

    public K D0(Transformer transformer) {
        this.f1165a = transformer;
        return s0();
    }

    public String E() {
        return this.f;
    }

    public K E0(Class<T> cls) {
        this.f1168a = cls;
        return s0();
    }

    public final String F(String str) {
        Matcher matcher = Pattern.compile("<meta [^>]*http-equiv[^>]*\"Content-Type\"[^>]*>", 2).matcher(str);
        if (matcher.find()) {
            return j0(matcher.group());
        }
        return null;
    }

    public K F0(boolean z) {
        this.d = z;
        return s0();
    }

    public K G0(String str) {
        this.g = str;
        return s0();
    }

    public String H() {
        return this.f1185i;
    }

    public final void H0() {
        if (this.f1182f) {
            synchronized (this) {
                try {
                    notifyAll();
                } catch (Exception unused) {
                }
            }
        }
    }

    public final String I(HttpEntity httpEntity) {
        Header contentEncoding;
        if (httpEntity == null || (contentEncoding = httpEntity.getContentEncoding()) == null) {
            return null;
        }
        return contentEncoding.getValue();
    }

    public K I0(Object obj, String str) {
        this.f1170a = new WeakReference(obj);
        this.f = str;
        this.f1169a = null;
        return s0();
    }

    public Object J() {
        Object obj = this.f1169a;
        if (obj != null) {
            return obj;
        }
        Reference<Object> reference = this.f1170a;
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    public final void J0(Context context) {
        T tMemGet = memGet(this.g);
        if (tMemGet == null) {
            this.f1167a = gq.q(context, this.K);
            u(this);
        } else {
            this.f1177b = tMemGet;
            this.f1166a.source(4).c();
            k();
        }
    }

    public final String K(String str) {
        String str2 = this.h;
        if (str2 != null) {
            str = str2;
        }
        AccountHandle accountHandle = this.f1164a;
        return accountHandle != null ? accountHandle.g(str) : str;
    }

    public final File L() {
        File fileR;
        if (isStreamingContent()) {
            fileR = this.f1176b;
            if (fileR == null) {
                if (this.f1175a) {
                    fileR = getCacheFile();
                } else {
                    File fileZ = gq.z();
                    if (fileZ == null) {
                        fileZ = this.f1167a;
                    }
                    fileR = gq.r(fileZ, this.g);
                }
            }
        } else {
            fileR = null;
        }
        if (fileR != null && !fileR.exists()) {
            try {
                fileR.getParentFile().mkdirs();
                fileR.createNewFile();
            } catch (Exception e) {
                gq.Q(e);
                return null;
            }
        }
        return fileR;
    }

    public T M() {
        return this.f1177b;
    }

    public c30 N() {
        return this.f1166a;
    }

    public String O() {
        return this.g;
    }

    public K P(Object obj, String str) {
        this.f1169a = obj;
        this.f = str;
        this.f1170a = null;
        return s0();
    }

    public K Q(String str, String str2) {
        if (this.f1179b == null) {
            this.f1179b = new HashMap();
        }
        this.f1179b.put(str, str2);
        return s0();
    }

    public final void R(String str, Map<String, String> map, c30 c30Var) throws Throwable {
        gq.j(p3.f, str);
        String strK0 = k0(str);
        S(new HttpDelete(strK0), strK0, map, c30Var);
    }

    public final void S(HttpUriRequest httpUriRequest, String str, Map<String, String> map, c30 c30Var) throws Throwable {
        HttpResponse httpResponseT;
        InputStream content;
        String str2;
        String str3;
        File fileL;
        OutputStream bufferedOutputStream;
        byte[] byteArray;
        String str4 = j;
        if (str4 != null) {
            httpUriRequest.addHeader("User-Agent", str4);
        }
        if (map != null) {
            for (String str5 : map.keySet()) {
                httpUriRequest.addHeader(str5, map.get(str5));
            }
        }
        if (i && (map == null || !map.containsKey("Accept-Encoding"))) {
            httpUriRequest.addHeader("Accept-Encoding", "gzip");
        }
        String strA0 = a0();
        if (strA0 != null) {
            httpUriRequest.addHeader(b.p, strA0);
        }
        AccountHandle accountHandle = this.f1164a;
        if (accountHandle != null) {
            accountHandle.b(this, httpUriRequest);
        }
        DefaultHttpClient defaultHttpClientG = G();
        HttpParams params = httpUriRequest.getParams();
        HttpHost httpHost = this.f1173a;
        if (httpHost != null) {
            params.setParameter("http.route.default-proxy", httpHost);
        }
        int i2 = this.L;
        if (i2 > 0) {
            params.setParameter("http.connection.timeout", Integer.valueOf(i2));
            params.setParameter("http.socket.timeout", Integer.valueOf(this.L));
        }
        BasicHttpContext basicHttpContext = new BasicHttpContext();
        basicHttpContext.setAttribute("http.cookie-store", new BasicCookieStore());
        this.f1174a = httpUriRequest;
        if (this.f1184h) {
            throw new IOException("Aborted");
        }
        InputStream inputStream = null;
        inputStream = null;
        InputStream inputStream2 = null;
        byte[] bArr = null;
        try {
            httpResponseT = t(httpUriRequest, defaultHttpClientG, basicHttpContext);
        } catch (HttpHostConnectException e) {
            if (this.f1173a == null) {
                throw e;
            }
            gq.i("proxy failed, retrying without proxy");
            params.setParameter("http.route.default-proxy", null);
            httpResponseT = t(httpUriRequest, defaultHttpClientG, basicHttpContext);
        }
        HttpResponse httpResponse = httpResponseT;
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        String reasonPhrase = httpResponse.getStatusLine().getReasonPhrase();
        HttpEntity entity = httpResponse.getEntity();
        if (statusCode < 200 || statusCode >= 300) {
            if (entity != null) {
                try {
                    content = entity.getContent();
                    try {
                        try {
                            str2 = new String(C0(I(entity), content), "UTF-8");
                            try {
                                gq.j("error", str2);
                            } catch (Exception e2) {
                                e = e2;
                                gq.k(e);
                            }
                        } catch (Throwable th) {
                            th = th;
                            inputStream = content;
                            gq.f(inputStream);
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        str2 = null;
                    }
                } catch (Exception e4) {
                    e = e4;
                    content = null;
                    str2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    gq.f(inputStream);
                    throw th;
                }
            } else {
                content = null;
                str2 = null;
            }
            gq.f(content);
            str3 = str;
            fileL = null;
        } else {
            String str6 = ((HttpHost) basicHttpContext.getAttribute("http.target_host")).toURI() + ((HttpUriRequest) basicHttpContext.getAttribute("http.request")).getURI();
            int iMax = Math.max(32, Math.min(65536, (int) entity.getContentLength()));
            try {
                fileL = L();
                if (fileL == null) {
                    bufferedOutputStream = new bx6(iMax);
                } else {
                    fileL.createNewFile();
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileL));
                }
                try {
                    InputStream content2 = entity.getContent();
                    try {
                        if ("gzip".equalsIgnoreCase(I(entity))) {
                            content2 = new GZIPInputStream(content2);
                        }
                        p(content2, bufferedOutputStream, (int) entity.getContentLength());
                        bufferedOutputStream.flush();
                        if (fileL == null) {
                            byteArray = ((bx6) bufferedOutputStream).toByteArray();
                        } else if (!fileL.exists() || fileL.length() == 0) {
                            byteArray = null;
                            fileL = null;
                        } else {
                            byteArray = null;
                        }
                        gq.f(content2);
                        gq.f(bufferedOutputStream);
                        bArr = byteArray;
                        str3 = str6;
                        str2 = null;
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream2 = content2;
                        gq.f(inputStream2);
                        gq.f(bufferedOutputStream);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Throwable th5) {
                th = th5;
                bufferedOutputStream = null;
            }
        }
        gq.j(ConnectionLog.CONN_LOG_STATE_RESPONSE, Integer.valueOf(statusCode));
        if (bArr != null) {
            gq.j(Integer.valueOf(bArr.length), str);
        }
        c30Var.b(statusCode).r(reasonPhrase).error(str2).redirect(str3).time(new Date()).data(bArr).file(fileL).client(defaultHttpClientG).context(basicHttpContext).headers(httpResponse.getAllHeaders());
    }

    public final void T(String str, HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, Map<String, String> map, Map<String, Object> map2, c30 c30Var) throws Throwable {
        HttpEntity urlEncodedFormEntity;
        httpEntityEnclosingRequestBase.getParams().setBooleanParameter("http.protocol.expect-continue", false);
        Object obj = map2.get(Constants.f1202m);
        if (obj instanceof HttpEntity) {
            urlEncodedFormEntity = (HttpEntity) obj;
        } else {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, Object> entry : map2.entrySet()) {
                Object value = entry.getValue();
                if (value != null) {
                    arrayList.add(new BasicNameValuePair(entry.getKey(), value.toString()));
                }
            }
            urlEncodedFormEntity = new UrlEncodedFormEntity(arrayList, "UTF-8");
        }
        if (map != null && !map.containsKey("Content-Type")) {
            map.put("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        }
        httpEntityEnclosingRequestBase.setEntity(urlEncodedFormEntity);
        S(httpEntityEnclosingRequestBase, str, map, c30Var);
    }

    public final void U(String str, Map<String, String> map, c30 c30Var) throws Throwable {
        gq.j(p3.f, str);
        String strK0 = k0(str);
        S(new HttpGet(strK0), strK0, map, c30Var);
    }

    public final void V(String str, Map<String, String> map, Map<String, Object> map2, c30 c30Var) throws IOException {
        String str2;
        byte[] bArrC0;
        gq.j("multipart", str);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setConnectTimeout(O * 4);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Connection", b.t0);
        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;charset=utf-8;boundary=*****");
        if (map != null) {
            for (String str3 : map.keySet()) {
                httpURLConnection.setRequestProperty(str3, map.get(str3));
            }
        }
        String strA0 = a0();
        if (strA0 != null) {
            httpURLConnection.setRequestProperty(b.p, strA0);
        }
        AccountHandle accountHandle = this.f1164a;
        if (accountHandle != null) {
            accountHandle.a(this, httpURLConnection);
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        for (Map.Entry<String, Object> entry : map2.entrySet()) {
            M0(dataOutputStream, entry.getKey(), entry.getValue());
        }
        dataOutputStream.writeBytes("--*****--\r\n");
        dataOutputStream.flush();
        dataOutputStream.close();
        httpURLConnection.connect();
        int responseCode = httpURLConnection.getResponseCode();
        String responseMessage = httpURLConnection.getResponseMessage();
        String contentEncoding = httpURLConnection.getContentEncoding();
        if (responseCode < 200 || responseCode >= 300) {
            str2 = new String(C0(contentEncoding, httpURLConnection.getErrorStream()), "UTF-8");
            gq.j("error", str2);
            bArrC0 = null;
        } else {
            bArrC0 = C0(contentEncoding, httpURLConnection.getInputStream());
            str2 = null;
        }
        gq.j(ConnectionLog.CONN_LOG_STATE_RESPONSE, Integer.valueOf(responseCode));
        if (bArrC0 != null) {
            gq.j(Integer.valueOf(bArrC0.length), str);
        }
        c30Var.b(responseCode).r(responseMessage).redirect(str).time(new Date()).data(bArrC0).error(str2).client(null);
    }

    public final void W(String str, Map<String, String> map, Map<String, Object> map2, c30 c30Var) throws Throwable {
        gq.j("post", str);
        T(str, new HttpPost(str), map, map2, c30Var);
    }

    public final void X(String str, Map<String, String> map, Map<String, Object> map2, c30 c30Var) throws Throwable {
        gq.j("put", str);
        T(str, new HttpPut(str), map, map2, c30Var);
    }

    public final boolean Y() {
        WeakReference<Activity> weakReference = this.f1178b;
        if (weakReference == null) {
            return true;
        }
        Activity activity = weakReference.get();
        return (activity == null || activity.isFinishing()) ? false : true;
    }

    public final String a0() {
        Map<String, String> map = this.c;
        if (map == null || map.size() == 0) {
            return null;
        }
        Iterator<String> it = this.c.keySet().iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            String next = it.next();
            String str = this.c.get(next);
            sb.append(next);
            sb.append("=");
            sb.append(str);
            if (it.hasNext()) {
                sb.append("; ");
            }
        }
        return sb.toString();
    }

    public File accessFile(File file, String str) {
        if (this.f1163a < 0) {
            return null;
        }
        File fileT = gq.t(file, str);
        if (fileT == null || this.f1163a == 0 || System.currentTimeMillis() - fileT.lastModified() <= this.f1163a) {
            return fileT;
        }
        return null;
    }

    public void b() {
        this.f1184h = true;
        HttpUriRequest httpUriRequest = this.f1174a;
        if (httpUriRequest == null || httpUriRequest.isAborted()) {
            return;
        }
        this.f1174a.abort();
    }

    public K b0(boolean z) {
        this.f1180b = z;
        return s0();
    }

    public K c0(int i2) {
        this.M = i2;
        return s0();
    }

    public boolean cacheAvailable(Context context) {
        return this.f1175a && gq.t(gq.q(context, this.K), this.g) != null;
    }

    public final void d() {
        String str = this.g;
        if (str != null && this.f1180b) {
            memPut(str, this.f1177b);
        }
        k();
        n();
    }

    public final void d0() throws Throwable {
        String str = this.g;
        Map<String, Object> map = this.f1172a;
        if (map == null && str.length() > 2000) {
            Uri uri = Uri.parse(str);
            String strX = x(uri);
            map = w(uri);
            str = strX;
        }
        String strK = K(str);
        int i2 = this.M;
        if (2 == i2) {
            R(strK, this.f1179b, this.f1166a);
            return;
        }
        if (3 == i2) {
            X(strK, this.f1179b, map, this.f1166a);
            return;
        }
        if (1 == i2 && map == null) {
            map = new HashMap<>();
        }
        if (map == null) {
            U(strK, this.f1179b, this.f1166a);
        } else if (Z(map)) {
            V(strK, this.f1179b, map, this.f1166a);
        } else {
            W(strK, this.f1179b, map, this.f1166a);
        }
    }

    public T datastoreGet(String str) {
        return null;
    }

    public void e(Activity activity) {
        if (activity.isFinishing()) {
            gq.d0(b.g, "Possible memory leak. Calling ajax with a terminated activity.");
        }
        if (this.f1168a == null) {
            gq.d0(b.g, "type() is not called with response type.");
        } else {
            this.f1178b = new WeakReference<>(activity);
            f(activity);
        }
    }

    public final void e0(int i2) throws Throwable {
        if (i2 <= 1) {
            d0();
            return;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            try {
                d0();
                return;
            } catch (IOException e) {
                if (i3 == i2 - 1) {
                    throw e;
                }
            }
        }
    }

    public void f(Context context) {
        c30 c30Var = this.f1166a;
        if (c30Var == null) {
            c30 c30Var2 = new c30();
            this.f1166a = c30Var2;
            c30Var2.redirect(this.g).refresh(this.f1181c);
        } else if (c30Var.getDone()) {
            this.f1166a.reset();
            this.f1177b = null;
        }
        showProgress(true);
        AccountHandle accountHandle = this.f1164a;
        if (accountHandle == null || accountHandle.d()) {
            J0(context);
        } else {
            gq.j("auth needed", this.g);
            this.f1164a.c(this);
        }
    }

    public K f0(String str) {
        this.h = str;
        return s0();
    }

    public T fileGet(String str, File file, c30 c30Var) {
        byte[] bArrB0;
        try {
            if (isStreamingContent()) {
                c30Var.file(file);
                bArrB0 = null;
            } else {
                bArrB0 = gq.b0(new FileInputStream(file));
            }
            return transform(str, bArrB0, c30Var);
        } catch (Exception e) {
            gq.k(e);
            return null;
        }
    }

    public void filePut(String str, T t, File file, byte[] bArr) {
        if (file == null || bArr == null) {
            return;
        }
        gq.X(file, bArr, 0L);
    }

    public K g(Activity activity, String str, String str2) {
        if (str.startsWith("g.")) {
            this.f1164a = new rv3(activity, str, str2);
        }
        return s0();
    }

    public final void g0() throws Throwable {
        byte[] data;
        if (this.g == null) {
            this.f1166a.b(c30.h).c();
            return;
        }
        try {
            e0(this.N + 1);
            AccountHandle accountHandle = this.f1164a;
            if (accountHandle != null && accountHandle.e(this, this.f1166a) && !this.f1183g) {
                gq.j("reauth needed", this.f1166a.l());
                this.f1183g = true;
                if (!this.f1164a.h(this)) {
                    this.f1166a.reauth(true);
                    return;
                }
                d0();
            }
            data = this.f1166a.getData();
        } catch (Exception e) {
            gq.k(e);
            this.f1166a.b(c30.h).r(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR);
            data = null;
        }
        try {
            this.f1177b = transform(this.g, data, this.f1166a);
        } catch (Exception e2) {
            gq.k(e2);
        }
        if (this.f1177b == null && data != null) {
            this.f1166a.b(c30.j).r("transform error");
        }
        Q = this.f1166a.f();
        this.f1166a.c();
    }

    public File getCacheFile() {
        return gq.r(this.f1167a, D());
    }

    public Class<T> getType() {
        return this.f1168a;
    }

    public K h(AccountHandle accountHandle) {
        this.f1164a = accountHandle;
        return s0();
    }

    public K h0(String str, Object obj) {
        if (this.f1172a == null) {
            this.f1172a = new HashMap();
        }
        this.f1172a.put(str, obj);
        return s0();
    }

    public final void i() throws Throwable {
        if (!this.f1181c && this.f1175a) {
            B();
        }
        if (this.f1177b == null) {
            r();
        }
        if (this.f1177b == null) {
            g0();
        }
    }

    public K i0(Map<String, ?> map) {
        this.f1172a = map;
        return s0();
    }

    public boolean isStreamingContent() {
        return File.class.equals(this.f1168a) || XmlPullParser.class.equals(this.f1168a) || InputStream.class.equals(this.f1168a) || j6a.class.equals(this.f1168a);
    }

    public void j() {
        if (gq.E()) {
            throw new IllegalStateException("Cannot block UI thread.");
        }
        if (this.e) {
            return;
        }
        try {
            synchronized (this) {
                this.f1182f = true;
                wait(O + 5000);
            }
        } catch (Exception unused) {
        }
    }

    public final String j0(String str) {
        int iIndexOf;
        if (str == null || (iIndexOf = str.indexOf("charset")) == -1) {
            return null;
        }
        int iIndexOf2 = str.indexOf(l.b, iIndexOf);
        if (iIndexOf2 == -1) {
            iIndexOf2 = str.length();
        }
        return str.substring(iIndexOf + 7, iIndexOf2).replaceAll("[^\\w-]", "");
    }

    public void k() {
        showProgress(false);
        this.e = true;
        if (!Y()) {
            skip(this.g, this.f1177b, this.f1166a);
        } else if (this.f != null) {
            gq.A(J(), this.f, true, true, new Class[]{String.class, this.f1168a, c30.class}, f1161a, this.g, this.f1177b, this.f1166a);
        } else {
            try {
                l(this.g, this.f1177b, this.f1166a);
            } catch (Exception e) {
                gq.Q(e);
            }
        }
        A();
        if (!this.f1182f) {
            this.f1166a.a();
        }
        H0();
        gq.l();
    }

    public void l(String str, T t, c30 c30Var) {
    }

    public K l0(int i2) {
        this.K = i2;
        return s0();
    }

    public K m0(Dialog dialog) {
        return o0(dialog);
    }

    public T memGet(String str) {
        return null;
    }

    public void memPut(String str, T t) {
    }

    public final void n() {
        this.f1170a = null;
        this.f1169a = null;
        this.f1171a = null;
        this.f1174a = null;
        this.f1165a = null;
        this.f1164a = null;
        this.f1178b = null;
    }

    public K n0(View view) {
        return o0(view);
    }

    public K o(String str, String str2) {
        if (this.c == null) {
            this.c = new HashMap();
        }
        this.c.put(str, str2);
        return s0();
    }

    public K o0(Object obj) {
        if (obj != null) {
            this.f1171a = new WeakReference<>(obj);
        }
        return s0();
    }

    public final void p(InputStream inputStream, OutputStream outputStream, int i2) throws IOException {
        WeakReference<Object> weakReference = this.f1171a;
        Object obj = weakReference != null ? weakReference.get() : null;
        gq.h(inputStream, outputStream, i2, obj != null ? new g17(obj) : null);
    }

    public K p0(String str, int i2) {
        this.f1173a = new HttpHost(str, i2);
        return s0();
    }

    public final String q(byte[] bArr, String str, c30 c30Var) {
        String str2 = null;
        try {
            if (!"utf-8".equalsIgnoreCase(str)) {
                return new String(bArr, str);
            }
            String strJ0 = j0(c30Var.j("Content-Type"));
            gq.j("parsing header", strJ0);
            if (strJ0 != null) {
                return new String(bArr, strJ0);
            }
            String str3 = new String(bArr, "utf-8");
            try {
                String strF = F(str3);
                gq.j("parsing needed", strF);
                if (strF == null || "utf-8".equalsIgnoreCase(strF)) {
                    return str3;
                }
                gq.j("correction needed", strF);
                String str4 = new String(bArr, strF);
                try {
                    c30Var.data(str4.getBytes("utf-8"));
                    return str4;
                } catch (Exception e) {
                    e = e;
                    str2 = str4;
                }
            } catch (Exception e2) {
                e = e2;
                str2 = str3;
            }
            gq.Q(e);
            return str2;
        } catch (Exception e3) {
            e = e3;
        }
    }

    public K q0(boolean z) {
        this.f1181c = z;
        return s0();
    }

    public final void r() {
        T tDatastoreGet = datastoreGet(this.g);
        this.f1177b = tDatastoreGet;
        if (tDatastoreGet != null) {
            this.f1166a.source(2).c();
        }
    }

    public K r0(int i2) {
        this.N = i2;
        return s0();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1166a.getDone()) {
            d();
            return;
        }
        try {
            i();
        } catch (Throwable th) {
            gq.k(th);
            this.f1166a.b(c30.h).c();
        }
        if (this.f1166a.getReauth()) {
            return;
        }
        if (this.d) {
            gq.K(this);
        } else {
            d();
        }
    }

    public K s(String str) {
        this.f1185i = str;
        return s0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final K s0() {
        return this;
    }

    public void showProgress(boolean z) {
        WeakReference<Object> weakReference = this.f1171a;
        Object obj = weakReference == null ? null : weakReference.get();
        if (obj != null) {
            if (gq.E()) {
                vp1.n(obj, this.g, z);
            } else {
                gq.K(new a(obj, z));
            }
        }
    }

    public void skip(String str, T t, c30 c30Var) {
    }

    public final HttpResponse t(HttpUriRequest httpUriRequest, DefaultHttpClient defaultHttpClient, HttpContext httpContext) throws IOException {
        if (!httpUriRequest.getURI().getAuthority().contains(LoginConstants.UNDER_LINE)) {
            return defaultHttpClient.execute(httpUriRequest, httpContext);
        }
        URL url = httpUriRequest.getURI().toURL();
        return defaultHttpClient.execute(url.getPort() == -1 ? new HttpHost(url.getHost(), 80, url.getProtocol()) : new HttpHost(url.getHost(), url.getPort(), url.getProtocol()), httpUriRequest, httpContext);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.io.File] */
    /* JADX WARN: Type inference failed for: r9v12, types: [T, java.io.Closeable, java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r9v13, types: [T, org.xmlpull.v1.XmlPullParser] */
    public T transform(String str, byte[] bArr, c30 c30Var) {
        String str2;
        if (this.f1168a == null) {
            return null;
        }
        ?? r0 = (T) c30Var.getFile();
        if (bArr != 0) {
            if (this.f1168a.equals(Bitmap.class)) {
                return (T) BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            }
            if (this.f1168a.equals(JSONObject.class)) {
                try {
                    str2 = new String(bArr, this.f1185i);
                    try {
                        return (T) ((JSONObject) new JSONTokener(str2).nextValue());
                    } catch (Exception e) {
                        e = e;
                        gq.k(e);
                        gq.i(str2);
                        return null;
                    }
                } catch (Exception e2) {
                    e = e2;
                    str2 = null;
                }
            } else {
                if (this.f1168a.equals(JSONArray.class)) {
                    try {
                        return (T) ((JSONArray) new JSONTokener(new String(bArr, this.f1185i)).nextValue());
                    } catch (Exception e3) {
                        gq.k(e3);
                        return null;
                    }
                }
                if (this.f1168a.equals(String.class)) {
                    if (c30Var.o() == 1) {
                        gq.i("network");
                        return (T) q(bArr, this.f1185i, c30Var);
                    }
                    gq.i("file");
                    try {
                        return (T) new String(bArr, this.f1185i);
                    } catch (Exception e4) {
                        gq.k(e4);
                        return null;
                    }
                }
                if (this.f1168a.equals(byte[].class)) {
                    return bArr;
                }
                Transformer transformer = this.f1165a;
                if (transformer != null) {
                    return (T) transformer.a(str, this.f1168a, this.f1185i, bArr, c30Var);
                }
                Transformer transformer2 = b;
                if (transformer2 != null) {
                    return (T) transformer2.a(str, this.f1168a, this.f1185i, bArr, c30Var);
                }
            }
        } else if (r0 != 0) {
            if (this.f1168a.equals(File.class)) {
                return r0;
            }
            if (this.f1168a.equals(j6a.class)) {
                try {
                    FileInputStream fileInputStream = new FileInputStream((File) r0);
                    T t = (T) new j6a(fileInputStream);
                    c30Var.closeLater(fileInputStream);
                    return t;
                } catch (Exception e5) {
                    gq.Q(e5);
                    return null;
                }
            }
            if (this.f1168a.equals(XmlPullParser.class)) {
                ?? r9 = (T) Xml.newPullParser();
                try {
                    FileInputStream fileInputStream2 = new FileInputStream((File) r0);
                    r9.setInput(fileInputStream2, this.f1185i);
                    c30Var.closeLater(fileInputStream2);
                    return r9;
                } catch (Exception e6) {
                    gq.Q(e6);
                    return null;
                }
            }
            if (this.f1168a.equals(InputStream.class)) {
                try {
                    ?? r10 = (T) new FileInputStream((File) r0);
                    c30Var.closeLater(r10);
                    return r10;
                } catch (Exception e7) {
                    gq.Q(e7);
                }
            }
        }
        return null;
    }

    public K v(long j2) {
        this.f1163a = j2;
        return s0();
    }

    public void y(int i2, String str) {
        c30 c30Var = this.f1166a;
        if (c30Var != null) {
            c30Var.b(i2).r(str);
            k();
        }
    }

    public K z(boolean z) {
        this.f1175a = z;
        return s0();
    }
}
