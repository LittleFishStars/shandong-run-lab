package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.util.Log;
import com.google.common.base.Predicate;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import com.zj.adlib.t24;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class e extends BaseDataSource implements HttpDataSource {
    public static final String b = "DefaultHttpDataSource";
    public static final long c = 2048;
    public static final int e = 8000;
    public static final int f = 8000;
    public static final int g = 20;
    public static final int h = 307;
    public static final int i = 308;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f31144a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final HttpDataSource.a f5204a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public InputStream f5205a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final String f5206a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public HttpURLConnection f5207a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final int f5208b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f5209b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public DataSpec f5210b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final HttpDataSource.a f5211b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public Predicate<String> f5212b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f5213b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final int f5214c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final boolean f5215c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f5216d;

    public static final class b implements HttpDataSource.Factory {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public TransferListener f5218a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public Predicate<String> f5219a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public String f5220a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f5221a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f5222b;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final HttpDataSource.a f5217a = new HttpDataSource.a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f31145a = 8000;
        public int b = 8000;

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource.Factory
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public e a() {
            e eVar = new e(this.f5220a, this.f31145a, this.b, this.f5221a, this.f5217a, this.f5219a, this.f5222b);
            TransferListener transferListener = this.f5218a;
            if (transferListener != null) {
                eVar.b(transferListener);
            }
            return eVar;
        }

        public b e(boolean z) {
            this.f5221a = z;
            return this;
        }

        public b f(int i) {
            this.f31145a = i;
            return this;
        }

        public b g(@Nullable Predicate<String> predicate) {
            this.f5219a = predicate;
            return this;
        }

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource.Factory
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final b c(Map<String, String> map) {
            this.f5217a.b(map);
            return this;
        }

        public b i(boolean z) {
            this.f5222b = z;
            return this;
        }

        public b j(int i) {
            this.b = i;
            return this;
        }

        public b k(@Nullable TransferListener transferListener) {
            this.f5218a = transferListener;
            return this;
        }

        public b l(@Nullable String str) {
            this.f5220a = str;
            return this;
        }
    }

    public static class c extends ForwardingMap<String, List<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, List<String>> f31146a;

        public c(Map<String, List<String>> map) {
            this.f31146a = map;
        }

        public static /* synthetic */ boolean lambda$entrySet$1(Map.Entry entry) {
            return entry.getKey() != null;
        }

        public static /* synthetic */ boolean lambda$keySet$0(String str) {
            return str != null;
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public boolean containsKey(@Nullable Object obj) {
            return obj != null && super.containsKey(obj);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public boolean containsValue(@Nullable Object obj) {
            return super.standardContainsValue(obj);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set<Map.Entry<String, List<String>>> entrySet() {
            return Sets.i(super.entrySet(), new Predicate() { // from class: com.zj.adlib.pg2
                @Override // com.google.common.base.Predicate
                public final boolean apply(Object obj) {
                    return e.c.lambda$entrySet$1((Map.Entry) obj);
                }
            });
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public boolean equals(@Nullable Object obj) {
            return obj != null && super.standardEquals(obj);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public int hashCode() {
            return super.standardHashCode();
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public boolean isEmpty() {
            if (super.isEmpty()) {
                return true;
            }
            return super.size() == 1 && super.containsKey(null);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set<String> keySet() {
            return Sets.i(super.keySet(), new Predicate() { // from class: com.zj.adlib.og2
                @Override // com.google.common.base.Predicate
                public final boolean apply(Object obj) {
                    return e.c.lambda$keySet$0((String) obj);
                }
            });
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public int size() {
            return super.size() - (super.containsKey(null) ? 1 : 0);
        }

        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public Map<String, List<String>> delegate() {
            return this.f31146a;
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        @Nullable
        public List<String> get(@Nullable Object obj) {
            if (obj == null) {
                return null;
            }
            return (List) super.get(obj);
        }
    }

    public static boolean i(HttpURLConnection httpURLConnection) {
        return "gzip".equalsIgnoreCase(httpURLConnection.getHeaderField("Content-Encoding"));
    }

    public static void l(@Nullable HttpURLConnection httpURLConnection, long j) {
        int i2;
        if (httpURLConnection == null || (i2 = gj9.f41922a) < 19 || i2 > 20) {
            return;
        }
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            if (j == -1) {
                if (inputStream.read() == -1) {
                    return;
                }
            } else if (j <= 2048) {
                return;
            }
            String name = inputStream.getClass().getName();
            if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                Method declaredMethod = ((Class) sb0.g(inputStream.getClass().getSuperclass())).getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(inputStream, new Object[0]);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long a(DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        byte[] bArrB1;
        this.f5210b = dataSpec;
        long j = 0;
        this.f5209b = 0L;
        this.f31144a = 0L;
        transferInitializing(dataSpec);
        try {
            HttpURLConnection httpURLConnectionJ = j(dataSpec);
            this.f5207a = httpURLConnectionJ;
            this.d = httpURLConnectionJ.getResponseCode();
            String responseMessage = httpURLConnectionJ.getResponseMessage();
            int i2 = this.d;
            if (i2 < 200 || i2 > 299) {
                Map<String, List<String>> headerFields = httpURLConnectionJ.getHeaderFields();
                if (this.d == 416) {
                    if (dataSpec.f5032c == t24.c(httpURLConnectionJ.getHeaderField("Content-Range"))) {
                        this.f5216d = true;
                        transferStarted(dataSpec);
                        long j2 = dataSpec.f5033d;
                        if (j2 != -1) {
                            return j2;
                        }
                        return 0L;
                    }
                }
                InputStream errorStream = httpURLConnectionJ.getErrorStream();
                try {
                    bArrB1 = errorStream != null ? gj9.B1(errorStream) : gj9.f16790a;
                } catch (IOException unused) {
                    bArrB1 = gj9.f16790a;
                }
                byte[] bArr = bArrB1;
                g();
                throw new HttpDataSource.InvalidResponseCodeException(this.d, responseMessage, this.d == 416 ? new DataSourceException(2008) : null, headerFields, dataSpec, bArr);
            }
            String contentType = httpURLConnectionJ.getContentType();
            Predicate<String> predicate = this.f5212b;
            if (predicate != null && !predicate.apply(contentType)) {
                g();
                throw new HttpDataSource.InvalidContentTypeException(contentType, dataSpec);
            }
            if (this.d == 200) {
                long j3 = dataSpec.f5032c;
                if (j3 != 0) {
                    j = j3;
                }
            }
            boolean zI = i(httpURLConnectionJ);
            if (zI) {
                this.f31144a = dataSpec.f5033d;
            } else {
                long j4 = dataSpec.f5033d;
                if (j4 != -1) {
                    this.f31144a = j4;
                } else {
                    long jB = t24.b(httpURLConnectionJ.getHeaderField("Content-Length"), httpURLConnectionJ.getHeaderField("Content-Range"));
                    this.f31144a = jB != -1 ? jB - j : -1L;
                }
            }
            try {
                this.f5205a = httpURLConnectionJ.getInputStream();
                if (zI) {
                    this.f5205a = new GZIPInputStream(this.f5205a);
                }
                this.f5216d = true;
                transferStarted(dataSpec);
                try {
                    p(j, dataSpec);
                    return this.f31144a;
                } catch (IOException e2) {
                    g();
                    if (e2 instanceof HttpDataSource.HttpDataSourceException) {
                        throw ((HttpDataSource.HttpDataSourceException) e2);
                    }
                    throw new HttpDataSource.HttpDataSourceException(e2, dataSpec, 2000, 1);
                }
            } catch (IOException e3) {
                g();
                throw new HttpDataSource.HttpDataSourceException(e3, dataSpec, 2000, 1);
            }
        } catch (IOException e4) {
            g();
            throw HttpDataSource.HttpDataSourceException.createForIOException(e4, dataSpec, 1);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public void clearAllRequestProperties() {
        this.f5211b.a();
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public void clearRequestProperty(String str) {
        sb0.g(str);
        this.f5211b.d(str);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws HttpDataSource.HttpDataSourceException {
        try {
            InputStream inputStream = this.f5205a;
            if (inputStream != null) {
                long j = this.f31144a;
                long j2 = -1;
                if (j != -1) {
                    j2 = j - this.f5209b;
                }
                l(this.f5207a, j2);
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    throw new HttpDataSource.HttpDataSourceException(e2, (DataSpec) gj9.k(this.f5210b), 2000, 3);
                }
            }
            this.f5205a = null;
            g();
            if (this.f5216d) {
                this.f5216d = false;
                transferEnded();
            }
        } catch (Throwable th) {
            this.f5205a = null;
            g();
            if (this.f5216d) {
                this.f5216d = false;
                transferEnded();
            }
            throw th;
        }
    }

    public final void g() {
        HttpURLConnection httpURLConnection = this.f5207a;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e2) {
                Log.e(b, "Unexpected error while disconnecting", e2);
            }
            this.f5207a = null;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public int getResponseCode() {
        int i2;
        if (this.f5207a == null || (i2 = this.d) <= 0) {
            return -1;
        }
        return i2;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Map<String, List<String>> getResponseHeaders() {
        HttpURLConnection httpURLConnection = this.f5207a;
        return httpURLConnection == null ? ImmutableMap.of() : new c(httpURLConnection.getHeaderFields());
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @Nullable
    public Uri getUri() {
        HttpURLConnection httpURLConnection = this.f5207a;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final URL h(URL url, @Nullable String str, DataSpec dataSpec) throws HttpDataSource.HttpDataSourceException {
        if (str == null) {
            throw new HttpDataSource.HttpDataSourceException("Null location redirect", dataSpec, 2001, 1);
        }
        try {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !"http".equals(protocol)) {
                throw new HttpDataSource.HttpDataSourceException("Unsupported protocol redirect: " + protocol, dataSpec, 2001, 1);
            }
            if (this.f5213b || protocol.equals(url.getProtocol())) {
                return url2;
            }
            throw new HttpDataSource.HttpDataSourceException("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + ")", dataSpec, 2001, 1);
        } catch (MalformedURLException e2) {
            throw new HttpDataSource.HttpDataSourceException(e2, dataSpec, 2001, 1);
        }
    }

    public final HttpURLConnection j(DataSpec dataSpec) throws IOException {
        URL url = new URL(dataSpec.f5026a.toString());
        int i2 = dataSpec.f31105a;
        byte[] bArr = dataSpec.f5030a;
        long j = dataSpec.f5032c;
        long j2 = dataSpec.f5033d;
        boolean zD = dataSpec.d(1);
        if (!this.f5213b && !this.f5215c) {
            return k(url, i2, bArr, j, j2, zD, true, dataSpec.f5029a);
        }
        URL urlH = url;
        int i3 = i2;
        byte[] bArr2 = bArr;
        int i4 = 0;
        while (true) {
            int i5 = i4 + 1;
            if (i4 > 20) {
                throw new HttpDataSource.HttpDataSourceException(new NoRouteToHostException("Too many redirects: " + i5), dataSpec, 2001, 1);
            }
            long j3 = j;
            long j4 = j;
            int i6 = i3;
            URL url2 = urlH;
            long j5 = j2;
            HttpURLConnection httpURLConnectionK = k(urlH, i3, bArr2, j3, j2, zD, false, dataSpec.f5029a);
            int responseCode = httpURLConnectionK.getResponseCode();
            String headerField = httpURLConnectionK.getHeaderField("Location");
            if ((i6 == 1 || i6 == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                httpURLConnectionK.disconnect();
                urlH = h(url2, headerField, dataSpec);
                i3 = i6;
            } else {
                if (i6 != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                    return httpURLConnectionK;
                }
                httpURLConnectionK.disconnect();
                if (this.f5215c && responseCode == 302) {
                    i3 = i6;
                } else {
                    bArr2 = null;
                    i3 = 1;
                }
                urlH = h(url2, headerField, dataSpec);
            }
            i4 = i5;
            j = j4;
            j2 = j5;
        }
    }

    public final HttpURLConnection k(URL url, int i2, @Nullable byte[] bArr, long j, long j2, boolean z, boolean z2, Map<String, String> map) throws IOException {
        HttpURLConnection httpURLConnectionM = m(url);
        httpURLConnectionM.setConnectTimeout(this.f5208b);
        httpURLConnectionM.setReadTimeout(this.f5214c);
        HashMap map2 = new HashMap();
        HttpDataSource.a aVar = this.f5204a;
        if (aVar != null) {
            map2.putAll(aVar.c());
        }
        map2.putAll(this.f5211b.c());
        map2.putAll(map);
        for (Map.Entry entry : map2.entrySet()) {
            httpURLConnectionM.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        String strA = t24.a(j, j2);
        if (strA != null) {
            httpURLConnectionM.setRequestProperty("Range", strA);
        }
        String str = this.f5206a;
        if (str != null) {
            httpURLConnectionM.setRequestProperty("User-Agent", str);
        }
        httpURLConnectionM.setRequestProperty("Accept-Encoding", z ? "gzip" : HlsPlaylistParser.V);
        httpURLConnectionM.setInstanceFollowRedirects(z2);
        httpURLConnectionM.setDoOutput(bArr != null);
        httpURLConnectionM.setRequestMethod(DataSpec.c(i2));
        if (bArr != null) {
            httpURLConnectionM.setFixedLengthStreamingMode(bArr.length);
            httpURLConnectionM.connect();
            OutputStream outputStream = httpURLConnectionM.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            httpURLConnectionM.connect();
        }
        return httpURLConnectionM;
    }

    @VisibleForTesting
    public HttpURLConnection m(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    public final int n(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        long j = this.f31144a;
        if (j != -1) {
            long j2 = j - this.f5209b;
            if (j2 == 0) {
                return -1;
            }
            i3 = (int) Math.min(i3, j2);
        }
        int i4 = ((InputStream) gj9.k(this.f5205a)).read(bArr, i2, i3);
        if (i4 == -1) {
            return -1;
        }
        this.f5209b += (long) i4;
        bytesTransferred(i4);
        return i4;
    }

    @Deprecated
    public void o(@Nullable Predicate<String> predicate) {
        this.f5212b = predicate;
    }

    public final void p(long j, DataSpec dataSpec) throws IOException {
        if (j == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j > 0) {
            int i2 = ((InputStream) gj9.k(this.f5205a)).read(bArr, 0, (int) Math.min(j, 4096));
            if (Thread.currentThread().isInterrupted()) {
                throw new HttpDataSource.HttpDataSourceException(new InterruptedIOException(), dataSpec, 2000, 1);
            }
            if (i2 == -1) {
                throw new HttpDataSource.HttpDataSourceException(dataSpec, 2008, 1);
            }
            j -= (long) i2;
            bytesTransferred(i2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataReader
    public int read(byte[] bArr, int i2, int i3) throws HttpDataSource.HttpDataSourceException {
        try {
            return n(bArr, i2, i3);
        } catch (IOException e2) {
            throw HttpDataSource.HttpDataSourceException.createForIOException(e2, (DataSpec) gj9.k(this.f5210b), 2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public void setRequestProperty(String str, String str2) {
        sb0.g(str);
        sb0.g(str2);
        this.f5211b.e(str, str2);
    }

    @Deprecated
    public e() {
        this(null, 8000, 8000);
    }

    @Deprecated
    public e(@Nullable String str) {
        this(str, 8000, 8000);
    }

    @Deprecated
    public e(@Nullable String str, int i2, int i3) {
        this(str, i2, i3, false, null);
    }

    @Deprecated
    public e(@Nullable String str, int i2, int i3, boolean z, @Nullable HttpDataSource.a aVar) {
        this(str, i2, i3, z, aVar, null, false);
    }

    public e(@Nullable String str, int i2, int i3, boolean z, @Nullable HttpDataSource.a aVar, @Nullable Predicate<String> predicate, boolean z2) {
        super(true);
        this.f5206a = str;
        this.f5208b = i2;
        this.f5214c = i3;
        this.f5213b = z;
        this.f5204a = aVar;
        this.f5212b = predicate;
        this.f5211b = new HttpDataSource.a();
        this.f5215c = z2;
    }
}
